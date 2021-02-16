package com.example.administrator.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.administrator.myapplication.handler.HanderOneActivity;
import com.example.administrator.myapplication.handler.HanderTwoActivity;
import com.example.administrator.myapplication.list.ListViewActivity;
import com.example.administrator.myapplication.http.OkhttpActivity;

/**
 * 布局总控代码
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //定义xml属性
    //activityHandlerOne(handler的基本处理)
    private Button activityHandlerOne;

    private Button activityHandlerTwo;

    //进入列表button
    private Button activityListView;

    //进入列表okhttp
    private Button activityOkhttp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        activityHandlerOne = (Button) findViewById(R.id.btn_handler_one);
        //这里必须添加应用事件
        activityHandlerOne.setOnClickListener(this);

        activityHandlerTwo = (Button) findViewById(R.id.btn_handler_two);
        //这里必须添加应用事件
        activityHandlerTwo.setOnClickListener(this);
        //列表
        activityListView = (Button) findViewById(R.id.btn_list_view);
        //这里必须添加应用事件
        activityListView.setOnClickListener(this);

        //okhttp
        activityOkhttp = (Button) findViewById(R.id.btn_http_view);
        //这里必须添加应用事件
        activityOkhttp.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        System.out.println("btn_handler_one");
        switch (v.getId()) {
            case R.id.btn_handler_one:
            System.out.println("btn_handler_one");
            startActivity(new Intent(this, HanderOneActivity.class));
            break;
            case R.id.btn_handler_two:
            System.out.println("btn_handler_two");
            startActivity(new Intent(this, HanderTwoActivity.class));
            break;
            case R.id.btn_list_view:
            System.out.println("btn_handler_two");
            startActivity(new Intent(this, ListViewActivity.class));
            break;
            case R.id.btn_http_view:
            System.out.println("btn_http_view");
            startActivity(new Intent(this, OkhttpActivity.class));
            break;

        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}

