package org.rao.spring.orm.hibernate.service.impl;

import java.io.Serializable;
import java.util.List;

import org.rao.spring.orm.hibernate.dao.BaseDao;
import org.rao.spring.orm.hibernate.service.BaseService;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class BaseServiceImpl<T extends Serializable,PK extends Serializable> implements BaseService<T,PK> {
	protected BaseDao dao;
	
	@Override
	public T save(T entity) {
		return (T) dao.save(entity);
	}

	@Override
	public void delete(T entity) {
		dao.delete(entity);
	}

	@Override
	public void update(T entity) {
		dao.update(entity);
	}

	@Override
	public List<T> list() {
		return dao.findAll();
	}

	@Override
	public T get(PK id) {
		return (T) dao.findById(id);
	}

}
