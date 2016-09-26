package com.asovel.bibicleta.Interface_Usuario.MenuNovedadesProductos;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.asovel.bibicleta.Interface_Usuario.CatalogoBicicletas.BicicletaDetailActivity;
import com.asovel.bibicleta.R;
import com.bumptech.glide.Glide;

/**
 * {@link BaseAdapter} personalizado para el gridview
 *
 *
 *  se realiza en Glide es pasar la referencia del ImageView para que cargue en ella la imagen.

 Para cargar una imagen debes asegurar la url contiene una ruta de imagen:

 Glide.with(this)
 .load(urlString)
 .centerCrop()
 .into(imageView);
 para realizar un resize por ejemplo de 200x200 px:

 Glide.with(this)
 .load(urlString)
 .override(200, 200)
 .into(imageView);
 Para cargar imágenes desde recursos:

 a) desde imagen en recursos necesitamos el id:

 Glide.with(this)
 .load(R.id.resource_id)


 b) desde assets:

 Glide.with(fragment)
 .load(Uri.parse("file:///android_asset/nombre_imagen"))
 */



public class GridAdapter extends BaseAdapter   {

    private final Context mContext;
    private final Product[] items;
    public ItemClickListener listener;
    GridFragment NombreObjeto=new GridFragment();

    public GridAdapter(Context c, Product[] items) {
        mContext = c;
        this.items = items;
    }

    @Override
    public int getCount() {
        // Decremento en 1, para no contar el header view
        return items.length - 1;
    }

    @Override
    public Product getItem(int position) {
        return items[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View view, final ViewGroup viewGroup) {



        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.productos_grid_item, viewGroup, false);

        }
        Product item = getItem(position);


        // Seteando Imagen
        final ImageView image = (ImageView) view.findViewById(R.id.imagen);
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


        // evento click de imagenes la de 2 columnas por tipo de bici
        view.setTag(position);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NombreObjeto.contador_carrito++;
                int position = (int) v.getTag();
                Toast.makeText(v.getContext(), "Row "+ position + "was clicked!"  + NombreObjeto.contador_carrito , Toast.LENGTH_SHORT).show();
                BicicletaDetailActivity.launch(
                        (Activity) image.getContext(),  position, image);
                // Actualizar el contador icono carrito



               // contador_carrito ++;
            }
        });

        return view;
    }

    interface ItemClickListener {
        void onItemClick(View view, int position);


    }
}
