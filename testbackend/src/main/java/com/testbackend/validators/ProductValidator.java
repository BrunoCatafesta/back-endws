package com.testbackend.validators;

import com.testbackend.architecture.exception.EnumException;
import com.testbackend.architecture.exception.TestBackEndRuntime;
import com.testbackend.architecture.validation.ValidatorService;
import com.testbackend.entity.Product;
import com.testbackend.persistence.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductValidator implements ValidatorService<Product> {
	
	@Autowired
	private ManufacturerRepository manufacturerRepository;
	
	
	@Override
	public void validateInsert(Product entity) {
		validateExistenceManufacturer(entity);
	}
	
	@Override
	public void validateUpdate(Product entity) {
		validateExistenceManufacturer(entity);
	}
	
	public void validateExistenceManufacturer(Product entity) {
		Long idManufacturer = entity.getManufacturer().getId();
		manufacturerRepository.find(idManufacturer).orElseThrow(() -> new TestBackEndRuntime(EnumException.MANUFACTURER_NOT_FOUND, idManufacturer));
	}

}
