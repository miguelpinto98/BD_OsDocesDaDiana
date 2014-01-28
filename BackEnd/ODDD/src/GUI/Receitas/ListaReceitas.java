package GUI.Receitas;

import BusinessLayer.Categoria;
import BusinessLayer.Receita;
import GUI.PainelAdmin;
import java.util.Map;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;

public class ListaReceitas extends javax.swing.JPanel {

    private Categoria c;
    private PainelAdmin p;
    public ListaReceitas(PainelAdmin p,Categoria c) {
        this.p=p;
        this.c=c;
        initComponents();
        Map<Integer, Receita> receitas = c.getReceitas();
        
        this.labelistareceitas.setText("Lista de Receitas de "+c.getNomeCategoria());
        
        Object[] columnNames = new String[] {"ID","Título"};
        Object[][] data = new Object[][] {};
        DefaultTableModel x = new DefaultTableModel(data, columnNames);
        
        if(receitas != null)
            for(Integer n : receitas.keySet())
                x.addRow(new Object[]{n, receitas.get(n).getNome() });
        
        listareceitas.setModel(x);
    }
    
    public int seleccionaReceita() {        
        int id = -1;
        int row = this.listareceitas.getSelectedRow();
        
        if (row != -1)
            id = (int) this.listareceitas.getValueAt(row, 0);
        
        listareceitas.clearSelection();

        return id;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelistareceitas = new javax.swing.JLabel();
        adicionar = new javax.swing.JButton();
        consulta = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listareceitas = new org.jdesktop.swingx.JXTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(359, 351));
        setPreferredSize(new java.awt.Dimension(359, 351));

        labelistareceitas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelistareceitas.setForeground(new java.awt.Color(76, 106, 98));
        labelistareceitas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelistareceitas.setText("Lista de Receitas");

        adicionar.setText("Adicionar");
        adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarActionPerformed(evt);
            }
        });

        consulta.setText("Consultar/Editar");
        consulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaActionPerformed(evt);
            }
        });

        remove.setText("Remover");

        listareceitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Titulo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        listareceitas.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(listareceitas);
        if (listareceitas.getColumnModel().getColumnCount() > 0) {
            listareceitas.getColumnModel().getColumn(0).setResizable(false);
            listareceitas.getColumnModel().getColumn(0).setPreferredWidth(8);
            listareceitas.getColumnModel().getColumn(1).setResizable(false);
            listareceitas.getColumnModel().getColumn(1).setPreferredWidth(150);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelistareceitas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(consulta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(adicionar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(remove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(labelistareceitas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(consulta, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(remove, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarActionPerformed
        // TODO add your handling code here:
        JDialog frame = new JAdicionarReceita(p,this,c);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }//GEN-LAST:event_adicionarActionPerformed

    private void consultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaActionPerformed
        // TODO add your handling code here:
        int id = seleccionaReceita();
        
        if(id != -1) {
            
            JDialog frame = new JEditarReceita(this,this.c.getReceitas().get(id),this.c.getNomeCategoria());
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }
    }//GEN-LAST:event_consultaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionar;
    private javax.swing.JButton consulta;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelistareceitas;
    private org.jdesktop.swingx.JXTable listareceitas;
    private javax.swing.JButton remove;
    // End of variables declaration//GEN-END:variables
}
