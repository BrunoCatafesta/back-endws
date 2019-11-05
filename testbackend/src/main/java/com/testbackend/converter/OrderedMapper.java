package com.testbackend.converter;

import com.testbackend.architecture.converter.Dto;
import com.testbackend.architecture.converter.Mapper;
import com.testbackend.dto.OrderedDTO;
import com.testbackend.entity.Ordered;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@org.mapstruct.Mapper(uses = { ConsumerMapper.class, DeliveryMapper.class, PaymentMapper.class,
		OrderedItemMapper.class }, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderedMapper extends Mapper<OrderedDTO, Ordered> {

	OrderedMapper INSTANCE = Mappers.getMapper(OrderedMapper.class);

	@Override
	@Mapping(source = "status", target = "status.status")
	Ordered convertDtoToEntity(OrderedDTO dto);

	@Override
	@Mapping(source = "status.status", target = "status")
	OrderedDTO convertEntityToDto(Ordered entity);

	@Override
	List<Dto> convertEntitiesToDTOs(List<Ordered> allEntities);

}