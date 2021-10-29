package com.example.sdcard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    private EditText filename;
    private EditText content;
    private Button write;
    private Button read;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        filename=findViewById(R.id.filename);
        content=findViewById(R.id.content);
        write=findViewById(R.id.write_button);
        read=findViewById(R.id.read_button);

        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String f_name = String.valueOf(filename.getText());
                System.out.println("===="+f_name);
                if (f_name.equals("")) toastMessage("File name can't be empty !");
                else {
                    String f_content = String.valueOf(content.getText());

                    File file = new File(getExternalFilesDir("myfiles"), f_name + ".txt");
                    try {
                        if (file.createNewFile()) System.out.println("===already exists");
                        else System.out.println("===created");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    FileOutputStream FOS = null;
                    try {

                        FOS = new FileOutputStream(file, true);
                    } catch (FileNotFoundException e) {
                        Log.d("file_error", "onClick: ");
                        e.printStackTrace();
                    }


                    try {
                        f_content = content.getText().toString() + "\n";
                        assert FOS != null;
                        FOS.write(f_content.getBytes());
                        toastMessage("Content added :]");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        FOS.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    //System.out.println("===here");
                    //Toast.makeText(MainActivity.this, "added", Toast.LENGTH_SHORT).show();
                    //Toast.makeText(getApplicationContext(),f_name + "saved",Toast.LENGTH_LONG).show();


                }
            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent readActivity=new Intent(MainActivity.this, ReadActivity.class);
                filename.setText("");
                content.setText("");
                startActivity(readActivity);
            }
        });

    }

    private void toastMessage(String message){
        Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT).show();
    }
}