package com.example.heroetreasure;

import android.widget.ImageView;

public interface Clase {
    void Cura();
    int Golpe1();
    int Golpe2();
    void setClase(String clase);
    String getClase();
    void setNombre(String nombre);
    String getNombre();
    void setImage(int codigoImagen);
    int getImage();

    void setVida(int vida);
    int getVida();
    void setAtaque(int ataque);
    int getAtaque();

}
