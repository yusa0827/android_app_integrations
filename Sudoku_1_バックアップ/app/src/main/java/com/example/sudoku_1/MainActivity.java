package com.example.sudoku_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_home);
        setToSubTrainingOrAnalysis();
    }

    /**
     * 「押すとpage1へ戻る」ボタンが押されたときに、1ページ目を表示する。
     */
    protected void setSubTrainToMainHome()
    {
        //先にサブのトレーニングの中のリターンのボタンを見つける
        Button button_sub_train_to_main_ = this.findViewById(R.id.button_sub_train_to_main);//
        button_sub_train_to_main_.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setContentView(R.layout.main_home);
                setToSubTrainingOrAnalysis();
            }
        });
    }

    protected void setSubAnalysisToMainHome()
    {
        //先にサブのトレーニングの中のリターンのボタンを見つける
        Button button_sub_analysis_to_main_ = this.findViewById(R.id.button_sub_analysis_to_main);//
        button_sub_analysis_to_main_.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setContentView(R.layout.main_home);
                setToSubTrainingOrAnalysis();
            }
        });
    }


    /**
     * 「押したらpage2へ」ボタンが押されたときに、2ページ目を表示する。
     */
    protected void setToSubTrainingOrAnalysis()
    {
        //流れる処理ではなく、クリックされたところから処理される

        //メインの中のトレーニングボタンが押されたら飛ぶ
        Button button_sub_training_to_main_ = this.findViewById(R.id.main_to_training);
        button_sub_training_to_main_.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setContentView(R.layout.sub_training);//Mainに戻る
                setSubTrainToMainHome();
            }
        });

        //メインの中のアナライズボタンが押されたら飛ぶ
        Button button_sub_analysis_to_main_ = this.findViewById(R.id.main_to_analysis);
        button_sub_analysis_to_main_.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setContentView(R.layout.sub_analysis);//Mainに戻る
                setSubAnalysisToMainHome();
            }
        });



    }




}
