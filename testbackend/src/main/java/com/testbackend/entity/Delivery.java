package com.testbackend.entity;

import com.testbackend.architecture.Identifier;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Delivery implements Identifier<Long> {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_delivery")
	@SequenceGenerator(name = "sq_delivery", allocationSize = 1, sequenceName = "sq_delivery")
	private Long id;

	@NotNull
	@NotBlank
	private String mode;

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public Long getId() {
		return id;
	}
}
