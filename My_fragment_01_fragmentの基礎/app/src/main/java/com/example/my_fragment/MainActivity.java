package com.example.my_fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener{
    //メンバ変数
    Button button1;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(this);
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);
    }

    //Fragmentを表示する
    //引数：fragmentNumber = Fragmentの番号
    private void displayFragment(int fragmentNumber) {
        Fragment fragment;

        //引数で渡された番号のFragmentのインスタンスを作成
        switch (fragmentNumber) {
            case 1:
                fragment = new SampleFragment1();
                break;
            case 2:
                fragment = new SampleFragment2();
                break;
            default:
                return;
        }
        //FragmentTransactionを生成して処理を開始
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //レイアウトコンテナにFragmentを展開
        transaction.replace(R.id.fragment_container, fragment);
        //処理実行
        transaction.commit();
    }

    //常に別のfragmentを表示させる
    private void displayFragment_support() {
        Fragment fragment_support;

        //引数で渡された番号のFragmentのインスタンスを作成
        fragment_support = new SampleFragment3();

        //FragmentTransactionを生成して処理を開始
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //レイアウトコンテナにFragmentを展開
        transaction.replace(R.id.fragment_container_support, fragment_support);
        //処理実行
        transaction.commit();
    }


    //ボタンがクリックされたときの処理
    @Override
    public void onClick(View v) {
        if (v.equals(button1)) {
            displayFragment(1);
        } else if (v.equals(button2)) {
            displayFragment(2);
        }

        //下にfragmentを表示させる
        displayFragment_support();

    }
}