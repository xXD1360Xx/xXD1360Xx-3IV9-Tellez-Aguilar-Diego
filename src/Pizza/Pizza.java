package Pizza;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import pizzeria.Menu;

public class Pizza {
    
    protected String[] masas = {"Rellena de queso", "Crunch", "Con ajo"};
    protected String[] salsas = {"BBQ", "Tomate", "Hiervas finas"};
    protected String[] tamaños = {"Chica", "Mediana", "Grande", "Familiar"};
    
    protected int masa;
    protected int salsa;
    protected int tamaño;
    
    public String tipoP, tamañoP, masaP, salsaP, ingredienteP;
    public int precio;

    public Pizza(){
    }

    public Pizza(int masa, int salsa) {
        this.masa = masa;
        this.salsa = salsa;
    }

    public int getTamaño() {
        return tamaño;
    }

    //operaciones propias
    public void hornear(int tamaño){
        switch(tamaño){
            case 0:
                JOptionPane.showMessageDialog(null, "El horneado de la pizza ha tomado 15 minutos");
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "El horneado de la pizza ha tomado 20 minutos");
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "El horneado de la pizza ha tomado 25 minutos");
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "El horneado de la pizza ha tomado 30 minutos");
                break;
        }
    }

    public void cortar(int tamaño){
        switch(tamaño){
            case 0:
                JOptionPane.showMessageDialog(null, "La pizza se ha cortado en 4 porciones");
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "La pizza se ha cortado en 8 porciones");
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "La pizza se ha cortado en 12 porciones");
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "La pizza se ha cortado en 16 porciones");
                break;
        }
    }

    public void empacar(int tamaño){
        switch(tamaño){
            case 0:
                JOptionPane.showMessageDialog(null, "La pizza se ha empacado en una cajita de corazon");
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "La pizza se ha empacado en una cajita circular");
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "La pizza se ha empacado en una cajita cuadrada");
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "La pizza se ha empacado en una cajita rectangular");
                break;
        }
    }
    
    public int elegirMasa(){
        masa = JOptionPane.showOptionDialog(null, "Elige la masa que deseas", "Masas", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, masas, masas[0]);
        return masa;
    }
      
    public int elegirSalsa(){
        salsa = JOptionPane.showOptionDialog(null, "Elige la salsa que deseas", "Salsas", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, salsas, salsas[0]);
        return salsa;
    }
    
    public int elegirTamaño(){
        tamaño = JOptionPane.showOptionDialog(null, "Elige el tamaño que deseas", "Tamaños", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, tamaños, tamaños[0]);
        return tamaño;
    }

    
    public Pizza datosPedido(int opc){

      Pizza pedido = new Pizza();
      
      Menu tipoObj = new Menu();
      Queso ques = new Queso();
      Peperonni peper = new Peperonni();
      Vegetariana veger = new Vegetariana();

        switch (opc){
            case 0: 
                tipoP = "Queso";
                    switch(ques.getQueso()){
                        case 0:
                            ingredienteP = "Parmesano";
                            switch (tamaño){
                                case 0: 
                                    tamañoP = "Chica";
                                    precio = 89;
                                  break;
                                case 1:
                                    tamañoP = "Mediana";
                                    precio = 115;
                                  break;
                                case 2:
                                    tamañoP = "Grande";
                                    precio = 135;
                                  break;
                                case 3:
                                    tamañoP = "Familiar";
                                    precio = 175;
                                  break;
                            }
                            
                            break;
                        case 1: 
                            ingredienteP = "Mozzarela";
                            switch (tamaño){
                                case 0: 
                                    tamañoP = "Chica";
                                    precio = 75;
                                  break;
                                case 1:
                                    tamañoP = "Mediana";
                                    precio = 89;
                                  break;
                                case 2:
                                    tamañoP = "Grande";
                                    precio = 112;
                                  break;
                                case 3:
                                    tamañoP = "Familiar";
                                    precio = 135;
                                  break;
                            }
                            break;
                    }   
              break;
              
            case 1:
                tipoP = "Peperonni";
                    switch (tamaño){
                        case 0: 
                            tamañoP = "Chica";
                            precio = 96;
                          break;
                        case 1:
                            tamañoP = "Mediana";
                            precio = 119;
                          break;
                        case 2:
                            tamañoP = "Grande";
                            precio = 131;
                          break;
                        case 3:
                            tamañoP = "Familiar";
                            precio = 167;
                          break;
                    }
                    
                    switch (peper.getTipoPeperonni()){
                        case 0: 
                            ingredienteP = "Rodajas";
                          break;
                        case 1:
                            ingredienteP = "Rodajas con Parmesano";
                          break;
                        case 2:
                            ingredienteP = "Rodajas con Albaca";
                          break;
                        case 3:
                            ingredienteP = "Doble Peperonni en Rodajas";
                          break;
                    }
                break;

            case 2:
                tipoP = "Vegetariana";
                    switch (tamaño){
                        case 0: 
                            tamañoP = "Chica";
                            precio = 88;
                          break;
                        case 1:
                            tamañoP = "Mediana";
                            precio = 97;
                          break;
                        case 2:
                            tamañoP = "Grande";
                            precio = 111;
                          break;
                        case 3:
                            tamañoP = "Familiar";
                            precio = 157;
                          break;
                    }
                    
                    switch (veger.getVerdura()){
                        case 0: 
                            ingredienteP = "Champiñones";
                          break;
                        case 1:
                            ingredienteP = "Piña";
                          break;
                        case 2:
                            ingredienteP = "Pimiento";
                          break;
                        case 3:
                            ingredienteP = "Elote";
                          break;
                    }
                break;
        }
   
        switch (salsa){
            case 0: 
                salsaP = "BBQ";
              break;
            case 1:
                salsaP = "Tomate";
              break;
            case 2:
                salsaP = "Hiervas finas";
              break;
        }
   
        switch (masa){
            case 0: 
                masaP = "Rellena de queso";
              break;
            case 1:
                masaP = "Crunch";
              break;
            case 2:
                masaP = "Con ajo";
              break;
        }

        JOptionPane.showMessageDialog(null, "Tipo de pizza: " + tipoP + "\n Ingrediente de pizza: " + ingredienteP + "\n Masa: " + masaP + "\n Salsa: " + salsaP + "\n Tamaño: " + tamañoP + "\n Precio: $" + precio, "Resumen de pedido", JOptionPane.INFORMATION_MESSAGE);
        pedido.setMasaP(masaP);
        pedido.setSalsaP(salsaP);
        pedido.setTamañoP(tamañoP);
        pedido.setIngredienteP(ingredienteP);
        pedido.setPrecio(precio);
        pedido.setTipoP(tipoP);
        return pedido;
    }
    
    

    public void setTipoP(String tipoP) {
        this.tipoP = tipoP;
    }

    public void setTamañoP(String tamañoP) {
        this.tamañoP = tamañoP;
    }

    public void setMasaP(String masaP) {
        this.masaP = masaP;
    }

    public void setIngredienteP(String ingredienteP) {
        this.ingredienteP = ingredienteP;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setSalsaP(String salsaP) {
        this.salsaP = salsaP;
    }

    public String getTamañoP() {
        return tamañoP;
    }

    public String getSalsaP() {
        return salsaP;
    }
    
    

    public String getTipoP() {
        return tipoP;
    }

    public String getMasaP() {
        return masaP;
    }

    public String getIngredienteP() {
        return ingredienteP;
    }

    public int getPrecio() {
        return precio;
    }

  
    
   
    
}

    
