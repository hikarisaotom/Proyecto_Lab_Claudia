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
public class Caballo extends Piezas {

    private String simbolo = "♘";

    public Caballo() {
        super();
        super.simbolo = "♘";
        super.Nombre = "Caballo";
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public boolean Movimiento(int F_Vieja, int C_Vieja, int F_Nueva, int C_Nueva, int Num1, Object Tablero[][]) {
        boolean Mover = false;
        if (F_Nueva == F_Vieja + 2 || F_Nueva == F_Vieja - 2) { //Arriba o Abajo
            if (C_Nueva == C_Vieja + 1 || C_Nueva == C_Vieja - 1) {
                Mover = true;
            }
        } else if (F_Nueva == F_Vieja + 1 || F_Nueva == F_Vieja - 1) {//Izq o derecha
            if (C_Nueva == C_Vieja + 2 || C_Nueva == C_Vieja - 2) {
                Mover = true;
            }
        } else {//Default, error.
            Mover = false;
        }
        if (Mover && Tablero[F_Nueva][C_Nueva] instanceof Piezas) {
            if (((Piezas) Tablero[F_Nueva][C_Nueva]).getId_Jugador() == ((Piezas) Tablero[F_Vieja][C_Vieja]).getId_Jugador()) {
                if (Num1 != 1) {
                    System.out.println("No puedes saltar piezas, la casilla coresponde a una casilla propia.");
                }
                return false;
            } else {
                if (Num1 == 1 && ((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
                    System.out.println("JAQUE");
                } else {
                    if (((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
                        System.out.println("JAQUE ");
                        Ganador = true;
                        JUGADORGANADOR = ((Piezas) Tablero[F_Vieja][C_Vieja]).getId_Jugador();
                    } else {
                        System.out.println("PIEZA CAPTURADA");
                    }
                }
                return true;
            }
        }
        return Mover;
    }

    @Override
    public boolean Restriccion(int F_Vieja, int C_Vieja, Object Matriz[][], int id) {
        boolean Acceso = true;
        if (F_Vieja == 0) {

        } else if (F_Vieja == 7) {

        } else {

        }
        return Acceso;
    }
}
