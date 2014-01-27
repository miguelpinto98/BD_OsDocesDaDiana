package GUI.Receitas;

import BusinessLayer.Categoria;
import GUI.PainelAdmin;
import javax.swing.JDialog;

public class ListaReceitas extends javax.swing.JPanel {

    private Categoria c;
    private PainelAdmin p;
    public ListaReceitas(PainelAdmin p,Categoria c) {
        this.p=p;
        this.c=c;
        initComponents();
    }

    public String seleccionaReceita(){
        String s;
        
        if (listaReceita.getSelectedIndex() != -1){
            s = listaReceita.getSelectedValue().toString();
        }
        else{s= null;}
        
        listaReceita.clearSelection();
        
       return s;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaReceita = new javax.swing.JList();
        adicionarCategoria = new javax.swing.JButton();
        adicionarCategoria1 = new javax.swing.JButton();
        adicionarCategoria2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(359, 351));
        setPreferredSize(new java.awt.Dimension(359, 351));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(76, 106, 98));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Lista de Receitas");

        listaReceita.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listaReceita);

        adicionarCategoria.setText("Adicionar");
        adicionarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarCategoriaActionPerformed(evt);
            }
        });

        adicionarCategoria1.setText("Editar");
        adicionarCategoria1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarCategoria1ActionPerformed(evt);
            }
        });

        adicionarCategoria2.setText("Remover");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(adicionarCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                    .addComponent(adicionarCategoria1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(adicionarCategoria2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(adicionarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(adicionarCategoria1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(adicionarCategoria2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void adicionarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarCategoriaActionPerformed
        // TODO add your handling code here:
        String s = seleccionaReceita();
        if(s!=null){
         JDialog frame = new JAdicionarReceita(p,this,c);
         frame.setLocationRelativeTo(null);
         frame.setVisible(true);
        }
    }//GEN-LAST:event_adicionarCategoriaActionPerformed

    private void adicionarCategoria1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarCategoria1ActionPerformed
        // TODO add your handling code here:
        String s = seleccionaReceita();
        if(s!=null){
         JDialog frame = new JEditarReceita(this);
         frame.setLocationRelativeTo(null);
         frame.setVisible(true);
        }
    }//GEN-LAST:event_adicionarCategoria1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionarCategoria;
    private javax.swing.JButton adicionarCategoria1;
    private javax.swing.JButton adicionarCategoria2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listaReceita;
    // End of variables declaration//GEN-END:variables
}
