package com.testbackend.builder;

import com.testbackend.architecture.Builder;
import com.testbackend.entity.Consumer;

public class ConsumerBuilder implements Builder<Consumer> {
	
	private Consumer consumer = new Consumer();
	
	public ConsumerBuilder withEmail(String email) {
		consumer.setEmail(email);
		return this;
	}


	public ConsumerBuilder withPhone(String phone) {
		consumer.setPhone(phone);
		return this;
	}

	public ConsumerBuilder withId(Long id) {
		consumer.setId(id);
		return this;
	}

	@Override
	public Consumer builde() {
		return consumer;
	}

}
