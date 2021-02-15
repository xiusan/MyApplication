package com.example.administrator.myapplication.handler;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.entity.FirstData;
import com.example.administrator.myapplication.utils.L;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
     * @ClassName HanderOneActivity
     * @Author xiaojinlu1990@163.com
     * @Date 时间
     * @Description  列表展示
     * @Version 1.0.0
     */
public class ListViewActivity extends AppCompatActivity {

    private static final String TAG = "ListViewActivity";
    /**
     * 步奏
     * 1 在layout创建ListView （activity_list_view.xml）
     * 2 创建每一行layout （activity_app_list.xml）
     * 3 对应创建每一行数据
     * 4 adapter数据填充到每一行
     *  */
    private ListView mListView;

    private final OkHttpClient mClient = new OkHttpClient();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //创建控件空间
        setContentView(R.layout.activity_list_view);
        mListView = (ListView) findViewById(R.id.set_list_view_id);
        //创建数据
        List<FirstData> infos = getAppListString();
        mListView.setAdapter(new AppListAdapter(null,infos));
        //定义事件
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                {
                    final String url = "http://v.juhe.cn/toutiao/index?type=shishang&key="+"5c1df2ef1f0dda4edeb0c23b33621bc6";
                     
                       // String json = get(url);
                        //解析json
                        
                        //System.out.println(s);

                    


                }

            }
        });
    }

    private List<FirstData> getAppListString() {
        final String url = "http://v.juhe.cn/toutiao/index?type=shishang&key="+"5c1df2ef1f0dda4edeb0c23b33621bc6";

        List<FirstData> list = null;
        try {
            String json = get(url);
            //解析json
          list = parsingJson(json);

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return list;

    }

    private List<FirstData>  parsingJson(String json)   {
        List<FirstData> list = new ArrayList<>();
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(json);

            JSONObject result = jsonObject.getJSONObject("result");
            JSONArray data = result.getJSONArray("data");
            for (int i=0; i<data.length();i++){
                FirstData firstData = new FirstData();
                JSONObject jsonSon = (JSONObject)data.get(i);
                firstData.setTitle(jsonSon.getString("title"));
                firstData.setUrl(jsonSon.getString("url"));
                firstData.setAuthorName(jsonSon.getString("author_name"));
                firstData.setThumbnailPicS(jsonSon.getString("thumbnail_pic_s"));
                firstData.setUniquekey(jsonSon.getString("uniquekey"));
                list.add(firstData);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    return list;
    }

    private List<ResolveInfo> getAppInfos() {
        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        return getPackageManager().queryIntentActivities(mainIntent, 0);
    }

    /**
     *
     * 创建list对象
     *
     */

    public class AppListAdapter extends BaseAdapter{

        private Context context;
        private LayoutInflater inflater;
        private  List<FirstData> mInfos;
        //构造函数
        public AppListAdapter(Context context,  List<FirstData> infos) {
            this.context = context;
            this.mInfos = infos;
          //  inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return mInfos.size();
        }

        @Override
        public Object getItem(int position) {
            return mInfos.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            //获取系统服务
            LayoutInflater layoutInflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //引入数据
            convertView = layoutInflater.inflate(R.layout.activity_app_list, null);
            // 获取控件
            TextView textView= (TextView) convertView.findViewById(R.id.app_name_message);
            ImageView imageView = (ImageView) convertView.findViewById(R.id.icon_image_view);
            //渲染数据
            FirstData firstData = mInfos.get(position);
            textView.setText(firstData.getTitle());
            imageView.setImageBitmap(getBitmap(firstData.getThumbnailPicS()));
            return convertView;
        }
    }

    private String get(final String url) throws ExecutionException, InterruptedException {
        String urlStr = null;
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Object> submit = executor.submit(new Callable<Object>() {
            @Override
            public Object call() {
                String string = null;
                Request.Builder builder = new Request.Builder();
                builder.url(url);
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
        return urlStr;
    }
    public Bitmap getBitmap(final String url) {
        L.i("getBitmap="+url);
         Bitmap bm = null;
        final ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Object> submit = executor.submit(new Callable<Object>() {
            @Override
            public Object call() {
                Bitmap bmm = null;
                try {
                    URL iconUrl = new URL(url);
                    URLConnection conn = iconUrl.openConnection();
                    HttpURLConnection http = (HttpURLConnection) conn;

                    int length = http.getContentLength();

                    conn.connect();
                    // 获得图像的字符流
                    InputStream is = conn.getInputStream();
                    BufferedInputStream bis = new BufferedInputStream(is, length);
                    bmm = BitmapFactory.decodeStream(bis);
                    bis.close();
                    is.close();// 关闭流
                } catch (Exception e) {
                    e.printStackTrace();
                }

                return bmm;
            }
        });

        executor.shutdown();
        try {
            bm = (Bitmap) submit.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return bm;
    }
}
