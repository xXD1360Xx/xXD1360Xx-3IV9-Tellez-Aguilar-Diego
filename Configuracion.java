
package juegoahorcado;

import javax.swing.JOptionPane;

public class Configuracion {
    
    //variables
    private int cantidadJugadores; 
    public String palabra;
    public int vidas;
    private boolean validacion;
    public String[] jugadoresA;
    private int validacionContador = 0;
    private int p = 0;
    private int j = 1;
    private int decisionDificultad;
    
    

    public int getDecisionDificultad() {
        return decisionDificultad;
    }
    
    //constructores
    
   public Configuracion(int cantidadJugadores) {
        this.cantidadJugadores = cantidadJugadores;
    }
    
    public Configuracion(String[] jugadoresA) {
        this.jugadoresA = jugadoresA;
    }
    
    public Configuracion(String palabra) {
        this.palabra = palabra;
    }
    
    public Configuracion(boolean validacion) {
        this.validacion = validacion;
    }

    public Configuracion() {
    }
    
    public Configuracion(int cantidadJugadores, int vidas, String palabra) {
        this.cantidadJugadores = cantidadJugadores;
        this.vidas = vidas;
        this.palabra = palabra;
    }
    
    
    
    public String getPalabra(){
        return palabra;
    }
    
    public int getCantidadJugadores() {
        return cantidadJugadores;
    } 
        
    public String[] getJugadoresA() {
        return jugadoresA;
    }

    public void setJugadoresA(String[] jugadoresA) {
        this.jugadoresA = jugadoresA;
    }
    
    
        
    public int getVidas() {
        return vidas;
    }
    
 // metodo antibobos 
    public void antibobos(){
        String palabras[] = {"Religion", "Television", "Capitalismo", "Politica", "Libertad", "Tecnologia", "Naturaleza", "Anarquismo", "Matematicas", "Filosofia"};
        int valorRandom = (int) (Math.random()* 10);
        palabra = palabras[valorRandom];
        cantidadJugadores = 1;
        vidas = 6;
    }
    
    
    

    //métodos
    public int jugadores01M(){
        String opcionesJugadoresA [] = {"1", "2"};  
        cantidadJugadores = JOptionPane.showOptionDialog(null, "Cuántas personas jugarán?", "Configuración de partida", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesJugadoresA, opcionesJugadoresA[0]);
        cantidadJugadores += 1;
        return cantidadJugadores; 
    }
    
    
      
 
    public String palabraM(String[] jugadoresA){
        int decisionPalabra;
        String[] opcionesPalabraA = {"Escribir palabra", "Generar palabra"};
        decisionPalabra = JOptionPane.showOptionDialog(null, "Debe introducir la palabra con a que se jugará", "Configuración de partida", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesPalabraA, opcionesPalabraA[0]);
        switch (decisionPalabra) {
            case 0:       
                int o = p%2;
                palabra = JOptionPane.showInputDialog(jugadoresA[o] + " (jugador " + (o + 1) + ")" + ", escribe la palabra secreta");
                p += 1;
                break;
             
            case 1: 
                palabraProM();
                p += 1;
        }
        return palabra;
    }
    
    public String palabraProM(){
        String palabras[] = {"Religion", "Television", "Capitalismo", "Politica", "Libertad", "Tecnologia", "Naturaleza", "Anarquismo", "Matematicas", "Filosofia"};
        int valorRandom = (int) (Math.random()* 10);
        palabra = palabras[valorRandom];
               
        JOptionPane.showMessageDialog(null, "Se ha generado una palabra secreta", "Configuración de partida", JOptionPane.PLAIN_MESSAGE);
        return palabra;
    }
    
    
    
    
    public int dificultadM(){
        
        String dificultadA[] = {"Facil (8 vidas)", "Medio (6 vidas)", "Dificil (4 vidas)"};
        decisionDificultad = JOptionPane.showOptionDialog(null, "Debe seleccionar la dificultad de la partida", "Configuración de partida", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, dificultadA, dificultadA[0]);
        switch (decisionDificultad) {    
            case 0:       
                vidas = 8;
                break;

            case 1:              
                vidas = 6;
                break;

            case 2:       
                vidas = 4;
                break;
        }
      return vidas;
    }
    
    boolean finalizarJuego;
    
    public void procesoJuego(){
        ventanaJue ventana = new ventanaJue(palabra, vidas, decisionDificultad, cantidadJugadores, jugadoresA);
        ventana.setVisible(true);
    }    
  
}

   

 