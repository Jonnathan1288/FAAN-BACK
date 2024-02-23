package com.proyecto.faan.uploadServer.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.proyecto.faan.uploadServer.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static com.proyecto.faan.uploadServer.constants.ConstantsNames.*;


@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class UploadController {

    private final FileUploadService fileUploadService;

    @Autowired
    public UploadController(FileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }
    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("folder") String folder) {
        try {
            String folderPath = FOLDER_MAPPING.get(folder);

            if (folderPath == null) {
                return new ResponseEntity<>("Path not found", HttpStatus.BAD_REQUEST);
            }

            Map<String, String> response = new HashMap<>();
            String fileName = fileUploadService.saveFile(file, folderPath);
            response.put("key", fileName);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("Error uploading file: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/upload/{fileName:.+}/{folder}")
    public ResponseEntity<Resource> getUploadedFile(@PathVariable("fileName") String fileName, @PathVariable("folder") String folder) {
        try {
            Resource resource = fileUploadService.getUploadedFile(fileName, folder);
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);

        } catch (FileNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/uploadUri/{fileName:.+}/{folder}")
    public ResponseEntity<Resource> getFile(@PathVariable String fileName, @PathVariable("folder") String folder) {
        try {
            Resource resource = fileUploadService.getUploadedFile(fileName,  folder);
            String contentType = Files.probeContentType(Paths.get(resource.getURI()));

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType(contentType));

            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
        } catch (FileNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/upload/delete/{fileName}")
    public ResponseEntity<String> deleteFile(@PathVariable String fileName) {
        try {
            fileUploadService.deleteFile(fileName);
            return new ResponseEntity<>("Successful", HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("Err: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

