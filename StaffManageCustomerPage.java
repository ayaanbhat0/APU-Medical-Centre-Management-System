package Manager;

import java.io.*;
import java.util.*;

public class ManagerProfileLoader {
    public static List<String[]> getAllManagers() {
        List<String[]> managers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("txtfiles/anager.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                managers.add(parts);
            }
        } catch (Exception e) { }
        return managers;
    }
}