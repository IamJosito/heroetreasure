package com.example.heroetreasure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

public class PrimeraEleccion extends AppCompatActivity {
    ImageView img;
    Clase clase;
    TextView tvVida, tvAtaque, tvNombre, tvClase;
    ImageButton btnMontana, btnBosque;
    MediaPlayer musicaCiudad, sonidoBoton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primera_eleccion);
        img = findViewById(R.id.imagenPersonaje);
        tvAtaque = findViewById(R.id.mostrarAtaque);
        tvVida = findViewById(R.id.mostrarVida);
        tvClase = findViewById(R.id.mostrarClase);
        tvNombre = findViewById(R.id.mostrarNombre);
        btnMontana = findViewById(R.id.btnElecc1);
        btnBosque = findViewById(R.id.btnElecc2);

        sonidoBoton = MediaPlayer.create(this,R.raw.sonido_btn);
        sonidoBoton.setVolume(0.1f,0.1f);

        musicaCiudad = MediaPlayer.create(this, R.raw.sonido_pueblo);
        musicaCiudad.setVolume(0.5f, 0.5f);
        musicaCiudad.start();

        Intent intent = getIntent();
        clase = (Clase) intent.getSerializableExtra("objeto");
        img.setImageResource(clase.getImage());

        tvVida.setText(String.valueOf(clase.getVida()));
        tvAtaque.setText(String.valueOf(clase.getAtaque()));
        tvClase.setText(clase.getClase());
        tvNombre.setText(clase.getNombre());



        btnMontana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sonidoBoton.start();
                Intent pasarAMontana = new Intent(PrimeraEleccion.this, EleccionMontana.class);
                pasarAMontana.putExtra("objeto", (Serializable) clase);
                startActivity(pasarAMontana);
                musicaCiudad.stop();
            }
        });

        btnBosque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sonidoBoton.start();
                Intent pasarAlBosque = new Intent(PrimeraEleccion.this, EleccionBosque.class);
                pasarAlBosque.putExtra("objeto", (Serializable) clase);
                startActivity(pasarAlBosque);
                musicaCiudad.stop();
            }
        });



    }
}