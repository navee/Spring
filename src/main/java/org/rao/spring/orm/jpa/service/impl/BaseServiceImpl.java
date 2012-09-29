package org.rao.spring.orm.jpa.service.impl;

import java.io.Serializable;
import java.util.List;

import org.rao.spring.orm.jpa.dao.BaseDao;
import org.rao.spring.orm.jpa.service.BaseService;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class BaseServiceImpl<T extends Serializable,PK extends Serializable> implements BaseService<T, PK> {
	protected BaseDao<T,PK> dao;
	
	public abstract void setDao(BaseDao<T,PK> dao);
	
	@Override
	public T findById(PK id) {
		return (T) dao.findById(id);
	}

	@Override
	public List<T> findAll() {
		return dao.findAll();
	}

	@Override
	public void save(T entity) {
		dao.save(entity);
	}

	@Override
	public void delete(T entity) {
		dao.delete(entity);
	}

	@Override
	public void update(T entity) {
		dao.update(entity);
	}

}
