package com.testbackend.controller;

import com.testbackend.architecture.controller.GenericControllerImpl;
import com.testbackend.converter.ManufacturerMapper;
import com.testbackend.dto.ManufacturerDTO;
import com.testbackend.entity.Manufacturer;
import com.testbackend.service.MunufacturerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manufacturer")
@Api(value = "Manufacturer", description = "manufacturer operations")
public class ManufacturerController extends GenericControllerImpl<Long, ManufacturerDTO, ManufacturerDTO, Manufacturer> {

    @Autowired
    public ManufacturerController(MunufacturerService manufacturerService) {
        super(ManufacturerMapper.INSTANCE, ManufacturerMapper.INSTANCE, manufacturerService);
    }
}