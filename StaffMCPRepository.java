package Manager;

import java.io.*;
import javax.swing.*;

public class ManagerProfileSaver {
    public static void saveProfile(String id, String username, String password, String gender, String email, String phone, String age) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("txtfiles/manager.txt", true))) {
            String line = id + "," + username + "," + password + "," + gender + "," + email + "," + phone + "," + age;
            bw.write(line);
            bw.newLine();
            JOptionPane.showMessageDialog(null, "Manager profile updated successfully!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving profile: " + e.getMessage());
        }
    }
}