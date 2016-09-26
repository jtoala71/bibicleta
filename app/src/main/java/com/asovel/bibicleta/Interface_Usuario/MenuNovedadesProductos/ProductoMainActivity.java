package com.asovel.bibicleta.Interface_Usuario.MenuNovedadesProductos;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
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
import android.transition.Explode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.asovel.bibicleta.Interface_Usuario.CatalogoBicicletas.BicicletaActivity;
import com.asovel.bibicleta.Interface_Usuario.CatalogoBicicletas.BicicletaDetailActivity;
import com.asovel.bibicleta.R;

import java.util.ArrayList;
import java.util.List;


public class ProductoMainActivity extends AppCompatActivity {
    ViewPager mViewPager1;


    /**
     *
     *
     * en Gridadapter.java esta el clicklistener con la galleta que dice el nombre del producto
     */
    //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.productos_activity_main);

        setToolbar(); // Añadir la toolbar
        setupWindowAnimations();
        // Setear adaptador al viewpager.
        mViewPager1 = (ViewPager) findViewById(R.id.pager);
        setupViewPager(mViewPager1);

        // Preparar las pestañas
        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);

        tabs.setupWithViewPager(mViewPager1);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem item = menu.findItem(R.id.action_shop);

        // Obtener drawable del item
        LayerDrawable icon = (LayerDrawable) item.getIcon();
        GridFragment NombreObjeto=new GridFragment();
        // Actualizar el contador icono carrito
        Utils.setBadgeCount(this, icon, NombreObjeto.contador_carrito);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_shop) {
            showSnackBar("Carrito de compras");
            startActivity(new Intent(getApplicationContext() , BicicletaActivity.class ));




            return true;
        }

        return super.onOptionsItemSelected(item);
    }

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
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void setupWindowAnimations() {
        getWindow().setReenterTransition(new Explode());
        getWindow().setExitTransition(new Explode().setDuration(500));
    }
    /**
     * Crea una instancia del view pager con los datos
     * predeterminados
     *
     * @param viewPager Nueva instancia
     */
    private void setupViewPager(ViewPager viewPager) {
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());


        adapter.addFragment(GridFragment.newInstance(4), "Kits ");
        adapter.addFragment(GridFragment.newInstance(1), "Bicicleta Montaña");
        adapter.addFragment(GridFragment.newInstance(2), "Bicicleta Urbana");
        adapter.addFragment(GridFragment.newInstance(3), "Bicicleta Carretera");
        viewPager.setAdapter(adapter);


    }

    /**
     * Método onClick() del FAB
     *
     * @param v View presionado
     */
    public void onFabClick(View v) {
        showSnackBar("Buscar producto");
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
