package Staff;

import javax.swing.*;
import java.io.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

public class StaffAppointmentPage extends JFrame {
    private JTable doctorTable, customerTable;
    private DefaultTableModel doctorModel, customerModel;
    private JComboBox<String> doctorCombo, customerCombo, comboYear, comboMonth, comboDay, comboHour, comboMinute;

    private JButton btnSave, btnDelete, btnBack;
    private List<StaffCP> customers;
    private List<StaffAppointment> appointment;

    private String name;

    private final StaffMCPRepository customerRepo = new StaffMCPRepository("txtfiles/customer.txt");
    private final StaffBARepositority apptRepo = new StaffBARepositority("txtfiles/appointments.txt");


    public StaffAppointmentPage(String name) {
        this.name = name;
        setTitle("Staff - Appointment Booking");
        setSize(1500, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        //Display
        JLabel lblTitle = new JLabel("Appointment Booking");
        lblTitle.setBounds(20, 10, 400, 30);
        add(lblTitle);

        // Doctor Table
        String[] dColumns = {"DoctorID", "Doctor Name", "Scheduled Appointment Time", "Phone"};
        doctorModel = new DefaultTableModel(dColumns, 0);
        doctorTable = new JTable(doctorModel);
        JScrollPane dScroll = new JScrollPane(doctorTable);
        dScroll.setBounds(20, 50, 700, 200);
        add(dScroll);

        // Customer Table
        String[] cColumns = {"CustomerID", "Customer Name", "Scheduled Appointment Time", "Phone"};
        customerModel = new DefaultTableModel(cColumns, 0);
        customerTable = new JTable(customerModel);
        JScrollPane cScroll = new JScrollPane(customerTable);
        cScroll.setBounds(750, 50, 700, 200);
        add(cScroll);

        // Input Data
        JLabel lblCID = new JLabel("Customer ID:");
        lblCID.setBounds(20, 265, 100, 25);
        add(lblCID);
        customerCombo = new JComboBox<>();
        customers = customerRepo.getAllData();
        for (StaffCP c : customers){
            customerCombo.addItem(c.GetID());
        }
        customerCombo.setBounds(150, 265, 120, 25);
        add(customerCombo);

        JLabel lblDID = new JLabel("Doctor ID:");
        lblDID.setBounds(20, 305, 100, 25);
        add(lblDID);
        doctorCombo = new JComboBox<>();
        try (Scanner sc = new Scanner(new File("txtfiles/doctor.txt"))){
            while (sc.hasNextLine()){
                String line = sc.nextLine().trim();
                if(!line.isEmpty()){
                    String [] parts = line.split(",");
                    if (parts.length >= 3){
                        doctorCombo.addItem(parts[0]);
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "doctor.txt not found!");
        }
        doctorCombo.setBounds(150, 305, 120, 25);
        add(doctorCombo);

        JLabel lblTime = new JLabel("Appointment Time:");
        lblTime.setBounds(20, 345, 150, 25);
        add(lblTime);
        // Year ComboBox
        comboYear = new JComboBox<>();
        for (int y = 2025; y <= 2030; y++) {
            comboYear.addItem(String.valueOf(y));
        }
        comboYear.setBounds(150, 345, 80, 25);
        add(comboYear);

        // Month ComboBox
        comboMonth = new JComboBox<>();
        for (int m = 1; m <= 12; m++) {
            comboMonth.addItem(String.format("%02d", m));
        }
        comboMonth.setBounds(235, 345, 60, 25);
        add(comboMonth);

        // Day ComboBox
        comboDay = new JComboBox<>();
        for (int d = 1; d <= 31; d++) {
            comboDay.addItem(String.format("%02d", d));
        }
        comboDay.setBounds(300, 345, 60, 25);
        add(comboDay);

        // Hour ComboBox
        comboHour = new JComboBox<>();
        for (int h = 0; h < 24; h++) {
            comboHour.addItem(String.format("%02d", h));
        }
        comboHour.setBounds(365, 345, 60, 25);
        add(comboHour);
        // Minute (0, 30)
        comboMinute = new JComboBox<>();
        for (int m = 0; m < 60; m++) {
            comboMinute.addItem(String.format("%02d", m));
        }
        comboMinute.setBounds(430, 345, 60, 25);
        add(comboMinute);

        //Button
        btnSave = new JButton("Save");
        btnSave.setBounds(1050, 350, 100, 30);
        add(btnSave);

        btnDelete = new JButton("Delete");
        btnDelete.setBounds(1200, 350, 100, 30);
        add(btnDelete);

        btnBack = new JButton("Back");
        btnBack.setBounds(1350, 350, 100, 30);
        add(btnBack);

        loadDoctor("txtfiles/appointment.txt");
        loadCustomer();

        btnSave.addActionListener(e -> saveAppointment());
        
        btnDelete.addActionListener(e -> deleteAppointment());

        btnBack.addActionListener(e -> {
            new StaffPage(name).setVisible(true);
            dispose();
        });
    }

    private void loadCustomer(){
        customerModel.setRowCount(0);

        appointment = apptRepo.getAllData();
        for(StaffAppointment a : appointment){
            customerModel.addRow(new Object[]{a.getCustomerId(),a.getCustomerName(),a.getAppointmentTime(),a.getCustomerPhone()});
        }
    }

    private void loadDoctor(String fileName){
        doctorModel.setRowCount(0);

        appointment = apptRepo.getAllData();
        for(StaffAppointment a : appointment){
            doctorModel.addRow(new Object[]{a.getDoctorId(),a.getDoctorName(),a.getAppointmentTime(),a.getDoctorPhone()});
        }
    }

    private void saveAppointment() {
        String bookingId = (String) apptRepo.generateNextID();
        String customerId = (String) customerCombo.getSelectedItem();
        String doctorId = (String) doctorCombo.getSelectedItem();
        String year = (String) comboYear.getSelectedItem();
        String month = (String) comboMonth.getSelectedItem();
        String day = (String) comboDay.getSelectedItem();
        String hour = (String) comboHour.getSelectedItem();
        String minute = (String)  comboMinute.getSelectedItem();
        String time = year + '-' + month + '-' + day + ' ' + hour + ':' + minute;

        String customerName = "";
        String customerPhone = "";
        customers = customerRepo.getAllData();
        for (StaffCP c : customers){
            if (c.GetID().equals(customerId)){
                    customerName = c.GetName();
                    customerPhone = c.GetPhone();
            }
        }

        String doctorName = "";
        String doctorPhone = "";
        try (Scanner sc = new Scanner(new File("txtfiles/doctor.txt"))){
            while (sc.hasNextLine()){
                String line = sc.nextLine().trim();
                if(!line.isEmpty()){
                    String [] parts = line.split(",");
                    if (parts.length >= 6){
                        doctorName = parts[1];
                        doctorPhone = parts[5];
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "doctor.txt not found!");
        }

        for (StaffAppointment a : apptRepo.getAllData()) {
            if (doctorId.equals(a.getDoctorId()) && time.equals(a.getAppointmentTime())) {
                JOptionPane.showMessageDialog(this, "This doctor is already booked at that time.");
                return;
            }
        }

        StaffAppointment newAppt = new StaffAppointment(
                bookingId, customerId, customerName, customerPhone,
                doctorId, doctorName, doctorPhone,
                time
        );
        apptRepo.addAppointment(newAppt);

        JOptionPane.showMessageDialog(this, "Appointment saved!");
        loadDoctor("txtfiles/doctor.txt");
        loadCustomer();
    }
    
    private void deleteAppointment(){
        String customerId = (String) customerCombo.getSelectedItem();
        String doctorId = (String) doctorCombo.getSelectedItem();
        String year = (String) comboYear.getSelectedItem();
        String month = (String) comboMonth.getSelectedItem();
        String day = (String) comboDay.getSelectedItem();
        String hour = (String) comboHour.getSelectedItem();
        String minute = (String)  comboMinute.getSelectedItem();
        String time = year + '-' + month + '-' + day + ' ' + hour + ':' + minute;
       
        List<StaffAppointment> allAppointments = apptRepo.getAllData();
        StaffAppointment toDelete = null;
        for (StaffAppointment a : allAppointments) {
            if (a.getCustomerId().equals(customerId) &&
                a.getDoctorId().equals(doctorId) &&
                a.getAppointmentTime().equals(time)) {
                toDelete = a;
                break;
            }
        }

        if (toDelete == null) {
            JOptionPane.showMessageDialog(this, "This appointment not exist");
            return;
        }
        
        allAppointments.remove(toDelete);

        try (PrintWriter pw = new PrintWriter(new FileWriter("txtfiles/appointments.txt"))) {
            for (StaffAppointment a : allAppointments) {
                pw.println(a.toFileString());
           }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error deleting appointment: " + ex.getMessage());
        }

        JOptionPane.showMessageDialog(this, "Appointment deleted!");
        loadDoctor("txtfiles/doctor.txt");
        loadCustomer();
    }
}

