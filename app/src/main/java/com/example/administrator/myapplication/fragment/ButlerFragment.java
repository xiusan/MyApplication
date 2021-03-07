package com.example.administrator.myapplication.fragment;

/*
 *  项目名： Talayout
 *  包名：    com.example.administrator.myapplication.fragment
 *  文件名:   ButlerFragment
 *  创建者:   xiaojinlu
 *  创建时间:  2021年2月8日21:03:27
 *  描述：    管家服务
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.recycler.RecyclerActivity;

public class ButlerFragment extends Fragment  {

    private ListView mChatListView;
    private Button butLinelist;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_butler, null);
        findView(view);
        return view;
    }

    //初始化View
    private void findView(View view) {

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
        butLinelist = (Button)getActivity().findViewById(R.id.but_line_list);
        butLinelist.setOnClickListener(new View.OnClickListener() {
        //跳转到RecyclerView
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                startActivity(new Intent(getContext(), RecyclerActivity.class));
            }
        });
    }


}


