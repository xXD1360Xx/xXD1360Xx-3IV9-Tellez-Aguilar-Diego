/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pizza;
import javax.swing.JOptionPane;



public class Vegetariana extends Pizza {

    public Vegetariana() {
    }

    public Vegetariana(int masa, int salsa) {
        super(masa, salsa);
    }
    
    private int verdura;
    public int elegirVerdura(){
        String[] verduras = {"Champiñones", "Piña", "Pimiento", "Elote"};
        verdura = JOptionPane.showOptionDialog(null, "Elige la verdura que deseas", "Quesos", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, verduras, verduras[0]);
        return verdura;
    }

    public int getVerdura() {
        return verdura;
    }



    
}
