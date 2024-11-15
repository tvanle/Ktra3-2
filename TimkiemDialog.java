package KiemtraTH;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class TimkiemDialog extends JDialog {

    public TimkiemDialog(JFrame parent, List<MonHoc> resultList) {
        super(parent, "Search", true);

        // Set the layout for the dialog (1 row for the table)
        setLayout(new BorderLayout());

        // Column names for the table
        String[] columnNames = {"Mã môn học", "Tên môn học", "Số tín chỉ", "Loại môn học"};

        // Create a DefaultTableModel with the given column names and data
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // Add the data from resultList to the table model
        for (MonHoc mh : resultList) {
            model.addRow(new Object[]{mh.getMaMonHoc(), mh.getTenMonHoc(), mh.getSoTinChi(), mh.getLoaiMonHoc()});
        }

        // Create a JTable using the model
        JTable table = new JTable(model);

        // Set the table to be scrollable
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the scroll pane with the table to the dialog
        add(scrollPane, BorderLayout.CENTER);

        // Set dialog properties
        setSize(500, 300); // Adjust size as needed
        setLocationRelativeTo(parent); // Center the dialog on the parent frame
    }
}