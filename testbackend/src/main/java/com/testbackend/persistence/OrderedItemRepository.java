package com.testbackend.persistence;


import com.testbackend.architecture.persistence.GenericDAOImpl;
import com.testbackend.entity.OrderedItem;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class OrderedItemRepository extends GenericDAOImpl <Long, OrderedItem>{

    public OrderedItemRepository() {
        super(OrderedItem.class);
    }
}