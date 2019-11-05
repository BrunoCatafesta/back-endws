package com.testbackend.controller;

import com.testbackend.architecture.controller.GenericControllerImpl;
import com.testbackend.converter.ProductMapper;
import com.testbackend.converter.QueryProductMapper;
import com.testbackend.dto.ProductDTO;
import com.testbackend.dto.QueryProductDTO;
import com.testbackend.entity.Product;
import com.testbackend.service.ProductService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@Api(value = "Product", description = "product operations")
public class ProductController extends GenericControllerImpl<Long, ProductDTO, QueryProductDTO, Product> {

    @Autowired
	public ProductController(ProductService service) {
		super(ProductMapper.INSTANCE, QueryProductMapper.INSTANCE, service);
    }

    @GetMapping("/{id}/detail")
    ResponseEntity<ProductDTO> detail(@PathVariable(value = "id") Long id){
        Product product = getGenericService().findOne(id);
        return ResponseEntity.ok(getMapper().convertEntityToDto(product));
    }

}
