package proyecto_programación_claudia_11711357;

import Piezas.*;
import Jugadores.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Proyecto_Programación_Claudia_11711357 {

    public static ArrayList<Jugador> Jugadores = new ArrayList();
    public static Object[][] Tablero;
    public static Scanner SC = new Scanner(System.in);
    public static boolean Ganador = false;
    public static int Turno = 0;

    public static void main(String[] args) {
        System.out.println("Ingrese el Nombre del Jugador 1");
        String Nombre = SC.next();
        System.out.println("Seleccione el color con el que desea jugar: \n\n"
                + " 1)\033[32mVerdes.\033[30m \n2)\033[36mCyan.\033[30m");
        int ID = SC.nextInt();
        Jugadores.add(new Jugador(Nombre, 0, ID));
        if (ID == 1) {
            ID = 2;
        } else {
            ID = 1;
        }
        System.out.println("Ingrese el Nombre del Jugador 2");
        Nombre = SC.next();
        Jugadores.add(new Jugador(Nombre, 1, ID));
        Tablero = Llenar_Matriz();
        Tablero = Cargar_Piezas(Tablero);

        while (true) {
            if (Ganador) {
                System.out.println("Felicidades " + Jugadores.get(Turno).getNombre() + " ha ganado!");
            }
            System.out.println("");
            System.out.println("Turno de " + Jugadores.get(Turno).getNombre());
            System.out.println("");
            switch (Turno) {
                case 0:
                    Imprimir_Matriz(Tablero, 7, 0);
                    System.out.println("");
                    CambiarPosicion(Turno);
                    Turno = 1;
                    System.out.println("");
                    break;
                case 1:
                    Imprimir_Matriz(Tablero, 7, 0);
                    System.out.println("");
                    CambiarPosicion(Turno);
                    // Imprimir_Matriz(Tablero, 7, 0);
                    Turno = 0;
                    break;
            }
            System.out.println("NUEVAS POSICIONES");
            Imprimir_Matriz(Tablero, 7, 0);
            System.out.println("");

        }

    }

    public static Object[][] Llenar_Matriz() {
        Object[][] Tablero = new Object[8][8];
        boolean Bandera = false;
        for (int i = 0; i < 8; i++) {
            if (i % 2 == 0) {
                Bandera = true;
            } else {
                Bandera = false;
            }
            for (int j = 0; j < 8; j++) {
                if (Bandera) {
                    Tablero[i][j] = "░";
                    Bandera = !Bandera;
                } else {
                    Tablero[i][j] = "▓";
                    Bandera = !Bandera;
                }
            }
        }
        //Tablero[7][7]=Jugadores.get(0).getPiezas().get(0);
        return Tablero;
    }

    public static Object[][] Cargar_Piezas(Object matriz[][]) {
        Piezas_Jugador(0);
        Piezas_Jugador(1);
        int Contador = 0;

        int Jugador = 0;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = Jugadores.get(Jugador).getPiezas().get(Contador);
                //matriz[i][j] = Jugadores.get(Jugador).getPiezas().get(j);
                Contador += 1;
            }
        }

        Jugador = 1;
        Contador = 0;

        for (int i = 7; i > 5; i--) {
            for (int j = 0; j < 8; j++) {
                matriz[i][j] = Jugadores.get(Jugador).getPiezas().get(Contador);
                Contador += 1;
            }
        }
        //System.out.println("JUGADORES:"+Jugadores);
        return matriz;
    }

    public static void Piezas_Jugador(int Num) {
        int Bandera = 0;
        int Pts = 3;
        boolean Cambio = false;
        for (int i = 0; i < 8; i++) {
            switch (Bandera) {
                case 0://Torre
                    Bandera = 1;
                    Pts = 3;
                    Jugadores.get(Num).setPiezas(new Torre());
                    break;
                case 1://Caballo
                    if (Cambio) {
                        Bandera = 0;
                        Pts = 3;
                    } else {
                        Bandera = 2;
                        Pts = 3;
                    }
                    Jugadores.get(Num).setPiezas(new Caballo());
                    break;
                case 2://Alfil
                    if (Cambio) {
                        Bandera = 1;
                        Pts = 3;
                    } else {
                        Bandera = 3;
                        Pts = 5;
                    }
                    Jugadores.get(Num).setPiezas(new Alfil());
                    break;
                case 3://Rey
                    Bandera = 4;
                    Pts = 10;
                    Jugadores.get(Num).setPiezas(new Rey());
                    break;
                case 4://Reina
                    Bandera = 2;
                    Pts = 3;
                    Cambio = true;
                    Jugadores.get(Num).setPiezas(new Reina());
                    break;
            }
            int tamano = Jugadores.get(Num).getPiezas().size() - 1;
            int ColorID = Jugadores.get(Num).getColor_Piezas();
            Jugadores.get(Num).getPiezas().get(tamano).setId_Jugador(Num);
            Jugadores.get(Num).getPiezas().get(tamano).setColor(ColorID);
            Jugadores.get(Num).getPiezas().get(tamano).setPuntos(Pts);
        }
        for (int i = 0; i < 8; i++) {
            Jugadores.get(Num).setPiezas(new Peon());
            int tamano = Jugadores.get(Num).getPiezas().size() - 1;
            int ColorID = Jugadores.get(Num).getColor_Piezas();
            Jugadores.get(Num).getPiezas().get(tamano).setId_Jugador(Num);
            Jugadores.get(Num).getPiezas().get(tamano).setColor(ColorID);
            Jugadores.get(Num).getPiezas().get(tamano).setPuntos(1);
            /*Jugadores.get(Num).setPiezas(new Peon());
            int tamano = Jugadores.get(Num).getPiezas().size() - 1;
            Jugadores.get(Num).getPiezas().get(tamano).setId_Jugador(Num);
            Jugadores.get(Num).getPiezas().get(tamano).setPuntos(1);*/
        }
    }

    public static void Imprimir_Matriz(Object matriz[][], int filas, int cols) {
        String[] Letras = {"A", "  B", "  C", " D", "  E", "  F", "  G", "  H"};

        if (filas == 7 && cols == 0) {
            System.out.print("++");
            for (String Letra : Letras) {
                System.out.print(Letra + " ");

            }
            System.out.println("");
            System.out.print("++");
            for (int i = 0; i < 8; i++) {
                System.out.print(i + "   ");
            }
            System.out.println("");
        }
        if (cols == 0) {
            System.out.print(filas + " ");
        }

        if (filas == 0 && cols == matriz[0].length - 1) {//CASO BASE.
            /*Determinar el color de la pieza.*/
            if (!(matriz[filas][cols] instanceof String)) {
                if (((Piezas) matriz[filas][cols]).getColor() == 1) {//Rojas
                    System.out.print("\033[32m" + ((Piezas) matriz[filas][cols]).getSimbolo() + "  \033[30m");
                } else {//Cyan
                    System.out.print("\033[36m" + ((Piezas) matriz[filas][cols]).getSimbolo() + "  \033[30m");
                }
            } else {
                System.out.print(matriz[filas][cols] + "  ");
            }
            /*Fin determinar el color de la pieza.*/
        } else { //Llamado Recursivo.
            if (cols == matriz[0].length - 1) {

                /*Determinamos el color.*/
                if (!(matriz[filas][cols] instanceof String)) {
                    if (((Piezas) matriz[filas][cols]).getColor() == 1) {//Rojas
                        System.out.println("\033[32m" + ((Piezas) matriz[filas][cols]).getSimbolo() + "  \033[30m");
                    } else {//Cyan
                        System.out.println("\033[36m" + ((Piezas) matriz[filas][cols]).getSimbolo() + "  \033[30m");
                    }
                } else {//si es texto pasa esto
                    System.out.println(matriz[filas][cols]);
                }
                /*Fin determinar el color*/

                Imprimir_Matriz(matriz, filas - 1, 0);
            } else {//SINO
                /*Determinamos el color.*/
                if (!(matriz[filas][cols] instanceof String)) {
                    if (((Piezas) matriz[filas][cols]).getColor() == 1) {//Rojas
                        System.out.print("\033[32m" + ((Piezas) matriz[filas][cols]).getSimbolo() + "  \033[30m");
                    } else {//Cyan
                        System.out.print("\033[36m" + ((Piezas) matriz[filas][cols]).getSimbolo() + "  \033[30m");
                    }
                } else {//si es texto pasa esto
                    System.out.print(matriz[filas][cols] + "  ");
                }
                Imprimir_Matriz(matriz, filas, cols + 1);
            }

        }
    }

    public static boolean ValidarNum(int Num) {
        boolean Bandera = false;
        if (Num > 7 || Num < 0) {
            Bandera = true;
        }
        return Bandera;
    }

    public static boolean ValidarPiezasPropias(int Turno, Piezas P) {
        boolean Bandera = true;
        if (P.getId_Jugador() == Turno) {
            Bandera = false;
        }
        return Bandera;
    }

    public static void CambiarPosicion(int Turno) {
        boolean Bandera = true;
        boolean Bandera2 = true;
        int ColumnaVieja = 0;
        int FilaVieja = 0;
        int Fila = 0;
        int Columna = 0;
        while (Bandera) {
            System.out.println("Ingrese la Fila de la pieza que desea mover.");
            FilaVieja = SC.nextInt();
            System.out.println("Ingrese la Columnade la pieza que desea mover.");
            ColumnaVieja = SC.nextInt();
            if (ValidarNum(FilaVieja) || ValidarNum(ColumnaVieja)) {
                System.out.println("\033[31mERROR EN LOS NUMEROS\033[30m");
                continue;
            }
            if (Tablero[FilaVieja][ColumnaVieja] instanceof String) {
                System.out.println("\033[31mNO PUEDE MOVER EL TABLERO\033[30m");
                continue;
            }
            if (ValidarPiezasPropias(Turno, ((Piezas) Tablero[FilaVieja][ColumnaVieja]))) {
                System.out.println("\033[31m NO PUEDES MOVER PIEZAS AJENAS\033[30m");
            } else {
                Bandera = false;
            }
        }
        while (Bandera2) {
            System.out.println("Ingrese la nueva Fila de la pieza.");
            Fila = SC.nextInt();
            System.out.println("Ingrese la Nueva Columna de la pieza");
            Columna = SC.nextInt();
            if (ValidarNum(Fila) || ValidarNum(Columna) || (Fila == FilaVieja && Columna == ColumnaVieja)) {
                System.out.println("\033[31mERROR EN LOS NUMEROS\033[30m");
                continue;
            }
            if (!MovimientoTorre(FilaVieja, ColumnaVieja, Fila, Columna)) {
                System.out.println("\033[31m MOVIMIENTO INVALIDO PARA LA TORRE\033[30m");
                continue;
            }
            Bandera2 = false;
        }

        Tablero[Fila][Columna] = Tablero[FilaVieja][ColumnaVieja];
        if (FilaVieja % 2 == 0) {//La Fila es Par

            if (ColumnaVieja % 2 == 0) {//Columna Par (Blanco)
                Tablero[FilaVieja][ColumnaVieja] = "░";

            } else {//Columna Impar (Negro)
                Tablero[FilaVieja][ColumnaVieja] = "▓";
            }
        } else { //La fila es impar.

            if (ColumnaVieja % 2 == 0) {//Columna Par (Negro)
                Tablero[FilaVieja][ColumnaVieja] = "▓";
            } else {//Columna Impar (Blanco)
                Tablero[FilaVieja][ColumnaVieja] = "░";
            }
        }
    }

    public static boolean ValidarMovimiento() {
        boolean Acceso = true;
        return Acceso;
    }

    public static boolean MovimientoTorre(int F_Vieja, int C_Vieja, int F_Nueva, int C_Nueva) {
        boolean Mover = false;
        if (F_Vieja == F_Nueva && C_Nueva == C_Vieja) {
            return false;
        }
        //El movimiento esta en la misma fila, una fila abajo, o una fila arriba.
        if (F_Vieja == F_Nueva || F_Vieja == F_Nueva - 1 || F_Vieja == F_Nueva + 1) {
            //El movimiento esta una columna al lado, una columna antes o en la msma columna.
            if (C_Vieja == C_Nueva - 1 || C_Vieja == C_Nueva + 1 || C_Vieja == C_Nueva) {
                return true;
            }

        }
        return Mover;
    }

    public static boolean MovimientoCaballo() {
        boolean Mover = false;
        return Mover;
    }

    public static boolean MovimientoAlfil() {
        boolean Mover = false;
        return Mover;
    }

    public static boolean MovimientoReina() {
        boolean Mover = false;
        return Mover;
    }

    public static boolean MovimientoRey() {
        boolean Mover = false;
        return Mover;
    }

    public static boolean MovimientoPeon() {
        boolean Mover = false;
        return Mover;
    }
    /**
     * METODOS DE PRUEBA/ /*public static void imprimeMatriz(Object matriz[][],
     * int filas, int cols) { if (filas == matriz.length - 1 && cols ==
     * matriz[0].length - 1) { System.out.print( matriz[filas][cols] +" "); }
     * else { if (cols == matriz[0].length-1) { System.out.println(
     * matriz[filas][cols] ); imprimeMatriz(matriz, filas+1, 0); } else {
     * System.out.print( matriz[filas][cols] +" "); imprimeMatriz(matriz, filas,
     * cols+1); } } }
     */
}
