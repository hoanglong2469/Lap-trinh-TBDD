package com.example.sqlitedemo;

public class Author {
    private int idAuthor;
    private  String name;
    private  String address;
    private  String email;

    public Author(int idAuthor, String name, String address, String email) {
        this.idAuthor = idAuthor;
        this.name = name;
        this.address = address;
        this.email = email;
    }

    public Author() {
        this.idAuthor = 0;
        this.name = null;
        this.address = null;
        this.email = null;
    }

    public int getIdAuthor() {
        return idAuthor;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
