package com.example.on_tap.dao;

import androidx.room.*;

import com.example.on_tap.entity.Book;

@Dao
public abstract class BookDAO {
    @Insert
    public abstract void insert(Book book);

    @Update
    public abstract void update(Book book);

    @Delete
    public abstract void delete(Book book);

    @Query("SELECT * FROM books WHERE id=:id")
    public abstract Book findById(String id);

    public boolean checkExits(String id){
        return findById(id) != null;
    }
}
