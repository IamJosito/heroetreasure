package com.example.heroetreasure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PrimeraEleccion extends AppCompatActivity {
    ImageView img;
    Clase clase;
    TextView tvVida, tvAtaque, tvNombre, tvClase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primera_eleccion);
        img = findViewById(R.id.imagenPersonaje);
        tvAtaque = findViewById(R.id.mostrarAtaque);
        tvVida = findViewById(R.id.mostrarVida);
        tvClase = findViewById(R.id.mostrarClase);
        tvNombre = findViewById(R.id.mostrarNombre);

        Intent intent = getIntent();
        clase = (Clase) intent.getSerializableExtra("objeto");
        img.setImageResource(clase.getImage());

        tvVida.setText(String.valueOf(clase.getVida()));
        tvAtaque.setText(String.valueOf(clase.getAtaque()));
        tvClase.setText(clase.getClase());
        tvNombre.setText(clase.getNombre());

    }
}