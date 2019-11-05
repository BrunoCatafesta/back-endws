package com.testbackend.builder;

import com.testbackend.architecture.Builder;
import com.testbackend.entity.Payment;

import java.math.BigDecimal;

public class PaymentBuilder implements Builder<Payment> {
	
	private Payment payment = new Payment();
	
	public PaymentBuilder withId(Long id) {
		payment.setId(id);
		return this;
	}

	public PaymentBuilder withMode(String mode) {
		payment.setMode(mode);
		return this;
	}
	
	public PaymentBuilder setInstallmentValue(BigDecimal installmentValue) {
		payment.setInstallmentValue(installmentValue);
		return this;
	}

	public PaymentBuilder withInstallments(Integer installments) {
		payment.setInstallments(installments);
		return this;
	}

	@Override
	public Payment builde() {
		return payment;
	}

}
