package com.testbackend.builder;

import com.testbackend.architecture.Builder;
import com.testbackend.entity.Manufacturer;

public class ManufacturerBuilder implements Builder<Manufacturer> {

	private Manufacturer manufacturer = new Manufacturer();

	public ManufacturerBuilder withId(Long id) {
		manufacturer.setId(id);
		return this;
	}

	public ManufacturerBuilder withName(String name) {
		manufacturer.setName(name);
		return this;
	}

	@Override
	public Manufacturer builde() {
		return manufacturer;
	}

}
