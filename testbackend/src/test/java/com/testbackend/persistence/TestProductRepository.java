package com.testbackend.persistence;

import com.testbackend.architecture.persistence.TestPersistenceConfiguration;
import com.testbackend.builder.ManufacturerBuilder;
import com.testbackend.builder.ProductBuilder;
import com.testbackend.business.ordered.InstallmentCalculator;
import com.testbackend.business.ordered.ManipulatorStatusOrdered;
import com.testbackend.entity.Manufacturer;
import com.testbackend.entity.Product;
import com.testbackend.service.*;
import com.testbackend.validators.*;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

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
public class TestProductRepository {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ManufacturerRepository manufacturerRepository;


	@Test()
	public void mustPersistProductWithAllFields() {
		String nameProductExpected = "Teste Product";
		Long barcodeProductExpected = 152272562567L;
		String descriptionProductorExpected = "Homo";

		String nameManufacturerExpected = "Texaco";

		Manufacturer manufacturer = new ManufacturerBuilder()
				.withName(nameManufacturerExpected)
				.builde();
		manufacturerRepository.insert(manufacturer);

		Product product = new ProductBuilder()
				.withName(nameProductExpected)
				.withBarcode(barcodeProductExpected)
				.withDescription(descriptionProductorExpected)
				.withManufacturer(manufacturer)
				.builde();

		productRepository.insert(product);

		product = productRepository.find(product.getId()).orElse(null);
		manufacturer = manufacturerRepository.find(manufacturer.getId()).orElse(null);
		
		assertThat(product.getId(), Matchers.notNullValue());
		assertThat(manufacturer.getId(), Matchers.notNullValue());
		assertThat(product.getDescription(), Matchers.equalTo(descriptionProductorExpected));
		assertThat(product.getName(), Matchers.equalTo(nameProductExpected));
		assertThat(product.getBarcode(), Matchers.equalTo(barcodeProductExpected));
		assertThat(manufacturer.getName(), Matchers.equalTo(manufacturer.getName()));
	}

}