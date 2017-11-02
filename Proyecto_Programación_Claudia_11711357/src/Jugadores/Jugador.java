package Jugadores;
import Piezas.*;
import java.util.ArrayList;

public class Jugador {
    private String Nombre;
    private int Puntos_Totales;
    private int ID;
    private ArrayList<Piezas>Piezas=new ArrayList();
    private int Color_Piezas;

    public Jugador() {
    }

    public Jugador(String Nombre, int ID, int Color_Piezas) {
        this.Nombre = Nombre;
        this.ID = ID;
        this.Color_Piezas = Color_Piezas;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getPuntos_Totales() {
        return Puntos_Totales;
    }

    public void setPuntos_Totales(int Puntos_Totales) {
        this.Puntos_Totales = Puntos_Totales;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public ArrayList<Piezas> getPiezas() {
        return Piezas;
    }

    public void setPiezas(Piezas Piezas) {
        this.Piezas.add(Piezas);
    }

    public int getColor_Piezas() {
        return Color_Piezas;
    }

    public void setColor_Piezas(int Color_Piezas) {
        this.Color_Piezas = Color_Piezas;
    }

    @Override
    public String toString() {
        return "\n\nJugador{" + "Nombre=" + Nombre + ", Puntos_Totales=" + Puntos_Totales + ", ID=" + ID + ", Piezas=\n\n " + Piezas + ", Color_Piezas=" + Color_Piezas + '}';
    }
    
    
}
