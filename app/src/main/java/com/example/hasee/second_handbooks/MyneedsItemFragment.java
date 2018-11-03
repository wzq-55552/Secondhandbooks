package com.example.hasee.second_handbooks;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.hasee.second_handbooks.BaseClass.ExchangeMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


//我的需求点击碎片查看信息


public class MyneedsItemFragment extends Fragment {

    Context mContext;

    private FloatingActionButton item_fab;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.myneedsitemfragment, container, false);
        item_fab = (FloatingActionButton)view.findViewById(R.id.item_fab);
        item_fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Snackbar.make(v,"联系对方？",Snackbar.LENGTH_SHORT)
                            .setAction("确定", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                   //打电话给对方，读取对方的手机号并拨打
                                    //检查是否授权check
                                    if(ContextCompat.checkSelfPermission(mContext, Manifest.permission.CALL_PHONE)
                                            != PackageManager.PERMISSION_GRANTED){//PackageManager.PERMISSION_GRANTED相等就是用户已经授权
                                        ActivityCompat.requestPermissions(getActivity(),new String[]{
                                                Manifest.permission.CALL_PHONE},1);//申请授权
                                    }else{
                                        call();
                                    }
                                }
                            }).show();
                }
            });
        return view;
    }

    private void call(){
        try{
            Intent intent = new Intent(Intent.ACTION_CALL);//自动拨号,声明权限
            intent.setData(Uri.parse("tel:10086"));//获取电话资源？？？？？？？？
            startActivity(intent);
        }catch (SecurityException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {//授权条件
                    call();
                }else{
                    Toast.makeText(mContext,"您拒绝了权限授权！",Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }


}



