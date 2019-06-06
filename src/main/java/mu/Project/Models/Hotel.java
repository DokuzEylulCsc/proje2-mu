package mu.Project.Models;

import mu.Project.Connector;
import mu.Project.Logger;
import mu.Project.NotImplementedException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Hotel implements Model {

    private final static String distinctCitiesQuery = "SELECT DISTINCT city FROM hotels";

    public static List<String> getDistinctCities() {
        List<String> result = new ArrayList<>();

        try (PreparedStatement statement = Connector.getInstance().prepareStatement(distinctCitiesQuery)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                result.add(resultSet.getString(1));
            }
            return result;

        } catch (SQLException e) {
            Logger.getInstance().addLog(e);
        }

        return result;
    }
}
