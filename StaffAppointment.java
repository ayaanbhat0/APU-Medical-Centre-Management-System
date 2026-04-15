package Manager;

import javax.swing.*;
import java.io.*;

public class CRUDFrame extends JFrame {
    private String fileName;
    private DefaultListModel<String> model = new DefaultListModel<>();
    private JList<String> list = new JList<>(model);

    public CRUDFrame(String title, String fileName) {
        super(title);
        this.fileName = fileName;
        setSize(500, 400);
        setLayout(null);

        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setBounds(20, 20, 300, 300);
        add(scrollPane);

        JButton btnAdd = new JButton("Add");
        btnAdd.setBounds(350, 40, 100, 30);
        add(btnAdd);

        JButton btnEdit = new JButton("Edit");
        btnEdit.setBounds(350, 90, 100, 30);
        add(btnEdit);

        JButton btnDelete = new JButton("Delete");
        btnDelete.setBounds(350, 140, 100, 30);
        add(btnDelete);

        loadData();

        btnAdd.addActionListener(e -> {
            String data = JOptionPane.showInputDialog(this, "Enter CSV line (ID,Username,Password,Gender,Email,Phone,Age):");
            if (data != null && !data.isEmpty()) {
                model.addElement(data);
                saveData();
            }
        });

        btnEdit.addActionListener(e -> {
            int idx = list.getSelectedIndex();
            if (idx >= 0) {
                String data = JOptionPane.showInputDialog(this, "Edit CSV line:", model.get(idx));
                if (data != null && !data.isEmpty()) {
                    model.set(idx, data);
                    saveData();
                }
            }
        });

        btnDelete.addActionListener(e -> {
            int idx = list.getSelectedIndex();
            if (idx >= 0) {
                model.remove(idx);
                saveData();
            }
        });

        setVisible(true);
    }

    private void loadData() {
        model.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                model.addElement(line);
            }
        } catch (Exception e) { }
    }

    private void saveData() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, false))) {
            for (int i = 0; i < model.getSize(); i++) {
                bw.write(model.get(i));
                bw.newLine();
            }
        } catch (Exception e) { }
    }
}