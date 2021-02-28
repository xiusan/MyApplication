package com.example.administrator.myapplication.event;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.utils.L;

/**
 * 本地广播事件监听
 * */

public class EventLocalListenerActivity extends AppCompatActivity {


    public  static final String HANDLE_EVENT_ACTION = "handle_event_action";
    public  static final String STATUS_KEY = "status";
    //实例化广播接收者
    private final BroadcastReceiver mReceiver = new BroadcastReceiver(){
        @Override
        public void onReceive(Context context, Intent intent) {
            final String action = intent.getAction();
            if (HANDLE_EVENT_ACTION.equals(action)){
                final boolean booleanExtra = intent.getBooleanExtra(STATUS_KEY, false);
                if(booleanExtra){
                    setImageSrc(R.drawable.ic_sentiment);
                } else {
                    setImageSrc(R.drawable.ic_sad);
                }

            }
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        //设置本地监听
        IntentFilter filter = new IntentFilter(HANDLE_EVENT_ACTION);
        LocalBroadcastManager.getInstance(this)
                .registerReceiver(mReceiver,filter);
    }
    //销毁本地广播实例
    @Override
    protected void onStop() {
        super.onStop();
        LocalBroadcastManager.getInstance(this)
                .unregisterReceiver(mReceiver);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_lisener);
//        setTitle("Subscriber");
//
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 发布方 Display dialog fragment (publisher)
                L.i("demo");
                PublisherLocalListenerDialogFragment fragment = new  PublisherLocalListenerDialogFragment();

                fragment.show(getSupportFragmentManager(),"SubscriberSimple");
            }
        });

    }
    private void setImageSrc(int resId) {
        final ImageView imageView = (ImageView) findViewById(R.id.emotionImageView);
        imageView.setImageResource(resId);
    }

}
