package com.testbackend.service;


import com.testbackend.architecture.persistence.TestPersistenceConfiguration;
import com.testbackend.builder.*;
import com.testbackend.business.ordered.InstallmentCalculator;
import com.testbackend.business.ordered.ManipulatorStatusOrdered;
import com.testbackend.entity.*;
import com.testbackend.enun.EnumStatusOrdered;
import com.testbackend.persistence.*;
import com.testbackend.validators.*;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Collections;

import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestPersistenceConfiguration.class })
@SpringBootTest(
		classes = {
        ProductRepository.class,
        ManufacturerRepository.class,
        DeliveryRepository.class,
        ConsumerRepository.class,
        PaymentRepository.class,
        StatusOrderedRepository.class,
        OrderedItemRepository.class,
        OrderedRepository.class,
        OrderedService.class,
        OrderedValidator.class,
        ConsumerService.class,
        ConsumerValidator.class,
        OrderedItemService.class,
        OrderedItemValidator.class,
        ProductService.class,
        ProductValidator.class,
        DeliveryService.class,
        DeliveryValidator.class,
        PaymentValidator.class,
        ManufacturerRepository.class,
        InstallmentCalculator.class,
        ManipulatorStatusOrdered.class,
        PaymentService.class})
@WebAppConfiguration
@ActiveProfiles("test")
@Transactional
public class OrderedServiceTest {

	
	@Autowired 
	private ProductRepository productRepository;
	@Autowired 
	private OrderedService orderedService;
	@Autowired
	private ManufacturerRepository manufacturerRepository;
	@Autowired
	private StatusOrderedRepository statusOrderedRepository;
	@Autowired
	private OrderedRepository orderedRepository;
	private Product product = null; 
    @Before
    public void pesistData(){
     Manufacturer manufacturer = new ManufacturerBuilder()
    		 .withName("Apple")
    		 .builde();  
     manufacturer = manufacturerRepository.insert(manufacturer);	
      Product product =  new ProductBuilder()
    		  .withBarcode(32264563245L)
    		  .withDescription("Test")
    		  .withName("Test Product")
    		  .withUnitPrice(BigDecimal.ONE)
    		  .withManufacturer(manufacturer)
    		  .builde();
      this.product = productRepository.insert(product); 
      EnumStatusOrdered.getAllStatus().forEach(e -> statusOrderedRepository.mergeOrPersist(e));
      
    }

    @Test
    public void mustPersistOrderedItemForProductOfContext(){
    	Consumer consumer = new ConsumerBuilder()
    		.withEmail("alex.bruno4@gmail.com")
    		.withPhone("+5545999999999999").builde();
    	
    	Payment payment = new Payment();
    	payment.setMode("Card Credit");
    	payment.setInstallments(2);
    	payment.setInstallmentValue(BigDecimal.TEN);
    	
    	Delivery delivery = new DeliveryBuilder()
    		.withMode("sedex 10").builde();
    	
    	OrderedItem item = new OrderedItem();
    	item.setUnits(BigDecimal.ONE);
    	item.setProduct(product);
    	
    	Ordered ordered = new OrderedBuilder()
    		.withConsumer(consumer)
    		.withDelivery(delivery)
    		.withPayment(payment)
    		.withStatus(EnumStatusOrdered.PENDING.getStatusOrdered())
    		.withProducts(Collections.singletonList(item))
    		.builde();
    	orderedService.insert(ordered);
    	Ordered orderedLocated = orderedRepository.find(ordered.getId()).get();
    	
    	assertThat(orderedLocated.getProducts(), Matchers.hasSize(1)); 
    	assertThat(product.getId(), Matchers.equalTo(this.product.getId()));
    }

}