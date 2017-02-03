package com.beye.hbm.bookstore.controller;

import com.beye.hbm.bookstore.model.Book;
import com.beye.hbm.bookstore.service.BookBO;
import com.beye.hbm.common.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by MamaMia on 1/17/2017.
 */
@Controller
public class BookController extends BaseController<Book, String> {
    private BookBO bookService;


    @Autowired
    public void setBookService(BookBO bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/book")
    @ResponseBody
    @Transactional
    public List<Book> getBook() {
        return this.bookService.findAll();
    }

    @RequestMapping("/book/{id}")
    @ResponseBody
    @Transactional
    public Book getBook(@PathVariable Integer id) {
        return this.bookService.findById(id);
    }

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    @Transactional(propagation = Propagation.REQUIRED)
    public void addBook(@RequestBody Book book) {
        this.bookService.save(book);
    }
}
