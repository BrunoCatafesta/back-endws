package com.testbackend.architecture.persistence;

import com.testbackend.architecture.Identifier;
import org.springframework.data.domain.Pageable;

import javax.persistence.LockModeType;
import java.util.List;
import java.util.Optional;

public interface GenericDAO<IDENTIFIER extends Number, T extends Identifier<IDENTIFIER>> {

	T insert(T entity);

	Optional<T> findLock(IDENTIFIER id, LockModeType lockModeType);

	Optional<T> find(T entity);

	T merge(T entity);

	List<T> findAll(Pageable pageable);

	T getReference(IDENTIFIER id);

	void delete(T entity);

	Optional<T> find(IDENTIFIER id);

    T mergeOrPersist(T entity);

    void delete(IDENTIFIER id);

}
