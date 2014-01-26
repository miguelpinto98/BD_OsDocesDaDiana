package GUI;

import BusinessLayer.ODDD;
import BusinessLayer.Utilizador;
import javax.swing.JDialog;

public class JLogin extends javax.swing.JDialog {

    private PainelAdmin p;
    
    public JLogin(PainelAdmin p) {
        
        initComponents();
        this.p=p;
               
        this.setModal(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        p.setEnabled(false); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginpane = new org.jdesktop.swingx.JXLoginPane();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().add(loginpane, java.awt.BorderLayout.CENTER);

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        ODDD o = p.getSistema();
        String username = loginpane.getUserName();
        String password = new String(loginpane.getPassword());
        
        if(!o.login(username, password))
            loginpane.setMessage("Não existe nenhum utilizador com essa password");
        else {     
            Utilizador user = o.getUsers().get(username);
            
            PainelAdmin.UTILIZADOR = username;
            PainelAdmin.REGISTADO = true;
            p.setUser(user);
            p.verificaUser(user);
            p.setEnabled(true);
            dispose();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private org.jdesktop.swingx.JXLoginPane loginpane;
    // End of variables declaration//GEN-END:variables
}
