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
public class Torre extends Piezas {

    public Torre() {
        super();
        super.simbolo = "♖";
        super.Nombre = "Torre";
    }

    @Override
    public boolean Restriccion(int F_Vieja, int C_Vieja, Object Matriz[][], int id) {
        boolean Acceso = false;
        if (F_Vieja == 0) {
            if (C_Vieja == 0) {
                if (Matriz[F_Vieja + 1][C_Vieja] instanceof Piezas && Matriz[F_Vieja][C_Vieja + 1] instanceof Piezas) {
                    Acceso = false;
                } else {
                    Acceso = true;
                }
            } else if (C_Vieja == 7) {
                if (Matriz[F_Vieja + 1][C_Vieja] instanceof Piezas && Matriz[F_Vieja][C_Vieja - 1] instanceof Piezas) {
                    Acceso = false;
                } else {
                    Acceso = true;
                }
            }//Fin del if de las filas
        } else if (F_Vieja == 7) {
            if (C_Vieja == 0) {
                if (Matriz[F_Vieja - 1][C_Vieja] instanceof Piezas && Matriz[F_Vieja][C_Vieja + 1] instanceof Piezas) {
                    Acceso = false;
                } else {
                    Acceso = true;
                }
            } else if (C_Vieja == 7) {
                if (Matriz[F_Vieja - 1][C_Vieja] instanceof Piezas && Matriz[F_Vieja][C_Vieja - 1] instanceof Piezas) {
                    Acceso = false;
                } else {
                    Acceso = true;
                }
            }//Fin del if de las filas
        } else {
            if (Matriz[F_Vieja][C_Vieja + 1] instanceof Piezas && Matriz[F_Vieja][C_Vieja - 1] instanceof Piezas//Movimientos hacia los lados.
                    && Matriz[F_Vieja + 1][C_Vieja] instanceof Piezas && Matriz[F_Vieja - 1][C_Vieja] instanceof Piezas) {//Movimientos hacia arriba y abajo
                Acceso = false;
            } else {
                Acceso = true;
            }
        }
        return Acceso;
    }//Fin dle metodo.
}
