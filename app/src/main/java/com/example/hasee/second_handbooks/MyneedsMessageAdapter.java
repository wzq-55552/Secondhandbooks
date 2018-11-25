package com.example.hasee.second_handbooks;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.hasee.second_handbooks.db.ExchangeMessage;

import java.util.List;

//MyneedsMessageAdapter

public class MyneedsMessageAdapter extends RecyclerView.Adapter <RecyclerView.ViewHolder> {

    private static final int TYPE_ITEM = 0;
    private static final int TYPE_FOOTER = 1;
    public boolean isLoadMore = false;


    private Context mContext;

    private List<ExchangeMessage> mExchangeMessageList;


    static class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;

        //ImageView Book_img;

        TextView Book_name;

        TextView Change_time;

        TextView Change_location;

        public ViewHolder(View view) {
            super(view);
            cardView = (CardView) view;
            Book_name = (TextView) view.findViewById(R.id.Book_name);
            //Book_img = (ImageView)view.findViewById(R.id.Book_img);
            Change_time = (TextView) view.findViewById(R.id.Change_time);
            Change_location = (TextView) view.findViewById(R.id.Change_location);
        }
    }

    public MyneedsMessageAdapter(List<ExchangeMessage> MessagesList) {
        mExchangeMessageList = MessagesList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (mContext == null) {
            mContext = viewGroup.getContext();
        }


        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(-1, -2);
        if (i == TYPE_ITEM) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.myneedsmessage_item, viewGroup, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                //ExchangeMessage message = mExchangeMessageList.get(position);
                Intent intent = new Intent(mContext, MyneedsItemActivity.class);
                //intent.putExtra(MyneedsItemActivity.MESSAGE_BOOKNAME,message.getBook_name());
                //intent.putExtra(MyneedsItemActivity.MESSAGE_TIME,message.getTime());
                //intent.putExtra(MyneedsItemActivity.MESSAGE_LOCATION,message.getLocation());
                //intent.putExtra(MyneedsItemActivity.MESSAGE_REMARK,message.getRemark());
                mContext.startActivity(intent);
            }
        });

        return holder;
        }


        final ProgressBar bar = new ProgressBar(mContext);
        bar.setLayoutParams(lp);
        ProgressViewHoler barViewHolder = new ProgressViewHoler(bar);
        return barViewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof ViewHolder) {
            ExchangeMessage exchangeMessage = mExchangeMessageList.get(i);
            //viewHolder.Book_img.setImageResource(exchangeMessage.getBook_image_id());
            ((ViewHolder)viewHolder).Book_name.setText(exchangeMessage.getBook_name());
            ((ViewHolder)viewHolder).Change_time.setText(exchangeMessage.getTime());
            ((ViewHolder)viewHolder).Change_location.setText(exchangeMessage.getLocation());
        }
    }

    @Override
    public int getItemCount() {
        if (isLoadMore) {
            return mExchangeMessageList.size() + 1;
        }
        return mExchangeMessageList.size();
    }


    @Override
    public int getItemViewType(int position) {
        if (position + 1 == getItemCount() && isLoadMore) {
            return TYPE_FOOTER;
        }
        return TYPE_ITEM;
    }


    public static class ProgressViewHoler extends RecyclerView.ViewHolder {
        public ProgressBar bar;

        public ProgressViewHoler(View itemView) {
            super(itemView);
            bar = (ProgressBar) itemView;
        }
    }


    /*public void addItem(List<ExchangeMessage> newDatas) {
        newDatas.addAll(mExchangeMessageList);
        mExchangeMessageList.removeAll(mExchangeMessageList);
        mExchangeMessageList.addAll(newDatas);
        notifyDataSetChanged();
    }*/

    public void addMoreItem(List<ExchangeMessage> newData) {
        mExchangeMessageList.addAll(newData);
        isLoadMore = false;
        notifyDataSetChanged();
    }

    public void startLoad() {
        isLoadMore = true;
        notifyDataSetChanged();
    }



}


