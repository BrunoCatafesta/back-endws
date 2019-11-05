package com.testbackend.controller;


import com.testbackend.architecture.controller.GenericControllerImpl;
import com.testbackend.converter.OrderedMapper;
import com.testbackend.dto.OrderedDTO;
import com.testbackend.entity.Ordered;
import com.testbackend.persistence.OrderedRepository;
import com.testbackend.service.OrderedService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ordered")
@Api(value = "Ordered", description = "ordered operations")
public class OrderedController extends GenericControllerImpl <Long, OrderedDTO, OrderedDTO, Ordered>{

	@Autowired
	private OrderedRepository orderedRepository;
	
    @Autowired
    public OrderedController(OrderedService genericService) {
        super(OrderedMapper.INSTANCE, OrderedMapper.INSTANCE, genericService);
    }

    @PutMapping("/{id}/cancel")
    ResponseEntity<?> cancel(@PathVariable(value = "id") Long id){
        ((OrderedService) getGenericService()).cancelOrdered(id);
        Ordered ordered = orderedRepository.find(id).get();
        return ResponseEntity.ok(getMapper().convertEntityToDto(ordered));
    }

    @PutMapping("/{id}/confirm")
    ResponseEntity<OrderedDTO> confirm(@PathVariable(value = "id") Long id){
        ((OrderedService) getGenericService()).confirmOrdered(id);
        Ordered ordered = orderedRepository.find(id).get();
        return ResponseEntity.ok(getMapper().convertEntityToDto(ordered));
    }

}