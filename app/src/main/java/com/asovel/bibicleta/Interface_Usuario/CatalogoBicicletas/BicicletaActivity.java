package com.asovel.bibicleta.Interface_Usuario.CatalogoBicicletas;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.view.Menu;
import android.view.MenuItem;

import com.asovel.bibicleta.R;

public class BicicletaActivity extends AppCompatActivity {
    public RecyclerView recyclerView;
    public LinearLayoutManager linearLayout;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bicicleta_activity);

        setToolbar(); // Reemplazar toolbar

        setupRecyclerView(); // Preparar recycler view

        setupWindowAnimations(); // Añadir animaciones

    }

    private void setupRecyclerView() {
        linearLayout = new LinearLayoutManager(this);
        recyclerView = (RecyclerView) findViewById(R.id.reciclador);
        recyclerView.setLayoutManager(linearLayout);
        BicicletaAdapter adapter = new BicicletaAdapter(this, Bicicletas.getBicicletas());
        recyclerView.setAdapter(adapter);
    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null)// Habilitar Up Button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void setupWindowAnimations() {
        getWindow().setReenterTransition(new Explode());
        getWindow().setExitTransition(new Explode().setDuration(500));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bicicleta, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
