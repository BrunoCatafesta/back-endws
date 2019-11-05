package com.testbackend.architecture.service;

import com.testbackend.architecture.Identifier;
import com.testbackend.architecture.persistence.GenericDAO;
import com.testbackend.architecture.validation.ValidatorService;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class GenericServiceImpl<I extends Number, E extends Identifier<I>> implements GenericService<I, E> {

	
	private GenericDAO<I, E> dao;

	private ValidatorService<E> validatorService;
	
	public GenericServiceImpl(GenericDAO<I, E> dao, ValidatorService<E> validatorService) {
		this.dao = dao;
		this.validatorService = validatorService;
	}

	@Override
	public E insert(E entity) {
        validatorService.validateInsert(entity);
		prepareForInsert(entity);
		insertDependents(entity);
	    entity = dao.insert(entity);
	    insertDetails(entity);
	    return entity;
	}

    @Override
	public E update(E entity) {
		prepareForUpdate(entity);
		validatorService.validateInsert(entity);
		return dao.merge(entity);
	}

	@Override
	public List<E> findAll(Pageable pageable) {
		return dao.findAll(pageable);
	}

	@Override
	public E findOne(I id) {
		return dao.find(id).orElse(null);
	}

	@Override
	public void delete(I id) {
		dao.delete(id);
	}

    public void insertDetails(E entity) {}

	public void insertDependents(E entity) {}
	
	public void prepareForInsert(E entity){};

	public void prepareForUpdate(E entity){};

	public ValidatorService<E> getValidatorService() {
		return validatorService;
	}
}
