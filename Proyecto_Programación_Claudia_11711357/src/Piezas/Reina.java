/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Piezas;

import static proyecto_programación_claudia_11711357.Proyecto_Programación_Claudia_11711357.Ganador;
import static proyecto_programación_claudia_11711357.Proyecto_Programación_Claudia_11711357.JUGADORGANADOR;
import static proyecto_programación_claudia_11711357.Proyecto_Programación_Claudia_11711357.Tablero;

/**
 *
 * @author Claudia Cortes
 */
public class Reina extends Piezas {
//private String simbolo="Q";

    public Reina() {
        super();
        super.simbolo = "♕";
        super.Nombre = "Reina";
    }

    @Override
    public boolean Restriccion(int F_Vieja, int C_Vieja, Object Matriz[][], int id) {
        boolean Acceso = false;
        if (F_Vieja == 0) {
            if (C_Vieja == 0) {
                if (Matriz[F_Vieja + 1][C_Vieja] instanceof Piezas
                        && Matriz[F_Vieja][C_Vieja + 1] instanceof Piezas
                        && Matriz[F_Vieja + 1][C_Vieja + 1] instanceof Piezas) {
                    Acceso = false;
                } else {
                    Acceso = true;
                }
            } else if (C_Vieja == 7) {
                if (Matriz[F_Vieja + 1][C_Vieja] instanceof Piezas
                        && Matriz[F_Vieja][C_Vieja - 1] instanceof Piezas
                        && Matriz[F_Vieja + 1][C_Vieja - 1] instanceof Piezas) {
                    Acceso = false;
                } else {
                    Acceso = true;
                }
            } else {
                if (Matriz[F_Vieja + 1][C_Vieja] instanceof Piezas && Matriz[F_Vieja][C_Vieja + 1] instanceof Piezas && Matriz[F_Vieja][C_Vieja - 1] instanceof Piezas
                        && Matriz[F_Vieja + 1][C_Vieja + 1] instanceof Piezas && Matriz[F_Vieja + 1][C_Vieja - 1] instanceof Piezas) {
                    Acceso = false;
                } else {
                    Acceso = true;
                }
            }
        } else if (F_Vieja == 7) {
            if (C_Vieja == 0) {
                if (Matriz[F_Vieja - 1][C_Vieja] instanceof Piezas
                        && Matriz[F_Vieja][C_Vieja + 1] instanceof Piezas
                        && Matriz[F_Vieja - 1][C_Vieja + 1] instanceof Piezas) {
                    Acceso = false;
                } else {
                    Acceso = true;
                }
            } else if (C_Vieja == 7) {
                if (Matriz[F_Vieja - 1][C_Vieja] instanceof Piezas
                        && Matriz[F_Vieja][C_Vieja - 1] instanceof Piezas
                        && Matriz[F_Vieja - 1][C_Vieja - 1] instanceof Piezas) {
                    Acceso = false;
                } else {
                    Acceso = true;
                }
            } else {
                if (Matriz[F_Vieja - 1][C_Vieja] instanceof Piezas && Matriz[F_Vieja][C_Vieja + 1] instanceof Piezas && Matriz[F_Vieja][C_Vieja - 1] instanceof Piezas
                        && Matriz[F_Vieja - 1][C_Vieja + 1] instanceof Piezas && Matriz[F_Vieja - 1][C_Vieja - 1] instanceof Piezas) {
                    Acceso = false;
                } else {
                    Acceso = true;
                }
            }
        } else {//Esta en cualquier fila.
            if (Matriz[F_Vieja + 1][C_Vieja] instanceof Piezas && Matriz[F_Vieja - 1][C_Vieja] instanceof Piezas
                    &&//Arriab abajo
                    Matriz[F_Vieja][C_Vieja + 1] instanceof Piezas && Matriz[F_Vieja][C_Vieja - 1] instanceof Piezas
                    &&//Los lados
                    Matriz[F_Vieja - 1][C_Vieja + 1] instanceof Piezas && Matriz[F_Vieja - 1][C_Vieja - 1] instanceof Piezas
                    &&//Diagonales abajo
                    Matriz[F_Vieja + 1][C_Vieja + 1] instanceof Piezas && Matriz[F_Vieja + 1][C_Vieja - 1] instanceof Piezas) {//Diagonales arriba
                Acceso = false;
            } else {
                Acceso = true;
            }
        }
        return Acceso;
    }

    public boolean Movimiento(int F_Vieja, int C_Vieja, int F_Nueva, int C_Nueva, int Num1, Object[][] Tablero) {
        boolean Mover = false;
        Torre P = new Torre();
        Alfil A = new Alfil();

        if (P.Movimiento(F_Vieja, C_Vieja, F_Nueva, C_Nueva, Num1, Tablero) || A.Movimiento(F_Vieja, C_Vieja, F_Nueva, C_Nueva, Num1, Tablero)) {
            //if (MovimientoTorre(F_Vieja, C_Vieja, F_Nueva, C_Nueva, Num1,Tablero) || MovimientoAlfil(F_Vieja, C_Vieja, F_Nueva, C_Nueva, Num1,Tablero)) {
            Mover = true;
        }
        return Mover;

    }

}

