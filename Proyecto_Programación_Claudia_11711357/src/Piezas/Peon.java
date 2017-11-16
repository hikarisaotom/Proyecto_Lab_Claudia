/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Piezas;

import static proyecto_programación_claudia_11711357.Proyecto_Programación_Claudia_11711357.Ganador;
import static proyecto_programación_claudia_11711357.Proyecto_Programación_Claudia_11711357.JUGADORGANADOR;
//import static proyecto_programación_claudia_11711357.Proyecto_Programación_Claudia_11711357.PeonComer;
import static proyecto_programación_claudia_11711357.Proyecto_Programación_Claudia_11711357.Tablero;

/**
 *
 * @author Claudia Cortes
 */
public class Peon extends Piezas {
//private String simbolo="P";

    public Peon() {
        super();
        super.simbolo = "♙";
        super.Nombre = "Peon";
    }

    @Override
    public boolean Restriccion(int F_Vieja, int C_Vieja, Object Matriz[][], int id) {
        boolean Acceso = false;
        if (id == 0) {
            if (C_Vieja == 0) {
                if (Matriz[F_Vieja + 1][C_Vieja] instanceof Piezas && (Matriz[F_Vieja + 1][C_Vieja + 1] instanceof String)) {
                    Acceso = false;
                } else {
                    Acceso = true;
                }
            } else if (C_Vieja == 7) {
                System.out.println("el error esta aqui perro");
                if (Matriz[F_Vieja + 1][C_Vieja] instanceof Piezas && (Matriz[F_Vieja + 1][C_Vieja - 1] instanceof String)) {
                    Acceso = false;
                } else {
                    Acceso = true;
                }
            } else {
                if (Matriz[F_Vieja + 1][C_Vieja] instanceof Piezas && (Matriz[F_Vieja + 1][C_Vieja + 1] instanceof String) && (Matriz[F_Vieja + 1][C_Vieja - 1] instanceof String)) {
                    Acceso = false;
                } else {
                    Acceso = true;
                }
            }
        } else {//EL JUGADOR ES EL NUMEro 2
            if (C_Vieja == 0) {
                if (Matriz[F_Vieja - 1][C_Vieja] instanceof Piezas && (Matriz[F_Vieja - 1][C_Vieja + 1] instanceof String)) {
                    Acceso = false;
                } else {
                    Acceso = true;
                }
            } else if (C_Vieja == 7) {
                if (Matriz[F_Vieja - 1][C_Vieja] instanceof Piezas && (Matriz[F_Vieja - 1][C_Vieja - 1] instanceof String)) {
                    Acceso = false;
                } else {
                    Acceso = true;
                }
            } else {
                if (Matriz[F_Vieja - 1][C_Vieja] instanceof Piezas && (Matriz[F_Vieja - 1][C_Vieja + 1] instanceof String) && (Matriz[F_Vieja - 1][C_Vieja - 1] instanceof String)) {
                    Acceso = false;
                } else {
                    Acceso = true;
                }
            }
        }
        return Acceso;
    }

    public boolean Movimiento(int F_Vieja, int C_Vieja, int F_Nueva, int C_Nueva, int Num1, Object[][] Tablero) {
        boolean Mover = false;
        int Num = 0;
        int Num2 = 0;
        int idActual = ((Piezas) Tablero[F_Vieja][C_Vieja]).getId_Jugador();
        int idOponente;
        if (idActual == 0) {
            idOponente = 1;
        } else {
            idOponente = 0;
        }
        
        if (((Piezas) Tablero[F_Vieja][C_Vieja]).getId_Jugador() == 0) {
            Num = 2;
            Num2 = 1;
        } else {
            Num = -2;
            Num2 = -1;
        }
        if (PeonComer(F_Vieja, C_Vieja, F_Nueva, C_Nueva, Num1)) {
            return true;
        }
        /*  if (((idActual==1&&F_Nueva==F_Vieja-1)||(idActual==0&&F_Nueva==F_Vieja+1))&&C_Vieja==C_Nueva&&Tablero[F_Nueva+Num2][C_Vieja]instanceof String) {
            return true;
        }*/
        //System.out.println("NUM2"+Num2);
        if (((Piezas) Tablero[F_Vieja][C_Vieja]).getPosicion().equals(F_Vieja + "-" + C_Vieja) &&( F_Vieja+Num == F_Nueva && C_Vieja == C_Nueva)) {//En caso de que sea su primer movimiento
//            System.out.println("Puede moverse dos para arriba");
//            System.out.println("PIEZA EN PSICION"+F_Vieja+"-"+C_Vieja);
            System.out.println("POSICOION ORIGINAL"+((Piezas) Tablero[F_Vieja][C_Vieja]).getPosicion());
            if (F_Vieja + Num == F_Nueva && C_Vieja == C_Nueva || F_Vieja + Num2 == F_Nueva && C_Vieja == C_Nueva) { //Solo puede moverse 2 casillas maximo
                for (int i = 1; i < 3; i++) {
                    if (idActual == 0) {
                        if (Tablero[F_Vieja + i][C_Nueva] instanceof Piezas && idActual == 0) {
                            if (Num1 != 1) {
                               // System.out.println("ENTRO A LA EXCEPCION DEL MAIN");
                                System.out.println("EL PEON TIENE EL PASO BLOQUEADO");
                            }

                            return false;
                        }

                    } else {
                        //  System.out.println("JUGADOR 2");
                        if (Tablero[F_Vieja - i][C_Nueva] instanceof Piezas && idActual == 0) {
                            if (Num1 != 1) {
                                System.out.println("");
                                System.out.println("EL PEON TIENE EL PASO BLOQUEADO");
                            }
                            return false;
                        }
                    }

                }
                return true;
            } else {
                return false;
            }
        } else {//En caso de que no sea su primer movimiento.

            if (Tablero[F_Nueva][C_Nueva] instanceof Piezas) {
                if (Num1 != 1) {
                    System.out.println("EL PEON TIENE EL PASO BLOQUEADO");
                }
            } else if (F_Vieja + Num2 == F_Nueva && C_Vieja == C_Nueva && Tablero[F_Nueva][C_Nueva] instanceof String) {
                return true;
            }

        }
        return Mover;
    }

