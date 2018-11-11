package com.example.hasee.second_handbooks;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.hasee.second_handbooks.db.ExchangeMessage;

import java.io.InputStream;
import java.util.List;

public class APCAdapter extends RecyclerView.Adapter<APCAdapter.ViewHolder> {
    private List<ExchangeMessage>mexchangeMessageList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        View APCView;
        ImageView APCImage;
        TextView APCName;

        public ViewHolder(View view){
            super(view);
            APCView=view;
            APCImage=(ImageView)view.findViewById(R.id.apc_item_image);
            APCName=(TextView)view.findViewById(R.id.apc_item_name);
        }
    }

    public APCAdapter(List<ExchangeMessage>exchangeMessageList){
        mexchangeMessageList=exchangeMessageList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int position) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.apc_item,parent,false);
        final ViewHolder holder=new ViewHolder(view);
        holder.APCImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                ExchangeMessage exchangeMessage=mexchangeMessageList.get(position);
                Intent intent=new Intent(parent.getContext(),MyAPCItemActivity.class);
                intent.putExtra("apc_item_name",exchangeMessage.getBook_name());
                intent.putExtra("apc_item_image",exchangeMessage.getBook_image_id());
                intent.putExtra("apc_item_location",exchangeMessage.getLocation());
                intent.putExtra("apc_item_time",exchangeMessage.getTime());
                parent.getContext().startActivity(intent);
            }
        });

        holder.APCName.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                ExchangeMessage exchangeMessage=mexchangeMessageList.get(position);
                Intent intent=new Intent(parent.getContext(),MyAPCItemActivity.class);
                intent.putExtra("apc_item_name",exchangeMessage.getBook_name());
                intent.putExtra("apc_item_image",exchangeMessage.getBook_image_id());
                intent.putExtra("apc_item_location",exchangeMessage.getLocation());
                intent.putExtra("apc_item_time",exchangeMessage.getTime());
                parent.getContext().startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ExchangeMessage exchangeMessage=mexchangeMessageList.get(position);
        holder.APCImage.setImageResource(exchangeMessage.getBook_image_id());
        holder.APCName.setText(exchangeMessage.getBook_name());
    }

    @Override
    public int getItemCount() {
        return mexchangeMessageList.size();
    }
}
