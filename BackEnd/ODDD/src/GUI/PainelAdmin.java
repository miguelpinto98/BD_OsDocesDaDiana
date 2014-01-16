package GUI;

import BusinessLayer.ODDD;
import BusinessLayer.Utilizador;
import GUI.Categorias.JAdicionarCategoria;
import GUI.Receitas.ListaReceitas;
import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;


public class PainelAdmin extends javax.swing.JFrame {
    private ODDD sistema;
    private Utilizador user;

   
    public PainelAdmin() {
        initComponents();
    }
    
    public String seleccionaCategoria(){
        String s;
        
        if (listaCategoria.getSelectedIndex() != -1){
            s = listaCategoria.getSelectedValue().toString();
        }
        else{s= null;}
        
        listaCategoria.clearSelection();
        
       return s;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jXSearchField1 = new org.jdesktop.swingx.JXSearchField();
        jButton3 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        painelgeral = new javax.swing.JTabbedPane();
        categorias = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaCategoria = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        adicionarCategoria = new javax.swing.JButton();
        editarCategoria = new javax.swing.JButton();
        removerCategoria = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        adicionarCategoria1 = new javax.swing.JButton();
        utilizadores = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(144, 176, 167));

        jLabel4.setFont(new java.awt.Font("Andalus", 1, 42)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Os doces da Diana");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo.png"))); // NOI18N
        jLabel5.setText("jLabel5");

        jPanel2.setBackground(new java.awt.Color(181, 220, 209));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(144, 176, 167), 2));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(181, 220, 209));

        jXSearchField1.setText("jXSearchField1");

        jButton3.setText("Pesquisar");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXSearchField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(123, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXSearchField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel4, java.awt.BorderLayout.LINE_START);

        jPanel5.setBackground(new java.awt.Color(181, 220, 209));

        jButton1.setText("Registar");

        jButton2.setText("Entrar");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(211, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel5, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        painelgeral.setBackground(new java.awt.Color(181, 220, 209));
        painelgeral.setToolTipText("");

        categorias.setBackground(new java.awt.Color(255, 255, 255));

        listaCategoria.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listaCategoria);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(76, 106, 98));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Lista de Categorias");

        adicionarCategoria.setText("Adicionar");
        adicionarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarCategoriaActionPerformed(evt);
            }
        });

        editarCategoria.setText("Editar");

        removerCategoria.setText("Remover");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setMinimumSize(new java.awt.Dimension(359, 351));
        jPanel3.setPreferredSize(new java.awt.Dimension(359, 351));
        jPanel3.setLayout(new java.awt.BorderLayout());

        adicionarCategoria1.setText("Ver Receitas");
        adicionarCategoria1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarCategoria1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout categoriasLayout = new javax.swing.GroupLayout(categorias);
        categorias.setLayout(categoriasLayout);
        categoriasLayout.setHorizontalGroup(
            categoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(categoriasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(categoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(categoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(adicionarCategoria1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(adicionarCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editarCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(removerCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                .addContainerGap())
        );
        categoriasLayout.setVerticalGroup(
            categoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(categoriasLayout.createSequentialGroup()
                .addGroup(categoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(categoriasLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(categoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(categoriasLayout.createSequentialGroup()
                                .addComponent(adicionarCategoria1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(adicionarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(editarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(removerCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(categoriasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(categoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 343, Short.MAX_VALUE)
                            .addComponent(jSeparator1))))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        painelgeral.addTab("Categorias & Receitas", categorias);

        utilizadores.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout utilizadoresLayout = new javax.swing.GroupLayout(utilizadores);
        utilizadores.setLayout(utilizadoresLayout);
        utilizadoresLayout.setHorizontalGroup(
            utilizadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 742, Short.MAX_VALUE)
        );
        utilizadoresLayout.setVerticalGroup(
            utilizadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 367, Short.MAX_VALUE)
        );

        painelgeral.addTab("Utilizadores", utilizadores);

        getContentPane().add(painelgeral, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void adicionarCategoria1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarCategoria1ActionPerformed
        // TODO add your handling code here:
        String s = seleccionaCategoria();
        
        if(s != null) {
             this.jPanel3.removeAll();
             this.jPanel3.add(new ListaReceitas(this), BorderLayout.CENTER);
             this.jPanel3.updateUI();
             this.jPanel3.validate();
        }
        
    }//GEN-LAST:event_adicionarCategoria1ActionPerformed

    private void adicionarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarCategoriaActionPerformed
        // TODO add your handling code here:
        String s = seleccionaCategoria();
        if(s!=null){
         JDialog frame = new JAdicionarCategoria(this);
         frame.setLocationRelativeTo(null);
         frame.setVisible(true);
        }
    }//GEN-LAST:event_adicionarCategoriaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PainelAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionarCategoria;
    private javax.swing.JButton adicionarCategoria1;
    private javax.swing.JPanel categorias;
    private javax.swing.JButton editarCategoria;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private org.jdesktop.swingx.JXSearchField jXSearchField1;
    private javax.swing.JList listaCategoria;
    private javax.swing.JTabbedPane painelgeral;
    private javax.swing.JButton removerCategoria;
    private javax.swing.JPanel utilizadores;
    // End of variables declaration//GEN-END:variables
}
