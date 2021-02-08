package com.example.administrator.myapplication.fragment;

/*
 *  项目名： Talayout
 *  包名：    com.example.administrator.myapplication.fragment
 *  文件名:   ButlerFragment
 *  创建者:   xiaojinlu
 *  创建时间:  2021年2月8日21:03:27
 *  描述：    管家服务
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.administrator.myapplication.R;


public class ButlerFragment extends Fragment{

    private ListView mChatListView;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_butler, null);
        findView(view);
        return view;
    }

    //初始化View
    private void findView(View view) {


    }


}

