package com.example.hasee.second_handbooks;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter <BookAdapter.ViewHolder>{

    private Context mConext;

    private List<Book> mBookList;


    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;


        public ViewHolder(View view){
            super(view);
            cardView = (CardView) view;
        }
    }

    public BookAdapter(List<Book> booksList){
        mBookList = booksList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (mConext ==null){
            mConext = viewGroup.getContext();
        }
        View view = LayoutInflater.from(mConext).inflate(R.layout.book_item,viewGroup,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mConext,Book.class);
                mConext.startActivity(intent);
            }
        });
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Book book = mBookList.get(i);
    }

    @Override
    public int getItemCount() {
        return mBookList.size();
    }
}
