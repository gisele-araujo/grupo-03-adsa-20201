/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Executaveis;

import Coletores.CPU;
import Coletores.Disco;
import Coletores.Formatacao;
import Coletores.Memoria;
import ConexaoBanco.SetSends;
import TesteSlack.MandarMsg;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import javax.swing.JFrame;
import javax.swing.Timer;
import oshi.SystemInfo;
import TesteSlack.MandarMsg;
/**
 *
 * @author Gabriel
 */
public class ScreenEagle extends javax.swing.JFrame {
     
    private CPU cp = new CPU();
    private Memoria memory = new Memoria();
    private Disco disc = new Disco();
    SystemInfo si = new SystemInfo();
    
    
    /** Creates new form ScreenEagle */
    public ScreenEagle() {
        initComponents();
        
        SetSends bd = new SetSends();
        
        bd.setAll();
        
         ActionListener action = (ActionEvent actionEvent) -> {
               
           
            
            lblCpu.setText(String.format("%.0f%%", cp.cpuPorcentagem()));
            lblSpeedCpu.setText(String.format("%.2fGhz", cp.freqMax()));
            //jpCpu.setValue(cp.getPercentComplete().intValue());
            
            
            
            lblMemoria.setText(String.format("%.1fGB / %.1fGB", memory.memoriaLivre(), memory.memoriaTotal()));
            //jpMemoria.setValue(WIDTH);
            
            //lblDisco2.setText(disc.discoDados());
            
            //jpDisco.setValue(WIDTH);
            
            
            lblSistemaOp.setText(String.format("%s", si.getHardware().getProcessor().getProcessorIdentifier().getName()));
            lblModeloCpu.setText(String.format("%s", String.valueOf(si.getOperatingSystem())));
            lblNucleosCpu.setText(String.format("%s", si.getHardware().getProcessor().getPhysicalProcessorCount()));
            lblTimeUse.setText(String.format("%s", Formatacao.formatElapsedSecs(si.getOperatingSystem().getSystemUptime())));
            
            //if(cp.cpuPorcentagem() > 95 || memory.memoriaLivre() < 0.5){
               // alertas(actionEvent);
           // }
          };
            
        
        
        Timer time = new Timer(1000, action);
        time.start();
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblCpu = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblMemoria = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblSistemaOp = new javax.swing.JLabel();
        lblModeloCpu = new javax.swing.JLabel();
        lblNucleosCpu = new javax.swing.JLabel();
        lblSpeedCpu = new javax.swing.JLabel();
        lblTimeUse = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jSeparator1.setBackground(new java.awt.Color(0, 102, 255));
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(20, 40, 400, 10);

        jPanel2.setBackground(new java.awt.Color(0, 102, 255));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CPU");

        lblCpu.setFont(new java.awt.Font("Dialog", 1, 28)); // NOI18N
        lblCpu.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel1)
                .addContainerGap(75, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCpu, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCpu, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(20, 60, 190, 90);

        jPanel3.setBackground(new java.awt.Color(0, 102, 255));

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("MEMÓRIA");

        lblMemoria.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblMemoria.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel3)
                .addContainerGap(63, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMemoria, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMemoria, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(220, 60, 200, 90);

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 255));
        jLabel2.setText("Visão Geral");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(180, 10, 90, 23);

        jPanel5.setBackground(new java.awt.Color(0, 102, 255));

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("INFORMAÇÕES DO SISTEMA:");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Plataforma:");

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Modelo de CPU:");

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Núcleos de CPU:");

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Velocidade de CPU:");

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Tempo de uso:");

        lblSistemaOp.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblSistemaOp.setForeground(new java.awt.Color(255, 255, 255));

        lblModeloCpu.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblModeloCpu.setForeground(new java.awt.Color(255, 255, 255));

        lblNucleosCpu.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblNucleosCpu.setForeground(new java.awt.Color(255, 255, 255));

        lblSpeedCpu.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblSpeedCpu.setForeground(new java.awt.Color(255, 255, 255));

        lblTimeUse.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblTimeUse.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSistemaOp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTimeUse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblModeloCpu, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNucleosCpu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(lblSpeedCpu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(123, 123, 123)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblSistemaOp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblModeloCpu))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lblNucleosCpu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSpeedCpu)
                    .addComponent(jLabel12))
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(lblTimeUse))
                .addGap(16, 16, 16))
        );

        jPanel1.add(jPanel5);
        jPanel5.setBounds(20, 170, 400, 200);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(464, 439));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
     
    
   // private void alertas(java.awt.event.ActionEvent evt){
     //       JFrame frameAlert = new JFrame();
       //     frameAlert.setContentPane(new Alert());
            
        //}
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
            java.util.logging.Logger.getLogger(ScreenEagle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScreenEagle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScreenEagle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScreenEagle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ScreenEagle().setVisible(true);
            }
        });
        
        
        
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCpu;
    private javax.swing.JLabel lblMemoria;
    private javax.swing.JLabel lblModeloCpu;
    private javax.swing.JLabel lblNucleosCpu;
    private javax.swing.JLabel lblSistemaOp;
    private javax.swing.JLabel lblSpeedCpu;
    private javax.swing.JLabel lblTimeUse;
    // End of variables declaration//GEN-END:variables

}
