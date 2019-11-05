package com.testbackend.dto;

import com.testbackend.architecture.converter.Dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class ProductDTO implements Dto {

    private Long id;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String description;

    @NotNull
    private Long barcode;

    @NotNull
    @Positive
    private BigDecimal unitPrice;

    private ManufacturerDTO manufacturer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getBarcode() {
        return barcode;
    }

    public void setBarcode(Long barcode) {
        this.barcode = barcode;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public ManufacturerDTO getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(ManufacturerDTO manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
}