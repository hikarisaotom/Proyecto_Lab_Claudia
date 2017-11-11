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
public class Alfil extends Piezas{

    public Alfil() {
        super();
        super.simbolo="♗";
        super.Nombre="Alfil";
    }

    @Override
    public boolean Restriccion(int F_Vieja, int C_Vieja, Object Matriz[][], int id) {
        boolean Acceso = false;
        if (F_Vieja == 0) {
            if (Matriz[F_Vieja + 1][C_Vieja + 1] instanceof Piezas && Matriz[F_Vieja + 1][C_Vieja - 1] instanceof Piezas) {
                Acceso = false;
            } else {
                Acceso = true;
            }
        } else if (F_Vieja == 7) {
            if (Matriz[F_Vieja - 1][C_Vieja + 1] instanceof Piezas && Matriz[F_Vieja - 1][C_Vieja - 1] instanceof Piezas) {
                Acceso = false;
            } else {
                Acceso = true;
            }
        } else {//NO ESTA EN LOS EXTREMOS.
            if (Matriz[F_Vieja + 1][C_Vieja + 1] instanceof Piezas && Matriz[F_Vieja + 1][C_Vieja - 1] instanceof Piezas
                    && Matriz[F_Vieja - 1][C_Vieja + 1] instanceof Piezas && Matriz[F_Vieja - 1][C_Vieja - 1] instanceof Piezas) {
                Acceso = false;
            } else {
                Acceso = true;
            }
        }
        return Acceso;
    }

}
/*if (id == 0) {//Jugador 1
            if (F_Vieja == 0) {
                if (Matriz[F_Vieja + 1][C_Vieja + 1] instanceof Piezas && Matriz[F_Vieja + 1][C_Vieja - 1] instanceof Piezas) {
                    Acceso = false;
                } else {
                    Acceso = true;
                }
            } else {
                if (Matriz[F_Vieja + 1][C_Vieja + 1] instanceof Piezas && Matriz[F_Vieja + 1][C_Vieja - 1] instanceof Piezas
                        && Matriz[F_Vieja - 1][C_Vieja + 1] instanceof Piezas && Matriz[F_Vieja - 1][C_Vieja - 1] instanceof Piezas) {
                    Acceso = false;
                } else {
                    Acceso = true;
                }
            }
        } else {//Jugador 2
            if (F_Vieja == 7) {
                if (Matriz[F_Vieja - 1][C_Vieja + 1] instanceof Piezas && Matriz[F_Vieja - 1][C_Vieja - 1] instanceof Piezas) {
                    Acceso = false;
                } else {
                    Acceso = true;
                }
            } else {
                if (Matriz[F_Vieja + 1][C_Vieja + 1] instanceof Piezas && Matriz[F_Vieja + 1][C_Vieja - 1] instanceof Piezas
                        && Matriz[F_Vieja - 1][C_Vieja + 1] instanceof Piezas && Matriz[F_Vieja - 1][C_Vieja - 1] instanceof Piezas) {
                    Acceso = false;
                } else {
                    Acceso = true;
                }
            }
        }*/