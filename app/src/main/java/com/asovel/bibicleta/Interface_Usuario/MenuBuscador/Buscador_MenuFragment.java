package com.asovel.bibicleta.Interface_Usuario.MenuBuscador;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.asovel.bibicleta.R;

import in.srain.cube.views.GridViewWithHeaderAndFooter;



/**
 * Un fragmento que contiene una grilla de productos
 */
public class Buscador_MenuFragment extends Fragment {
    /**
     * Argumento que representa el número sección al que pertenece
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Creación prefabricada de un {@link Buscador_MenuFragment}
     */
    public static Buscador_MenuFragment newInstance(int sectionNumber) {
        Buscador_MenuFragment fragment = new Buscador_MenuFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public Buscador_MenuFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.buscador_fragment_main, container, false);

        // Obtención del grid view
        GridViewWithHeaderAndFooter grid =
                (GridViewWithHeaderAndFooter) rootView.findViewById(R.id.gridview);

        // Inicializar el grid view
        setUpGridView(grid);

        return rootView;
    }

    /**
     * Infla el grid view del fragmento dependiendo de la sección
     *
     * @param grid Instancia del grid view
     */
    private void setUpGridView(GridViewWithHeaderAndFooter grid) {
        int section_number = getArguments().getInt(ARG_SECTION_NUMBER);
        /*
        switch (section_number) {
            case 1:
                grid.addHeaderView(createHeaderView1(6, getBicisCarretera()));

                break;
            case 2:
                grid.addHeaderView(createHeaderView2(6, Products.getTablets()));

                break;
            case 3:
                grid.addHeaderView(createHeaderView3(6, Products.getPortatiles()));

                break;
            case 4:
                grid.addHeaderView(createHeaderView4(6, Products.getPortatiles()));

                break;
        }
        */
    }

    /**
     * Crea un view de cabecera para mostrarlo en el principio del grid view.
     *
     * @param position Posición del item que sera el grid view dentro de {@code items}
     * @param items    Array de productos
     * @return Header View
     */
    private View createHeaderView1(int position, Product[] items) {

        View view;

        LayoutInflater inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.buscador_grid_menu1, null, false);

        Product item = items[position];

        // Seteando Imagen
        //ImageView image = (ImageView) view.findViewById(R.id.imagen);
        //Glide.with(image.getContext()).load(item.getIdThumbnail()).into(image);

        // Seteando Nombre
        //TextView name = (TextView) view.findViewById(R.id.nombre);
        //name.setText(item.getNombre());

        // Seteando Descripción
        //TextView descripcion = (TextView) view.findViewById(R.id.descripcion);
        //descripcion.setText(item.getDescripcion());

        // Seteando Precio
        //TextView precio = (TextView) view.findViewById(R.id.precio);
        //precio.setText(item.getPrecio());

        // Seteando Rating
        //RatingBar ratingBar = (RatingBar) view.findViewById(R.id.rating);
        //ratingBar.setRating(item.getRating());

        return view;
    }

    private View createHeaderView2(int position, Product[] items) {

        View view;

        LayoutInflater inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.buscador_grid_menu2, null, false);

        Product item = items[position];

        // Seteando Imagen
       // ImageView image = (ImageView) view.findViewById(R.id.imagen);
       // Glide.with(image.getContext()).load(item.getIdThumbnail()).into(image);

        // Seteando Nombre
       // TextView name = (TextView) view.findViewById(R.id.nombre);
        //name.setText(item.getNombre());

        // Seteando Descripción
        //TextView descripcion = (TextView) view.findViewById(R.id.descripcion);
        //descripcion.setText(item.getDescripcion());

        // Seteando Precio
        //TextView precio = (TextView) view.findViewById(R.id.precio);
        //precio.setText(item.getPrecio());

        // Seteando Rating
        //RatingBar ratingBar = (RatingBar) view.findViewById(R.id.rating);
        //ratingBar.setRating(item.getRating());

        return view;
    }

    private View createHeaderView3(int position, Product[] items) {

        View view;

        LayoutInflater inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.buscador_grid_menu3, null, false);

        Product item = items[position];

        // Seteando Imagen
        // ImageView image = (ImageView) view.findViewById(R.id.imagen);
        // Glide.with(image.getContext()).load(item.getIdThumbnail()).into(image);

        // Seteando Nombre
        // TextView name = (TextView) view.findViewById(R.id.nombre);
        //name.setText(item.getNombre());

        // Seteando Descripción
        //TextView descripcion = (TextView) view.findViewById(R.id.descripcion);
        //descripcion.setText(item.getDescripcion());

        // Seteando Precio
        //TextView precio = (TextView) view.findViewById(R.id.precio);
        //precio.setText(item.getPrecio());

        // Seteando Rating
        //RatingBar ratingBar = (RatingBar) view.findViewById(R.id.rating);
        //ratingBar.setRating(item.getRating());

        return view;
    }

    private View createHeaderView4(int position, Product[] items) {

        View view;

        LayoutInflater inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.buscador_grid_menu4, null, false);

        Product item = items[position];

        // Seteando Imagen
        // ImageView image = (ImageView) view.findViewById(R.id.imagen);
        // Glide.with(image.getContext()).load(item.getIdThumbnail()).into(image);

        // Seteando Nombre
        // TextView name = (TextView) view.findViewById(R.id.nombre);
        //name.setText(item.getNombre());

        // Seteando Descripción
        //TextView descripcion = (TextView) view.findViewById(R.id.descripcion);
        //descripcion.setText(item.getDescripcion());

        // Seteando Precio
        //TextView precio = (TextView) view.findViewById(R.id.precio);
        //precio.setText(item.getPrecio());

        // Seteando Rating
        //RatingBar ratingBar = (RatingBar) view.findViewById(R.id.rating);
        //ratingBar.setRating(item.getRating());

        return view;
    }

}
