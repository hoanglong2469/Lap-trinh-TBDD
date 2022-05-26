package com.example.sql_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.mymenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnauthor:
                Intent intent_author = new Intent(MainActivity.this, AuthorActivity.class);
                startActivity(intent_author);
                return true;
            case R.id.mnbook:
                Intent intent_book = new Intent(MainActivity.this, BookActivity.class);
                startActivity(intent_book);
                return true;
            case R.id.mnsearch:
                Intent intent_search = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent_search);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}