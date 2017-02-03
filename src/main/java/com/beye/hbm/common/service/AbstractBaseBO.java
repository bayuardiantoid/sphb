package com.beye.hbm.common.service;

import com.beye.hbm.common.dao.AbstractBaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by MamaMia on 1/17/2017.
 */


public abstract class AbstractBaseBO<E, K extends Serializable> implements BaseBO<E,K> {

    protected AbstractBaseDao<E, K> dao;


    @Autowired
    public void setDao(AbstractBaseDao<E, K> dao) {
        this.dao = dao;
    }

    @Override
    public void save(E entity) {
        dao.save(entity);
    }

    @Override
    public void delete(E entity) {
        dao.delete(entity);
    }

    @Override
    public E findById(K key) {
        return dao.findById(key);
    }

    @Override
    public List<E> findAll() {
        return dao.findAll();
    }





}
