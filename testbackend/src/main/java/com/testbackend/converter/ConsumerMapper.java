package com.testbackend.converter;

import com.testbackend.architecture.converter.Dto;
import com.testbackend.architecture.converter.Mapper;
import com.testbackend.dto.ConsumerDTO;
import com.testbackend.entity.Consumer;
import org.mapstruct.factory.Mappers;

import java.util.List;

@org.mapstruct.Mapper
public interface ConsumerMapper extends Mapper<ConsumerDTO, Consumer> {

    ConsumerMapper INSTANCE = Mappers.getMapper(ConsumerMapper.class);

    @Override
    Consumer convertDtoToEntity(ConsumerDTO dto);

    @Override
    ConsumerDTO convertEntityToDto(Consumer entity);

    @Override
    List<Dto> convertEntitiesToDTOs(List<Consumer> allEntities);
}