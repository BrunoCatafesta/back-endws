package com.testbackend.builder;

import com.testbackend.architecture.Builder;
import com.testbackend.entity.*;

import java.util.List;

public class OrderedBuilder implements Builder<Ordered> {

	private Ordered ordered = new Ordered();

	public OrderedBuilder withConsumer(Consumer consumer) {
		ordered.setConsumer(consumer);
		return this;
	}

	public OrderedBuilder withPayment(Payment payment) {
		ordered.setPayment(payment);
		return this;
	}

	public OrderedBuilder withStatus(StatusOrdered status) {
		ordered.setStatus(status);
		return this;
	}

	public OrderedBuilder withDelivery(Delivery delivery) {
		ordered.setDelivery(delivery);
		return this;
	}

	public OrderedBuilder withProducts(List<OrderedItem> products) {
		ordered.setProducts(products);
		return this;
	}

	public OrderedBuilder withId(Long id) {
		ordered.setId(id);
		return this;
	}

	@Override
	public Ordered builde() {
		return ordered;
	}

}
