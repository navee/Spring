package org.rao.spring.orm.hibernate.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;
import org.rao.spring.orm.hibernate.dao.BaseDao;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class BaseDaoImpl<T extends Serializable, PK extends Serializable> implements BaseDao<T, PK> {
	private Class<T> clazz;
	
	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	@SuppressWarnings("unchecked")
	public BaseDaoImpl(){
		this.clazz = (Class<T>) ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		//String clazzName = hibernateTemplate.getSessionFactory().getClassMetadata(this.clazz).getEntityName();
	}
	
	public T findById(PK id) {
		return hibernateTemplate.get(clazz, id);
	}

	public List<T> findAll() {
		return hibernateTemplate.loadAll(clazz);
	}

	public T save(T entity) {
		return (T) hibernateTemplate.save(entity);
	}

	public void delete(T entity) {
		hibernateTemplate.delete(entity);
	}

	public void update(T entity) {
		hibernateTemplate.update(entity);
	}
}
