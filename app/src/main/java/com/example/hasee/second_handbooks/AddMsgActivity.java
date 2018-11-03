package com.example.hasee.second_handbooks;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class AddMsgActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_msg);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

<<<<<<< HEAD
=======
        //返回键显示
>>>>>>> 8d6fd9eb2072023c008cd541c7d407a4cfb0ec9f
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

<<<<<<< HEAD
=======
        //提交键
>>>>>>> 8d6fd9eb2072023c008cd541c7d407a4cfb0ec9f
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
<<<<<<< HEAD
            case android.R.id.home:
=======
            case android.R.id.home://返回键功能
>>>>>>> 8d6fd9eb2072023c008cd541c7d407a4cfb0ec9f
                Intent intent = new Intent(AddMsgActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
            default:
        }
        return true;
    }
}
