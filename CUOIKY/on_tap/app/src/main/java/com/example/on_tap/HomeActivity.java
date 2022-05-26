package com.example.on_tap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.on_tap.adapter.Adapter;
import com.example.on_tap.entity.Book;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private EditText edtBookName, edtAuthor;
    private Button btnSave, btnClear;
    private ListView listView;

    private Context context;
    private DatabaseReference mDatabase;

    private int lastId = 1;
    private int selectedId = 0;

    private final String TABLE_NAME = "books";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        context = this;

        mDatabase = FirebaseDatabase.getInstance().getReference();

        edtBookName = findViewById(R.id.home_edtBookName);
        edtAuthor = findViewById(R.id.home_edtAuthor);
        btnSave = findViewById(R.id.home_btnSave);
        btnClear = findViewById(R.id.home_btnClear);
        listView = findViewById(R.id.home_listView);

        layDuLieu();
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String bookName = edtBookName.getText().toString().trim();
                String author = edtAuthor.getText().toString().trim();
                if (bookName.isEmpty()) {
                    Toast.makeText(context, "Tên sách không được rỗng", Toast.LENGTH_SHORT).show();
                }
                if (author.isEmpty()) {
                    Toast.makeText(context, "Tên tác giả không được rỗng", Toast.LENGTH_SHORT).show();
                }
                if (!bookName.isEmpty() && !author.isEmpty()) {
                    saveDuLieu(bookName, author);
                }
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Book book = (Book) listView.getAdapter().getItem(i);
                selectedId = book.getId();
                edtBookName.setText(book.getTen());
                edtAuthor.setText(book.getTacGia());
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtBookName.setText("");
                edtAuthor.setText("");
                selectedId = 0;
            }
        });
    }

    public void layDuLieu() {
        List<Book> list = new ArrayList<>();
        mDatabase.child(TABLE_NAME).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for (DataSnapshot sn : snapshot.getChildren()) {
                    Book book = sn.getValue(Book.class);
                    list.add(book);
                }
                loadDuLieu(list);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void saveDuLieu(String bookName, String author) {
        Book book = new Book(bookName, author);
        if(selectedId != 0) {
            book.setId(selectedId);
        } else {
            layDuLieu();
            book.setId(lastId);
            selectedId = lastId;
        }
        mDatabase.child(TABLE_NAME).child(book.getId() + "").setValue(book);
    }

    public void loadDuLieu(List<Book> list) {
        int size = list.size();
        lastId = list.get(size - 1).getId() + 1;
        Adapter adapter = new Adapter(this, R.layout.item, list);
        listView.setAdapter(adapter);
    }

    public void deleteDuLieu(int id) {
        mDatabase.child(TABLE_NAME).child(id + "").removeValue();
    }
}