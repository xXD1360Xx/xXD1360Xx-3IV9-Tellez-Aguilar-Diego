/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenpoo;

import javax.swing.JOptionPane;

/**
 *
 * @author ciegi
 */
public class calificaciones extends javax.swing.JFrame {

    int[] calificaciones = new int[10];
    int contador;
    int califMayor;
    int califMenor;
    double promedio;
    String calificacionesTodas;
    int aprobados, reprobados, menorPromedio, mayorPromedio;
    
    
    
    public calificaciones() {
        initComponents();
        txtNumCalif.setText(String.valueOf(contador + 1));
    }

    public int califMayor(){
        for (int i = 0; i < 10; i ++){
            if (calificaciones[i] > califMayor){
                califMayor = calificaciones[i];
            }       
        }
        return califMayor;
    }
    
    public int califMenor(){
        for (int i = 0; i < 10; i ++){
            if (calificaciones[i] < califMayor){
                califMenor = calificaciones[i];
            }       
        }
        return califMenor;
    }
    
    public double promedio(){
        for (int i = 0; i < 10; i ++){
            promedio += calificaciones[i];
        }
        promedio = promedio/10;
        return promedio;
    }
    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        spinnerCalif = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        txtNumCalif = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnPromedio = new javax.swing.JButton();
        btnCalifAltaBaja = new javax.swing.JButton();
        btnReproApro = new javax.swing.JButton();
        btnSupPromedio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 0, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Calificacion ");

        spinnerCalif.setModel(new javax.swing.SpinnerNumberModel(10, 1, 10, 1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setText("Calificaciones ");

        txtNumCalif.setBackground(new java.awt.Color(153, 0, 0));
        txtNumCalif.setBorder(null);

        btnAgregar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("Ver calificaciones");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnPromedio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPromedio.setText("Obtener promedio");

        btnCalifAltaBaja.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCalifAltaBaja.setText("Calif. mas alta y mas baja");
        btnCalifAltaBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalifAltaBajaActionPerformed(evt);
            }
        });

        btnReproApro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnReproApro.setText("Cantidad de reprobados y aprobados");
        btnReproApro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReproAproActionPerformed(evt);
            }
        });

        btnSupPromedio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSupPromedio.setText("Calif. superiores a promedio");
        btnSupPromedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupPromedioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jButton3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(btnCalifAltaBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSupPromedio))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNumCalif, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(80, 80, 80)
                                        .addComponent(btnAgregar)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnPromedio)
                                    .addComponent(spinnerCalif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(btnReproApro, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNumCalif, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerCalif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnAgregar)
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPromedio, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(btnReproApro, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCalifAltaBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSupPromedio, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(214, 214, 214))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCalifAltaBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalifAltaBajaActionPerformed
        if(calificaciones.length != 10){
            JOptionPane.showMessageDialog(null, "Primero debe ingresar las 10 calificaciones");
        }else{
            JOptionPane.showMessageDialog(null, "La calificacion mas alta es: " + califMayor() + "\n La calificacion mas baja es: " + califMenor());
        }
        
    }//GEN-LAST:event_btnCalifAltaBajaActionPerformed

    private void btnReproAproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReproAproActionPerformed
        if(calificaciones.length != 10){
            JOptionPane.showMessageDialog(null, "Primero debe ingresar las 10 calificaciones");
        }else{
            JOptionPane.showMessageDialog(null, "El promedio es " + promedio()); 
        }
    }//GEN-LAST:event_btnReproAproActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if(calificaciones.length != 10){
            JOptionPane.showMessageDialog(null, "Primero debe ingresar las 10 calificaciones");
        }else{
            calificaciones[contador] = Integer.parseInt(spinnerCalif.getValue().toString());
            contador += 1;
            txtNumCalif.setText(String.valueOf(contador + 1));
            JOptionPane.showMessageDialog(null, "La calificacion " + (contador + 1) + " se ha agregado correctamente");   
        } 
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(calificaciones.length != 10){
            JOptionPane.showMessageDialog(null, "Primero debe ingresar las 10 calificaciones");
        }else{
            for (int i = 0; i < 10; i ++){
                calificacionesTodas = "Calificacion " + (i + 1) + ": " + calificaciones[i] + "\n";
            }
            JOptionPane.showMessageDialog(null, calificacionesTodas);
        } 
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnSupPromedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupPromedioActionPerformed
        if(calificaciones.length != 10){
            JOptionPane.showMessageDialog(null, "Primero debe ingresar las 10 calificaciones");
        }else{
            for (int i = 0; i < 10; i ++){
                if(calificaciones[i] < promedio()){
                    menorPromedio += 1;
                }else{
                    mayorPromedio += 1;
                }
            }
            JOptionPane.showMessageDialog(null, "Las calificaciones mayores del promedio (" + promedio() + ") son: " + mayorPromedio + "\n Las calificaciones menores del promedio (" + promedio() + ") son: " + menorPromedio);
        } 
    }//GEN-LAST:event_btnSupPromedioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(calificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(calificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(calificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(calificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new calificaciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCalifAltaBaja;
    private javax.swing.JButton btnPromedio;
    private javax.swing.JButton btnReproApro;
    private javax.swing.JButton btnSupPromedio;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner spinnerCalif;
    private javax.swing.JTextField txtNumCalif;
    // End of variables declaration//GEN-END:variables
}
