package com.testbackend.business.ordered;

import com.testbackend.builder.OrderedBuilder;
import com.testbackend.builder.OrderedItemBuilder;
import com.testbackend.builder.PaymentBuilder;
import com.testbackend.builder.ProductBuilder;
import com.testbackend.entity.Ordered;
import com.testbackend.entity.OrderedItem;
import com.testbackend.entity.Payment;
import com.testbackend.entity.Product;
import com.testbackend.persistence.ProductRepository;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class InstallmentCalculatorTest {

	private ProductRepository productRepository = Mockito.mock(ProductRepository.class);
	private InstallmentCalculator installmentCalculator = new InstallmentCalculator(productRepository);

	@Test
	public void mustReturnInstallmentValueTenForOrderedWithProductAndOneInstallment() {

		BigDecimal installmentValueExpected = BigDecimal.TEN.setScale(5);

		Product product1 = new ProductBuilder().withBarcode(363462346457L).withDescription("Test product")
				.withName("Test").withUnitPrice(installmentValueExpected).builde();
		Mockito.when(productRepository.find(Mockito.any(Product.class))).thenReturn(Optional.ofNullable(product1));

		OrderedItem orderedItem = new OrderedItemBuilder().withProduct(product1).withUnits(BigDecimal.ONE).builde();

		Payment payment = new PaymentBuilder().withInstallments(1).builde();

		Ordered ordered = new OrderedBuilder().withProducts(Collections.singletonList(orderedItem)).withPayment(payment)
				.builde();

		BigDecimal valueCalculated = installmentCalculator.calculateInstallment(ordered);

		Assert.assertThat(valueCalculated, Matchers.equalTo(installmentValueExpected));
	}

	@Test
	public void mustReturnInstallmentValueFiveForOrderedWithProductAndOneInstallment() {

		BigDecimal installmentValueExpected = new BigDecimal(5).setScale(5);

		Product product1 = new ProductBuilder().withBarcode(363462346457L).withDescription("Test product")
				.withName("Test").withUnitPrice(BigDecimal.TEN).builde();
		Mockito.when(productRepository.find(Mockito.any(Product.class))).thenReturn(Optional.ofNullable(product1));

		OrderedItem orderedItem = new OrderedItemBuilder().withProduct(product1).withUnits(BigDecimal.ONE).builde();

		Payment payment = new PaymentBuilder().withInstallments(2).builde();

		Ordered ordered = new OrderedBuilder().withProducts(Collections.singletonList(orderedItem)).withPayment(payment)
				.builde();

		BigDecimal valueCalculated = installmentCalculator.calculateInstallment(ordered);

		Assert.assertThat(valueCalculated, Matchers.equalTo(installmentValueExpected));
	}

}