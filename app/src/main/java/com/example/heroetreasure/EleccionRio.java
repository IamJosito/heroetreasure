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

public class EleccionRio extends AppCompatActivity {
    ImageView img;
    Clase clase;
    TextView tvVida, tvAtaque, tvNombre, tvClase;
    ImageButton btnSeguirSendero;
    MediaPlayer sonidoBoton, musicaBosque;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleccion_rio);

        img = findViewById(R.id.imagenPersonaje);
        tvAtaque = findViewById(R.id.mostrarAtaque);
        tvVida = findViewById(R.id.mostrarVida);
        tvClase = findViewById(R.id.mostrarClase);
        tvNombre = findViewById(R.id.mostrarNombre);
        btnSeguirSendero = findViewById(R.id.btnElecc1);

        sonidoBoton = MediaPlayer.create(this,R.raw.sonido_btn);
        sonidoBoton.setVolume(0.4f,0.4f);

        musicaBosque = MediaPlayer.create(this,R.raw.sonido_bosque);
        musicaBosque.setVolume(0.5f, 0.5f);
        musicaBosque.start();

        Intent intent = getIntent();
        clase = (Clase) intent.getSerializableExtra("objeto");
        clase.restaurarVida();

        img.setImageResource(clase.getImage());
        tvVida.setText(String.valueOf(clase.getVida()));
        tvAtaque.setText(String.valueOf(clase.getAtaque()));
        tvClase.setText(clase.getClase());
        tvNombre.setText(clase.getNombre());

        btnSeguirSendero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sonidoBoton.start();
                Intent intent2 = new Intent(EleccionRio.this, SeguirSendero.class);
                intent2.putExtra("objeto", (Serializable) clase);
                startActivity(intent2);
                musicaBosque.stop();
            }
        });

    }
}