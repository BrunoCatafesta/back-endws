package com.testbackend.service;

import com.testbackend.architecture.exception.TestBackEndRuntime;
import com.testbackend.architecture.service.GenericServiceImpl;
import com.testbackend.business.ordered.InstallmentCalculator;
import com.testbackend.business.ordered.ManipulatorStatusOrdered;
import com.testbackend.entity.Ordered;
import com.testbackend.entity.OrderedItem;
import com.testbackend.enun.EnumStatusOrdered;
import com.testbackend.persistence.OrderedRepository;
import com.testbackend.validators.OrderedValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderedService extends GenericServiceImpl<Long, Ordered> {

    @Autowired
    private ConsumerService consumerService;
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private DeliveryService deliveryService;
    @Autowired
    private OrderedItemService orderedItemService;
    @Autowired
    private InstallmentCalculator installmentCalculator;
    @Autowired
    private ManipulatorStatusOrdered manipulatorStatusOrdered;

    @Autowired
    public OrderedService(OrderedRepository orderedRepository, OrderedValidator orderedValidator) {
        super(orderedRepository, orderedValidator);
    }

    @Override
    public void insertDependents(Ordered entity) {
        entity.setPayment(paymentService.insert(entity.getPayment()));
        entity.setConsumer(consumerService.insert(entity.getConsumer()));
        entity.setDelivery(deliveryService.insert(entity.getDelivery()));
    }
    
    @Override
    public void insertDetails(Ordered entity) {
    	insertOrderedItem(entity);
    }
    
    private List<OrderedItem> insertOrderedItem(Ordered entity) {
        return entity.getProducts().stream().map(item -> {
        	item.setOrdered(entity);
        	return orderedItemService.insert(item);	
        }).collect(Collectors.toList());
    }

    @Override
    public void prepareForInsert(Ordered entity) {
    	BigDecimal installmentValue = installmentCalculator.calculateInstallment(entity);
        entity.setStatus(EnumStatusOrdered.PENDING.getStatusOrdered());
        entity.getPayment().setInstallmentValue(installmentValue);
    }

    public void cancelOrdered(Long idOrdered) {
    	manipulatorStatusOrdered.applyStatus(idOrdered, EnumStatusOrdered.CANCELED);
    }
    
    public void confirmOrdered(Long idOrdered) {
    	manipulatorStatusOrdered.applyStatus(idOrdered, EnumStatusOrdered.CONFIRMED);
    }
    
    @Override
    public Ordered update(Ordered entity) {
    	throw new TestBackEndRuntime(" Operation not allowed. ");
    }

}