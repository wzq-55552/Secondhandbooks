package com.example.hasee.second_handbooks;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hasee.second_handbooks.BaseClass.ExchangeMessage;

import java.util.List;


//MyneedsMessageItemAdapter

public class MyneedsMessageItemAdapter extends RecyclerView.Adapter <MyneedsMessageItemAdapter.ViewHolder>{


    private Context mConext;

    private List<ExchangeMessage> mExchangeMessageList;


    static class ViewHolder extends RecyclerView.ViewHolder{

        View Messagesview;

        TextView Book_name;

        TextView time;

        TextView location;

        public ViewHolder(View view){
            super(view);
            Messagesview = view;
            Book_name = (TextView)view.findViewById(R.id.myneedsitem_bookname);
            time = (TextView)view.findViewById(R.id.myneedsitem_time);
            location = (TextView)view.findViewById(R.id.myneedsitem_location);
        }
    }

    public MyneedsMessageItemAdapter(List<ExchangeMessage> MessagesList){
        mExchangeMessageList = MessagesList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (mConext ==null){
            mConext = viewGroup.getContext();
        }
        View view = LayoutInflater.from(mConext).inflate(R.layout.myneedsitem_item,viewGroup,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.Messagesview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mConext,MyneedsItemFragment.class);
                mConext.startActivity(intent);
            }
        });
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ExchangeMessage exchangeMessage = mExchangeMessageList.get(i);
        viewHolder.Book_name.setText(exchangeMessage.getBook_name());
        viewHolder.time.setText(exchangeMessage.getTime().toString());
        viewHolder.location.setText(exchangeMessage.getLocation());
    }

    @Override
    public int getItemCount() {
        return mExchangeMessageList.size();
    }
}
