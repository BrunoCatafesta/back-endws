package com.testbackend.architecture.persistence;

import com.testbackend.architecture.Identifier;
import org.hibernate.Session;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Transactional
public class GenericDAOImpl<IDENTIFIER extends Number, T extends Identifier<IDENTIFIER>> implements GenericDAO<IDENTIFIER, T> {

	@PersistenceContext
	protected EntityManager entityManager;

	private Class<T> type;

	public GenericDAOImpl(Class<T> type) {
		this.type = type;
	}

	@Override
	public T insert(T entity) {
		entityManager.persist(entity);
		return entity;
	}

	@Override
	public Optional<T> findLock(IDENTIFIER id, LockModeType lockModeType) {
		return Optional.ofNullable(entityManager.find(type, id, lockModeType));
	}

	@Override
	public Optional<T> find(T entity) {
		return Optional.ofNullable(entityManager.find(type, entity.getId()));
	}

	@Override
	public T merge(T entity) {
		return entityManager.merge(entity);
	}

	@Override
	public List<T> findAll(Pageable pageable) {
		int pageNumber  = pageable.getPageNumber();
		int limit = pageable.getPageSize();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> criteria = builder.createQuery(type);
		criteria.from(type);
		Query query = entityManager.createQuery(criteria);
		query.setFirstResult(pageNumber * limit);
		query.setMaxResults(limit);
		return query.getResultList();
	}

	@Override
	public T getReference(IDENTIFIER id) {
		return entityManager.getReference(type, id);
	}

	@Override
	public void delete(T entity) {
		entityManager.remove(entity);
	}

	@Override
	public Optional<T> find(IDENTIFIER id) {
		return Optional.ofNullable(entityManager.find(type, id));
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public Session getSession(){
		return entityManager.unwrap(Session.class);
	}

	@Override
	public T mergeOrPersist(T entity){
		Optional<T> entityLocated = Objects.nonNull(entity.getId()) ? this.find(entity) : Optional.empty();
		if(entityLocated.isPresent()) {
			entity = merge(entity);
		} else {
			insert(entity);
		}
		return entity;
	}

	@Override
	public void delete(IDENTIFIER id) {
		T entity = getReference(id);
		entityManager.remove(entity);
	}

}
