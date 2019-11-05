package com.testbackend.dto;

import com.testbackend.architecture.converter.Dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class OrderedItemDTO implements Dto {

    @NotNull
    private Long id;

    @Positive
    @NotNull
    private BigDecimal units;

    public BigDecimal getUnits() {
        return units;
    }

    public void setUnits(BigDecimal units) {
        this.units = units;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}