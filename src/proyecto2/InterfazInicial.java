package proyecto2;

import javax.swing.JOptionPane;

/**
 * @author Ignacio
 */
public class InterfazInicial extends javax.swing.JFrame {

    /**
     * Creates new form InterfazInicial
     */
    public static UserList userList = new UserList();
    public static OpenerCsv file = new OpenerCsv();
    
    public InterfazInicial() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        newUser = new javax.swing.JButton();
        deleteUser = new javax.swing.JButton();
        logIn = new javax.swing.JButton();
        showUsers = new javax.swing.JButton();
        showImpression = new javax.swing.JButton();
        editImpresion = new javax.swing.JButton();
        save = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        newUser.setText("Agregar Usuario");
        newUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newUserMouseClicked(evt);
            }
        });
        newUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newUserActionPerformed(evt);
            }
        });

        deleteUser.setText("Eliminar Usuario");
        deleteUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteUserMouseClicked(evt);
            }
        });
        deleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteUserActionPerformed(evt);
            }
        });

        logIn.setText("Iniciar Sesion");
        logIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logInMouseClicked(evt);
            }
        });
        logIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logInActionPerformed(evt);
            }
        });

        showUsers.setText("Mostrar Lista de Usuarios");
        showUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showUsersActionPerformed(evt);
            }
        });

        showImpression.setText("Mostrar Cola de Impresión");

        editImpresion.setText("Editar Cola de Impresion");

        save.setText("Guardar Cambios");
        save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteUser)
                    .addComponent(newUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(logIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(save, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(103, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(showImpression, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(showUsers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editImpresion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(107, 107, 107))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(showUsers)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showImpression)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editImpresion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newUser)
                    .addComponent(logIn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteUser)
                    .addComponent(save))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showUsersActionPerformed
        String list = userList.printList();
        JOptionPane.showMessageDialog(null, list);
    }//GEN-LAST:event_showUsersActionPerformed

    private void newUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newUserActionPerformed

    }//GEN-LAST:event_newUserActionPerformed

    private void deleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteUserActionPerformed

    }//GEN-LAST:event_deleteUserActionPerformed

    private void newUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newUserMouseClicked
        AddUser addUser = new AddUser();
        addUser.setLocationRelativeTo(null);
        addUser.setVisible(true);
    }//GEN-LAST:event_newUserMouseClicked

    private void deleteUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteUserMouseClicked
        DeleteUser deleteUser = new DeleteUser();
        deleteUser.setLocationRelativeTo(null);
        deleteUser.setVisible(true);
    }//GEN-LAST:event_deleteUserMouseClicked

    private void logInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logInActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_logInActionPerformed

    private void logInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logInMouseClicked
        LogIn logIn = new LogIn();
        logIn.setLocationRelativeTo(null);
        logIn.setVisible(true);
    }//GEN-LAST:event_logInMouseClicked

    private void saveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveMouseClicked
        String text = userList.saveList();
        file.write(text);
        JOptionPane.showMessageDialog(null, "Se han guardado los cambios exitosamente.");
        
    }//GEN-LAST:event_saveMouseClicked

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
            java.util.logging.Logger.getLogger(InterfazInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazInicial().setVisible(false);
            }
        });
        InterfazInicial menu = new InterfazInicial(); //Creo interfaz con la lista de almacenes como parámetro
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
        
        //Guardamos el texto del archivo.
        String text = file.read();
        
        //Guardamos los datos del texto.
        try{
            String[] users = text.split("\n");
            for (int i = 0; i < users.length; i++) {
                String[] userInformation = users[i].split(";");
                if ((userInformation[0].equalsIgnoreCase("u﻿suario")) || (userInformation[1].equalsIgnoreCase("tipo"))){
                    System.out.println("Paso");
                }
                else{
                    String name = userInformation[0];
                    String priority = userInformation[1];
                    UserNode user = new UserNode(name, priority);
                    userList.addUser(user);  
                }
            }
        }
        catch (NullPointerException e){           
            System.exit(0);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteUser;
    private javax.swing.JButton editImpresion;
    private javax.swing.JButton logIn;
    private javax.swing.JButton newUser;
    private javax.swing.JButton save;
    private javax.swing.JButton showImpression;
    private javax.swing.JButton showUsers;
    // End of variables declaration//GEN-END:variables
}
