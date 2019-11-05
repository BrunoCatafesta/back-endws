package com.testbackend.dto;

import com.testbackend.architecture.converter.Dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class DeliveryDTO implements Dto {

    private Long id;

    @NotNull
    @NotBlank
    private String mode;

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
}