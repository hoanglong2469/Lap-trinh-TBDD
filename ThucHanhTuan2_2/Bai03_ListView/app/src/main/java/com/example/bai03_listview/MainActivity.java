package com.example.bai03_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayAdapter<String> adapter;
    private ArrayList<String> listName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etNhap = findViewById(R.id.edittext_nhapten);
        Button  btnNhap = findViewById(R.id.button_nhap);
        ListView lv_name = findViewById(R.id.listview_name);
        TextView tv_ketQua = findViewById(R.id.textview_hienthi);


        listName = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listName);
        lv_name.setAdapter(adapter);

        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etNhap.getText().toString().trim().isEmpty()){
                    Toast.makeText(MainActivity.this, "Vui lòng nhập vào tên.", Toast.LENGTH_LONG).show();
                }else{
                    listName.add(etNhap.getText().toString().trim());
                    adapter.notifyDataSetChanged();
                }

            }
        });

        lv_name.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                tv_ketQua.setText("Position: "+i+"| Value: "+adapterView.getItemAtPosition(i).toString());
            }
        });

    }
}