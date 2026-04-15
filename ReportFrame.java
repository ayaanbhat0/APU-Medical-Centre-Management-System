package LoginPage;
import Customer.Dashboard;
import Doctor.DoctorMainPage;
import Manager.ManagerApp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;
import Staff.StaffPage;

public class loginSystem extends JFrame {
    private JLabel lblTitle, lblName, lblPass, lblRole;
    private JTextField txtName, txtPass;
    private JComboBox comboRole;
    private JButton btnLogin;
    
    private String filename;
    
    public loginSystem(){
        setTitle("Login System");
        setSize(370, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        
        // Title
        lblTitle = new JLabel("APU Medical Centrel (AMC)");
        lblTitle.setBounds(100, 30, 200, 25);
        add(lblTitle);
        
        //User Name
        lblName = new JLabel("Name         :");
        lblName.setBounds(40, 100, 80, 25);
        add(lblName);
        txtName = new JTextField();
        txtName.setBounds(120, 100, 200, 25);
        add(txtName);
        
        //Password
        lblPass = new JLabel("Passworld :  ");
        lblPass.setBounds(40, 135, 80, 25);
        add(lblPass);
        txtPass = new JTextField();
        txtPass.setBounds(120, 135, 200, 25);
        add(txtPass);
        
        //Role
        lblRole = new JLabel("Role           :");
        lblRole.setBounds(40, 170, 80, 25);
        add(lblRole);
        comboRole =new JComboBox(new String[]{"Staff", "Customer", "Doctor", "Manager"});
        comboRole.setBounds(120, 170, 100, 25);
        add(comboRole);
        
        //Button
        btnLogin = new JButton("Login");
        btnLogin.setBounds(150, 250, 70, 25);
        add(btnLogin);
        
        btnLogin.addActionListener(e -> checkLogin());
    }
    
    
    
    public String getUserName(){
        String currentName = txtName.getText();
        return currentName;
    }
    public String getPass(){return txtPass.getText();}
    public String getRole(){return comboRole.getSelectedItem().toString().toLowerCase();}
    public String getFileName(){return getRole()+ ".txt";}

    public void loginCustomer(){
        boolean hasUserName = false;
        try (Scanner sc = new Scanner(new File("txtfiles/customer.txt"))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                String [] parts = line.split(",");
                if (!line.isEmpty()) {
                    String name = parts[1];
                    String pass = parts[2];
                    if (name.equals(getUserName())){
                        hasUserName = true;
                        if (pass.equals(getPass())){
                            JOptionPane.showMessageDialog(this, "Login Successfully");
                            Dashboard dash = new Dashboard();
                            dash.setVisible(true);
                            this.dispose();
                        } else {
                            JOptionPane.showMessageDialog(this, "Password Incorrect");
                        }
                    }
                }
            }
            if (!hasUserName){
                JOptionPane.showMessageDialog(this, "Username not exist");
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, "File not found");
        }
    }
    
    public void loginManager(){
        boolean hasUserName = false;
        try (Scanner sc = new Scanner(new File("txtfiles/manager.txt"))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                String [] parts = line.split(",");
                if (!line.isEmpty()) {
                    String name = parts[1];
                    String pass = parts[2];
                    if (name.equals(getUserName())){
                        hasUserName = true;
                        if (pass.equals(getPass())){
                            JOptionPane.showMessageDialog(this, "Login Successfully");
                            new ManagerApp(getUserName());
                            this.dispose(); // close the login frame
                        } else {
                            JOptionPane.showMessageDialog(this, "Password Incorrect");
                        }
                    }
                }
            }
            if (!hasUserName){
                JOptionPane.showMessageDialog(this, "Username not exist");
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, "File not found");
        }
    }
    
    public void loginStaff(){
        boolean hasUserName = false;
        try (Scanner sc = new Scanner(new File("txtfiles/staff.txt"))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                String [] parts = line.split(",");
                if (!line.isEmpty()) {
                    String name = parts[1];
                    String pass = parts[2];
                    if (name.equals(getUserName())){
                        hasUserName = true;
                        if (pass.equals(getPass())){
                            JOptionPane.showMessageDialog(this, "Login Successfully");
                            new StaffPage(name).setVisible(true);
                            dispose();
                        } else {
                            JOptionPane.showMessageDialog(this, "Password Incorrect");
                        }
                    }
                }
            }
            if (!hasUserName){
                JOptionPane.showMessageDialog(this, "Username not exist");
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, "File not found");
        }
    }
    
    public void loginDoctor(){ 
        boolean hasUserName = false;
        try (Scanner sc = new Scanner(new File("txtfiles/doctor.txt"))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                String [] parts = line.split(",");
                if (!line.isEmpty()) {
                    String name = parts[1];
                    String pass = parts[2];
                    if (name.equals(getUserName())){
                        hasUserName = true;
                        if (pass.equals(getPass())){
                            JOptionPane.showMessageDialog(this, "Login Successfully");
                            DoctorMainPage doctorPage = new DoctorMainPage();
                            doctorPage.setVisible(true);
                            this.dispose();
                        } else {
                            JOptionPane.showMessageDialog(this, "Password Incorrect");
                        }
                    }
                }
            }
            if (!hasUserName){
                JOptionPane.showMessageDialog(this, "Username not exist");
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, "File not found");
        }
    }
    
    public void checkLogin(){
        if (getUserName().isEmpty() || getPass().isEmpty() || getRole().isEmpty()){
            JOptionPane.showMessageDialog(this, "Please fill in all field");
        } else {
            if (getRole().equals("customer")){
                loginCustomer();
            } else if (getRole().equals("manager")) {
                loginManager();
            } else if (getRole().equals("staff")) {
                loginStaff();
            } else if (getRole().equals("doctor")) {
                loginDoctor();
            } 
        }
    }

    public static void main(String[] args) {
        new loginSystem().setVisible(true);
    }   
}