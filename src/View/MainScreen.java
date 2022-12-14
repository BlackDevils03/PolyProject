/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Repositories.ChucVuRepository;
import ViewModels.QLCheck;
import javax.swing.JOptionPane;

/**
 *
 * @author congh
 */
public class MainScreen extends javax.swing.JFrame {

    /**
     * Creates new form MainScreen
     */
    String s1 = "";

    public MainScreen(QLCheck s) {
        initComponents();
        setLocationRelativeTo(null);
        s1 = s.getSo1();
        System.out.println(s1);
    }

    private MainScreen() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        btncCuaHang = new javax.swing.JButton();
        btnNhanVien = new javax.swing.JButton();
        btnSanPham = new javax.swing.JButton();
        btnkhachHang = new javax.swing.JButton();
        btnQLCv = new javax.swing.JButton();
        btnBanHang1 = new javax.swing.JButton();
        btnQLNSX = new javax.swing.JButton();
        btnlogout = new javax.swing.JButton();
        btnlogout1 = new javax.swing.JButton();

        jMenu3.setText("jMenu3");

        jMenu4.setText("jMenu4");

        jMenu5.setText("File");
        jMenuBar2.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar2.add(jMenu6);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("H??? th???ng b??n h??ng");

        btncCuaHang.setBackground(new java.awt.Color(255, 255, 255));
        btncCuaHang.setText("Qu???n l?? c???a h??ng");
        btncCuaHang.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btncCuaHang.setBorderPainted(false);
        btncCuaHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncCuaHangActionPerformed(evt);
            }
        });

        btnNhanVien.setBackground(new java.awt.Color(255, 255, 255));
        btnNhanVien.setText("Qu???n l?? nh??n vi??n");
        btnNhanVien.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnNhanVien.setBorderPainted(false);
        btnNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanVienActionPerformed(evt);
            }
        });

        btnSanPham.setBackground(new java.awt.Color(255, 255, 255));
        btnSanPham.setText("Qu???n l?? s???n ph???m");
        btnSanPham.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnSanPham.setBorderPainted(false);
        btnSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSanPhamActionPerformed(evt);
            }
        });

        btnkhachHang.setBackground(new java.awt.Color(255, 255, 255));
        btnkhachHang.setText("Kh??ch h??ng");
        btnkhachHang.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnkhachHang.setBorderPainted(false);
        btnkhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkhachHangActionPerformed(evt);
            }
        });

        btnQLCv.setBackground(new java.awt.Color(255, 255, 255));
        btnQLCv.setText("QU???N L?? CH???C V???");
        btnQLCv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQLCvActionPerformed(evt);
            }
        });

        btnBanHang1.setBackground(new java.awt.Color(255, 255, 255));
        btnBanHang1.setText("Mua S???m");
        btnBanHang1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBanHang1.setBorderPainted(false);
        btnBanHang1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBanHang1ActionPerformed(evt);
            }
        });

        btnQLNSX.setBackground(new java.awt.Color(255, 255, 255));
        btnQLNSX.setText("QU???N L?? NSX");
        btnQLNSX.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnQLNSX.setBorderPainted(false);
        btnQLNSX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQLNSXActionPerformed(evt);
            }
        });

        btnlogout.setBackground(new java.awt.Color(204, 0, 0));
        btnlogout.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnlogout.setForeground(new java.awt.Color(255, 255, 255));
        btnlogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Disconnect.png"))); // NOI18N
        btnlogout.setText("LOG OUT");
        btnlogout.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnlogout.setBorderPainted(false);
        btnlogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlogoutActionPerformed(evt);
            }
        });

        btnlogout1.setBackground(new java.awt.Color(204, 0, 0));
        btnlogout1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnlogout1.setForeground(new java.awt.Color(255, 255, 255));
        btnlogout1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Exit.png"))); // NOI18N
        btnlogout1.setText("Tho??t");
        btnlogout1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnlogout1.setBorderPainted(false);
        btnlogout1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlogout1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSanPham, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncCuaHang, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(88, 88, 88))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnQLCv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBanHang1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnkhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnQLNSX, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnlogout, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(561, Short.MAX_VALUE)
                    .addComponent(btnlogout1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(8, 8, 8)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnlogout, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQLNSX, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBanHang1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btncCuaHang, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQLCv, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnkhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(275, Short.MAX_VALUE)
                    .addComponent(btnlogout1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(20, 20, 20)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanVienActionPerformed
        // TODO add your handling code here:

        if (s1.equals("Kh??ch h??ng")) {
            JOptionPane.showMessageDialog(this, "Ch???c n??ng n??y kh??ng d??nh cho kh??ch h??ng");
        } else {
            this.dispose();
            QLCheck qlc = new QLCheck(s1);
            new JdlNhanVien(this, true, qlc).setVisible(true);
        }
    }//GEN-LAST:event_btnNhanVienActionPerformed

    private void btncCuaHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncCuaHangActionPerformed
        // TODO add your handling code here:
        if (s1.equals("Kh??ch h??ng")) {
            JOptionPane.showMessageDialog(this, "Ch???c n??ng n??y kh??ng d??nh cho kh??ch h??ng");
        } else {
            this.dispose();
            QLCheck qlc = new QLCheck(s1);
            new jdlCuaHang(this, true, qlc).setVisible(true);
        }
    }//GEN-LAST:event_btncCuaHangActionPerformed

    private void btnSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSanPhamActionPerformed
        // TODO add your handling code here:

        if (s1.equals("Kh??ch h??ng")) {
            JOptionPane.showMessageDialog(this, "Ch???c n??ng n??y kh??ng d??nh cho kh??ch h??ng");
        } else {
            this.dispose();
            QLCheck qlc = new QLCheck(s1);
            new jdlSanPham(this, true, qlc).setVisible(true);
        }
    }//GEN-LAST:event_btnSanPhamActionPerformed

    private void btnkhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkhachHangActionPerformed
        // TODO add your handling code here:
        this.dispose();
        QLCheck qlc = new QLCheck(s1);
        new jdlKhachHang(this, true, qlc).setVisible(true);
    }//GEN-LAST:event_btnkhachHangActionPerformed

    private void btnQLCvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLCvActionPerformed
        // TODO add your handling code here:

        if (s1.equals("Kh??ch h??ng")) {
            JOptionPane.showMessageDialog(this, "Ch???c n??ng n??y kh??ng d??nh cho kh??ch h??ng");
        } else {
            this.dispose();
            QLCheck qlc = new QLCheck(s1);
            new jdlChucVu(this, true, qlc).setVisible(true);
        }
    }//GEN-LAST:event_btnQLCvActionPerformed

    private void btnBanHang1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBanHang1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        QLCheck qlc = new QLCheck(s1);
        new jdlMuaHang(qlc).setVisible(true);
    }//GEN-LAST:event_btnBanHang1ActionPerformed

    private void btnQLNSXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLNSXActionPerformed
        // TODO add your handling code here:
        if (s1.equals("Kh??ch h??ng")) {
            JOptionPane.showMessageDialog(this, "Ch???c n??ng n??y kh??ng d??nh cho kh??ch h??ng");
        } else {
            this.dispose();
            QLCheck qlc = new QLCheck(s1);
            new jdlQLNSX(this, true, qlc).setVisible(true);
        }
    }//GEN-LAST:event_btnQLNSXActionPerformed

    private void btnlogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlogoutActionPerformed
        // TODO add your handling code here:
        if(s1.equals("Kh??ch H??ng")){
            JOptionPane.showMessageDialog(this, "Xin ch??o qu?? kh??ch");
        }else{
            JOptionPane.showMessageDialog(this, "Log Out complete");
            this.dispose();
            new LoginView().setVisible(true);
            s1 = "";
        }
    }//GEN-LAST:event_btnlogoutActionPerformed

    private void btnlogout1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlogout1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnlogout1ActionPerformed

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
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBanHang1;
    private javax.swing.JButton btnNhanVien;
    private javax.swing.JButton btnQLCv;
    private javax.swing.JButton btnQLNSX;
    private javax.swing.JButton btnSanPham;
    private javax.swing.JButton btncCuaHang;
    private javax.swing.JButton btnkhachHang;
    private javax.swing.JButton btnlogout;
    private javax.swing.JButton btnlogout1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPopupMenu jPopupMenu1;
    // End of variables declaration//GEN-END:variables
}
