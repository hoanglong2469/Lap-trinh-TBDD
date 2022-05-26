package com.example.on_tap.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.on_tap.dao.BookDAO;
import com.example.on_tap.entity.Book;

@Database(entities = {Book.class}, version = 1)
public abstract class DatabaseHandler extends RoomDatabase {
    public abstract BookDAO getBookDAO();
}