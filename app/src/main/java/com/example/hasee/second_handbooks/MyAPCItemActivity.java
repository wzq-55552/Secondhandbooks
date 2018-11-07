package com.example.hasee.second_handbooks;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAPCItemActivity extends AppCompatActivity implements View.OnClickListener{

    //判断申请状态碎片显示
    private int isState=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_apcitem);
        Button back_button=(Button)findViewById(R.id.apc_item_back_button);
        back_button.setOnClickListener(this);

        TextView apc_item_input_name=(TextView)findViewById(R.id.apc_item_input_name);
        TextView apc_item_input_location=(TextView)findViewById(R.id.apc_item_input_location);
        TextView apc_item_input_time=(TextView)findViewById(R.id.apc_item_input_time);
        ImageView apc_item_input_image=(ImageView)findViewById(R.id.apc_item_input_image);

        Intent intent=getIntent();
        apc_item_input_name.setText(intent.getStringExtra("apc_item_name"));
        apc_item_input_image.setImageResource(intent.getIntExtra("apc_item_image",123));
        apc_item_input_location.setText(intent.getStringExtra("apc_item_location"));
        apc_item_input_time.setText(intent.getStringExtra("apc_item_time"));

        if(isState==1){
            replaceFragment(new State_1_Fragment());
        }else if(isState==2){
            replaceFragment(new State_2_Fragment());
        }

    }

    private void replaceFragment(Fragment fragment1){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.apc_item_state_fragment,fragment1);
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.apc_item_back_button:
                this.finish();
                break;
            default:
                break;
        }
    }
}
