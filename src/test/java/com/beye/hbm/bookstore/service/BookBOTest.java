package com.beye.hbm.bookstore.service;

import com.beye.hbm.bookstore.model.Book;
import com.beye.hbm.common.AbstractBeyeTest;
import com.beye.hbm.config.AppConfig;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by MamaMia on 2/3/2017.
 */



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class} )
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BookBOTest {

    @Autowired
    @Qualifier("bookService")
    private BookBO bookBO;


    @Test
    public void save() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    @Transactional
    public void findById() throws Exception {
        Book book = bookBO.findById(1);
        assert(book.getName().equalsIgnoreCase("buku 1"));
    }

    @Test
    public void findAll() throws Exception {

    }

}