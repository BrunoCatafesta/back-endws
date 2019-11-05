package com.testbackend.validators;

import com.testbackend.architecture.validation.ValidatorService;
import com.testbackend.entity.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentValidator implements ValidatorService<Payment> {
}