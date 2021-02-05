package com.example.administrator.myapplication.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.myapplication.R;

/**
 * https://www.runoob.com/w3cnote/android-tutorial-relativelayout.html
 * @ClassName UiRelativeLayoutActivity
 * @Author xiaojinlu
 * @Date 20210205:11:16
 * @Description RelativeLayout(相对布局)
 * @Version 1.0.0
 */
public class UiRelativeLayoutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_layout);
        initView();
    }

    private void initView() {

    }
}
