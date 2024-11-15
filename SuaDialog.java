package KiemtraTH;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SuaDialog extends JDialog {
    private JTextField txtMaMonHoc;
    private JTextField txtTenMonHoc;
    private JTextField txtSoTinChi;
    private JComboBox<String> cbLoaiMonHoc;
    private JButton btnLuu;
    private JButton btnHuy;
    private MonHoc monHocSua;

    public SuaDialog(JFrame parent, MonHoc monHoc) {
        super(parent, "Sửa Môn Học", true);
        setLayout(null);
        setSize(400, 300);
        setLocationRelativeTo(parent);

        JLabel lblMaMonHoc = new JLabel("Mã Môn Học:");
        lblMaMonHoc.setBounds(20, 20, 100, 30);
        add(lblMaMonHoc);

        txtMaMonHoc = new JTextField(String.valueOf(monHoc.getId()));
        txtMaMonHoc.setBounds(150, 20, 200, 30);
        txtMaMonHoc.setEditable(false); // Không cho phép sửa mã môn học
        add(txtMaMonHoc);

        JLabel lblTenMonHoc = new JLabel("Tên Môn Học:");
        lblTenMonHoc.setBounds(20, 70, 100, 30);
        add(lblTenMonHoc);

        txtTenMonHoc = new JTextField(monHoc.getTenMonHoc());
        txtTenMonHoc.setBounds(150, 70, 200, 30);
        add(txtTenMonHoc);

        JLabel lblSoTinChi = new JLabel("Số Tín Chỉ:");
        lblSoTinChi.setBounds(20, 120, 100, 30);
        add(lblSoTinChi);

        txtSoTinChi = new JTextField(String.valueOf(monHoc.getSoTinChi()));
        txtSoTinChi.setBounds(150, 120, 200, 30);
        add(txtSoTinChi);

        JLabel lblLoaiMonHoc = new JLabel("Loại Môn Học:");
        lblLoaiMonHoc.setBounds(20, 170, 100, 30);
        add(lblLoaiMonHoc);

        cbLoaiMonHoc = new JComboBox<>(new String[]{"Lý Thuyết", "Thực Hành"});
        cbLoaiMonHoc.setBounds(150, 170, 200, 30);
        cbLoaiMonHoc.setSelectedItem(monHoc.getLoaiMonHoc()); // Đặt loại môn học hiện tại
        add(cbLoaiMonHoc);

        btnLuu = new JButton("Lưu");
        btnLuu.setBounds(80, 220, 100, 30);
        add(btnLuu);

        btnHuy = new JButton("Hủy");
        btnHuy.setBounds(200, 220, 100, 30);
        add(btnHuy);

        btnLuu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Lấy dữ liệu từ các trường nhập liệu
                    String ten = txtTenMonHoc.getText().trim();
                    String soTinChiText = txtSoTinChi.getText().trim();
                    String loai = (String) cbLoaiMonHoc.getSelectedItem();

                    // Kiểm tra dữ liệu
                    if (ten.isEmpty() || soTinChiText.isEmpty()) {
                        JOptionPane.showMessageDialog(SuaDialog.this, "Vui lòng nhập đầy đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Kiểm tra số tín chỉ có phải là số hợp lệ không
                    int soTinChi;
                    try {
                        soTinChi = Integer.parseInt(soTinChiText);
                        if (soTinChi <= 0) {
                            throw new NumberFormatException("Số tín chỉ phải lớn hơn 0.");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(SuaDialog.this, "Số tín chỉ phải là số nguyên dương!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Cập nhật thông tin môn học
                    monHoc.setTenMonHoc(ten);
                    monHoc.setSoTinChi(soTinChi);
                    monHoc.setLoaiMonHoc(loai);

                    JOptionPane.showMessageDialog(SuaDialog.this, "Cập nhật môn học thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    monHocSua = monHoc;
                    dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(SuaDialog.this, "Đã xảy ra lỗi: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnHuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                monHocSua = null;
                dispose();
            }
        });
    }

    public MonHoc getMonHocSua() {
        return monHocSua;
    }
}
