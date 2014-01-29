package GUI;

import BusinessLayer.Categoria;
import BusinessLayer.ODDD;
import BusinessLayer.Receita;
import BusinessLayer.Utilizador;
import GUI.Receitas.ListaReceitas;
import GUI.Users.InfoUser;
import GUI.Users.JAdicionarUser;
import GUI.comentarios.JComentarios;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;
import java.lang.reflect.Method;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

public final class PainelAdmin extends javax.swing.JFrame {
    public static final String OS = System.getProperty("os.name").toLowerCase();
    
    public static boolean REGISTADO = false;
    public static String UTILIZADOR = null; 
    
    private final ODDD sistema;
    private Utilizador user;

    public PainelAdmin() {
        this.sistema = new ODDD();
        this.user=null;
                
        initComponents();
        listaCategorias();
        listaUtilizadores();
        listaReceitas();
        //verificaUser(user);
    }
    
    public void verificaUser(Utilizador user){
      if(user==null){
          JDialog f = new JLogin(this);
          f.setLocationRelativeTo(null);
          f.setVisible(true);
          labeluser.setText("Bem-Vindo "+this.user.getUsername());
      }  
    }
    
    public void setUser(Utilizador user) {
        this.user = user;
    }
    
     public ODDD getSistema() {
        return this.sistema;
    }
     
    public void listaCategorias() {
        DefaultListModel<String> str = new DefaultListModel<>();

        for(String s : this.sistema.getCategorias().keySet())
            str.addElement(s);
            
        listaCategoria.setModel(str);
    }
    
     public void listaReceitas() {
        DefaultListModel<Integer> str = new DefaultListModel<>();
        for(String s : this.sistema.getCategorias().keySet()){
            for (Integer sd : this.sistema.getCategorias().get(s).getReceitas().keySet()) {
                str.addElement(sd);
            }
        }
        jList1.setModel(str);
    }
    
    public void listaUtilizadores() {
        Object[] columnNames = new String[] {"Tipo","Nome"};
        Object[][] data = new Object[][] {};
        DefaultTableModel x = new DefaultTableModel(data, columnNames);
        
        Map<String, Utilizador> users = this.sistema.getUsers();
        if(users != null)
            for(String n : users.keySet())
                x.addRow(new Object[]{users.get(n).getTipo(),n});
        
        listaUser.setModel(x);
    }

    public String seleccionaUser() {        
        String s;
        int row = this.listaUser.getSelectedRow();

        if (row != -1) {
            s = (String) this.listaUser.getValueAt(row, 1);
        } else {
            s = null;
        }

        listaUser.clearSelection();

        return s;
    }
    
    public String seleccionaRec() {
        String s = null;

        if (jList1.getSelectedIndex() != -1)
            s = jList1.getSelectedValue().toString();

        jList1.clearSelection();
        return s;
    }

