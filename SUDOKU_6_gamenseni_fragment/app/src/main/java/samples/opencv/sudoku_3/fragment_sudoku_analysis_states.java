package samples.opencv.sudoku_3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class fragment_sudoku_analysis_states extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sudoku_grid_analysis_states, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        Button button = (Button)getActivity().findViewById(R.id.button_to_sudoku_home_from_demo_fragment);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "hoge!", Toast.LENGTH_SHORT).show();
            }
        });

    }





}


/* fragmentの使い方
* レイアウトで設定したいボタンやテキストを配置する
* そのレイアウト専用のjavaクラスを作成する
* 次にMainActivityでそのクラスのオブジェクトを生成し、処理させる
* */