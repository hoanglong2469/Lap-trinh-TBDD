package com.example.ui_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<NhanVien> nv_List= new ArrayList<>();
    String[] dv_List;
    String donvi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText et_Maso= findViewById(R.id.editText_MaSo);
        EditText et_Hoten= findViewById(R.id.editText_HoTen);
        ListView lv_Nhanvien= findViewById(R.id.listView_NhanVien);
        RadioGroup rg_Gioitinh= findViewById(R.id.radiofroup);
        RadioButton rg_Nam= findViewById(R.id.radioButton_Nam);
        RadioButton rg_Nu= findViewById(R.id.radioButton_Nu);


        Spinner spinner_DonVi= findViewById(R.id.spinner_DonVi);

        dv_List= getResources().getStringArray(R.array.donvi_list);

        ArrayAdapter<String> adapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dv_List);
        spinner_DonVi.setAdapter(adapter);
        spinner_DonVi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                donvi= dv_List[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        Button bt_Them= findViewById(R.id.button_Them);
        bt_Them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int maso= Integer.parseInt(et_Maso.getText().toString());
                String hoTen= et_Hoten.getText().toString();
                String gioiTinh= ((RadioButton)findViewById(rg_Gioitinh.getCheckedRadioButtonId())).getText().toString();
                NhanVien nv= new NhanVien(maso, hoTen, gioiTinh, donvi);
                //Thêm nhân viên vào danh sách
                nv_List.add(nv);

                //Đưa danh sách nhân viên vào ListView
                ArrayList<String> listItems= new ArrayList<>();
                for(NhanVien nv1: nv_List){
                    listItems.add(nv1.toString());
                }
                ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(MainActivity.this,
                        android.R.layout.simple_list_item_1, android.R.id.text1, listItems);

                lv_Nhanvien.setAdapter(adapter1);

            }
        });

        lv_Nhanvien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                NhanVien nv= nv_List.get(i);
                //mã số là kiểu int nên +"" đằng sau nó nữa
                et_Maso.setText(nv.getMaso() + "");
                //họ tên kiểu string nên ko cần
                et_Hoten.setText(nv.getHoten());

                //Xử lý giới tính
                if(nv.getGioitinh().equals("Nam")){
                    rg_Nam.setChecked(true);
                }
                else{
                    rg_Nu.setChecked(true);
                }

                //Xử lý đơn vị
                for(int j=0; j < dv_List.length; j++){
                    if(dv_List[j].equals(nv.getGioitinh())){
                        spinner_DonVi.setSelection(j);
                    }
                }


            }
        });

    }
}