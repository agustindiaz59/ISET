package com.mycompany.controlstock.graficos;

import com.mycompany.controlstock.modelo.Producto;
import com.mycompany.controlstock.repositorio.Repositorio;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Principal extends javax.swing.JFrame {

    private DefaultTableModel model;
    private Object[] fila = new Object[5];
    private Repositorio repo;
    private String ultimaConsulta;
    private ResultSet respuesta;

    public Principal() {
        initComponents();
        model = (DefaultTableModel) jTable2.getModel();
        repo = Repositorio.getInstancia();
        setLocationRelativeTo(null);
    }

    //Metodo comun para actualizar la tabla
    private void actualizarTabla() {
        try {
            if (respuesta != null) {
                while (respuesta.next()) {
                    Producto p = new Producto(
                            respuesta.getString("codigo"),
                            respuesta.getString("descripcion"),
                            respuesta.getInt("stock"),
                            respuesta.getLong("precio"),
                            respuesta.getString("rubro")
                    );
                    fila[0] = p.getCodigo();
                    fila[1] = p.getDescripcion();
                    fila[2] = p.getStock();
                    fila[3] = "$" + p.getPrecioPorUnidad();
                    fila[4] = p.getRubro();
                    model.addRow(fila);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error actualizando la tabla, ERR: " + ex.getErrorCode());
        }
    }

    private void vaciarTabla() {
        for (int i = 0; i < model.getRowCount(); i++) {
            model.removeRow(i);
            i -= 1;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        productosPN = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        actualizarBTN = new javax.swing.JButton();
        traerTodoBTN = new javax.swing.JButton();
        busquedaPN = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        busquedaPorCodigoTF = new javax.swing.JTextField();
        buscarCodigoBTN = new javax.swing.JButton();
        buscarPorDescripcionLB = new javax.swing.JLabel();
        buscarDescripcionTF = new javax.swing.JTextField();
        buscarDescripcionBTN = new javax.swing.JButton();
        buscarPorRubroLB = new javax.swing.JLabel();
        buscarPorRubroCBX = new javax.swing.JComboBox<>();
        eliminarPN = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        eliminarLB = new javax.swing.JLabel();
        eliminarTF = new javax.swing.JTextField();
        eliminarBTN = new javax.swing.JButton();
        nuevoPN = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        nuevoCodigoLB = new javax.swing.JLabel();
        nuevoCodigoTF = new javax.swing.JTextField();
        nuevaDescripcionLB = new javax.swing.JLabel();
        nuevaDescripcionTF = new javax.swing.JTextField();
        nuevoStockLB = new javax.swing.JLabel();
        nuevoStockTF = new javax.swing.JTextField();
        nuevoPrecioLB = new javax.swing.JLabel();
        nuevoPrecioTF = new javax.swing.JTextField();
        guardarNuevoBTN = new javax.swing.JButton();
        nuevoRubroLB = new javax.swing.JLabel();
        nuevoRubroTF = new javax.swing.JTextField();
        avisoPN = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Control de stock ISET");
        setBounds(new java.awt.Rectangle(0, 0, 450, 580));
        setResizable(false);

        jDesktopPane1.setPreferredSize(new java.awt.Dimension(420, 600));
        jDesktopPane1.setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        productosPN.setPreferredSize(new java.awt.Dimension(375, 200));
        productosPN.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("Productos"));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(375, 300));

        jTable2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descripcion", "Stock", "Precio unidad", "Rubro"
            }
        ));
        jTable2.setMinimumSize(new java.awt.Dimension(60, 60));
        jScrollPane2.setViewportView(jTable2);

        productosPN.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel5.setLayout(new java.awt.BorderLayout());

        actualizarBTN.setText("Actualizar");
        actualizarBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarBTNActionPerformed(evt);
            }
        });
        jPanel5.add(actualizarBTN, java.awt.BorderLayout.EAST);

        traerTodoBTN.setText("Traer todo");
        traerTodoBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                traerTodoBTNActionPerformed(evt);
            }
        });
        jPanel5.add(traerTodoBTN, java.awt.BorderLayout.WEST);

        productosPN.add(jPanel5, java.awt.BorderLayout.SOUTH);

        jPanel1.add(productosPN);

        busquedaPN.setBorder(javax.swing.BorderFactory.createTitledBorder("Busqueda"));
        busquedaPN.setLayout(new javax.swing.BoxLayout(busquedaPN, javax.swing.BoxLayout.Y_AXIS));

        java.awt.GridBagLayout jPanel4Layout = new java.awt.GridBagLayout();
        jPanel4Layout.columnWidths = new int[] {0, 6, 0, 6, 0, 6, 0, 6, 0, 6, 0, 6, 0};
        jPanel4Layout.rowHeights = new int[] {0, 4, 0, 4, 0};
        jPanel4.setLayout(jPanel4Layout);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setLabelFor(busquedaPorCodigoTF);
        jLabel1.setText("Por codigo");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel4.add(jLabel1, gridBagConstraints);

        busquedaPorCodigoTF.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        busquedaPorCodigoTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busquedaPorCodigoTFActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        jPanel4.add(busquedaPorCodigoTF, gridBagConstraints);

        buscarCodigoBTN.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        buscarCodigoBTN.setText("Buscar");
        buscarCodigoBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarCodigoBTNActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel4.add(buscarCodigoBTN, gridBagConstraints);

        buscarPorDescripcionLB.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        buscarPorDescripcionLB.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buscarPorDescripcionLB.setLabelFor(buscarDescripcionTF);
        buscarPorDescripcionLB.setText("Por descripcion");
        buscarPorDescripcionLB.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel4.add(buscarPorDescripcionLB, gridBagConstraints);

        buscarDescripcionTF.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        buscarDescripcionTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarDescripcionTFActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.9;
        jPanel4.add(buscarDescripcionTF, gridBagConstraints);

        buscarDescripcionBTN.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        buscarDescripcionBTN.setText("Buscar");
        buscarDescripcionBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarDescripcionBTNActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel4.add(buscarDescripcionBTN, gridBagConstraints);

        buscarPorRubroLB.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        buscarPorRubroLB.setText("Por rubro");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel4.add(buscarPorRubroLB, gridBagConstraints);

        buscarPorRubroCBX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Alimenticio", "Bebidas", "Tecnologia", "Electrodomesticos", "Miscelaneos" }));
        buscarPorRubroCBX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscarPorRubroCBXMouseClicked(evt);
            }
        });
        buscarPorRubroCBX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarPorRubroCBXActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel4.add(buscarPorRubroCBX, gridBagConstraints);

        busquedaPN.add(jPanel4);

        jPanel1.add(busquedaPN);

        eliminarPN.setBorder(javax.swing.BorderFactory.createTitledBorder("Eliminar"));
        eliminarPN.setLayout(new javax.swing.BoxLayout(eliminarPN, javax.swing.BoxLayout.LINE_AXIS));

        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        eliminarLB.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        eliminarLB.setText("Por codigo");
        eliminarLB.setPreferredSize(new java.awt.Dimension(83, 16));
        jPanel2.add(eliminarLB);

        eliminarTF.setPreferredSize(new java.awt.Dimension(200, 22));
        eliminarTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarTFActionPerformed(evt);
            }
        });
        jPanel2.add(eliminarTF);

        eliminarBTN.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        eliminarBTN.setText("Eliminar");
        eliminarBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarBTNActionPerformed(evt);
            }
        });
        jPanel2.add(eliminarBTN);

        eliminarPN.add(jPanel2);

        jPanel1.add(eliminarPN);

        nuevoPN.setBorder(javax.swing.BorderFactory.createTitledBorder("Nuevo"));
        nuevoPN.setFocusable(false);
        nuevoPN.setLayout(new javax.swing.BoxLayout(nuevoPN, javax.swing.BoxLayout.X_AXIS));

        java.awt.GridBagLayout jPanel8Layout = new java.awt.GridBagLayout();
        jPanel8Layout.columnWidths = new int[] {0, 6, 0, 6, 0, 6, 0, 6, 0, 6, 0, 6, 0};
        jPanel8Layout.rowHeights = new int[] {0, 10, 0, 10, 0, 10, 0, 10, 0};
        jPanel8.setLayout(jPanel8Layout);

        nuevoCodigoLB.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        nuevoCodigoLB.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nuevoCodigoLB.setText("Codigo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel8.add(nuevoCodigoLB, gridBagConstraints);

        nuevoCodigoTF.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        nuevoCodigoTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoCodigoTFActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 65;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.2;
        jPanel8.add(nuevoCodigoTF, gridBagConstraints);

        nuevaDescripcionLB.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        nuevaDescripcionLB.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nuevaDescripcionLB.setText("Descripcion");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel8.add(nuevaDescripcionLB, gridBagConstraints);

        nuevaDescripcionTF.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        nuevaDescripcionTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevaDescripcionTFActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 65;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.2;
        jPanel8.add(nuevaDescripcionTF, gridBagConstraints);

        nuevoStockLB.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        nuevoStockLB.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nuevoStockLB.setText("Stock");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel8.add(nuevoStockLB, gridBagConstraints);

        nuevoStockTF.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 65;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.2;
        jPanel8.add(nuevoStockTF, gridBagConstraints);

        nuevoPrecioLB.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        nuevoPrecioLB.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nuevoPrecioLB.setText("Precio");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel8.add(nuevoPrecioLB, gridBagConstraints);

        nuevoPrecioTF.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 65;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.2;
        jPanel8.add(nuevoPrecioTF, gridBagConstraints);

        guardarNuevoBTN.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        guardarNuevoBTN.setText("Agregar");
        guardarNuevoBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarNuevoBTNActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 8;
        jPanel8.add(guardarNuevoBTN, gridBagConstraints);

        nuevoRubroLB.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        nuevoRubroLB.setText("Rubro");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel8.add(nuevoRubroLB, gridBagConstraints);

        nuevoRubroTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoRubroTFActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel8.add(nuevoRubroTF, gridBagConstraints);

        nuevoPN.add(jPanel8);

        jPanel1.add(nuevoPN);

        avisoPN.setBorder(javax.swing.BorderFactory.createTitledBorder("Aviso"));
        avisoPN.setPreferredSize(new java.awt.Dimension(420, 70));
        avisoPN.setLayout(new java.awt.BorderLayout());

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel8.setText("<html>Respetar mayusculas y minusculas <p>Los productos que se muestran son los que se encuentran cargados en la base de datos, sin embargo debe mantener la aplicacion actualizada frecuentemente</html>");
        jLabel8.setMaximumSize(new java.awt.Dimension(480, 20));
        jLabel8.setMinimumSize(new java.awt.Dimension(10, 23));
        avisoPN.add(jLabel8, java.awt.BorderLayout.CENTER);

        jPanel1.add(avisoPN);

        jDesktopPane1.add(jPanel1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void busquedaPorCodigoTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busquedaPorCodigoTFActionPerformed
        buscarCodigoBTNActionPerformed(evt);
    }//GEN-LAST:event_busquedaPorCodigoTFActionPerformed

    private void nuevoCodigoTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoCodigoTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nuevoCodigoTFActionPerformed

    private void nuevaDescripcionTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevaDescripcionTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nuevaDescripcionTFActionPerformed

    private void actualizarBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarBTNActionPerformed
        respuesta = repo.select(ultimaConsulta);
        vaciarTabla();
        actualizarTabla();
    }//GEN-LAST:event_actualizarBTNActionPerformed

    private void buscarCodigoBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarCodigoBTNActionPerformed
        ultimaConsulta = "select * from productos where codigo=" + busquedaPorCodigoTF.getText();
        respuesta = repo.select(ultimaConsulta);
        vaciarTabla();
        actualizarTabla();
    }//GEN-LAST:event_buscarCodigoBTNActionPerformed

    private void guardarNuevoBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarNuevoBTNActionPerformed
        Producto p = new Producto();
        if (nuevoCodigoTF.getText().matches("([a-z]|[0-9]){0,20}")) {
            p.setCodigo(nuevoCodigoTF.getText());
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese un codigo valido");
        }
        if (!nuevaDescripcionTF.getText().equals("")) {
            p.setDescripcion(nuevaDescripcionTF.getText());
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese una descripcion valida");
        }
        try {
            p.setStock(Integer.parseInt(nuevoStockTF.getText()));
            p.setPrecioPorUnidad(Double.parseDouble(nuevoPrecioTF.getText()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un numero de stock y precio validos");
        }
        
        p.setRubro(nuevoRubroTF.getText());

        if (p.esValido()) {
            StringBuilder builder = new StringBuilder();
            builder.append("insert into productos(codigo, descripcion, stock, precio, rubro) values(");
            builder.append(p.toString());
            builder.append(")");

            repo.update(builder.toString());
            actualizarTabla();
            JOptionPane.showMessageDialog(null, "Producto agregado con exito");
        } else {
            System.out.println("Registro invalido");
        }
    }//GEN-LAST:event_guardarNuevoBTNActionPerformed

    private void traerTodoBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_traerTodoBTNActionPerformed
        ultimaConsulta = "select * from productos";
        respuesta = repo.select(ultimaConsulta);
        vaciarTabla();
        actualizarTabla();
    }//GEN-LAST:event_traerTodoBTNActionPerformed

    private void buscarDescripcionBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarDescripcionBTNActionPerformed
        ultimaConsulta = "select * from productos where descripcion = '" + buscarDescripcionTF.getText() + "'";
        respuesta = repo.select(ultimaConsulta);
        vaciarTabla();
        actualizarTabla();
    }//GEN-LAST:event_buscarDescripcionBTNActionPerformed

    private void buscarDescripcionTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarDescripcionTFActionPerformed
        buscarDescripcionBTNActionPerformed(evt);
    }//GEN-LAST:event_buscarDescripcionTFActionPerformed

    private void eliminarTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarTFActionPerformed
        eliminarBTNActionPerformed(evt);
    }//GEN-LAST:event_eliminarTFActionPerformed

    private void eliminarBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarBTNActionPerformed

        if (eliminarTF.getText().matches("([a-z]|[0-9]){0,20}")) {
            StringBuilder builder = new StringBuilder();
            builder.append("delete from productos where codigo='");
            builder.append(eliminarTF.getText());
            builder.append("'");

            repo.update(builder.toString());
            traerTodoBTNActionPerformed(evt);
            JOptionPane.showMessageDialog(null, "Producto eliminado con exito");
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese un codigo valido");
        }
    }//GEN-LAST:event_eliminarBTNActionPerformed

    private void nuevoRubroTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoRubroTFActionPerformed
        guardarNuevoBTNActionPerformed(evt);
    }//GEN-LAST:event_nuevoRubroTFActionPerformed

    private void buscarPorRubroCBXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarPorRubroCBXActionPerformed
        switch(buscarPorRubroCBX.getSelectedItem().toString()){
           case "Todos":
               ultimaConsulta = "select * from productos";
               respuesta = repo.select(ultimaConsulta);
               vaciarTabla();
               actualizarTabla();
               break;
           case "Alimenticio":
               ultimaConsulta = "select * from productos where rubro = 'Alimenticio'";
               respuesta = repo.select(ultimaConsulta);
               vaciarTabla();
               actualizarTabla();
               break;
           case "Bebidas":
               ultimaConsulta = "select * from productos where rubro = 'Bebidas'";
               respuesta = repo.select(ultimaConsulta);
               vaciarTabla();
               actualizarTabla();
               break;
           case "Tecnologia":
               ultimaConsulta = "select * from productos where rubro = 'Tecnologia'";
               respuesta = repo.select(ultimaConsulta);
               vaciarTabla();
               actualizarTabla();
               break;
            case "Miscelaneos":
               ultimaConsulta = "select * from productos where rubro = 'Miscelaneos'";
               respuesta = repo.select(ultimaConsulta);
               vaciarTabla();
               actualizarTabla();
               break;
            case "Electrodomesticos":
               ultimaConsulta = "select * from productos where rubro = 'Electrodomesticos'";
               respuesta = repo.select(ultimaConsulta);
               vaciarTabla();
               actualizarTabla();
               break;
           default:
               System.out.println("Combo box invalido");
               break;
       }
    }//GEN-LAST:event_buscarPorRubroCBXActionPerformed

    private void buscarPorRubroCBXMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarPorRubroCBXMouseClicked
        
    }//GEN-LAST:event_buscarPorRubroCBXMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizarBTN;
    private javax.swing.JPanel avisoPN;
    private javax.swing.JButton buscarCodigoBTN;
    private javax.swing.JButton buscarDescripcionBTN;
    private javax.swing.JTextField buscarDescripcionTF;
    private javax.swing.JLabel buscarPorDescripcionLB;
    private javax.swing.JComboBox<String> buscarPorRubroCBX;
    private javax.swing.JLabel buscarPorRubroLB;
    private javax.swing.JPanel busquedaPN;
    private javax.swing.JTextField busquedaPorCodigoTF;
    private javax.swing.JButton eliminarBTN;
    private javax.swing.JLabel eliminarLB;
    private javax.swing.JPanel eliminarPN;
    private javax.swing.JTextField eliminarTF;
    private javax.swing.JButton guardarNuevoBTN;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel nuevaDescripcionLB;
    private javax.swing.JTextField nuevaDescripcionTF;
    private javax.swing.JLabel nuevoCodigoLB;
    private javax.swing.JTextField nuevoCodigoTF;
    private javax.swing.JPanel nuevoPN;
    private javax.swing.JLabel nuevoPrecioLB;
    private javax.swing.JTextField nuevoPrecioTF;
    private javax.swing.JLabel nuevoRubroLB;
    private javax.swing.JTextField nuevoRubroTF;
    private javax.swing.JLabel nuevoStockLB;
    private javax.swing.JTextField nuevoStockTF;
    private javax.swing.JPanel productosPN;
    private javax.swing.JButton traerTodoBTN;
    // End of variables declaration//GEN-END:variables
}
