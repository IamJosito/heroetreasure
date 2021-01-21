package com.example.heroetreasure;

import java.io.Serializable;

public class Guerrero implements Clase, Serializable {
    private int vida = 250;
    private int ataque = 20;
    private String nombre;
    private String clase;
    private int codigoImagen;

    public Guerrero(){

    }

    @Override
    public void Cura() {
        this.vida += Math.random() * (30 - 5 + 1) + 5;
    }

    @Override
    public int Golpe1() {
        int dmg = (int) Math.random() * (50 - this.ataque + 1) + this.ataque;
        return dmg;
    }

    @Override
    public int Golpe2() {
        int dmg = (int) Math.random() * (40 - this.ataque + 1) + this.ataque;
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

    @Override
    public void restaurarVida() {
        this.vida = 250;
    }

}
