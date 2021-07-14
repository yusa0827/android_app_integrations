package samples.opencv.sudoku_5_fragment;

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




        Button button01 = findViewById(R.id.button);

        if(savedInstanceState == null){
            button01.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                    // BackStackを設定
                    fragmentTransaction.addToBackStack(null);

                    // パラメータを設定
                    fragmentTransaction.replace(R.id.container,
                            TestFragment.newInstance("Fragment"));
                    fragmentTransaction.commit();
                }

            });
        }

    }
}
