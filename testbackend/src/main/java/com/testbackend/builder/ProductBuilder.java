package com.testbackend.builder;

import com.testbackend.architecture.Builder;
import com.testbackend.entity.Manufacturer;
import com.testbackend.entity.Ordered;
import com.testbackend.entity.Product;

import java.math.BigDecimal;

public class ProductBuilder implements Builder<Product> {

	private Product product = new Product();

	public ProductBuilder withName(String name) {
		product.setName(name);
		return this;
	}

	public ProductBuilder withBarcode(Long barcode) {
		product.setBarcode(barcode);
		return this;
	}

	public ProductBuilder withDescription(String description) {
		product.setDescription(description);
		return this;
	}

	public ProductBuilder withUnitPrice(BigDecimal unitPrice) {
		product.setUnitPrice(unitPrice);
		return this;
	}

	public ProductBuilder withManufacturer(Manufacturer manufacturer) {
		product.setManufacturer(manufacturer);
		return this;
	}

	public ProductBuilder withOrdered(Ordered ordered) {
		// product.setOrdered(ordered);
		return this;
	}

	public ProductBuilder withId(Long id) {
		product.setId(id);
		return this;
	}

	@Override
	public Product builde() {
		return product;
	}

}
