package com.example.heroetreasure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.Serializable;

public class CharlaConMarcus extends AppCompatActivity {
    TextView tv;
    ImageButton btn;
    int textoParaMostrar = 0;
    Clase clase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charla_con_marcus);
        tv = findViewById(R.id.textoMarcus);
        btn = findViewById(R.id.btnSiguiente);
        Intent intent = getIntent();
        clase = (Clase) intent.getSerializableExtra("objeto");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textoParaMostrar == 0){
                    tv.setText(R.string.txtMarcus2);
                    textoParaMostrar++;
                }else if (textoParaMostrar == 1){
                    tv.setText("Confio en ti " + clase.getNombre());
                    textoParaMostrar++;
                }else if (textoParaMostrar == 2){
                    Intent intent = new Intent(CharlaConMarcus.this, PrimeraEleccion.class);
                    intent.putExtra("objeto", (Serializable) clase);
                    startActivity(intent);
                }
            }
        });
    }
}