package com.testbackend.builder;

import com.testbackend.architecture.Builder;
import com.testbackend.entity.Ordered;
import com.testbackend.entity.OrderedItem;
import com.testbackend.entity.Product;

import java.math.BigDecimal;

public class OrderedItemBuilder implements Builder<OrderedItem> {

	private OrderedItem orderedItem = new OrderedItem();
	
	public OrderedItemBuilder withOrdered(Ordered ordered) {
		orderedItem.setOrdered(ordered);
		return this;
	}

	public OrderedItemBuilder withUnits(BigDecimal units) {
		orderedItem.setUnits(units);
		return this;
	}

	public OrderedItemBuilder withProduct(Product product) {
		orderedItem.setProduct(product);
		return this;
	}

	public OrderedItemBuilder withId(Long id) {
		orderedItem.setId(id);
		return this;
	}

	@Override
	public OrderedItem builde() {
		return orderedItem;
	}

}
