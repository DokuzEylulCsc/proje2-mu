package mu.Project.Models;

import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class ReservationTableModel extends DefaultTableModel {
    private static Vector<String> columnNames = new Vector<>() {{
        add("Hotel Name");
        add("Stars");
        add("Room Type");
        add("Room Number");
        add("Daily Price");
        add("Bed Space");
        add("Sea View");
        add("Safe");
        add("Air Conditioners");
        add("Televisions");
        add("Minibars");
        add("Extra Services");
    }};

    public ReservationTableModel(Vector<Vector<Object>> data) {
        super(data, columnNames);
    }

    /**
     * Make table read-only.
     */
    @Override
    public boolean isCellEditable(int x, int y) {
        return false;
    }

}
