package com.example.sd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {
    EditText filename,content;
    Button write,read;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        filename=findViewById(R.id.filename);
        content=findViewById(R.id.content);
        write=findViewById(R.id.button);
        read=findViewById(R.id.button3);
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fname=filename.getText().toString();
                File file = new File(getExternalFilesDir("myfiles"),fname+".txt");
                FileOutputStream FOS=null;
                try{
                    FOS = new FileOutputStream(file,true);
                }catch (FileNotFoundException e){
                    System.out.println(e);
                    e.printStackTrace();
                }

                try{
                    String f_content=String.valueOf(content.getText());
                    assert FOS!=null;
                    FOS.write(f_content.getBytes());
                    Toast.makeText(getApplicationContext(), "Written successfully", Toast.LENGTH_SHORT).show();
                }catch (IOException e){
                    e.printStackTrace();
                }
                try{
                    FOS.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent = new Intent(getApplicationContext(),ReadActivity.class);
                filename.setText("");
                content.setText("");
                MainActivity.this.startActivity(myintent);
            }
        });
    }
}