    public static boolean PeonComer(int F_Vieja, int C_Vieja, int F_Nueva, int C_Nueva, int Num1) {
      /*  if (Num1==1) {
            System.out.println("LA POSICION DEL REY QUE RECIBO"+F_Nueva+"-"+C_Nueva);
        }*/
        boolean Mover = false;
        int idActual = ((Piezas) Tablero[F_Vieja][C_Vieja]).getId_Jugador();
        int idOponente;
        if (idActual == 0) {
            idOponente = 1;
        } else {
            idOponente = 0;
        }

        int Num = 0;
        Num = F_Nueva - F_Vieja;
        

        if ((Num == 1 && idActual == 0) || (Num == -1 && idActual == 1)) {
            //System.out.println("Num"+Num+"Id Atual"+idActual);
            if (C_Vieja + Num == C_Nueva || C_Vieja - Num == C_Nueva
                    && (C_Nueva <= 7 && C_Nueva >= 0) && (F_Nueva <= 7 && F_Nueva >= 0)) {
                if (Tablero[F_Nueva][C_Nueva] instanceof Piezas && ((Piezas) Tablero[F_Nueva][C_Nueva]).getId_Jugador() == idOponente) {
                    //System.out.println("EL ERROR ESTA AQUI");
                    if (C_Vieja == 0) {
                        if (((Piezas) Tablero[F_Vieja + Num][C_Vieja + 1]).getId_Jugador() == idOponente) {

                               if (Num1 == 1 && ((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
                                 
                                System.out.println("\033[33m ☢ JAQUE ☢ \033[30m");
                            } else {
                                if (((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
                                    System.out.println("\033[31m ☠ JAQUE MATE ☠ \033[30m");
                                    Ganador = true;
                                    JUGADORGANADOR = ((Piezas) Tablero[F_Vieja][C_Vieja]).getId_Jugador();
                                } else {
                                    System.out.println("\033[32m ★ PIEZA CAPTURADA ★\033[30m");
                                }
                            }
                            Mover = true;
                            //  System.out.println("PIEZA COMIDA!");
                        }

                        /*AQUI TERMINA*/
                    } else if (C_Vieja == 7) {
                        if (((Piezas) Tablero[F_Vieja + Num][C_Vieja - 1]).getId_Jugador() == idOponente) {
                                if (Num1 == 1 && ((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
                                 
                                System.out.println("\033[33m ☢ JAQUE ☢ \033[30m");
                            } else {
                                if (((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
                                    System.out.println("\033[31m ☠ JAQUE MATE ☠ \033[30m");
                                    Ganador = true;
                                    JUGADORGANADOR = ((Piezas) Tablero[F_Vieja][C_Vieja]).getId_Jugador();
                                } else {
                                    System.out.println("\033[32m ★ PIEZA CAPTURADA ★\033[30m");
                                }
                            }
                            Mover = true;
                            //  System.out.println("PIEZA COMIDA!");
                        }
                        /*AQUI TERMINO*/
                    } else {
                       // System.out.println("ERROR EN EL ELSE");
                       // System.out.println("EL NUMERO " + Num);
                        //System.out.println("FILA: " + (F_Vieja + Num) + " Columna: " + (C_Vieja + Num));
                        //((Piezas) Tablero[F_Vieja + Num][C_Vieja + Num]).getId_Jugador() == idOponente || ((Piezas) Tablero[F_Vieja + Num][C_Vieja - Num]).getId_Jugador() == idOponente
                        if (Tablero[F_Vieja + Num][C_Vieja + Num] instanceof Piezas||Tablero[F_Vieja + Num][C_Vieja - Num] instanceof Piezas) {

                             if (Num1 == 1 && ((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
                                 
                                System.out.println("\033[33m ☢ JAQUE ☢ \033[30m");
                            } else {
                                if (((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
                                    System.out.println("\033[31m ☠ JAQUE MATE ☠ \033[30m");
                                    Ganador = true;
                                    JUGADORGANADOR = ((Piezas) Tablero[F_Vieja][C_Vieja]).getId_Jugador();
                                } else {
                                    System.out.println("\033[32m ★ PIEZA CAPTURADA ★\033[30m");
                                }
                            }
                            Mover = true;
                            //  System.out.println("PIEZA COMIDA!");
                        }
                    }
                } else {
                    System.out.println("LA POSICION CORRESPONDE A UNA PIEZA PROPIA");
                }
            }
        } else {
            Mover = false;
        }
        return Mover;
    }
}
