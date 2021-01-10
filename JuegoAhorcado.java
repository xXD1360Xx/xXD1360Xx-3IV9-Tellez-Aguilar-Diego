package juegoahorcado;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.*;

public class JuegoAhorcado implements Serializable {
    
    public boolean finalizarMenuPrincipal = false;
    public boolean finalizarJuego = false;
    static String nombreJug;
    static boolean configuracionValida = false;

    public boolean getConfiguracionValida() {
        return configuracionValida;
    }
    
    public String getNombreJug() {
        return nombreJug;
    }

    public static void main(String[] args)throws IOException, ClassNotFoundException{

       //variables
        int opcionMenu;
        int opcionFinPartida;
        boolean finalizarMenuPrincipal = false;
        boolean finalizarConfiguracion = false;
        String jugadoresNom[] = new String[2];
        boolean jugadoresSelec = false;
        int opcJug;
        
        Configuracion objeto1 = new Configuracion();
        Jugadores objeto11 = new Jugadores();
        JOptionPane.showMessageDialog(null, "Bienvenido al juego de Ahorcado", "DIEGO TÉLLEZ AGUILAR 3IV9", JOptionPane.PLAIN_MESSAGE);

        String opcionesMenu[] = {"Empezar partida", "Configurar partida", "Salir"};
        opcionMenu = JOptionPane.showOptionDialog(null, "¿Qué desea hacer?", "Menú principal", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesMenu, opcionesMenu[0]);

        objeto11.recuperarArchivo();
        do{
          
            switch (opcionMenu){
                case 0: 

                        if (configuracionValida != true){
                            
                            int resp = JOptionPane.showConfirmDialog(null, "No has configurado la partida. Tú puntuación no se guardará ¿Deseas continuar jugar sin guardar?", "Configuración de partida", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                                if (resp == 0){
                                    objeto1.antibobos();
                                    JOptionPane.showMessageDialog(null, "El juego se ha configurado con variables predeterminadas (un jugador, 6 vidas y una palabra aleatoria). No seleccionaste jugador, tu puntuación no se guardará", "Configuración de partida", JOptionPane.PLAIN_MESSAGE);
                                    objeto1.procesoJuego();
                                    finalizarMenuPrincipal = true;
                                    break;  
                                }
                        }
                        else{
                            objeto1.procesoJuego();
                            finalizarMenuPrincipal = true;
                            
                            break;
                        }
          
                case 1: 
                    do{
                        objeto1.jugadores01M();

                        if (objeto1.getCantidadJugadores() > 1){
                            
                            do{
                                opcJug = objeto11.mostrarJugadores();
                                
                                switch (opcJug){
                                    case 0:
                                        for (int i = 0; i < 2; i++ ){
                                            nombreJug = objeto11.seleccionarJugador(String.valueOf(i + 1));
                                            jugadoresNom[i] = nombreJug;
                                        }
                                        objeto1.setJugadoresA(jugadoresNom);
                                        jugadoresSelec = true;
                                        break;
                                    case 1:
                                        objeto11.agregarJugador();
                                        
                                        break;
                                    case 2:
                                        nombreJug = objeto11.seleccionarJugador("que desea borrar");
                                        objeto11.borrarJugadores(nombreJug);

                                        break;
                                    case 3:
                                        nombreJug = objeto11.seleccionarJugador("que desea actualizar");
                                        objeto11.ActualizarJugadores(nombreJug);
                                        break;

                                }
                            }while(jugadoresSelec == false);
                            
                            objeto1.palabraM(objeto1.jugadoresA);
                        } 
                        else{
                        objeto1.palabraProM();
                        
                        
                            do{

                                    opcJug = objeto11.mostrarJugadores();
                                    switch (opcJug){
                                        case 0:
                                            nombreJug = objeto11.seleccionarJugador(String.valueOf(1));
                                            jugadoresSelec = true;
                        
                                            break;
                                        case 1:
                                            objeto11.agregarJugador();
                                            break;
                                        case 2:
                                            nombreJug = objeto11.seleccionarJugador("que desea borrar");
                                            objeto11.borrarJugadores(nombreJug);

                                            break;
                                        case 3:
                                            nombreJug = objeto11.seleccionarJugador("que desea actualizar");
                                            objeto11.ActualizarJugadores(nombreJug);
                                            break;

                                    }
                            }while(jugadoresSelec == false);
                        
                        
                        }
 
                        objeto1.dificultadM();
                        
                        
                        configuracionValida = true;
                        
                        JOptionPane.showMessageDialog(null, "La partida se ha configurado con las siguientes especificaciones: \nJugadores: " + objeto1.getCantidadJugadores() + "\nVidas: " + objeto1.getVidas() + "\nPalabra: " + objeto1.getPalabra(), "Configuración de partida", JOptionPane.PLAIN_MESSAGE);
                        
                        String opcionesSubMenu[] = {"Empezar partida", "Configurar partida nuevamente", "Salir"};
                        int opcionSubMenu = JOptionPane.showOptionDialog(null, "¿Qué desea hacer?", "Menú secundario", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesSubMenu, opcionesSubMenu[0]);
                            switch (opcionSubMenu){
                                case 0: 
                                    finalizarConfiguracion = true;
                                    opcionMenu = 0;
                                  
                                    break;

                                case 1:
                                    break;

                                case 2:
                                    finalizarConfiguracion = true;
                                    finalizarMenuPrincipal = true;
                                    break;
                            }
                            
                    }while(finalizarConfiguracion == false);
                    break;
      
                case 2: 
                    finalizarMenuPrincipal = true;
                    break; 
                    
            }
        }while(finalizarMenuPrincipal == false);
        
        
    }
}
