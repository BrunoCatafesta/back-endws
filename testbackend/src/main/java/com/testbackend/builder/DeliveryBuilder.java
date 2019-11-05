package com.testbackend.builder;

import com.testbackend.architecture.Builder;
import com.testbackend.entity.Delivery;

public class DeliveryBuilder implements Builder<Delivery>{
	
	private Delivery delivery = new Delivery();


	public DeliveryBuilder withMode(String mode) {
		delivery.setMode(mode);
		return this;
	}


	public DeliveryBuilder withId(Long id) {
		delivery.setId(id);
		return this;
	}

	@Override
	public Delivery builde() {
		return delivery;
	}

}
