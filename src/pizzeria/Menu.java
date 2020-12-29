package pizzeria;


import Pizza.*;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class Menu {

    public int opc;
    int opc2;


    public void MenuOperaciones(){

        Scanner entrada = new Scanner(System.in);
        
        Pizza piza;
        Ticket ventana = new Ticket();
        Pizza pedido = new Pizza();
        
        do{
            String[] tipoPicsa = {"Pizza de Queso", "Pizza de Peperonni", "Pizza Vegetariana"};
            opc = JOptionPane.showOptionDialog(null, "¿Que desea ordenar?", "Bienvenido a la Pizzeria Los Tacos", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, tipoPicsa, tipoPicsa[0]);
            
            switch(opc){
                case 0:
                    piza = new Queso();
                    
                    Queso ques = new Queso();
                    ques.elegirQueso();
                    
                    piza.elegirMasa();
                    piza.elegirSalsa();
                    piza.elegirTamaño();
                    piza.hornear(piza.getTamaño());
                    piza.cortar(piza.getTamaño());
                    piza.empacar(piza.getTamaño());
                    
                    pedido = piza.datosPedido(opc);
                    ventana.crearPedido(pedido);
                    break;

                case 1:
                    piza = new Peperonni();
                    
                    Peperonni peper = new Peperonni();
                    peper.elegirTipoPeperonni();
                    
                    piza.elegirMasa();
                    piza.elegirSalsa();
                    piza.elegirTamaño();
                    piza.hornear(piza.getTamaño());
                    piza.cortar(piza.getTamaño());
                    piza.empacar(piza.getTamaño());
                    
                    pedido = piza.datosPedido(opc);
                    ventana.crearPedido(pedido);
                    break;

                case 2: 
                    piza = new Vegetariana();
                    
                    Vegetariana veger = new Vegetariana();
                    veger.elegirVerdura();
                    
                    piza.elegirMasa();
                    piza.elegirSalsa();
                    piza.elegirTamaño();
                    piza.hornear(piza.getTamaño());
                    piza.cortar(piza.getTamaño());
                    piza.empacar(piza.getTamaño());

                    pedido = piza.datosPedido(opc);
                    ventana.crearPedido(pedido);
                    break;
            }

            String[] opciones = {"Ordenar otra pizza", "Terminar pedido y salir"};
            opc2 = JOptionPane.showOptionDialog(null, "¿Que desea hacer?", "Pizzeria Los Tacos", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
        }while(opc2 != 1);
        ventana.mostrarTicket();
    }


    
}
