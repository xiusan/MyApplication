package com.example.administrator.myapplication.io;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.myapplication.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class InternalStorageActivity extends AppCompatActivity {

    EditText edt;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage);

        edt = findViewById(R.id.edit_text);
        txt = findViewById(R.id.textView);
    }

    public void operate(View v){

        //  data/data/包名/files
        //   getCacheDir()    data/data/包名/cache
        File f = new File(getFilesDir(),"getFilesDirs.txt");
        switch (v.getId()){
            case R.id.save_btn:
                try {
                    if (!f.exists()) {
                        f.createNewFile();
                    }
                    FileOutputStream fos = new FileOutputStream(f);
                    fos.write(edt.getText().toString().getBytes());
                    fos.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
                break;
            case R.id.read_btn:
                try {
                    FileInputStream fis = new FileInputStream(f);
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
