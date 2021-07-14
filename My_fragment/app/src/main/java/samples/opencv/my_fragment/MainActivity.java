package samples.opencv.my_fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //フラグメントのボタンをセット
        Button button01 = findViewById(R.id.button);


        //フラグメントの値を変えてあげる
        //フラグメントのボタンを
        if(savedInstanceState == null){
            button01.setOnClickListener(new View.OnClickListener(){
                //クリックしたら実行
                @Override
                public void onClick(View view){
                    //フラグメント設定
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                    // BackStackを設定
                    fragmentTransaction.addToBackStack(null);

                    // パラメータを設定
                    fragmentTransaction.replace(R.id.container,
                            TestFragment.newInstance("Change"));
                    //フラグメントに設定されていた値を変える
                    fragmentTransaction.commit();
                }

            });
        }
    }
}