package org.rao.spring.orm.jpa.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T extends Serializable, PK extends Serializable> {
	public T findById(PK id);

	public List<T> findAll();

	public void save(T entity);

	public void delete(T entity);

	public void update(T entity);
}
