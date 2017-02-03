package com.beye.hbm.bookstore.service;

import com.beye.hbm.bookstore.model.Publisher;
import com.beye.hbm.common.service.AbstractBaseBO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by MamaMia on 1/17/2017.
 */
@Service("publisherService")
public class PublisherBO extends AbstractBaseBO<Publisher, Integer> {
}
