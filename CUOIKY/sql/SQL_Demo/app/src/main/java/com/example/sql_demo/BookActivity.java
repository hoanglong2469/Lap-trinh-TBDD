package com.example.sql_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

public class BookActivity extends AppCompatActivity {
    EditText et_idbook, et_title, et_idauthor;
    Button bt_save, bt_select, bt_exit, bt_update, bt_delete;
    GridView gv_display;
    DBHelper dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);


    }
}
