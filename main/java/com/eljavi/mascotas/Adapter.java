package com.eljavi.mascotas;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;



public class Adapter extends RecyclerView.Adapter<Adapter.MascotaViewHolder>{  /////////////////////////////////////////////CLASE ADAPTER

    ArrayList<Mascotas> mascotas;
    Activity activity;
    Integer numero;


    public Adapter(ArrayList<Mascotas> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override    //Infla el layout y lo pasa al viewholder para que obtenga los viewa
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //Asocia el layout a nuestro Recycler View
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas, parent, false);

        return new MascotaViewHolder(v);
    }

    //Aqui se va a estar pasando la lista de mascotas. Asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder mascotaViewHolder, int position) {

        Mascotas mascota = mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombre.setText(mascota.getNombre());
        mascotaViewHolder.tvLikes.setText(String.valueOf(mascota.getLikes()));

        //Accion para el boton Hueso Blanco que es el Likes equivalente en esta app
        mascotaViewHolder.imgHuesoBlanco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Te gusta " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
                mascotaViewHolder.tvLikes.setText(String.valueOf(mascota.getLikes()+1));
            }
        });
    }

    @Override
    public int getItemCount() { //Cantidad de elementos que contiene la lista
        return mascotas.size();
    }

    //Clase anidada donde se declaran los views
    public static class MascotaViewHolder extends RecyclerView.ViewHolder{      //////////////////////////////////////////CLASE VIEWHOLDER

        private ImageView imgFoto;
        private ImageView imgHuesoBlanco;
        private TextView tvNombre;
        private TextView tvLikes;
        //private ImageView imgHuesoRojo;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto         = (ImageView) itemView.findViewById((R.id.imgFoto));
            imgHuesoBlanco  = (ImageView) itemView.findViewById((R.id.imgHuesoBlanco));
            tvNombre        = (TextView) itemView.findViewById((R.id.tvNombre));
            tvLikes         = (TextView) itemView.findViewById((R.id.tvLikes));
            //imgHuesoRojo    = (ImageView) itemView.findViewById(R.id.imgHuesoRojo);
        }
    }

}
