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
public class Rey extends Piezas{
   // private String simbolo="R";

    public Rey() {
    super();
          super.simbolo="♔";
                super.Nombre="Rey";
    }
     @Override
    public boolean Restriccion(int F_Vieja,int C_Vieja,Object Matriz[]) {
        boolean Acceso=false;
        return Acceso;
    }
}
