package Doctor;


import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import java.awt.Component;

public class Doctor {
    // Method to resize JTable columns
    public static void resizeTable(JTable table) {
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); // enable horizontal scroll

        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 50; // minimum width
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width + 10, width);
            }
            table.getColumnModel().getColumn(column).setPreferredWidth(width);
        }
    }    
}