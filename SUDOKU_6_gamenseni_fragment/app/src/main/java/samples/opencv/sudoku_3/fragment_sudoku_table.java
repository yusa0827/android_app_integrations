package samples.opencv.sudoku_3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class fragment_sudoku_table extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //fragment_sudoku_grid_table 割り当てられた数独のフラグメントを代入
        return inflater.inflate(R.layout.fragment_sudoku_grid_table, container, false);
    }

}