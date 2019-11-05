package com.testbackend.service;

import com.testbackend.architecture.service.GenericServiceImpl;
import com.testbackend.entity.Delivery;
import com.testbackend.persistence.DeliveryRepository;
import com.testbackend.validators.DeliveryValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService extends GenericServiceImpl<Long, Delivery> {

    @Autowired
    public DeliveryService(DeliveryRepository dao, DeliveryValidator deliveryValidator) {
        super(dao, deliveryValidator);
    }
}
