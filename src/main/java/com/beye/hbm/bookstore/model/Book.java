package com.beye.hbm.bookstore.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by MamaMia on 1/16/2017.
 */

@Entity
@Table(name = "book")
public class Book implements Serializable {


    public Book() {
    }

    @Column(name = "name", length = 100)
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "isbn", length = 13)
    private int isbn;

    @Column(name = "publish_date")
    private Timestamp publishDate;

    @Column(name = "price")
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN )
    @PrimaryKeyJoinColumn(name = "publisher", referencedColumnName = "code")
    private Publisher publisher;

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Timestamp publishDate) {
        this.publishDate = publishDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Publisher getPublisher() {
        return publisher;
    }
}
