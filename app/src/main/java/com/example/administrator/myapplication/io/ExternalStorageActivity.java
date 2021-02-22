package com.example.administrator.myapplication.io;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.example.administrator.myapplication.R;


public class ExternalStorageActivity extends AppCompatActivity {

    EditText infoEdt;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_storage);

        infoEdt = findViewById(R.id.info_edt);
        txt = findViewById(R.id.textView);
        //获取写入权限这里会弹窗 选择 allow
        int permisson = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        //PackageManager.PERMISSION_GRANTED  权限是否被获取
        if(permisson!=PackageManager.PERMISSION_GRANTED){
            //动态去申请权限
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
        }

    }
    //被获取权限处理
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 1){
            //要处理的
        }
    }

    public void operate(View v){
        //通过环境对象获取跟目录
        String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Download/xjl.txt";
        //私有目录类型
        //   {@link #DIRECTORY_MUSIC}, {@link #DIRECTORY_PODCASTS},
//     {@link #DIRECTORY_RINGTONES}, {@link #DIRECTORY_ALARMS},
//     {@link #DIRECTORY_NOTIFICATIONS}, {@link #DIRECTORY_PICTURES},
//     {@link #DIRECTORY_MOVIES}, {@link #DIRECTORY_DOWNLOADS},
//     {@link #DIRECTORY_DCIM}, or {@link #DIRECTORY_DOCUMENTS}. May not be null.
        File externalFilesDir = super.getExternalFilesDir(Environment.DIRECTORY_MUSIC);
        // 私用目录缓存
        File externalCacheDir = super.getExternalCacheDir();

        Log.e("TAG",path+",externalFilesDir="+externalFilesDir+",externalCacheDir="+externalCacheDir);

        //if(Environment.getExternalStorageState().equals("mounted"))
        switch (v.getId()){
            case R.id.save_btn:
                File f = new File(path);
                try {
                    if (!f.exists()) {
                        f.createNewFile();
                    }
                    //追加内容 true  默认不追加
                    FileOutputStream fos = new FileOutputStream(path,true);
                    String str = infoEdt.getText().toString();
                    fos.write(str.getBytes());
                }catch (IOException ioe){
                    ioe.printStackTrace();
                }
                break;
            case R.id.read_btn:
                try {
                    FileInputStream fis = new FileInputStream(path);
                    byte[] b = new byte[1024];
                    int len = fis.read(b);
                    String str2 = new String(b,0,len);
                    txt.setText(str2);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

}
