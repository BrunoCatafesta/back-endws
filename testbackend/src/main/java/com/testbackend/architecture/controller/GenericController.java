package com.testbackend.architecture.controller;

import com.testbackend.architecture.Identifier;
import com.testbackend.architecture.converter.Dto;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface GenericController<I extends Number, DTO extends Dto, DTOQUERY extends Dto, E extends Identifier<I>> {

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<DTO> create(DTO dto);

	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<DTO> update(I id, DTO dto);

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Page<DTOQUERY>> findAll(   
			@RequestParam(defaultValue = "0") Integer pageNo, 
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy);

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<DTOQUERY> findOne(I id);

	@DeleteMapping("/{id}")
	ResponseEntity<DTO> delete(I id);

}
