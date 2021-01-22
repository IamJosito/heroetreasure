package com.example.heroetreasure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

public class ReyZend1 extends AppCompatActivity {
    Clase clase;
    TextView tvTxtBandido;
    Button btnVerdad, btnMentir, btnHuir;
    MediaPlayer sonidoBoton, musicaCastillo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rey_zend1);

        btnVerdad = findViewById(R.id.btnVerdad);
        btnMentir = findViewById(R.id.btnMentir);
        btnHuir = findViewById(R.id.btnHuir);

        tvTxtBandido = findViewById(R.id.textoBandido);

        sonidoBoton = MediaPlayer.create(this,R.raw.sonido_btn);
        sonidoBoton.setVolume(0.4f,0.4f);

        musicaCastillo = MediaPlayer.create(this,R.raw.musica_castillo);
        musicaCastillo.setVolume(0.5f, 0.5f);
        musicaCastillo.start();

        Intent intent = getIntent();
        clase = (Clase) intent.getSerializableExtra("objeto");

        View.OnClickListener huirOVerdad = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sonidoBoton.start();
                Intent intent2 = new Intent(ReyZend1.this, PeleaConRey.class);
                intent2.putExtra("objeto", (Serializable) clase);
                musicaCastillo.stop();
                startActivity(intent2);
            }
        };

        btnHuir.setOnClickListener(huirOVerdad);
        btnVerdad.setOnClickListener(huirOVerdad);

        btnMentir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sonidoBoton.start();
                Intent intent2 = new Intent(ReyZend1.this, EleccionMentira.class);
                intent2.putExtra("objeto", (Serializable) clase);
                musicaCastillo.stop();
                startActivity(intent2);
            }
        });
    }
}