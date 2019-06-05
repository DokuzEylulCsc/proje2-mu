package mu.Project.Models;

import mu.Project.Logger;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;

public class TableUtility {
    final static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Builds and returns a table model with buildTableModelData and getColumnNames.
     */
    public static CustomTableModel buildTableModel(ResultSet resultSet) throws SQLException {
        Logger.getInstance().addLog(String.valueOf(resultSet.isClosed()));

        // SQLite support only TYPE_FORWARD_ONLY pointer
        // First look at column names to not get inconsistent internal state i.e SQLException
        Vector<String> columnNames = getColumnNames(resultSet);
        Vector<Vector<Object>> tableModelData = buildTableModelData(resultSet);

        return new CustomTableModel(tableModelData, columnNames);
    }

    /**
     * Format first 2 column with given DateFormat.
     */
    public static CustomTableModel buildTableModelWithFormattedDates(ResultSet resultSet, DateFormat newDateFormat)
            throws SQLException {

        Vector<String> columnNames = getColumnNames(resultSet);
        Vector<Vector<Object>> tableModelData = buildTableModelData(resultSet);

        try {
            for (int i = 0; i < tableModelData.size(); i++) {
                tableModelData.get(i).set(0, newDateFormat.format(dateFormat.parse((String) tableModelData.get(i).get(0))));
                tableModelData.get(i).set(1, newDateFormat.format(dateFormat.parse((String) tableModelData.get(i).get(1))));
            }
        } catch (ParseException e) {
            Logger.getInstance().addLog("Couldn't parse dates from database for reservedTable.");
            Logger.getInstance().addLog(e);
        }

        return new CustomTableModel(tableModelData, columnNames);
    }

    public static Vector<String> getColumnNames(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();

        Vector<String> columnNames = new Vector<>();
        for (int i = 1; i <= metaData.getColumnCount(); i++) {
            columnNames.add(metaData.getColumnName(i));
        }

        return columnNames;
    }

    /**
     * Acquire rows from a ResultSet and return.
     */
    public static Vector<Vector<Object>> buildTableModelData(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();

        Vector<Vector<Object>> rows = new Vector<Vector<Object>>();
        while (resultSet.next()) {
            Vector<Object> row = new Vector<Object>();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                row.add(resultSet.getObject(i));
            }
            rows.add(row);
        }

        return rows;
    }
}
