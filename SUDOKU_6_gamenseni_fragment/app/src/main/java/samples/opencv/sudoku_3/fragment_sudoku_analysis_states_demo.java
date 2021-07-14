package samples.opencv.sudoku_3;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class fragment_sudoku_analysis_states_demo extends Fragment  {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sudoku_grid_analysis_states_demo_, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        //hoge!と表示
        Button button = (Button)getActivity().findViewById(R.id.button_to_sudoku_home_from_demo);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "hoge!", Toast.LENGTH_SHORT).show();

            }
        });






    }



}
