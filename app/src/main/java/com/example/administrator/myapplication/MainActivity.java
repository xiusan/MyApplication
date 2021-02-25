package com.example.administrator.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.administrator.myapplication.io.SharedpreFerenceActivity;
import com.example.administrator.myapplication.io.SqlliteActivity;
import com.example.administrator.myapplication.utils.L;

/**
 * 布局总控代码
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //定义xml属性
    //activityHandlerOne(handler的基本处理)
    private Button activityHandlerOne;

    //sqllite的是数据实例
    private Button textSqlLite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        activityHandlerOne = (Button) findViewById(R.id.btn_io_one);
        //这里必须添加应用事件
        activityHandlerOne.setOnClickListener(this);


        textSqlLite = (Button) findViewById(R.id.btn_sqllite);
        //这里必须添加应用事件
        textSqlLite.setOnClickListener(this);


    }
    @Override
    public void onClick(View v) {
        L.i("btn_handler_one");
        switch (v.getId()) {
            case R.id.btn_io_one:
            L.i("btn_handler_one");
            startActivity(new Intent(this, SharedpreFerenceActivity.class));
            case R.id.btn_sqllite:
            L.i("btn_sqllite");
            startActivity(new Intent(this, SqlliteActivity.class));
            break;

        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}

