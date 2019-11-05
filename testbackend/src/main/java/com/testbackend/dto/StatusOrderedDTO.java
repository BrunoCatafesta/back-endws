package com.testbackend.dto;

import com.testbackend.architecture.converter.Dto;

public class StatusOrderedDTO implements Dto {

	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
