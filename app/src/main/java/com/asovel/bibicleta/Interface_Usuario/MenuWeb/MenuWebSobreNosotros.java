package com.asovel.bibicleta.Interface_Usuario.MenuWeb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.asovel.bibicleta.R;

public class MenuWebSobreNosotros extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_menu_web_sobre_nosotros);

        webView = (WebView) findViewById(R.id.webView4);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://www.asovel.net/?page_id=484");
    }
}
