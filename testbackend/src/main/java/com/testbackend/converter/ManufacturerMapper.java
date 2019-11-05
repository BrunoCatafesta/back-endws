package com.testbackend.converter;

import com.testbackend.architecture.converter.Dto;
import com.testbackend.architecture.converter.Mapper;
import com.testbackend.dto.ManufacturerDTO;
import com.testbackend.entity.Manufacturer;
import org.mapstruct.factory.Mappers;

import java.util.List;

@org.mapstruct.Mapper
public interface ManufacturerMapper extends Mapper<ManufacturerDTO, Manufacturer> {

    ManufacturerMapper INSTANCE = Mappers.getMapper(ManufacturerMapper.class);

    @Override
    Manufacturer convertDtoToEntity(ManufacturerDTO dto);

    @Override
    ManufacturerDTO convertEntityToDto(Manufacturer entity);

    @Override
    List<Dto> convertEntitiesToDTOs(List<Manufacturer> allEntities);
}