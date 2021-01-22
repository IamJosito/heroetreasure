package com.example.heroetreasure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

public class SeguirSendero extends AppCompatActivity {
    ImageView img;
    Clase clase;
    TextView tvTxtBandido;
    Button btnPelear, btnHablar;
    MediaPlayer sonidoBoton, musicaBosque;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seguir_sendero);


        btnHablar = findViewById(R.id.btnHablar);
        btnPelear = findViewById(R.id.btnPelear);
        tvTxtBandido = findViewById(R.id.textoBandido);

        sonidoBoton = MediaPlayer.create(this,R.raw.sonido_btn);
        sonidoBoton.setVolume(0.4f,0.4f);

        musicaBosque = MediaPlayer.create(this,R.raw.sonido_bosque);
        musicaBosque.setVolume(0.5f, 0.5f);
        musicaBosque.start();

        Intent intent = getIntent();
        clase = (Clase) intent.getSerializableExtra("objeto");

        btnHablar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sonidoBoton.start();
                tvTxtBandido.setText(R.string.bandido2);
                btnHablar.setVisibility(v.GONE);
            }
        });

        btnPelear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(SeguirSendero.this, PeleaBandido.class);
                intent2.putExtra("objeto", (Serializable) clase);
                startActivity(intent2);
                musicaBosque.stop();
            }
        });
    }
}