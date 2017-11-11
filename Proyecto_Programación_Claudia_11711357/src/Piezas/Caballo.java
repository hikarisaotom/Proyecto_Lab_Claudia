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
public class Caballo extends Piezas {
    private String simbolo="♘";

    public Caballo() {
        super();
        super.simbolo="♘";
        super.Nombre="Caballo";
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }
    
     @Override
    public boolean Restriccion(int F_Vieja,int C_Vieja,Object Matriz[]) {
        boolean Acceso=false;
        return Acceso;
    }
}
