package com.asovel.bibicleta.Interface_Usuario.MenuBuscador;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.asovel.bibicleta.Interface_Usuario.CatalogoBicicletas.BicicletaActivity;
import com.asovel.bibicleta.Interface_Usuario.MenuWeb.MenuWebAntesDeComprar;
import com.asovel.bibicleta.R;

import java.util.ArrayList;
import java.util.List;

public class Buscador_MainActivity extends AppCompatActivity {
    ViewPager mViewPager;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buscador_activity_main);

        setToolbar(); // Añadir la toolbar

        // Setear adaptador al viewpager.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        setupViewPager(mViewPager);

        // Preparar las pestañas
        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);

        tabs.setupWithViewPager(mViewPager);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.buscador_menu_main, menu);
       // MenuItem item = menu.findItem(R.id.action_shop);

        // Obtener drawable del item
       // LayerDrawable icon = (LayerDrawable) item.getIcon();

        // Actualizar el contador
        //Buscador_Utils.setBadgeCount(this, icon, 3);

        return true;
    }

    /**
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_shop) {
            showSnackBar("Carrito de compras");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
     */
    /**
     * Muestra una {@link Snackbar} prefabricada
     *
     * @param msg Mensaje a proyectar
     */
    private void showSnackBar(String msg) {
        Snackbar.make(findViewById(R.id.fab), msg, Snackbar.LENGTH_LONG).show();
    }

    /**
     * Establece la toolbar como action bar
     */
    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            // Poner ícono del drawer toggle
            ab.setHomeAsUpIndicator(R.drawable.ic_menu);
            ab.setDisplayHomeAsUpEnabled(true);
        }

    }

    /**
     * Crea una instancia del view pager con los datos
     * predeterminados
     *
     * @param viewPager Nueva instancia
     */
    private void setupViewPager(ViewPager viewPager) {
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(Buscador_MenuFragment.newInstance(1), getString(R.string.title_section_buscador1));
        adapter.addFragment(Buscador_MenuFragment.newInstance(2), getString(R.string.title_section_buscador2));
        adapter.addFragment(Buscador_MenuFragment.newInstance(3), getString(R.string.title_section_buscador3));
        adapter.addFragment(Buscador_MenuFragment.newInstance(4), getString(R.string.title_section_buscador4));
        viewPager.setAdapter(adapter);
        viewPager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String position = (String) v.getTag();
                Toast.makeText(v.getContext(), "buscarRow "+ position + "was clicked!"   , Toast.LENGTH_SHORT).show();

                // Actualizar el contador icono carrito



                // contador_carrito ++;
            }
        });
    }

    /**
     * Método onClick() del FAB
     *
     * @param v View presionado
     */
    public void onFabClick(View v) {
        showSnackBar("Buscar producto");
        startActivity(new Intent(getApplicationContext() , BicicletaActivity.class ));

        progressDialog = ProgressDialog.show(Buscador_MainActivity.this, "Por favor espere ...",  "Tarea en proceso ...", true);
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

    /**
     * Un {@link FragmentPagerAdapter} que gestiona las secciones, fragmentos y
     * títulos de las pestañas
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }

}
