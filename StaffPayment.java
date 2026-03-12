package Manager;

import javax.swing.*;
import java.io.*;

public class ViewFileFrame extends JFrame {
    public ViewFileFrame(String title, String fileName) {
        super(title);
        setSize(500, 400);
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane);
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                textArea.append(line + "\n");
            }
        } catch (Exception e) {
            textArea.setText("Error loading file: " + e.getMessage());
        }
        setVisible(true);
    }
}