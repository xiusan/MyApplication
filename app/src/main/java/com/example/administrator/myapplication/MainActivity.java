package com.example.administrator.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.administrator.myapplication.ui.UiLinearLayout;
import com.example.administrator.myapplication.ui.UiRelativeLayoutActivity;

/**
 * 布局总控代码
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //定义xml属性
    //UiLinearLayout(线性布局)
    private Button activityLinearLayou;
    //RelativeLayout(相对布局)
    private Button activityLlinearLayou;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        activityLinearLayou = (Button) findViewById(R.id.btn_linear_layout);
        activityLinearLayou.setOnClickListener(this);
        activityLlinearLayou = (Button) findViewById(R.id.btn_relative_layout);
        activityLlinearLayou.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        System.out.println("btn_linear_layout");
        switch (v.getId()) {
            case R.id.btn_linear_layout:

                System.out.println("btn_linear_layout");
                startActivity(new Intent(this, UiLinearLayout.class));
                break;
                case R.id.btn_relative_layout:

                System.out.println("UiRelativeLayoutActivity");
                startActivity(new Intent(this, UiRelativeLayoutActivity.class));
                break;
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}

