package com.example.bai01_pheptinh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText et_soA = findViewById(R.id.editText_soA);
        EditText et_soB = findViewById(R.id.editText_soB);
        TextView tv_ketQua = findViewById(R.id.textView_ketQua);
        Button bt_tong = findViewById(R.id.button_tong);
        Button bt_hieu = findViewById(R.id.button_hieu);
        Button bt_tich = findViewById(R.id.button_tich);
        Button bt_thuong = findViewById(R.id.button_thuong);
        Button bt_uocChungLonNhat = findViewById(R.id.button_uocChungLonNhat);
        Button bt_thoat = findViewById(R.id.button_thoat);


        bt_tong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int soA = Integer.parseInt(et_soA.getText().toString());
                int soB = Integer.parseInt(et_soB.getText().toString());
                PhepTinh phepTinh = new PhepTinh(soA, soB);
                String ketQua = String.valueOf(phepTinh.tinhTong());
                tv_ketQua.setText(ketQua);
            }
        });

        bt_hieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int soA = Integer.parseInt(et_soA.getText().toString());
                int soB = Integer.parseInt(et_soB.getText().toString());
                PhepTinh phepTinh = new PhepTinh(soA, soB);
                String ketQua = String.valueOf(phepTinh.tinhHieu());
                tv_ketQua.setText(ketQua);

            }
        });

        bt_tich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int soA = Integer.parseInt(et_soA.getText().toString());
                int soB = Integer.parseInt(et_soB.getText().toString());
                PhepTinh phepTinh = new PhepTinh(soA, soB);
                String ketQua = String.valueOf(phepTinh.tinhTich());
                tv_ketQua.setText(ketQua);
            }
        });

        bt_thuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int soA = Integer.parseInt(et_soA.getText().toString());
                int soB = Integer.parseInt(et_soB.getText().toString());
                PhepTinh phepTinh = new PhepTinh(soA, soB);
                String ketQua = String.valueOf(phepTinh.tinhThuong());
                tv_ketQua.setText(ketQua);
            }
        });

        bt_uocChungLonNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int soA = Integer.parseInt(et_soA.getText().toString());
                int soB = Integer.parseInt(et_soB.getText().toString());
                PhepTinh phepTinh = new PhepTinh(soA, soB);
                String ketQua = String.valueOf(phepTinh.tinhUocChungLonNhat());
                tv_ketQua.setText(ketQua);
            }
        });

        bt_thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}