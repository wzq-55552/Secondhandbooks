package com.example.hasee.second_handbooks;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


public class MyApplyItemActicity extends AppCompatActivity {


        //判断申请状态碎片显示
        private int isState=1;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.acticity_myapplyitem);

            //返回键显示
            Toolbar toolbar = (Toolbar)findViewById(R.id.apc_item_toolbar);
            setSupportActionBar(toolbar);
            ActionBar actionBar = getSupportActionBar();
            if (actionBar!=null){
                actionBar.setDisplayHomeAsUpEnabled(true);
            }

            TextView apc_item_input_name=(TextView)findViewById(R.id.apc_item_input_name);
            TextView apc_item_input_location=(TextView)findViewById(R.id.apc_item_input_location);
            TextView apc_item_input_time=(TextView)findViewById(R.id.apc_item_input_time);
            TextView apc_item_input_remark=(TextView)findViewById(R.id.apc_item_input_remark);
            ImageView apc_item_input_image=(ImageView)findViewById(R.id.apc_item_input_image);

            Intent intent=getIntent();
            apc_item_input_name.setText(intent.getStringExtra("apc_item_name"));
            //apc_item_input_image.setImageResource(intent.getIntExtra("apc_item_image",123));
            apc_item_input_location.setText(intent.getStringExtra("apc_item_location"));
            apc_item_input_time.setText(intent.getStringExtra("apc_item_time"));
            apc_item_input_remark.setText(intent.getStringExtra("apc_item_remark"));

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
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()){
                case android.R.id.home://返回键功能
                    finish();
                default:
            }
            return true;
        }

}
