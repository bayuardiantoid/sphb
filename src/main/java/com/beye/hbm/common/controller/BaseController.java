package com.beye.hbm.common.controller;

import com.beye.hbm.common.service.AbstractBaseBO;
import org.springframework.stereotype.Controller;

import java.io.Serializable;

/**
 * Created by MamaMia on 1/17/2017.
 */
@Controller
public abstract class BaseController<E, K extends Serializable> {
    protected AbstractBaseBO<E, K> service;

    public void save(E entity) {
        service.save(entity);
    }

    public void delete(E entity) {
        service.delete(entity);
    }

    public E get(K key) {
        return service.findById(key);
    }

}
