package com.testbackend.service;

import com.testbackend.architecture.service.GenericServiceImpl;
import com.testbackend.entity.Product;
import com.testbackend.persistence.ProductRepository;
import com.testbackend.validators.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends GenericServiceImpl<Long, Product> {

	@Autowired
	public ProductService(ProductRepository dao, ProductValidator productValidator) {
		super(dao, productValidator);
	}

}
