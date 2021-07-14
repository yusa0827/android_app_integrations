package com.example.counterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int i = 0;//カウンター

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    //カウントボタン
    //ボタンをクリックしたら実行されるように activity_main.xmlに設定する
    public void onCount(View v){
        TextView t = findViewById(R.id.textView);
        i++;
        t.setText(""+ i);//数値 ⇒ 文字列
    }

    //リセットボタン
    public void onReset(View v){
        TextView t = findViewById(R.id.textView);
        i = 0;
        t.setText(""+ i);//数値 ⇒ 文字列
    }

}
