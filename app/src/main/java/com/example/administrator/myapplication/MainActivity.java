package com.example.administrator.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.administrator.myapplication.io.ExternalStorageActivity;
import com.example.administrator.myapplication.io.SharedpreFerenceActivity;
import com.example.administrator.myapplication.utils.L;

/**
 * 布局总控代码
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //定义xml属性
    //activityHandlerOne(handler的基本处理)
    private Button activityHandlerOne,activityExternalStorage;

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

        //外部存储
        activityExternalStorage = (Button) findViewById(R.id.external_storage);
        //这里必须添加应用事件
        activityExternalStorage.setOnClickListener(this);


    }
    @Override
    public void onClick(View v) {
        L.i("btn_handler_one");
        switch (v.getId()) {
            case R.id.btn_io_one:
            L.i("btn_handler_one");
            startActivity(new Intent(this, SharedpreFerenceActivity.class));
            break;
            case R.id.external_storage:
            L.i("btn_handler_one");
            startActivity(new Intent(this, ExternalStorageActivity.class));
            break;

        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}

