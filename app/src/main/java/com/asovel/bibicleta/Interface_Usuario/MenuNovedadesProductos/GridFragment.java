package com.asovel.bibicleta.Interface_Usuario.MenuNovedadesProductos;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.asovel.bibicleta.R;
import com.bumptech.glide.Glide;

import in.srain.cube.views.GridViewWithHeaderAndFooter;

/**
 * Un fragmento que contiene una grilla de productos
 */
public class GridFragment extends Fragment {
    int contador_carrito =0;
    /**
     * Argumento que representa el número sección al que pertenece
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Creación prefabricada de un {@link GridFragment}
     */
    public static GridFragment newInstance(int sectionNumber) {
        GridFragment fragment1 = new GridFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment1.setArguments(args);
        return fragment1;
    }

    public GridFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.productos_fragment_main, container, false);

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
     * grid.addHeaderView(createHeaderView( numero de ventanas a visulizar, Products. matriz datos novedad()));
     * grid.setAdapter(new GridAdapter(getActivity(), Products. matriz datos novedad()));
     *
     *
     * @param grid Instancia del grid view
     */
    private void setUpGridView(GridViewWithHeaderAndFooter grid) {
        int section_number = getArguments().getInt(ARG_SECTION_NUMBER);
        switch (section_number) {
            case 1:
                grid.addHeaderView(createHeaderView(6, Products.getBicisMontaña()));
                grid.setAdapter(new GridAdapter(getActivity(), Products.getBicisMontaña()));
                break;
            case 2:
                grid.addHeaderView(createHeaderView(6, Products.getBicisUrbanas()));
                grid.setAdapter(new GridAdapter(getActivity(), Products.getBicisUrbanas()));
                break;
            case 3:
                grid.addHeaderView(createHeaderView(6, Products.getBicisCarretera()));
                grid.setAdapter(new GridAdapter(getActivity(), Products.getBicisCarretera()));
                break;


            case 4:
                grid.addHeaderView(createHeaderView(6, Products.getKitsElecticos()));
                grid.setAdapter(new GridAdapter(getActivity(), Products.getKitsElecticos()));
                break;
        }
    }

    /**
     * Crea un view de cabecera para mostrarlo en el principio del grid view.
     *
     * @param position Posición del item que sera el grid view dentro de {@code items}
     * @param items    Array de productos
     * @return Header View
     */
    private View createHeaderView(int position, Product[] items) {

        View view;
        Product item = items[position];

        LayoutInflater inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.productos_grid_header, null, false);




        // Seteando Imagen
        ImageView image = (ImageView) view.findViewById(R.id.imagen);
       // Glide.with(image.getContext()).load(item.getIdThumbnail()).into(image);
        Glide.with(image.getContext()).load(item.getIdImage()).into(image);

        // Seteando Nombre
        TextView name = (TextView) view.findViewById(R.id.nombre);
        name.setText(item.getName());

        // Seteando Descripción
        TextView descripcion = (TextView) view.findViewById(R.id.descripcion);
        descripcion.setText(item.getDescripcion());

        // Seteando Precio
        TextView precio = (TextView) view.findViewById(R.id.precio);
        precio.setText(item.getPrice());

        // Seteando Rating
        RatingBar ratingBar = (RatingBar) view.findViewById(R.id.rating);
        ratingBar.setRating(item.getRating());

        view.setTag(name.getText());

        // evento click de  1ª imagen la de cabecera
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador_carrito ++;
                String position = (String) v.getTag();
                Toast.makeText(v.getContext(), "Row "+ position + "was clicked!" + contador_carrito , Toast.LENGTH_SHORT).show();

            }
        });


        return view;
    }



}
