package com.example.on_tap.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;

@IgnoreExtraProperties
@Entity(tableName = "books")
public class Book implements Serializable {
    @PrimaryKey
    @NonNull
    private int id;
    private String ten;
    private String tacGia;

    public Book(int id, String ten, String tacGia) {
        this.id = id;
        this.ten = ten;
        this.tacGia = tacGia;
    }

    public Book(String ten, String tacGia) {
        this.ten = ten;
        this.tacGia = tacGia;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }
}
