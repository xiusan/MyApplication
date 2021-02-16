package com.example.administrator.myapplication.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.utils.L;

import okhttp3.OkHttpClient;

/**
     * @ClassName ListViewDetailsActivity
     * @Author xiaojinlu1990@163.com
     * @Date 时间
     * @Description  列表展示详情使用webView
     * @Version 1.0.0
     */
public class ListViewDetailsActivity extends AppCompatActivity {

    private static final String TAG = "ListViewDetailsActivity";
    /**
     * 步奏
     * 1
     *  */
    private ProgressBar mProgressBar;
    private WebView mWebView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //创建控件空间
        setContentView(R.layout.activity_list_view_details);
        initView();
    }
    //初始化View
    private void initView() {
        mProgressBar = (ProgressBar) findViewById(R.id.mProgressBar);
        mWebView = (WebView) findViewById(R.id.mWebView);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        final String url = intent.getStringExtra("url");
        L.i("url"+url);
        //设置标题
        getSupportActionBar().setTitle(title);

//进行加载网页的逻辑

        //支持JS
        mWebView.getSettings().setJavaScriptEnabled(true);
        //支持缩放
        mWebView.getSettings().setSupportZoom(true);
        mWebView.getSettings().setBuiltInZoomControls(true);
        //接口回调
        mWebView.setWebChromeClient(new WebViewClient());
        //加载网页
        mWebView.loadUrl(url);

        //本地显示
        mWebView.setWebViewClient(new android.webkit.WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(url);
                //我接受这个事件
                return true;
            }
        });
    }

    public class WebViewClient extends WebChromeClient {

        //进度变化的监听
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            if(newProgress == 100){
                mProgressBar.setVisibility(View.GONE);
            }
            super.onProgressChanged(view, newProgress);
        }
    }

}
