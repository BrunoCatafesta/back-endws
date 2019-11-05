package com.testbackend.persistence;

import com.testbackend.architecture.persistence.GenericDAOImpl;
import com.testbackend.entity.Delivery;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DeliveryRepository extends GenericDAOImpl<Long, Delivery> {

    public DeliveryRepository() {
        super(Delivery.class);
    }

}