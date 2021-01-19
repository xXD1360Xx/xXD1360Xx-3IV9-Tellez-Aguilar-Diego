package examenpoo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Persona implements Serializable {
    static  ArrayList<Persona> personas = new ArrayList<Persona>(); 
  
    String nombre;
    //pongo edad para que se justifique el uso de arraylist
    int edad;

    public Persona() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
    
    public void agregarPersona() throws IOException {
        Persona personaNueva = new Persona();
        nombre = JOptionPane.showInputDialog("Cual es el nombre de la persona?");
        edad =  Integer.parseInt (JOptionPane.showInputDialog("Cual es la edad de la persona?"));
        personaNueva.setEdad(edad);
        personaNueva.setNombre(nombre);
        personas.add(personaNueva);
        guardarArchivo();
    }
     
    public void borrarPersonas(){
        boolean  personaBorrada = false;
        nombre = JOptionPane.showInputDialog("Cual es el nombre de la persona que desea borrar?");
        for (int i = 0; i < personas.size() + 1; i++){
            if(nombre.equalsIgnoreCase(personas.get(i).getNombre())){
                personas.remove(i);
                personaBorrada = true;
            } else {
            }  
        }
        
        if (personaBorrada == false){
            JOptionPane.showMessageDialog(null, "Persona no encontrada");
        }
    
    }
    
    public void verPersonas(){
        String Personas = "";
        for (int i = 0; i < personas.size(); i++){
          Personas += "Persona " + (i + 1) + "\n";
          Personas += "Nombre: " + personas.get(i).getNombre() + " \nEdad: " + personas.get(i).getEdad() + "\n" + "\n"; 
        }   
        JOptionPane.showMessageDialog(null, Personas);
    }
    
        public void recuperarArchivo() throws IOException, ClassNotFoundException{
        FileInputStream archivo = new FileInputStream("datos.dat");
        try (ObjectInputStream entrada = new ObjectInputStream(archivo)) {
            personas = (ArrayList)entrada.readObject();
        }catch(Exception e){
            System.out.println("Error de lectura de archivos");
        }
    }
    public void guardarArchivo() throws FileNotFoundException, IOException{
        FileOutputStream archivo = new FileOutputStream("datos.dat");
        try (ObjectOutputStream salida = new ObjectOutputStream(archivo)) {
            salida.writeObject(personas);
        }catch(Exception e){
            System.out.println("Error de escritura de datos");
        }
    }
}
