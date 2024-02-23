package com.proyecto.faan.controller.primarys;

import com.proyecto.faan.controller.Generic.GenericControllerImpl;
import com.proyecto.faan.model.primarys.Fundacion;
import com.proyecto.faan.service.primarys.FundacionService;
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
