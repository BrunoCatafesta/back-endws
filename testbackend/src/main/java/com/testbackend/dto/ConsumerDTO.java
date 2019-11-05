package com.testbackend.dto;

import com.testbackend.architecture.converter.Dto;
import com.testbackend.architecture.validation.Phone;
import io.swagger.annotations.ApiModel;

import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel(description = "All details about the Consumer. ")
public class ConsumerDTO implements Dto {

    @Id
    private Long id;
    
    @NotNull
    @NotBlank
    private String name;

    @Phone
    private String phone;

    @Email(message = "Email should be valid")
    private String email;


    public Long getId() {
        return id;
    }

    public String getName() {
		return name;
	}
    
    public void setName(String name) {
		this.name = name;
	}
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}