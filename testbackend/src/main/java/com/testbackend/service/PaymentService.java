package com.testbackend.service;

import com.testbackend.architecture.service.GenericServiceImpl;
import com.testbackend.entity.Payment;
import com.testbackend.persistence.PaymentRepository;
import com.testbackend.validators.PaymentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService extends GenericServiceImpl<Long, Payment> {

    @Autowired
    public PaymentService(PaymentRepository paymentRepository, PaymentValidator paymentValidator) {
        super(paymentRepository, paymentValidator);
    }
}