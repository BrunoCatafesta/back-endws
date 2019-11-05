package com.testbackend.service;

import com.testbackend.architecture.service.GenericServiceImpl;
import com.testbackend.architecture.validation.ValidatorService;
import com.testbackend.entity.OrderedItem;
import com.testbackend.persistence.OrderedItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderedItemService extends GenericServiceImpl<Long, OrderedItem> {


    @Autowired
    public OrderedItemService(OrderedItemRepository dao, ValidatorService<OrderedItem> validatorService) {
        super(dao, validatorService);
    }
}