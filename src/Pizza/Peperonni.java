package Pizza;

import javax.swing.JOptionPane;


public class Peperonni extends Pizza{

    public Peperonni() {
    }

    public Peperonni(int masa, int salsa) {
        super(masa, salsa);
    }
    
    private int tipoPeperonni;
    public int elegirTipoPeperonni(){
        String[] tiposPeperonni = {"Rodajas", "Rodajas con Parmesano", "Rodajas con Albaca", "Doble Peperonni en Rodajas"};
        tipoPeperonni = JOptionPane.showOptionDialog(null, "Elige el tipo de Peperonni que deseas", "Tipo de Peperonni", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, tiposPeperonni, tiposPeperonni[0]);
        return tipoPeperonni;
    }

    public int getTipoPeperonni() {
        return tipoPeperonni;
    }
    
    


}
