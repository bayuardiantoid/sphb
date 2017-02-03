package com.beye.hbm.bookstore.dao;

import com.beye.hbm.bookstore.model.Book;
import com.beye.hbm.common.dao.AbstractBaseDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by MamaMia on 1/17/2017.
 */

@Repository
public class BookDao extends AbstractBaseDao<Book, Integer> {

}
