package com.testbackend.service;

import com.testbackend.architecture.service.GenericServiceImpl;
import com.testbackend.entity.Manufacturer;
import com.testbackend.persistence.ManufacturerRepository;
import com.testbackend.validators.ManufacturerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MunufacturerService extends GenericServiceImpl<Long, Manufacturer> {

    @Autowired
    public MunufacturerService(ManufacturerRepository dao, ManufacturerValidator manufacturerValidator) {
        super(dao, manufacturerValidator);
    }
}