package com.proyecto.faan.upload.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.*;
import com.amazonaws.util.IOUtils;


import com.proyecto.faan.upload.model.Asset;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.UUID;

@Service
public class S3Service {
    public final static String BUCKET="bucketgtmt";

    @Autowired
    private AmazonS3 amazonS3;

    public String putObject(MultipartFile file) {
        String extension = StringUtils.getFilenameExtension(file.getOriginalFilename());
        String key = String.format("%s.%s", UUID.randomUUID(),extension);

        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType(file.getContentType());

        try {
            PutObjectRequest putObjectRequest = new PutObjectRequest(BUCKET, key , file.getInputStream(), objectMetadata);
            amazonS3.putObject(putObjectRequest);

            return key;
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }


    public Asset getObject(String key){
        S3Object s3Object = amazonS3.getObject(BUCKET, key);
        ObjectMetadata metadata = s3Object.getObjectMetadata();

        try {
            S3ObjectInputStream inputStream = s3Object.getObjectContent();
            byte[] bytes = IOUtils.toByteArray(inputStream);
            return new Asset(bytes, metadata.getContentType());
        }catch (IOException ex){
            throw new RuntimeException(ex);
        }
    }

    public void deleteObject(String key){
        amazonS3.deleteObject(BUCKET, key);
    }

    public String getObjectUrl(String key){
        return String.format("https://%s.s3.amazonaws.com/%s", BUCKET, key);
    }
}
