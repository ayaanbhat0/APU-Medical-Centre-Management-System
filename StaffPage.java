package Manager;

import javax.swing.*;
import java.io.*;

public class ReportFrame extends JFrame {
    public ReportFrame() {
        super("Report");
        setSize(400, 300);
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        add(new JScrollPane(textArea));

        int managerCount = countLines("txtfiles/manager.txt");
        int staffCount = countLines("txtfiles/staff.txt");
        int doctorCount = countLines("txtfiles/doctor.txt");
        int apptCount = countLines("txtfiles/appointments.txt");
        int feedbackCount = countLines("txtfiles/feedbacks.txt");

        String report = "Managers: " + managerCount +
                "\nStaff: " + staffCount +
                "\nDoctors: " + doctorCount +
                "\nAppointments: " + apptCount +
                "\nFeedbacks: " + feedbackCount;

        textArea.setText(report);
        setVisible(true);
    }

    private int countLines(String fileName) {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while (br.readLine() != null) count++;
        } catch (Exception e) { }
        return count;
    }
}