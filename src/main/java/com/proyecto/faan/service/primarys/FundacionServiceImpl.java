package com.proyecto.faan.service.primarys;

import com.proyecto.faan.model.primarys.Fundacion;
import com.proyecto.faan.repository.primarys.FundacionRepository;
import com.proyecto.faan.repository.generic.GenericRepository;
import com.proyecto.faan.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FundacionServiceImpl extends GenericServiceImpl<Fundacion, Integer> implements FundacionService{
    @Autowired
    private FundacionRepository fundacionRepository;

    @Override
    public GenericRepository<Fundacion, Integer> getDao() {
        return fundacionRepository;
    }
}