package com.example.appone_provider;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {
    static final String URI = "content://com.example.appone_provider";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        EditText et_id = findViewById(R.id.edittext_id);
        EditText et_name = findViewById(R.id.edittext_name);
        EditText et_unit = findViewById(R.id.edittext_unit);
        EditText et_madein = findViewById(R.id.edittext_madein);
        GridView gv_product = findViewById(R.id.gridview_products);

        Button btnSave = findViewById(R.id.button_save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("id", et_id.getText().toString().trim());
                contentValues.put("name", et_name.getText().toString().trim());
                contentValues.put("unit", et_unit.getText().toString().trim());
                contentValues.put("madein", et_madein.getText().toString().trim());


                Uri insert_uri = getContentResolver().insert(Uri.parse(URI), contentValues);
                Toast.makeText(getApplicationContext(), "Lưu thành công", Toast.LENGTH_SHORT).show();

            }
        });

        Button btn_select = findViewById(R.id.button_select);
        btn_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> strings = new ArrayList<>();
                Uri product = Uri.parse(URI);
                Cursor cursor = getContentResolver().query(product, null, null, null, "name");
                if (cursor != null) {
                    cursor.moveToFirst();
                    do {
                        strings.add(cursor.getInt(0) + "");
                        strings.add(cursor.getString(1));
                        strings.add(cursor.getString(2));
                        strings.add(cursor.getString(3));
                    } while (cursor.moveToNext());
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(ProductActivity.this, android.R.layout.simple_list_item_1, strings);
                    gv_product.setAdapter(adapter);
                }else{
                    Toast.makeText(getApplicationContext(), "Không có kết quả", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}