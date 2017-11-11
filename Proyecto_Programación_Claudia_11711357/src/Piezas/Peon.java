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
public class Peon extends Piezas{
//private String simbolo="P";
    public Peon() {
    super();
          super.simbolo="♙";
                super.Nombre="Peon";
    }
     @Override
    public boolean Restriccion(int F_Vieja,int C_Vieja,Object Matriz[][], int id) {
        boolean Acceso=false;
         if (id==0) {
             if (Matriz[F_Vieja+1][C_Vieja] instanceof Piezas&&((Matriz[F_Vieja+1][C_Vieja-1] instanceof String)&&(Matriz[F_Vieja+1][C_Vieja+1] instanceof String))) {
                 Acceso=false;
             }else{
                 Acceso=true;
             }
         }else{//EL JUGADOR ES EL NUMEro 2
             if (Matriz[F_Vieja-1][C_Vieja] instanceof Piezas&&((Matriz[F_Vieja-1][C_Vieja-1] instanceof String)&&(Matriz[F_Vieja-1][C_Vieja+1] instanceof String))) {
                 Acceso=false;
             }else{
                 Acceso=true;
             }
         }
        return Acceso;
    }
}
