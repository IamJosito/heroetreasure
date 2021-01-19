package com.example.heroetreasure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.io.Serializable;

public class Inicio extends AppCompatActivity {
    ImageButton btnKnight, btnMage, btnAssasin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAssasin = findViewById(R.id.assasinBtn);
        btnKnight = findViewById(R.id.knightBtn);
        btnMage = findViewById(R.id.mageBtn);
    }

    public void selectedClass(View view){
        Clase clase = null;
        if (btnMage.isPressed()){
            clase = new Mago();
            clase.setClase("Mago");
            clase.setImage(R.drawable.mago);
        }

        if (btnKnight.isPressed()){
            clase = new Guerrero();
            clase.setClase("Guerrero");
            clase.setImage(R.drawable.knight);
        }

        if (btnAssasin.isPressed()){
            clase = new Asesino();
            clase.setClase("Asesino");
            clase.setImage(R.drawable.assasin);
        }

        Intent intent = new Intent(this, EscogerNombre.class);
        intent.putExtra("objeto", (Serializable) clase);
        startActivity(intent);
    }
}