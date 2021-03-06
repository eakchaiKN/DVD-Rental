
import java.sql.*;
import javax.swing.JOptionPane;
import util.ConnectDB;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.swing.JRViewer;

public class StockDVD extends javax.swing.JInternalFrame {

    Connection con = null;
    ResultSet rs = null;
    Statement stmt = null;
    String rent_status = null;
    int selectRow, selectId;
    DefaultTableModel model, model1;

    public StockDVD() {

        initComponents();
        selectRow = -1;
        selectId = -1;
        rent_status = "Yes";
        displayStock("SELECT * FROM dvd ");
    }

    public void displayStock(String query) {
        model1 = (DefaultTableModel) showStock.getModel();
        model1.setRowCount(0);
        int i = 0;
        try {
            con = ConnectDB.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                String title = (String) rs.getString("title");
                String category = (String) rs.getString("category");
                int price = (int) rs.getInt("price");

                model1.addRow(new Object[]{title, category, price});
                i++;
                //System.out.println(num+" : "+fname);  
            }
            if (i == 0) {
                JOptionPane.showMessageDialog(null, "Search : Not Result");
                displayStock("SELECT * FROM dvd");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void order_by() {
        dvd_idRadioButton.setText("dvd_id");
        titleRadioButton.setText("title");
        categoryRadioButton.setText("category");
        priceRadioButton.setText("priceRadio");
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
        jPanel2 = new javax.swing.JPanel();
        titleTextField = new javax.swing.JTextField();
        categoryTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        priceTextField = new javax.swing.JTextField();
        newButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        showStock = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        dvd_idRadioButton = new javax.swing.JRadioButton();
        priceRadioButton = new javax.swing.JRadioButton();
        titleRadioButton = new javax.swing.JRadioButton();
        categoryRadioButton = new javax.swing.JRadioButton();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        RnameTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        RNoTextField = new javax.swing.JTextField();
        printButton = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Stock");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "DVD Detail"));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        titleTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Title:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Category:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Price:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(priceTextField)
                    .addComponent(categoryTextField)
                    .addComponent(titleTextField, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(jLabel4))
                .addContainerGap())
        );

        newButton.setText("New");
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(newButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(updateButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DeleteButton)
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(DeleteButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(updateButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        showStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title ", "Category", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        showStock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showStockMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(showStock);
        if (showStock.getColumnModel().getColumnCount() > 0) {
            showStock.getColumnModel().getColumn(0).setResizable(false);
            showStock.getColumnModel().getColumn(0).setPreferredWidth(80);
            showStock.getColumnModel().getColumn(1).setResizable(false);
            showStock.getColumnModel().getColumn(1).setPreferredWidth(45);
            showStock.getColumnModel().getColumn(2).setResizable(false);
            showStock.getColumnModel().getColumn(2).setPreferredWidth(30);
        }

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Order By"));

        jPanel5.setBackground(new java.awt.Color(204, 224, 229));

        dvd_idRadioButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        dvd_idRadioButton.setText("By DVD ID");
        dvd_idRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dvd_idRadioButtonActionPerformed(evt);
            }
        });

        priceRadioButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        priceRadioButton.setText("By DVD Price");
        priceRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceRadioButtonActionPerformed(evt);
            }
        });

        titleRadioButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        titleRadioButton.setText("By Title");
        titleRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleRadioButtonActionPerformed(evt);
            }
        });

        categoryRadioButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        categoryRadioButton.setText("By Category");
        categoryRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryRadioButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dvd_idRadioButton)
                    .addComponent(titleRadioButton))
                .addGap(32, 32, 32)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(priceRadioButton)
                    .addComponent(categoryRadioButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dvd_idRadioButton)
                    .addComponent(priceRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleRadioButton)
                    .addComponent(categoryRadioButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Stock Report"));

        jPanel12.setBackground(new java.awt.Color(204, 224, 229));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Report name:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Report No:");

        printButton.setText("Print");
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(RNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(printButton))
                    .addComponent(RnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(RnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(RNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(printButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dvd_idRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dvd_idRadioButtonActionPerformed
        // TODO add your handling code here:
        if (dvd_idRadioButton.isSelected()) {
            priceRadioButton.setSelected(false);
        }
        titleRadioButton.setSelected(false);
        categoryRadioButton.setSelected(false);
        con = ConnectDB.getConnection();
        displayStock("SELECT * FROM dvd ORDER BY dvd_id ");
    }//GEN-LAST:event_dvd_idRadioButtonActionPerformed

    private void titleRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titleRadioButtonActionPerformed
        // TODO add your handling code here:
        if (titleRadioButton.isSelected()) {
            priceRadioButton.setSelected(false);
        }
        dvd_idRadioButton.setSelected(false);
        categoryRadioButton.setSelected(false);

        con = ConnectDB.getConnection();
        displayStock("SELECT * FROM dvd ORDER BY title ");
    }//GEN-LAST:event_titleRadioButtonActionPerformed

    private void categoryRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryRadioButtonActionPerformed
        // TODO add your handling code here:
        if (categoryRadioButton.isSelected()) {
            priceRadioButton.setSelected(false);
        }
        titleRadioButton.setSelected(false);
        dvd_idRadioButton.setSelected(false);

        con = ConnectDB.getConnection();
        displayStock("SELECT * FROM dvd ORDER BY category ");
    }//GEN-LAST:event_categoryRadioButtonActionPerformed

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        // TODO add your handling code here:
        con = ConnectDB.getConnection();
        String title = titleTextField.getText();
        String category = categoryTextField.getText();
        String price = priceTextField.getText();
        String rent_status = "Yes";
        if (!title.isEmpty() && !category.isEmpty() && !price.isEmpty() && !rent_status.isEmpty()) {
            try {
                stmt = con.createStatement();
                stmt.executeUpdate("INSERT INTO dvd(title,category,price,rent_status) VALUES('" + title + "','" + category + "'," + price + ",'" + rent_status + "')");
                titleTextField.setText("");
                categoryTextField.setText("");
                priceTextField.setText("");
                 JOptionPane.showMessageDialog(null, "         Succesfully ", "  Stock", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/icon.png"));   
                displayStock("SELECT * FROM dvd");

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                con = ConnectDB.closeConnection();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please Enter data");
        }

    }//GEN-LAST:event_newButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
        con = ConnectDB.getConnection();
        String title = titleTextField.getText();
        String category = categoryTextField.getText();
        String price = priceTextField.getText();
        if (selectRow >= 0) {
            try {
                stmt = con.createStatement();
                stmt.executeUpdate("UPDATE dvd SET title='" + title + "',category='" + category + "',price=" + price + " WHERE dvd_id = " + selectId + "");
                titleTextField.setText("");
                categoryTextField.setText("");
                priceTextField.setText("");
                    JOptionPane.showMessageDialog(null, "         Succesfully ", "  Stock", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/update.png")); 
                displayStock("SELECT * FROM dvd");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                selectId = -1;
                con = ConnectDB.closeConnection();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select data");
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        // TODO add your handling code here:
        con = ConnectDB.getConnection();
        if (selectRow >= 0) {
           // model.removeRow(selectRow);
            try {
                stmt = con.createStatement();
                //System.out.println("w");
                stmt.executeUpdate("DELETE FROM dvd WHERE dvd_id = "+ selectId );               
            
                titleTextField.setText("");
                categoryTextField.setText("");
                priceTextField.setText("");
                    JOptionPane.showMessageDialog(null, "         Succesfully ", "  Stock", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Delete.png"));  
                
                
                displayStock("SELECT * FROM dvd");
                
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                selectId = -1;
                con = ConnectDB.closeConnection();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select data");
        }

    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void showStockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showStockMouseClicked
        // TODO add your handling code here:
        selectRow = showStock.getSelectedRow();
        con = ConnectDB.getConnection();
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM dvd");
            int i = 0;
            while (rs.next()) {
                if (selectRow == i) {
                    selectId = rs.getInt("dvd_id");
                    String title = rs.getString("title");
                    String category = rs.getString("category");
                    String price = String.valueOf(rs.getInt("price"));

                    titleTextField.setText(title);
                    categoryTextField.setText(category);
                    priceTextField.setText(price);
                }
                i++;
                //System.out.println(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con = ConnectDB.closeConnection();
            System.out.println(selectRow);
        }
    }//GEN-LAST:event_showStockMouseClicked

    private void priceRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceRadioButtonActionPerformed
        // TODO add your handling code here:
        if (priceRadioButton.isSelected()) {
            dvd_idRadioButton.setSelected(false);
        }
        titleRadioButton.setSelected(false);
        categoryRadioButton.setSelected(false);

        con = ConnectDB.getConnection();
        displayStock("SELECT * FROM dvd ORDER BY price ");
    }//GEN-LAST:event_priceRadioButtonActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        // TODO add your handling code here:
        con = ConnectDB.getConnection();
        String Rname = RnameTextField.getText(); // Report is R
        String RNo = RNoTextField.getText();

        if (!Rname.isEmpty() && !RNo.isEmpty()) {
            try {
                stmt = con.createStatement();
                stmt.executeUpdate("INSERT INTO report(Rname,RNo) VALUES('" + Rname + "','" + RNo + "')");
                RnameTextField.setText("");
                RNoTextField.setText("");
                    con = ConnectDB.getConnection();
        Map<String, Object> parameters = new HashMap<String, Object>(); // Parameters for report
        String reportFile = null;
        try {
            reportFile = new File(".").getCanonicalPath() + "\\report.jrxml";
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        try {
            //compile jrxml file
            JasperReport jReport = JasperCompileManager.compileReport(reportFile);
            JasperPrint jPrint = JasperFillManager.fillReport(jReport, parameters, con);

            //Output
            JFrame frame = new JFrame();
            frame.setTitle("Report");
            frame.setBounds(100, 100, 800, 600);
            frame.getContentPane().add(new JRViewer(jPrint));
            frame.setVisible(true);

        } catch (JRException e) {
            e.printStackTrace();
        } finally {
            con = ConnectDB.closeConnection();
        }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                con = ConnectDB.closeConnection();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please Enter data");
        }

        
    }//GEN-LAST:event_printButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteButton;
    private javax.swing.JTextField RNoTextField;
    private javax.swing.JTextField RnameTextField;
    private javax.swing.JRadioButton categoryRadioButton;
    private javax.swing.JTextField categoryTextField;
    private javax.swing.JRadioButton dvd_idRadioButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton newButton;
    private javax.swing.JRadioButton priceRadioButton;
    private javax.swing.JTextField priceTextField;
    private javax.swing.JButton printButton;
    private javax.swing.JTable showStock;
    private javax.swing.JRadioButton titleRadioButton;
    private javax.swing.JTextField titleTextField;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
