package com.testbackend.converter;

import com.testbackend.architecture.converter.Mapper;
import com.testbackend.dto.ProductDTO;
import com.testbackend.entity.Product;
import org.mapstruct.factory.Mappers;

@org.mapstruct.Mapper(uses = { ManufacturerMapper.class })
public interface ProductMapper extends Mapper<ProductDTO, Product> {

	ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

	@Override
	Product convertDtoToEntity(ProductDTO dto);

}