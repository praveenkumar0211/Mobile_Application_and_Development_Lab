package com.example.dynamic_webpage_semester;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView webview =(WebView) findViewById(R.id.webView);
        Button b1=findViewById(R.id.button);
        EditText e1=findViewById(R.id.editTextTextPersonName);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            @SuppressLint("SetJavaScriptEnabled")
            public void onClick(View view) {
                String utl=e1.getText().toString();
                WebSettings websettings = webview.getSettings();
                websettings.getJavaScriptEnabled();
                webview.loadUrl(utl);
            }
        });
    }
}