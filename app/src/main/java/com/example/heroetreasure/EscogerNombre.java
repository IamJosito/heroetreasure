package com.example.heroetreasure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

public class EscogerNombre extends AppCompatActivity {
    TextView tv;
    ImageButton btn;
    EditText et;
    MediaPlayer sonidoBoton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);
        sonidoBoton = MediaPlayer.create(this,R.raw.sonido_btn);
        sonidoBoton.setVolume(0.1f,0.1f);

        Intent intent = getIntent();
        final Clase clase = (Clase) intent.getSerializableExtra("objeto");

        Spannable textoClase = new SpannableString("Hola joven " + clase.getClase() + ". \nEres nuevo?");
        textoClase.setSpan(new ForegroundColorSpan(Color.RED),"Hola joven ".length(),"Hola joven ".length() + clase.getClase().length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        tv = findViewById(R.id.textoInicial);
        tv.setText(textoClase);

        btn = findViewById(R.id.btnSiguiente);
        et = findViewById(R.id.nombreEt);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sonidoBoton.start();
                if(!et.getText().toString().isEmpty()){
                    clase.setNombre(et.getText().toString());
                    Intent intent = new Intent(EscogerNombre.this, CharlaConMarcus.class);
                    intent.putExtra("objeto", (Serializable) clase);
                    startActivity(intent);
                }else{
                    Toast.makeText(EscogerNombre.this, "El nombre no puede estar vacío.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}