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

    public boolean MovimientoTorre(int F_Vieja, int C_Vieja, int F_Nueva, int C_Nueva, int Num1, Object[][] Tablero) {
        boolean Mover = false;
        int Dif_C = C_Nueva - C_Vieja;
        /*Valor - es a la izq y pos a la derecha */
        int Dif_F = F_Nueva - F_Vieja;
        int Cont = 1;
        int idActual = ((Piezas) Tablero[F_Vieja][C_Vieja]).getId_Jugador();
        int idOponente;
        if (idActual == 0) {
            idOponente = 1;
        } else {
            idOponente = 0;
        }
        if (F_Vieja == F_Nueva) {//En la misma fila(Izq o derecha
            if (Dif_C < 0) {//Movimiento a la izquierda.
                while (Cont <= (Dif_C * -1)) {
                    if (Tablero[F_Vieja][C_Vieja - Cont] instanceof Piezas) {
                        if (((Piezas) Tablero[F_Vieja][C_Vieja - Cont]).getId_Jugador() == idActual) {
                            if (Num1 != 1) {
                                System.out.println("No puedes saltar piezas, la casilla coresponde a una casilla propia.");

                            }
                            return false;
                        } else {//La Pieza es ajena.
                            if (C_Vieja - Cont > C_Nueva) {
                                if (Num1 != 1) {
                                    System.out.println("No puedes saltar piezas, la casilla coresponde a una casilla ajena.");

                                }
                                System.out.println("");
                                return false;
                            } else {
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
                                /* if (Num1 == 1 && ((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
                                    System.out.println("JAQUE");
                                } else {
                                    if (((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
                                        System.out.println("JAQUE MATE");
                                        Ganador = true;
                                        JUGADORGANADOR = ((Piezas) Tablero[F_Vieja][C_Vieja]).getId_Jugador();
                                    } else {
                                        System.out.println("PIEZA CAPTURADA");
                                    }
                                }*/
                                return true;
                            }
                        }
                    } else {
                        //System.out.println("Espacio Vacio es" + F_Vieja + "-" + (C_Vieja - Cont));
                    }
                    Cont++;
                }//Fin del while
                return true;/*SI LLEGO A ESTE PUNTO NO ENCONTRO NINGUNA PIEZA EN EL CAMINO*/

            } else {//Movimiento a la derecha
                while (Cont <= Dif_C) {
                    if (Tablero[F_Vieja][C_Vieja + Cont] instanceof Piezas) {
                        if (((Piezas) Tablero[F_Vieja][C_Vieja + Cont]).getId_Jugador() == idActual) {
                            if (Num1 != 1) {
                                System.out.println("No puedes saltar piezas, la casilla coresponde a una casilla propia.");

                            }
                            return false;
                        } else {//La Pieza es ajena.
                            if (C_Vieja + Cont < C_Nueva) {
                                if (Num1 != 1) {
                                    System.out.println("No puedes saltar piezas, la casilla coresponde a una casilla ajena.");

                                }
                                System.out.println("");
                                return false;
                            } else {
                                /*  if (Num1 == 1 && ((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
                                    System.out.println("JAQUE");
                                } else {
                                    if (((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
                                        System.out.println("JAQUE MATE");
                                        Ganador = true;
                                        JUGADORGANADOR = ((Piezas) Tablero[F_Vieja][C_Vieja]).getId_Jugador();
                                    } else {
                                        System.out.println("PIEZA CAPTURADA");
                                    }
                                }*/
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
                                return true;

                            }
                        }
                    } else {
                        // System.out.println("Espacio Vacio es" + F_Vieja + "-" + (C_Vieja - Cont));
                    }
                    Cont++;
                }//Fin del while.
                return true;
            }
        } else if (C_Nueva == C_Vieja) {//Misma  Columna(es arriba o abajo(
            if (Dif_F < 0) {//El Movimiento es hacia abajo.
                while (Cont <= (Dif_F * -1)) {
                    if (Tablero[F_Vieja - Cont][C_Vieja] instanceof Piezas) {
                        if (((Piezas) Tablero[F_Vieja - Cont][C_Vieja]).getId_Jugador() == idActual) {
                            if (Num1 != 1) {
                                System.out.println("No puedes saltar piezas, la casilla coresponde a una casilla propia.");

                            }
                            return false;
                        } else {//La Pieza es ajena.
                            if (F_Vieja - Cont > F_Nueva) {
                                if (Num1 != 1) {
                                    System.out.println("No puedes saltar piezas, la casilla coresponde a una casilla ajena.");

                                }
                                System.out.println("");
                                return false;
                            } else {
                                /* if (Num1 == 1 && ((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
                                    System.out.println("JAQUE");
                                } else {
                                    if (((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
                                        System.out.println("JAQUE MATE");
                                        Ganador = true;
                                        JUGADORGANADOR = ((Piezas) Tablero[F_Vieja][C_Vieja]).getId_Jugador();
                                    } else {
                                        System.out.println("PIEZA CAPTURADA");
                                    }
                                }*/
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
                                return true;
                            }
                        }
                    } else {
                        //System.out.println("Espacio Vacio es" + F_Vieja + "-" + (C_Vieja - Cont));
                    }
                    Cont++;
                }//Fin del while
                return true;/*SI LLEGO A ESTE PUNTO NO ENCONTRO NINGUNA PIEZA EN EL CAMINO*/

            } else {//Movimiento hacia arriba
                while (Cont <= Dif_F) {
                    if (Tablero[F_Vieja + Cont][C_Vieja] instanceof Piezas) {
                        if (((Piezas) Tablero[F_Vieja + Cont][C_Vieja]).getId_Jugador() == idActual) {
                            if (Num1 != 1) {
                                System.out.println("No puedes saltar piezas, la casilla coresponde a una casilla propia.");

                            }
                            return false;
                        } else {//La Pieza es ajena.
                            if (F_Vieja + Cont < F_Nueva) {
                                if (Num1 != 1) {
                                    System.out.println("No puedes saltar piezas, la casilla coresponde a una casilla ajena.");

                                }
                                System.out.println("");
                                return false;
                            } else {
                                /* if (Num1 == 1 && ((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
                                    System.out.println("JAQUE");
                                } else {
                                    if (((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
                                        System.out.println("JAQUE MATE");
                                        Ganador = true;
                                        JUGADORGANADOR = ((Piezas) Tablero[F_Vieja][C_Vieja]).getId_Jugador();
                                    } else {
                                        System.out.println("PIEZA CAPTURADA");
                                    }
                                }*/
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
                                return true;
                            }
                        }
                    } else {
                        //System.out.println("Espacio Vacio es" + F_Vieja + "-" + (C_Vieja - Cont));
                    }
                    Cont++;
                }//Fin del while
                return true;/*SI LLEGO A ESTE PUNTO NO ENCONTRO NINGUNA PIEZA EN EL CAMINO*/
            }
        }
        return Mover;
    }

    public boolean MovimientoAlfil(int F_Vieja, int C_Vieja, int F_Nueva, int C_Nueva, int Num1, Object[][] Tablero) {
        boolean Mover = false;
        int idActual = ((Piezas) Tablero[F_Vieja][C_Vieja]).getId_Jugador();
        int idOponente;
        if (idActual == 0) {
            idOponente = 1;
        } else {
            idOponente = 0;
        }
        int Cont = 1;
        int Num = 0;
        Num = F_Nueva - F_Vieja;
        /*if (F_Nueva < 0) {
            System.out.println("MOVIMIENTO HACIA ABAJO.");
        } else {
            System.out.println("MOVIMIENTO HACIA ARRIBA");
        }*/
        if (F_Vieja == 7) {

            //  }else if(){
        }
        if (C_Vieja + Num == C_Nueva || C_Vieja - Num == C_Nueva) {
            if (Num < 0) {//Movimiento hacia abajo
                if (C_Nueva < C_Vieja) {//Movimeinto hacia la izquierda
                    // System.out.println("MOVIMIENTO A LA IZQ." + F_Nueva + "<" + F_Vieja);
                    while (Cont <= (Num * -1)) {
                        if (F_Vieja - Cont >= 0 && C_Vieja - Cont >= 0) {
                            if (Tablero[F_Vieja - Cont][C_Vieja - Cont] instanceof Piezas) {
                                if (((Piezas) Tablero[F_Vieja - Cont][C_Vieja - Cont]).getId_Jugador() == idActual) {
                                    // System.out.println("Recorriendo la posicion" + (F_Vieja - Cont) + "-" + (C_Vieja - Cont));
                                    if (Num1 != 1) {
                                        System.out.println("No puedes saltar piezas, la casilla coresponde a una casilla propia.");
                                    }
                                    return false;
                                } else {//La Pieza es ajena.
                                    if (F_Vieja - Cont > F_Nueva) {
                                        if (Num1 != 1) {
                                            System.out.println("No puedes saltar piezas, la casilla coresponde a una casilla ajena.");
                                        }
                                        return false;
                                    } else {
                                        /*if (Num1 == 1 && ((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
                                            System.out.println("JAQUE");
                                        } else {
                                            if (((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
                                                System.out.println("JAQUE MATE");
                                                Ganador = true;
                                                JUGADORGANADOR = ((Piezas) Tablero[F_Vieja][C_Vieja]).getId_Jugador();
                                            } else {
                                                System.out.println("PIEZA CAPTURADA");
                                            }
                                        }*/
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
                                        return true;
                                    }
                                }
                            } else {
                                // System.out.println("Espacio Vacio es" + (F_Vieja - Cont) + "-" + (C_Vieja - Cont));
                            }
                            Cont++;
                        }//Fin del if que decide si estamos o no dentro del tablero.
                    }
                    // System.out.println("LLEGO HASTA AQUI, HAY CAMINO LIBRE");
                    return true;/*SI LLEGO A ESTE PUNTO NO ENCONTRO NINGUNA PIEZA EN EL CAMINO*/
                } else {//Movimeinto hacia la derecha
                    //  System.out.println("MOVIMIENTO A LA IZQ." + F_Nueva + ">" + F_Vieja);
                    while (Cont <= (Num * -1)) {
                        if (F_Vieja - Cont >= 0 && C_Vieja + Cont <= 7) {
                            if (Tablero[F_Vieja - Cont][C_Vieja + Cont] instanceof Piezas) {
                                if (((Piezas) Tablero[F_Vieja - Cont][C_Vieja + Cont]).getId_Jugador() == idActual) {
                                    //System.out.println("Recorriendo la posicion" + (F_Vieja - Cont) + "-" + (C_Vieja + Cont));
                                    if (Num1 != 1) {
                                        System.out.println("No puedes saltar piezas, la casilla coresponde a una casilla propia.");
                                    }
                                    return false;
                                } else {//La Pieza es ajena.
                                    if (F_Vieja - Cont > F_Nueva) {
                                        if (Num1 != 1) {
                                            System.out.println("No puedes saltar piezas, la casilla coresponde a una casilla ajena.");
                                        }
                                        System.out.println("");
                                        return false;
                                    } else {
                                        /*if (Num1 == 1 && ((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
                                            System.out.println("JAQUE");
                                        } else {
                                            if (((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
                                                System.out.println("JAQUE MATE");
                                                Ganador = true;
                                                JUGADORGANADOR = ((Piezas) Tablero[F_Vieja][C_Vieja]).getId_Jugador();
                                            } else {
                                                System.out.println("PIEZA CAPTURADA");
                                            }
                                        }*/
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
                                        return true;
                                    }
                                }
                            } else {
                                // System.out.println("Espacio Vacio es" + (F_Vieja - Cont) + "-" + (C_Vieja - Cont));
                            }
                            Cont++;
                        }//Fin del if que decide si estamos o no dentro del tablero.
                    }
                    //  System.out.println("LLEGO HASTA AQUI, HAY CAMINO LIBRE");
                    return true;/*SI LLEGO A ESTE PUNTO NO ENCONTRO NINGUNA PIEZA EN EL CAMINO*/
                }
                /*FIN DEL IF DE IZQ Y DERECHA*/
            } else {//Movimiento hacia arriba.
                if (C_Nueva < C_Vieja) {//Movimeinto hacia la izquierda
                    // System.out.println("MOVIMIENTO A LA IZQ." + F_Nueva + "<" + F_Vieja);
                    while (Cont <= Num) {
                        if (F_Vieja + Cont <= 7 && C_Vieja - Cont >= 0) {
                            if (Tablero[F_Vieja + Cont][C_Vieja - Cont] instanceof Piezas) {
                                if (((Piezas) Tablero[F_Vieja + Cont][C_Vieja - Cont]).getId_Jugador() == idActual) {
                                    // System.out.println("Recorriendo la posicion" + (F_Vieja + Cont) + "-" + (C_Vieja - Cont));
                                    if (Num1 != 1) {
                                        System.out.println("No puedes saltar piezas, la casilla coresponde a una casilla propia.");
                                    }
                                    return false;
                                } else {//La Pieza es ajena.
                                    if (F_Vieja + Cont < F_Nueva) {
                                        if (Num1 != 1) {
                                            System.out.println("No puedes saltar piezas, la casilla coresponde a una casilla ajena.");
                                        }
                                        System.out.println("");
                                        return false;
                                    } else {
                                        /*if (Num1 == 1 && ((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
                                            System.out.println("JAQUE");
                                        } else {
                                            if (((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
                                                System.out.println("JAQUE MATE");
                                                Ganador = true;
                                                JUGADORGANADOR = ((Piezas) Tablero[F_Vieja][C_Vieja]).getId_Jugador();
                                            } else {
                                                System.out.println("PIEZA CAPTURADA");
                                            }
                                        }*/
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
                                        return true;
                                    }
                                }
                            } else {
                                //System.out.println("Espacio Vacio es" + (F_Vieja + Cont) + "-" + (C_Vieja - Cont));
                            }
                            Cont++;
                        }//Fin del if que decide si estamos o no dentro del tablero.
                    }
                    // System.out.println("LLEGO HASTA AQUI, HAY CAMINO LIBRE");
                    return true;/*SI LLEGO A ESTE PUNTO NO ENCONTRO NINGUNA PIEZA EN EL CAMINO*/
                } else {//MOVIMIENTO HACIA LA DERECHA.
                    while (Cont <= Num) {
                        //System.out.println("MOVIMIENTO A LA IZQ." + F_Nueva + ">" + F_Vieja);
                        if (F_Vieja + Cont <= 7 && C_Vieja + Cont <= 7) {
                            if (Tablero[F_Vieja + Cont][C_Vieja + Cont] instanceof Piezas) {
                                if (((Piezas) Tablero[F_Vieja + Cont][C_Vieja + Cont]).getId_Jugador() == idActual) {
                                    //System.out.println("Recorriendo la posicion" + (F_Vieja + Cont) + "-" + (C_Vieja + Cont));
                                    if (Num1 != 1) {
                                        System.out.println("No puedes saltar piezas, la casilla coresponde a una casilla propia.");
                                    }
                                    return false;
                                } else {//La Pieza es ajena.
                                    if (F_Vieja + Cont < F_Nueva) {
                                        if (Num1 != 1) {
                                            System.out.println("No puedes saltar piezas, la casilla coresponde a una casilla ajena.");
                                        }
                                        System.out.println("");
                                        return false;
                                    } else {
                                        /* if (Num1 == 1 && ((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
                                            System.out.println("JAQUE");
                                        } else {
                                            if (((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
                                                System.out.println("JAQUE MATE");
                                                Ganador = true;
                                                JUGADORGANADOR = ((Piezas) Tablero[F_Vieja][C_Vieja]).getId_Jugador();
                                            } else {
                                                System.out.println("PIEZA CAPTURADA");
                                            }
                                        }*/
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
                                        return true;
                                    }
                                }
                            } else {
                                // System.out.println("Espacio Vacio es" + F_Vieja + Cont + "-" + (C_Vieja - Cont));
                            }
                            Cont++;
                        }//Fin del if que decide si estamos o no dentro del tablero.
                    }
                    // System.out.println("LLEGO HASTA AQUI, HAY CAMINO LIBRE");
                    return true;

                }
            }//FIN DEL IF QUE DETERMINA LA ORIENTACION DEL MOVIMIENTO.
        }
        return Mover;
    }

