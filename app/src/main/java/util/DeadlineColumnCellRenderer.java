/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.awt.Color;
import java.awt.Component;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import model.Task;

/**
 *
 * @author Fábio Vieira
 */
public class DeadlineColumnCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label;
        label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        label.setHorizontalAlignment(CENTER);

        TaskTabelModel taskModel = (TaskTabelModel) table.getModel();
        Task task = taskModel.getTasks().get(row);

        if (task.getDeadline().after(new Date())) {
            label.setBackground(Color.GREEN);
            label.setForeground(Color.BLACK);
        }else{
            label.setBackground(Color.RED);
            label.setForeground(Color.BLACK);
        }

        return label;
    }

}
