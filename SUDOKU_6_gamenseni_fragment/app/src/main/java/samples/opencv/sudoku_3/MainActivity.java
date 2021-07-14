package samples.opencv.sudoku_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

//    //戻るボタンを関数化したい
//    public void Go_To_A_From_B(int A, final int B){
//        //activity_main内のボタンをクリックしたら移動する
//        Button button_sudoku_demo_ = this.findViewById(A);
//        button_sudoku_demo_.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                //クリックしたら飛ぶレイアウトページを選択する
//                setContentView(B);
//                _1_sudoku_demo();
//            }
//        });
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//activity_mainを表示
        //5秒たったら、自動的にホーム画面に飛ばす
        SetSudokuHomeAuto();
    }

    //3秒間、skipボタンを押さなかったら数独ホームに移動する
    private void SetSudokuHomeAuto(){
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                // ここに5秒後に実行したい処理 数独ホームの表示
                setContentView(R.layout.sudoku_home);
                SetSudokuDemoTrainOriginai();
            }
        }, 3000);
    }

    //sudoku_homeのボタンによって別のページに行く
    private void SetSudokuDemoTrainOriginai()
    {
//        //sudoku_home内のボタンをクリックしたら移動する
//        Button button_sudoku_demo_ = this.findViewById(R.id.button_sudoku_demo_);
//        button_sudoku_demo_.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                //クリックしたら飛ぶレイアウトページを選択する
//                setContentView(R.layout._1_sudoku_demo);
//                _1_sudoku_demo();
//            }
//        });

        //sudoku_home内のボタンをクリックしたら移動する
        Button button_sudoku_demo_demo = this.findViewById(R.id.button_sudoku_demo_demo);
        button_sudoku_demo_demo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //クリックしたら飛ぶレイアウトページを選択する
                setContentView(R.layout._1_sudoku_demo_demo_demo);
                _1_sudoku_demo_demo();
            }
        });


        //sudoku_home内のbutton_sudoku_train_ボタンをクリックしたら移動する
        Button button_sudoku_train_ = this.findViewById(R.id.button_sudoku_train_);
        button_sudoku_train_.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //クリックしたら飛ぶレイアウトページを選択する トレーニング選択肢にいく
                setContentView(R.layout._2_sudoku_training_samples);
                _2_sudoku_training_samples();
            }
        });

        //sudoku_home内のbutton_sudoku_original_ボタンをクリックしたら移動する
        Button button_sudoku_original_ = this.findViewById(R.id.button_sudoku_original_);
        button_sudoku_original_.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //クリックしたら飛ぶレイアウトページを選択する オリジナル問題にいく
                setContentView(R.layout._3_sudoku_original_question);
                button_fragment_sudoku();
                button_fragment_sudoku_analysis_states();
                BackSudokuHomeFromA(R.id.button_to_sudoku_home_from_original_);
//                BackSudokuHomeFromTrain();
            }
        });

    }


    //数独ホームに特定場所から移動
    private void BackSudokuHomeFromA(int A)
    {
        Button button_to_sudoku_home_from_demo = this.findViewById(A);
        button_to_sudoku_home_from_demo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //クリックしたら飛ぶレイアウトページを選択する
                setContentView(R.layout.sudoku_home);
                SetSudokuDemoTrainOriginai();//数独ホーム画面に移動する
            }
        });
    }


    //数独トレーニングホームから戻る
    private void _2_sudoku_training_samples()
    {

        Button button_to_sudoku_home_from_demo = this.findViewById(R.id.button_to_sudoku_home_from_demo);
        button_to_sudoku_home_from_demo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //クリックしたら飛ぶレイアウトページを選択する
                setContentView(R.layout.sudoku_home);
                SetSudokuDemoTrainOriginai();//数独ホーム画面に移動する
            }
        });
    }

