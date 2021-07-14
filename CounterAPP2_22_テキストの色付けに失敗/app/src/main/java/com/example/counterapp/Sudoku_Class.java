package com.example.counterapp;

public class Sudoku_Class {


    // コンストラクター
    Sudoku_Class(){

    }

    //3*3 のインクリメンター
    public int inclimenter_3_3 = 0;

    //3*3マスにバツが2個か3この時に発動 ここに行と列の条件によって他ブロックの候補を消去
    public int counter_del = 0;
    public int counter_tate_yoko = 0;

    // special_delete 用の変数
    public int save_tate_ = 0;
    public int save_yoko_ = 0;
    public int start_1_tate = 0;//初期化プール用のスタート位置
    public int start_2_tate = 0;//初期化プール用のスタート位置
    public int start_1_yoko = 0;//初期化プール用のスタート位置
    public int start_2_yoko = 0;//初期化プール用のスタート位置

    //数独　数値
    public int[][] s = new int[10][10];
    //数独　文字列
    public String[][] s_string = new String[10][10];
    //各ナンバー　bool_num_[縦][横][指定文字] 1に初期化
    public Boolean[][][] bool_num_ = new Boolean[10][10][10];
    //特徴量マップ用変数
    public int[][] f_map = new int[10][10];
    //特徴量マップの和が0だとbreak
    public int f_map_sum = 0;

    //数独を初期化
    public void initilize_bool_num_3N_and_feature_map_2N() {

        //同時に初期化
        for (int number_ = 1; number_ <= 9; number_++) {
            for (int tate_ = 1; tate_ <= 9; tate_++) {
                for (int yoko_ = 1; yoko_ <= 9; yoko_++) {

                    //数独を初期化
                    bool_num_[tate_][yoko_][number_] = true;

                    //特徴特徴マップを初期化
                    f_map[tate_][yoko_] = 0;
                }
            }
        }
    }


    //特定の数値における 0と1　処理
    public void Nth_0_1_checker(int number_) {
    // 1とそれ以外以外の値の範囲をマッピング
        for (int tate_ = 1; tate_ <= 9; tate_++) {
            for (int yoko_ = 1; yoko_ <= 9; yoko_++) {
                //0 以外かつ特定番号1以外のとき
                if (s[tate_][yoko_] != 0 && s[tate_][yoko_] != number_) {
                    bool_num_[tate_][yoko_][number_] = false;
                }

                //特定の値の列、行
                if (s[tate_][yoko_] == number_) {
                    //行　横
                    for (int row = 1; row <= 9; row++) {
                        bool_num_[tate_][row][number_] = false;
                    }

                    //列　縦
                    for (int col = 1; col <= 9; col++) {
                        bool_num_[col][yoko_][number_] = false;
                    }

                }

                //特定の値の列、行、エリアである
                if (s[tate_][yoko_] == number_) {
                    //スタート範囲
                    int start_tate;
                    int start_yoko;

                    //縦のエリアを探索
                    if (1 <= tate_ && tate_ <= 3) {
                        start_tate = 1;
                    }
                    else if (4 <= tate_ && tate_ <= 6) {
                        start_tate = 4;
                    }
                    else {
                        start_tate = 7;
                    }
                    //横のエリアを探索
                    if (1 <= yoko_ && yoko_ <= 3) {
                        start_yoko = 1;
                    }
                    else if (4 <= yoko_ && yoko_ <= 6) {
                        start_yoko = 4;
                    }
                    else {
                        start_yoko = 7;
                    }

                    //エリアに加算する
                    for (int i_ = start_tate; i_ < start_tate + 3; i_++) {
                        for (int j_ = start_yoko; j_ < start_yoko + 3; j_++) {
                            bool_num_[i_][j_][number_] = false;
                        }
                    }
                }
            }
        }
    }

