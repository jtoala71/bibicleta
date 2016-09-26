package com.asovel.bibicleta.Interface_Usuario.MenuWeb;

import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Window;
import android.webkit.WebView;

import com.asovel.bibicleta.R;

import static android.view.Window.*;

public class MenuWebAntesDeComprar extends AppCompatActivity {
    private WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_webctivity);
        setToolbar(); // Reemplazar la action bar

        webView = (WebView) findViewById(R.id.webView1);
        webView.getSettings().setJavaScriptEnabled(true);

        try {
            webView.loadUrl("http://www.asovel.net/?page_id=475");
        }
        catch (Exception e) {
            // Log.d(e.getMessage()); //Get the Exception thrown.
            //webView.loadUrl("file:///android_asset/myerrorpage.html");

        }

        progressDialog = ProgressDialog.show(MenuWebAntesDeComprar.this, "Por favor espere ...",  "Tarea en proceso ...", true);
        progressDialog.setCancelable(true);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //Do some stuff that take some time...
                    Thread.sleep(3000);  //dfd  Let's wait for some time

                } catch (Exception e) {

                }
                progressDialog.dismiss();
            }
        }).start();

    }
    ProgressDialog progressDialog;

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null)// Habilitar Up Button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
