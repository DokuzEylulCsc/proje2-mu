package mu.Project.Models;

import javax.swing.table.DefaultTableModel;
import java.util.Vector;

/**
 * Read-only DefaultTableModel.
 */
public class CustomTableModel extends DefaultTableModel {

    public CustomTableModel(Vector<Vector<Object>> rows, Vector<String> columnNames) {
        super(rows, columnNames);
    }

    /**
     * Make table read-only.
     */
    @Override
    public boolean isCellEditable(int x, int y) {
        return false;
    }
}
