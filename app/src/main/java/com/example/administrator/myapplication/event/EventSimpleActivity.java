package com.example.administrator.myapplication.event;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.utils.L;

/**
 * 简单的事件监听
 * */

public class EventSimpleActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_simple);
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
                PublisherDialogFragment fragment = new  PublisherDialogFragment();
                //实现监听
                fragment.setEventListener(new PublisherDialogFragment.OnEventListener(){
                    @Override
                    public void onSuccess() {
                        setImageSrc(R.drawable.ic_sentiment);
                    }

                    @Override
                    public void onFailure() {
                        setImageSrc(R.drawable.ic_sad);
                    }
                });
                fragment.show(getSupportFragmentManager(),"SubscriberSimple");
            }
        });
    }
    private void setImageSrc(int resId) {
        final ImageView imageView = (ImageView) findViewById(R.id.emotionImageView);
        imageView.setImageResource(resId);
    }

}
