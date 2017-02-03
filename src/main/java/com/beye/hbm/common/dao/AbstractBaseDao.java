package com.beye.hbm.common.dao;

import org.hibernate.*;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by MamaMia on 1/17/2017.
 */

@SuppressWarnings("unchecked")
public abstract class AbstractBaseDao<E, K extends Serializable> implements BaseDao<E, K> {



    protected SessionFactory sessionFactory;
    private Class<E> clazz;


    public AbstractBaseDao() {
        this.clazz = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        System.out.println("SESSION FACTORY SET!");
        System.out.println(sessionFactory);
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void save(E entity){
        getCurrentSession().save(entity);
    }

    @Override
    public void delete(E entity) {
        getCurrentSession().update(entity);
    }


    @Override
    public E findById(K key) {
        return (E) getCurrentSession().get(clazz, key);
    }
    
    @Override
    public List<E> findByCriteria(Criterion... criterions) {
        Criteria criteria = getCurrentSession().createCriteria(clazz);
        for (Criterion criterion : criterions) {
            criteria.add(criterion);
        }
        return (List<E>) criteria.list();
    }

    @Override
    public Query findByQuery(String query) {
        return getCurrentSession().createQuery(query);
    }

    @Override
    public List<E> findAll() {
        return getCurrentSession().createCriteria(clazz).list();
    }

}
