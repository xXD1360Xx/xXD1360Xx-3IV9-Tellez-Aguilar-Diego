
package juegoahorcado;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Jugadores implements Serializable {
    static  ArrayList<Jugadores> listaJugadores = new ArrayList();
 
    
    
    private String nombre;
    private int edad;
    private int puntos;
    private boolean ActualizarJ = false;
    private String nombreActualizado;
    private int edadActualizado;
    
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public int getPuntos() {
        return puntos;
    }
    
    

    public void recuperarArchivo() throws IOException, ClassNotFoundException{
        FileInputStream archivo = new FileInputStream("Jugadores.dat");
        ObjectInputStream entrada = new ObjectInputStream(archivo);
        listaJugadores = (ArrayList)entrada.readObject();
        entrada.close();
    }
    
    public void agregarJugador() {
        Jugadores jugador = new Jugadores();
        nombre = JOptionPane.showInputDialog("Cual es el nombre del jugador?");
        edad =  Integer.parseInt (JOptionPane.showInputDialog("Cual es la edad del jugador?"));
        puntos = 0;
        jugador.setEdad(edad);
        jugador.setNombre(nombre);
        jugador.setPuntos(puntos);
        listaJugadores.add(jugador);
    }
    
    public int mostrarJugadores(){
        
        Jugadores au = new Jugadores();
        
        for(int i = 0; i < listaJugadores.size(); i++){
                    
            for (int j = 0; j < listaJugadores.size() - 1; j++){
                        
                if (listaJugadores.get(j).getPuntos() < listaJugadores.get(j + 1).getPuntos()){
                    au = listaJugadores.get(j);
                    listaJugadores.add(j, listaJugadores.get(j + 1));
                    listaJugadores.add(j + 1, au);
                }
            }
        }
     
        String Jugadores = "";
        for (int i = 0; i < listaJugadores.size(); i++){
          Jugadores += "Jugador " + (i + 1) + "\n";
          Jugadores += "Nombre: " + listaJugadores.get(i).getNombre() + " \nEdad: " + listaJugadores.get(i).getEdad() + " \nPuntos totales: " + listaJugadores.get(i).getPuntos() + "\n" + "\n"; 
        }
         
        String opcionesJug[] = {"Seleccionar jugador", "Agregar jugador", "Eliminar jugador", "Actualizar jugador"}; 
        int opcJug = JOptionPane.showOptionDialog(null, Jugadores + "\n\n¿Qué desea hacer?", "Jugadores", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesJug, opcionesJug[0]);
        return opcJug;
        
    }
    
    public void borrarJugadores(String jugadorS){
        boolean borrarJ = false;
        
        for (int i = 0; i < listaJugadores.size() + 1; i++){
            if(jugadorS.equalsIgnoreCase(listaJugadores.get(i).getNombre())){
                listaJugadores.remove(i);
                borrarJ = true;
            }  
        }
        
        if (borrarJ == false){
                JOptionPane.showMessageDialog(null, "Persona no encontrada");
        }
    
    }
    
    public void ActualizarJugadores(String jugadorS){
       
        Jugadores jugadorActualizado = new Jugadores();
        int i;
       
        for (i = 0; i < listaJugadores.size() + 1; i++){
            if(jugadorS.equalsIgnoreCase(listaJugadores.get(i).getNombre())){
               break; 
            }
        }
        
            String opcActJug[] = {"Actualizar  nombre", "Actualizar edad", "Salir"};
            int opcAc = JOptionPane.showOptionDialog(null, "¿Qué desea hacer?", "Actualizar jugador", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcActJug, opcActJug[0]);
                switch (opcAc){
                    case 0:
                        edad = listaJugadores.get(i).getEdad();
                        puntos = listaJugadores.get(i).getPuntos();
                        nombre = JOptionPane.showInputDialog("Ingresa el nuevo nombre del jugador");
                        jugadorActualizado.setEdad(edad);
                        jugadorActualizado.setNombre(nombre);
                        jugadorActualizado.setPuntos(puntos);
                        listaJugadores.remove(i);
                        listaJugadores.add(i, jugadorActualizado);
                        ActualizarJ = true;

                        break;
                    case 1:
                        nombre = listaJugadores.get(i).getNombre();
                        puntos = listaJugadores.get(i).getPuntos();
                        edad = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la nueva edad del jugador"));
                        jugadorActualizado.setEdad(edad);
                        jugadorActualizado.setNombre(nombre);
                        jugadorActualizado.setPuntos(puntos);
                        listaJugadores.remove(i);
                        listaJugadores.add(i, jugadorActualizado);
                        ActualizarJ = true;
                        break;
                    case 2:
                        break;
                }
            
            if (ActualizarJ == false){
                JOptionPane.showMessageDialog(null, "Persona no encontrada");
            }   
    }
    
    public String seleccionarJugador(String con){
        String[] Jugadores = new String[listaJugadores.size()];
        for (int i = 0; i < listaJugadores.size(); i++){
            Jugadores[i] = listaJugadores.get(i).getNombre();
        }
       
        String SelecJug = (String) JOptionPane.showInputDialog(null, "Seleccione al jugador " + con, "Seleccion de jugador", JOptionPane.DEFAULT_OPTION, null, Jugadores, Jugadores[0]);
        return SelecJug;
    }

    public void guardarPuntuacion(String jugadorS, int puntos){
        int i;
        
        for (i = 0; i < listaJugadores.size() + 1; i++){
            if(jugadorS.equalsIgnoreCase(listaJugadores.get(i).getNombre())){
               break; 
            }
        }

        listaJugadores.get(i).setPuntos(listaJugadores.get(i).getPuntos() + puntos);
 
    }
    
    public void guardarArchivo() throws FileNotFoundException, IOException{
        FileOutputStream archivo = new FileOutputStream("jugadores.dat");
        ObjectOutputStream salida = new ObjectOutputStream(archivo);
        salida.writeObject(listaJugadores);
        salida.close();
     }
}
