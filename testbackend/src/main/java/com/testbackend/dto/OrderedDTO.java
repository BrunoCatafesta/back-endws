package com.testbackend.dto;

import com.testbackend.architecture.converter.Dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;


public class OrderedDTO implements Dto {

    private Long id;

    @NotNull
    private ConsumerDTO consumer;

    @NotNull
    private DeliveryDTO delivery;

    @NotNull
    private PaymentDTO payment;

    private String status;

    @NotNull
    @NotEmpty
    private List<OrderedItemDTO> products;

    public String getStatus() {
		return status;
	}
    
    public void setStatus(String status) {
		this.status = status;
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ConsumerDTO getConsumer() {
        return consumer;
    }

    public void setConsumer(ConsumerDTO consumer) {
        this.consumer = consumer;
    }

    public DeliveryDTO getDelivery() {
        return delivery;
    }

    public void setDelivery(DeliveryDTO delivery) {
        this.delivery = delivery;
    }

    public PaymentDTO getPayment() {
        return payment;
    }

    public void setPayment(PaymentDTO payment) {
        this.payment = payment;
    }

    public List<OrderedItemDTO> getProducts() {
        return products;
    }

    public void setProducts(List<OrderedItemDTO> products) {
        this.products = products;
    }
}