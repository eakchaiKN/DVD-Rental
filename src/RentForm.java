import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import util.ConnectDB;
import javax.swing.table.DefaultTableModel;
public class RentForm extends javax.swing.JInternalFrame {
    
    DefaultTableModel model,model1 ;
    public RentForm() {
        initComponents();
        displayCustomer("SELECT * FROM customers ORDER BY cus_id");
    }
  
    public void displayCustomer(String query){
        model1 = (DefaultTableModel) showCustomer.getModel();
        model1.setRowCount(0);
        Connection con = null;
        ResultSet rs = null;
        Statement stmt = null;
        int i=0;
        con = ConnectDB.getConnection();
        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while(rs.next()){              
                String num = (String) rs.getString("cus_id");
                String fname = (String) rs.getString("cus_fname");
                String lname = (String) rs.getString("cus_lname");
                model1.addRow(new Object[]{num,fname,lname});
                i++; 
            }
            if (i==0){
                JOptionPane.showMessageDialog(null,"Search : Not Result");
                displayCustomer("SELECT * FROM customers");
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                con.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        searchValue = new javax.swing.JTextField();
        showAllButton = new javax.swing.JButton();
        searchCustomerButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        showCustomer = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        searchDVDvalue = new javax.swing.JTextField();
        searchDVDButton = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        showDvdId = new javax.swing.JTextField();
        showTiTle = new javax.swing.JTextField();
        addRentList = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        showCategory = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        showPrice = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        showCusID = new javax.swing.JTextField();
        showTotal = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        rentListView = new javax.swing.JTable();
        deleteRentList = new javax.swing.JButton();
        deleteAllRentList = new javax.swing.JButton();
        rentSubmit = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Rent DVD");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Customer Information"));

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));

        showAllButton.setBackground(new java.awt.Color(255, 255, 255));
        showAllButton.setText("Show All");
        showAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showAllButtonActionPerformed(evt);
            }
        });

        searchCustomerButton.setBackground(new java.awt.Color(255, 255, 255));
        searchCustomerButton.setText("Search");
        searchCustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchCustomerButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Customer ID :");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(searchCustomerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(showAllButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchValue, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchValue, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showAllButton)
                    .addComponent(searchCustomerButton))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        showCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "First Name", "Last name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        showCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showCustomerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(showCustomer);
        if (showCustomer.getColumnModel().getColumnCount() > 0) {
            showCustomer.getColumnModel().getColumn(0).setResizable(false);
            showCustomer.getColumnModel().getColumn(0).setPreferredWidth(30);
            showCustomer.getColumnModel().getColumn(1).setResizable(false);
            showCustomer.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Search Member");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(108, 108, 108)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                .addGap(5, 5, 5))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Borrow"));

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "DVD Detail"));

        jPanel17.setBackground(new java.awt.Color(204, 204, 255));

        searchDVDButton.setBackground(new java.awt.Color(255, 255, 255));
        searchDVDButton.setText("Search");
        searchDVDButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchDVDButtonActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("DVD ID :");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchDVDvalue, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchDVDButton)
                .addGap(24, 24, 24))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(searchDVDvalue, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchDVDButton))
                .addGap(40, 40, 40))
        );

        jPanel18.setBackground(new java.awt.Color(204, 204, 255));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setText("DVD ID :");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setText("Title :");

        showDvdId.setEditable(false);
        showDvdId.setBackground(new java.awt.Color(0, 0, 0));
        showDvdId.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        showDvdId.setForeground(new java.awt.Color(255, 255, 0));

        showTiTle.setEditable(false);
        showTiTle.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        addRentList.setText("Select");
        addRentList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRentListActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Price :");

        showCategory.setEditable(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Category :");

        showPrice.setEditable(false);
        showPrice.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(showPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(addRentList, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(showTiTle, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(showCategory)
                    .addComponent(showDvdId, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(19, 19, 19))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showDvdId, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showTiTle, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showCategory, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(jLabel6))
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(showPrice, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(addRentList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Current DVD to rent"));

        jPanel16.setBackground(new java.awt.Color(204, 224, 229));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Customer ID :");

        showCusID.setEditable(false);
        showCusID.setBackground(new java.awt.Color(255, 255, 51));
        showCusID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        showCusID.setForeground(new java.awt.Color(255, 0, 0));
        showCusID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        showCusID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showCusIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(showCusID)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel18))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(showCusID, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        showTotal.setEditable(false);
        showTotal.setBackground(new java.awt.Color(0, 0, 0));
        showTotal.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        showTotal.setForeground(new java.awt.Color(255, 255, 0));
        showTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        showTotal.setText("0");

        rentListView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DVD ID", "Title ", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        rentListView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rentListViewMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(rentListView);

        deleteRentList.setText("Delete");
        deleteRentList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteRentListActionPerformed(evt);
            }
        });

        deleteAllRentList.setText("Delete all");
        deleteAllRentList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteAllRentListActionPerformed(evt);
            }
        });

        rentSubmit.setText("Rent");
        rentSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rentSubmitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(showTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(deleteAllRentList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rentSubmit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(1, 1, 1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addComponent(deleteRentList, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(showTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(deleteRentList, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteAllRentList, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(rentSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchCustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchCustomerButtonActionPerformed
        // TODO add your handling code here:
        String id = searchValue.getText();
        if(id.isEmpty()){
              JOptionPane.showMessageDialog(null,"Please Enter ID");
              
        }else{
            
            displayCustomer("SELECT * FROM customers WHERE cus_id = '"+id+"'");
            searchValue.setText("");
        }
    }//GEN-LAST:event_searchCustomerButtonActionPerformed

    private void showAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showAllButtonActionPerformed
        // TODO add your handling code here:
        displayCustomer("SELECT * FROM customers");
        searchValue.setText("");
    }//GEN-LAST:event_showAllButtonActionPerformed

    private void searchDVDButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchDVDButtonActionPerformed
        // TODO add your handling code here:
        String id = searchDVDvalue.getText();
        if (id.isEmpty()){
            JOptionPane.showMessageDialog(null,"Please Enter ID");
            
        }else{
            Connection con = null;
            ResultSet rs = null;
            Statement stmt = null;
            int i=0;
            try{
                con = ConnectDB.getConnection();
                stmt = con.createStatement();
                rs = stmt.executeQuery("select * from dvd where dvd_id = '"+id+"'");
                if(rs.next()){              
                    String num = (String) rs.getString("dvd_id");
                    String title = (String) rs.getString("title");
                    String category = (String) rs.getString("category");
                    int price = rs.getInt("price");
                     showDvdId.setText(num);
                     showTiTle.setText(title);
                     showCategory.setText(category);
                     showPrice.setText(Integer.toString(price));
                     searchDVDvalue.setText("");
                    i++;
                }
                if (i==0){
                    JOptionPane.showMessageDialog(null,"Search : Not Result");
                    searchDVDvalue.setText("");
                }
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                try{
                    con.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        
    }//GEN-LAST:event_searchDVDButtonActionPerformed

    private void showCusIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showCusIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_showCusIDActionPerformed

    private void showCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showCustomerMouseClicked
        // TODO add your handling code here:
        try{
            int row = showCustomer.getSelectedRow();
            showCusID.setText(showCustomer.getModel().getValueAt(row,0).toString());
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_showCustomerMouseClicked
    boolean checkSelected(String id){
        boolean check = false;
        int row = model.getRowCount();
        while(row > 0){
            String value = String.valueOf(model.getValueAt(row-1,0));
            if(value.equals(id)){
                check = true;
            }else {
                check = false;
            }
            row--;
        }
        return check;
    }
    private void addRentListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRentListActionPerformed
        // TODO add your handling code here:
        model = (DefaultTableModel) rentListView.getModel();
        String dvdId = showDvdId.getText();
        String price = showPrice.getText();
        String title = showTiTle.getText();
        Connection con = null;
        ResultSet rs = null;
        Statement stmt = null;
        int i=0;
            try{
                con = ConnectDB.getConnection();
                stmt = con.createStatement();
                rs = stmt.executeQuery("select rent_status from dvd where dvd_id = '"+dvdId+"'");   
                if(rs.next()){
                    String s = (String)rs.getString("rent_status");
                    //System.out.println(s);
                    if(s.equals("Yes")){
                        JOptionPane.showMessageDialog(null,"DVD is rented");
                        showDvdId.setText("");
                        showPrice.setText("");
                        showTiTle.setText("");
                        showCategory.setText("");
                    }else if(checkSelected(dvdId)){
                        JOptionPane.showMessageDialog(null,"DVD is selected");
                        showDvdId.setText("");
                        showPrice.setText("");
                        showTiTle.setText("");
                        showCategory.setText("");
                    }else{
                        int total = Integer.parseInt(price);
                        //int total = 0;
                        int getsum = Integer.parseInt(showTotal.getText());
                        int sum = total + getsum;
                        showTotal.setText(String.valueOf(sum));
                        if(dvdId.isEmpty()){
                            JOptionPane.showMessageDialog(null,"Please select DVD");
                        }else{
                            model.addRow(new Object[]{dvdId,title,price});
                            showDvdId.setText("");
                            showPrice.setText("");
                            showTiTle.setText("");
                            showCategory.setText("");
                        }
                    }
                    
                }
                
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                try{
                    con.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            } 
    }//GEN-LAST:event_addRentListActionPerformed
    
    
    private void rentSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rentSubmitActionPerformed
        // TODO add your handling code here:
        String cusId = showCusID.getText();
        int row = rentListView.getRowCount();
        Connection con = null;
        Statement stmt = null;
        
        if(cusId.isEmpty()){
            JOptionPane.showMessageDialog(null,"Please select customer");
        }else if(row == 0){
            JOptionPane.showMessageDialog(null,"Please select DVD");
        }else{
            try{
                con = ConnectDB.getConnection();
                stmt = con.createStatement();
                java.util.Date now = new java.util.Date();
                DateFormat dF = new SimpleDateFormat("yyyy-MM-dd");
                String rentDate = dF.format(now); //keep today date
                long msec = now.getTime(); 
                msec += 7*24*60*60 *1000L; //set return date after today to 7 days
                now.setTime(msec);
                String returnDate = dF.format(now);
                int fine=0,i=0;
                int rowCount = rentListView.getRowCount();
                while(rowCount > 0){
                     String dvdId = rentListView.getModel().getValueAt(i,0).toString();
                     String title = rentListView.getModel().getValueAt(i,1).toString();
                     stmt.executeUpdate("INSERT INTO rentlist VALUES('"+dvdId+"','"+cusId+"','"+title+"','"+rentDate+"','"+returnDate+"')");
                     stmt.executeUpdate("UPDATE dvd SET rent_status='Yes' WHERE dvd_id ='"+dvdId+"'");
                     rowCount--;
                     i++;
                }
                //System.out.println("updated"+i);
                model.setRowCount(0);
                showTotal.setText("");
                }catch(Exception e){
                    e.printStackTrace();
            }
        }
        
        
    }//GEN-LAST:event_rentSubmitActionPerformed

    private void deleteAllRentListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteAllRentListActionPerformed
        // TODO add your handling code here:
        if(model.getRowCount() >= 0){
            model.setRowCount(0);
        }else{
            JOptionPane.showMessageDialog(null,"No data !");
        }
    }//GEN-LAST:event_deleteAllRentListActionPerformed
    int rowDel = -1;
    private void deleteRentListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteRentListActionPerformed
        // TODO add your handling code here:
        if(rowDel >= 0){
            model.removeRow(rowDel);
            rowDel= -1;
        }else{
            JOptionPane.showMessageDialog(null,"Please select row");
        }
    }//GEN-LAST:event_deleteRentListActionPerformed

    private void rentListViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rentListViewMouseClicked
        // TODO add your handling code here:
            rowDel = rentListView.getSelectedRow();
            
    }//GEN-LAST:event_rentListViewMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addRentList;
    private javax.swing.JButton deleteAllRentList;
    private javax.swing.JButton deleteRentList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable rentListView;
    private javax.swing.JButton rentSubmit;
    private javax.swing.JButton searchCustomerButton;
    private javax.swing.JButton searchDVDButton;
    private javax.swing.JTextField searchDVDvalue;
    private javax.swing.JTextField searchValue;
    private javax.swing.JButton showAllButton;
    private javax.swing.JTextField showCategory;
    private javax.swing.JTextField showCusID;
    private javax.swing.JTable showCustomer;
    private javax.swing.JTextField showDvdId;
    private javax.swing.JTextField showPrice;
    private javax.swing.JTextField showTiTle;
    private javax.swing.JTextField showTotal;
    // End of variables declaration//GEN-END:variables
}
