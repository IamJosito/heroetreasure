package com.example.heroetreasure;

import java.io.Serializable;

public class Asesino implements Clase, Serializable {
    private int vida = 100;
    private int ataque = 40;
    private String nombre;
    private String clase;
    private int codigoImagen;

    public Asesino(){

    }

    @Override
    public void Cura() {
        this.vida += Math.random() * (35 - 1 + 1) + 1;
    }

    @Override
    public int Golpe1() {
        int dmg = (int) Math.random() * (90 - this.ataque + 1) + this.ataque;
        return dmg;
    }

    @Override
    public int Golpe2() {
        int dmg = (int) Math.random() * (75 - this.ataque + 1) + this.ataque;
        return dmg;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public void setClase(String clase) {
        this.clase = clase;
    }

    @Override
    public String getClase() {
        return this.clase;
    }

    @Override
    public void setImage(int codigoImagen) {
        this.codigoImagen = codigoImagen;
    }

    @Override
    public int getImage() {
        return codigoImagen;
    }

    public void setVida(int vida) {
        this.vida -= vida;
    }

    @Override
    public int getVida() {
        return this.vida;
    }

    @Override
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    @Override
    public int getAtaque() {
        return this.ataque;
    }
}
