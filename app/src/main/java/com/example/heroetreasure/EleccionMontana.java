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

public class EleccionMontana extends AppCompatActivity {
    ImageView img;
    Clase clase;
    TextView tvVida, tvAtaque, tvNombre, tvClase;
    ImageButton btnVolcan, btnLlanura;
    MediaPlayer sonidoBoton, musicaMontana;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleccion_montana);

        img = findViewById(R.id.imagenPersonaje);
        tvAtaque = findViewById(R.id.mostrarAtaque);
        tvVida = findViewById(R.id.mostrarVida);
        tvClase = findViewById(R.id.mostrarClase);
        tvNombre = findViewById(R.id.mostrarNombre);
        btnVolcan = findViewById(R.id.btnElecc1);
        btnLlanura = findViewById(R.id.btnElecc2);

        sonidoBoton = MediaPlayer.create(this,R.raw.sonido_btn);
        sonidoBoton.setVolume(0.1f,0.1f);

        musicaMontana = MediaPlayer.create(this,R.raw.sonido_montana);
        musicaMontana.setVolume(0.5f, 0.5f);
        musicaMontana.start();

        Intent intent = getIntent();
        clase = (Clase) intent.getSerializableExtra("objeto");
        img.setImageResource(clase.getImage());

        tvVida.setText(String.valueOf(clase.getVida()));
        tvAtaque.setText(String.valueOf(clase.getAtaque()));
        tvClase.setText(clase.getClase());
        tvNombre.setText(clase.getNombre());

        btnVolcan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sonidoBoton.start();
                Intent intent2 = new Intent(EleccionMontana.this, PeleaSlimeRojo.class);
                intent2.putExtra("objeto", (Serializable) clase);
                musicaMontana.stop();
                startActivity(intent2);
            }
        });

        btnLlanura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sonidoBoton.start();
                Intent intent2 = new Intent(EleccionMontana.this, PeleaSlimeAzul.class);
                intent2.putExtra("objeto", (Serializable) clase);
                musicaMontana.stop();
                startActivity(intent2);
            }
        });
    }
}