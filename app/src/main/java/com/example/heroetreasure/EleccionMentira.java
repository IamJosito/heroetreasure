package com.example.heroetreasure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;

public class EleccionMentira extends AppCompatActivity {
    Clase clase;
    TextView tvTxtBandido;
    Button btnTesoro, btnTitulo;
    MediaPlayer sonidoBoton, musicaCastillo;
    int textoDelRey = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleccion_mentira);

        btnTesoro = findViewById(R.id.btnTesoro);
        btnTitulo = findViewById(R.id.btnTitulo);

        tvTxtBandido = findViewById(R.id.textoBandido);

        sonidoBoton = MediaPlayer.create(this,R.raw.sonido_btn);
        sonidoBoton.setVolume(0.4f,0.4f);

        musicaCastillo = MediaPlayer.create(this,R.raw.musica_castillo);
        musicaCastillo.setVolume(0.5f, 0.5f);
        musicaCastillo.start();

        Intent intent = getIntent();
        clase = (Clase) intent.getSerializableExtra("objeto");

        btnTesoro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sonidoBoton.start();
                Intent intent2 = new Intent(EleccionMentira.this, PeleaConRey.class);
                intent2.putExtra("objeto", (Serializable) clase);
                musicaCastillo.stop();
                startActivity(intent2);
            }
        });

        btnTitulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sonidoBoton.start();
                btnTesoro.setVisibility(v.GONE);
                if (textoDelRey == 0){
                    tvTxtBandido.setText(R.string.txtRey3);
                    textoDelRey++;
                    btnTitulo.setText(R.string.ir_al_final);
                }else{
                    Intent intent2 = new Intent(EleccionMentira.this, Fin.class);
                    startActivity(intent2);
                    musicaCastillo.stop();
                }

            }
        });
    }
}