package com.beye.hbm.common.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * Created by MamaMia on 1/20/2017.
 */
public interface BaseDao<E, K extends Serializable> {

    Session getCurrentSession();

    void save(E entity);

    void delete(E entity);

    E findById(K key);

    List<E> findAll();

    List<E> findByCriteria(Criterion... criterions);

    Query findByQuery(String query);
}
