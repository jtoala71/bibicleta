package com.asovel.bibicleta.Interface_Usuario.CatalogoBicicletas;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityOptions;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.asovel.bibicleta.R;
import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

public class BicicletaDetailActivity extends AppCompatActivity {
    private static final String EXTRA_POSITION = "com.herprogramacion.cursospoint.extra.POSITION";
    private CollapsingToolbarLayout collapsingToolbarLayout;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bicicleta_activity_detail);

        setToolbar(); // Reemplazar la action bar

        // Se obtiene la posición del item seleccionado
        int position = getIntent().getIntExtra(EXTRA_POSITION, -1);

        // Carga los datos en la vista
        setupViews(position);

        Window window = getWindow();

        // Elegir transiciones
        switch (position) {
            // EXPLODE
            case 0:
                Explode t0 = new Explode();
                window.setEnterTransition(t0);
                break;
            // SLIDE
            case 1:
                Slide t1 = new Slide();
                t1.setSlideEdge(Gravity.END);
                window.setEnterTransition(t1);
                break;
            // FADE
            case 2:
                Fade t2 = new Fade();
                window.setEnterTransition(t2);
                break;
            // PERSONALIZADA
            case 3:
                Transition t3 = TransitionInflater.from(this)
                        .inflateTransition(R.transition.detail_enter_trasition);
                window.setEnterTransition(t3);
                break;
            // EVENTOS DE TRANSICIÓN
            case 4:
                Fade t4 = new Fade();
                t4.addListener(
                        new Transition.TransitionListener() {
                            @Override
                            public void onTransitionStart(Transition transition) {

                            }

                            @Override
                            public void onTransitionEnd(Transition transition) {
                                Snackbar.make(
                                        findViewById(R.id.coordinator),
                                        "Terminó la transición",
                                        Snackbar.LENGTH_SHORT)
                                        .show();
                            }

                            @Override
                            public void onTransitionCancel(Transition transition) {

                            }

                            @Override
                            public void onTransitionPause(Transition transition) {

                            }

                            @Override
                            public void onTransitionResume(Transition transition) {

                            }
                        }
                );
                window.setEnterTransition(t4);
                break;
            // POR DEFECTO
            case 5:
                window.setEnterTransition(null);
                break;

        }
    }

    private void setupViews(int position) {
        TextView name = (TextView) findViewById(R.id.detail_name);
        //TextView description = (TextView) findViewById(R.id.detail_description);
        TextView author = (TextView) findViewById(R.id.detail_author);
        TextView price = (TextView) findViewById(R.id.detail_price);
        RatingBar rating = (RatingBar) findViewById(R.id.detail_rating);
        ImageView image = (ImageView) findViewById(R.id.detail_image);
        FloatingActionButton FAB  = (FloatingActionButton) findViewById(R.id.fab);
        FAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(BicicletaDetailActivity.this,"Añadido a la cesta",Toast.LENGTH_SHORT).show();
               // startActivity(new Intent(getApplicationContext() , DialogoMapaActivity.class ));

            }
        });

        // Obtiene la bicicleta ha detallar basado en la posición
        Bicicleta detailBicicleta = Bicicletas.getBicicletaByPosition(position);

        name.setText(detailBicicleta.getName());
       // description.setText(detailBicicleta.getDescription());
        author.setText("Creado Por:" + detailBicicleta.getAuthor());
        price.setText("$" + detailBicicleta.getPrice());
        rating.setRating(detailBicicleta.getRating());
        Glide.with(this).load(detailBicicleta.getIdImage()).into(image);
    }




    private void setToolbar() {



       // collapsingToolbarLayout.setContentScrimColor(palette.getMutedColor(primary));
       // collapsingToolbarLayout.setStatusBarScrimColor(palette.getDarkMutedColor(primaryDark));

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        if (getSupportActionBar() != null)//   Habilitar Up Button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar1);

        collapsingToolbarLayout.setTitle("Detalles");
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
        final ImageView image1 = (ImageView) findViewById(R.id.image);

    }


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            default:
                return super.onOptionsItemSelected(item);
            case android.R.id.home:
                // Obtener intent de la actividad padre
                Intent upIntent = NavUtils.getParentActivityIntent(this);
                upIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);

                // Comprobar si DetailActivity no se creó desde BicicletaActivity
                if (NavUtils.shouldUpRecreateTask(this, upIntent)
                        || this.isTaskRoot()) {

                    // Construir de nuevo la tarea para ligar ambas actividades
                    TaskStackBuilder.create(this)
                            .addNextIntentWithParentStack(upIntent)
                            .startActivities();
                }

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    // Terminar con el método correspondiente para Android 5.x
                    this.finishAfterTransition();
                    return true;
                }

                // Dejar que el sistema maneje el comportamiento del up button
                return false;
        }
    }

/*
    @Override
    public void onClick(BicicletaAdapter.BicicletaViewHolder holder, String name) {
        Snackbar.make(findViewById(android.R.id.content), ":id = " + name,
                Snackbar.LENGTH_LONG).show();
    }
    */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static void launch(Activity context, int position, View sharedView) {
        Intent intent = new Intent(context, BicicletaDetailActivity.class);
        intent.putExtra(EXTRA_POSITION, position);

        // Los elementos 4, 5 y 6 usan elementos compartidos,
        if (position >= 3) {
            ActivityOptions options0 = ActivityOptions
                    .makeSceneTransitionAnimation(context, sharedView, sharedView.getTransitionName());
            context.startActivity(intent, options0.toBundle());
        } else {
            ActivityOptions options0 = ActivityOptions.makeSceneTransitionAnimation(context);
            context.startActivity(intent, options0.toBundle());
        }
    }
}