//    private void _1_sudoku_demo()
//    {
//        button_fragment_sudoku();
//        button_fragment_sudoku_analysis_states();
//
//        //フラグメントのボタンを実行させる
//        Button button_to_sudoku_home_from_demo = this.findViewById(R.id.button_to_sudoku_home_from_demo);
//        button_to_sudoku_home_from_demo.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                //クリックしたら飛ぶレイアウトページを選択する
//                setContentView(R.layout.sudoku_home);
//                SetSudokuDemoTrainOriginai();//数独ホーム画面に移動する
//            }
//        });
//    }



    private void _1_sudoku_demo_demo()
    {
        button_fragment_sudoku_demo_demo();
        button_fragment_sudoku_analysis_states_demo();

        //フラグメントのボタンを実行させる
        Button button_to_sudoku_home_from_demo = this.findViewById(R.id.button_to_sudoku_home_from_demo);
        button_to_sudoku_home_from_demo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //クリックしたら飛ぶレイアウトページを選択する
                setContentView(R.layout.sudoku_home);
                SetSudokuDemoTrainOriginai();//数独ホーム画面に移動する
            }
        });
    }

    //ボタン数独のフラグメントを作成
    private void button_fragment_sudoku_demo_demo() {
        Fragment fragment_button_sudoku_demo_demo;
        //クラスを引用 javaクラスから生成させる
        fragment_button_sudoku_demo_demo = new fragment_sudoku_table();
        //FragmentTransactionを生成して処理を開始
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //レイアウトコンテナにFragmentを展開
        //transaction.replace(R.id.fragment_button_sudoku, fragment_button_sudoku);
        //レイアウトコンテナにFragmentを展開 fragment_button_sudokuはどこから来ているのか
        // fragment_button_sudoku _1_sudoku_demoのなかのフラグメントとして割り当てられた変数
        transaction.replace(R.id.fragment_button_sudoku_demo_demo, fragment_button_sudoku_demo_demo);
        //処理実行
        transaction.commit();
    }


    //ボタン数独のフラグメントを作成
    private void button_fragment_sudoku_analysis_states_demo() {
        Fragment fragment_sudoku_analysis_states_demo;
        //クラスを引用 javaクラスから生成させる 実行したい関数を実行
        fragment_sudoku_analysis_states_demo = new fragment_sudoku_analysis_states_demo();
        //FragmentTransactionを生成して処理を開始
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //レイアウトコンテナにFragmentを展開
        //transaction.replace(R.id.fragment_button_sudoku, fragment_button_sudoku);
        //レイアウトコンテナにFragmentを展開
        transaction.replace(R.id.fragment_button_sudoku_analysis_states_demo, fragment_sudoku_analysis_states_demo);
        //処理実行
        transaction.commit();
    }


    //ボタン数独のフラグメントを作成
    private void button_fragment_sudoku_analysis_states() {
        Fragment fragment_sudoku_analysis_states;
        //クラスを引用 javaクラスから生成させる
        fragment_sudoku_analysis_states = new fragment_sudoku_analysis_states();
        //FragmentTransactionを生成して処理を開始
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //レイアウトコンテナにFragmentを展開
        //transaction.replace(R.id.fragment_button_sudoku, fragment_button_sudoku);
        //レイアウトコンテナにFragmentを展開
        transaction.replace(R.id.fragment_button_sudoku_analysis_states, fragment_sudoku_analysis_states);
        //処理実行
        transaction.commit();
    }

    //ボタン数独のフラグメントを作成
    private void button_fragment_sudoku() {
        Fragment fragment_button_sudoku;
        //クラスを引用 javaクラスから生成させる
        fragment_button_sudoku = new fragment_sudoku_table();
        //FragmentTransactionを生成して処理を開始
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //レイアウトコンテナにFragmentを展開
        //transaction.replace(R.id.fragment_button_sudoku, fragment_button_sudoku);
        //レイアウトコンテナにFragmentを展開 fragment_button_sudokuはどこから来ているのか
        // fragment_button_sudoku _1_sudoku_demoのなかのフラグメントとして割り当てられた変数
        transaction.replace(R.id.fragment_button_sudoku, fragment_button_sudoku);
        //処理実行
        transaction.commit();
    }




}
