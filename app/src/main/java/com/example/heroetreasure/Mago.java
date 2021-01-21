package com.example.heroetreasure;

import java.io.Serializable;

public class Mago implements Clase, Serializable{
    private int vida = 180;
    private int ataque = 30;
    private String nombre;
    private String clase;
    private int codigoImagen;

    public Mago(){

    }

    @Override
    public void Cura() {
        this.vida += Math.random() * (50 - 10 + 1) + 10;
    }

    @Override
    public int Golpe1() {
        int dmg = (int) Math.random() * (60 - this.ataque + 1) + this.ataque;
        return dmg;
    }

    @Override
    public int Golpe2() {
        int dmg = (int) Math.random() * (50 - this.ataque + 1) + this.ataque;
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

    @Override
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
        this.vida = 180;
    }


}
