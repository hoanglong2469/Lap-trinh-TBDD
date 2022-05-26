package com.example.sqlitedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        EditText et_IdBook=findViewById(R.id.ID_Book);
        EditText et_title=findViewById(R.id.Title_book);
        EditText et_ID_Author=findViewById(R.id.ID_Author);

        GridView gv_ListBook=findViewById(R.id.ListBook);
        DBHelper dbHelper=new DBHelper(this);

        Button bt_save=findViewById(R.id.Save);
        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book book= new Book();
                book.setId(Integer.parseInt(et_IdBook.getText().toString()));
                book.setTitle(et_title.getText().toString());
                book.setId_author(Integer.parseInt(et_ID_Author.getText().toString()));

                if (dbHelper.insertBook(book)>0)
                    Toast.makeText(getApplicationContext(),"Bạn đã lưu thành công",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(),"Bạn lưu không thành công",Toast.LENGTH_SHORT).show();
            }
        });

        Button bt_select=findViewById(R.id.Select);
        bt_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Book> ListBook=new ArrayList<>();
                ArrayList<String> list_String= new ArrayList<>();
                ListBook= dbHelper.getAllBook();
                if(et_IdBook.getText().toString().equals("")){
                    ListBook= dbHelper.getAllBook();
                }else{
                    ListBook.add(dbHelper.getIdBook(Integer.parseInt(et_IdBook.getText().toString())));

                }
                for (Book au:ListBook){
                    list_String.add(au.getId()+"");
                    list_String.add(au.getTitle());
                    list_String.add(au.getId_author()+"");

                }
                ArrayAdapter<String> adapter= new ArrayAdapter<>(BookActivity.this,android.R.layout.simple_list_item_1);
                gv_ListBook.setAdapter(adapter);
            }
        });
        Button bt_Exit=findViewById(R.id.Ex_book);
        bt_Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}