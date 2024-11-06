/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tampilan;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import kelas.Category;
import kelas.Products;
/**
 *
 * @author Santri IT
 */
public class f_products extends javax.swing.JFrame {

    /**
     * Creates new form f_products
     */
    public f_products() {
        initComponents();
        loadTable();
        reset();
        comboBox();
    }

    void loadTable() {

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID PRODUK");
        model.addColumn("PRODUK");
        model.addColumn("DESKRIPSI");
        model.addColumn("HARGA");
        model.addColumn("KATEGORI");

        try {
            Products pro = new Products();
            ResultSet data = pro.tampilProduk();
            
            while (data.next()) {
                model.addRow(new Object[]{
                    data.getString("ID"),
                    data.getString("Nama"),
                    data.getString("Deskripsi"),
                    data.getString("Harga"),
                    data.getString("Kategori"),});
            }
        } catch (SQLException sQLException) {
        }
        tProduk.setModel(model);
    }

    void reset() {
        autoID();
        tID.setEditable(true);
        tDesk.setText(null);
        tHarga.setText(null);
        cKategori.setSelectedItem(null);
        tNama.setText(null);
    }

    void comboBox() {

        try {
            Category cat = new Category();
            ResultSet data = cat.tampilComBox();

            while (data.next()) {
                String isi = data.getString("category_name");
                cKategori.addItem(isi);
            }
        } catch (SQLException ex) {
        }
    }

    void autoID() {

        try {
            Products pro = new Products();
            ResultSet id = pro.autoID();
            if (id.next()) {
                int auto = id.getInt("ID") + 1;
                tID.setText(String.valueOf(auto));
            } else {
                tID.setText("1");
            }
        } catch (SQLException sQLException) {
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

        tNama = new javax.swing.JTextField();
        tDesk = new javax.swing.JTextField();
        tHarga = new javax.swing.JTextField();
        cKategori = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        btambah = new javax.swing.JButton();
        tubah = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        bhapus = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tID = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tProduk = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Makanan ", "Minuman" }));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("f-products");

        btambah.setText("TAMBAH");
        btambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btambahActionPerformed(evt);
            }
        });

        tubah.setText("UBAH");
        tubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tubahActionPerformed(evt);
            }
        });

        jLabel1.setText("ID                 ");

        bhapus.setText("HAPUS");
        bhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhapusActionPerformed(evt);
            }
        });

        jLabel2.setText("Nama");

        jLabel3.setText("Deskripsi");

        jLabel4.setText("Harga");

        jLabel5.setText("Kategori");

        tID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tIDActionPerformed(evt);
            }
        });

        tProduk.setModel(new javax.swing.table.DefaultTableModel(
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
        tProduk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tProdukMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tProduk);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tDesk, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tHarga, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cKategori, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tNama, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                            .addComponent(tID, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tubah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bhapus))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addComponent(jLabel1))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tDesk, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btambah)
                    .addComponent(tubah)
                    .addComponent(bhapus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tIDActionPerformed

    private void btambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btambahActionPerformed
        // TODO add your handling code here:
        try {

            Products pro = new Products();
            Category cat = new Category();
            pro.setProduct_id(Integer.parseInt(tID.getText()));
            pro.setProduct_name(tNama.getText());
            pro.setProduct_desc(tDesk.getText());

            pro.setProduct_price(Integer.parseInt(tHarga.getText()));

            cat.setCategory_name(cKategori.getSelectedItem().toString());
            ResultSet data = cat.Konversi();

            if (data.next()) {

                String isi = data.getString("category_id");
                pro.setProduct_cat_id(Integer.parseInt(isi));
            }
            pro.tambahProduk();

        } catch (SQLException sQLException) {
            System.out.println("data tidak masuk");
        }
        loadTable();
        reset();
    }//GEN-LAST:event_btambahActionPerformed

    private void bhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapusActionPerformed
        // TODO add your handling code here:
        try {

            Products pro = new Products();
            pro.setProduct_id(Integer.parseInt(tID.getText()));
            pro.hapusProduk();
        } catch (SQLException sQLException) {
        }
        reset();
        loadTable();
    }//GEN-LAST:event_bhapusActionPerformed

    private void tProdukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tProdukMouseClicked
        // TODO add your handling code here:
        int baris = tProduk.rowAtPoint(evt.getPoint());
        String ID = tProduk.getValueAt(baris, 0).toString();
        String Nama = tProduk.getValueAt(baris, 1).toString();
        String Desc = tProduk.getValueAt(baris, 2).toString();
        String Harga = tProduk.getValueAt(baris, 3).toString();

        String Kategori = tProduk.getValueAt(baris, 4).toString();

        tID.setText(ID);
        tID.setEditable(false);
        tNama.setText(Nama);
        tHarga.setText(Harga);
        tDesk.setText(Desc);
        cKategori.setSelectedItem(Kategori);
    }//GEN-LAST:event_tProdukMouseClicked

    private void tubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tubahActionPerformed
        // TODO add your handling code here:
        try {

            Products pro = new Products();
            Category cat = new Category();
            pro.setProduct_id(Integer.parseInt(tID.getText()));

            pro.setProduct_name(tNama.getText());
            pro.setProduct_desc(tDesk.getText());

            pro.setProduct_price(Integer.parseInt(tHarga.getText()));

            cat.setCategory_name(cKategori.getSelectedItem().toString());
            ResultSet data = cat.Konversi();

            if (data.next()) {
                String isi = data.getString("category_id");
                pro.setProduct_cat_id(Integer.parseInt(isi));
            }
            pro.ubahProduk();

        } catch (SQLException sQLException) {
            System.out.println("data tidak masuk");
        }

        loadTable();
        reset();

    }//GEN-LAST:event_tubahActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new f_products().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bhapus;
    private javax.swing.JButton btambah;
    private javax.swing.JComboBox<String> cKategori;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tDesk;
    private javax.swing.JTextField tHarga;
    private javax.swing.JTextField tID;
    private javax.swing.JTextField tNama;
    private javax.swing.JTable tProduk;
    private javax.swing.JButton tubah;
    // End of variables declaration//GEN-END:variables

}
