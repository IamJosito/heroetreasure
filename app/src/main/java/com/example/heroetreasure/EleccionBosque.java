package com.example.heroetreasure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

public class EleccionBosque extends AppCompatActivity {
    ImageView img;
    Clase clase;
    TextView tvVida, tvAtaque, tvNombre, tvClase;
    ImageButton btnCaminoIzq, btnCaminoDer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleccion_bosque);

        img = findViewById(R.id.imagenPersonaje);
        tvAtaque = findViewById(R.id.mostrarAtaque);
        tvVida = findViewById(R.id.mostrarVida);
        tvClase = findViewById(R.id.mostrarClase);
        tvNombre = findViewById(R.id.mostrarNombre);
        btnCaminoIzq = findViewById(R.id.btnElecc1);
        btnCaminoDer = findViewById(R.id.btnElecc2);

        Intent intent = getIntent();
        clase = (Clase) intent.getSerializableExtra("objeto");
        img.setImageResource(clase.getImage());

        tvVida.setText(String.valueOf(clase.getVida()));
        tvAtaque.setText(String.valueOf(clase.getAtaque()));
        tvClase.setText(clase.getClase());
        tvNombre.setText(clase.getNombre());

        View.OnClickListener peleaSlime = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("HAS ELEGIO UN CAMINO");
                Intent peleaSlime = new Intent(EleccionBosque.this, PeleaSlimeBosque.class);
                peleaSlime.putExtra("objeto", (Serializable) clase);
                startActivity(peleaSlime);
            }
        };

        btnCaminoDer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("HAS ELEGIO UN CAMINO");
                Intent peleaSlime = new Intent(EleccionBosque.this, PeleaSlimeBosque.class);
                peleaSlime.putExtra("objeto", (Serializable) clase);
                startActivity(peleaSlime);
            }
        });
        btnCaminoIzq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("HAS ELEGIO UN CAMINO");
                Intent peleaSlime = new Intent(EleccionBosque.this, PeleaSlimeBosque.class);
                peleaSlime.putExtra("objeto", (Serializable) clase);
                startActivity(peleaSlime);
            }
        });
    }
}