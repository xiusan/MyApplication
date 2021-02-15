package com.example.administrator.myapplication.http;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


import com.example.administrator.myapplication.R;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class OkhttpActivity  extends AppCompatActivity {
    private static final String TAG = "OkhttpActivity";

    private static final MediaType MEDIA_TYPE_MARKDOWN
            = MediaType.parse("text/x-markdown; charset=utf-8");

    private static final String POST_URL = "https://api.github.com/markdown/raw";

    private final OkHttpClient mClient = new OkHttpClient();
    private TextView mContentTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_view);
        mContentTextView = (TextView) findViewById(R.id.tvContent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuGet:
                try {
                    get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.menuResponse:
                response();
                break;
            case R.id.menuPost:
                post();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void post() {
        Request.Builder builder = new Request.Builder();
        builder.url(POST_URL);
        builder.post(RequestBody.create(MEDIA_TYPE_MARKDOWN, "Hello world git #1 **ma**, and ### 1"));
        Request request = builder.build();
        Call call = mClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String content = response.body().string();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mContentTextView.setText(content);
                        }
                    });
                }
            }
        });
    }

    private void response() {
        Request.Builder builder = new Request.Builder();
        builder.url("https://github.com/xiusan/MyApplication/blob/master/README.md");
        Request request = builder.build();
        Call call = mClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure() called with: call = [" + call + "], e = [" + e + "]");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d(TAG, "onResponse() called with: call = [" + call + "], response = [" + response + "]");
                int code = response.code();
                Headers headers = response.headers();
                String content = response.body().string();
                final StringBuilder buf = new StringBuilder();
                buf.append("code: " + code);
                buf.append("\nHeaders: \n" + headers);
                buf.append("\nbody: \n" + content);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mContentTextView.setText(buf.toString());
                    }
                });
            }
        });
    }

    private void get() throws ExecutionException, InterruptedException {
        String urlStr = null;
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Object> submit = executor.submit(new Callable<Object>() {
            @Override
            public Object call() {
                  String string = null;
                        Request.Builder builder = new Request.Builder();
                builder.url("https://github.com/xiusan/MyApplication/blob/master/README.md");
                Request request = builder.build();
                Log.d(TAG, "run: " + request);
                Call call = mClient.newCall(request);
                try {
                    Response response = call.execute();
                    if (response.isSuccessful()) {
                        string = response.body().string();
                        final String finalString = string;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mContentTextView.setText(finalString);
                            }
                        });
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return string;
            }
        });
        urlStr = (String) submit.get();

        executor.shutdown();

    }
}
