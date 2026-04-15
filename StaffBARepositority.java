package Manager;

import java.io.*;
import javax.swing.*;

public class DoctorProfileSaver {
    public static void saveProfile(String username, String password, String gender, String email, String phone, String age) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("DoctorProfile.txt", true))) {
            String line = username + "," + password + "," + gender + "," + email + "," + phone + "," + age;
            bw.write(line);
            bw.newLine();
            JOptionPane.showMessageDialog(null, "Profile updated successfully!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving profile: " + e.getMessage());
        }
    }
}