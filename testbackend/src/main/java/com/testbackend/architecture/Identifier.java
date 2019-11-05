package com.testbackend.architecture;

import java.io.Serializable;

public interface Identifier<T> extends Serializable {

    T getId();
    
    void setId(T id);

}