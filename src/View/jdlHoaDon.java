/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Services.HoaDonService;
import Services.IQLHoaDonService;
import Services.IQLKhachHangService;
import Services.IQLNhanVienService;
import Services.KhachHangService;
import Services.NhanVienService;
import ViewModels.QLCheck;
import ViewModels.QLHoaDon;
import ViewModels.QLKhachHang;
import ViewModels.QLNhanVien;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author congh
 */
public class jdlHoaDon extends javax.swing.JFrame {

    /**
     * Creates new form jdlHoaDon
     */
    private DefaultTableModel dtm = new DefaultTableModel();
    private List<QLHoaDon> listqlhd = new ArrayList<>();
    private IQLHoaDonService iqlhds = new HoaDonService();
    private IQLNhanVienService iqlnvs = new NhanVienService();
    private IQLKhachHangService iqlkhs = new KhachHangService();
    private DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
    private DefaultComboBoxModel dcbm1 = new DefaultComboBoxModel();
    private DefaultComboBoxModel dcbm2 = new DefaultComboBoxModel();
    List<QLNhanVien> listqlnv = new ArrayList<>();
    List<QLKhachHang> listqlkh = new ArrayList<>();
    static String s = "";

    public jdlHoaDon(QLCheck qlc) {
        initComponents();
        s = qlc.getSo1();
        tbhoaDon.setModel(dtm);
        String[] form = {"STT", "Ma HD", "Ngay Tao", "Ten Nhan Vien", "Tinh Trang"};
        dtm.setColumnIdentifiers(form);
        loaddDate();
        loaddCbb();
    }

    private jdlHoaDon() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void loaddDate() {
        listqlhd = iqlhds.getALL();
        inputDataHoDon(listqlhd);
        listqlkh = iqlkhs.getall();
        listqlnv = iqlnvs.getAll();
        
    }

    private void inputDataHoDon(List<QLHoaDon> listqlhd) {
        dtm.setRowCount(0);
        int i = 0;
        for (QLHoaDon qlhd : listqlhd) {
            i++;
            dtm.addRow(qlhd.toRow(i));
        }
    }

    private void loaddCbb() {
        cbbNhanVien.setModel(dcbm);
        cbbkhachHang.setModel(dcbm1);
        cbbtrangThai.setModel(dcbm2);

        List<String> listcbb = new ArrayList<>();
        List<String> listcbbnv = new ArrayList<>();
        List<String> listcbbch = new ArrayList<>();
        dcbm2.removeAllElements();
        listcbb.add("Ch??? thanh to??n");
        listcbb.add("H???y");
        listcbb.add("???? Thanh To??n");
        dcbm2.addAll(listcbb);

        for (QLKhachHang qLKhachHang : listqlkh) {
            listcbbch.add(qLKhachHang.getHo() + qLKhachHang.getTenDem() + qLKhachHang.getTen());
        }
        dcbm1.addAll(listcbbch);
        for (QLNhanVien qLNhanVien : listqlnv) {
            listcbbnv.add(qLNhanVien.getHo() + qLNhanVien.getTenDem() + qLNhanVien.getTen());
        }
        dcbm.addAll(listcbbnv);
        cbbNhanVien.setSelectedIndex(0);
        cbbkhachHang.setSelectedIndex(0);
        cbbtrangThai.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbhoaDon = new javax.swing.JTable();
        txtngayTao = new javax.swing.JTextField();
        txtMa = new javax.swing.JTextField();
        txtdiaChi = new javax.swing.JTextField();
        txtngayNhan = new javax.swing.JTextField();
        txtngayThanhToan = new javax.swing.JTextField();
        txttenNguoiNhan = new javax.swing.JTextField();
        txtngayShip = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        cbbkhachHang = new javax.swing.JComboBox<>();
        cbbNhanVien = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        lbID = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cbbtrangThai = new javax.swing.JComboBox<>();
        btnthem = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        btnxoa = new javax.swing.JButton();
        btnthanhToan = new javax.swing.JButton();

        jLabel14.setText("ID");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbhoaDon.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbhoaDon);

