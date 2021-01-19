package com.example.heroetreasure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.Serializable;

public class Inicio2 extends AppCompatActivity {
    Intent intent;
    ImageButton btn;
    Clase clase;
    int textoParaMostrar = 0;
    TextView tv;
    MediaPlayer sonidoBoton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio2);
        intent = getIntent();
        sonidoBoton = MediaPlayer.create(this, R.raw.sonido_btn);
        sonidoBoton.setVolume(0.1f, 0.1f);

        clase = (Clase) intent.getSerializableExtra("objeto");
        btn = findViewById(R.id.btnSiguiente);
        tv = findViewById(R.id.mostrarTexto);
        System.out.println(clase.getAtaque());
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sonidoBoton.start();
                if(textoParaMostrar == 0){
                    tv.setText(R.string.locutor2);
                    textoParaMostrar++;
                }else if (textoParaMostrar == 1){
                    tv.setText(R.string.locutor3);
                    textoParaMostrar++;
                }else if(textoParaMostrar == 2){
                    tv.setText(R.string.locutor4);
                    textoParaMostrar++;
                }else if (textoParaMostrar == 3){
                    Intent intent = new Intent(Inicio2.this, EscogerNombre.class);
                    intent.putExtra("objeto", (Serializable) clase);
                    startActivity(intent);
                }
            }
        });
    }


}