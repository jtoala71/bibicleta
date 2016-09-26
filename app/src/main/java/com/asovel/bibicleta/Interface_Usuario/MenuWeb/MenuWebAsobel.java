package com.asovel.bibicleta.Interface_Usuario.MenuWeb;

import android.app.Activity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.asovel.bibicleta.R;

public class MenuWebAsobel extends Activity {

    private WebView webView;
    private boolean isError;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_web_asobel);

        webView = (WebView) findViewById(R.id.webView2);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://www.asovel.net/");


        //gestión de errores


    }

}