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



    //アナライズで手動を選択
    protected void setAnalysisToManual()
    {
        //アナライズで手動を選択したが、アナライズホームに戻り飛ぶ
        Button button_analysis_to_manual_ = this.findViewById(R.id.back_button_analysis_from_manual);//
        button_analysis_to_manual_.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setContentView(R.layout.analysis_home);//
                setAnalysisToManualOrAutomatic();
            }
        });

        //サブアナライズでアナライズが押されたら、アナライズホームに飛ぶ
        Button button_analysis_to_automatic_ = this.findViewById(R.id.back_button_analysis_by_manual_to_home);//
        button_analysis_to_automatic_.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setContentView(R.layout.main_home);
                setToSubTrainingOrAnalysis();
            }
        });


    }

    //数独の表を作成するために、カメラを起動する
    protected void setWorkCameraToMain()
    {
        //アナライズで手動を選択したが、アナライズホームに戻り飛ぶ
        Button button_work_camera_for_sudoku_1 = this.findViewById(R.id.back_button_to_work_camera_for_sudoku);//
        button_work_camera_for_sudoku_1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setContentView(R.layout.main_home);//
                setToSubTrainingOrAnalysis();
            }
        });

    }

    //アナライズで手動を選択
    protected void setAnalysisToAutomatic()
    {
        //アナライズで手動を選択したが、アナライズホームに戻り飛ぶ
        Button button_work_camera_for_sudoku_ = this.findViewById(R.id.work_camera);//
        button_work_camera_for_sudoku_.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setContentView(R.layout.analysis_to_work_camera);//
                setWorkCameraToMain();
            }
        });


        //アナライズで手動を選択したが、アナライズホームに戻り飛ぶ
        Button button_back_button_analysis_ = this.findViewById(R.id.back_button_automatic_from_automatic);//
        button_back_button_analysis_.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setContentView(R.layout.analysis_home);//
                setAnalysisToManualOrAutomatic();
            }
        });

        //サブアナライズでアナライズが押されたら、アナライズホームに飛ぶ
        Button back_button_analysis_by_automatic_to_home_ = this.findViewById(R.id.back_button_analysis_by_automatic_to_home);//
        back_button_analysis_by_automatic_to_home_.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setContentView(R.layout.main_home);
                setToSubTrainingOrAnalysis();
            }
        });


    }



    //アナライズホームで手動か自動化を選択する
    protected void setAnalysisToManualOrAutomatic()
    {
        //サブアナライズでアナライズが押されたら、アナライズホームに飛ぶ
        Button button_analysis_to_manual_ = this.findViewById(R.id.analysis_to_manual);//
        button_analysis_to_manual_.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setContentView(R.layout.analysis_by_manual);
                setAnalysisToManual();
            }
        });

        //サブアナライズでアナライズが押されたら、アナライズホームに飛ぶ
        Button button_analysis_to_automatic_ = this.findViewById(R.id.analysis_to_automatic);//
        button_analysis_to_automatic_.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setContentView(R.layout.analysis_by_automatic);
                setAnalysisToAutomatic();
            }
        });


    }


    //サブアナライズでアナライズホームが押されるか、ホームが押されるか
    protected void setSubAnalysisToAnalysisOrMainHome()
    {
        //サブアナライズでアナライズが押されたら、アナライズホームに飛ぶ
        Button button_sub_analysis_to_analysis_ = this.findViewById(R.id.button_analysis);//
        button_sub_analysis_to_analysis_.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setContentView(R.layout.analysis_home);
                setAnalysisToManualOrAutomatic();
            }
        });

        ///サブアナライズでホームがおされたら、ホームに戻る
        Button button_sub_analysis_to_main_ = this.findViewById(R.id.button_sub_analysis_to_main);//
        button_sub_analysis_to_main_.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setContentView(R.layout.main_home);
                setToSubTrainingOrAnalysis();
            }
        });
    }


    //ホーム画面からトレーニングかアナライズかを選択
    //流れる処理ではなく、クリックされたところから処理される
    protected void setToSubTrainingOrAnalysis()
    {
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
                setSubAnalysisToAnalysisOrMainHome();//サブアナライズからアナライズかホームか
            }
        });
    }




}
