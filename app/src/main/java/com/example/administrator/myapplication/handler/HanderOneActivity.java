package com.example.administrator.myapplication.handler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.utils.L;

/**
     * @ClassName HanderOneActivity
     * @Author xiaojinlu1990@163.com
     * @Date 时间
     * @Description  子线程处理耗时操作，结束更新主线程，监听操作
     * @Version 1.0.0
     */
public class HanderOneActivity extends AppCompatActivity {
    /**
     * 步奏
     * 1 新建ui视图
     * 2 创建handler处理
     * 3 创建子线程操作
     * 4 主线程监听
     *  */
    private Button baseHandlerOneId;
    private TextView textViewHandlerOneId;


    //Message
    private  int sendMessage = 2001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hander_one);

        final Handler  handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                L.d("处理接受message信息");
                super.handleMessage(msg);
                if(msg.what == sendMessage){
                    //这里必须是String类型，俗称
                    // 字符串
                    textViewHandlerOneId.setText(sendMessage+"");
                }
            }
        };

        initView(handler);
        initData();
    }



    private void initView(final Handler handler) {
        textViewHandlerOneId = (TextView) findViewById(R.id.text_view_handler_one);

        baseHandlerOneId = (Button) findViewById(R.id.base_handler_one);
        //这里必须添加应用事件
        baseHandlerOneId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L.d("base_handler_one");
                new  Thread(new Runnable() {
                    @Override
                    public void run() {
                        handler.sendEmptyMessage(sendMessage);
                        // textViewHandlerOneId.setText("异步处理完成");
                    }
                }).start();
            }
        });


    }

    private void initData() {

    }


}
