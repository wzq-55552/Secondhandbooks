package com.example.hasee.second_handbooks;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MyFragment01 extends Fragment {

    Context mContext;


    private Book[] books = {
            new Book("Android")
    };

    private List<Book> booksList = new ArrayList<>();

    private BookAdapter adapter;

    private SwipeRefreshLayout swipeRefreshLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment01, container, false);

        initBooks();

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, true);//每一行有1个元素
        recyclerView.setLayoutManager(layoutManager);
        adapter = new BookAdapter(booksList);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private void initBooks(){//随机存入数据
        booksList.clear();
        for (int i = 0; i < 80; i++) {
            Random random = new Random();
            int index = random.nextInt(books.length);
            booksList.add(books[index]);
        }
    }


}



