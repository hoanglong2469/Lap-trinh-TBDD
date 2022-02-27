package com.example.bai02_dangnhap;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText et_tenDangNhap = findViewById(R.id.edittext_tendangnhap);
        EditText et_matKhau = findViewById(R.id.edittext_matkhau);
        CheckBox cb_luuThongTin = findViewById(R.id.checkbox_luu);
        Button bt_dangNhap = findViewById(R.id.button_dangnhap);
        Button bt_thoat = findViewById(R.id.button_thoat);

        bt_dangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et_tenDangNhap.getText().toString().trim().isEmpty() || et_matKhau.getText().toString().trim().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Thông tin không được để rỗng", Toast.LENGTH_LONG).show();
                } else {

                    if (cb_luuThongTin.isChecked()) {
                        Toast.makeText(MainActivity.this, "Chào mừng bạn đăng nhập hệ thống, thông tin của bạn đã được lưu", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Chào mừng bạn đăng nhập hệ thống, thông tin của bạn không được lưu", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        bt_thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setMessage("Bạn có muốn thoát không?");
                builder.setTitle("Thông báo");
                builder.setIcon(R.drawable.ic_warning_48);
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        finish();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
}