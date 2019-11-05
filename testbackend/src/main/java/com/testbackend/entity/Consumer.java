package com.testbackend.entity;

import com.testbackend.architecture.Identifier;
import com.testbackend.architecture.validation.Phone;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
public class Consumer implements Identifier<Long> {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_consumer")
	@SequenceGenerator(name = "sq_consumer", allocationSize = 1, sequenceName = "sq_consumer")
	private Long id;

	private String name;

	@Phone
	private String phone;

	@Email(message = "Email should be valid")
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
