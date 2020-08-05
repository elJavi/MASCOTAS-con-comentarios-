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
import android.widget.ImageButton;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ArrayList<Mascotas> mascotas;
    private RecyclerView listaMascotas;

    ImageButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        //La lista de mascotas (RecyclerView se debe comportar como un linearLayoutManager
        listaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();

        inicializarAdaptador();

    }

    //BOTON QUE LANZA A LA SEGUNDA ACTIVIDAD
    //Esta funcion no funciono porque el boton esta en el menu
    //Se usa el switch case de la funcion de hasta abajo
    public void launchSegunda(View view){
        Intent i = new Intent(MainActivity.this, SegundaActivity.class);
        startActivity(i);
    }

    public void inicializarAdaptador(){
        Adapter adaptador = new Adapter(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }


    public void inicializarListaMascotas(){
        mascotas = new ArrayList<>();

        mascotas.add(new Mascotas("Firulas", 4, R.drawable.perro_blanconegro));
        mascotas.add(new Mascotas("Garfield", 5, R.drawable.gato_garfield));
        mascotas.add(new Mascotas("Solovino", 7, R.drawable.perro_doberman));
        mascotas.add(new Mascotas("Killer", 4, R.drawable.perro_sabueso));
        mascotas.add(new Mascotas("Garras", 3, R.drawable.gato_gris));
        mascotas.add(new Mascotas("Pirata", 11, R.drawable.gato_pirata));
    }


    //PARA CREAR EL MENU DE OPCIONES LAS SIGUIENTES FUNCIONES
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.mAbout:
                //Aqui va cualquier accion quese necesite
                break;

            case R.id.mSettings:
                //Accion que se quiera en caso de ser elegido este menu
                break;

            case R.id.mActionBar:                                                   ////////////OPCION DEL ACTION VIEW ESTRELLA QUE ESTA EN menu_opciones.xml
                Intent i = new Intent(MainActivity.this, SegundaActivity.class);
                startActivity(i);
                break;

        }

        return super.onOptionsItemSelected(item);
    }




















}


