package com.beye.hbm.bookstore.controller;

import com.beye.hbm.bookstore.model.Book;
import com.beye.hbm.bookstore.model.Publisher;
import com.beye.hbm.bookstore.service.PublisherBO;
import com.beye.hbm.common.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by MamaMia on 1/22/2017.
 */

@Controller
public class PublisherController extends BaseController<Publisher, String> {
    private PublisherBO publisherService;

    @Autowired
    public void setPublisherService(PublisherBO publisherService) {
        this.publisherService = publisherService;
    }

    @RequestMapping(value = "/publisher", method = RequestMethod.GET)
    @ResponseBody
    @Transactional
    public List<Publisher> getPublisher() {
        return this.publisherService.findAll();
    }

    @RequestMapping(value = "/publisher/{id}", method = RequestMethod.GET)
    @ResponseBody
    @Transactional
    public Publisher getPublisher(@PathVariable Integer id) {
        return this.publisherService.findById(id);
    }

    @RequestMapping(value = "/publisher", method = RequestMethod.POST)
    @Transactional(propagation = Propagation.REQUIRED)
    public void addPublisher(@RequestBody Publisher publisher) {
        this.publisherService.save(publisher);
    }

}
