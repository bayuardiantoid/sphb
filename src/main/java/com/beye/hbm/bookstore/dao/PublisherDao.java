package com.beye.hbm.bookstore.dao;

import com.beye.hbm.bookstore.model.Publisher;
import com.beye.hbm.common.dao.AbstractBaseDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by MamaMia on 1/17/2017.
 */

@Repository
public class PublisherDao extends AbstractBaseDao<Publisher, Integer> {

}
