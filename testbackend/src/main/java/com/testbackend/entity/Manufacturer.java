package com.testbackend.entity;

import com.testbackend.architecture.Identifier;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Manufacturer implements Identifier<Long> {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_manufacturer")
    @SequenceGenerator(name = "sq_manufacturer", allocationSize = 1, sequenceName="sq_manufacturer")
    private Long id;

    @NotNull
    @NotBlank
    private String name;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}