package com.beye.hbm.common.controller;

import com.beye.hbm.bookstore.model.Book;
import com.beye.hbm.bookstore.model.Publisher;
import com.beye.hbm.bookstore.service.PublisherBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by MamaMia on 1/22/2017.
 */

@Controller
public class HelloController {

    private PublisherBO publisherService;

    @Autowired
    public void setPublisherService(PublisherBO publisherService) {
        this.publisherService = publisherService;
    };

    @RequestMapping(value = "/publisher/{id}/book", method = RequestMethod.GET)
    @ResponseBody
    @Transactional
    public List<Book> hello(@PathVariable Integer id) {
        Publisher publisher = publisherService.findById(id);
        System.out.println(publisher);
        List<Book> books = publisher.getBooks();
        System.out.println(books.size());
        return books;
    }

}
