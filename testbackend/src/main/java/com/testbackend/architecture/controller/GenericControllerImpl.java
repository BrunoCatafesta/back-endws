package com.testbackend.architecture.controller;

import com.testbackend.architecture.Identifier;
import com.testbackend.architecture.converter.Dto;
import com.testbackend.architecture.converter.Mapper;
import com.testbackend.architecture.service.GenericService;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public class GenericControllerImpl<I extends Number, DTO extends Dto, DTOQUERY extends Dto, E extends Identifier<I>> implements GenericController<I, DTO, DTOQUERY, E> {

	private Mapper<DTO, E> mapper;

	private Mapper<DTOQUERY, E> mapperQuery;

	private GenericService<I, E> genericService;

	public GenericControllerImpl(Mapper<DTO, E> mapper, Mapper<DTOQUERY, E> mapperQuery, GenericService<I, E> genericService) {
		this.mapper = mapper;
		this.genericService = genericService;
		this.mapperQuery = mapperQuery;
	}

	@Override
	public ResponseEntity<DTO> create(@RequestBody @Valid DTO dto) {
		E entity = mapper.convertDtoToEntity(dto);
		entity = genericService.insert(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(mapper.convertEntityToDto(entity));
	}

	@Override
	public ResponseEntity<DTO> update(@PathVariable(value = "id") I id,@RequestBody @Valid DTO dto) {
		E entity = mapper.convertDtoToEntity(dto);
		entity.setId(id);
		entity = genericService.update(entity);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(mapper.convertEntityToDto(entity));
	}

	@Override
	public ResponseEntity<Page<DTOQUERY>> findAll(Integer pageNo, Integer pageSize, String sortBy) {
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		List<E> entities = genericService.findAll(paging);	
		List<DTOQUERY> dtos = (List<DTOQUERY>) mapperQuery.convertEntitiesToDTOs(entities);
		Page<DTOQUERY> pageDto = new PageImpl<>(dtos, paging, dtos.size()); 
		return (ResponseEntity<Page<DTOQUERY>>) ResponseEntity.ok(pageDto);
	}

	@Override
	public ResponseEntity<DTOQUERY> findOne(@PathVariable(value = "id") I id) {
		return ResponseEntity.ok(mapperQuery.convertEntityToDto(genericService.findOne(id)));
	}

	@Override
	public ResponseEntity<DTO> delete(@PathVariable(value = "id") I id) {
		genericService.delete(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}

	public GenericService<I, E> getGenericService() {
		return genericService;
	}

	public Mapper<DTO, E> getMapper() {
		return mapper;
	}

    public Mapper<DTOQUERY, E> getMapperQuery() {
        return mapperQuery;
    }
}
