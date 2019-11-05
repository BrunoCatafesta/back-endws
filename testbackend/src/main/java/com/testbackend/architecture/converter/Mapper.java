package com.testbackend.architecture.converter;

import com.testbackend.architecture.Identifier;

import java.util.List;

public interface Mapper<DTO extends Dto, E extends Identifier<?>> {

	E convertDtoToEntity(DTO dto);

	DTO convertEntityToDto(E entity);

	List<Dto> convertEntitiesToDTOs(List<E> allEntities);

}