package org.rao.spring.orm.hibernate.service;

import java.util.List;

public interface BaseService<T,PK> {
	T save(T entity);

	void delete(T entity);

	void update(T entity);

	List<T> list();
	
	T get(PK id);
}
