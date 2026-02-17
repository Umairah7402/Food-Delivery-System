public class HomePage extends javax.swing.JFrame {

    public HomePage() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        customerRadioButton = new javax.swing.JRadioButton();
        restaurantRadioButton = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        goToplaceOrderButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        goToManageClientButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 500));
        setSize(new java.awt.Dimension(500, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 27)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("FOOD DELIVERY SYSTEM");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 360, 30));

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel2.setText("HOME PAGE");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 90, -1));

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel3.setText("CHOOSE YOUR ACCOUNT AS:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 220, -1));

        customerRadioButton.setBackground(new java.awt.Color(255, 204, 204));
        customerRadioButton.setText("CUSTOMER");
        customerRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerRadioButtonActionPerformed(evt);
            }
        });
        getContentPane().add(customerRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 90, -1));

        restaurantRadioButton.setBackground(new java.awt.Color(255, 204, 204));
        restaurantRadioButton.setText("RESTAURANT");
        restaurantRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restaurantRadioButtonActionPerformed(evt);
            }
        });
        getContentPane().add(restaurantRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, -1, -1));

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel6.setText("PLEASE REGISTER YOUR ACCOUNT:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 270, 20));

        goToplaceOrderButton.setBackground(new java.awt.Color(255, 204, 204));
        goToplaceOrderButton.setText("YOU MAY PLACE ORDERS BY CLICKING HERE");
        goToplaceOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToplaceOrderButtonActionPerformed(evt);
            }
        });
        getContentPane().add(goToplaceOrderButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 350, 40));
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, -1, -1));

        goToManageClientButton.setBackground(new java.awt.Color(255, 204, 204));
        goToManageClientButton.setText("YOU MAY MANAGE CLIENTS INFORMATION BY CLICKING HERE");
        goToManageClientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToManageClientButtonActionPerformed(evt);
            }
        });
        getContentPane().add(goToManageClientButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, 350, 40));

        exitButton.setBackground(new java.awt.Color(255, 204, 204));
        exitButton.setText("EXIT");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(exitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 70, 30));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background.png"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void customerRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerRadioButtonActionPerformed
        if (restaurantRadioButton.isSelected()) {
            restaurantRadioButton.setSelected(false);
        }
        java.awt.EventQueue.invokeLater(() -> new CustomerPage().setVisible(true));
        this.dispose(); // Close the current RegisterPage
    }//GEN-LAST:event_customerRadioButtonActionPerformed

    private void restaurantRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restaurantRadioButtonActionPerformed
        // Open the RestaurantPage GUI
        if (customerRadioButton.isSelected()) {
            customerRadioButton.setSelected(false);
        }
        java.awt.EventQueue.invokeLater(() -> new RestaurantPage().setVisible(true));
        this.dispose(); // Close the current RegisterPage
    }//GEN-LAST:event_restaurantRadioButtonActionPerformed

    private void goToplaceOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goToplaceOrderButtonActionPerformed
        this.dispose();
        OrderPage orderPage = new OrderPage();
        orderPage.setVisible(true);
    }//GEN-LAST:event_goToplaceOrderButtonActionPerformed

    private void goToManageClientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goToManageClientButtonActionPerformed
        this.dispose();
        ManageClients manageClients = new ManageClients();
        manageClients.setVisible(true);
    }//GEN-LAST:event_goToManageClientButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

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
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new HomePage().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton customerRadioButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton goToManageClientButton;
    private javax.swing.JButton goToplaceOrderButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton restaurantRadioButton;
    // End of variables declaration//GEN-END:variables
}