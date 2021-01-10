
package juegoahorcado;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ventanaJue extends javax.swing.JFrame {
    
    char letraRespuesta = '5';
    int[] puntuacion = new int [2];
    int puntuacion2 = 0;
    boolean finalizarJuego;
    int j = 1;
    boolean validacion;
    int validacionContador = 0;
    int opcionFinPartida;
    int t;
    boolean finalizarPartida;
    public char[] letrasPalabra;
    char [] guionesPalabra;
    int longitudPalabra;
    String palabra;
    int vidas;
    int decisionDificultad;
    int cantidadJugadores;
    String[] jugadoresA;
    String dibujo;
            
            
    Configuracion objeto1 = new Configuracion();
    Dificil objeto5 = new Dificil();
    Medio objeto6 = new Medio();
    Facil objeto7 = new Facil();
     Jugadores objeto11 = new Jugadores();
    Jugadores objeto12 = new Jugadores();
    JuegoAhorcado objeto13 = new JuegoAhorcado();
    
    public int[] getPuntuacion() {
        return puntuacion;
    }

    public int getPuntuacion2() {
        return puntuacion2;
    }
 
    public ventanaJue(String palabra, int vidas, int decisionDificultad, int cantidadJugadores, String[]jugadoresA){
        initComponents();
        letrasPalabra = palabra.toCharArray();
        guionesPalabra = new char [letrasPalabra.length];
        longitudPalabra = letrasPalabra.length;
        guionesPalabra[0] = letrasPalabra [0];
        guionesPalabra[letrasPalabra.length - 1] = letrasPalabra[letrasPalabra.length - 1];
        
        for(int i = 1; i < letrasPalabra.length - 1; i++){
            guionesPalabra[i] = '_';   
        }   
              
        jPalabra.setText(String.valueOf(guionesPalabra));
        jVidas.setText(String.valueOf(vidas));
        
        if (cantidadJugadores > 1){
            jAviso.setText(jugadoresA[t] + ", ingresa la letra que probablemente esté en la palabra secreta"); 
        }
        else{
            jAviso.setText("Ingresa la letra que probablemente esté en la palabra secreta"); 
        }    
        
        this.palabra = palabra;
        this.vidas = vidas;
        this.decisionDificultad = decisionDificultad;
        this.cantidadJugadores = cantidadJugadores;
        this.jugadoresA = jugadoresA;
        
    }
    
    public void proceso(char letraRespuestaa) {

                                

                                    t = j%2;
                                     
                                        validacionContador = 0;

                                        for(int i = 1; i < letrasPalabra.length - 1; i++){
                                            
                                            
                                            if(String.valueOf(letrasPalabra[i]).equalsIgnoreCase(String.valueOf(letraRespuestaa))){
                                                guionesPalabra[i] = letraRespuestaa;
                                                jPalabra.setText(String.valueOf(guionesPalabra));
                                                validacionContador += 1; 
                                            }
                                            
                                        }
                                        
                                        if (validacionContador == 0){
                                            vidas -= 1; 
                                            jVidas.setText(String.valueOf(vidas));
                                            if (cantidadJugadores > 1){
                                                puntuacion[t] -= 5;
                                                jPuntos.setText(String.valueOf(puntuacion[t]));
                                                jAviso.setText(jugadoresA[t] + ", tú puntuacion (-5 por fallar) es de: " + puntuacion[t]);
                                            }
                                            else{
                                                puntuacion2 -= 5;
                                                jPuntos.setText(String.valueOf(puntuacion2));
                                               jAviso.setText("Tú puntuacion (-5 por fallar) es de: " + puntuacion2);
                                            }
                                            
                                        }
                                        
                                        else{
                                            
                                            if (cantidadJugadores > 1){
                                                puntuacion[t]+= (validacionContador * 10);
                                                jPuntos.setText(String.valueOf(puntuacion[t]));
                                                jAviso.setText(jugadoresA[t] + ", tú puntuacion (+10 por acertar) es de: " + puntuacion[t]);
                                            }

                                            else{
                                                puntuacion2 += validacionContador * 10;
                                                jPuntos.setText(String.valueOf(puntuacion2));
                                                jAviso.setText("Tú puntuacion (+10 por acertar) es de: " + puntuacion2);
                                            }
                                            
                                        }
                                        
                                        validacion = validacionContador >= 1;
                                        
                                    if (validacion == true){
                                        jAviso.setText("Has encontrado una letra correcta :)");
                                    }

                                    else{
                                        jAviso.setText("Has ingresado una letra incorrecta :(");
     
                                        if (decisionDificultad == 2){
                                            dibujo = objeto5.dibujoDificil(vidas); 
                                        }
                                        else {
                                            if (decisionDificultad == 1){
                                                dibujo = objeto6.dibujoMedio(vidas);              
                                            }
                                            else{
                                                dibujo = objeto7.dibujoFacil(vidas);
                                            }
                                        }
                                        jDibujo.setText(dibujo);
                                    }
                                    
                                    if(vidas == 0){
                                        jAviso.setText("Has perdido :(");
                                        proceso2();
                                    }
                                    
                                    if(String.valueOf(letrasPalabra).equalsIgnoreCase(String.valueOf(guionesPalabra))){
                                        jPalabra.setText(String.valueOf(palabra));
                                        jAviso.setText("Has ganado! :)");
                                        proceso2();
                                    }   
                                    
                
    }
                            
    
    
                public void proceso2(){
                           String opcionesFinPartida[] = {"Jugar de nuevo (manteniendo jugadores, puntuaciones y dificultad)", "Terminar juego y guardar", "Salir sin guardar"};
                           opcionFinPartida = JOptionPane.showOptionDialog(null, "¿Qué desea hacer?", "Menú principal", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesFinPartida, opcionesFinPartida[0]);
                           switch(opcionFinPartida){
                               case 0:
                                   
                                    if (cantidadJugadores > 1){
                                        j += 1;
                                        palabra = objeto1.palabraM(jugadoresA);
                                    } 
                                    else{
                                        palabra = objeto1.palabraProM();
                                    }
                                    
                                    letrasPalabra = palabra.toCharArray();
                                    guionesPalabra = new char [letrasPalabra.length];
                                    longitudPalabra = letrasPalabra.length;
                                    guionesPalabra[0] = letrasPalabra [0];
                                    guionesPalabra[letrasPalabra.length - 1] = letrasPalabra[letrasPalabra.length - 1];
                                    for(int i = 1; i < letrasPalabra.length - 1; i++){
                                        guionesPalabra[i] = '_';   
                                    }   
                                    
                                    

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
                                    
                                    jPalabra.setText(String.valueOf(guionesPalabra));
                                    jVidas.setText(String.valueOf(vidas));
                                    break;

                               case 1: 
                                   
                                   if (cantidadJugadores > 1){
                                       JOptionPane.showMessageDialog(null, "La puntuación total de " + jugadoresA[0] + " es de: " + puntuacion[0] + "\nLa puntuación total de " + jugadoresA[1] + " es de: " + puntuacion[1], "Resultados de partida", JOptionPane.PLAIN_MESSAGE);
                                  
                                       if(puntuacion[0] > puntuacion[1]){
                                           JOptionPane.showMessageDialog(null, "El ganador fue el Jugador 1 (" + jugadoresA[0] + ")", "Resultados de partida", JOptionPane.PLAIN_MESSAGE); 
                                       }
                                       else{
                                           JOptionPane.showMessageDialog(null, "El ganador fue el Jugador 2 (" + jugadoresA[1] + ")", "Resultados de partida", JOptionPane.PLAIN_MESSAGE); 
                                       }
                                       
                                       if (objeto13.getConfiguracionValida() == true){
                                            for (int i = 0; i < 2; i++){
                                                objeto12.guardarPuntuacion(jugadoresA[i], puntuacion[i]);
                                                try {
                                                    objeto11.guardarArchivo();
                                                } catch (IOException ex) {
                                                    Logger.getLogger(ventanaJue.class.getName()).log(Level.SEVERE, null, ex);
                                                }
                                            }
                                       }
                       
                                   }

                                    else{
                                       JOptionPane.showMessageDialog(null, "Tú puntuación total es de: " + puntuacion2 , "Resultados de partida", JOptionPane.PLAIN_MESSAGE); 
                                       if (objeto13.getConfiguracionValida() == true){
                                           objeto12.guardarPuntuacion(objeto13.getNombreJug(), puntuacion2);
                                           try {
                                               objeto11.guardarArchivo();
                                           } catch (IOException ex) {
                                               Logger.getLogger(ventanaJue.class.getName()).log(Level.SEVERE, null, ex);
                                           }
                                       }
                                    }
                                   setVisible(false);
                                   System.exit(0);
                                   break;

                               case 2:
                                   System.exit(0);
                                   break;

                            }     
                }
                           
                                           
    

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSalir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jDibujo = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        bQ = new javax.swing.JButton();
        bW = new javax.swing.JButton();
        bE = new javax.swing.JButton();
        bR = new javax.swing.JButton();
        bT = new javax.swing.JButton();
        bY = new javax.swing.JButton();
        bU = new javax.swing.JButton();
        bI = new javax.swing.JButton();
        bO = new javax.swing.JButton();
        bP = new javax.swing.JButton();
        bÑ = new javax.swing.JButton();
        bA = new javax.swing.JButton();
        bS = new javax.swing.JButton();
        bD = new javax.swing.JButton();
        bF = new javax.swing.JButton();
        bG = new javax.swing.JButton();
        bH = new javax.swing.JButton();
        bJ = new javax.swing.JButton();
        bK = new javax.swing.JButton();
        bL = new javax.swing.JButton();
        bZ = new javax.swing.JButton();
        bX = new javax.swing.JButton();
        bC = new javax.swing.JButton();
        bV = new javax.swing.JButton();
        bB = new javax.swing.JButton();
        bN = new javax.swing.JButton();
        bM = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPalabra = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jVidas = new javax.swing.JTextField();
        jAviso = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPuntos = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 102, 255));

        jSalir.setBackground(new java.awt.Color(204, 0, 0));
        jSalir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jSalir.setText("Salir");
        jSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSalirActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));

        jDibujo.setEditable(false);
        jDibujo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jDibujo.setToolTipText("");
        jDibujo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDibujoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jDibujo, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jDibujo, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

        bQ.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        bQ.setText("Q");
        bQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bQActionPerformed(evt);
            }
        });

        bW.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        bW.setText("W");
        bW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bWActionPerformed(evt);
            }
        });

        bE.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        bE.setText("E");
        bE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEActionPerformed(evt);
            }
        });

        bR.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        bR.setText("R");
        bR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRActionPerformed(evt);
            }
        });

        bT.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        bT.setText("T");
        bT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTActionPerformed(evt);
            }
        });

        bY.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        bY.setText("Y");
        bY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bYActionPerformed(evt);
            }
        });

        bU.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        bU.setText("U");
        bU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUActionPerformed(evt);
            }
        });

        bI.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        bI.setText("I");
        bI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bIActionPerformed(evt);
            }
        });

        bO.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        bO.setText("O");
        bO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOActionPerformed(evt);
            }
        });

        bP.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        bP.setText("P");
        bP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPActionPerformed(evt);
            }
        });

        bÑ.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        bÑ.setText("Ñ");
        bÑ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bÑActionPerformed(evt);
            }
        });

        bA.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        bA.setText("A");
        bA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAActionPerformed(evt);
            }
        });

        bS.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        bS.setText("S");
        bS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSActionPerformed(evt);
            }
        });

        bD.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        bD.setText("D");
        bD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDActionPerformed(evt);
            }
        });

        bF.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        bF.setText("F");
        bF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFActionPerformed(evt);
            }
        });

        bG.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        bG.setText("G");
        bG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGActionPerformed(evt);
            }
        });

        bH.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        bH.setText("H");
        bH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHActionPerformed(evt);
            }
        });

        bJ.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        bJ.setText("J");
        bJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bJActionPerformed(evt);
            }
        });

        bK.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        bK.setText("K");
        bK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bKActionPerformed(evt);
            }
        });

        bL.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        bL.setText("L");
        bL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLActionPerformed(evt);
            }
        });

        bZ.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        bZ.setText(" Z");
        bZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bZActionPerformed(evt);
            }
        });

        bX.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        bX.setText("X");
        bX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bXActionPerformed(evt);
            }
        });

        bC.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        bC.setText("C");
        bC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCActionPerformed(evt);
            }
        });

        bV.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        bV.setText("V");
        bV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVActionPerformed(evt);
            }
        });

        bB.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        bB.setText("B");
        bB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBActionPerformed(evt);
            }
        });

        bN.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        bN.setText("N");
        bN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNActionPerformed(evt);
            }
        });

        bM.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        bM.setText("M");
        bM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bA)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(bQ)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bW)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(bE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bY)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bU)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bI)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bO)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bÑ))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(bS)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bF)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bG)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bH)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bJ)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bK)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bL))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(bZ)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bX)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bV)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bM)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bE)
                        .addComponent(bR)
                        .addComponent(bT)
                        .addComponent(bY)
                        .addComponent(bU)
                        .addComponent(bI)
                        .addComponent(bO)
                        .addComponent(bP)
                        .addComponent(bÑ))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bQ)
                        .addComponent(bW)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bA)
                    .addComponent(bS)
                    .addComponent(bD)
                    .addComponent(bF)
                    .addComponent(bG)
                    .addComponent(bH)
                    .addComponent(bJ)
                    .addComponent(bK)
                    .addComponent(bL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bZ)
                    .addComponent(bX)
                    .addComponent(bC)
                    .addComponent(bV)
                    .addComponent(bB)
                    .addComponent(bN)
                    .addComponent(bM))
                .addGap(19, 19, 19))
        );

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));

        jPalabra.setEditable(false);
        jPalabra.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jPalabra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPalabraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(jPalabra, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jPalabra, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Vidas: ");

        jVidas.setEditable(false);
        jVidas.setBackground(new java.awt.Color(153, 102, 255));
        jVidas.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jVidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jVidasActionPerformed(evt);
            }
        });

        jAviso.setEditable(false);
        jAviso.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Puntos:");

        jPuntos.setEditable(false);
        jPuntos.setBackground(new java.awt.Color(153, 102, 255));
        jPuntos.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jPuntos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPuntosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jAviso)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jVidas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(2, 2, 2))))))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jVidas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jAviso, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(126, 126, 126))
        );

        jVidas.setText("t");
        jVidas.setText("t");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jSalirActionPerformed

    private void bQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bQActionPerformed
        letraRespuesta = 'q';
        proceso(letraRespuesta);
    }//GEN-LAST:event_bQActionPerformed

    private void bWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bWActionPerformed
        letraRespuesta = 'w';
        proceso(letraRespuesta);
    }//GEN-LAST:event_bWActionPerformed

    private void bEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEActionPerformed
       letraRespuesta = 'e';
       proceso(letraRespuesta);
    }//GEN-LAST:event_bEActionPerformed

    private void bRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRActionPerformed
        letraRespuesta = 'r';
        proceso(letraRespuesta);
    }//GEN-LAST:event_bRActionPerformed

    private void bTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTActionPerformed
        letraRespuesta = 't';
        proceso(letraRespuesta);
    }//GEN-LAST:event_bTActionPerformed

    private void bYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bYActionPerformed
        letraRespuesta = 'y';
        proceso(letraRespuesta);
    }//GEN-LAST:event_bYActionPerformed

    private void bUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUActionPerformed
        letraRespuesta = 'u';
        proceso(letraRespuesta);
    }//GEN-LAST:event_bUActionPerformed

    private void bIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bIActionPerformed
        letraRespuesta = 'i';
        proceso(letraRespuesta);
    }//GEN-LAST:event_bIActionPerformed

    private void bOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOActionPerformed
        letraRespuesta = 'o';
        proceso(letraRespuesta);
    }//GEN-LAST:event_bOActionPerformed

    private void bPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPActionPerformed
       letraRespuesta = 'p';
       proceso(letraRespuesta);
    }//GEN-LAST:event_bPActionPerformed

    private void bÑActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bÑActionPerformed
       letraRespuesta = 'ñ';
       proceso(letraRespuesta);
    }//GEN-LAST:event_bÑActionPerformed

    private void bAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAActionPerformed
        letraRespuesta = 'a';
        proceso(letraRespuesta);
    }//GEN-LAST:event_bAActionPerformed

    private void bSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSActionPerformed
        letraRespuesta = 's';
        proceso(letraRespuesta);
    }//GEN-LAST:event_bSActionPerformed

    private void bDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDActionPerformed
        letraRespuesta = 'd';
        proceso(letraRespuesta);
    }//GEN-LAST:event_bDActionPerformed

    private void bFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFActionPerformed
        letraRespuesta = 'f';
        proceso(letraRespuesta);
    }//GEN-LAST:event_bFActionPerformed

    private void bGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGActionPerformed
        letraRespuesta = 'g';
        proceso(letraRespuesta);
    }//GEN-LAST:event_bGActionPerformed

    private void bHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHActionPerformed
        letraRespuesta = 'h';
        proceso(letraRespuesta);
    }//GEN-LAST:event_bHActionPerformed

    private void bJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bJActionPerformed
        letraRespuesta = 'j';
        proceso(letraRespuesta);
    }//GEN-LAST:event_bJActionPerformed

    private void bKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bKActionPerformed
        letraRespuesta = 'k';
        proceso(letraRespuesta);
    }//GEN-LAST:event_bKActionPerformed

    private void bLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLActionPerformed
        letraRespuesta = 'l';
        proceso(letraRespuesta);
    }//GEN-LAST:event_bLActionPerformed

    private void bZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bZActionPerformed
        letraRespuesta = 'z';
        proceso(letraRespuesta);
    }//GEN-LAST:event_bZActionPerformed

    private void bXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bXActionPerformed
        letraRespuesta = 'x';
        proceso(letraRespuesta);
    }//GEN-LAST:event_bXActionPerformed

    private void bCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCActionPerformed
        letraRespuesta = 'c';
        proceso(letraRespuesta);
    }//GEN-LAST:event_bCActionPerformed

    private void bVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVActionPerformed
        letraRespuesta = 'v';
        proceso(letraRespuesta);
    }//GEN-LAST:event_bVActionPerformed

    private void bBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBActionPerformed
       letraRespuesta = 'b';
       proceso(letraRespuesta);
    }//GEN-LAST:event_bBActionPerformed

    private void bNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNActionPerformed
        letraRespuesta = 'n';
        proceso(letraRespuesta);
    }//GEN-LAST:event_bNActionPerformed

    private void bMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMActionPerformed
        letraRespuesta = 'm';
        proceso(letraRespuesta);
    }//GEN-LAST:event_bMActionPerformed

    private void jDibujoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDibujoActionPerformed

    }//GEN-LAST:event_jDibujoActionPerformed

    
    private void jPalabraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPalabraActionPerformed
         
    }//GEN-LAST:event_jPalabraActionPerformed

    private void jVidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jVidasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jVidasActionPerformed

    private void jPuntosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPuntosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPuntosActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bA;
    private javax.swing.JButton bB;
    private javax.swing.JButton bC;
    private javax.swing.JButton bD;
    private javax.swing.JButton bE;
    private javax.swing.JButton bF;
    private javax.swing.JButton bG;
    private javax.swing.JButton bH;
    private javax.swing.JButton bI;
    private javax.swing.JButton bJ;
    private javax.swing.JButton bK;
    private javax.swing.JButton bL;
    private javax.swing.JButton bM;
    private javax.swing.JButton bN;
    private javax.swing.JButton bO;
    private javax.swing.JButton bP;
    private javax.swing.JButton bQ;
    private javax.swing.JButton bR;
    private javax.swing.JButton bS;
    private javax.swing.JButton bT;
    private javax.swing.JButton bU;
    private javax.swing.JButton bV;
    private javax.swing.JButton bW;
    private javax.swing.JButton bX;
    private javax.swing.JButton bY;
    private javax.swing.JButton bZ;
    private javax.swing.JButton bÑ;
    private javax.swing.JTextField jAviso;
    private javax.swing.JTextField jDibujo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jPalabra;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jPuntos;
    private javax.swing.JButton jSalir;
    private javax.swing.JTextField jVidas;
    // End of variables declaration//GEN-END:variables
}
