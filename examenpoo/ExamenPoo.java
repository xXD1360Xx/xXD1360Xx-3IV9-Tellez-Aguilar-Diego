package examenpoo;

import java.io.IOException;
import javax.swing.JOptionPane;

public class ExamenPoo {
    static Persona obj2 = new Persona();
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        obj2.guardarArchivo();
        obj2.recuperarArchivo();
        
        String[] programas = {"Calificaciones", "Personas"};
        int seleccion = JOptionPane.showOptionDialog(null, "Que programa desea abrir?", "Diego Tellez Aguilar 3IV9", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, programas, programas[0]);
        switch(seleccion){
            case 0:
                calificaciones obj = new calificaciones();
                obj.setVisible(true);
                break;
            case 1:
                operaciones obj1 = new operaciones();
                obj1.setVisible(true);
                break;
        }
        
        
    }
    
}
