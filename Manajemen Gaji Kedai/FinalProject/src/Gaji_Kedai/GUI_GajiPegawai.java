/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Gaji_Kedai;

/**
 *
 * @author march
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
public class GUI_GajiPegawai extends javax.swing.JFrame {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/gaji_kedai";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private Connection connection;

    /**
     * Creates new form GUI_GajiPegawai
     */
    public GUI_GajiPegawai() {
        initComponents();
        initializeDatabaseConnection();
        DefaultTableModel dataModel = (DefaultTableModel) Tabel.getModel();
        int rowCount = dataModel.getRowCount();
        while (rowCount > 0)
        {
            dataModel.removeRow(rowCount - 1);
            rowCount = dataModel.getRowCount();
        }
    }
    private void initializeDatabaseConnection() {
        try {
        // Memuat driver JDBC MySQL
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Menjalin koneksi ke database
        connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
    } catch (ClassNotFoundException | SQLException ex) {
        JOptionPane.showMessageDialog(this, "Gagal terhubung ke database.");
        ex.printStackTrace();
    }
    }

    private void saveToDatabase(int id, String jabatan, int hadir, int lembur, int totalGaji) {
        try {
            String query = "INSERT INTO pegawai (id, jabatan, hadir, lembur, total_gaji) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.setString(2, jabatan);
            statement.setInt(3, hadir);
            statement.setInt(4, lembur);
            statement.setInt(5, totalGaji);

            statement.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Failed to save data to the database.");
            ex.printStackTrace();
        }
    }

    private void loadDataFromDatabase() {
        try {
            String query = "SELECT * FROM gaji_kedai";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            DefaultTableModel dataModel = (DefaultTableModel) Tabel.getModel();
            dataModel.setRowCount(0); // Clear existing rows

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String jabatan = resultSet.getString("jabatan");
                int hadir = resultSet.getInt("hadir");
                int lembur = resultSet.getInt("lembur");
                int totalGaji = resultSet.getInt("total_gaji");
                dataModel.addRow(new Object[]{id, jabatan, hadir, lembur, totalGaji});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Failed to load data from the database.");
            ex.printStackTrace();
        }
    }
    
    private void insertToDatabase(int id, String jabatan, int hadir, int lembur, int totalGaji) {
    try {
        // Disesuaikan dengan skema database dan koneksi database yang digunakan
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

        String sql = "INSERT INTO pegawai (id, jabatan, hadir, lembur, total_gaji) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.setString(2, jabatan);
            statement.setInt(3, hadir);
            statement.setInt(4, lembur);
            statement.setInt(5, totalGaji);

            statement.executeUpdate();
        }

        connection.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Failed to Insert data from the database.");
        e.printStackTrace();
        // Tambahkan penanganan kesalahan sesuai kebutuhan Anda
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmb1 = new javax.swing.JComboBox<>();
        txtHadir = new javax.swing.JTextField();
        txtLembur = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabel = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        btnInsert = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Manajemen Gaji");

        jLabel2.setText("Jabatan Perusahaan :");

        jLabel3.setText("Jumlah Hadir :");

        jLabel4.setText("Jumlah Lembur :");

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jLabel5.setText("Total gaji ");

        jLabel6.setText("Rp");

        cmb1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Karyawan", "Sekretaris", "Manager" }));

        txtHadir.setText("0");

        txtLembur.setText("0");

        Tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Jabatan", "Hadir", "Lembur", "Total Gaji"
            }
        ));
        jScrollPane2.setViewportView(Tabel);

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnInsert.setText("Insert");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addGap(27, 27, 27)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtHadir, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmb1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtLembur, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel4))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(26, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cmb1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtHadir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(txtLembur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnClose)
                        .addComponent(btnDelete))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnUpdate)
                        .addComponent(btnInsert)))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dataModel = (DefaultTableModel) Tabel.getModel();
        int selectedRow = Tabel.getSelectedRow();

        if (selectedRow != -1) {
        int id = Integer.parseInt(dataModel.getValueAt(selectedRow, 0).toString());
        int hadir = Integer.parseInt(txtHadir.getText());
        int lmbr = Integer.parseInt(txtLembur.getText());

        Pegawai pegawai = null;

        if (cmb1.getSelectedIndex() == 0) {
            pegawai = new Karyawan();
        } else if (cmb1.getSelectedIndex() == 1) {
            pegawai = new Sekretaris();
            ((Sekretaris) pegawai).jmlHadir = hadir;
        } else if (cmb1.getSelectedIndex() == 2) {
            pegawai = new Manager();
            ((Manager) pegawai).jmlHadir = hadir;
            ((Manager) pegawai).jmlLembur = lmbr;
        }

        if (pegawai != null) {
            int totalGaji = pegawai.hitGaji();
            dataModel.setValueAt(pegawai.getClass().getSimpleName(), selectedRow, 1);
            dataModel.setValueAt(hadir, selectedRow, 2);
            dataModel.setValueAt(lmbr, selectedRow, 3);
            dataModel.setValueAt(totalGaji, selectedRow, 4);
            txtTotal.setText(Integer.toString(totalGaji));

            // Update to the database
            updateToDatabase(id, pegawai.getClass().getSimpleName(), hadir, lmbr, totalGaji);
        }
    } else {
        JOptionPane.showMessageDialog(rootPane, "Pilih baris yang akan diupdate.");
    }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dataModel = (DefaultTableModel) Tabel.getModel();
    int selectedRow = Tabel.getSelectedRow();

    if (selectedRow != -1) {
        int id = Integer.parseInt(dataModel.getValueAt(selectedRow, 0).toString());
        dataModel.removeRow(selectedRow);

        // Delete from the database
        deleteFromDatabase(id);
    } else {
        JOptionPane.showMessageDialog(rootPane, "Pilih baris yang akan dihapus.");
    }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // TODO add your handling code here:
    DefaultTableModel dataModel = (DefaultTableModel) Tabel.getModel();
    int hadir = Integer.parseInt(txtHadir.getText());
    int lmbr = Integer.parseInt(txtLembur.getText());

    Pegawai pegawai = null;

    if (cmb1.getSelectedIndex() == 0) {
        pegawai = new Karyawan();
    } else if (cmb1.getSelectedIndex() == 1) {
        pegawai = new Sekretaris();
        ((Sekretaris) pegawai).jmlHadir = hadir;
    } else if (cmb1.getSelectedIndex() == 2) {
        pegawai = new Manager();
        ((Manager) pegawai).jmlHadir = hadir;
        ((Manager) pegawai).jmlLembur = lmbr;
    }

    if (pegawai != null) {
        int totalGaji = pegawai.hitGaji();
        dataModel.addRow(new Object[]{0, pegawai.getClass().getSimpleName(), hadir, lmbr, totalGaji});
        txtTotal.setText(Integer.toString(totalGaji));

        // Insert to the database
        insertToDatabase(pegawai.getClass().getSimpleName(), hadir, lmbr, totalGaji);
    }
    }//GEN-LAST:event_btnInsertActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_GajiPegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_GajiPegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_GajiPegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_GajiPegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_GajiPegawai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabel;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmb1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtHadir;
    private javax.swing.JTextField txtLembur;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables

    private void updateToDatabase(int id, String jabatan, int hadir, int lmbr, int totalGaji) {
       try {
        String query = "UPDATE pegawai SET jabatan=?, hadir=?, lembur=?, total_gaji=?, WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, jabatan);
        statement.setInt(2, hadir);
        statement.setInt(3, lmbr);
        statement.setInt(4, totalGaji);
        statement.setInt(5, id);
        

        statement.executeUpdate();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Failed to update data in the database.");
        ex.printStackTrace();
    }
    }

    private void deleteFromDatabase(int id) {
        try {
        String query = "DELETE FROM pegawai WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);

        statement.executeUpdate();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Failed to delete data from the database.");
        ex.printStackTrace();
    }
    }

    private void insertToDatabase(String jabatan, int hadir, int lmbr, int totalGaji) {
         try {
        String query = "INSERT INTO pegawai (jabatan, hadir, lembur, total_gaji) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, jabatan);
        statement.setInt(2, hadir);
        statement.setInt(3, lmbr);
        statement.setInt(4, totalGaji);

        statement.executeUpdate();
        //loadDataFromDatabase(); // Reload data after inserting
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Failed to insert data into the database.");
        ex.printStackTrace();
    }
  }
}
