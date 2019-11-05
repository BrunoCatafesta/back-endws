package com.testbackend.converter;

import com.testbackend.dto.ProductDTO;
import com.testbackend.dto.QueryProductDTO;
import com.testbackend.entity.Product;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@org.mapstruct.Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QueryProductMapper extends com.testbackend.architecture.converter.Mapper<QueryProductDTO, Product> {

	QueryProductMapper INSTANCE = Mappers.getMapper(QueryProductMapper.class);

	Product convertDtoToEntity(ProductDTO dto);

	QueryProductDTO convertEntityToDto(Product entity);
}