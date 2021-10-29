package com.example.myapplication51;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private Button start;
    private Button next;
    private Handler mainHandler=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar=findViewById(R.id.progressBar);
        start=findViewById(R.id.button);
        next=findViewById(R.id.button2);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toastMessage("Started :)");
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for(int i=0;i<=100;i++){
                            int finalI = i;
                            mainHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    progressBar.setProgress(finalI);
                                    if(finalI<=25)progressBar.setProgressTintList(ColorStateList.valueOf(Color.RED));
                                    if(finalI>25 && finalI<75)progressBar.setProgressTintList(ColorStateList.valueOf(Color.YELLOW));
                                    if(finalI>=75)progressBar.setProgressTintList(ColorStateList.valueOf(Color.GREEN));
                                    if(finalI==99)toastMessage("Process finished !");
                                }
                            });
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent secondActivity=new Intent(MainActivity.this,SecondActivity.class);
                startActivity(secondActivity);

            }
        });

    }
    private void toastMessage(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }
}