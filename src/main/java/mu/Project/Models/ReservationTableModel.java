package mu.Project.Models;

import mu.Project.NotImplementedException;

import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class ReservationTableModel extends DefaultTableModel {

    public ReservationTableModel(Vector<Vector<Object>> data, Vector<String> columnNames) {
        super(data, columnNames);
    }

    public Integer getSelectedRoomsId() {
        throw new NotImplementedException();
    }

}