    //特別な処理　
    // 3*3エリア内に縦・横のみに1がある場合に他の縦・横を消去
    public int one_counter_in_3_3 = 0;
    public int row_or_col_counter = 0;
    public void special_delete_ver2(int number_){
        for (int tate_move = 0; tate_move < 3; tate_move++) {
            for (int yoko_move = 0; yoko_move < 3; yoko_move++) {
                one_counter_in_3_3 = 0;
                // tate=4-6 yoko=4-6 のtrueをカウント
                for (int tate_ = tate_move * 3 + 1; tate_ <= tate_move * 3 + 3; tate_++) {//int tate_ = 4; tate_ <= 6; tate_++
                    for (int yoko_ = yoko_move * 3 + 1; yoko_ <= yoko_move * 3 + 3; yoko_++) {
                        if (bool_num_[tate_][yoko_][number_]) {
                            one_counter_in_3_3++;
                        }
                    }
                }

                row_or_col_counter = 0;
                if (one_counter_in_3_3 == 3 || one_counter_in_3_3 == 2) {
                    // tate固定
                    for (int tate_ = tate_move * 3 + 1; tate_ <= tate_move * 3 + 3; tate_++) {
                        row_or_col_counter = 0;//この初期化が組まれていないかもしてない
                        for (int yoko_ = yoko_move * 3 + 1; yoko_ <= yoko_move * 3 + 3; yoko_++) {
                            if (bool_num_[tate_][yoko_][number_]) {
                                row_or_col_counter++;
                            }
                            save_yoko_ = yoko_;
                        }

                        if (save_yoko_ == 3) {
                            start_1_yoko = 4;
                            start_2_yoko = 7;
                        }
                        if (save_yoko_ == 6) {
                            start_1_yoko = 1;
                            start_2_yoko = 7;
                        }
                        if (save_yoko_ == 9) {
                            start_1_yoko = 1;
                            start_2_yoko = 4;
                        }

                        if (one_counter_in_3_3 == row_or_col_counter) {

                            for (int yoko1 = start_1_yoko; yoko1 <= start_1_yoko + 2; yoko1++) {
                                bool_num_[tate_][yoko1][number_] = false;
                            }

                            for (int yoko1 = start_2_yoko; yoko1 <= start_2_yoko + 2; yoko1++) {
                                bool_num_[tate_][yoko1][number_] = false;
                            }
                        }
                    }


                    for (int yoko_ = yoko_move * 3 + 1; yoko_ <= yoko_move * 3 + 3; yoko_++) {
                        row_or_col_counter = 0;//この初期化が組まれていないかもしてない
                        for (int tate_ = tate_move * 3 + 1; tate_ <= tate_move * 3 + 3; tate_++) {
                            if (bool_num_[tate_][yoko_][number_]) {
                                row_or_col_counter++;
                            }
                            save_tate_ = tate_;
                        }

                        if (one_counter_in_3_3 == row_or_col_counter) {

                            if (save_tate_ == 3) {
                                start_1_tate = 4;
                                start_2_tate = 7;
                            }
                            if (save_tate_ == 6) {
                                start_1_tate = 1;
                                start_2_yoko = 7;
                            }
                            if (save_tate_ == 9) {
                                start_1_tate = 1;
                                start_2_yoko = 4;
                            }

                            for (int tate1 = start_1_tate; tate1 <= start_1_tate + 2; tate1++) {
                                bool_num_[tate1][yoko_][number_] = false;
                            }

                            for (int tate1 = start_2_yoko; tate1 <= start_2_yoko + 2; tate1++) {
                                bool_num_[tate1][yoko_][number_] = false;
                            }
                        }
                    }
                }
            }
        }
    }

    //それぞれの特徴量マップの3*3のマスの中に1があったら定数に変化
    public void change_1_to_number_in_3_3_blocks(int number_){
        for (int tate_tate = 0; tate_tate < 3; tate_tate++) {
            for (int yoko_yoko = 0; yoko_yoko < 3; yoko_yoko++) {
                //左ブロック目 3*3 を走査
                inclimenter_3_3 = 0;
                for (int tate_ = tate_tate * 3 + 1; tate_ <= tate_tate * 3 + 3; tate_++) {
                    for (int yoko_ = yoko_yoko * 3 + 1; yoko_ <= yoko_yoko * 3 + 3; yoko_++) {
                        if (bool_num_[tate_][yoko_][number_]) {
                            ++inclimenter_3_3;
                            save_tate_ = tate_;
                            save_yoko_ = yoko_;
                        }
                    }
                }
                //3*3ブロックでインクリメント1のときに確定　座標を確保
                if (inclimenter_3_3 == 1) {
                    s[save_tate_][save_yoko_] = number_;//値を代入する
                }
            }
        }
    }

    //3次元的な特徴を2次元的な特徴に落とし込む
    public void decliment_3N_to_2N() {
        f_map_sum = 0;
        for (int number_ = 1; number_ <= 9; number_++) {
            for (int tate_ = 1; tate_ <= 9; tate_++) {
                for (int yoko_ = 1; yoko_ <= 9; yoko_++) {
                    //trueはチェックを潜り抜けた生き残り
                    if (bool_num_[tate_][yoko_][number_]) {
                        f_map[tate_][yoko_]++;
                        //全体の特徴マップの和が0だとブレイク
                        f_map_sum++;
                    }
                }
            }
        }
    }

    //全体の特徴量マップの中に1があったら定数に変化
    public void find_1_in_each_f_map() {
        for (int tate_ = 1; tate_ <= 9; tate_++) {
            for (int yoko_ = 1; yoko_ <= 9; yoko_++) {
                //特徴マップで1のときにその値しか入らない
                if (f_map[tate_][yoko_] == 1) {
                    //その1はどこの数値かを調べる
                    for (int number_ = 1; number_ <= 9; number_++) {
                        //みつけたら、それを定数化する
                        if (bool_num_[tate_][yoko_][number_]) {
                            //値を置き換えた。
                            s[tate_][yoko_] = number_;
                        }
                    }
                }
            }
        }
    }




    private String[] nm = {"Apple","Google","MicroSoft"};

    String name(int number){
        String res = "error";
        // 配列要素外ではエラーとする
        if(nm.length > number) {
            res = nm[number];
        }

        return res;
    }




}
