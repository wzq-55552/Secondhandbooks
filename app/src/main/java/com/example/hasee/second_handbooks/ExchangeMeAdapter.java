package com.example.hasee.second_handbooks;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hasee.second_handbooks.BaseClass.ExchangeMessage;

import java.util.List;

public class ExchangeMeAdapter extends RecyclerView.Adapter <ExchangeMeAdapter.ViewHolder>{

    private Context mConext;

    private List<ExchangeMessage> mExchangeMessageList;


    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;


        public ViewHolder(View view){
            super(view);
            cardView = (CardView) view;
        }
    }

    public ExchangeMeAdapter(List<ExchangeMessage> booksList){
        mExchangeMessageList = booksList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (mConext ==null){
            mConext = viewGroup.getContext();
        }
        View view = LayoutInflater.from(mConext).inflate(R.layout.message_item,viewGroup,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mConext,ExchangeMessage.class);
                mConext.startActivity(intent);
            }
        });
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ExchangeMessage exchangeMessage = mExchangeMessageList.get(i);
    }

    @Override
    public int getItemCount() {
        return mExchangeMessageList.size();
    }
}
