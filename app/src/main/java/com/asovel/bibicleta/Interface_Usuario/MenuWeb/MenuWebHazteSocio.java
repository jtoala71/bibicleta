package com.asovel.bibicleta.Interface_Usuario.MenuWeb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.asovel.bibicleta.R;

public class MenuWebHazteSocio extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_menu_web_hazte_socio);

        webView = (WebView) findViewById(R.id.webView3);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSfeXj1fan4L3Uc2O88EoLkUuwIyW2V4jXPDl1sNuX1a01q27A/viewform?c=0&w=1");
    }
}
