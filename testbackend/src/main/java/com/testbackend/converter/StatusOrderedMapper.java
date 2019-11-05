package com.testbackend.converter;

import com.testbackend.architecture.converter.Dto;
import com.testbackend.architecture.converter.Mapper;
import com.testbackend.dto.StatusOrderedDTO;
import com.testbackend.entity.StatusOrdered;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@org.mapstruct.Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StatusOrderedMapper extends Mapper<StatusOrderedDTO, StatusOrdered> {

	StatusOrderedMapper INSTANCE = Mappers.getMapper(StatusOrderedMapper.class);

	@Override
	StatusOrdered convertDtoToEntity(StatusOrderedDTO dto);

	@Override
	StatusOrderedDTO convertEntityToDto(StatusOrdered entity);

	@Override
	List<Dto> convertEntitiesToDTOs(List<StatusOrdered> allEntities);
}