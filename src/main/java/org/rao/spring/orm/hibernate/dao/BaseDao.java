package org.rao.spring.orm.hibernate.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public interface BaseDao<T extends Serializable,PK extends Serializable> {

	public T findById(PK id);
	
	public List<T> findAll();
	
	public T save(T entity);
	
	public void delete(T entity);
	
	public void update(T entity);
}