    public String seleccionaCategoria() {
        String s = null;

        if (listaCategoria.getSelectedIndex() != -1)
            s = listaCategoria.getSelectedValue().toString();

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
        labeluser = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        painelgeral = new javax.swing.JTabbedPane();
        utilizadores = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        consultarUser = new javax.swing.JButton();
        BloquearUser = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaUser = new org.jdesktop.swingx.JXTable();
        jButton2 = new javax.swing.JButton();
        categorias = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaCategoria = new javax.swing.JList<String>();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        adicionarCategoria1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel6 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jButton4 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(856, 535));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(144, 176, 167));

        jLabel4.setFont(new java.awt.Font("Andalus", 1, 42)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Os doces da Diana");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo.png"))); // NOI18N
        jLabel5.setText("jLabel5");

        jPanel2.setBackground(new java.awt.Color(181, 220, 209));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(144, 176, 167), 2));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(181, 220, 209));

        jButton3.setText("Pesquisar");

        labeluser.setFont(new java.awt.Font("Lucida Grande", 3, 14)); // NOI18N
        labeluser.setText("Bem-Vindo XXX");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione uma base de dados", "Oracle", " " }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labeluser, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jXSearchField1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(labeluser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jXSearchField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jLabel1.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Administração");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(114, 114, 114)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        painelgeral.setBackground(new java.awt.Color(181, 220, 209));
        painelgeral.setToolTipText("");

        utilizadores.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(76, 106, 98));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Lista de Utilizadores");

        consultarUser.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        consultarUser.setText("Consultar");
        consultarUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarUserActionPerformed(evt);
            }
        });

        BloquearUser.setText("Bloquear");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(368, 344));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jButton1.setText("Adicionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        listaUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ativo", "Nome"
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
        listaUser.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(listaUser);
        if (listaUser.getColumnModel().getColumnCount() > 0) {
            listaUser.getColumnModel().getColumn(0).setResizable(false);
            listaUser.getColumnModel().getColumn(1).setResizable(false);
        }

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton2.setText("Atualizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout utilizadoresLayout = new javax.swing.GroupLayout(utilizadores);
        utilizadores.setLayout(utilizadoresLayout);
        utilizadoresLayout.setHorizontalGroup(
            utilizadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(utilizadoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(utilizadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(utilizadoresLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(utilizadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BloquearUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, utilizadoresLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(consultarUser)))))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                .addContainerGap())
        );
        utilizadoresLayout.setVerticalGroup(
            utilizadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(utilizadoresLayout.createSequentialGroup()
                .addGroup(utilizadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(utilizadoresLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(utilizadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(utilizadoresLayout.createSequentialGroup()
                                .addComponent(consultarUser, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BloquearUser, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(utilizadoresLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(utilizadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))))
                .addContainerGap())
        );

        painelgeral.addTab("Utilizadores", utilizadores);

        categorias.setBackground(new java.awt.Color(255, 255, 255));

        listaCategoria.setFont(new java.awt.Font("Lucida Grande", 0, 13)); // NOI18N
        listaCategoria.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaCategoria.setVisibleRowCount(12);
        jScrollPane1.setViewportView(listaCategoria);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(76, 106, 98));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Lista de Categorias");

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
                .addGroup(categoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(categoriasLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(adicionarCategoria1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        categoriasLayout.setVerticalGroup(
            categoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(categoriasLayout.createSequentialGroup()
                .addGroup(categoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(categoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(categoriasLayout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(categoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(adicionarCategoria1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(categoriasLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        painelgeral.addTab("Categorias & Receitas", categorias);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "adsad", "sadas" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(76, 106, 98));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Lista de Receitas");

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jButton4.setText("Comentários");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setPreferredSize(new java.awt.Dimension(442, 350));
        jPanel7.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator3)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        painelgeral.addTab("Comentários", jPanel6);

        getContentPane().add(painelgeral, java.awt.BorderLayout.LINE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void adicionarCategoria1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarCategoria1ActionPerformed
        // TODO add your handling code here:
        String s = seleccionaCategoria();
        
        if(s != null) {
            System.out.println(s);
            Categoria cat = this.sistema.getCategorias().get(s);

            this.jPanel3.removeAll();
            this.jPanel3.add(new ListaReceitas(this,cat), BorderLayout.CENTER);
            this.jPanel3.updateUI();
            this.jPanel3.validate();
        }

    }//GEN-LAST:event_adicionarCategoria1ActionPerformed

    private void consultarUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarUserActionPerformed
        // TODO add your handling code here:
        String s = seleccionaUser();

        if (s != null) {
            System.out.println(s);
            this.jPanel5.removeAll();
            this.jPanel5.add(new InfoUser(this,s), BorderLayout.CENTER);
            this.jPanel5.updateUI();
            this.jPanel5.validate();
        }
    }//GEN-LAST:event_consultarUserActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JDialog atum = new JAdicionarUser(this);
        atum.setLocationRelativeTo(null);
        atum.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        listaUtilizadores();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String s = seleccionaRec();
        int nr = Integer.parseInt(s);
        Receita rec = null;
        for (String ss : this.sistema.getCategorias().keySet())
            for(Integer in : this.sistema.getCategorias().get(ss).getReceitas().keySet())
            { if (in==nr) {
                rec = this.sistema.getCategorias().get(ss).getReceitas().get(in);
                } 
            }
        
        if (s != null) {
            this.jPanel7.removeAll();
            this.jPanel7.add(new JComentarios(this,sistema,rec), BorderLayout.CENTER);
            this.jPanel7.updateUI();
            this.jPanel7.validate();  
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    final PainelAdmin frame = new PainelAdmin();
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

                    if (isMac()) {
                        enableOSXFullscreen(frame);
                    }

                    frame.setVisible(true);
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                }
            }
        });
    }

    public static boolean isMac() {
        return (OS.indexOf("mac") >= 0);
    }

    public static void enableOSXFullscreen(Window window) {
        try {
            Class<?> util = Class.forName("com.apple.eawt.FullScreenUtilities");
            Class<?> params[] = new Class[]{Window.class, Boolean.TYPE};
            Method method = util.getMethod("setWindowCanFullScreen", params);
            method.invoke(util, window, true);
        } catch (ClassNotFoundException exp) {
        } catch (Exception exp) {
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BloquearUser;
    private javax.swing.JButton adicionarCategoria1;
    private javax.swing.JPanel categorias;
    private javax.swing.JButton consultarUser;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private org.jdesktop.swingx.JXSearchField jXSearchField1;
    private javax.swing.JLabel labeluser;
    private javax.swing.JList<String> listaCategoria;
    private org.jdesktop.swingx.JXTable listaUser;
    private javax.swing.JTabbedPane painelgeral;
    private javax.swing.JPanel utilizadores;
    // End of variables declaration//GEN-END:variables
}
