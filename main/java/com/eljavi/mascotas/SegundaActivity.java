package com.eljavi.mascotas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class SegundaActivity extends AppCompatActivity {

    ArrayList<Mascotas> mascotas;
    private RecyclerView listaMascotas;            //RECYCLERVIEW


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas2);        //RECYCLERVIEW

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        //La lista de mascotas (RecyclerView se debe comportar como un linearLayoutManager
        listaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();

        inicializarAdaptador();


    }

    public void regresar(View view){
        Intent i2 = new Intent(SegundaActivity.this, MainActivity.class);
        startActivity(i2);
        finish();
    }

    public void inicializarAdaptador(){
        Adapter adaptador = new Adapter(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    //ARREGLO DE LAS MASCOTAS MAS GUSTADA
    public void inicializarListaMascotas(){
        mascotas = new ArrayList<>();
        mascotas.add(new Mascotas("Pirata", 11, R.drawable.gato_pirata));
        mascotas.add(new Mascotas("Solovino", 7, R.drawable.perro_doberman));
        mascotas.add(new Mascotas("Garfield", 5, R.drawable.gato_garfield));

        mascotas.add(new Mascotas("Firulas", 4, R.drawable.perro_blanconegro));
        mascotas.add(new Mascotas("Killer", 4, R.drawable.perro_sabueso));

    }

    














}