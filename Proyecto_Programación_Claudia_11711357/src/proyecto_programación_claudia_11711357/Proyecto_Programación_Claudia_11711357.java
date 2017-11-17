package proyecto_programación_claudia_11711357;

import Piezas.*;
import Jugadores.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Proyecto_Programación_Claudia_11711357 {

    public static ArrayList<Jugador> Jugadores = new ArrayList();
    public static Object[][] Tablero;
    public static Object[][] Tab;
    public static Scanner SC = new Scanner(System.in);
    public static boolean Ganador = false;
    public static int Turno = 0;
    public static int JUGADORGANADOR = 0;
    /*POSICIONES GENERALES DE LOS REYES*/
//    public static int F_Rey = 0;
//    public static int C_Rey = 0;
//   public static int F_Rey1 = 0;
//   public static int C_Rey1 = 3;
// public static int F_Rey2 = 7;
//   public static int C_Rey2 = 3;
    public static int F_Rey1 = 3;
    public static int C_Rey1 = 2;
    public static int F_Rey2 = 4;
    public static int C_Rey2 = 3;
    public static String Cyan = "\033[36m";
    public static String Rojo = "\033[31m";
    public static String Azul = "\033[34m";
    public static String Verde = "\033[32m";
    public static String Amarillo = "\033[33m";
    public static String Magenta = "\033[35m";
    public static String Negro = "\033[30m";
    public static String Color1 = "\033[30m";
    public static String Color2 = "\033[30m";

    public static void main(String[] args) {
       // int ID = 3;
        //boolean Bandera = true;
        System.out.println(Azul + "*******************Ingrese el Nombre del Jugador 1*******************" + Negro);
        System.out.print("→");
        String Nombre = SC.next();
        System.out.println(Azul + "********************************************************************" + Negro);
        Color1 = ColorPieza(0);
        Jugadores.add(new Jugador(Nombre, 0, 1));
        System.out.println(Azul + "*******************Ingrese el Nombre del Jugador 2*******************" + Negro);
        System.out.print("→");
        Nombre = SC.next();
        System.out.println(Azul + "********************************************************************" + Negro);
        Color2 = ColorPieza(1);
        Jugadores.add(new Jugador(Nombre, 1, 2));
        Tablero = Llenar_Matriz();
        Tablero = Cargar_Piezas(Tablero);
        Tab = Llenar_Matriz();
        while (true) {
            // System.out.println("Estado del ganador"+Ganador);
            if (Ganador) {
                System.out.println("Felicidades " + Jugadores.get(JUGADORGANADOR).getNombre() + " ha ganado!");
                break;
            }
            System.out.println("Turno de:" + Jugadores.get(Turno).getNombre());
            Imprimir_Matriz(Tablero, 7, 0);
            System.out.println("\n---------------------------------------------");
            CambiarPosicion(Turno);
            switch (Turno) {
                case 0:
                    Turno = 1;
                    break;
                case 1:
                  Imprimir_Matriz(Tablero, 7, 0);
                CambiarPosicion(Turno);
                    Turno = 0;
                    break;
            }
            System.out.println("\n→ NUEVAS POSICIONES ←");
        }

    }
    public static String ColorPieza(int Jugador) {
        String Color = "";
        int ID = 5;
        int Numero = -1;

        while (Numero == -1) {
            try {
                System.out.println("→Ingrese el Color con el que desea Jugar: \n"
                        + Azul + "1)Azul.\n"
                        + Rojo + "2)Rojo.\n" + Negro
                        + Verde + "3)Verde.\n" + Negro
                        + Amarillo + "4)Amarillo.\n" + Negro
                        + Magenta + "5)Magenta.\n" + Negro
                        + Cyan + "6)Cyan." + Negro
                );
                System.out.print("→");
                SC = new Scanner(System.in);

                ID = SC.nextInt();

                switch (ID) {
                    case 1:
                        Color = Azul;
                        break;
                    case 2:
                        Color = Rojo;
                        break;
                    case 3:
                        Color = Verde;
                        break;
                    case 4:
                        Color = Amarillo;
                        break;
                    case 5:
                        Color = Magenta;
                        break;
                    case 6:
                        Color = Cyan;
                        break;
                    default:
                        System.out.println(Rojo + "COLOR NO VALIDO" + Negro);
                        continue;
                }
               
                if (Jugador == 1 && Color.equals(Color1)) {
                    System.out.println(Amarillo+"El Jugador 1 Ya escogio ese color."+Negro);
                   continue;
                } else {
                    Numero = 6;
                }
            } catch (Exception e) {
                System.out.println(Rojo + "Ha ocurrido un error" + Negro);
                continue;
            }
        }
       
        return Color;
    }
    public static Object[][] Llenar_Matriz() {
        Object[][] Tablero = new Object[8][8];
        boolean Bandera = true;
        /*SOLO CAMBIASTE LA BANDERA DE FALSE A TRUE*/
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
                Jugadores.get(Jugador).getPiezas().get(Contador).setPosicion(i + "-" + j);
                //matriz[i][j] = Jugadores.get(Jugador).getPiezas().get(j);
                Contador += 1;
            }
        }
        //System.out.println("Piezas del jugador"+Jugador+Jugadores.get(Jugador).getPiezas());
        Jugador = 1;
        Contador = 0;

        for (int i = 7; i > 5; i--) {
            for (int j = 0; j < 8; j++) {
                matriz[i][j] = Jugadores.get(Jugador).getPiezas().get(Contador);
                Jugadores.get(Jugador).getPiezas().get(Contador).setPosicion(i + "-" + j);
                Contador += 1;
            }
        }
        //System.out.println("JUGADORES:"+Jugadores);
        //matriz[3][2] = Jugadores.get(0).getPiezas().get(3);
        // matriz[4][3] = Jugadores.get(1).getPiezas().get(3);
        // System.out.println("Pieza"+Jugadores.get(Jugador).getPiezas().get(3).getClass().getSimpleName());
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
        String[] Letras = {" A", "  B", "  C", " D", "  E", "  F", " G", "  H"};

        if (filas == 7 && cols == 0) {
            System.out.print(" ");
            for (String Letra : Letras) {
                System.out.print(Letra + " ");

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
                    System.out.print(Color1+ ((Piezas) matriz[filas][cols]).getSimbolo() + "  "+Negro);
                } else {//Cyan
                    System.out.print(Color2+ ((Piezas) matriz[filas][cols]).getSimbolo() + "  "+Negro);
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
                        System.out.println(Color1+ ((Piezas) matriz[filas][cols]).getSimbolo() + "  "+Negro);
                    } else {//Cyan
                        System.out.println(Color2+ ((Piezas) matriz[filas][cols]).getSimbolo() + "  "+Negro);
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
                        System.out.print(Color1+ ((Piezas) matriz[filas][cols]).getSimbolo() + "  "+Negro);
                    } else {//Cyan
                        System.out.print(Color2 + ((Piezas) matriz[filas][cols]).getSimbolo() + "  "+Negro);
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
        int[] Arreglo = {15, 15};
        String Posicion = "";
        int JUGADORGANADOR = 5;
        while (Bandera) {
            System.out.println("→Ingrese la posicion de la pieza que desea mover");
            Posicion = SC.next();
            Arreglo = ValidarMovimiento(Posicion);
            FilaVieja = Arreglo[0];//fILAS
            ColumnaVieja = Arreglo[1];//Columnas

            if (ValidarNum(FilaVieja) || ValidarNum(ColumnaVieja)) {
                System.out.println("\033[31mERROR EN LOS NUMEROS\033[30m");
                continue;
            }
            if (Tablero[FilaVieja][ColumnaVieja] instanceof String) {
                System.out.println("\033[31mLA POSICION SELECCIONADA NO TIENE NINGUNA PIEZA\033[30m");
                continue;
            }
            if (ValidarPiezasPropias(Turno, ((Piezas) Tablero[FilaVieja][ColumnaVieja]))) {
                System.out.println("\033[31m NO PUEDES MOVER PIEZAS AJENAS\033[30m");
                continue;
            }
            int Id = ((Piezas) Tablero[FilaVieja][ColumnaVieja]).getId_Jugador();
            if (!((Piezas) Tablero[FilaVieja][ColumnaVieja]).Restriccion(FilaVieja, ColumnaVieja, Tablero, Id)) {
                System.out.println("\033[31m LA PIEZA: " + ((Piezas) Tablero[FilaVieja][ColumnaVieja]).getNombre().toUpperCase() + " ESTA BLOQUEADA, SELECCIONE OTRA O ANALICE MEJOR LA JUGADA\033[30m");
            } else {
                Bandera = false;
            }
        }

        while (Bandera2) {
            System.out.println("→Ingrese la Nueva Posicion de la pieza:");
            Posicion = SC.next();
            Arreglo = ValidarMovimiento(Posicion);
            Fila = Arreglo[0];//fILAS
            Columna = Arreglo[1];//Columnas
            int Num = 0;
            if (ValidarNum(Fila) || ValidarNum(Columna) || (Fila == FilaVieja && Columna == ColumnaVieja)) {
                System.out.println("\033[31mERROR EN LOS NUMEROS\033[30m");
                continue;
            }
            if (Tablero[FilaVieja][ColumnaVieja] instanceof Peon) {

            }
            if (!((Piezas) Tablero[FilaVieja][ColumnaVieja]).Movimiento(FilaVieja, ColumnaVieja, Fila, Columna, 0, Tablero)) {
                System.out.println("\033[31m MOVIMIENTO INVALIDO PARA LA PIEZA: " + ((Piezas) Tablero[FilaVieja][ColumnaVieja]).getNombre().toUpperCase() + "\033[30m");
                continue;
            }

            Bandera2 = false;
        }//Fin del while
        int Id = ((Piezas) Tablero[FilaVieja][ColumnaVieja]).getId_Jugador();
        if (Tablero[FilaVieja][ColumnaVieja] instanceof Rey) {
            if (Id == 0) {
                F_Rey1 = Fila;
                C_Rey1 = Columna;
            } else {
                F_Rey2 = Fila;
                C_Rey2 = Columna;
            }

            //  System.out.println("LA NUEVA POSICION DEL REY  " + F_Rey + "-" + C_Rey);
        }
        Tablero[Fila][Columna] = Tablero[FilaVieja][ColumnaVieja];
        Relleno(FilaVieja, ColumnaVieja);

        if (Id == 0) {
           // System.out.println("TURNO DEL JUGADOR 1");

           //
           System.out.println("Las posiciones del rey 2:" + F_Rey2 + "-" + C_Rey2);
            ((Piezas) Tablero[Fila][Columna]).Movimiento(Fila, Columna, F_Rey2, C_Rey2, 1, Tablero);
        } else {
           // System.out.println("TURNO DEL JUGADOR 2");
            //System.out.println("Las posiciones del rey 1: " + F_Rey1 + "-" + C_Rey1);

            ((Piezas) Tablero[Fila][Columna]).Movimiento(Fila, Columna, F_Rey1, C_Rey1, 1, Tablero);
        }
    }

    public static void Relleno(int FilaVieja, int ColumnaVieja) {
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

    public static int[] ValidarMovimiento(String Posicion) {
        boolean Acceso = true;
        int Letra = 15;
        ///int [] A= new int(2);
        int[] A = {15, 15};
        try {
            if (Character.isDigit(Posicion.charAt(0)) || Character.isAlphabetic(Posicion.charAt(1)) || Posicion.length() == 1 || Posicion.length() > 2) {
                return A;
            }
            //ValidarMovimiento
            switch (("" + Posicion.charAt(0)).toUpperCase()) {
                case "A":
                    Letra = 0;
                    break;
                case "B":
                    Letra = 1;
                    break;
                case "C":
                    Letra = 2;
                    break;
                case "D":
                    Letra = 3;
                    break;
                case "E":
                    Letra = 4;
                    break;
                case "F":
                    Letra = 5;
                    break;
                case "G":
                    Letra = 6;
                    break;
                case "H":
                    Letra = 7;
                    break;
            }
            A[1] = Letra;//Columnas
            A[0] = Integer.parseInt("" + Posicion.charAt(1));//Filas
        } catch (Exception e) {
            System.out.println("Se ha Producido un error");
        }
        return A;
    }

//    public static boolean MovimientoCaballo(int F_Vieja, int C_Vieja, int F_Nueva, int C_Nueva, int Num) {
//        boolean Mover = false;
//        if (F_Nueva == F_Vieja + 2 || F_Nueva == F_Vieja - 2) { //Arriba o Abajo
//            if (C_Nueva == C_Vieja + 1 || C_Nueva == C_Vieja - 1) {
//                Mover = true;
//            }
//        } else if (F_Nueva == F_Vieja + 1 || F_Nueva == F_Vieja - 1) {//Izq o derecha
//            if (C_Nueva == C_Vieja + 2 || C_Nueva == C_Vieja - 2) {
//                Mover = true;
//            }
//        } else {//Default, error.
//            Mover = false;
//        }
//        if (Mover && Tablero[F_Nueva][C_Nueva] instanceof Piezas) {
//            if (((Piezas) Tablero[F_Nueva][C_Nueva]).getId_Jugador() == ((Piezas) Tablero[F_Vieja][C_Vieja]).getId_Jugador()) {
//                System.out.println("No puedes saltar piezas, la casilla coresponde a una casilla propia.");
//                return false;
//            } else {
//                if (Num == 1 && ((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
//                    System.out.println("JAQUE");
//                } else {
//                    if (((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
//                        System.out.println("JAQUE ");
//                        Ganador = true;
//                        JUGADORGANADOR = ((Piezas) Tablero[F_Vieja][C_Vieja]).getId_Jugador();
//                    } else {
//                        System.out.println("PIEZA CAPTURADA");
//                    }
//                }
//                return true;
//            }
//        }
//        return Mover;
//    }
//
//    public static boolean MovimientoReina(int F_Vieja, int C_Vieja, int F_Nueva, int C_Nueva, int Num) {
//        boolean Mover = false;
//        if (MovimientoTorre(F_Vieja, C_Vieja, F_Nueva, C_Nueva, Num) || MovimientoAlfil(F_Vieja, C_Vieja, F_Nueva, C_Nueva, Num)) {
//            Mover = true;
//        }
//        return Mover;
//    }
//
//    public static boolean MovimientoRey(int F_Vieja, int C_Vieja, int F_Nueva, int C_Nueva, int Num) {
//        boolean Mover = false;
//        if (F_Vieja + 1 == F_Nueva || F_Vieja - 1 == F_Nueva) {
//            if (C_Vieja + 1 == C_Nueva || C_Vieja - 1 == C_Nueva || C_Vieja == C_Nueva) {
//                Mover = true;
//            }
//        } else if (F_Vieja == F_Nueva) {
//            if (C_Vieja + 1 == C_Nueva || C_Vieja - 1 == C_Nueva) {
//                Mover = true;
//            }
//        } else {
//            Mover = false;
//        }
//        return Mover;
//    }
//
////    public static boolean MovimientoPeon(int F_Vieja, int C_Vieja, int F_Nueva, int C_Nueva, int Num1) {
////        boolean Mover = false;
////        int Num = 0;
////        int Num2 = 0;
////        int idActual = ((Piezas) Tablero[F_Vieja][C_Vieja]).getId_Jugador();
////        int idOponente;
////        if (idActual == 0) {
////            idOponente = 1;
////        } else {
////            idOponente = 0;
////        }
////        if (((Piezas) Tablero[F_Vieja][C_Vieja]).getId_Jugador() == 0) {
////            Num = 2;
////            Num2 = 1;
////        } else {
////            Num = -2;
////            Num2 = -1;
////        }
////        if (PeonComer(F_Vieja, C_Vieja, F_Nueva, C_Nueva, Num1)) {
////            return true;
////        }
////        if (((Piezas) Tablero[F_Vieja][C_Vieja]).getPosicion().equals(F_Vieja + "-" + C_Vieja)) {//En caso de que sea su primer movimiento
////            //System.out.println("Puede moverse dos para arriba");
////            if (F_Vieja + Num == F_Nueva && C_Vieja == C_Nueva || F_Vieja + Num2 == F_Nueva && C_Vieja == C_Nueva) { //Solo puede moverse 2 casillas maximo
////                for (int i = 1; i < 3; i++) {
////                    if (idActual == 0) {
////                        if (Tablero[F_Vieja + i][C_Nueva] instanceof Piezas && idActual == 0) {
////                            System.out.println("EL PEON TIENE EL PASO BLOQUEADO");
////                            return false;
////                        }
////
////                    } else {
////                        //  System.out.println("JUGADOR 2");
////                        if (Tablero[F_Vieja - i][C_Nueva] instanceof Piezas && idActual == 0) {
////                            System.out.println("EL PEON TIENE EL PASO BLOQUEADO");
////                            return false;
////                        }
////                    }
////
////                }
////                return true;
////            } else {
////                return false;
////            }
////        } else {//En caso de que no sea su primer movimiento.
////
////            if (Tablero[F_Nueva][C_Nueva] instanceof Piezas) {
////                System.out.println("EL PEON TIENE EL PASO BLOQUEADO");
////            } else if (F_Vieja + Num2 == F_Nueva && C_Vieja == C_Nueva && Tablero[F_Nueva][C_Nueva] instanceof String) {
////                return true;
////            }
////
////        }
////        return Mover;
////    }
////
////    public static boolean PeonComer(int F_Vieja, int C_Vieja, int F_Nueva, int C_Nueva, int Num1) {
////        boolean Mover = false;
////        int idActual = ((Piezas) Tablero[F_Vieja][C_Vieja]).getId_Jugador();
////        int idOponente;
////        if (idActual == 0) {
////            idOponente = 1;
////        } else {
////            idOponente = 0;
////        }
////
////        int Num = 0;
////        Num = F_Nueva - F_Vieja;
////        if ((Num == 1 && idActual == 0) || (Num == -1 && idActual == 1)) {
////            if (C_Vieja + Num == C_Nueva || C_Vieja - Num == C_Nueva
////                    && (C_Nueva <= 7 && C_Nueva >= 0) && (F_Nueva <= 7 && F_Nueva >= 0)) {
////                if (((Piezas) Tablero[F_Vieja + 1][C_Vieja + 1]).getId_Jugador() == idOponente) {
////                    if (Num == 1 && ((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
////                        System.out.println("JAQUE");
////                    } else {
////                        if (((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
////                            System.out.println("JAQUE MATE");
////                            Ganador = true;
////                            JUGADORGANADOR = ((Piezas) Tablero[F_Vieja][C_Vieja]).getId_Jugador();
////                        } else {
////                            System.out.println("PIEZA CAPTURADA");
////                        }
////                    }
////                    Mover = true;
////                    //  System.out.println("PIEZA COMIDA!");
////                }
////            }
////        } else {
////            Mover = false;
////        }
////        return Mover;
////    }
//
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
//                            System.out.println("No puedes saltar piezas, la casilla coresponde a una casilla propia.");
//                            return false;
//                        } else {//La Pieza es ajena.
//                            if (C_Vieja - Cont > C_Nueva) {
//                                System.out.println("No puedes saltar piezas, la casilla corresponde a una pieza ajena.");
//                                System.out.println("");
//                                return false;
//                            } else {
//                                if (Num == 1 && ((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
//                                    System.out.println("JAQUE");
//                                } else {
//                                    if (((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
//                                        System.out.println("JAQUE MATE");
//                                        Ganador = true;
//                                        JUGADORGANADOR = ((Piezas) Tablero[F_Vieja][C_Vieja]).getId_Jugador();
//                                    } else {
//                                        System.out.println("PIEZA CAPTURADA");
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
//            } else {//Movimiento a la derecha
//                while (Cont <= Dif_C) {
//                    if (Tablero[F_Vieja][C_Vieja + Cont] instanceof Piezas) {
//                        if (((Piezas) Tablero[F_Vieja][C_Vieja + Cont]).getId_Jugador() == idActual) {
//                            System.out.println("No puedes saltar piezas, la casilla coresponde a una casilla propia.");
//                            return false;
//                        } else {//La Pieza es ajena.
//                            if (C_Vieja + Cont < C_Nueva) {
//                                System.out.println("No puedes saltar piezas, la casilla coresponde a una casilla propia.");
//                                System.out.println("");
//                                return false;
//                            } else {
//                                if (Num == 1 && ((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
//                                    System.out.println("JAQUE");
//                                } else {
//                                    if (((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
//                                        System.out.println("JAQUE MATE");
//                                        Ganador = true;
//                                        JUGADORGANADOR = ((Piezas) Tablero[F_Vieja][C_Vieja]).getId_Jugador();
//                                    } else {
//                                        System.out.println("PIEZA CAPTURADA");
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
//                            System.out.println("No puedes saltar piezas, la casilla coresponde a una casilla propia.");
//                            return false;
//                        } else {//La Pieza es ajena.
//                            if (F_Vieja - Cont > F_Nueva) {
//                                System.out.println("No puedes saltar piezas, la casilla coresponde a una pieza ajena.");
//                                System.out.println("");
//                                return false;
//                            } else {
//                                if (Num == 1 && ((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
//                                    System.out.println("JAQUE");
//                                } else {
//                                    if (((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
//                                        System.out.println("JAQUE MATE");
//                                        Ganador = true;
//                                        JUGADORGANADOR = ((Piezas) Tablero[F_Vieja][C_Vieja]).getId_Jugador();
//                                    } else {
//                                        System.out.println("PIEZA CAPTURADA");
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
//                            System.out.println("No puedes saltar piezas, la casilla coresponde a una casilla propia.");
//                            return false;
//                        } else {//La Pieza es ajena.
//                            if (F_Vieja + Cont < F_Nueva) {
//                                System.out.println("No puedes saltar piezas, la casilla coresponde a una pieza ajena.");
//                                System.out.println("");
//                                return false;
//                            } else {
//                                if (Num == 1 && ((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
//                                    System.out.println("JAQUE");
//                                } else {
//                                    if (((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
//                                        System.out.println("JAQUE MATE");
//                                        Ganador = true;
//                                        JUGADORGANADOR = ((Piezas) Tablero[F_Vieja][C_Vieja]).getId_Jugador();
//                                    } else {
//                                        System.out.println("PIEZA CAPTURADA");
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
//                    System.out.println("MOVIMIENTO A LA IZQ." + F_Nueva + "<" + F_Vieja);
//                    while (Cont <= (Num * -1)) {
//                        if (F_Vieja - Cont >= 0 && C_Vieja - Cont >= 0) {
//                            if (Tablero[F_Vieja - Cont][C_Vieja - Cont] instanceof Piezas) {
//                                if (((Piezas) Tablero[F_Vieja - Cont][C_Vieja - Cont]).getId_Jugador() == idActual) {
//                                    System.out.println("Recorriendo la posicion" + (F_Vieja - Cont) + "-" + (C_Vieja - Cont));
//                                    System.out.println("No puedes saltar piezas, la casilla coresponde a una casilla propia.");
//                                    return false;
//                                } else {//La Pieza es ajena.
//                                    if (F_Vieja - Cont > F_Nueva) {
//                                        System.out.println("No puedes saltar piezas, la casilla coresponde a una pieza ajena.");
//                                        System.out.println("");
//                                        return false;
//                                    } else {
//                                        if (Num1 == 1 && ((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
//                                            System.out.println("JAQUE");
//                                        } else {
//                                            if (((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
//                                                System.out.println("JAQUE MATE");
//                                                Ganador = true;
//                                                JUGADORGANADOR = ((Piezas) Tablero[F_Vieja][C_Vieja]).getId_Jugador();
//                                            } else {
//                                                System.out.println("PIEZA CAPTURADA");
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
//                                    System.out.println("No puedes saltar piezas, la casilla coresponde a una casilla propia.");
//                                    return false;
//                                } else {//La Pieza es ajena.
//                                    if (F_Vieja - Cont > F_Nueva) {
//                                        System.out.println("No puedes saltar piezas, la casilla coresponde a una pieza ajena.");
//                                        System.out.println("");
//                                        return false;
//                                    } else {
//                                        if (Num1 == 1 && ((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
//                                            System.out.println("JAQUE");
//                                        } else {
//                                            if (((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
//                                                System.out.println("JAQUE MATE");
//                                                Ganador = true;
//                                                JUGADORGANADOR = ((Piezas) Tablero[F_Vieja][C_Vieja]).getId_Jugador();
//                                            } else {
//                                                System.out.println("PIEZA CAPTURADA");
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
//                                    System.out.println("No puedes saltar piezas, la casilla coresponde a una casilla propia.");
//                                    return false;
//                                } else {//La Pieza es ajena.
//                                    if (F_Vieja + Cont < F_Nueva) {
//                                        System.out.println("No puedes saltar piezas, la casilla coresponde a una pieza ajena.");
//                                        System.out.println("");
//                                        return false;
//                                    } else {
//                                        if (Num1 == 1 && ((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
//                                            System.out.println("JAQUE");
//                                        } else {
//                                            if (((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
//                                                System.out.println("JAQUE MATE");
//                                                Ganador = true;
//                                                JUGADORGANADOR = ((Piezas) Tablero[F_Vieja][C_Vieja]).getId_Jugador();
//                                            } else {
//                                                System.out.println("PIEZA CAPTURADA");
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
//                                    System.out.println("No puedes saltar piezas, la casilla coresponde a una casilla propia.");
//                                    return false;
//                                } else {//La Pieza es ajena.
//                                    if (F_Vieja + Cont < F_Nueva) {
//                                        System.out.println("No puedes saltar piezas, la casilla coresponde a una pieza ajena.");
//                                        System.out.println("");
//                                        return false;
//                                    } else {
//                                        if (Num1 == 1 && ((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
//                                            System.out.println("JAQUE");
//                                        } else {
//                                            if (((Piezas) Tablero[F_Nueva][C_Nueva]).getPuntos() == 10) {
//                                                System.out.println("JAQUE MATE");
//                                                Ganador = true;
//                                                JUGADORGANADOR = ((Piezas) Tablero[F_Vieja][C_Vieja]).getId_Jugador();
//                                            } else {
//                                                System.out.println("PIEZA CAPTURADA");
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
}//Fin de la clase.

/*
 * METODOS DE PRUEBA/ /*public static void imprimeMatriz(Object matriz[][], int
 * filas, int cols) { if (filas == matriz.length - 1 && cols == matriz[0].length
 * - 1) { System.out.print( matriz[filas][cols] +" "); } else { if (cols ==
 * matriz[0].length-1) { System.out.println( matriz[filas][cols] );
 * imprimeMatriz(matriz, filas+1, 0); } else { System.out.print(
 * matriz[filas][cols] +" "); imprimeMatriz(matriz, filas, cols+1); } } }
 */
//    public static boolean MovimientoAlfil(int F_Vieja, int C_Vieja, int F_Nueva, int C_Nueva) {
//        boolean Mover = false;
//
//        int Num = 0;
//        Num = F_Nueva - F_Vieja;
//        //System.out.println("Numero de Casillas que subira o Bajara"+Num);
//        if (F_Nueva < 0) {
//            System.out.println("MOVIMIENTO HACIA ABAJO.");
//        } else {
//            System.out.println("MOVIMIENTO HACIA ARRIBA");
//        }
//        if (C_Vieja + Num == C_Nueva || C_Vieja - Num == C_Nueva) {
//            Mover = true;
//        }else{
//            return false;
//        }
//        if (AlfilComer(F_Vieja, C_Vieja, F_Nueva, C_Nueva)&&Mover) {
//           Mover=true;
//        }
//        //System.out.println("Numero de Casillas que subira o Bajara");
//        return Mover;
//    }

/*RECUERDA CAMBIAR EL BOOLEANO DE NUEVO A FALSO.Clase del Alfin*/
 /* public static boolean MovimientoAlfil(int F_Vieja, int C_Vieja, int F_Nueva, int C_Nueva) {
        boolean Mover = false;
        
        int Num=0;
           Num = F_Nueva - F_Vieja;
        if (F_Nueva < 0) {
            System.out.println("MOVIMIENTO HACIA ABAJO.");
        } else {
            System.out.println("MOVIMIENTO HACIA ARRIBA");
        }
        if (F_Vieja+Num==C_Nueva) {
            return true;    
        }
        return Mover;
    }*/
 /*public static boolean MovimientoTorre1(int F_Vieja, int C_Vieja, int F_Nueva, int C_Nueva) {
        boolean Mover = false;
        if (F_Vieja == F_Nueva && C_Nueva == C_Vieja) {
            System.out.println("Usted esta tratando de mpverse al lugar en el que esta");
            return false;
        }
       
        //El movimiento es a la izquiera o a la derecha-
        
        if (Mover||TorreComer(F_Vieja,C_Vieja,F_Nueva,C_Nueva)) {
            
        }
     
        return Mover;
    }*/
 /* System.out.println("Ingrese la nueva Fila de la pieza.");
            Fila = SC.nextInt();
            System.out.println("Ingrese la Nueva Columna de la pieza");
            Columna = SC.nextInt();*/
// System.out.println("La posicion"+Posicion+"Se traduce como: "+FilaVieja+"-"+ColumnaVieja);

/*System.out.println("Ingrese la Fila de la pieza que desea mover.");
            FilaVieja = SC.nextInt();
            System.out.println("Ingrese la Columnade la pieza que desea mover.");
            ColumnaVieja = SC.nextInt();*/
 /*LLAMADO DE LOSMETODOS EN EL CAMBIAR PIEZA
/* if (Tablero[FilaVieja][ColumnaVieja] instanceof Torre) {

                if (!MovimientoTorre(FilaVieja, ColumnaVieja, Fila, Columna, 0)) {
                    System.out.println("\033[31m MOVIMIENTO INVALIDO PARA LA TORRE\033[30m");
                    continue;
                } else {
                    MovimientoTorre(FilaVieja, ColumnaVieja, Fila, Columna, 1);
                }
            } else if (Tablero[FilaVieja][ColumnaVieja] instanceof Peon) {

                if (!MovimientoPeon(FilaVieja, ColumnaVieja, Fila, Columna, 0)) {
                    System.out.println("\033[31m MOVIMIENTO INVALIDO PARA EL PEON\033[30m");
                    continue;
                } else {
                    MovimientoPeon(FilaVieja, ColumnaVieja, Fila, Columna, 1);
                }

            } else if (Tablero[FilaVieja][ColumnaVieja] instanceof Alfil) {
               
               /if (!MovimientoAlfil(FilaVieja, ColumnaVieja, Fila, Columna, 0)) {
                    System.out.println("\033[31m MOVIMIENTO INVALIDO PARA EL ALFIL\033[30m");
                    continue;
                } else {
                    MovimientoAlfil(FilaVieja, ColumnaVieja, Fila, Columna, 1);
                }

            } else if (Tablero[FilaVieja][ColumnaVieja] instanceof Reina) {
                if (!MovimientoReina(FilaVieja, ColumnaVieja, Fila, Columna, 0)) {
                    System.out.println("\033[31m MOVIMIENTO INVALIDO PARALA REINA \033[30m");
                    continue;
                } else {
                    MovimientoReina(FilaVieja, ColumnaVieja, Fila, Columna, 1);
                }
            } else if (Tablero[FilaVieja][ColumnaVieja] instanceof Rey) {
                if (!MovimientoRey(FilaVieja, ColumnaVieja, Fila, Columna, 0)) {
                    System.out.println("\033[31m MOVIMIENTO INVALIDO PARA EL REY \033[30m");
                    continue;
                } else {
                    MovimientoRey(FilaVieja, ColumnaVieja, Fila, Columna, 1);
                }
            } else if (Tablero[FilaVieja][ColumnaVieja] instanceof Caballo) {
                if (!MovimientoCaballo(FilaVieja, ColumnaVieja, Fila, Columna, Num)) {
                    System.out.println("\033[31m MOVIMIENTO INVALIDO PARA EL CABALLO\033[30m");
                    continue;
                } else {
                    MovimientoCaballo(FilaVieja, ColumnaVieja, Fila, Columna, 1);
                }
            }
LOS METODOS FUNCIONALES


 */
