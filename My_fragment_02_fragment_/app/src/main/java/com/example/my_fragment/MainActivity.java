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

        //数独のホーム画面に移動
        Move_To_Sudoku_Home();
    }


    //--------------------------------------------------------------------------------------//
    //ホーム画面に移動する
    protected void Move_To_Sudoku_Home()
    {
        //先にサブのトレーニングの中のリターンのボタンを見つける
        Button start_sudoku = this.findViewById(R.id.button_start_sudoku);//
        start_sudoku.setOnClickListener(new View.OnClickListener(){
            @Override
            //ボタンを押したら以下のページに飛ぶ
            public void onClick(View v) {
                //数独ホームのボタンの中の
                setContentView(R.layout.sudoku_home);
                Move_To_Demo_Manual_Auto();
            }
        });
    }

    //数独ホームの3つのボタンのそれぞれのボタンに飛ぶ
    protected void Move_To_Demo_Manual_Auto()
    {
        //数独ホームのうちの(1)デモに移動する
        Button button_sub_train_to_main = this.findViewById(R.id.button_play_with_demo);//
        button_sub_train_to_main.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setContentView(R.layout.layout_play_with_demo);
                Move_To_Sudoku_Home_from_demo();
            }
        });

        //数独ホームのうちの(2)手入力に移動する
        Button play_with_manual = this.findViewById(R.id.button_play_with_manual);//
        play_with_manual.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setContentView(R.layout.layout_play_with_manual);
                Move_To_Sudoku_Home_from_manual();
            }
        });

        //数独ホームのうちの(3)カメラ入力に移動する
        Button play_with_auto = this.findViewById(R.id.button_play_with_auto);//
        play_with_auto.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setContentView(R.layout.layout_play_with_auto);
                Move_To_Sudoku_Home_from_auto();
            }
        });
    }

    //手入力からホーム画面に移動する
    protected void Move_To_Sudoku_Home_from_manual()
    {
        //下にfragmentを表示させる　さらにレイアウトさせるのか
        button_fragment_sudoku();

        //先にサブのトレーニングの中のリターンのボタンを見つける
        Button start_sudoku = this.findViewById(R.id.button_manual_to_sudoku_home);//
        start_sudoku.setOnClickListener(new View.OnClickListener(){
            @Override
            //ボタンを押したら以下のページに飛ぶ
            public void onClick(View v) {
                //数独ホームのボタンの中の
                setContentView(R.layout.sudoku_home);
                Move_To_Demo_Manual_Auto();
            }
        });
    }

    //手入力からホーム画面に移動する
    protected void Move_To_Sudoku_Home_from_auto()
    {
        //下にfragmentを表示させる　さらにレイアウトさせるのか
        button_fragment_sudoku();

        //先にサブのトレーニングの中のリターンのボタンを見つける
        Button start_sudoku = this.findViewById(R.id.button_auto_to_sudoku_home);//
        start_sudoku.setOnClickListener(new View.OnClickListener(){
            @Override
            //ボタンを押したら以下のページに飛ぶ
            public void onClick(View v) {
                //数独ホームのボタンの中の
                setContentView(R.layout.sudoku_home);
                Move_To_Demo_Manual_Auto();
            }
        });
    }

    //デモからホーム画面に移動する
    protected void Move_To_Sudoku_Home_from_demo()
    {



        //下にfragmentを表示させる　さらにレイアウトさせるのか
        button_fragment_sudoku();//フラグメント処理


        //先にサブのトレーニングの中のリターンのボタンを見つける
        Button start_sudoku = this.findViewById(R.id.button_demo_to_sudoku_home);//
        start_sudoku.setOnClickListener(new View.OnClickListener(){
            @Override
            //ボタンを押したら以下のページに飛ぶ
            public void onClick(View v) {
                //数独ホームのボタンの中の
                setContentView(R.layout.sudoku_home);
                Move_To_Demo_Manual_Auto();
            }
        });
    }
    //--------------------------------------------------------------------------------------//


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
        fragment_support = new SampleFragment3();//Javaのクラスとつながっている

        //FragmentTransactionを生成して処理を開始
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //レイアウトコンテナにFragmentを展開
        transaction.replace(R.id.fragment_container_support, fragment_support);
        //処理実行
        transaction.commit();
    }

    //ボタン数独のフラグメントを作成
    private void button_fragment_sudoku() {
        Fragment fragment_button_sudoku;

        //引数で渡された番号のFragmentのインスタンスを作成
        //クラスを引用 javaクラスから生成させる
        fragment_button_sudoku = new java_fragment_button_sudoku_manual();

        //FragmentTransactionを生成して処理を開始
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        //レイアウトコンテナにFragmentを展開
        //transaction.replace(R.id.fragment_button_sudoku, fragment_button_sudoku);

        //レイアウトコンテナにFragmentを展開
        transaction.replace(R.id.fragment_button_sudoku, fragment_button_sudoku);

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