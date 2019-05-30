package mu.Project.Models;

import mu.Project.Connector;
import mu.Project.Logger;
import mu.Project.NotImplementedException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomType implements Model {
    private Integer id;
    final private String type_name;
    final private Integer hotel_id;
    public Integer price;
    final public Integer sea_view;
    final public Integer safe;
    final public Integer double_bed;
    final public Integer single_bed;
    final public Integer air_conditioner_count;
    final public Integer minibar_count;
    final public Integer television_count;
    public String extra_services;

    final static String creationQuery = "SELECT id, type_name, hotel_id, price, sea_view, safe, double_bed, " +
            "single_bed, air_conditioner_count, minibar_count, television_count, extra_services " +
            "FROM room_types WHERE hotel_id = ?";


    // TODO : Write SQL statements below
    final static String saveOrInsertStatement = "";
    final static String deleteStatement = "";


    private RoomType(Integer id, String type_name, Integer hotel_id, Integer price, Integer sea_view, Integer safe,
                     Integer double_bed, Integer single_bed, Integer air_conditioner_count, Integer minibar_count,
                     Integer television_count, String extra_services) {

        this.id = id;
        this.type_name = type_name;
        this.hotel_id = hotel_id;
        this.price = price;
        this.sea_view = sea_view;
        this.safe = safe;
        this.double_bed = double_bed;
        this.single_bed = single_bed;
        this.air_conditioner_count = air_conditioner_count;
        this.minibar_count = minibar_count;
        this.television_count = television_count;
        this.extra_services = extra_services;
    }

    /**
     * Initialize all room types in the given hotel, and return them as a List.
     *
     * @param hotel_id Integer
     * @return List of RoomType objects
     */
    public static List<RoomType> getRoomTypes(Integer hotel_id) {
        List<RoomType> result = new ArrayList<>();

        try (PreparedStatement preparedStatement = Connector.getInstance().getConnection().prepareStatement(creationQuery)) {
            preparedStatement.setInt(1, hotel_id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                result.add(new RoomType(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4),
                        resultSet.getInt(5),
                        resultSet.getInt(6),
                        resultSet.getInt(7),
                        resultSet.getInt(8),
                        resultSet.getInt(9),
                        resultSet.getInt(10),
                        resultSet.getInt(11),
                        resultSet.getString(12)

                ));
            }
        } catch (SQLException e) {
            Logger.getInstance().addLog(e);
        }

        return result;
    }

    public Boolean hasSeaView() {
        return sea_view == 1;
    }

    public void save() {
        throw new NotImplementedException();
    }

    public void delete() {
        throw new NotImplementedException();
    }

    @Override
    public String toString() {
        throw new NotImplementedException();

        // return String.format("Price: %d, ")
    }
}
