package mu.Project.Models;

import mu.Project.Connector;
import mu.Project.Logger;
import mu.Project.NotImplementedException;

import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

// TODO: Complete javadocs
public class Reservation implements Model {

    private final static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private final static String reserveRoomSQL = "INSERT INTO reservations (room_id, account_id, person_count,\n" +
            "start_date, end_date)\n" +
            "VALUES ((SELECT id FROM rooms WHERE room_number = ? AND hotel_id = (SELECT id FROM hotels WHERE name = ?)),\n" +
            "(SELECT id FROM accounts WHERE email = ?), ?, ?, ?)";

    private final static String getReservedRoomsQuery = "SELECT reservations.start_date, reservations.end_date,\n" +
            "hotels.name, hotels.stars, room_type.type_name, rooms.room_number, room_type.price,\n" +
            "room_type.double_bed * 2 + room_type.single_bed, room_type.sea_view, room_type.safe, room_type.air_conditioner_count,\n" +
            "room_type.television_count, room_type.minibar_count, room_type.extra_services_description FROM reservations\n" +
            "INNER JOIN rooms ON (rooms.id = reservations.room_id)\n" +
            "INNER JOIN hotels ON (hotels.id = rooms.hotel_id)\n" +
            "INNER JOIN room_type ON (room_type.id = rooms.room_type_id)\n" +
            "INNER JOIN accounts ON (reservations.account_id = accounts.id)\n" +
            "WHERE accounts.email = ?\n" +
            "ORDER BY reservations.start_date DESC";

    /**
     *
     * @param model
     * @param hotel_name
     * @param room_number
     * @param person_count
     * @param startDate
     * @param endDate
     * @throws SQLException
     */
    public static void reserveRoom(Account model, String hotel_name, Integer room_number, Integer person_count,
                                   Date startDate, Date endDate) throws SQLException {

        PreparedStatement preparedStatement = Connector.getInstance().prepareStatement(reserveRoomSQL);
        preparedStatement.setInt(1, room_number);
        preparedStatement.setString(2, hotel_name);
        preparedStatement.setString(3, model.getEmail());
        preparedStatement.setInt(4, person_count);
        preparedStatement.setString(5, dateFormat.format(startDate));
        preparedStatement.setString(6, dateFormat.format(endDate));

        preparedStatement.executeUpdate();
    }

    /**
     *
     * @param email
     * @return
     */
    public static DefaultTableModel getReservedRoomsAsTableModel(String email) {
        DefaultTableModel tableModel = null;
        try (PreparedStatement preparedStatement = Connector.getInstance().prepareStatement(getReservedRoomsQuery)) {
            preparedStatement.setString(1, email);

            tableModel = Room.buildTableModel(preparedStatement.executeQuery());

        } catch (SQLException e) {
            Logger.getInstance().addLog(e);
        }
        return tableModel;
    }

    public void save() {
        throw new NotImplementedException();
    }

    public void delete() {
        throw new NotImplementedException();
    }
}
