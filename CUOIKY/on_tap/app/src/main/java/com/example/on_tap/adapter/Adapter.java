package com.example.on_tap.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.on_tap.HomeActivity;
import com.example.on_tap.R;
import com.example.on_tap.entity.Book;

import java.util.List;

public class Adapter extends BaseAdapter {
    private Context context;
    private int idLayout;
    private List<Book> list;

    public Adapter(Context context, int idLayout, List<Book> list) {
        this.context = context;
        this.idLayout = idLayout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(idLayout, viewGroup, false);
        }
        TextView tvBookName = view.findViewById(R.id.item_tvBookName);
        TextView tvAuthor = view.findViewById(R.id.item_tvAuthor);
        TextView tvId = view.findViewById(R.id.item_tvId);
        ImageButton imgBtnDelete = view.findViewById(R.id.item_imgBtnDelete);

        if (list != null || !list.isEmpty()) {
            Book book = list.get(i);
            tvId.setText(String.valueOf(book.getId()));
            tvBookName.setText(book.getTen());
            tvAuthor.setText(book.getTacGia());

            imgBtnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((HomeActivity) context).deleteDuLieu(book.getId());
                    ((HomeActivity) context).layDuLieu();
                }
            });
        }
        return view;
    }
}
