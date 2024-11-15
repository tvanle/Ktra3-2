package KiemtraTH;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThemDialog extends JDialog {
    private JTextField txtMaMonHoc;
    private JTextField txtTenMonHoc;
    private JTextField txtSoTinChi;
    private JComboBox<String> cbLoaiMonHoc;
    private JButton btnLuu;
    private JButton btnHuy;
    private MonHoc monHocMoi;


    public ThemDialog(JFrame parent, int nextMaMonHoc) {
        super(parent, "Thêm Môn Học", true);
        setLayout(null);
        setSize(400, 300);
        setLocationRelativeTo(parent);

        JLabel lblMaMonHoc = new JLabel("Mã Môn Học:");
        lblMaMonHoc.setBounds(20, 20, 100, 30);
        add(lblMaMonHoc);

        txtMaMonHoc = new JTextField(String.valueOf(nextMaMonHoc)); // Gán mã tự động tăng
        txtMaMonHoc.setBounds(150, 20, 200, 30);
        txtMaMonHoc.setEditable(false); // Không cho phép chỉnh sửa mã
        add(txtMaMonHoc);

        JLabel lblTenMonHoc = new JLabel("Tên Môn Học:");
        lblTenMonHoc.setBounds(20, 70, 100, 30);
        add(lblTenMonHoc);

        txtTenMonHoc = new JTextField();
        txtTenMonHoc.setBounds(150, 70, 200, 30);
        add(txtTenMonHoc);

        JLabel lblSoTinChi = new JLabel("Số Tín Chỉ:");
        lblSoTinChi.setBounds(20, 120, 100, 30);
        add(lblSoTinChi);

        txtSoTinChi = new JTextField();
        txtSoTinChi.setBounds(150, 120, 200, 30);
        add(txtSoTinChi);

        JLabel lblLoaiMonHoc = new JLabel("Loại Môn Học:");
        lblLoaiMonHoc.setBounds(20, 170, 100, 30);
        add(lblLoaiMonHoc);

        cbLoaiMonHoc = new JComboBox<>(new String[]{"Lý Thuyết", "Thực Hành"});
        cbLoaiMonHoc.setBounds(150, 170, 200, 30);
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
                    String ma = txtMaMonHoc.getText().trim(); // Mã môn học (không thể sửa)
                    String ten = txtTenMonHoc.getText().trim(); // Tên môn học
                    String soTinChiText = txtSoTinChi.getText().trim(); // Số tín chỉ (chuỗi để kiểm tra)
                    String loai = (String) cbLoaiMonHoc.getSelectedItem(); // Loại môn học

                    // Kiểm tra dữ liệu
                    if (ten.isEmpty() || soTinChiText.isEmpty()) {
                        JOptionPane.showMessageDialog(ThemDialog.this, "Vui lòng nhập đầy đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
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
                        JOptionPane.showMessageDialog(ThemDialog.this, "Số tín chỉ phải là số nguyên dương!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Tạo môn học mới và đóng form
                    monHocMoi = new MonHoc(ten, soTinChi, loai);
                    monHocMoi.setId(Integer.parseInt(ma)); // Gán mã môn học
                    JOptionPane.showMessageDialog(ThemDialog.this, "Thêm môn học thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

                    dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(ThemDialog.this, "Đã xảy ra lỗi: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnHuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                monHocMoi = null;
                dispose();
            }
        });
    }

    public MonHoc getMonHocMoi() {
        return monHocMoi;
    }

}