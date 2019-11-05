package com.testbackend.dto;

import com.testbackend.architecture.converter.Dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class PaymentDTO implements Dto {

    
    private Long id;

    @Positive
    @NotNull
    @Size(max = 5)
    private Integer installments;

    @NotNull
    @NotEmpty
    @Size(max = 150)
    private String mode;

    @Positive
    @NotNull
    private BigDecimal installmentValue;

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getInstallments() {
        return installments;
    }

    public void setInstallments(Integer installments) {
        this.installments = installments;
    }

    public BigDecimal getInstallmentValue() {
        return installmentValue;
    }

    public void setInstallmentValue(BigDecimal installmentValue) {
        this.installmentValue = installmentValue;
    }
}