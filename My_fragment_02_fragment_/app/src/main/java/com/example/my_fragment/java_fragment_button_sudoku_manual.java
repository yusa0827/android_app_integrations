
package com.example.my_fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class java_fragment_button_sudoku_manual extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // fragment_button_sudoku_manual xmlファイルを指定
        return inflater.inflate(R.layout.fragment_button_sudoku_manual, container, false);
    }
}