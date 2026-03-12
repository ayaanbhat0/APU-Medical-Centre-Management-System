package Manager;

import javax.swing.*;

public class ManagerApp extends JFrame {
    public ManagerApp(String managerName) {
        setTitle("APU Medical Centre - Manager");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblTitle = new JLabel("APU Medical Centre - Manager", JLabel.CENTER);
        lblTitle.setBounds(100, 20, 400, 40);
        lblTitle.setFont(lblTitle.getFont().deriveFont(22.0f));
        add(lblTitle);

        JButton btnManageManagers = new JButton("Manage Managers");
        btnManageManagers.setBounds(60, 80, 200, 50);
        add(btnManageManagers);

        JButton btnManageStaff = new JButton("Manage Staff");
        btnManageStaff.setBounds(320, 80, 200, 50);
        add(btnManageStaff);

        JButton btnManageDoctors = new JButton("Manage Doctors");
        btnManageDoctors.setBounds(60, 160, 200, 50);
        add(btnManageDoctors);

        JButton btnAppointments = new JButton("View Appointments");
        btnAppointments.setBounds(320, 160, 200, 50);
        add(btnAppointments);

        JButton btnFeedback = new JButton("View Feedback");
        btnFeedback.setBounds(60, 240, 200, 50);
        add(btnFeedback);

        JButton btnReport = new JButton("Generate Report");
        btnReport.setBounds(320, 240, 200, 50);
        add(btnReport);

        btnManageManagers.addActionListener(e -> new CRUDFrame("Managers", "txtfiles/manager.txt"));
        btnManageStaff.addActionListener(e -> new CRUDFrame("Staff", "txtfiles/staff.txt"));
        btnManageDoctors.addActionListener(e -> new CRUDFrame("Doctors", "txtfiles/doctor.txt"));
        btnAppointments.addActionListener(e -> new ViewFileFrame("Appointments", "txtfiles/appointments.txt"));
        btnFeedback.addActionListener(e -> new ViewFileFrame("Feedback", "txtfiles/DoctorChargesAndFeedback.txt"));
        btnReport.addActionListener(e -> new ReportFrame());
        
        setVisible(true);
    }

    public static void main(String[] args) {
        new ManagerApp("adam321");
    }
}