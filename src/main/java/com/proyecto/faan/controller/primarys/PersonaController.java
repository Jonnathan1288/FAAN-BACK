package com.proyecto.faan.controller.primarys;

import com.proyecto.faan.controller.Generic.GenericControllerImpl;
import com.proyecto.faan.model.primarys.Persona;
import com.proyecto.faan.payload.PersonFind;
import com.proyecto.faan.service.primarys.PersonaService;
import com.proyecto.faan.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/persona")
public class PersonaController extends GenericControllerImpl<Persona, Integer> {
    private PersonaService personaService;
    @Autowired
    public PersonaController (PersonaService personaService){
        this.personaService = personaService;
    }

    @Override
    protected GenericService<Persona, Integer> getService() {
        return personaService;
    }

    //    ====================================================================================
    @GetMapping("/findByCedulaOrNombre/{filter}")
    public ResponseEntity<?> findByCedulaOrNombre(@PathVariable("filter") String filter, @PageableDefault(page = 0, size = 3, direction = Sort.Direction.ASC) Pageable pageable) {
        try {
            Page<Persona> personaFind = personaService.findByCedulaOrApellido(filter, pageable);

            if (personaFind != null) {
                return new ResponseEntity<>(personaFind, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //    ====================================================================================

    @GetMapping("/cedulaRegistra/{cedulaPersona}")
    public Boolean cedulaRegistra(@PathVariable("cedulaPersona") String cedulaPersona) {
        try {
            return personaService.existsByIdentificacion(cedulaPersona);
        } catch (Exception e) {
            return false;
        }

    }
    @GetMapping("/correoRegistrado/{correoPersona}")
    public Boolean correoRegistrado(@PathVariable("correoPersona") String correoPersona) {
        try {
            return personaService.existsByCorreo(correoPersona);
        } catch (Exception e) {
            return false;
        }

    }

    @GetMapping("/findByIdentificacion/{ci}")
    public ResponseEntity<PersonFind> findByCedulaOrNombre(@PathVariable("ci") String filter) {
        try {
            PersonFind personaFind = personaService.findPersonabyIdentificacion(filter);

            if (personaFind != null) {
                return new ResponseEntity<>(personaFind, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Not admin
    @GetMapping("/pageable/dadmin")
    public ResponseEntity<?> findByAllPerson(Pageable pageable) {
        try {
            return new ResponseEntity<>(personaService.findByAllPerson(pageable), HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
