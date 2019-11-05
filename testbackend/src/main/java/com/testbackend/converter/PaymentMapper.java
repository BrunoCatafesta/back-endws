package com.testbackend.converter;

import com.testbackend.architecture.converter.Dto;
import com.testbackend.architecture.converter.Mapper;
import com.testbackend.dto.PaymentDTO;
import com.testbackend.entity.Payment;
import org.mapstruct.factory.Mappers;

import java.util.List;

@org.mapstruct.Mapper
public interface PaymentMapper extends Mapper<PaymentDTO, Payment> {

	PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);

	@Override
	Payment convertDtoToEntity(PaymentDTO dto);

	@Override
	PaymentDTO convertEntityToDto(Payment entity);

	@Override
	List<Dto> convertEntitiesToDTOs(List<Payment> allEntities);
}
