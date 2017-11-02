/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Piezas;

/**
 *
 * @author Claudia Cortes
 */
public class Piezas {
    protected String Nombre;
    protected String Posicion;
    protected int Puntos;
    protected int Id_Jugador;
    protected int Color;

    public int getColor() {
        return Color;
    }

    public void setColor(int Color) {
        this.Color = Color;
    }
    protected String simbolo;

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }
    public Piezas() {
    }

    @Override
    public String toString() {
        return "Piezas{" + "Nombre=" + Nombre + ", Posicion=" + Posicion + ", Puntos=" + Puntos + ", Id_Jugador=" + Id_Jugador + '}';
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getPosicion() {
        return Posicion;
    }

    public void setPosicion(String Posicion) {
        this.Posicion = Posicion;
    }

    public int getPuntos() {
        return Puntos;
    }

    public void setPuntos(int Puntos) {
        this.Puntos = Puntos;
    }

    public int getId_Jugador() {
        return Id_Jugador;
    }

    public void setId_Jugador(int Id_Jugador) {
        this.Id_Jugador = Id_Jugador;
    }
    
    
}
