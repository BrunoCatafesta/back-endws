package com.testbackend.architecture.service;

import com.testbackend.architecture.Identifier;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GenericService<I extends Number, E extends Identifier<I>> {

	E insert(E entity);

	E update(E entity);

	List<E> findAll(Pageable paging);

	E findOne(I id);

	void delete(I id);

}
