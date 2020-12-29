package Pizza;


import javax.swing.JOptionPane;


    public class Queso extends Pizza {

    public Queso() {
    }

    public Queso(int masa, int salsa) {
        super(masa, salsa);
    }
    
    private int queso;
    public int elegirQueso(){
        String[] quesos = {"Parmesano", "Mozzarela"};
        queso = JOptionPane.showOptionDialog(null, "Elige el queso que deseas", "Quesos", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, quesos, quesos[0]);
        return queso;
    }

    public int getQueso() {
        return queso;
    }
    
    
}