        txtngayTao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtngayTaoActionPerformed(evt);
            }
        });

        txtdiaChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdiaChiActionPerformed(evt);
            }
        });

        cbbkhachHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbkhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbkhachHangActionPerformed(evt);
            }
        });

        cbbNhanVien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("ID");

        jLabel3.setText("M??");

        jLabel4.setText("Ng??y Nh???n");

        jLabel5.setText("Ng??y T???o");

        jLabel6.setText("Ng??y Thanh To??n");

        jLabel7.setText("Kh??ch H??ng");

        jLabel8.setText("?????a Ch???");

        jLabel9.setText("Tr???ng Th??i");

        jLabel10.setText("T??n Ng?????i Nh???n");

        jLabel11.setText("Nh??n Vi??n");

        jLabel12.setText("Ng??y Ship");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel13.setText("H??A ????N");

        jLabel15.setText("S??? ??i???n Tho???i");

        cbbtrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnthem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnthem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add to basket.png"))); // NOI18N
        btnthem.setText("Th??m");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        btnsua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnsua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Edit.png"))); // NOI18N
        btnsua.setText("S???a");

        btnxoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnxoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Remove from basket.png"))); // NOI18N
        btnxoa.setText("X??a");
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });

        btnthanhToan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnthanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Money.png"))); // NOI18N
        btnthanhToan.setText("Thanh To??n");
        btnthanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthanhToanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(333, 333, 333)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtngayThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtngayShip, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(lbID, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtngayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(42, 42, 42)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel15)
                                            .addComponent(jLabel10))))
                                .addGap(28, 28, 28))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtngayNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txttenNguoiNhan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdiaChi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbkhachHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbtrangThai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbNhanVien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnthem)
                        .addGap(63, 63, 63)
                        .addComponent(btnsua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnxoa)
                        .addGap(44, 44, 44)
                        .addComponent(btnthanhToan)
                        .addGap(58, 58, 58))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbID)
                    .addComponent(jLabel11)
                    .addComponent(cbbNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel9)
                    .addComponent(cbbtrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtngayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cbbkhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6)
                    .addComponent(txtdiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtngayThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtngayShip, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel15)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtngayNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txttenNguoiNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnthem)
                    .addComponent(btnsua)
                    .addComponent(btnxoa)
                    .addComponent(btnthanhToan))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbbkhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbkhachHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbkhachHangActionPerformed

    private void txtngayTaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtngayTaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtngayTaoActionPerformed

    private void txtdiaChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdiaChiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdiaChiActionPerformed

    private void btnthanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthanhToanActionPerformed
        // TODO add your handling code here:
        this.dispose();
        QLCheck check = new QLCheck(s);
        new JFBanHang(check).setVisible(true);
    }//GEN-LAST:event_btnthanhToanActionPerformed

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        // TODO add your handling code here:
        String idkh = "";
        String idnv = "";
        for (QLKhachHang qLKhachHang : listqlkh) {
            if ((qLKhachHang.getHo() + qLKhachHang.getTenDem() + qLKhachHang.getTen()).equals(cbbkhachHang.getSelectedItem())) {
                idkh = qLKhachHang.getId();
            }
        }
        for (QLNhanVien qLNhanVien : listqlnv) {
            if ((qLNhanVien.getHo() + qLNhanVien.getTenDem() + qLNhanVien.getTen()).equals(cbbNhanVien.getSelectedItem())) {
                idnv = qLNhanVien.getId();
            }
        }
        QLKhachHang qlkh = new QLKhachHang(idkh);
        QLNhanVien qlnv = new QLNhanVien(idnv);
        int i = 0;
        if (cbbtrangThai.getSelectedItem().equals("???? Thanh To??n")) {
            i = 1;
        } else if (cbbtrangThai.getSelectedItem().equals("Ch??? Thanh To??n")) {
            i = 0;
        } else {
            i = 3;
        }
        boolean kq = iqlhds.save(new QLHoaDon(null, qlkh, qlnv, txtMa.getText(), txtngayTao.getText(),
                 txtngayThanhToan.getText(), txtngayShip.getText(),txtngayNhan.getText(), i, txttenNguoiNhan.getText(),
                txtdiaChi.getText(), txtSDT.getText()));
        if (kq = true) {
            JOptionPane.showMessageDialog(this, "Ok");
        } else {
            JOptionPane.showMessageDialog(this, "Kh??ng Ok");
        }
        loaddDate();
    }//GEN-LAST:event_btnthemActionPerformed

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        // TODO add your handling code here:
        int i = tbhoaDon.getSelectedRow();
        QLHoaDon qlhd = listqlhd.get(i);
        boolean kq = iqlhds.delete(qlhd);
        if (kq = true) {
            JOptionPane.showMessageDialog(this, "Ok");
        } else {
            JOptionPane.showMessageDialog(this, "Kh??ng Ok");
        }
    }//GEN-LAST:event_btnxoaActionPerformed

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
            java.util.logging.Logger.getLogger(jdlHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdlHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdlHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdlHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            QLCheck qlc = new QLCheck(s);
            new jdlHoaDon(qlc).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthanhToan;
    private javax.swing.JButton btnthem;
    private javax.swing.JButton btnxoa;
    private javax.swing.JComboBox<String> cbbNhanVien;
    private javax.swing.JComboBox<String> cbbkhachHang;
    private javax.swing.JComboBox<String> cbbtrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbID;
    private javax.swing.JTable tbhoaDon;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtdiaChi;
    private javax.swing.JTextField txtngayNhan;
    private javax.swing.JTextField txtngayShip;
    private javax.swing.JTextField txtngayTao;
    private javax.swing.JTextField txtngayThanhToan;
    private javax.swing.JTextField txttenNguoiNhan;
    // End of variables declaration//GEN-END:variables
}
