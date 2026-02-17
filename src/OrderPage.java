import java.awt.Color;
import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderPage extends javax.swing.JFrame {

    private static final String URL = "jdbc:mysql://localhost:3306/fooddeliveryDB";
    private static final String USER = "root";
    private static final String PASSWORD = "Um@ir@h7402";

    private Connection connection;
    private ArrayList<String> restaurantNames = new ArrayList<>();
    private Map<String, Map<String, Double>> restaurantMenu = new HashMap<>();
    private Map<String, JCheckBox> foodCheckBoxes = new HashMap<>();
    
    public OrderPage() {
        initComponents();
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            loadRestaurants();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Failed to connect to database: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        setComponentsEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        customerIDTextField = new javax.swing.JTextField();
        dateOrderedTextField = new javax.swing.JTextField();
        restaurantComboBox = new javax.swing.JComboBox<>();
        submitButton = new javax.swing.JButton();
        totalAmountTextField = new javax.swing.JTextField();
        foodPanel = new javax.swing.JPanel();
        checkCustomerIDButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 500));
        setSize(new java.awt.Dimension(500, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        customerIDTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerIDTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(customerIDTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 170, -1));

        dateOrderedTextField.setForeground(new java.awt.Color(153, 153, 153));
        dateOrderedTextField.setText("YYYY/MM/DD");
        dateOrderedTextField.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        dateOrderedTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                dateOrderedTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                dateOrderedTextFieldFocusLost(evt);
            }
        });
        dateOrderedTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateOrderedTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(dateOrderedTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, 150, -1));

        restaurantComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restaurantComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(restaurantComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, 170, -1));

        submitButton.setText("Submit Order");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(submitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 360, -1, -1));

        totalAmountTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalAmountTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(totalAmountTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 400, 149, -1));

        foodPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        foodPanel.setLayout(new java.awt.GridLayout(1, 0));
        getContentPane().add(foodPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 250, 53));

        checkCustomerIDButton.setText("Verify");
        checkCustomerIDButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkCustomerIDButtonActionPerformed(evt);
            }
        });
        getContentPane().add(checkCustomerIDButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, -1, -1));

        backButton.setBackground(new java.awt.Color(255, 204, 204));
        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 445, -1, -1));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 27)); // NOI18N
        jLabel1.setText("FOOD DELIVERY SYSTEM");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel3.setText("Enter your ID:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, -1));

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel4.setText("<html>Select your preferred<br>restaurant:</html>");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 190, -1));

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel5.setText("Select your food:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, -1, -1));

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel6.setText("Input date ordered:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, -1, -1));

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel7.setText("Total Amount:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loadRestaurants() throws SQLException {
        String query = "SELECT DISTINCT restaurantName FROM restaurant";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            String restaurantName = resultSet.getString("restaurantName");
            restaurantNames.add(restaurantName);
            restaurantComboBox.addItem(restaurantName);
            loadRestaurantMenu(restaurantName);
        }
        resultSet.close();
        statement.close();
    }
    
    private void loadRestaurantMenu(String restaurantName) throws SQLException {
        Map<String, Double> menu = new HashMap<>();
        String query = "SELECT food1, price1, food2, price2, food3, price3 FROM restaurant WHERE restaurantName = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, restaurantName);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            String food1 = resultSet.getString("food1");
            double price1 = resultSet.getDouble("price1");
            String food2 = resultSet.getString("food2");
            double price2 = resultSet.getDouble("price2");
            String food3 = resultSet.getString("food3");
            double price3 = resultSet.getDouble("price3");

            menu.put(food1, price1);
            menu.put(food2, price2);
            menu.put(food3, price3);
        }
        resultSet.close();
        statement.close();
        restaurantMenu.put(restaurantName, menu);
    }
    
    private void customerIDTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerIDTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerIDTextFieldActionPerformed

    private void restaurantComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restaurantComboBoxActionPerformed
        // Get the selected restaurant
        String selectedRestaurant = (String) restaurantComboBox.getSelectedItem();

        if (selectedRestaurant != null) {
            foodPanel.removeAll();
            Map<String, Double> menu = restaurantMenu.get(selectedRestaurant);
            if (menu != null) {
                for (String food : menu.keySet()) {
                    JCheckBox checkBox = new JCheckBox(food);
                    foodCheckBoxes.put(food, checkBox);
                    foodPanel.add(checkBox);
                }
                foodPanel.revalidate();
                foodPanel.repaint();
            }
        }
    }//GEN-LAST:event_restaurantComboBoxActionPerformed

    private void dateOrderedTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateOrderedTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateOrderedTextFieldActionPerformed

    private void totalAmountTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalAmountTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalAmountTextFieldActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        try {
            int customerID = Integer.parseInt(customerIDTextField.getText());
            if (!isCustomerExists(customerID)) {
                JOptionPane.showMessageDialog(this, "Customer ID does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String restaurantName = (String) restaurantComboBox.getSelectedItem();
            ArrayList<String> foodOrdered = new ArrayList<>();
            for (Map.Entry<String, JCheckBox> entry : foodCheckBoxes.entrySet()) {
                if (entry.getValue().isSelected()) {
                    foodOrdered.add(entry.getKey());
                }
            }
            String dateOrdered = dateOrderedTextField.getText();

            double totalAmount = calculateTotalAmount(restaurantName, foodOrdered);
            totalAmountTextField.setText(String.format("RM %.2f", totalAmount));

            Order order = new Order(0, customerID, restaurantName, foodOrdered.toString(), dateOrdered, totalAmount);
            saveOrder(order);

            JOptionPane.showMessageDialog(this, "Order placed successfully! Total amount: RM" + totalAmount, "Success", JOptionPane.INFORMATION_MESSAGE);
            clearFields();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Failed to place order: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    private void dateOrderedTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dateOrderedTextFieldFocusGained
        if (dateOrderedTextField.getText().equals("YYYY/MM/DD")){
            dateOrderedTextField.setText("");
            dateOrderedTextField.setForeground(new Color(102,102,102));
        }
    }//GEN-LAST:event_dateOrderedTextFieldFocusGained

    private void dateOrderedTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dateOrderedTextFieldFocusLost
        if (dateOrderedTextField.getText().equals("")) {
            dateOrderedTextField.setText("YYYY/MM/DD");
            dateOrderedTextField.setForeground(new Color(102,102,102));
        }
    }//GEN-LAST:event_dateOrderedTextFieldFocusLost

    private void checkCustomerIDButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkCustomerIDButtonActionPerformed
        try {
            int customerID = Integer.parseInt(customerIDTextField.getText());
            if (isCustomerExists(customerID)) {
                JOptionPane.showMessageDialog(this, "Verified, you may place order now", "Success", JOptionPane.INFORMATION_MESSAGE);
                setComponentsEnabled(true);
            } else {
                JOptionPane.showMessageDialog(this, "Customer ID does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
                setComponentsEnabled(false);
                navigateToHomePage();
            }
        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(this, "Invalid input: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            setComponentsEnabled(false);
            navigateToHomePage();
        }
    }//GEN-LAST:event_checkCustomerIDButtonActionPerformed

    private void navigateToHomePage() {
        this.dispose();
        HomePage registerPage = new HomePage();
        registerPage.setVisible(true);
    }
    
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        this.dispose();
        HomePage registerPage = new HomePage();
        registerPage.setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    private boolean isCustomerExists(int customerID) throws SQLException {
        String query = "SELECT COUNT(*) FROM customer WHERE customerID = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, customerID);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        int count = resultSet.getInt(1);
        resultSet.close();
        statement.close();
        return count > 0;
    }

    private double calculateTotalAmount(String restaurantName, List<String> foodOrdered) {
        double total = 0.0;
        for (String food : foodOrdered) {
            total += restaurantMenu.get(restaurantName).getOrDefault(food, 0.0);
        }
        return total;
    }

    private void saveOrder(Order order) throws SQLException {
        String query = "INSERT INTO orders (customerID, restaurantName, foodOrdered, dateOrdered, totalAmount) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, order.getCustomerID());
        statement.setString(2, order.getRestaurantName());
        statement.setString(3, order.getFoodOrdered());
        statement.setString(4, order.getDateOrdered());
        statement.setDouble(5, order.getTotalAmount());
        statement.executeUpdate();
        statement.close();
    }

    private void clearFields() {
        customerIDTextField.setText("");
        restaurantComboBox.setSelectedIndex(0);
        foodPanel.removeAll();
        dateOrderedTextField.setText("");
        totalAmountTextField.setText("");
        setComponentsEnabled(false);
    }
    
    private void setComponentsEnabled(boolean enabled) {
        restaurantComboBox.setEnabled(enabled);
        foodPanel.setEnabled(enabled);
        dateOrderedTextField.setEnabled(enabled);
        submitButton.setEnabled(enabled);
        totalAmountTextField.setEnabled(enabled);
    }
    
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
            java.util.logging.Logger.getLogger(OrderPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new OrderPage().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton checkCustomerIDButton;
    private javax.swing.JTextField customerIDTextField;
    private javax.swing.JTextField dateOrderedTextField;
    private javax.swing.JPanel foodPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JComboBox<String> restaurantComboBox;
    private javax.swing.JButton submitButton;
    private javax.swing.JTextField totalAmountTextField;
    // End of variables declaration//GEN-END:variables
}