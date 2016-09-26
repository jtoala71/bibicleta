package com.asovel.bibicleta.Interface_Usuario.MenuInicial;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.asovel.bibicleta.Comunicacion_base_datos.BackendlessCRUD.start.SelectTableActivity;
import com.asovel.bibicleta.Interface_Usuario.CatalogoBicicletas.BicicletaActivity;
import com.asovel.bibicleta.Interface_Usuario.MenuBuscador.Buscador_MainActivity;
import com.asovel.bibicleta.Interface_Usuario.MenuNovedadesProductos.ProductoMainActivity;

import com.asovel.bibicleta.Interface_Usuario.MenuRegistrate.LoginActivity;
import com.asovel.bibicleta.Interface_Usuario.MenuWeb.MenuWebAntesDeComprar;
import com.asovel.bibicleta.Interface_Usuario.MenuWeb.MenuWebAsobel;
import com.asovel.bibicleta.Interface_Usuario.MenuWeb.MenuWebHazteSocio;
import com.asovel.bibicleta.Interface_Usuario.MenuWeb.MenuWebSobreNosotros;
import com.asovel.bibicleta.R;

public class MainActivity extends AppCompatActivity {
    /**
     * Instancia del drawer
     */

    private DrawerLayout drawerLayout;

    /**
     * Titulo inicial del drawer
     *
     * en re/menu/nav_menu => se añaden las opciones menu = buscar,carrito,producto...
     */
    private String drawerTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setToolbar(); // Setear Toolbar como action bar

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }

        drawerTitle = getResources().getString(R.string.home_item);
        if (savedInstanceState == null) {
            selectItem(drawerTitle);
        }

    }

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


    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {

                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        //Toast.makeText(this, "Selected Item: " + menuItem.getItemId(), Toast.LENGTH_SHORT).show();

                        // Marcar item presionado
                        menuItem.setChecked(true);
                        // Crear nuevo fragmento
                        String title = menuItem.getTitle().toString();
                        selectItem(title);


                        switch (menuItem.getItemId())
                        {
                            case R.id.nav_home:
                                startActivity(new Intent(getApplicationContext() , SelectTableActivity.class ));
                                break;

                            case R.id.nav_NovMyEbike:
                                startActivity(new Intent(getApplicationContext() , ProductoMainActivity.class ));
                                break;

                            case R.id.nav_MyEbike:
                                startActivity(new Intent(getApplicationContext() , Buscador_MainActivity.class ));
                                break;
                            case R.id.nav_sobre_nosotros:
                                startActivity(new Intent(getApplicationContext() , MenuWebSobreNosotros.class ));
                                break;
                            case R.id.nav_hazte_socio:
                                startActivity(new Intent(getApplicationContext() , MenuWebHazteSocio.class ));
                                break;
                            case R.id.nav_Registrate:
                                //startActivity(new Intent(getApplicationContext() , MenuWebRegistrate.class ));
                                startActivity(new Intent(getApplicationContext() , LoginActivity.class ));
                                break;
                            case R.id.nav_ir_asovel:
                                startActivity(new Intent(getApplicationContext() , MenuWebAsobel.class ));
                                break;
                            case R.id.nav_antes_de_comprar:
                                startActivity(new Intent(getApplicationContext() , MenuWebAntesDeComprar.class ));
                                break;
                            case R.id.nav_Publica_tu_ebike:
                                //startActivity(new Intent(getApplicationContext() , Buscador_MainActivity.class ));
                                break;
                            /*
                            case 2:
                                Intent dealsIntent = new Intent(MainActivity.this, ActivityDeals.class);
                                startActivity(dealsIntent);
                                break;
                            case 3:
                                Intent eventsIntent = new Intent(MainActivity.this, ActivityEvents.class);
                                startActivity(eventsIntent);
                                break;
                                */
                        }







                        return true;
                    }
                }
        );
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!drawerLayout.isDrawerOpen(GravityCompat.START)) {
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, "Selected Item: " + item.getItemId(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case android.R.id.home:
                Toast.makeText(this, "Selected Item: " + item.getTitle(), Toast.LENGTH_SHORT).show();
                drawerLayout.openDrawer(GravityCompat.START);
               // startActivity (new Intent(this, BicicletaActivity.class));
                return true;


        }
        return super.onOptionsItemSelected(item);
    }

    private void selectItem(String title) {
        // Enviar título como arguemento del fragmento
        Bundle args = new Bundle();
        args.putString(PlaceholderFragment.ARG_SECTION_TITLE, title);

        Fragment fragment = PlaceholderFragment.newInstance(title);
        fragment.setArguments(args);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .replace(R.id.main_content, fragment)
                .commit();

        drawerLayout.closeDrawers(); // Cerrar drawer

        setTitle(title); // Setear título actual

    }



}
