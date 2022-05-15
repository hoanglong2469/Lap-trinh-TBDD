package com.example.sql_demo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    DBHelper(Context context){
        super(context,"BookDatabase.sqlite",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE Authors("+
                "id_author integer primary key,"+
                "name text,"+
                "address text,"+
                "email text)");
        sqLiteDatabase.execSQL("CREATE TABLE Books("+
                "id_book integer primary key,"+
                "title text,"+
                "id_author integer "+
                "constraint id_author references Authors(id_author) On  Delete Cascade ON UPDATE CASCADE)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Books");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Authors");
        onCreate(sqLiteDatabase);
    }

    public int insertAuthor(Author author){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id_author", author.getId_author());
        contentValues.put("name", author.getName());
        contentValues.put("address", author.getAddress());
        contentValues.put("email", author.getEmail());
        int result = (int)db.insert("Authors", null, contentValues);
        db.close();
        return result;
    }
    public ArrayList<Author> getAllAuthor(){
        ArrayList<Author> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Authors",null);
        if(cursor != null)
            cursor.moveToFirst();
        while(cursor.isAfterLast()==false) {
            list.add(new Author(cursor.getInt(0), cursor.getString(1),cursor.getString(2), cursor.getString(3)));
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return list;
    }
    public ArrayList<Author> getIdAuthor(int id_author){
        ArrayList<Author> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Authors where id_author=" + id_author,null);
        if(cursor != null)
            cursor.moveToFirst();
        Author author = new Author(cursor.getInt(0),cursor.getString(1), cursor.getString(2),cursor.getString(3));
        list.add(author);
        cursor.close();
        db.close();
        return list;
    }
    public ArrayList<String> getSearch(String name){
        ArrayList<String> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select id_book, title, name from Authors inner join Books on Authors.id_author = Books.id_author where name=" + name,null);
        if(cursor != null)
            cursor.moveToFirst();
        while(cursor.isAfterLast()==false) {
            String st = cursor.getInt(0) + "\t" + cursor.getString(1) + "\t" + cursor.getString(2);
            list.add(st);
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return list;
    }

    public int insertBook(Book book){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id_book", book.getId_Book());
        contentValues.put("title", book.getTitle());
        contentValues.put("id_author", book.getId_Author());
        int result = (int)db.insert("Books", null, contentValues);
        db.close();
        return result;
    }
    public ArrayList<Book> getAllBook(){
        ArrayList<Book> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Books",null);
        if(cursor != null)
            cursor.moveToFirst();
        while(cursor.isAfterLast()==false) {
            list.add(new Book(cursor.getInt(0), cursor.getString(1),
                    cursor.getInt(2)));
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return list;
    }
}
