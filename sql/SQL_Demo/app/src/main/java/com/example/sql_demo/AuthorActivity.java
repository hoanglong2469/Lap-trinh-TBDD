package com.example.sql_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class AuthorActivity extends AppCompatActivity {
    EditText et_idauthor, et_name, et_address, et_email;
    Button bt_save, bt_select, bt_exit, bt_update, bt_delete;
    GridView gv_display;
    DBHelper dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author);
        et_idauthor = (EditText)findViewById(R.id.edittext_idauthor);
        et_name = (EditText)findViewById(R.id.edittext_name);
        et_address = (EditText)findViewById(R.id.edittext_address);
        et_email = (EditText)findViewById(R.id.edittext_email);
        gv_display = (GridView)findViewById(R.id.gridview_display);
        dbhelper = new DBHelper(this);

        bt_select = (Button)findViewById(R.id.button_select);
        bt_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Author> list_author = new ArrayList<>();
                ArrayList<String> list_string = new ArrayList<>();

                if(et_idauthor.getText().toString().equals(""))
                    list_author = dbhelper.getAllAuthor();
                else
                    list_author = dbhelper.getIdAuthor(Integer.parseInt(et_idauthor.getText().toString()));

                for(Author author:list_author){
                    list_string.add(author.getId_author()+"");
                    list_string.add(author.getName());
                    list_string.add(author.getAddress());
                    list_string.add(author.getEmail());
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(AuthorActivity.this,android.R.layout.simple_list_item_1, list_string);
                gv_display.setAdapter(adapter);
            }
        });

        bt_save = (Button)findViewById(R.id.button_save);
        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Author author = new Author();
                author.setId_author(Integer.parseInt(et_idauthor.getText().toString()));
                author.setName(et_name.getText().toString());
                author.setAddress(et_address.getText().toString());
                author.setEmail(et_email.getText().toString());
                if(dbhelper.insertAuthor(author) > 0)
                    Toast.makeText(getApplicationContext(),"Đã lưu thành công",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(),"Lưu không thành công",Toast.LENGTH_LONG).show();
                et_idauthor.setText("");
                et_name.setText("");
                et_address.setText("");
                et_email.setText("");
            }
        });
        bt_exit = (Button)findViewById(R.id.button_exit);
        bt_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        gv_display.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                et_idauthor.setText("i="+i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
