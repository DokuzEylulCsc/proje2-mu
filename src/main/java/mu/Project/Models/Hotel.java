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
    private String name;
    private Integer stars;
    private String city;
    private String type;

    private final static String distinctCitiesQuery = "SELECT DISTINCT city FROM hotels";

    public static List<String> getDistinctCities() {
        try (PreparedStatement statement = Connector.getInstance().prepareStatement(distinctCitiesQuery)) {
            List<String> result = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                result.add(resultSet.getString(1));
            }
            return result;

        } catch (SQLException e) {
            Logger.getInstance().addLog(e);
        }

        return null;
    }

    public void save() {
        throw new NotImplementedException();
    }

    public void delete() {
        throw new NotImplementedException();
    }
}
