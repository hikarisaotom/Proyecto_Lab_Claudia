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
    public boolean Restriccion(int F_Vieja,int C_Vieja,Object Matriz[][],int id) {
        boolean Acceso=false;
        int Num=0;
         if (F_Vieja==0) {
             Num=1;
         }else if (F_Vieja==7){
             Num=-1;
         }
         if (F_Vieja==0||F_Vieja==7) {
             if (Matriz[F_Vieja+Num][C_Vieja] instanceof Piezas&&Matriz[F_Vieja][C_Vieja+1] instanceof Piezas&&Matriz[F_Vieja][C_Vieja-1] instanceof Piezas) {
                Acceso=false; 
             }else{
                 Acceso=true;
             }
         }else{
              if (Matriz[F_Vieja-1][C_Vieja] instanceof Piezas&&Matriz[F_Vieja+1][C_Vieja] instanceof Piezas&&Matriz[F_Vieja][C_Vieja+1] instanceof Piezas&&Matriz[F_Vieja][C_Vieja-1] instanceof Piezas) {
                Acceso=false; 
             }else{
                 Acceso=true;
             }
         }
        return Acceso;
    }
}
