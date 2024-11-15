package KiemtraTH;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Comparator;
import java.util.List;

/**
 * @author Admin
 */
public class MainForm extends javax.swing.JFrame {
    private List<MonHoc>      danhSachMonHoc;

    public MainForm() {
        initComponents();
        danhSachMonHoc = FileManager.readFromFile();
        LoadTable();

    }
    private void LoadTable()
    {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        for (MonHoc mh : danhSachMonHoc) {
            model.addRow(new Object[]{mh.getMaMonHoc(), mh.getTenMonHoc(), mh.getSoTinChi(), mh.getLoaiMonHoc()});
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        sapxeptheo = new javax.swing.JButton();
        btnTimkiem = new javax.swing.JButton();
        cbSapxep = new javax.swing.JComboBox<>();
        txtFieldTimkiem = new javax.swing.JTextField();


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "Ma", "Ten", "SoTinCHi", "LoaiMonHoc"
                }
        ));
        jScrollPane1.setViewportView(table);

        btnThem.setText("Them");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setText("Xoa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int index = table.getSelectedRow();
                if (index >= 0) {
                    danhSachMonHoc.remove(index);
                    LoadTable(); // Cập nhật lại bảng
                }
            }
        });

        btnSua.setText("Sua");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int index = table.getSelectedRow();
                if (index >= 0) {
                    MonHoc monHoc = danhSachMonHoc.get(index);
                    SuaDialog suaDialog = new SuaDialog(MainForm.this, monHoc);
                    suaDialog.setVisible(true);

                    MonHoc monHocSua = suaDialog.getMonHocSua();
                    if (monHocSua != null) {
                        danhSachMonHoc.set(index, monHocSua);
                        LoadTable(); // Cập nhật lại bảng
                    }
                }
            }
        });

        btnLuu.setText("Luu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FileManager.saveToFile(danhSachMonHoc);
            }
        });

        sapxeptheo.setText("Sap xep theo");
        sapxeptheo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sapxeptheoActionPerformed(evt);
            }
        });

        btnTimkiem.setLabel("Timkiem:");

        cbSapxep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Tenmon", "TinChi"}));

        txtFieldTimkiem.setText("jTextField1");
        txtFieldTimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldTimkiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(btnThem)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnXoa)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnSua)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnLuu))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(sapxeptheo)
                                                .addGap(5, 5, 5)
                                                .addComponent(cbSapxep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnTimkiem)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtFieldTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(142, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnThem)
                                        .addComponent(btnXoa)
                                        .addComponent(btnSua)
                                        .addComponent(btnLuu))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(sapxeptheo)
                                        .addComponent(btnTimkiem)
                                        .addComponent(cbSapxep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtFieldTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(67, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void txtFieldTimkiemActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void sapxeptheoActionPerformed(java.awt.event.ActionEvent evt) {
        // Lấy tiêu chí sắp xếp từ JComboBox
        String tieuChi = (String) cbSapxep.getSelectedItem();

        // Sắp xếp danh sách môn học dựa trên tiêu chí
        switch (tieuChi) {
            case "Tenmon":
                danhSachMonHoc.sort(Comparator.comparing(MonHoc::getTenMonHoc));
                break;
            case "TinChi":
                danhSachMonHoc.sort(Comparator.comparingInt(MonHoc::getSoTinChi));
                break;
            default:
                JOptionPane.showMessageDialog(this, "Tiêu chí không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
        }

        // Cập nhật bảng hiển thị
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Xóa dữ liệu cũ trong bảng
        for (MonHoc mh : danhSachMonHoc) {
            model.addRow(new Object[]{mh.getId(), mh.getTenMonHoc(), mh.getSoTinChi(), mh.getLoaiMonHoc()});
        }

        JOptionPane.showMessageDialog(this, "Sắp xếp thành công theo: " + tieuChi, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }


    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {
        int nextMaMonHoc = getNextMaMonHoc();
        ThemDialog themDialog = new ThemDialog(this, nextMaMonHoc);
        themDialog.setVisible(true);

        MonHoc monHocMoi = themDialog.getMonHocMoi();
        if (monHocMoi != null) {
            danhSachMonHoc.add(monHocMoi);
            LoadTable(); // Cập nhật lại bảng
        }
    }


    //others
    private int getNextMaMonHoc() {
        return danhSachMonHoc.stream()
                .mapToInt(MonHoc::getId)
                .max()
                .orElse(0) + 1;
    }

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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton           btnLuu;
    private javax.swing.JButton           btnSua;
    private javax.swing.JButton           btnThem;
    private javax.swing.JButton           btnTimkiem;
    private javax.swing.JButton           btnXoa;
    private javax.swing.JComboBox<String> cbSapxep;
    private javax.swing.JScrollPane       jScrollPane1;
    private javax.swing.JButton           sapxeptheo;
    private javax.swing.JTable            table;
    private javax.swing.JTextField        txtFieldTimkiem;
    // End of variables declaration
}
