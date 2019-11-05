package com.testbackend.converter;

import com.testbackend.architecture.converter.Dto;
import com.testbackend.dto.OrderedItemDTO;
import com.testbackend.entity.OrderedItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface OrderedItemMapper extends com.testbackend.architecture.converter.Mapper<OrderedItemDTO, OrderedItem> {

	@Override
	@Mapping(ignore = true, target = "ordered")
	@Mapping(ignore = true, target = "id")
	@Mapping(source = "id", target = "product.id")
	OrderedItem convertDtoToEntity(OrderedItemDTO dto);

	@Override
	@Mapping(source = "product.id", target = "id")
	OrderedItemDTO convertEntityToDto(OrderedItem entity);

	@Override
	List<Dto> convertEntitiesToDTOs(List<OrderedItem> allEntities);
}