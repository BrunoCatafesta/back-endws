package com.testbackend.entity;

import com.testbackend.architecture.Identifier;
import com.testbackend.enun.EnumStatusOrdered;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Entity
public class Ordered implements Identifier<Long> {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_ordered")
	@SequenceGenerator(name = "sq_ordered", allocationSize = 1, sequenceName = "sq_ordered")
	private Long id;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "status_ordered")
	private StatusOrdered status;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "consumer")
	private Consumer consumer;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "payment")
	private Payment payment;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "delivery")
	private Delivery delivery;

	@NotNull
	@UniqueElements
	@OneToMany(mappedBy = "ordered", fetch = FetchType.LAZY)
	private List<OrderedItem> products;

	public Consumer getConsumer() {
		return consumer;
	}

	public Payment getPayment() {
		return payment;
	}

	public StatusOrdered getStatus() {
		return status;
	}

	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public void setStatus(StatusOrdered status) {
		this.status = status;
	}

	public List<OrderedItem> getProducts() {
		return products;
	}

	public Delivery getDelivery() {
		return delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

	public void setProducts(List<OrderedItem> products) {
		this.products = products;
	}

	public boolean isPending() {
		return Objects.nonNull(getStatus()) && isStatus(EnumStatusOrdered.PENDING);
	}

	public boolean isCanceled() {
		return Objects.nonNull(getStatus()) && isStatus(EnumStatusOrdered.CANCELED);
	}

	public boolean isConfirmed() {
		return Objects.nonNull(getStatus()) && isStatus(EnumStatusOrdered.CONFIRMED);
	}

	private boolean isStatus(EnumStatusOrdered enumStatusOrdered) {
		return enumStatusOrdered.getStatusOrdered().getId().equals(getStatus().getId());
	}

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
