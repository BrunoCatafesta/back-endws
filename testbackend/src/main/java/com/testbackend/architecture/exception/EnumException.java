package com.testbackend.architecture.exception;

public enum EnumException implements TestBackendException {

    CANNOT_CHANGED_STATUS_ORDERED("Cannot be changed because the order is in status: %s"),
    MANUFACTURER_NOT_FOUND("Manufacturer with id: %s not found."),
    PRODUCT_NOT_FOUND("Product with id: %s not found."), 
    STATUS_ORDERED_NOT_FOUND("Status ordered not found.");

    private String erro;

    EnumException(String erro){
        this.erro = erro;
    }

    public String getErro() {
        return erro;
    }

}