package org.rao.spring.orm.jpa.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.rao.spring.orm.jpa.dao.BaseDao;

public class BaseDaoImpl<T extends Serializable,PK extends Serializable> implements BaseDao<T, PK> {
	private Class<T> clazz;
	
	@PersistenceContext
	EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		this.clazz = (Class<T>) ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	@Override
	public T findById(PK id) {
		return entityManager.find(clazz, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return entityManager.createQuery("from " + clazz.getName()).getResultList();
	}

	@Override
	public void save(T entity) {
		entityManager.persist(entity);
	}

	@Override
	public void delete(T entity) {
		entityManager.remove(entity);
	}

	@Override
	public void update(T entity) {
		entityManager.merge(entity);
	}
}
