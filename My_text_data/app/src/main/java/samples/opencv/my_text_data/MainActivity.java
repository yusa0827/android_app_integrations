package samples.opencv.my_text_data;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private EditText editText;
    private String fileName = "test.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_view);

        editText = findViewById(R.id.edit_text);

        //数独表のテキスト

        //数独表がどこまで終了したかを確認する


        //ボタンがクリックされたらテキストを保存
        Button buttonSave = findViewById(R.id.button_save);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // エディットテキストのテキストを取得
                String text = editText.getText().toString();
                // ファイルを保存
                saveFile(fileName, text);
                if(text.length() == 0){
                    //文字列がない NO TEXT
                    textView.setText(R.string.no_text);
                }
                else{
                    //テキストが入力されている Saved
                    textView.setText(R.string.saved);
                }
            }
        });

        //テキストを読み込む
        Button buttonRead = findViewById(R.id.button_read);
        buttonRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ファイルを読み込み 吐き出し ファイルの文字列をstrに代入
                String str = readFile(fileName);



                //nullではなかったらテキストビューに入力
                if (str != null) {
                    textView.setText(str);
                } else {
                    //nullだったらエラー
                    textView.setText(R.string.read_error);
                }
            }
        });

    }

    // ファイルを保存
    public void saveFile(String file, String str) {

        // try-with-resources
        try (FileOutputStream fileOutputstream = openFileOutput(file,
                Context.MODE_PRIVATE);){

            str = "1,3,5,7,9,0";

            fileOutputstream.write(str.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ファイルを読み出し
    public String readFile(String file) {
        String text = null;

        // try-with-resources
        try (FileInputStream fileInputStream = openFileInput(file);
             BufferedReader reader= new BufferedReader(
                     new InputStreamReader(fileInputStream, StandardCharsets.US_ASCII))) {
            //UTF_8


            String lineBuffer;
            while( (lineBuffer = reader.readLine()) != null ) {
                text = lineBuffer ;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return text;
    }
}
