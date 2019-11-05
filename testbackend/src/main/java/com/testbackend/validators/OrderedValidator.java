package com.testbackend.validators;

import com.testbackend.architecture.exception.EnumException;
import com.testbackend.architecture.exception.TestBackEndRuntime;
import com.testbackend.architecture.validation.ValidatorService;
import com.testbackend.entity.Ordered;
import com.testbackend.entity.Product;
import com.testbackend.persistence.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderedValidator implements ValidatorService<Ordered> {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void validateInsert(Ordered entity) {
		validateExistenceProduct(entity);
	}

	@Override
	public void validateUpdate(Ordered entity) {
		validateExistenceProduct(entity);
	}

	private void validateExistenceProduct(Ordered entity) {
		entity.getProducts().stream().forEach(itemProd -> {
			Long idProduct = itemProd.getProduct().getId();
			Optional<Product> product = productRepository.find(idProduct);
			product.orElseThrow(() -> new TestBackEndRuntime(EnumException.PRODUCT_NOT_FOUND, idProduct));
		});
	}
}