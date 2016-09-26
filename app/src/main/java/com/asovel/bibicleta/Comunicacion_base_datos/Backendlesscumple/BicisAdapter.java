package com.asovel.bibicleta.Comunicacion_base_datos.Backendlesscumple;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.asovel.bibicleta.R;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by emilio on 17/09/2016.
 */
public class BicisAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Bicis> datos;

    public static class BicisViewHolder extends RecyclerView.ViewHolder {

        TextView BiciName;
        TextView BiciTelf;
        TextView BiciCumple;

        public BicisViewHolder(View itemView) {
            super(itemView);
            BiciName = (TextView) itemView.findViewById(R.id.amigo_name);
            BiciTelf = (TextView) itemView.findViewById(R.id.amigo_telefono);
            BiciCumple = (TextView) itemView.findViewById(R.id.amigo_cumple);
        }

        public void render(final Bicis Bicis){
            BiciName.setText(Bicis.getNombre());
            BiciTelf.setText(Bicis.getTelefono());
            BiciCumple.setText(Bicis.getCumple());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), "Click "+Bicis.getNombre(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        private Context getContext() {
            return itemView.getContext();
        }

    }

    public BicisAdapter() {
        this.datos = new ArrayList<>();
    }

    public void addAll(Collection<Bicis> collection) {
        datos.clear();
        datos.addAll(collection);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.amigo_item, parent, false);
        return new BicisViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        BicisViewHolder BiciViewHolder = (BicisViewHolder) holder;
        Bicis career = datos.get(position);
        BiciViewHolder.render(career);
    }
}
