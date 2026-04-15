package Manager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataStore {

    public static void addManager(String username, String password, String gender, String email, String phone, String age) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("ManagerProfile.txt", true))) {
            String line = username + "," + password + "," + gender + "," + email + "," + phone + "," + age;
            bw.write(line);
            bw.newLine();
        } catch (Exception e) { }
    }

    public static String[] getAllManagers() {
        List<String> managers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("ManagerProfile.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                managers.add(line);
            }
        } catch (Exception e) { }
        return managers.toArray(new String[0]);
    }

    // For update and delete, you read all lines, modify as needed, then overwrite the file.
    public static void updateManager(String username, String newLine) {
        List<String> managers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("ManagerProfile.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(username)) {
                    managers.add(newLine); // updated info
                } else {
                    managers.add(line);
                }
            }
        } catch (Exception e) { }
        // Write back
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("ManagerProfile.txt", false))) {
            for (String s : managers) {
                bw.write(s);
                bw.newLine();
            }
        } catch (Exception e) { }
    }

    public static void deleteManager(String username) {
        List<String> managers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("ManagerProfile.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (!parts[0].equals(username)) {
                    managers.add(line);
                }
            }
        } catch (Exception e) { }
        // Write back
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("ManagerProfile.txt", false))) {
            for (String s : managers) {
                bw.write(s);
                bw.newLine();
            }
        } catch (Exception e) { }
    }
}