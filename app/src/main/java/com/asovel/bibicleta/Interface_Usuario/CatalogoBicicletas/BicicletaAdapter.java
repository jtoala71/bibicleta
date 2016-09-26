package com.asovel.bibicleta.Interface_Usuario.CatalogoBicicletas;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;
import com.asovel.bibicleta.R;
/**
 * {@link android.support.v7.widget.RecyclerView.Adapter} para la lista de elementos
 *
 */

/**
 * No se realiza imageView.setImageResource() lo que se realiza en Glide es pasar la referencia del ImageView para que cargue en ella la imagen.

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


public class BicicletaAdapter extends RecyclerView.Adapter<BicicletaAdapter.BicicletaViewHolder>
        implements ItemClickListener {
    private final Context context;
    private List<Bicicleta> items;


    public BicicletaAdapter(Context context, List<Bicicleta> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public BicicletaViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.bicicleta_list_item, viewGroup, false);
        return new BicicletaViewHolder(v, this);
    }

    @Override
    public void onBindViewHolder(BicicletaViewHolder viewHolder, int i) {
        // Item procesado actualmente
        Bicicleta currentItem = items.get(i);

        viewHolder.name.setText(currentItem.getName());
        viewHolder.author.setText(currentItem.getAuthor());
        viewHolder.price.setText("€" + currentItem.getPrice());
        viewHolder.rating.setRating(currentItem.getRating());
        viewHolder.students.setText(currentItem.getStudents() + " Unidades");
        // Cargar imagen
        Glide.with(context)
                .load(currentItem.getIdImage())
                .into(viewHolder.image);
    }

    @Override
    public void onItemClick(View view, int position) {
        // Imagen a compartir entre transiciones
        View sharedImage = view.findViewById(R.id.image);
        BicicletaDetailActivity.launch(
                (Activity) context, position, sharedImage);
    }

    /**
     * View holder para reciclar elementos
     */
    public static class BicicletaViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        // Views para un curso
        public final TextView name;
        public final TextView author;
        public final TextView price;
        public final RatingBar rating;
        public final TextView students;
        public final ImageView image;

        // Interfaz de comunicación
        public ItemClickListener listener;

        public BicicletaViewHolder(View v, ItemClickListener listener) {
            super(v);
            name = (TextView) v.findViewById(R.id.name);
            author = (TextView) v.findViewById(R.id.author);
            price = (TextView) v.findViewById(R.id.price);
            rating = (RatingBar) v.findViewById(R.id.rating);
            students = (TextView) v.findViewById(R.id.students);
            image = (ImageView) v.findViewById(R.id.image);
            v.setOnClickListener(this);

            this.listener = listener;
        }

        @Override
        public void onClick(View v) {
            listener.onItemClick(v, getAdapterPosition());
        }
    }
}

interface ItemClickListener {
    void onItemClick(View view, int position);


}