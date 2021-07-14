package com.example.my_opencv4_downgreade;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.util.Size;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import org.opencv.android.CameraBridgeViewBase;
import org.opencv.core.Core;
import org.opencv.core.Mat;


import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.dnn.Net;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Objects;

import static android.app.PendingIntent.getActivity;
import static org.opencv.imgproc.Imgproc.warpAffine;


public class MainActivity extends AppCompatActivity implements CameraBridgeViewBase.CvCameraViewListener {
    private CameraBridgeViewBase m_cameraView;
    private ImageView imageView;

    boolean image_cap = false;//画像保存用変数

    public void Canny_button(View Button){//ボタンを押すと画像保存
        image_cap = true;
   }


    static {
        System.loadLibrary("opencv_java4");
    }

    private static final int CAMERA_REQUEST = 1888;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getPermissionCamera(this);
//        OpenCVLoader.initDebug();
        // カメラビューのインスタンスを変数にバインド
        m_cameraView = findViewById(R.id.camera_view);
        // リスナーの設定 (後述)
        m_cameraView.setCvCameraViewListener(this);
        m_cameraView.enableView();

        //カメラを起動するボタンとその撮影した画像を表示させる
        this.imageView = (ImageView)this.findViewById(R.id.imageView);
        Button photoButton = (Button) this.findViewById(R.id.button);
        photoButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            Bitmap photo = (Bitmap) Objects.requireNonNull(data.getExtras()).get("data");
            imageView.setImageBitmap(photo);
        }
    }


    public static boolean getPermissionCamera(Activity activity) {
        if (ContextCompat.checkSelfPermission(
                activity,
                android.Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            String[] permissions = new String[]{Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE};
            ActivityCompat.requestPermissions(
                    activity,
                    permissions,
                    0);
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onCameraViewStarted(int width, int height) {
        // カメラプレビュー開始時に呼ばれる

    }

    @Override
    public void onCameraViewStopped() {
        // カメラプレビュー終了時に呼ばれる
    }


    boolean work_camera = true;

    int x=0;

    Mat public_img;


    int counter = 0;
    @Override
    public Mat onCameraFrame(Mat inputFrame) {

        Mat frame = new Mat();//動的メモリで
        Core.rotate(inputFrame, frame, Core.ROTATE_90_CLOCKWISE); //90度回転
        Imgproc.cvtColor(frame,frame, Imgproc.COLOR_RGBA2GRAY);//グレースケール

        int img_x = frame.cols();//横の長さ
        int img_y = frame.rows();//縦の長さ

        Point center_XV = new Point((int)(img_x/2), (int)(img_y/2));
        Point margin_XV = new Point(200, 200);
        Point startingPoint = new Point(center_XV.x - margin_XV.x, center_XV.y - margin_XV.y);
        Point endingPoint = new Point(center_XV.x + margin_XV.x, center_XV.y + margin_XV.y);
        Imgproc.rectangle(frame, startingPoint, endingPoint, new Scalar(255, 255, 0));

        //ボタンのクリックで画像保存
        if(image_cap){
            image_cap = false;
            public_img = frame;
            String file_name = "/Pictures/" + String.valueOf(counter++);
            Imgcodecs.imwrite(Environment.getExternalStorageDirectory() + file_name+"imgimgimg.jpg",frame);
            Rect roi = new Rect(startingPoint, endingPoint);

            //ROI画像の保存
            Mat im2 = new Mat(frame, roi);
            Imgcodecs.imwrite(Environment.getExternalStorageDirectory() + file_name+"imgimgimg_.jpg",im2);

        }




        // カスケード分類器で顔探索


        return frame;
    }








    private static final String TAG = "OpenCV/Sample/MobileNet";
    private static final String[] classNames = {"background",
            "aeroplane", "bicycle", "bird", "boat",
            "bottle", "bus", "car", "cat", "chair",
            "cow", "diningtable", "dog", "horse",
            "motorbike", "person", "pottedplant",
            "sheep", "sofa", "train", "tvmonitor"};
    private Net net;
    private CameraBridgeViewBase mOpenCvCameraView;



}