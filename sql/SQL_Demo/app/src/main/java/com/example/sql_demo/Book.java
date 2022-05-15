package com.example.sql_demo;

public class Book {
    private int id_book;
    private String title;
    private int id_author;

    Book() {
        this.id_book = 0;
        this.title = null;
        this.id_author = 0;
    }
    Book(int id_book, String title, int id_author) {
        this.id_book = id_book;
        this.title = title;
        this.id_author = id_author;
    }

    public int getId_Book() {
        return id_book;
    }

    public void setId_Book(int id_book) {
        this.id_book = id_book;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId_Author() {
        return id_author;
    }

    public void setId_Author(int id_author) {
        this.id_author = id_author;
    }
}
