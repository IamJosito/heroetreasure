package com.example.heroetreasure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class PeleaSlimeBosque extends AppCompatActivity {
    ImageView img;
    Clase clase;
    TextView tvVida, tvAtaque, tvNombre, tvClase, vidaEnemigo;
    Button btnGolpe1, btnGolpe2, btnCura;
    int vidaSlime = 150;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pelea_slime_bosque);

        img = findViewById(R.id.imagenPersonaje);
        tvAtaque = findViewById(R.id.mostrarAtaque);
        tvVida = findViewById(R.id.mostrarVida);
        tvClase = findViewById(R.id.mostrarClase);
        tvNombre = findViewById(R.id.mostrarNombre);
        vidaEnemigo = findViewById(R.id.vidaEnemigo);

        Intent intent = getIntent();
        clase = (Clase) intent.getSerializableExtra("objeto");

        tvVida.setText(String.valueOf(clase.getVida()));
        tvAtaque.setText(String.valueOf(clase.getAtaque()));
        tvClase.setText(clase.getClase());
        tvNombre.setText(clase.getNombre());
        img.setImageResource(clase.getImage());

        btnGolpe1 = findViewById(R.id.btnGolpe1);
        btnGolpe2 = findViewById(R.id.btnGolpe2);
        btnCura = findViewById(R.id.btnCura);

        btnGolpe1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vidaSlime -= clase.Golpe1();
                Random rand = new Random();
                int golpeSlime = rand.nextInt(10);
                clase.setVida(golpeSlime);
                vidaEnemigo.setText("HP: " + vidaSlime);
                tvVida.setText(String.valueOf(clase.getVida()));
                if (vidaSlime <= 0){
                    System.out.println("GANAS!!");
                }
            }
        });

        btnGolpe2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vidaSlime -= clase.Golpe2();
                Random rand = new Random();
                int golpeSlime = rand.nextInt(10);
                clase.setVida(golpeSlime);
                vidaEnemigo.setText("HP: " + vidaSlime);
                tvVida.setText(String.valueOf(clase.getVida()));
                if (vidaSlime <= 0){
                    System.out.println("GANAS!!");
                }
            }
        });

        btnCura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clase.Cura();
                Random rand = new Random();
                int golpeSlime = rand.nextInt(10);
                clase.setVida(golpeSlime);
                vidaEnemigo.setText("HP: " + vidaSlime);
                tvVida.setText(String.valueOf(clase.getVida()));
            }
        });





    }
}