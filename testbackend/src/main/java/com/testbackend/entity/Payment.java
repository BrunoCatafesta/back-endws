package com.testbackend.entity;

import com.testbackend.architecture.Identifier;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Entity
public class Payment implements Identifier<Long> {
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_payment")
    @SequenceGenerator(name = "sq_payment", allocationSize = 1, sequenceName="sq_payment")
    private Long id;

    @NotNull
    @NotEmpty
    private String mode;

    @Positive
    @NotNull
    private Integer installments;

//    @Positive
//    @NotNull
    private BigDecimal installmentValue;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public BigDecimal getInstallmentValue() {
        return installmentValue;
    }

    public void setInstallmentValue(BigDecimal installmentValue) {
        this.installmentValue = installmentValue;
    }

    public Integer getInstallments() {
        return installments;
    }

    public void setInstallments(Integer installments) {
        this.installments = installments;
    }

}