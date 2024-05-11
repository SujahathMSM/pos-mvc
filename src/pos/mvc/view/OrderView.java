/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pos.mvc.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pos.mvc.controller.CustomerController;
import pos.mvc.controller.ItemController;
import pos.mvc.controller.OrderController;
import pos.mvc.model.CustomerModel;
import pos.mvc.model.ItemModel;
import pos.mvc.model.OrderDetailModel;

/**
 *
 * @author sujah
 */
public class OrderView extends javax.swing.JFrame {

    private CustomerController customerController;
    private ItemController itemController;
    private OrderController orderController;
    ArrayList<OrderDetailModel> orderDetailModels = new ArrayList<>();

    /**
     * Creates new form OrderView
     */
    public OrderView() {
        initComponents();
        orderController = new OrderController();
        itemController = new ItemController();
        customerController = new CustomerController();
        loadTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        basepanel = new javax.swing.JPanel();
        headrpanel = new javax.swing.JPanel();
        headerlabel = new javax.swing.JLabel();
        formpanel = new javax.swing.JPanel();
        lblOrderID = new javax.swing.JLabel();
        txtOrderID = new javax.swing.JTextField();
        lblCustomerID = new javax.swing.JLabel();
        txtCustomerID = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemTable = new javax.swing.JTable();
        btnSearchCustomer = new javax.swing.JButton();
        lblCustomer = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblItemID = new javax.swing.JLabel();
        txtItemID = new javax.swing.JTextField();
        lblQty = new javax.swing.JLabel();
        lblDiscount = new javax.swing.JLabel();
        txtDiscount = new javax.swing.JTextField();
        txtQty = new javax.swing.JTextField();
        btnSearchItem = new javax.swing.JButton();
        lblItem = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnPlaceOrder = new javax.swing.JButton();
        tablepanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        headerlabel.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        headerlabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerlabel.setText("Order");

        javax.swing.GroupLayout headrpanelLayout = new javax.swing.GroupLayout(headrpanel);
        headrpanel.setLayout(headrpanelLayout);
        headrpanelLayout.setHorizontalGroup(
            headrpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headrpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headerlabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        headrpanelLayout.setVerticalGroup(
            headrpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headrpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headerlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        lblOrderID.setText("Order ID");
        lblOrderID.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lblCustomerID.setText("Customer ID");
        lblCustomerID.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        txtCustomerID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustomerIDActionPerformed(evt);
            }
        });

        itemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        itemTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemTableMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                itemTableMouseExited(evt);
            }
        });
        jScrollPane1.setViewportView(itemTable);

        btnSearchCustomer.setText("Search");
        btnSearchCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchCustomerActionPerformed(evt);
            }
        });

        lblCustomer.setFont(new java.awt.Font("Candara", 2, 12)); // NOI18N
        lblCustomer.setText("---Customer Details Will be Displayed Here---");

        lblItemID.setText("Item ID");
        lblItemID.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lblQty.setText("Qty");
        lblQty.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lblDiscount.setText("Discount");
        lblDiscount.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        btnSearchItem.setText("Search");
        btnSearchItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchItemActionPerformed(evt);
            }
        });

        lblItem.setFont(new java.awt.Font("Candara", 2, 12)); // NOI18N
        lblItem.setText("---Item Details Will be Displayed Here---");

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnPlaceOrder.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPlaceOrder.setText("Place Order");

        javax.swing.GroupLayout formpanelLayout = new javax.swing.GroupLayout(formpanel);
        formpanel.setLayout(formpanelLayout);
        formpanelLayout.setHorizontalGroup(
            formpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(formpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(formpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formpanelLayout.createSequentialGroup()
                        .addGroup(formpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(formpanelLayout.createSequentialGroup()
                                .addGroup(formpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(formpanelLayout.createSequentialGroup()
                                        .addGroup(formpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblQty, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblItemID, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(formpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(formpanelLayout.createSequentialGroup()
                                                .addComponent(txtDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(formpanelLayout.createSequentialGroup()
                                                .addGroup(formpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(txtItemID, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                                                    .addComponent(txtQty))
                                                .addGap(18, 18, 18)
                                                .addComponent(btnSearchItem, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12)
                                                .addComponent(lblItem, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(formpanelLayout.createSequentialGroup()
                                        .addGroup(formpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblOrderID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblCustomerID, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(formpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtOrderID, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                            .addComponent(txtCustomerID))
                                        .addGap(18, 18, 18)
                                        .addComponent(btnSearchCustomer)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 198, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formpanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnPlaceOrder)))
                        .addContainerGap())
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        formpanelLayout.setVerticalGroup(
            formpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formpanelLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(formpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOrderID)
                    .addComponent(txtOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(formpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCustomerID)
                    .addComponent(btnSearchCustomer)
                    .addComponent(txtCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(formpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtItemID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSearchItem)
                        .addComponent(lblItem, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblItemID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(formpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblQty))
                .addGap(10, 10, 10)
                .addGroup(formpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDiscount)
                    .addComponent(btnAdd))
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnPlaceOrder)
                .addContainerGap())
        );

        javax.swing.GroupLayout tablepanelLayout = new javax.swing.GroupLayout(tablepanel);
        tablepanel.setLayout(tablepanelLayout);
        tablepanelLayout.setHorizontalGroup(
            tablepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        tablepanelLayout.setVerticalGroup(
            tablepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 329, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout basepanelLayout = new javax.swing.GroupLayout(basepanel);
        basepanel.setLayout(basepanelLayout);
        basepanelLayout.setHorizontalGroup(
            basepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headrpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(basepanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(basepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(basepanelLayout.createSequentialGroup()
                        .addComponent(tablepanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(formpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        basepanelLayout.setVerticalGroup(
            basepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basepanelLayout.createSequentialGroup()
                .addComponent(headrpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(formpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tablepanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(basepanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(basepanel, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 329, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemTableMouseClicked
//        ViewItem();
    }//GEN-LAST:event_itemTableMouseClicked

    private void itemTableMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemTableMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_itemTableMouseExited

    private void btnSearchCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchCustomerActionPerformed
        // TODO add your handling code here:
        searchCustomer();
    }//GEN-LAST:event_btnSearchCustomerActionPerformed

    private void txtCustomerIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustomerIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustomerIDActionPerformed

    private void btnSearchItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchItemActionPerformed
        // TODO add your handling code here:
        searchItem();
    }//GEN-LAST:event_btnSearchItemActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        addToTable();
    }//GEN-LAST:event_btnAddActionPerformed

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
            java.util.logging.Logger.getLogger(OrderView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel basepanel;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnPlaceOrder;
    private javax.swing.JButton btnSearchCustomer;
    private javax.swing.JButton btnSearchItem;
    private javax.swing.JPanel formpanel;
    private javax.swing.JLabel headerlabel;
    private javax.swing.JPanel headrpanel;
    private javax.swing.JTable itemTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCustomer;
    private javax.swing.JLabel lblCustomerID;
    private javax.swing.JLabel lblDiscount;
    private javax.swing.JLabel lblItem;
    private javax.swing.JLabel lblItemID;
    private javax.swing.JLabel lblOrderID;
    private javax.swing.JLabel lblQty;
    private javax.swing.JPanel tablepanel;
    private javax.swing.JTextField txtCustomerID;
    private javax.swing.JTextField txtDiscount;
    private javax.swing.JTextField txtItemID;
    private javax.swing.JTextField txtOrderID;
    private javax.swing.JTextField txtQty;
    // End of variables declaration//GEN-END:variables

    private void searchCustomer() {
        try {
            String custID = txtCustomerID.getText();
            CustomerModel customer = customerController.SearchCustomer(custID);

            if (customer != null) {
                lblCustomer.setText(customer.getName() + ":" + customer.getCity());
            } else {
                lblCustomer.setText("Customer not found");
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderView.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void searchItem() {
        try {
            String itemID = txtItemID.getText();
            ItemModel item = itemController.viewItem(itemID);

            if (item != null) {
                lblItem.setText(item.getDesc() + "," + item.getUnitPrice() + "," + item.getQuantity());
            } else {
                lblItem.setText("Item not found");
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderView.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void addToTable() {
        OrderDetailModel odm = new OrderDetailModel(txtItemID.getText(), Integer.valueOf(txtQty.getText()), Double.valueOf(txtDiscount.getText()));
        orderDetailModels.add(odm);

        DefaultTableModel dtm = (DefaultTableModel) itemTable.getModel();

        Object[] rowObj = {odm.getItemCode(), odm.getQty(), odm.getDiscount()};
        dtm.addRow(rowObj);

        clearItems();
    }

    private void loadTable() {
        String[] columns = {"Item Code", "Quantity", "Discount"};
        DefaultTableModel dtm = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
            }

        };
        itemTable.setModel(dtm);
    }

    private void clearItems() {
        txtItemID.setText("");
        txtQty.setText("");
        txtDiscount.setText("");
        lblItem.setText("");
    }
}
