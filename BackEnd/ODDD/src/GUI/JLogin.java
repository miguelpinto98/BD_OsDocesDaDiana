package GUI;

import BusinessLayer.ODDD;
import BusinessLayer.Utilizador;
import javax.swing.JDialog;

public class JLogin extends javax.swing.JDialog {

    private PainelAdmin p;
    
    public JLogin(PainelAdmin p) {
        this.p=p;
        initComponents();
               
        this.setModal(true);
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        setAlwaysOnTop(true);
        p.setEnabled(false); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginpane = new org.jdesktop.swingx.JXLoginPane();
        jPanel1 = new javax.swing.JPanel();
        sair = new javax.swing.JButton();
        entrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("ODDD_System ");
        setMaximumSize(new java.awt.Dimension(399, 210));
        setMinimumSize(new java.awt.Dimension(399, 210));
        setPreferredSize(new java.awt.Dimension(399, 210));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(loginpane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 160));

        sair.setText("Sair");
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });

        entrar.setText("Entrar");
        entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(entrar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(sair, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(entrar)
                    .addComponent(sair))
                .addGap(31, 31, 31))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 400, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        // TODO add your handling code here:
        System.exit(1);
        
    }//GEN-LAST:event_sairActionPerformed

    private void entrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrarActionPerformed
        // TODO add your handling code here:
        ODDD sistema = p.getSistema();
        String username = loginpane.getUserName();
        String password = new String(loginpane.getPassword());
        
        if(!sistema.login(username, password))
            loginpane.setMessage("Não existe nenhum utilizador com essa password");
        else {     
            Utilizador user = sistema.getUsers().get(username);
            
            PainelAdmin.UTILIZADOR = username;
            PainelAdmin.REGISTADO = true;
            p.setUser(user);
            p.setEnabled(true);
            dispose();
        }
    }//GEN-LAST:event_entrarActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton entrar;
    private javax.swing.JPanel jPanel1;
    private org.jdesktop.swingx.JXLoginPane loginpane;
    private javax.swing.JButton sair;
    // End of variables declaration//GEN-END:variables
}
