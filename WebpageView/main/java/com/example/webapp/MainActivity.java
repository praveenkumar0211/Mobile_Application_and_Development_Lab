package com.example.webapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    private WebView webView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.webView = (WebView) findViewById(R.id.webview);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        WebAppClient webViewClient = new WebAppClient(this);
        webView.setWebViewClient(webViewClient);










        //webView.loadUrl("http://www.ssn.edu.in");
        webView.loadData("<html>" +
                "<body style=\"background-color:black; text-align:center; color: white;\">" +
                "<br><br>" +
                "<h1 style=\"text-decoration: underline\">MADLAB Ex12 - Webapp</h1>" +
                "<br><br>" +
                "<h2>" +
                "<b>Hello world</b><br><br>" +
                "</h2>" +
                "<br><br><br>" +
                "</body>" +
                "</html>", "text/html", "UTF-8");
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && this.webView.canGoBack()) {
            this.webView.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

}