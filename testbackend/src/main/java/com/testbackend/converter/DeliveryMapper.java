package com.testbackend.converter;

import com.testbackend.architecture.converter.Dto;
import com.testbackend.architecture.converter.Mapper;
import com.testbackend.dto.DeliveryDTO;
import com.testbackend.entity.Delivery;
import org.mapstruct.factory.Mappers;

import java.util.List;

@org.mapstruct.Mapper
public interface DeliveryMapper extends Mapper<DeliveryDTO, Delivery> {

	DeliveryMapper INSTANCE = Mappers.getMapper(DeliveryMapper.class);

	@Override
	Delivery convertDtoToEntity(DeliveryDTO dto);

	@Override
	DeliveryDTO convertEntityToDto(Delivery entity);

	@Override
	List<Dto> convertEntitiesToDTOs(List<Delivery> allEntities);
}
