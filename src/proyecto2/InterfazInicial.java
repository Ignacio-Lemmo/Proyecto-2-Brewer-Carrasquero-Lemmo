package proyecto2;

import javax.swing.JOptionPane;

/**
 * @author Ignacio y Carlos
 * Agregadas las variables de tiempo, la impresión del árbol (puede mejorar). Falta explicar funcionamiento y validar.
 */
public class InterfazInicial extends javax.swing.JFrame {

    /**
     * Creates new form InterfazInicial
     */
    public static UserList userList = new UserList();
    public static OpenerCsv file = new OpenerCsv();
    public static BinaryHeap impresionList = new BinaryHeap();
    public static HashTable hashTable = new HashTable(97);
    
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

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        save = new javax.swing.JButton();
        logIn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        editImpresion = new javax.swing.JButton();
        buttonMostrarBinario = new javax.swing.JButton();
        showImpression = new javax.swing.JButton();
        showUsers = new javax.swing.JButton();
        newUser = new javax.swing.JButton();
        deleteUser = new javax.swing.JButton();
        buttonFuncionamiento = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/impresora.jpg"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(400, 330));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        save.setText("Guardar");
        save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveMouseClicked(evt);
            }
        });
        jPanel1.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 200, 110, -1));

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
        jPanel1.add(logIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, 110, -1));

        jButton1.setText("Imprimir primero en cola");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 230, -1));

        editImpresion.setText("Eliminar archivo en Cola de Impresion");
        editImpresion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editImpresionMouseClicked(evt);
            }
        });
        editImpresion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editImpresionActionPerformed(evt);
            }
        });
        jPanel1.add(editImpresion, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 230, -1));

        buttonMostrarBinario.setText("Mostrar Montículo Binario");
        buttonMostrarBinario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonMostrarBinarioMouseClicked(evt);
            }
        });
        jPanel1.add(buttonMostrarBinario, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 230, -1));

        showImpression.setText("Mostrar Cola de Impresión");
        showImpression.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showImpressionMouseClicked(evt);
            }
        });
        jPanel1.add(showImpression, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 230, -1));

        showUsers.setText("Mostrar Lista de Usuarios");
        showUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showUsersMouseClicked(evt);
            }
        });
        showUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showUsersActionPerformed(evt);
            }
        });
        jPanel1.add(showUsers, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 230, -1));

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
        jPanel1.add(newUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 110, -1));

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
        jPanel1.add(deleteUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 110, -1));

        buttonFuncionamiento.setText("Funcionamiento");
        buttonFuncionamiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonFuncionamientoMouseClicked(evt);
            }
        });
        jPanel1.add(buttonFuncionamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/impresora.jpg"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 0, 540, 230));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showUsersActionPerformed

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

    private void showImpressionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showImpressionMouseClicked
        String text = "";
        BinaryHeap helper = new BinaryHeap();
        helper = helper.clone(impresionList.getRoot(), helper);
        while (true){
            try{
                FileNode deleted = helper.eraseMin2();
                text += deleted.getTitle() + ": " + deleted.getSize() + " paginas.\n";
            }
            catch (Exception e){
                break;
            }
        }
        JOptionPane.showMessageDialog(null, text);
        InterfazInicial.hashTable.imprimir();
    }//GEN-LAST:event_showImpressionMouseClicked

    private void editImpresionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editImpresionMouseClicked
        EditImpresion print = new EditImpresion();
        print.setLocationRelativeTo(null);
        print.setVisible(true);
    }//GEN-LAST:event_editImpresionMouseClicked

    private void editImpresionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editImpresionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editImpresionActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        if (InterfazInicial.impresionList.getRoot() != null){
            BinaryHeapNode printed2 = InterfazInicial.impresionList.getRoot();
            InterfazInicial.hashTable.EliminarPrimero(printed2);
            FileNode printed = InterfazInicial.impresionList.eraseMin2();
            printed.setWaiting2();
            JOptionPane.showMessageDialog(null, "Titulo: " + printed.getTitle() + "\nNumero de paginas: " + printed.getSize() + "\n\nSe ha impreso el archivo correctamente.");  
        } 
        else if(InterfazInicial.impresionList.getRoot() == null){
            JOptionPane.showMessageDialog(null, "Hubo un error al intentar imprimir el archivo. \nAsegurese de que la cola de impresion no este vacia.");
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void buttonMostrarBinarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonMostrarBinarioMouseClicked
        // TODO add your handling code here:
        String text = "";
        String a,b,c,d,f,g,h,i,j,k,l,m,n,o,p;
        a = b = c = d = f = g = h = i = j = k = l = m = n = o = p = "";
        BinaryHeap helper = new BinaryHeap();
        helper = helper.clone(impresionList.getRoot(), helper);
        String nivel1 = "          ";
        String nivel2 = "                    ";
        String nivel3 = "                              ";
        String z = "\n";
        
        int contador = 0;
        while (true){
            try{
                FileNode deleted = helper.eraseMin2();
                if (contador == 0) {
                    a = deleted.getTitle();
                    text = a;
                } else if (contador == 1) {
                    b = deleted.getTitle();
                    text = a + z + nivel1 + b;
                } else if (contador == 2) {
                    c = deleted.getTitle();
                    text = nivel1 + c + z + a + z+ nivel1 + b;
                } else if (contador == 3) {
                    d = deleted.getTitle();
                    text = nivel1 + c + z + a + z+ nivel1 + b + z + nivel2 + d ;
                } else if (contador == 4) {
                    f = deleted.getTitle();
                    text = nivel1 + c + z  + a + z+ nivel2 + f+ z +nivel1 + b + z + nivel2 + d ;
                } else if (contador == 5) {
                    g = deleted.getTitle();
                    text = nivel1 + c  + z + nivel2 + g  + z + a + z + nivel2 + f+ z + nivel1 + b + z + nivel2 + d ; 
                } else if (contador == 6) {
                    h = deleted.getTitle();
                    text = nivel2 + h + z + nivel1 + c  + z + nivel2 + g  + z + a + z + nivel2 + f+ z + nivel1 + b + z + nivel2 + d ;
                } else if (contador == 7) {
                    i = deleted.getTitle();
                    text = nivel2 + h + z + nivel1 + c  + z + nivel2 + g  + z + a + z + nivel2 + f+  z +nivel1 + b + z + nivel2 + d + z + nivel3 + i; 
                } else if (contador == 8) {
                    j = deleted.getTitle();
                    text = nivel2 + h + nivel2 + z + nivel1 + c  + z + nivel2 + g  + z + a + z + nivel2 + f+ z + nivel1 + b + z + nivel3 + j + z + nivel2 + d + z + nivel3 + i; 
                } else if (contador == 9) {
                    k = deleted.getTitle();
                    text = nivel2 + h + z + nivel1 + c  + z + nivel2 + g  + z + a + z + nivel2 + f+ z + nivel3 + k + z + nivel1 + b + z + nivel3 + j + z + nivel2 + d + z + nivel3 + i;    
                } else if (contador == 10) {
                    l = deleted.getTitle();
                    text = nivel2+ h + z +nivel1 + c  + z + nivel2 + g  + z + a + z + nivel3 + l + z + nivel2 + f+ z + nivel3 + k + z + nivel1 + b + z + nivel3 + j + z + nivel2 + d + z + nivel3 + i; ;  
                } else if (contador == 11) {
                    m = deleted.getTitle();
                    text = nivel2 + h + z +nivel1 + c  + z + nivel2 + g  + z + nivel3 + m + z + a + z + nivel3 + l + z + nivel2 + f+ z + nivel3 + k + z + nivel1 + b + z + nivel3 + j + z + nivel2 + d + z + nivel3 + i; ;
                } else if (contador == 12) {
                    n = deleted.getTitle();
                    text = nivel2 + h + z +nivel1 + c  + z + nivel3 + n + z + nivel2 + g + z + nivel3 + m + z + a + z + nivel3 + l + z + nivel2 + f+ z + nivel3 + k + z + nivel1 + b + z + nivel3 + j + z + nivel2 + d + z + nivel3 + i; ;
                } else if (contador == 13) {
                    o = deleted.getTitle();
                    text = nivel2 + h + z + nivel3 + o + z + nivel1 + c  + z + nivel3 + n + z + nivel2 + g + z + nivel3 + m + z + a + z + nivel3 + l + z + nivel2 + f+ z + nivel3 + k + z + nivel1 + b + z + nivel3 + j + z + nivel2 + d + z + nivel3 + i; ;
                } else if (contador == 14) {
                    p = deleted.getTitle();
                    text = nivel3 + p + z + nivel2 + h + z + nivel3 + o + z + nivel1 + c  + z + nivel3 + n + z + nivel2 + g + z + nivel3 + m + z + a + z + nivel3 + l + z + nivel2 + f+ z + nivel3 + k + z + nivel1 + b + z + nivel3 + j + z + nivel2 + d + z + nivel3 + i; ;
                }
                contador++;
            }
            catch (Exception e){
                break;
            }
        }
        JOptionPane.showMessageDialog(null, text);
    }//GEN-LAST:event_buttonMostrarBinarioMouseClicked

    private void buttonFuncionamientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonFuncionamientoMouseClicked
        // TODO add your handling code here:
        FuncInterfazInicial fii = new FuncInterfazInicial();
        fii.setLocationRelativeTo(null);
        fii.setVisible(true);
    }//GEN-LAST:event_buttonFuncionamientoMouseClicked

    private void showUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showUsersMouseClicked
        String list = userList.printList();
        JOptionPane.showMessageDialog(null, list);
    }//GEN-LAST:event_showUsersMouseClicked

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
        JOptionPane.showMessageDialog(null, "¡Bienvenido a impresiones UNIMET! \n\nPara más información puede presionar el botón 'funcionamiento'\n\nDisfrute del servicio.");

            
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonFuncionamiento;
    private javax.swing.JButton buttonMostrarBinario;
    private javax.swing.JButton deleteUser;
    private javax.swing.JButton editImpresion;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton logIn;
    private javax.swing.JButton newUser;
    private javax.swing.JButton save;
    private javax.swing.JButton showImpression;
    private javax.swing.JButton showUsers;
    // End of variables declaration//GEN-END:variables
}
