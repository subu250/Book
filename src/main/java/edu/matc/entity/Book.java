package edu.matc.entity;


import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class Book {

    @NotEmpty(message = "Please enter name")
    private String author;

    @NotNull
    @Size(min = 3, max = 15)
    private String title;

    @Min(3)
    private int bookCount;

    public Book() {

    }

    public Book(String author, String title, int bookCount) {
        super();
        this.author = author;
        this.title = title;
        this.bookCount = bookCount;

    }
    public String getAuthor () {
        return author;
    }

    public void setAuthor (String author){
        this.author = author;
    }

    public String getTitle () {
        return title;
    }

    public void setTitle (String title){
        this.title = title;
    }

    public int getBookCount () {
        return bookCount;
    }

    public void setBookCount ( int bookCount){
        this.bookCount = bookCount;
    }

}
