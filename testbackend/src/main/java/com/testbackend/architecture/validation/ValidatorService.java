package com.testbackend.architecture.validation;

import com.testbackend.architecture.Identifier;

public interface ValidatorService<T extends Identifier<?>> {

    public default void validateInsert(T entity){}

    public default void validateUpdate(T entity){}



}