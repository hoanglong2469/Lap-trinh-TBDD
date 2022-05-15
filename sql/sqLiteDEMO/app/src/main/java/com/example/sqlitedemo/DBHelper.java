package com.example.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context, "MYDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    sqLiteDatabase.execSQL("CREATE TABLE Authors(id integer primary key, name text,address text, email text);");
    sqLiteDatabase.execSQL("CREATE TABLE Books(id integer primary key, title text,id_author integer not null constraint id_author references Authors(id) ON DELETE CASCADE ON UPDATE CASCADE);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Authors");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Books");
        onCreate(sqLiteDatabase);
    }
    //them-xoa-sua
    public int insertAuthor(Author author){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues content= new ContentValues();
        content.put("id",author.getIdAuthor()+"");
        content.put("name",author.getName());
        content.put("address",author.getAddress());
        content.put("email",author.getEmail());
        int res=(int) db.insert("Authors",null,content);
        db.close();
        return res;
    }


    public ArrayList<Author> getAllAuthor(){
        ArrayList<Author> List=new ArrayList<>();
        String strSQL="Select * from Authors";
        SQLiteDatabase db=getReadableDatabase();
        Cursor cursor= db.rawQuery(strSQL,null);
        if (cursor!=null){
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                List.add(new Author(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3)));
                cursor.moveToNext();
            }
            cursor.close();
            db.close();
        }
        return List;
    }
    public Author getIdAuthor(int id){
        Author author= new Author();
        String strSQL="Select * from Authors where id="+id;
        SQLiteDatabase db=getReadableDatabase();
        Cursor cursor= db.rawQuery(strSQL,null);
        if (cursor!=null){
            cursor.moveToFirst();
            author.setIdAuthor(cursor.getInt(0));
            author.setName(cursor.getString(1));
            author.setAddress(cursor.getString(2));
            author.setEmail(cursor.getString(3));
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return author;

    }


    //them-xoa-sua-book
    public int insertBook(Book book){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues content= new ContentValues();
        content.put("id",book.getId()+"");
        content.put("title",book.getTitle());
        content.put("id_author",book.getId_author());
        int res=(int) db.insert("Books",null,content);
        db.close();
        return res;
    }
    public ArrayList<Book> getAllBook(){
        ArrayList<Book> List=new ArrayList<>();
        String strSQL="Select * from Books";
        SQLiteDatabase db=getReadableDatabase();
        Cursor cursor= db.rawQuery(strSQL,null);
        if (cursor!=null){
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                List.add(new Book(cursor.getInt(0),cursor.getString(1),cursor.getInt(2)));
                cursor.moveToNext();
            }
            cursor.close();
            db.close();
        }
        return List;
    }
    public Book getIdBook(int id){
        Book book= new Book();
        String strSQL="Select * from Books where id="+id;
        SQLiteDatabase db=getReadableDatabase();
        Cursor cursor= db.rawQuery(strSQL,null);
        if (cursor!=null){
            cursor.moveToFirst();
            book.setId(cursor.getInt(0));
            book.setTitle(cursor.getString(1));
            book.setId_author(cursor.getInt(2));
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return book;

    }
}
