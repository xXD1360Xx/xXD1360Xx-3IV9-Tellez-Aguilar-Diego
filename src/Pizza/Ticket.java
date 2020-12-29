
package Pizza;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import pizzeria.Menu;


public class Ticket extends JFrame{
    
    public  ArrayList<Pizza> listaPedidos = new ArrayList();
    Pizza pedido = new Pizza();
    Pizza au = new Pizza();

    public void crearPedido(Pizza pedido){
        listaPedidos.add(pedido);
    }
    
    public void mostrarTicket(){
        String ticket = "";
        for (int i = 0; i < listaPedidos.size(); i++){
          ticket += "Pedido " + (i + 1) + "\n";
          ticket += "Pizza de " + listaPedidos.get(i).getTipoP() + " " + listaPedidos.get(i).getTamañoP()+ "                            $" + listaPedidos.get(i).getPrecio() + "\n" + "\n"; 
        }
        JOptionPane.showMessageDialog(null, ticket); 
    }



}
