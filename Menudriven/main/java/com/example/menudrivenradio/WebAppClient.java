package com.example.menudrivenradio;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebAppClient extends WebViewClient {
    private Activity activity=null;
    public WebAppClient(Activity activity){
        this.activity=activity;
    }
    public boolean shouldOverrideUrlLoading(WebView webView, String url){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        activity.startActivity(intent);
        return true;


    }
}