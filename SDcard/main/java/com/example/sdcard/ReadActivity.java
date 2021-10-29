package com.example.sdcard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadActivity extends AppCompatActivity {

    private Button read_button;
    private EditText filename;
    private TextView content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read_activity);


        read_button=findViewById(R.id.read_button2);
        filename=findViewById(R.id.read_filename);
        content=findViewById(R.id.read_content);
        content.setMovementMethod(new ScrollingMovementMethod());

        read_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!filename.getText().toString().equals("")){

                    String f_content="";
                    String line="";
                    File file=new File(getExternalFilesDir("myfiles"),filename.getText().toString()+".txt");
                    if(file.exists()) {
                        FileInputStream FIS = null;
                        try {
                            FIS = new FileInputStream(file);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        BufferedReader BR = new BufferedReader(new InputStreamReader(FIS));
                        while (true) {
                            try {
                                if (!((line=BR.readLine())!=null)) break;
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            f_content+=line+"\n";
                        }

                        content.setText(f_content);
                    }
                    else {
                        Toast.makeText(ReadActivity.this, "File Not found !", Toast.LENGTH_SHORT).show();
                        filename.setText("");
                        content.setText("");
                    }
                }
                else{
                    content.setText("");
                    Toast.makeText(ReadActivity.this, "File name can't be empty !", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}