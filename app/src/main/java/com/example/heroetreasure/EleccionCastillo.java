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

public class EleccionCastillo extends AppCompatActivity {
    ImageView img;
    Clase clase;
    TextView tvVida, tvAtaque, tvNombre, tvClase;
    ImageButton btnIrCastillo, btnRodearCastillo;
    MediaPlayer musicaCiudad, sonidoBoton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleccion_castillo);

        img = findViewById(R.id.imagenPersonaje);
        tvAtaque = findViewById(R.id.mostrarAtaque);
        tvVida = findViewById(R.id.mostrarVida);
        tvClase = findViewById(R.id.mostrarClase);
        tvNombre = findViewById(R.id.mostrarNombre);
        btnIrCastillo = findViewById(R.id.btnElecc1);
        btnRodearCastillo = findViewById(R.id.btnElecc2);

        sonidoBoton = MediaPlayer.create(this,R.raw.sonido_btn);
        sonidoBoton.setVolume(0.4f,0.4f);

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



        btnIrCastillo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sonidoBoton.start();
                Intent pasarAMontana = new Intent(EleccionCastillo.this, EleccionEntrarCastillo.class);
                pasarAMontana.putExtra("objeto", (Serializable) clase);
                startActivity(pasarAMontana);
                musicaCiudad.stop();
            }
        });

        btnRodearCastillo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sonidoBoton.start();
                Intent pasarAlBosque = new Intent(EleccionCastillo.this, EleccionRodearCastillo.class);
                pasarAlBosque.putExtra("objeto", (Serializable) clase);
                startActivity(pasarAlBosque);
                musicaCiudad.stop();
            }
        });
    }
}