//    public static boolean MovimientoTorre(int F_Vieja, int C_Vieja, int F_Nueva, int C_Nueva, int Num) {
//        boolean Mover = false;
//        int Dif_C = C_Nueva - C_Vieja;
//        /*Valor - es a la izq y pos a la derecha */
//        int Dif_F = F_Nueva - F_Vieja;
//        int Cont = 1;
//        int idActual = ((Piezas) Tablero[F_Vieja][C_Vieja]).getId_Jugador();
//        int idOponente;
//        if (idActual == 0) {
//            idOponente = 1;
//        } else {
//            idOponente = 0;
//        }
//        if (F_Vieja == F_Nueva) {//En la misma fila(Izq o derecha
//            if (Dif_C < 0) {//Movimiento a la izquierda.
//                while (Cont <= (Dif_C * -1)) {
//                    if (Tablero[F_Vieja][C_Vieja - Cont] instanceof Piezas) {
//                        if (((Piezas) Tablero[F_Vieja][C_Vieja - Cont]).getId_Jugador() == idActual) {
//                            if (Num != 1) {
//                                System.out.println("No puedes saltar piezas, la casilla coresponde a una casilla propia.");
//
//                            }
//                            return false;
//                        } else {//La Pieza es ajena.
//                            if (C_Vieja - Cont > C_Nueva) {
//                                if (Num != 1) {
//                                    System.out.println("No puedes saltar piezas, la casilla coresponde a una casilla Ajena.");
//
//                                }
//                                System.out.println("");
//                                return false;
//                            } else {
//                                if (Num == 1 && ((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
//
//                                    System.out.println("\033[33m ☢ JAQUE ☢ \033[30m");
//                                } else {
//                                    if (((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
//                                        System.out.println("\033[31m ☠ JAQUE MATE ☠ \033[30m");
//                                        Ganador = true;
//                                        JUGADORGANADOR = ((Piezas) Tablero[F_Vieja][C_Vieja]).getId_Jugador();
//                                    } else {
//                                        System.out.println("\033[32m ★ PIEZA CAPTURADA ★\033[30m");
//                                    }
//                                }
//                                /* if (Num == 1 && ((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
//                                    System.out.println("JAQUE");
//                                } else {
//                                    if (((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
//                                        System.out.println("JAQUE MATE");
//                                        Ganador = true;
//                                        JUGADORGANADOR = ((Piezas) Tablero[F_Vieja][C_Vieja]).getId_Jugador();
//                                    } else {
//                                        System.out.println("PIEZA CAPTURADA");
//                                    }
//                                }*/
//                                return true;
//                            }
//                        }
//                    } else {
//                        //System.out.println("Espacio Vacio es" + F_Vieja + "-" + (C_Vieja - Cont));
//                    }
//                    Cont++;
//                }//Fin del while
//                return true;/*SI LLEGO A ESTE PUNTO NO ENCONTRO NINGUNA PIEZA EN EL CAMINO*/
//
//            } else {//Movimiento a la derecha
//                while (Cont <= Dif_C) {
//                    if (Tablero[F_Vieja][C_Vieja + Cont] instanceof Piezas) {
//                        if (((Piezas) Tablero[F_Vieja][C_Vieja + Cont]).getId_Jugador() == idActual) {
//                            if (Num != 1) {
//                                System.out.println("No puedes saltar piezas, la casilla coresponde a una casilla propia.");
//
//                            }
//                            return false;
//                        } else {//La Pieza es ajena.
//                            if (C_Vieja + Cont < C_Nueva) {
//                                if (Num != 1) {
//                                    System.out.println("No puedes saltar piezas, la casilla coresponde a una casilla ajena.");
//
//                                }
//                                System.out.println("");
//                                return false;
//                            } else {
//                                /* if (Num == 1 && ((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
//                                    System.out.println("JAQUE");
//                                } else {
//                                    if (((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
//                                        System.out.println("JAQUE MATE");
//                                        Ganador = true;
//                                        JUGADORGANADOR = ((Piezas) Tablero[F_Vieja][C_Vieja]).getId_Jugador();
//                                    } else {
//                                        System.out.println("PIEZA CAPTURADA");
//                                    }
//                                }*/
//                                if (Num == 1 && ((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
//
//                                    System.out.println("\033[33m ☢ JAQUE ☢ \033[30m");
//                                } else {
//                                    if (((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
//                                        System.out.println("\033[31m ☠ JAQUE MATE ☠ \033[30m");
//                                        Ganador = true;
//                                        JUGADORGANADOR = ((Piezas) Tablero[F_Vieja][C_Vieja]).getId_Jugador();
//                                    } else {
//                                        System.out.println("\033[32m ★ PIEZA CAPTURADA ★\033[30m");
//                                    }
//                                }
//                                return true;
//
//                            }
//                        }
//                    } else {
//                        // System.out.println("Espacio Vacio es" + F_Vieja + "-" + (C_Vieja - Cont));
//                    }
//                    Cont++;
//                }//Fin del while.
//                return true;
//            }
//        } else if (C_Nueva == C_Vieja) {//Misma  Columna(es arriba o abajo(
//            if (Dif_F < 0) {//El Movimiento es hacia abajo.
//                while (Cont <= (Dif_F * -1)) {
//                    if (Tablero[F_Vieja - Cont][C_Vieja] instanceof Piezas) {
//                        if (((Piezas) Tablero[F_Vieja - Cont][C_Vieja]).getId_Jugador() == idActual) {
//                            if (Num != 1) {
//                                System.out.println("No puedes saltar piezas, la casilla coresponde a una casilla propia.");
//
//                            }
//                            return false;
//                        } else {//La Pieza es ajena.
//                            if (F_Vieja - Cont > F_Nueva) {
//                                if (Num != 1) {
//                                    System.out.println("No puedes saltar piezas, la casilla coresponde a una casilla ajena.");
//
//                                }
//                                System.out.println("");
//                                return false;
//                            } else {
//                                /* if (Num == 1 && ((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
//                                    System.out.println("JAQUE");
//                                } else {
//                                    if (((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
//                                        System.out.println("JAQUE MATE");
//                                        Ganador = true;
//                                        JUGADORGANADOR = ((Piezas) Tablero[F_Vieja][C_Vieja]).getId_Jugador();
//                                    } else {
//                                        System.out.println("PIEZA CAPTURADA");
//                                    }
//                                }*/
//                                if (Num == 1 && ((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
//
//                                    System.out.println("\033[33m ☢ JAQUE ☢ \033[30m");
//                                } else {
//                                    if (((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
//                                        System.out.println("\033[31m ☠ JAQUE MATE ☠ \033[30m");
//                                        Ganador = true;
//                                        JUGADORGANADOR = ((Piezas) Tablero[F_Vieja][C_Vieja]).getId_Jugador();
//                                    } else {
//                                        System.out.println("\033[32m ★ PIEZA CAPTURADA ★\033[30m");
//                                    }
//                                }
//                                return true;
//                            }
//                        }
//                    } else {
//                        //System.out.println("Espacio Vacio es" + F_Vieja + "-" + (C_Vieja - Cont));
//                    }
//                    Cont++;
//                }//Fin del while
//                return true;/*SI LLEGO A ESTE PUNTO NO ENCONTRO NINGUNA PIEZA EN EL CAMINO*/
//
//            } else {//Movimiento hacia arriba
//                while (Cont <= Dif_F) {
//                    if (Tablero[F_Vieja + Cont][C_Vieja] instanceof Piezas) {
//                        if (((Piezas) Tablero[F_Vieja + Cont][C_Vieja]).getId_Jugador() == idActual) {
//                            if (Num != 1) {
//                                System.out.println("No puedes saltar piezas, la casilla coresponde a una casilla propia.");
//
//                            }
//                            return false;
//                        } else {//La Pieza es ajena.
//                            if (F_Vieja + Cont < F_Nueva) {
//                                if (Num != 1) {
//                                    System.out.println("No puedes saltar piezas, la casilla coresponde a una casilla ajena.");
//
//                                }
//                                System.out.println("");
//                                return false;
//                            } else {
//                                /* if (Num == 1 && ((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
//                                    System.out.println("JAQUE");
//                                } else {
//                                    if (((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
//                                        System.out.println("JAQUE MATE");
//                                        Ganador = true;
//                                        JUGADORGANADOR = ((Piezas) Tablero[F_Vieja][C_Vieja]).getId_Jugador();
//                                    } else {
//                                        System.out.println("PIEZA CAPTURADA");
//                                    }
//                                }*/
//                                if (Num == 1 && ((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
//
//                                    System.out.println("\033[33m ☢ JAQUE ☢ \033[30m");
//                                } else {
//                                    if (((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
//                                        System.out.println("\033[31m ☠ JAQUE MATE ☠ \033[30m");
//                                        Ganador = true;
//                                        JUGADORGANADOR = ((Piezas) Tablero[F_Vieja][C_Vieja]).getId_Jugador();
//                                    } else {
//                                        System.out.println("\033[32m ★ PIEZA CAPTURADA ★\033[30m");
//                                    }
//                                }
//                                return true;
//                            }
//                        }
//                    } else {
//                        //System.out.println("Espacio Vacio es" + F_Vieja + "-" + (C_Vieja - Cont));
//                    }
//                    Cont++;
//                }//Fin del while
//                return true;/*SI LLEGO A ESTE PUNTO NO ENCONTRO NINGUNA PIEZA EN EL CAMINO*/
//            }
//        }
//        return Mover;
//
//    }
//
//    public static boolean MovimientoAlfil(int F_Vieja, int C_Vieja, int F_Nueva, int C_Nueva, int Num1) {
//        boolean Mover = false;
//        int idActual = ((Piezas) Tablero[F_Vieja][C_Vieja]).getId_Jugador();
//        int idOponente;
//        if (idActual == 0) {
//            idOponente = 1;
//        } else {
//            idOponente = 0;
//        }
//        int Cont = 1;
//        int Num = 0;
//        Num = F_Nueva - F_Vieja;
//        /*if (F_Nueva < 0) {
//            System.out.println("MOVIMIENTO HACIA ABAJO.");
//        } else {
//            System.out.println("MOVIMIENTO HACIA ARRIBA");
//        }*/
//        if (C_Vieja + Num == C_Nueva || C_Vieja - Num == C_Nueva) {
//            if (Num < 0) {//Movimiento hacia abajo
//                if (C_Nueva < C_Vieja) {//Movimeinto hacia la izquierda
//                    // System.out.println("MOVIMIENTO A LA IZQ." + F_Nueva + "<" + F_Vieja);
//                    while (Cont <= (Num * -1)) {
//                        if (F_Vieja - Cont >= 0 && C_Vieja - Cont >= 0) {
//                            if (Tablero[F_Vieja - Cont][C_Vieja - Cont] instanceof Piezas) {
//                                if (((Piezas) Tablero[F_Vieja - Cont][C_Vieja - Cont]).getId_Jugador() == idActual) {
//                                    //  System.out.println("Recorriendo la posicion" + (F_Vieja - Cont) + "-" + (C_Vieja - Cont));
//                                    if (Num1 != 1) {
//                                        System.out.println("No puedes saltar piezas, la casilla coresponde a una casilla propia.");
//
//                                    }
//                                    return false;
//                                } else {//La Pieza es ajena.
//                                    if (F_Vieja - Cont > F_Nueva) {
//                                        if (Num1 != 1) {
//                                            System.out.println("No puedes saltar piezas, la casilla coresponde a una casilla ajena.");
//
//                                        }
//                                        System.out.println("");
//                                        return false;
//                                    } else {
//                                        /*  if (Num1 == 1 && ((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
//                                            System.out.println("JAQUE");
//                                        } else {
//                                            if (((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
//                                                System.out.println("JAQUE MATE");
//                                                Ganador = true;
//                                                JUGADORGANADOR = ((Piezas) Tablero[F_Vieja][C_Vieja]).getId_Jugador();
//                                            } else {
//                                                System.out.println("PIEZA CAPTURADA");
//                                            }
//                                        }*/
//                                        if (Num1 == 1 && ((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
//
//                                            System.out.println("\033[33m ☢ JAQUE ☢ \033[30m");
//                                        } else {
//                                            if (((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
//                                                System.out.println("\033[31m ☠ JAQUE MATE ☠ \033[30m");
//                                                Ganador = true;
//                                                JUGADORGANADOR = ((Piezas) Tablero[F_Vieja][C_Vieja]).getId_Jugador();
//                                            } else {
//                                                System.out.println("\033[32m ★ PIEZA CAPTURADA ★\033[30m");
//                                            }
//                                        }
//                                        return true;
//                                    }
//                                }
//                            } else {
//                                // System.out.println("Espacio Vacio es" + (F_Vieja - Cont) + "-" + (C_Vieja - Cont));
//                            }
//                            Cont++;
//                        }//Fin del if que decide si estamos o no dentro del tablero.
//                    }
//                    // System.out.println("LLEGO HASTA AQUI, HAY CAMINO LIBRE");
//                    return true;/*SI LLEGO A ESTE PUNTO NO ENCONTRO NINGUNA PIEZA EN EL CAMINO*/
//                } else {//Movimeinto hacia la derecha
//                    //  System.out.println("MOVIMIENTO A LA IZQ." + F_Nueva + ">" + F_Vieja);
//                    while (Cont <= (Num * -1)) {
//                        if (F_Vieja - Cont >= 0 && C_Vieja + Cont <= 7) {
//                            if (Tablero[F_Vieja - Cont][C_Vieja + Cont] instanceof Piezas) {
//                                if (((Piezas) Tablero[F_Vieja - Cont][C_Vieja + Cont]).getId_Jugador() == idActual) {
//                                    //System.out.println("Recorriendo la posicion" + (F_Vieja - Cont) + "-" + (C_Vieja + Cont));
//                                    if (Num1 != 1) {
//                                        System.out.println("No puedes saltar piezas, la casilla coresponde a una casilla propia.");
//
//                                    }
//                                    return false;
//                                } else {//La Pieza es ajena.
//                                    if (F_Vieja - Cont > F_Nueva) {
//                                        if (Num1 != 1) {
//                                            System.out.println("No puedes saltar piezas, la casilla coresponde a una casilla ajena.");
//
//                                        }
//                                        System.out.println("");
//                                        return false;
//                                    } else {
//                                        /*if (Num1 == 1 && ((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
//                                            System.out.println("JAQUE");
//                                        } else {
//                                            if (((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
//                                                System.out.println("JAQUE MATE");
//                                                Ganador = true;
//                                                JUGADORGANADOR = ((Piezas) Tablero[F_Vieja][C_Vieja]).getId_Jugador();
//                                            } else {
//                                                System.out.println("PIEZA CAPTURADA");
//                                            }
//                                        }*/
//                                        if (Num1 == 1 && ((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
//
//                                            System.out.println("\033[33m ☢ JAQUE ☢ \033[30m");
//                                        } else {
//                                            if (((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
//                                                System.out.println("\033[31m ☠ JAQUE MATE ☠ \033[30m");
//                                                Ganador = true;
//                                                JUGADORGANADOR = ((Piezas) Tablero[F_Vieja][C_Vieja]).getId_Jugador();
//                                            } else {
//                                                System.out.println("\033[32m ★ PIEZA CAPTURADA ★\033[30m");
//                                            }
//                                        }
//                                        return true;
//                                    }
//                                }
//                            } else {
//                                // System.out.println("Espacio Vacio es" + (F_Vieja - Cont) + "-" + (C_Vieja - Cont));
//                            }
//                            Cont++;
//                        }//Fin del if que decide si estamos o no dentro del tablero.
//                    }
//                    //  System.out.println("LLEGO HASTA AQUI, HAY CAMINO LIBRE");
//                    return true;/*SI LLEGO A ESTE PUNTO NO ENCONTRO NINGUNA PIEZA EN EL CAMINO*/
//                }
//                /*FIN DEL IF DE IZQ Y DERECHA*/
//            } else {//Movimiento hacia arriba.
//                if (C_Nueva < C_Vieja) {//Movimeinto hacia la izquierda
//                    // System.out.println("MOVIMIENTO A LA IZQ." + F_Nueva + "<" + F_Vieja);
//                    while (Cont <= Num) {
//                        if (F_Vieja + Cont <= 7 && C_Vieja - Cont >= 0) {
//                            if (Tablero[F_Vieja + Cont][C_Vieja - Cont] instanceof Piezas) {
//                                if (((Piezas) Tablero[F_Vieja + Cont][C_Vieja - Cont]).getId_Jugador() == idActual) {
//                                    // System.out.println("Recorriendo la posicion" + (F_Vieja + Cont) + "-" + (C_Vieja - Cont));
//                                    if (Num1 != 1) {
//                                        System.out.println("No puedes saltar piezas, la casilla coresponde a una casilla propia.");
//
//                                    }
//                                    return false;
//                                } else {//La Pieza es ajena.
//                                    if (F_Vieja + Cont < F_Nueva) {
//                                        if (Num1 != 1) {
//                                            System.out.println("No puedes saltar piezas, la casilla coresponde a una casilla ajena.");
//
//                                        }
//                                        System.out.println("");
//                                        return false;
//                                    } else {
//                                        /* if (Num1 == 1 && ((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
//                                            System.out.println("JAQUE");
//                                        } else {
//                                            if (((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
//                                                System.out.println("JAQUE MATE");
//                                                Ganador = true;
//                                                JUGADORGANADOR = ((Piezas) Tablero[F_Vieja][C_Vieja]).getId_Jugador();
//                                            } else {
//                                                System.out.println("PIEZA CAPTURADA");
//                                            }
//                                        }*/
//                                        if (Num1 == 1 && ((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
//
//                                            System.out.println("\033[33m ☢ JAQUE ☢ \033[30m");
//                                        } else {
//                                            if (((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
//                                                System.out.println("\033[31m ☠ JAQUE MATE ☠ \033[30m");
//                                                Ganador = true;
//                                                JUGADORGANADOR = ((Piezas) Tablero[F_Vieja][C_Vieja]).getId_Jugador();
//                                            } else {
//                                                System.out.println("\033[32m ★ PIEZA CAPTURADA ★\033[30m");
//                                            }
//                                        }
//                                        return true;
//                                    }
//                                }
//                            } else {
//                                //System.out.println("Espacio Vacio es" + (F_Vieja + Cont) + "-" + (C_Vieja - Cont));
//                            }
//                            Cont++;
//                        }//Fin del if que decide si estamos o no dentro del tablero.
//                    }
//                    // System.out.println("LLEGO HASTA AQUI, HAY CAMINO LIBRE");
//                    return true;/*SI LLEGO A ESTE PUNTO NO ENCONTRO NINGUNA PIEZA EN EL CAMINO*/
//                } else {//MOVIMIENTO HACIA LA DERECHA.
//                    while (Cont <= Num) {
//                        //System.out.println("MOVIMIENTO A LA IZQ." + F_Nueva + ">" + F_Vieja);
//                        if (F_Vieja + Cont <= 7 && C_Vieja + Cont <= 7) {
//                            if (Tablero[F_Vieja + Cont][C_Vieja + Cont] instanceof Piezas) {
//                                if (((Piezas) Tablero[F_Vieja + Cont][C_Vieja + Cont]).getId_Jugador() == idActual) {
//                                    //System.out.println("Recorriendo la posicion" + (F_Vieja + Cont) + "-" + (C_Vieja + Cont));
//                                    if (Num1 != 1) {
//                                        System.out.println("No puedes saltar piezas, la casilla coresponde a una casilla propia.");
//
//                                    }
//                                    return false;
//                                } else {//La Pieza es ajena.
//                                    if (F_Vieja + Cont < F_Nueva) {
//                                        if (Num1 != 1) {
//                                            System.out.println("No puedes saltar piezas, la casilla coresponde a una casilla ajena.");
//
//                                        }
//                                        System.out.println("");
//                                        return false;
//                                    } else {
//                                        /* if (Num1 == 1 && ((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
//                                            System.out.println("JAQUE");
//                                        } else {
//                                            if (((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
//                                                System.out.println("JAQUE MATE");
//                                                Ganador = true;
//                                                JUGADORGANADOR = ((Piezas) Tablero[F_Vieja][C_Vieja]).getId_Jugador();
//                                            } else {
//                                                System.out.println("PIEZA CAPTURADA");
//                                            }
//                                        }*/
//                                        if (Num1 == 1 && ((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
//
//                                            System.out.println("\033[33m ☢ JAQUE ☢ \033[30m");
//                                        } else {
//                                            if (((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
//                                                System.out.println("\033[31m ☠ JAQUE MATE ☠ \033[30m");
//                                                Ganador = true;
//                                                JUGADORGANADOR = ((Piezas) Tablero[F_Vieja][C_Vieja]).getId_Jugador();
//                                            } else {
//                                                System.out.println("\033[32m ★ PIEZA CAPTURADA ★\033[30m");
//                                            }
//                                        }
//                                        return true;
//                                    }
//                                }
//                            } else {
//                                // System.out.println("Espacio Vacio es" + F_Vieja + Cont + "-" + (C_Vieja - Cont));
//                            }
//                            Cont++;
//                        }//Fin del if que decide si estamos o no dentro del tablero.
//                    }
//                    // System.out.println("LLEGO HASTA AQUI, HAY CAMINO LIBRE");
//                    return true;
//
//                }
//            }//FIN DEL IF QUE DETERMINA LA ORIENTACION DEL MOVIMIENTO.
//        }
//        return Mover;
//    }//Fin del metodo.
}

/*
       
 */
