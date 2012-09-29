package org.rao.spring.orm.jpa.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T extends Serializable, PK extends Serializable> {
	public T findById(PK id);

	public List<T> findAll();

	public void save(T entity);

	public void delete(T entity);

	public void update(T entity);
}
