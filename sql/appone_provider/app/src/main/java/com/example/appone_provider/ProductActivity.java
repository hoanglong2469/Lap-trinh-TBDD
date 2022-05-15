package com.example.appone_provider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {
    static final String uri="content://com.example.appone_provider";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        EditText et_Id = findViewById(R.id.edittext_Id);
        EditText et_Name = findViewById(R.id.edittext_name);
        EditText et_Unit = findViewById(R.id.edittext_Unit);
        EditText et_Madein = findViewById(R.id.edittext_Madein);

        GridView gv_Display = new GridView(this);
        DBHelper dbHelper = new DBHelper(this);

        Button bt_Save = findViewById(R.id.button_save);
        bt_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues values= new ContentValues();
                values.put("id",et_Id.getText().toString());
                values.put("name",et_Name.getText().toString());
                values.put("unit",et_Unit.getText().toString());
                values.put("madein",et_Madein.getText().toString());
                Uri product = Uri.parse(uri);
                Uri insert_uri = getContentResolver().insert(product,values);
                Toast.makeText(getApplicationContext(),"Lưu thành công",Toast.LENGTH_SHORT).show();

            }
        });

        Button bt_Select = findViewById(R.id.button_select);
        bt_Select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> string_list = new ArrayList<>();
                Uri product = Uri.parse(uri);
                Cursor cursor = getContentResolver().query(product,null,
                        null,null,"name");
                if(cursor !=null){
                    cursor.moveToFirst();
                    do{
                        string_list.add(cursor.getInt(0)+"");
                        string_list.add(cursor.getString(1));
                        string_list.add(cursor.getString(2));
                        string_list.add(cursor.getString(3));
                    }while (cursor.moveToNext());
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(ProductActivity.this,
                            android.R.layout.simple_list_item_1,string_list);
                    gv_Display.setAdapter(adapter);
                }else
                    Toast.makeText(getApplicationContext(),"Không có kết quả",Toast.LENGTH_SHORT).show();
            }
        });
    }
}