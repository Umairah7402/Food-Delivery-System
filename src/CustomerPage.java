import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class CustomerPage extends javax.swing.JFrame {

    private static final String URL = "jdbc:mysql://localhost:3306/fooddeliveryDB";
    private static final String USER = "root";
    private static final String PASSWORD = "Um@ir@h7402";

    private Connection connection;
    private ArrayList<Customer> customerList = new ArrayList<>();
    
    public CustomerPage() {
        initComponents();
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Failed to connect to database: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        customerEmailTF.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent evt) {
                if (!customerEmailTF.getText().contains("@")) {
                    customerEmailTF.setText(customerEmailTF.getText() + "@gmail.com");
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        customerIDTF = new javax.swing.JTextField();
        customerNameTF = new javax.swing.JTextField();
        customerHomeAddressTF = new javax.swing.JTextField();
        customerEmailTF = new javax.swing.JTextField();
        submitButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 500));
        setSize(new java.awt.Dimension(500, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 27)); // NOI18N
        jLabel1.setText("FOOD DELIVERY SYSTEM");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel2.setText("CUSTOMER REGISTRATION PAGE");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, -1, -1));

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel3.setText("Enter Customer ID (6 digits):");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel4.setText("Enter Customer Name:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel5.setText("Enter Customer Home Address:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel6.setText("Enter Customer Email:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        customerIDTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerIDTFActionPerformed(evt);
            }
        });
        getContentPane().add(customerIDTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 220, -1));

        customerNameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerNameTFActionPerformed(evt);
            }
        });
        getContentPane().add(customerNameTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, 220, -1));

        customerHomeAddressTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerHomeAddressTFActionPerformed(evt);
            }
        });
        getContentPane().add(customerHomeAddressTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, 220, -1));

        customerEmailTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerEmailTFActionPerformed(evt);
            }
        });
        getContentPane().add(customerEmailTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 320, 224, -1));

        submitButton.setBackground(new java.awt.Color(255, 204, 204));
        submitButton.setText("SUBMIT");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(submitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 390, -1, -1));

        backButton.setBackground(new java.awt.Color(255, 204, 204));
        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background.png"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void customerNameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerNameTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerNameTFActionPerformed

    private void customerHomeAddressTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerHomeAddressTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerHomeAddressTFActionPerformed

    private void customerIDTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerIDTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerIDTFActionPerformed

    private void customerEmailTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerEmailTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerEmailTFActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        try {
            String idStr = customerIDTF.getText();
            if (idStr.length() != 6) {
                throw new NumberFormatException("Customer ID must be 6 digits long.");
            }

            int id = Integer.parseInt(idStr);

            if (isCustomerIDUnique(id)) {
                String name = customerNameTF.getText();
                String address = customerHomeAddressTF.getText();
                String email = customerEmailTF.getText();

                Customer cust = new Customer(id, name, address, email);
                TestDB.createCustomer(connection, cust);
                TestDB.customerList.add(cust);

                JOptionPane.showMessageDialog(this, "Customer registered successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                
                clearFields();
                
            } else {
                JOptionPane.showMessageDialog(this, "Customer ID already exists. Please enter a unique ID.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Failed to register customer: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    private void clearFields() {
        customerIDTF.setText("");
        customerNameTF.setText("");
        customerHomeAddressTF.setText("");
        customerEmailTF.setText("");
    }
    
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        this.dispose();
        HomePage registerPage = new HomePage();
        registerPage.setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

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
            java.util.logging.Logger.getLogger(CustomerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new CustomerPage().setVisible(true));
    }

    private boolean isCustomerIDUnique(int id) throws SQLException {
        String query = "SELECT COUNT(*) FROM customer WHERE customerID = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        int count = resultSet.getInt(1);
        statement.close();
        return count == 0;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JTextField customerEmailTF;
    private javax.swing.JTextField customerHomeAddressTF;
    private javax.swing.JTextField customerIDTF;
    private javax.swing.JTextField customerNameTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables
}