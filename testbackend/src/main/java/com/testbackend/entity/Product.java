package com.testbackend.entity;

import com.testbackend.architecture.Identifier;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Entity
public class Product implements Identifier<Long> {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_product")
	@SequenceGenerator(name = "sq_product", allocationSize = 1, sequenceName = "sq_product")
	private Long id;

	@NotNull
	private String name;

	@NotBlank
	private String description;

	@NotNull
	private Long barcode;

	@Positive
	@Column(name = "unit_price")
	private BigDecimal unitPrice;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "manufacturer")
	private Manufacturer manufacturer;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setBarcode(Long barcode) {
		this.barcode = barcode;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getBarcode() {
		return barcode;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}