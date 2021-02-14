package com.example.administrator.myapplication.handler;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

import java.util.ArrayList;
import java.util.List;

/**
     * @ClassName HanderOneActivity
     * @Author xiaojinlu1990@163.com
     * @Date 时间
     * @Description  列表展示
     * @Version 1.0.0
     */
public class ListViewActivity extends AppCompatActivity {
    /**
     * 步奏
     * 1 在layout创建ListView （activity_list_view.xml）
     * 2 创建每一行layout （activity_app_list.xml）
     * 3 对应创建每一行数据
     * 4 adapter数据填充到每一行
     *  */
    private ListView mListView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //创建控件空间
        setContentView(R.layout.activity_list_view);
        mListView = (ListView) findViewById(R.id.set_list_view_id);
        //创建数据
        List<String> infos = getAppListString();
        mListView.setAdapter(new AppListAdapter(infos));
        //定义事假
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("000000000000000000000000000");
                Toast.makeText(getApplicationContext(), "id="+id,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private List<String> getAppListString() {
        List<String> list = new ArrayList<>();
        list.add("app_name1");
        list.add("app_name2");
        list.add("app_name3");
        list.add("app_name4");
        list.add("app_name4");


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

        private List<String> mInfos;
        //构造函数
        public AppListAdapter( List<String> infos) {
            mInfos = infos;
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
            textView.setText(mInfos.get(position));

            return convertView;
        }
    }
}
