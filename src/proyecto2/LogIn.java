/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;

import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;  
import java.util.Date;

/**
 *
 * @author Ignacio y Carlos
 */
public class LogIn extends javax.swing.JFrame {

    /**
     * Creates new form LogIn
     */
    public LogIn() {
        initComponents();
        this.setDefaultCloseOperation(1);
        for (int i = 0; i < InterfazInicial.userList.getSize(); i++) {
            userBox.addItem(InterfazInicial.userList.getNodeAt(i).getName());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        userBox = new javax.swing.JComboBox<>();
        select = new javax.swing.JToggleButton();
        newFile = new javax.swing.JButton();
        deleteFile = new javax.swing.JButton();
        print = new javax.swing.JButton();
        fileBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        waitingList = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        buttonFuncionamiento = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Seleccione su nombre de Usuario");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        getContentPane().add(userBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 55, 157, -1));

        select.setText("Seleccionar");
        select.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectMouseClicked(evt);
            }
        });
        select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectActionPerformed(evt);
            }
        });
        getContentPane().add(select, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 55, -1, -1));

        newFile.setText("Nuevo Archivo");
        newFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newFileMouseClicked(evt);
            }
        });
        getContentPane().add(newFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 124, -1));

        deleteFile.setText("Eliminar Archivo");
        deleteFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteFileMouseClicked(evt);
            }
        });
        getContentPane().add(deleteFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 124, -1));

        print.setText("Imprimir Archivo");
        print.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                printMouseClicked(evt);
            }
        });
        getContentPane().add(print, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, -1, -1));

        getContentPane().add(fileBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 202, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Seleccione el Archivo que desea manipular");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 96, -1, -1));

        getContentPane().add(waitingList, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, 180, -1));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonFuncionamiento.setText("Funcionamiento");
        buttonFuncionamiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonFuncionamientoMouseClicked(evt);
            }
        });
        jPanel1.add(buttonFuncionamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, -1, -1));

        exit.setText("Regresar");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jPanel1.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, -1, -1));

        jLabel3.setText("Mis archivos en cola de Impresión");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, -1, 20));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Oficina4.jpg"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, -30, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 250));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        this.dispose();
    }//GEN-LAST:event_exitActionPerformed

    private void selectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectMouseClicked
        fileBox.removeAllItems();
        String name = userBox.getSelectedItem().toString();
        UserNode userSelected = InterfazInicial.userList.getNode(name);
        boolean empty = true;
        if (userSelected.getFilesList().getSize() != 0){
            for (int i = 0; i < userSelected.getFilesList().getSize(); i++) {
                String file = userSelected.getFilesList().getNodeAt(i).getTitle();
                fileBox.addItem(file);
                if (userSelected.getFilesList().getNodeAt(i).getWaiting()) {
                    waitingList.addItem(file);
                    empty = false;
                }
            }
        }
        else{
            fileBox.addItem("Lista vacia.");
            waitingList.addItem("No hay documentos en espera.");
        }
        if (empty){
            waitingList.addItem("No hay documentos en espera.");
        }
    }//GEN-LAST:event_selectMouseClicked

    private void deleteFileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteFileMouseClicked
        String title = fileBox.getSelectedItem().toString();
        String name = userBox.getSelectedItem().toString();
        FileNode toDelete = InterfazInicial.userList.getNode(name).getFilesList().getNode(title);
        InterfazInicial.userList.getNode(name).getFilesList().deleteNode(toDelete);
        JOptionPane.showMessageDialog(null, "Archivo eliminado correctamente.");
        this.dispose();
        
    }//GEN-LAST:event_deleteFileMouseClicked

    private void newFileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newFileMouseClicked
        String name = userBox.getSelectedItem().toString();
        AddFile addFile = new AddFile(name);
        addFile.setLocationRelativeTo(null);
        addFile.setVisible(true);
        this.dispose();
        fileBox.removeAllItems();
        waitingList.removeAllItems();
        
    }//GEN-LAST:event_newFileMouseClicked

    private void printMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printMouseClicked
        try{
            if (InterfazInicial.hashTable.buscar1(userBox.getSelectedItem().toString(), fileBox.getSelectedItem().toString()) == false){
                float hora = java.time.LocalTime.now().getHour();
                float minuto = java.time.LocalTime.now().getMinute();
                float segundo = java.time.LocalTime.now().getSecond();
                float hms = (hora+minuto/60+segundo/3600); //Almacena la hora actual del momento en el que se envió a imprimir un documento.
                //System.out.println(hora+minuto/60+segundo/3600);
                String title = fileBox.getSelectedItem().toString();
                String name = userBox.getSelectedItem().toString();
                int paginas = InterfazInicial.userList.getNode(name).getFilesList().getNode(title).getSize();
                int prioridad = InterfazInicial.userList.getNode(name).getFilesList().getNode(title).getPriorityInt();
                int priority = JOptionPane.showConfirmDialog(null, "¿Es prioritaria la impresion de este archivo?");
                if (priority == 0){
                    InterfazInicial.userList.getNode(name).getFilesList().getNode(title).setUrgency();
                    InterfazInicial.userList.getNode(name).getFilesList().getNode(title).setWaiting();
                    //Llenado de HashTable
                    InterfazInicial.hashTable.insertar(hms+(paginas*prioridad), InterfazInicial.userList.getNode(name), InterfazInicial.userList.getNode(name).getFilesList().getNode(title));
                    //--------------------
                    BinaryHeapNode newNode = new BinaryHeapNode((InterfazInicial.userList.getNode(name).getFilesList().getNode(title)), hms+(paginas*prioridad), (InterfazInicial.impresionList.getSize()));
                    InterfazInicial.impresionList.addNode(InterfazInicial.impresionList.getRoot(), newNode);
                    JOptionPane.showMessageDialog(null, "Se ha agregado exitosamente el archivo a la cola de impresion.");
                }    
                else if (priority == 1){
                    InterfazInicial.userList.getNode(name).getFilesList().getNode(title).setWaiting();
                    //Llenado de HashTable
                    InterfazInicial.hashTable.insertar(hms+(paginas*4), InterfazInicial.userList.getNode(name), InterfazInicial.userList.getNode(name).getFilesList().getNode(title));
                    //---------------------
                    BinaryHeapNode newNode = new BinaryHeapNode((InterfazInicial.userList.getNode(name).getFilesList().getNode(title)), hms+(paginas*4), (InterfazInicial.impresionList.getSize()));
                    InterfazInicial.impresionList.addNode(InterfazInicial.impresionList.getRoot(), newNode);
                    JOptionPane.showMessageDialog(null, "Se ha agregado exitosamente el archivo a la cola de impresion.");
                }
                else if (priority == 2){
                    JOptionPane.showMessageDialog(null, "Se cancelado la operacion.");
                }
                this.dispose();
                fileBox.removeAllItems();
                waitingList.removeAllItems();
                this.setVisible(true);
                this.setLocationRelativeTo(null);
            }
            else{
                JOptionPane.showMessageDialog(null, "Error, ya existe un archivo en cola con este titulo, \nespere que sea impreso para volver a imprimirlo.");
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error: Asegurese de haber seleccionado un archivo antes de imprimirlo.");
        }
    }//GEN-LAST:event_printMouseClicked

    private void selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectActionPerformed

    }//GEN-LAST:event_selectActionPerformed

    private void buttonFuncionamientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonFuncionamientoMouseClicked
        // TODO add your handling code here:
        FuncLogIn fli = new FuncLogIn();
        fli.setVisible(true);
        fli.setLocationRelativeTo(null);
    }//GEN-LAST:event_buttonFuncionamientoMouseClicked

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
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonFuncionamiento;
    private javax.swing.JButton deleteFile;
    private javax.swing.JButton exit;
    private javax.swing.JComboBox<String> fileBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton newFile;
    private javax.swing.JButton print;
    private javax.swing.JToggleButton select;
    private javax.swing.JComboBox<String> userBox;
    private javax.swing.JComboBox<String> waitingList;
    // End of variables declaration//GEN-END:variables
}
