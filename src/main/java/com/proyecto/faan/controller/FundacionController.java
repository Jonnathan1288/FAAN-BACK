package com.proyecto.faan.controller;

import com.proyecto.faan.controller.Generic.GenericControllerImpl;
import com.proyecto.faan.model.Fundacion;
import com.proyecto.faan.service.FundacionService;
import com.proyecto.faan.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/fundacion")
public class FundacionController extends GenericControllerImpl<Fundacion, Integer> {

    @Autowired
    private FundacionService fundacionService;

    @Override
    protected GenericService<Fundacion, Integer> getService() {
        return fundacionService;
    }
}
