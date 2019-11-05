package com.testbackend.business.ordered;

import com.testbackend.entity.Ordered;
import com.testbackend.entity.OrderedItem;
import com.testbackend.entity.Payment;
import com.testbackend.entity.Product;
import com.testbackend.persistence.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class InstallmentCalculator {

    private ProductRepository productRepository;

	@Autowired
	public InstallmentCalculator(ProductRepository productRepository){
	    this.productRepository = productRepository;
    }

	public BigDecimal calculateInstallment(Ordered ordered) {
		Payment payment = ordered.getPayment();
		BigDecimal installments = BigDecimal.valueOf(payment.getInstallments());
		BigDecimal amount = addValueProduct(ordered);
		return amount.divide(installments, 5, BigDecimal.ROUND_HALF_UP);
	}
	
	private BigDecimal addValueProduct(Ordered ordered) {
		return ordered.getProducts()
				.stream()
				.map(this::getProductValue)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	private BigDecimal getProductValue(OrderedItem item) {
		BigDecimal units = item.getUnits();
		Product prod = productRepository.find(item.getProduct()).get();
		return prod.getUnitPrice().multiply(units).setScale(5, BigDecimal.ROUND_HALF_UP);
	}

}
