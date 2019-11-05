package com.testbackend.service;

import com.testbackend.architecture.service.GenericServiceImpl;
import com.testbackend.entity.Consumer;
import com.testbackend.persistence.ConsumerRepository;
import com.testbackend.validators.ConsumerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService extends GenericServiceImpl<Long, Consumer> {

    @Autowired
    public ConsumerService(ConsumerRepository dao, ConsumerValidator consumerValidator) {
        super(dao, consumerValidator);
    }
}