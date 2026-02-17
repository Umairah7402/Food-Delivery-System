import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class RestaurantPage extends javax.swing.JFrame {

    private static final String URL = "jdbc:mysql://localhost:3306/fooddeliveryDB";
    private static final String USER = "root";
    private static final String PASSWORD = "Um@ir@h7402";

    private Connection connection;
    private ArrayList<Restaurant> restaurantList = new ArrayList<>();
    
    public RestaurantPage() {
        initComponents();
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);        
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Failed to connect to database: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        restaurantEmailTF.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent evt) {
                if (!restaurantEmailTF.getText().contains("@")) {
                    restaurantEmailTF.setText(restaurantEmailTF.getText() + "@gmail.com");
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
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        restaurantIDTF = new javax.swing.JTextField();
        restaurantNameTF = new javax.swing.JTextField();
        restaurantAddressTF = new javax.swing.JTextField();
        restaurantEmailTF = new javax.swing.JTextField();
        foodName1TF = new javax.swing.JTextField();
        foodPrice1TF = new javax.swing.JTextField();
        foodName2TF = new javax.swing.JTextField();
        foodPrice2TF = new javax.swing.JTextField();
        foodName3TF = new javax.swing.JTextField();
        foodPrice3TF = new javax.swing.JTextField();
        submitButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 500));
        setSize(new java.awt.Dimension(500, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 27)); // NOI18N
        jLabel1.setText("FOOD DELIVERY SYSTEM");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel2.setText("RESTAURANT REGISTRATION PAGE");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, -1, -1));

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel3.setText("Enter Restaurant ID (6 digits):");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel4.setText("Enter Restaurant Name:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel5.setText("Enter Restaurant Address:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel6.setText("Enter Restaurant Email:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel7.setText("Enter Food 1 & Price:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, -1));

        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel8.setText("Enter Food 2 & Price:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, -1, -1));

        jLabel9.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel9.setText("Enter Food 3 & Price:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, -1, -1));

        restaurantIDTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restaurantIDTFActionPerformed(evt);
            }
        });
        getContentPane().add(restaurantIDTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 200, -1));

        restaurantNameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restaurantNameTFActionPerformed(evt);
            }
        });
        getContentPane().add(restaurantNameTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, 200, -1));

        restaurantAddressTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restaurantAddressTFActionPerformed(evt);
            }
        });
        getContentPane().add(restaurantAddressTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 200, -1));

        restaurantEmailTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restaurantEmailTFActionPerformed(evt);
            }
        });
        getContentPane().add(restaurantEmailTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 200, -1));

        foodName1TF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                foodName1TFActionPerformed(evt);
            }
        });
        getContentPane().add(foodName1TF, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 140, -1));

        foodPrice1TF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                foodPrice1TFActionPerformed(evt);
            }
        });
        getContentPane().add(foodPrice1TF, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 300, 87, -1));

        foodName2TF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                foodName2TFActionPerformed(evt);
            }
        });
        getContentPane().add(foodName2TF, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 340, 140, -1));

        foodPrice2TF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                foodPrice2TFActionPerformed(evt);
            }
        });
        getContentPane().add(foodPrice2TF, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 340, 87, -1));

        foodName3TF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                foodName3TFActionPerformed(evt);
            }
        });
        getContentPane().add(foodName3TF, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 380, 140, -1));

        foodPrice3TF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                foodPrice3TFActionPerformed(evt);
            }
        });
        getContentPane().add(foodPrice3TF, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 380, 87, -1));

        submitButton.setBackground(new java.awt.Color(255, 204, 204));
        submitButton.setText("SUBMIT");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(submitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 420, -1, -1));

        backButton.setBackground(new java.awt.Color(255, 204, 204));
        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background.png"))); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void foodPrice2TFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_foodPrice2TFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_foodPrice2TFActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        try {
            int id = Integer.parseInt(restaurantIDTF.getText());
            if (String.valueOf(id).length() != 6) {
                throw new NumberFormatException("Restaurant ID must be exactly 6 digits.");
            }
            if (!isRestaurantIDUnique(id)) {
                throw new NumberFormatException("Restaurant ID already exists. Please enter a unique ID.");
            }
            String name = restaurantNameTF.getText();
            String address = restaurantAddressTF.getText();
            String email = restaurantEmailTF.getText();
            String food1 = foodName1TF.getText();
            double price1 = Double.parseDouble(foodPrice1TF.getText());
            String food2 = foodName2TF.getText();
            double price2 = Double.parseDouble(foodPrice2TF.getText());
            String food3 = foodName3TF.getText();
            double price3 = Double.parseDouble(foodPrice3TF.getText());

            Restaurant rest = new Restaurant(id, name, address, email, food1, price1, food2, price2, food3, price3);
            TestDB.createRestaurant(connection, rest);
            restaurantList.add(rest); // Add the new restaurant to the list

            JOptionPane.showMessageDialog(this, "Restaurant registered successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            
            clearFields();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Failed to register restaurant: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    private void clearFields() {
        restaurantIDTF.setText("");
        restaurantNameTF.setText("");
        restaurantAddressTF.setText("");
        restaurantEmailTF.setText("");
        foodName1TF.setText("");
        foodPrice1TF.setText("");
        foodName2TF.setText("");
        foodPrice2TF.setText("");
        foodName3TF.setText("");
        foodPrice3TF.setText("");
    }
    
    private void loadRestaurantsFromDatabase() {
        try {
            restaurantList.clear(); // Clear the existing list
            String query = "SELECT * FROM restaurant";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("restaurantID");
                String name = resultSet.getString("restaurantName");
                String address = resultSet.getString("restaurantAddress");
                String email = resultSet.getString("restaurantEmail");
                String food1 = resultSet.getString("food1");
                double price1 = resultSet.getDouble("price1");
                String food2 = resultSet.getString("food2");
                double price2 = resultSet.getDouble("price2");
                String food3 = resultSet.getString("food3");
                double price3 = resultSet.getDouble("price3");

                Restaurant rest = new Restaurant(id, name, address, email, food1, price1, food2, price2, food3, price3);
                restaurantList.add(rest);
            }

            statement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Failed to retrieve restaurants: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void foodName2TFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_foodName2TFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_foodName2TFActionPerformed

    private void restaurantEmailTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restaurantEmailTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_restaurantEmailTFActionPerformed

    private void foodPrice3TFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_foodPrice3TFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_foodPrice3TFActionPerformed

    private void restaurantIDTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restaurantIDTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_restaurantIDTFActionPerformed

    private void restaurantNameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restaurantNameTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_restaurantNameTFActionPerformed

    private void restaurantAddressTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restaurantAddressTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_restaurantAddressTFActionPerformed

    private void foodName1TFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_foodName1TFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_foodName1TFActionPerformed

    private void foodPrice1TFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_foodPrice1TFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_foodPrice1TFActionPerformed

    private void foodName3TFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_foodName3TFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_foodName3TFActionPerformed

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
            java.util.logging.Logger.getLogger(RestaurantPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RestaurantPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RestaurantPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RestaurantPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new RestaurantPage().setVisible(true));
    }

    private boolean isRestaurantIDUnique(int id) throws SQLException {
        String query = "SELECT COUNT(*) FROM restaurant WHERE restaurantID = ?";
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
    private javax.swing.JTextField foodName1TF;
    private javax.swing.JTextField foodName2TF;
    private javax.swing.JTextField foodName3TF;
    private javax.swing.JTextField foodPrice1TF;
    private javax.swing.JTextField foodPrice2TF;
    private javax.swing.JTextField foodPrice3TF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField restaurantAddressTF;
    private javax.swing.JTextField restaurantEmailTF;
    private javax.swing.JTextField restaurantIDTF;
    private javax.swing.JTextField restaurantNameTF;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables
}