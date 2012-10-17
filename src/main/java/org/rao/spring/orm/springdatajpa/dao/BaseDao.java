package org.rao.spring.orm.springdatajpa.dao;

import java.io.Serializable;

import org.rao.spring.orm.springdatajpa.entity.User;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

//不扫描注册repository bean
@NoRepositoryBean
public interface BaseDao<T,ID extends Serializable> extends Repository<T, ID> {
	T save(T entity);
}
