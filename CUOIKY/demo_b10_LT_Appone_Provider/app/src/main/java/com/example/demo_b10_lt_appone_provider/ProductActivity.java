package com.example.demo_b10_lt_appone_provider;

import androidx.appcompat.app.AppCompatActivity;

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

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {

    static final String uri = "content://com.example.demo_b10_lt_appone_provider";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        GridView gridView = findViewById(R.id.gridView_ac2);

        EditText edID = findViewById(R.id.ed_ID_ac2);
        EditText edName = findViewById(R.id.ed_Name_ac2);
        EditText ed_Madein_ac2 = findViewById(R.id.ed_Madein_ac2);
        EditText ed_unit_ac2 = findViewById(R.id.ed_unit_ac2);

        Button btnSelect = findViewById(R.id.btnSelect_Ac2);
        Button btnSave = findViewById(R.id.btnSave_Ac2);
        Button btnUpdate = findViewById(R.id.btnUpdate_Ac2);
        Button btnDelete = findViewById(R.id.btnDelete_Ac2);

        //
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(edID.getText().toString().trim());
                String name = edName.getText().toString();
                String made = ed_Madein_ac2.getText().toString();
                String unit = ed_unit_ac2.getText().toString();

                ContentValues values = new ContentValues();
                values.put("id", id); ///////////
                values.put("name", name);
                values.put("unit", unit);
                values.put("madein", made);

                Uri product = Uri.parse(uri);

            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(edID.getText().toString().trim());
                String name = edName.getText().toString();
                String made = ed_Madein_ac2.getText().toString();
                String unit = ed_unit_ac2.getText().toString();

                ContentValues values = new ContentValues();
                values.put("id", id); ///////////
                values.put("name", name);
                values.put("unit", unit);
                values.put("madein", made);

                Uri product = Uri.parse(uri);

                Uri insert_uri = getContentResolver().insert(product, values);
                Toast.makeText(getApplicationContext(), "Lưu thành công!", Toast.LENGTH_SHORT).show();

            }
        });
        //
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> listString = new ArrayList<>();
                Uri product = Uri.parse(uri);
                Cursor cursor = getContentResolver().query(product, null, null, null, "name");
                if (cursor != null) {
                    cursor.moveToFirst();
                    do {
                        listString.add(cursor.getString(0) + "");
                        listString.add(cursor.getString(1));
                        listString.add(cursor.getString(2));
                        listString.add(cursor.getString(3));
                    } while (cursor.moveToNext());
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(ProductActivity.this, android.R.layout.simple_list_item_1, listString);
                    gridView.setAdapter(adapter);
                } else {
                    Toast.makeText(getApplicationContext(), "Không có kết quả.", Toast.LENGTH_SHORT).show();
                }

            }
        });

        Button btnExit = findViewById(R.id.btnExit);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}