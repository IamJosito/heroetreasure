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

public class EleccionRodearCastillo extends AppCompatActivity {
    ImageView img;
    Clase clase;
    TextView tvVida, tvAtaque, tvNombre, tvClase;
    ImageButton btnSiguiente;
    MediaPlayer sonidoBoton, musicaCiudad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleccion_rodear_castillo);
        img = findViewById(R.id.imagenPersonaje);
        tvAtaque = findViewById(R.id.mostrarAtaque);
        tvVida = findViewById(R.id.mostrarVida);
        tvClase = findViewById(R.id.mostrarClase);
        tvNombre = findViewById(R.id.mostrarNombre);
        btnSiguiente = findViewById(R.id.btnSiguiente);

        sonidoBoton = MediaPlayer.create(this,R.raw.sonido_btn);
        sonidoBoton.setVolume(0.4f,0.4f);

        musicaCiudad = MediaPlayer.create(this,R.raw.sonido_pueblo);
        musicaCiudad.setVolume(0.5f, 0.5f);
        musicaCiudad.start();

        Intent intent = getIntent();
        clase = (Clase) intent.getSerializableExtra("objeto");
        clase.restaurarVida();

        img.setImageResource(clase.getImage());
        tvVida.setText(String.valueOf(clase.getVida()));
        tvAtaque.setText(String.valueOf(clase.getAtaque()));
        tvClase.setText(clase.getClase());
        tvNombre.setText(clase.getNombre());

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sonidoBoton.start();
                Intent intent2 = new Intent(EleccionRodearCastillo.this, ReyZend1.class);
                intent2.putExtra("objeto", (Serializable) clase);
                musicaCiudad.stop();
                startActivity(intent2);
            }
        });
    }
}