package proyecto_programación_claudia_11711357;

import Piezas.*;
import Jugadores.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Proyecto_Programación_Claudia_11711357 {

    public static ArrayList<Jugador> Jugadores = new ArrayList();
    public static Object[][] Tablero;
    public static Scanner SC = new Scanner(System.in);

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
        // System.out.println(Jugadores);
        Tablero = Llenar_Matriz();
        Tablero = Cargar_Piezas(Tablero);
        Imprimir_Matriz(Tablero, 7, 0);
        System.out.println("");
        CambiarPosicion();
        Imprimir_Matriz(Tablero, 7, 0);
                System.out.println("");

       // System.out.println("░ B");
       // System.out.println("▓ Blanco");
        //System.out.println("Jugador 1"+Jugadores.get(0).getPiezas());
        //System.out.println("Jugador 2"+Jugadores.get(1).getPiezas());
        //imprimeMatriz(Tablero,0,0);
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

        Jugador =1;
        Contador = 0;
    
        for (int i = 7; i >5; i--) {
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
        boolean Cambio=false;
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
                    }else{
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
                    Cambio=true;
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
        }
        if (cols == 0) {
            System.out.print(filas + " ");
        }

        if (filas == 0 && cols == matriz[0].length - 1) {//CASO BASE.
            /*Determinar el color de la pieza.*/
            if (!(matriz[filas][cols] instanceof String)) {
                if (((Piezas) matriz[filas][cols]).getColor() == 1) {//Rojas
                    System.out.print("\033[32m" + ((Piezas) matriz[filas][cols]).getSimbolo() + "   \033[30m");
                } else {//Cyan
                    System.out.print("\033[36m" + ((Piezas) matriz[filas][cols]).getSimbolo() + "   \033[30m");
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
                        System.out.println("\033[32m" + ((Piezas) matriz[filas][cols]).getSimbolo() + "   \033[30m");
                    } else {//Cyan
                        System.out.println("\033[36m" + ((Piezas) matriz[filas][cols]).getSimbolo() + "   \033[30m");
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
                        System.out.print("\033[32m" + ((Piezas) matriz[filas][cols]).getSimbolo() + "   \033[30m");
                    } else {//Cyan
                        System.out.print("\033[36m" + ((Piezas) matriz[filas][cols]).getSimbolo() + "   \033[30m");
                    }
                } else {//si es texto pasa esto
                    System.out.print(matriz[filas][cols] + "  ");
                }
                Imprimir_Matriz(matriz, filas, cols + 1);
            }

        }
    }

    public static void CambiarPosicion(){
          System.out.println("Ingrese la Fila de la pieza que desea mover.");
        int FilaVieja=SC.nextInt();
        System.out.println("Ingrese la Columnade la pieza que desea mover.");
        int ColumnaVieja=SC.nextInt();
        
        System.out.println("Ingrese la nueva Fila de la pieza.");
        int Fila = SC.nextInt();
        System.out.println("Ingrese la Nueva Columna de la pieza");
        int Columna = SC.nextInt();
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
