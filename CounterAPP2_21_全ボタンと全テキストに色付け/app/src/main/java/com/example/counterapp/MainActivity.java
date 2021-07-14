package com.example.counterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;

import android.widget.EditText;
import android.text.SpannableStringBuilder;
public class MainActivity extends AppCompatActivity {

    public int[][] s = new int[10][10];//すべて 0 が格納

    int i = 0;//カウンター

    /*
    *
-------------
|   |   | 87|
|   |   |   |
|  1|23 |   |
-------------
|  2|  4|   |
|  3|   |5  |
|   |8 5| 6 |
-------------
|   | 1 |3  |
|8  |  7|   |
|6  |   |   |
-------------
elapsed time = 53 msec.

-------------
|326|951|487|
|958|746|132|
|471|238|695|
-------------
|562|394|871|
|783|162|549|
|194|875|263|
-------------
|247|619|358|
|835|427|916|
|619|583|724|
-------------
    *
    * */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup rg1 = (RadioGroup) findViewById(R.id.radio_group);
        rg1.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb1 = (RadioButton) findViewById(checkedId);
                if (rb1.isChecked()) {
                    Toast.makeText(
                            MainActivity.this,
                            ((RadioButton) findViewById(checkedId)).getText()
                                    + "を選択しました。", Toast.LENGTH_LONG).show();
                }
            }
        });


    }


    //数独の表を初期化する
    public void initial_sudoku_table(View v){
        //初期値の代入
        for (int tate_ = 1; tate_ <= 9; tate_++) {
            for (int yoko_ = 1; yoko_ <= 9; yoko_++) {
                s[tate_][yoko_] = 0;
            }
        }

        //ラジオボタンを0に初期化
        RadioGroup group = (RadioGroup)findViewById(R.id.radio_group);
        group.check(R.id.radioButton0_delete);


        ///*
        onCount_1_1(v);
        onCount_1_2(v);
        onCount_1_3(v);
        onCount_1_4(v);
        onCount_1_5(v);
        onCount_1_5(v);
        onCount_1_6(v);
        onCount_1_7(v);
        onCount_1_8(v);
        onCount_1_9(v);
        onCount_2_1(v);
        onCount_2_2(v);
        onCount_2_3(v);
        onCount_2_4(v);
        onCount_2_5(v);
        onCount_2_6(v);
        onCount_2_7(v);
        onCount_2_8(v);
        onCount_2_9(v);
        onCount_3_1(v);
        onCount_3_2(v);
        onCount_3_3(v);
        onCount_3_4(v);
        onCount_3_5(v);
        onCount_3_6(v);
        onCount_3_7(v);
        onCount_3_8(v);
        onCount_3_9(v);
        onCount_4_1(v);
        onCount_4_2(v);
        onCount_4_3(v);
        onCount_4_4(v);
        onCount_4_5(v);
        onCount_4_6(v);
        onCount_4_7(v);
        onCount_4_8(v);
        onCount_4_9(v);
        onCount_5_1(v);
        onCount_5_2(v);
        onCount_5_3(v);
        onCount_5_4(v);
        onCount_5_5(v);
        onCount_5_6(v);
        onCount_5_7(v);
        onCount_5_8(v);
        onCount_5_9(v);
        onCount_6_1(v);
        onCount_6_2(v);
        onCount_6_3(v);
        onCount_6_4(v);
        onCount_6_5(v);
        onCount_6_6(v);
        onCount_6_7(v);
        onCount_6_8(v);
        onCount_6_9(v);
        onCount_7_1(v);
        onCount_7_2(v);
        onCount_7_3(v);
        onCount_7_4(v);
        onCount_7_5(v);
        onCount_7_6(v);
        onCount_7_7(v);
        onCount_7_8(v);
        onCount_7_9(v);
        onCount_8_1(v);
        onCount_8_2(v);
        onCount_8_3(v);
        onCount_8_4(v);
        onCount_8_5(v);
        onCount_8_6(v);
        onCount_8_7(v);
        onCount_8_8(v);
        onCount_8_9(v);
        onCount_9_1(v);
        onCount_9_2(v);
        onCount_9_3(v);
        onCount_9_4(v);
        onCount_9_5(v);
        onCount_9_6(v);
        onCount_9_7(v);
        onCount_9_8(v);
        onCount_9_9(v);

         //*/

    }

    public void demo_set(View v){

        //デモの数独初期化
        s[1][8]=8;
        s[1][9]=7;

        s[3][3]=1;
        s[3][4]=2;
        s[3][5]=3;

        s[4][3]=2;
        s[4][6]=4;

        s[5][3]=3;
        s[5][7]=5;

        s[6][4]=8;
        s[6][6]=5;
        s[6][8]=6;

        s[7][5]=1;
        s[7][7]=3;

        s[8][1]=8;
        s[8][6]=7;

        s[9][1]=6;


        //
    }

    //数独を解析させるプログラム
    public void let_us_solve(View v) {

        //数独クラスのインスタンス生成
        Sudoku_Class sudoku_ = new Sudoku_Class();

        //初期値の代入
        for (int tate_ = 1; tate_ <= 9; tate_++) {
            for (int yoko_ = 1; yoko_ <= 9; yoko_++) {
                sudoku_.s[tate_][yoko_] = s[tate_][yoko_];
            }
        }

        for(int loop_times = 1; loop_times<= 20; loop_times++) {

            //数独を初期化 全体の特徴マップの変数を初期化する
            sudoku_.initilize_bool_num_3N_and_feature_map_2N();
            //各番号において　0と1に分ける　0存在しない　1存在する可能性がある
            for (int number_ = 1; number_ <= 9; number_++) {
                //N番目の特徴マップ 既存の値とかぶっていたら 0に変更
                sudoku_.Nth_0_1_checker(number_);
                // 3*3エリア内に縦・横のみに1がある場合に他の縦・横を消去
                sudoku_.special_delete_ver2(number_);
            }


            //3次元特徴bool_num_ を2次元特徴にf_mapに加算する
            sudoku_.decliment_3N_to_2N();

            //それぞれの特徴量マップの3*3のマスの中に1があったら定数に変化
            for (int number_ = 1; number_ <= 9; number_++) {
                //それぞれの特徴量マップの3*3のマスの中に1があったら定数に変化
                sudoku_.change_1_to_number_in_3_3_blocks(number_);
            }

            //全体の特徴量マップの中に1があったら定数に変化
            sudoku_.find_1_in_each_f_map();

            //マップの和が0だとbreak
            if (sudoku_.f_map_sum == 0) {

                Log.d("onClick",loop_times+"回目まで解析しました");//runに残る


                //初期値の代入
                for (int tate_ = 1; tate_ <= 9; tate_++) {
                    for (int yoko_ = 1; yoko_ <= 9; yoko_++) {
                        //sudoku_.s[tate_][yoko_] = s[tate_][yoko_];
                        s[tate_][yoko_] = sudoku_.s[tate_][yoko_];
                    }
                }

                //数独表を表示している
                //1 入力して見てください
                //2 こちらの表で合っていますか？
                //3 解析が終了しました
                TextView t = findViewById(R.id.textView_state);
                t.setText("3 解析が終了しました");

                break;
            }
        }

    }



    public void radio_ground_id_X_(TextView t_, int[][] s, int tate, int yoko){
        // ラジオグループのオブジェクトを取得
        RadioGroup rg = (RadioGroup)findViewById(R.id.radio_group);

        // チェックされているラジオボタンの ID を取得
        int id = rg.getCheckedRadioButtonId();

        // チェックされているラジオボタンオブジェクトを取得
        RadioButton radioButton = (RadioButton)findViewById(id);
        t_.setText(radioButton.getText());//ボタンのテキストを入力　数値 ⇒ 文字列
        String str = t_.getText().toString();//ボタンのテキスト名を取得

        s[tate][yoko] = Integer.parseInt(t_.getText().toString());//ラジオボタンの値をint型に入れる

        if(s[tate][yoko] == 0 ){//0だったら数独ボタンの名前を" "にする
            t_.setText(" ");
        }

        Log.d("onClick1","変数 i は「"+ radioButton.getText() + "」");//runに残る
        Log.d("onClick2","変数 i は「"+ s[tate][yoko] + "」");//runに残る
    }


    //出力の結果を見る
    public void show_you_result(View v){
        set_number_table(v);





        //数独表を表示している
        //1 入力して見てください
        //2 こちらの表で合っていますか？
        //3 解析が終了しました
        //4 結果を出力しています
        TextView t = findViewById(R.id.textView_state);
        t.setText("4 結果を出力しています");
    }
    public int[][] sss = new int[10][10];//すべて 0 が格納


    //変数化！！！！！！！！！！！！！！！！！

    //Javaには参照渡しがないらしい。ポインタ型を駆使しないといけない
    //数独配列に入っている数値を出力
    public void set_number_table(View v){


        //上のボタンの値と下の出力の値の色を初期値によって変える
        //デフォルトで赤字にする


        //数独表を表示している
        //1 入力して見てください
        //2 こちらの表で合っていますか？
        TextView t = findViewById(R.id.textView_state);
        t.setText("2 こちらの表で合っていますか？");

        TextView[][] textViews_s = new TextView[10][10];
        int[][] textview_button_ = {{0,0,0,0,0,0,0,0,0,0,0,},
                {0, R.id.textView_s_11, R.id.textView_s_12, R.id.textView_s_13,R.id.textView_s_14, R.id.textView_s_15, R.id.textView_s_16, R.id.textView_s_17, R.id.textView_s_18, R.id.textView_s_19},
                {0, R.id.textView_s_21, R.id.textView_s_22, R.id.textView_s_23,R.id.textView_s_24, R.id.textView_s_25, R.id.textView_s_26, R.id.textView_s_27, R.id.textView_s_28, R.id.textView_s_29},
                {0, R.id.textView_s_31, R.id.textView_s_32, R.id.textView_s_33,R.id.textView_s_34, R.id.textView_s_35, R.id.textView_s_36, R.id.textView_s_37, R.id.textView_s_38, R.id.textView_s_39},
                {0, R.id.textView_s_41, R.id.textView_s_42, R.id.textView_s_43,R.id.textView_s_44, R.id.textView_s_45, R.id.textView_s_46, R.id.textView_s_47, R.id.textView_s_48, R.id.textView_s_49},
                {0, R.id.textView_s_51, R.id.textView_s_52, R.id.textView_s_53,R.id.textView_s_54, R.id.textView_s_55, R.id.textView_s_56, R.id.textView_s_57, R.id.textView_s_58, R.id.textView_s_59},
                {0, R.id.textView_s_61, R.id.textView_s_62, R.id.textView_s_63,R.id.textView_s_64, R.id.textView_s_65, R.id.textView_s_66, R.id.textView_s_67, R.id.textView_s_68, R.id.textView_s_69},
                {0, R.id.textView_s_71, R.id.textView_s_72, R.id.textView_s_73,R.id.textView_s_74, R.id.textView_s_75, R.id.textView_s_76, R.id.textView_s_77, R.id.textView_s_78, R.id.textView_s_79},
                {0, R.id.textView_s_81, R.id.textView_s_82, R.id.textView_s_83,R.id.textView_s_84, R.id.textView_s_85, R.id.textView_s_86, R.id.textView_s_87, R.id.textView_s_88, R.id.textView_s_89},
                {0, R.id.textView_s_91, R.id.textView_s_92, R.id.textView_s_93,R.id.textView_s_94, R.id.textView_s_95, R.id.textView_s_96, R.id.textView_s_97, R.id.textView_s_98, R.id.textView_s_99}};


        //入力された値をテキストビューに変換する
        for(int tate_ = 1; tate_<=9 ;tate_++){
            for(int yoko_ = 1; yoko_<=9 ;yoko_++){
                textViews_s[tate_][yoko_] = findViewById(textview_button_[tate_][yoko_]);
                textViews_s[tate_][yoko_].setText(String.valueOf(s[tate_][yoko_]));//数値 ⇒ 文字列にしてテキストビューを出力
            }
        }



        //ボタンの名前を書き換える処理が必要ぴ
        TextView[][] textViews_button_s = new TextView[10][10];
        int[][] button_name_ = {{0,0,0,0,0,0,0,0,0,0,0},
                {0, R.id.s_1_1, R.id.s_1_2, R.id.s_1_3,R.id.s_1_4, R.id.s_1_5, R.id.s_1_6, R.id.s_1_7, R.id.s_1_8, R.id.s_1_9},
                {0, R.id.s_2_1, R.id.s_2_2, R.id.s_2_3,R.id.s_2_4, R.id.s_2_5, R.id.s_2_6, R.id.s_2_7, R.id.s_2_8, R.id.s_2_9},
                {0, R.id.s_3_1, R.id.s_3_2, R.id.s_3_3,R.id.s_3_4, R.id.s_3_5, R.id.s_3_6, R.id.s_3_7, R.id.s_3_8, R.id.s_3_9},
                {0, R.id.s_4_1, R.id.s_4_2, R.id.s_4_3,R.id.s_4_4, R.id.s_4_5, R.id.s_4_6, R.id.s_4_7, R.id.s_4_8, R.id.s_4_9},
                {0, R.id.s_5_1, R.id.s_5_2, R.id.s_5_3,R.id.s_5_4, R.id.s_5_5, R.id.s_5_6, R.id.s_5_7, R.id.s_5_8, R.id.s_5_9},
                {0, R.id.s_6_1, R.id.s_6_2, R.id.s_6_3,R.id.s_6_4, R.id.s_6_5, R.id.s_6_6, R.id.s_6_7, R.id.s_6_8, R.id.s_6_9},
                {0, R.id.s_7_1, R.id.s_7_2, R.id.s_7_3,R.id.s_7_4, R.id.s_7_5, R.id.s_7_6, R.id.s_7_7, R.id.s_7_8, R.id.s_7_9},
                {0, R.id.s_8_1, R.id.s_8_2, R.id.s_8_3,R.id.s_8_4, R.id.s_8_5, R.id.s_8_6, R.id.s_8_7, R.id.s_8_8, R.id.s_8_9},
                {0, R.id.s_9_1, R.id.s_9_2, R.id.s_9_3,R.id.s_9_4, R.id.s_9_5, R.id.s_9_6, R.id.s_9_7, R.id.s_9_8, R.id.s_9_9}};



        //数独の値をボタンの名前に反映させる
        for(int tate_ = 1;tate_<=9; tate_++){
            for(int yoko_ = 1;yoko_<=9; yoko_++){
                //ボタンのIDの名前部分をtextViewとする
                textViews_button_s[tate_][yoko_] =  findViewById(button_name_[tate_][yoko_]);//ボタンを指定
                //そのボタンのtextviewの名前にs[][]を設定する
                textViews_button_s[tate_][yoko_].setText(String.valueOf(s[tate_][yoko_]));
                //もし0だったら、空白にする
                if(s[tate_][yoko_] == 0 ){//0だったら数独ボタンの名前を" "にする
                    textViews_button_s[tate_][yoko_].setText(" ");
                }
            }
        }
     }




    public void onCount_1_1(View v){
        //Javaには参照渡しがないらしい。ポインタ型を駆使しないといけない
        TextView t_ = findViewById(R.id.s_1_1);//ボタンを指定
        radio_ground_id_X_(t_, s, 1,1);
    }
    public void onCount_1_2(View v){
        TextView t_ = findViewById(R.id.s_1_2);
        radio_ground_id_X_(t_, s, 1,2);
    }
    public void onCount_1_3(View v){
        TextView t_ = findViewById(R.id.s_1_3);
        radio_ground_id_X_(t_, s, 1,3);
    }
    public void onCount_1_4(View v){
        TextView t_ = findViewById(R.id.s_1_4);
        radio_ground_id_X_(t_, s, 1,4);
    }
    public void onCount_1_5(View v){
        TextView t_ = findViewById(R.id.s_1_5);
        radio_ground_id_X_(t_, s, 1,5);
    }
    public void onCount_1_6(View v){
        TextView t_ = findViewById(R.id.s_1_6);
        radio_ground_id_X_(t_, s, 1,6);
    }
    public void onCount_1_7(View v){
        TextView t_ = findViewById(R.id.s_1_7);
        radio_ground_id_X_(t_, s, 1,7);
    }
    public void onCount_1_8(View v){
        TextView t_ = findViewById(R.id.s_1_8);
        radio_ground_id_X_(t_, s, 1,8);
    }
    public void onCount_1_9(View v){
        TextView t_ = findViewById(R.id.s_1_9);
        radio_ground_id_X_(t_, s, 1,9);
    }
    public void onCount_2_1(View v){
        TextView t_ = findViewById(R.id.s_2_1);
        radio_ground_id_X_(t_, s, 2,1);
    }
    public void onCount_2_2(View v){
        TextView t_ = findViewById(R.id.s_2_2);
        radio_ground_id_X_(t_, s, 2,2);
    }
    public void onCount_2_3(View v){
        TextView t_ = findViewById(R.id.s_2_3);
        radio_ground_id_X_(t_, s, 2,3);
    }
    public void onCount_2_4(View v){
        TextView t_ = findViewById(R.id.s_2_4);
        radio_ground_id_X_(t_, s, 2,4);
    }
    public void onCount_2_5(View v){
        TextView t_ = findViewById(R.id.s_2_5);
        radio_ground_id_X_(t_, s, 2,5);
    }
    public void onCount_2_6(View v){
        TextView t_ = findViewById(R.id.s_2_6);
        radio_ground_id_X_(t_, s, 2,6);
    }
    public void onCount_2_7(View v){
        TextView t_ = findViewById(R.id.s_2_7);
        radio_ground_id_X_(t_, s, 2,7);
    }
    public void onCount_2_8(View v){
        TextView t_ = findViewById(R.id.s_2_8);
        radio_ground_id_X_(t_, s, 2,8);
    }
    public void onCount_2_9(View v){
        TextView t_ = findViewById(R.id.s_2_9);
        radio_ground_id_X_(t_, s, 2,9);
    }
    public void onCount_3_1(View v){
        TextView t_ = findViewById(R.id.s_3_1);
        radio_ground_id_X_(t_, s, 3,1);
    }
    public void onCount_3_2(View v){
        TextView t_ = findViewById(R.id.s_3_2);
        radio_ground_id_X_(t_, s, 3,2);
    }
    public void onCount_3_3(View v){
        TextView t_ = findViewById(R.id.s_3_3);
        radio_ground_id_X_(t_, s, 3,3);
    }
    public void onCount_3_4(View v){
        TextView t_ = findViewById(R.id.s_3_4);
        radio_ground_id_X_(t_, s, 3,4);
    }
    public void onCount_3_5(View v){
        TextView t_ = findViewById(R.id.s_3_5);
        radio_ground_id_X_(t_, s, 3,5);
    }
    public void onCount_3_6(View v){
        TextView t_ = findViewById(R.id.s_3_6);
        radio_ground_id_X_(t_, s, 3,6);
    }
    public void onCount_3_7(View v){
        TextView t_ = findViewById(R.id.s_3_7);
        radio_ground_id_X_(t_, s, 3,7);
    }
    public void onCount_3_8(View v){
        TextView t_ = findViewById(R.id.s_3_8);
        radio_ground_id_X_(t_, s, 3,8);
    }
    public void onCount_3_9(View v){
        TextView t_ = findViewById(R.id.s_3_9);
        radio_ground_id_X_(t_, s, 3,9);
    }
    public void onCount_4_1(View v){
        TextView t_ = findViewById(R.id.s_4_1);
        radio_ground_id_X_(t_, s, 4,1);
    }
    public void onCount_4_2(View v){
        TextView t_ = findViewById(R.id.s_4_2);
        radio_ground_id_X_(t_, s, 4,2);
    }
    public void onCount_4_3(View v){
        TextView t_ = findViewById(R.id.s_4_3);
        radio_ground_id_X_(t_, s, 4,3);
    }
    public void onCount_4_4(View v){
        TextView t_ = findViewById(R.id.s_4_4);
        radio_ground_id_X_(t_, s, 4,4);
    }
    public void onCount_4_5(View v){
        TextView t_ = findViewById(R.id.s_4_5);
        radio_ground_id_X_(t_, s, 4,5);
    }
    public void onCount_4_6(View v){
        TextView t_ = findViewById(R.id.s_4_6);
        radio_ground_id_X_(t_, s, 4,6);
    }
    public void onCount_4_7(View v){
        TextView t_ = findViewById(R.id.s_4_7);
        radio_ground_id_X_(t_, s, 4,7);
    }
    public void onCount_4_8(View v){
        TextView t_ = findViewById(R.id.s_4_8);
        radio_ground_id_X_(t_, s, 4,8);
    }
    public void onCount_4_9(View v){
        TextView t_ = findViewById(R.id.s_4_9);
        radio_ground_id_X_(t_, s, 4,9);
    }
    public void onCount_5_1(View v){
        TextView t_ = findViewById(R.id.s_5_1);
        radio_ground_id_X_(t_, s, 5,1);
    }
    public void onCount_5_2(View v){
        TextView t_ = findViewById(R.id.s_5_2);
        radio_ground_id_X_(t_, s, 5,2);
    }
    public void onCount_5_3(View v){
        TextView t_ = findViewById(R.id.s_5_3);
        radio_ground_id_X_(t_, s, 5,3);
    }
    public void onCount_5_4(View v){
        TextView t_ = findViewById(R.id.s_5_4);
        radio_ground_id_X_(t_, s, 5,4);
    }
    public void onCount_5_5(View v){
        TextView t_ = findViewById(R.id.s_5_5);
        radio_ground_id_X_(t_, s, 5,5);
    }
    public void onCount_5_6(View v){
        TextView t_ = findViewById(R.id.s_5_6);
        radio_ground_id_X_(t_, s, 5,6);
    }
    public void onCount_5_7(View v){
        TextView t_ = findViewById(R.id.s_5_7);
        radio_ground_id_X_(t_, s, 5,7);
    }
    public void onCount_5_8(View v){
        TextView t_ = findViewById(R.id.s_5_8);
        radio_ground_id_X_(t_, s, 5,8);
    }
    public void onCount_5_9(View v){
        TextView t_ = findViewById(R.id.s_5_9);
        radio_ground_id_X_(t_, s, 5,9);
    }
    public void onCount_6_1(View v){
        TextView t_ = findViewById(R.id.s_6_1);
        radio_ground_id_X_(t_, s, 6,1);
    }
    public void onCount_6_2(View v){
        TextView t_ = findViewById(R.id.s_6_2);
        radio_ground_id_X_(t_, s, 6,2);
    }
    public void onCount_6_3(View v){
        TextView t_ = findViewById(R.id.s_6_3);
        radio_ground_id_X_(t_, s, 6,3);
    }
    public void onCount_6_4(View v){
        TextView t_ = findViewById(R.id.s_6_4);
        radio_ground_id_X_(t_, s, 6,4);
    }
    public void onCount_6_5(View v){
        TextView t_ = findViewById(R.id.s_6_5);
        radio_ground_id_X_(t_, s, 6,5);
    }
    public void onCount_6_6(View v){
        TextView t_ = findViewById(R.id.s_6_6);
        radio_ground_id_X_(t_, s, 6,6);
    }
    public void onCount_6_7(View v){
        TextView t_ = findViewById(R.id.s_6_7);
        radio_ground_id_X_(t_, s, 6,7);
    }
    public void onCount_6_8(View v){
        TextView t_ = findViewById(R.id.s_6_8);
        radio_ground_id_X_(t_, s, 6,8);
    }
    public void onCount_6_9(View v){
        TextView t_ = findViewById(R.id.s_6_9);
        radio_ground_id_X_(t_, s, 6,9);
    }
    public void onCount_7_1(View v){
        TextView t_ = findViewById(R.id.s_7_1);
        radio_ground_id_X_(t_, s, 7,1);
    }
    public void onCount_7_2(View v){
        TextView t_ = findViewById(R.id.s_7_2);
        radio_ground_id_X_(t_, s, 7,2);
    }
    public void onCount_7_3(View v){
        TextView t_ = findViewById(R.id.s_7_3);
        radio_ground_id_X_(t_, s, 7,3);
    }
    public void onCount_7_4(View v){
        TextView t_ = findViewById(R.id.s_7_4);
        radio_ground_id_X_(t_, s, 7,4);

    }
    public void onCount_7_5(View v){
        TextView t_ = findViewById(R.id.s_7_5);
        radio_ground_id_X_(t_, s, 7,5);

    }
    public void onCount_7_6(View v){
        TextView t_ = findViewById(R.id.s_7_6);
        radio_ground_id_X_(t_, s, 7,6);
    }
    public void onCount_7_7(View v){
        TextView t_ = findViewById(R.id.s_7_7);
        radio_ground_id_X_(t_, s, 7,7);
    }
    public void onCount_7_8(View v){
        TextView t_ = findViewById(R.id.s_7_8);
        radio_ground_id_X_(t_, s, 7,8);

    }
    public void onCount_7_9(View v){
        TextView t_ = findViewById(R.id.s_7_9);
        radio_ground_id_X_(t_, s, 7,9);

    }
    public void onCount_8_1(View v){
        TextView t_ = findViewById(R.id.s_8_1);
        radio_ground_id_X_(t_, s, 8,1);
    }
    public void onCount_8_2(View v){
        TextView t_ = findViewById(R.id.s_8_2);
        radio_ground_id_X_(t_, s, 8,2);
    }
    public void onCount_8_3(View v){
        TextView t_ = findViewById(R.id.s_8_3);
        radio_ground_id_X_(t_, s, 8,3);
    }
    public void onCount_8_4(View v){
        TextView t_ = findViewById(R.id.s_8_4);
        radio_ground_id_X_(t_, s, 8,4);
    }
    public void onCount_8_5(View v){
        TextView t_ = findViewById(R.id.s_8_5);
        radio_ground_id_X_(t_, s, 8,5);
    }
    public void onCount_8_6(View v){
        TextView t_ = findViewById(R.id.s_8_6);
        radio_ground_id_X_(t_, s, 8,6);
    }
    public void onCount_8_7(View v){
        TextView t_ = findViewById(R.id.s_8_7);
        radio_ground_id_X_(t_, s, 8,7);
    }
    public void onCount_8_8(View v){
        TextView t_ = findViewById(R.id.s_8_8);
        radio_ground_id_X_(t_, s, 8,8);
    }
    public void onCount_8_9(View v){
        TextView t_ = findViewById(R.id.s_8_9);
        radio_ground_id_X_(t_, s, 8,9);
    }
    public void onCount_9_1(View v){
        TextView t_ = findViewById(R.id.s_9_1);
        radio_ground_id_X_(t_, s, 9,1);
    }
    public void onCount_9_2(View v){
        TextView t_ = findViewById(R.id.s_9_2);
        radio_ground_id_X_(t_, s, 9,2);

    }
    public void onCount_9_3(View v){
        TextView t_ = findViewById(R.id.s_9_3);
        radio_ground_id_X_(t_, s, 9,3);
    }
    public void onCount_9_4(View v){
        TextView t_ = findViewById(R.id.s_9_4);
        radio_ground_id_X_(t_, s, 9,4);
    }
    public void onCount_9_5(View v){
        TextView t_ = findViewById(R.id.s_9_5);
        radio_ground_id_X_(t_, s, 9,5);
    }
    public void onCount_9_6(View v){
        TextView t_ = findViewById(R.id.s_9_6);
        radio_ground_id_X_(t_, s, 9,6);
    }
    public void onCount_9_7(View v){
        TextView t_ = findViewById(R.id.s_9_7);
        radio_ground_id_X_(t_, s, 9,7);
    }
    public void onCount_9_8(View v){
        TextView t_ = findViewById(R.id.s_9_8);
        radio_ground_id_X_(t_, s, 9,8);
    }
    public void onCount_9_9(View v){
        TextView t_ = findViewById(R.id.s_9_9);
        radio_ground_id_X_(t_, s, 9,9);
    }


}
