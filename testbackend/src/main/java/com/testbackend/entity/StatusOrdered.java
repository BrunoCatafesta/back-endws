package com.testbackend.entity;

import com.testbackend.architecture.Identifier;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "status_ordered")
public class StatusOrdered implements Identifier<Long> {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@NotEmpty
	@NotNull
	private String status;

	@NotEmpty
	@NotNull
	private String description;

	public StatusOrdered() {

	}

	public StatusOrdered(Long id, String status, String description) {
		this.status = status;
		this.id = id;
		this.description = description;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}