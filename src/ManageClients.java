import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ManageClients extends javax.swing.JFrame {

    private static final String URL = "jdbc:mysql://localhost:3306/fooddeliveryDB";
    private static final String USER = "root";
    private static final String PASSWORD = "Um@ir@h7402";

    private Connection connection;

    public ManageClients() {
        initComponents();
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Failed to connect to database: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchButton = new javax.swing.JButton();
        displayButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 500));
        setSize(new java.awt.Dimension(500, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchButton.setBackground(new java.awt.Color(255, 204, 204));
        searchButton.setText("SEARCH");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        getContentPane().add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 130, 90));

        displayButton.setBackground(new java.awt.Color(255, 204, 204));
        displayButton.setText("DISPLAY");
        displayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayButtonActionPerformed(evt);
            }
        });
        getContentPane().add(displayButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 130, 90));

        deleteButton.setBackground(new java.awt.Color(255, 204, 204));
        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 130, 90));

        editButton.setBackground(new java.awt.Color(255, 204, 204));
        editButton.setText("EDIT");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });
        getContentPane().add(editButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, 130, 90));

        backButton.setBackground(new java.awt.Color(255, 204, 204));
        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 455, -1, -1));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 27)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("FOOD DELIVERY SYSTEM");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        jLabel3.setText("<html><div style='text-align: center;'>CLICK HERE TO SEARCH<br>CUSTOMER/RESTAURANT DETAILS</div></html>");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        jLabel4.setText("<html><div style='text-align: center;'>CLICK HERE TO DISPLAY ALL<br>EXISTING CUSTOMER/RESTAURANT</div></html>");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, -1, -1));

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        jLabel5.setText("<html><div style='text-align: center;'>CLICK HERE TO DELETE<br>SPECIFIC CUSTOMER/RESTAURANT</div></html>");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, -1));

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        jLabel6.setText("<html><div style='text-align: center;'>CLICK HERE TO EDIT<br>CUSTOMER/RESTAURANT DETAILS</div></html>");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 380, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 500));
        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 300, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // Prompt user to choose between Customer and Restaurant
        String[] options = {"Customer", "Restaurant"};
        int choice = JOptionPane.showOptionDialog(this, "Search for:", "Select Client Type",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        if (choice == JOptionPane.CLOSED_OPTION) {
            return;
        }

        String clientType = options[choice];
        String idStr = JOptionPane.showInputDialog(this, "Enter the ID of the " + clientType + ":");

        if (idStr == null || idStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "ID cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int id = Integer.parseInt(idStr);
            if (clientType.equals("Customer")) {
                searchCustomer(id);
            } else if (clientType.equals("Restaurant")) {
                searchRestaurant(id);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid selection.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid ID format.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void displayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayButtonActionPerformed
        String[] options = {"Customer", "Restaurant"};
        int choice = JOptionPane.showOptionDialog(this, "Display:", "Select Client Type",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        if (choice == JOptionPane.CLOSED_OPTION) {
            return;
        }

        String clientType = options[choice];
        String[] sortOptions = {"ID", "Name"};
        int sortChoice = JOptionPane.showOptionDialog(this, "Sort by:", "Select Sort Option",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, sortOptions, sortOptions[0]);

        if (sortChoice == JOptionPane.CLOSED_OPTION) {
            return;
        }

        String sortBy = sortOptions[sortChoice];
        if (clientType.equals("Customer")) {
            displayCustomers(sortBy);
        } else if (clientType.equals("Restaurant")) {
            displayRestaurants(sortBy);
        } else {
            JOptionPane.showMessageDialog(this, "Invalid selection.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_displayButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        String[] options = {"Customer", "Restaurant"};
        int choice = JOptionPane.showOptionDialog(this, "Delete:", "Select Client Type",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        if (choice == JOptionPane.CLOSED_OPTION) {
            return;
        }

        String clientType = options[choice];
        String idStr = JOptionPane.showInputDialog(this, "Enter the ID of the " + clientType + " to delete:");

        if (idStr == null || idStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "ID cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int id = Integer.parseInt(idStr);
            int confirm = JOptionPane.showConfirmDialog(this,
                    "Are you sure you want to delete this " + clientType + " with ID " + id + "?",
                    "Confirm Deletion", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                if (clientType.equals("Customer")) {
                    deleteCustomer(id);
                } else if (clientType.equals("Restaurant")) {
                    deleteRestaurant(id);
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid selection.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid ID format.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        String[] options = {"Customer", "Restaurant"};
        int choice = JOptionPane.showOptionDialog(this, "Edit:", "Select Client Type",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        if (choice == JOptionPane.CLOSED_OPTION) {
            return;
        }

        String clientType = options[choice];
        String idStr = JOptionPane.showInputDialog(this, "Enter the ID of the " + clientType + " to edit:");

        if (idStr == null || idStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "ID cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int id = Integer.parseInt(idStr);
            if (clientType.equals("Customer")) {
                editCustomer(id);
            } else if (clientType.equals("Restaurant")) {
                editRestaurant(id);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid selection.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid ID format.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        this.dispose();
        HomePage registerPage = new HomePage();
        registerPage.setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    private void searchCustomer(int id) {
        try {
            String query = "SELECT * FROM customer WHERE customerID = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("customerName");
                String address = resultSet.getString("customerHomeAddress");
                String email = resultSet.getString("customerEmail");

                // Fetch past orders
                String ordersQuery = "SELECT * FROM orders WHERE customerID = ?";
                PreparedStatement ordersStatement = connection.prepareStatement(ordersQuery);
                ordersStatement.setInt(1, id);
                ResultSet ordersResultSet = ordersStatement.executeQuery();

                StringBuilder ordersInfo = new StringBuilder();
                double totalAmount = 0;
                while (ordersResultSet.next()) {
                    String restaurantName = ordersResultSet.getString("restaurantName");
                    String foodOrdered = ordersResultSet.getString("foodOrdered");
                    String dateOrdered = ordersResultSet.getString("dateOrdered");
                    double amount = ordersResultSet.getDouble("totalAmount");
                    totalAmount += amount;
                    ordersInfo.append(String.format("Restaurant: %s, Foods: %s, Date: %s, Amount: RM %.2f\n", restaurantName, foodOrdered, dateOrdered, amount));
                }
                ordersResultSet.close();
                ordersStatement.close();

                String message = String.format("Name: %s\nAddress: %s\nEmail: %s\n\nPast Orders:\n%sTotal Amount Paid: RM %.2f",
                        name, address, email, ordersInfo.toString(), totalAmount);
                JOptionPane.showMessageDialog(this, message, "Customer Details", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Customer not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error fetching customer details: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void searchRestaurant(int id) {
        try {
            String query = "SELECT * FROM restaurant WHERE restaurantID = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("restaurantName");
                String email = resultSet.getString("restaurantEmail");

                // Fetch menu
                String foodQuery = "SELECT food1, price1, food2, price2, food3, price3 FROM restaurant WHERE restaurantID = ?";
                PreparedStatement foodStatement = connection.prepareStatement(foodQuery);
                foodStatement.setInt(1, id);
                ResultSet foodResultSet = foodStatement.executeQuery();

                StringBuilder menuInfo = new StringBuilder();
                if (foodResultSet.next()) {
                    appendFood(menuInfo, "Food1", foodResultSet.getString("food1"), foodResultSet.getDouble("price1"));
                    appendFood(menuInfo, "Food2", foodResultSet.getString("food2"), foodResultSet.getDouble("price2"));
                    appendFood(menuInfo, "Food3", foodResultSet.getString("food3"), foodResultSet.getDouble("price3"));
                }
                foodResultSet.close();
                foodStatement.close();

                String message = String.format("Name: %s\nEmail: %s\n\nMenu:\n%s", name, email, menuInfo.toString());
                JOptionPane.showMessageDialog(this, message, "Restaurant Details", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Restaurant not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error fetching restaurant details: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void displayCustomers(String sortBy) {
        try {
        String query = "SELECT * FROM customer";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        List<Customer> customers = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("customerID");
            String name = resultSet.getString("customerName");
            String address = resultSet.getString("customerHomeAddress");
            String email = resultSet.getString("customerEmail");
            customers.add(new Customer(id, name, address, email));
        }

        if (sortBy.equals("Name")) {
            Collections.sort(customers, Comparator.comparing(Customer::getName));
        } else if (sortBy.equals("ID")) {
            Collections.sort(customers, Comparator.comparingInt(Customer::getId));
        }

        StringBuilder customersInfo = new StringBuilder();
        for (Customer customer : customers) {
            customersInfo.append(customer.toString()).append("\n");
        }

        if (customersInfo.length() == 0) {
            customersInfo.append("No customers found.");
        }

        JOptionPane.showMessageDialog(this, customersInfo.toString(), "Customer List", JOptionPane.INFORMATION_MESSAGE);
        resultSet.close();
        statement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error fetching customer list: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void displayRestaurants(String sortBy) {
        try {
        String query = "SELECT * FROM restaurant";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        List<Restaurant> restaurants = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("restaurantID");
            String name = resultSet.getString("restaurantName");
            String address = resultSet.getString("restaurantAddress");
            String email = resultSet.getString("restaurantEmail");
            restaurants.add(new Restaurant(id, name, address, email));
        }

        if (sortBy.equals("Name")) {
            Collections.sort(restaurants, Comparator.comparing(Restaurant::getName));
        } else if (sortBy.equals("ID")) {
            Collections.sort(restaurants, Comparator.comparingInt(Restaurant::getId));
        }

        StringBuilder restaurantsInfo = new StringBuilder();
        for (Restaurant restaurant : restaurants) {
            restaurantsInfo.append(restaurant.toString()).append("\n");
        }

        if (restaurantsInfo.length() == 0) {
            restaurantsInfo.append("No restaurants found.");
        }

        JOptionPane.showMessageDialog(this, restaurantsInfo.toString(), "Restaurant List", JOptionPane.INFORMATION_MESSAGE);
        resultSet.close();
        statement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error fetching restaurant list: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteCustomer(int id) {
        try {
            String query = "DELETE FROM customer WHERE customerID = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Customer deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Customer not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            statement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error deleting customer: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteRestaurant(int id) {
        try {
            String query = "DELETE FROM restaurant WHERE restaurantID = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Restaurant deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Restaurant not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            statement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error deleting restaurant: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editCustomer(int id) {
        try {
            String query = "SELECT * FROM customer WHERE customerID = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("customerName");
                String address = resultSet.getString("customerHomeAddress");
                String email = resultSet.getString("customerEmail");

                JTextField nameField = new JTextField(name);
                JTextField addressField = new JTextField(address);
                JTextField emailField = new JTextField(email);

                Object[] message = {
                    "Name:", nameField,
                    "Address:", addressField,
                    "Email:", emailField
                };

                int option = JOptionPane.showConfirmDialog(this, message, "Edit Customer", JOptionPane.OK_CANCEL_OPTION);

                if (option == JOptionPane.OK_OPTION) {
                    String newName = nameField.getText();
                    String newAddress = addressField.getText();
                    String newEmail = emailField.getText();

                    String updateQuery = "UPDATE customer SET customerName = ?, customerHomeAddress = ?, customerEmail = ? WHERE customerID = ?";
                    PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
                    updateStatement.setString(1, newName);
                    updateStatement.setString(2, newAddress);
                    updateStatement.setString(3, newEmail);
                    updateStatement.setInt(4, id);
                    updateStatement.executeUpdate();

                    JOptionPane.showMessageDialog(this, "Customer updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    updateStatement.close();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Customer not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error updating customer: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editRestaurant(int id) {
        try {
            String query = "SELECT * FROM restaurant WHERE restaurantID = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("restaurantName");
                String address = resultSet.getString("restaurantAddress");
                String email = resultSet.getString("restaurantEmail");
                String food1 = resultSet.getString("food1");
                double price1 = resultSet.getDouble("price1");
                String food2 = resultSet.getString("food2");
                double price2 = resultSet.getDouble("price2");
                String food3 = resultSet.getString("food3");
                double price3 = resultSet.getDouble("price3");

                JTextField nameField = new JTextField(name);
                JTextField addressField = new JTextField(address);
                JTextField emailField = new JTextField(email);
                JTextField food1Field = new JTextField(food1);
                JTextField price1Field = new JTextField(String.valueOf(price1));
                JTextField food2Field = new JTextField(food2);
                JTextField price2Field = new JTextField(String.valueOf(price2));
                JTextField food3Field = new JTextField(food3);
                JTextField price3Field = new JTextField(String.valueOf(price3));

                Object[] message = {
                    "Name:", nameField,
                    "Address:", addressField,
                    "Email:", emailField,
                    "Food 1:", food1Field,
                    "Price 1:", price1Field,
                    "Food 2:", food2Field,
                    "Price 2:", price2Field,
                    "Food 3:", food3Field,
                    "Price 3:", price3Field
                };

                int option = JOptionPane.showConfirmDialog(this, message, "Edit Restaurant", JOptionPane.OK_CANCEL_OPTION);

                if (option == JOptionPane.OK_OPTION) {
                    String newName = nameField.getText();
                    String newAddress = addressField.getText();
                    String newEmail = emailField.getText();
                    String newFood1 = food1Field.getText();
                    double newPrice1 = Double.parseDouble(price1Field.getText());
                    String newFood2 = food2Field.getText();
                    double newPrice2 = Double.parseDouble(price2Field.getText());
                    String newFood3 = food3Field.getText();
                    double newPrice3 = Double.parseDouble(price3Field.getText());

                    String updateQuery = "UPDATE restaurant SET restaurantName = ?, restaurantAddress = ?, restaurantEmail = ?, food1 = ?, price1 = ?, food2 = ?, price2 = ?, food3 = ?, price3 = ? WHERE restaurantID = ?";
                    PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
                    updateStatement.setString(1, newName);
                    updateStatement.setString(2, newAddress);
                    updateStatement.setString(3, newEmail);
                    updateStatement.setString(4, newFood1);
                    updateStatement.setDouble(5, newPrice1);
                    updateStatement.setString(6, newFood2);
                    updateStatement.setDouble(7, newPrice2);
                    updateStatement.setString(8, newFood3);
                    updateStatement.setDouble(9, newPrice3);
                    updateStatement.setInt(10, id);
                    updateStatement.executeUpdate();

                    JOptionPane.showMessageDialog(this, "Restaurant updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    updateStatement.close();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Restaurant not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error updating restaurant: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void appendFood(StringBuilder menuInfo, String label, String foodName, double price) {
        if (foodName != null && !foodName.isEmpty()) {
            menuInfo.append(String.format("%s: %s - RM %.2f\n", label, foodName, price));
        }
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
            java.util.logging.Logger.getLogger(ManageClients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageClients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageClients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageClients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new ManageClients().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton displayButton;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton searchButton;
    // End of variables declaration//GEN-END:variables
}