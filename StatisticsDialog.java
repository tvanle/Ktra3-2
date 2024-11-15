package KiemtraTH;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StatisticsDialog extends JDialog {
    private JTextArea txtStatistics;

    public StatisticsDialog(JFrame parent, List<MonHoc> danhSachMonHoc) {
        super(parent, "Statistics", true);
        setLayout(new BorderLayout()); // Use BorderLayout for better control

        // Group by subject type (LoaiMonHoc)
        Map<String, List<MonHoc>> groupedByType = danhSachMonHoc.stream()
                .collect(Collectors.groupingBy(MonHoc::getLoaiMonHoc));

        // Create a JTextArea to display statistics (to show multi-line text)
        txtStatistics = new JTextArea();
        txtStatistics.setEditable(false);
        txtStatistics.setFont(new Font("Monospaced", Font.PLAIN, 12)); // Monospaced font for readability

        // Loop through the grouped subjects and calculate statistics for each type
        StringBuilder statsText = new StringBuilder();
        for (Map.Entry<String, List<MonHoc>> entry : groupedByType.entrySet()) {
            String loaiMonHoc = entry.getKey();
            List<MonHoc> subjects = entry.getValue();

            int totalSubjects = subjects.size();
            int totalCredits = subjects.stream().mapToInt(MonHoc::getSoTinChi).sum();

            statsText.append("Loai: ").append(loaiMonHoc)
                    .append("\nTong TinChi: ").append(totalCredits)
                    .append("\n\n"); // Add spacing between different subject types
        }

        // Set the text in the JTextArea
        txtStatistics.setText(statsText.toString());

        // Add the JTextArea to the dialog
        add(new JScrollPane(txtStatistics), BorderLayout.CENTER);

        // Set the dialog size and position
        setSize(400, 300); // Adjust as needed
        setLocationRelativeTo(parent);
    }
}
