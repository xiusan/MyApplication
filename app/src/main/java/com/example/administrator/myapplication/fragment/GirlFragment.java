package com.example.administrator.myapplication.fragment;

/*
 *  项目名： Talayout
 *  包名：    com.example.administrator.myapplication.fragment
 *  文件名:   GirlFragment
 *  创建者:   xiaojinlu
 *  创建时间:  2021年2月8日21:03:27
 *  描述：    美女社区
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.myapplication.R;


public class GirlFragment extends Fragment {



    /**
     * 1.监听点击事件
     * 2.提示框
     * 3.加载图片
     * 4.PhotoView
     */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_girl, null);
        findView(view);
        return view;
    }
    //初始化View
    private void findView(View view) {

    }
}
