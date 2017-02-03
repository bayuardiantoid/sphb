package com.beye.hbm.common.service;

import com.beye.hbm.common.dao.AbstractBaseDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by MamaMia on 1/21/2017.
 */
public interface BaseBO<E, K> {

    void save(E entity);

    void delete(E entity);

    E findById(K key);

    List<E> findAll();
}
