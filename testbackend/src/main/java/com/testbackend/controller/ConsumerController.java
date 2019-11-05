package com.testbackend.controller;

import com.testbackend.architecture.controller.GenericControllerImpl;
import com.testbackend.converter.ConsumerMapper;
import com.testbackend.dto.ConsumerDTO;
import com.testbackend.entity.Consumer;
import com.testbackend.service.ConsumerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
@Api(value = "Consumer", description = "consumer operations")
public class ConsumerController extends GenericControllerImpl<Long, ConsumerDTO, ConsumerDTO, Consumer> {

    @Autowired
    public ConsumerController(ConsumerService consumerService) {
        super(ConsumerMapper.INSTANCE, ConsumerMapper.INSTANCE, consumerService);
    }
}