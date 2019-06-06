package mu.Project.Models;

import mu.Project.Connector;
import mu.Project.Logger;
import mu.Project.NotImplementedException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reservation implements Model {

    private final static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private final static String reserveRoomStatement = "INSERT INTO reservations (room_id, account_id, person_count,\n" +
            "start_date, end_date)\n" +
            "VALUES ((SELECT id FROM rooms WHERE room_number = ? AND hotel_id = (SELECT id FROM hotels WHERE name = ?)),\n" +
            "(SELECT id FROM accounts WHERE email = ?), ?, ?, ?)";

    private final static String getReservedRoomsQuery = "SELECT reservations.start_date AS 'Start Date',\n" +
            "reservations.end_date AS 'End Date', reservations.person_count AS 'Person Count', hotels.name AS 'Facility Name',\n" +
            "hotels.type AS 'Facility Type', hotels.stars AS 'Stars', room_type.type_name AS 'Room Type', rooms.room_number AS 'Room Number',\n" +
            "room_type.price AS 'Daily Price', room_type.double_bed * 2 + room_type.single_bed AS 'Bed Space',\n" +
            "room_type.sea_view AS 'Sea View', room_type.safe AS 'Safe', room_type.air_conditioner_count AS 'Air Conditioner',\n" +
            "room_type.television_count AS 'Televisions', room_type.minibar_count AS 'Minibars',\n" +
            "room_type.extra_services_description AS 'Extra Services' FROM reservations\n" +
            "INNER JOIN rooms ON (rooms.id = reservations.room_id)\n" +
            "INNER JOIN hotels ON (hotels.id = rooms.hotel_id)\n" +
            "INNER JOIN room_type ON (room_type.id = rooms.room_type_id)\n" +
            "INNER JOIN accounts ON (reservations.account_id = accounts.id)\n" +
            "WHERE accounts.email = ?\n" +
            "ORDER BY reservations.start_date DESC";

    private final static String deleteReservationStatement = "DELETE FROM reservations\n" +
            "WHERE account_id = (SELECT id FROM accounts WHERE email = ?) AND\n" +
            "start_date = ? AND room_id = (SELECT id FROM rooms \n" +
            "WHERE hotel_id = (SELECT id FROM hotels WHERE name = ?) AND room_number = ?)";

    /**
     * Reserve a room with given parameters.
     *
     * @param model Account
     * @param hotel_name String
     * @param room_number Integer
     * @param person_count Integer
     * @param startDate Date
     * @param endDate Date
     * @throws SQLException from jdbc
     */
    public static void reserveRoom(Account model, String hotel_name, Integer room_number, Integer person_count,
                                   Date startDate, Date endDate) throws SQLException {

        PreparedStatement preparedStatement = Connector.getInstance().prepareStatement(reserveRoomStatement);
        preparedStatement.setInt(1, room_number);
        preparedStatement.setString(2, hotel_name);
        preparedStatement.setString(3, model.getEmail());
        preparedStatement.setInt(4, person_count);
        preparedStatement.setString(5, dateFormat.format(startDate));
        preparedStatement.setString(6, dateFormat.format(endDate));

        preparedStatement.executeUpdate();
    }

    /**
     * Delete a reservation from reservations table.
     *
     * @param account Account
     * @param startDate Date
     * @param hotel_name String
     * @param room_number Integer
     * @throws SQLException from jdbc
     */
    public static void removeReservation(Account account, Date startDate, String hotel_name, Integer room_number)
            throws SQLException {
        PreparedStatement preparedStatement = Connector.getInstance().prepareStatement(deleteReservationStatement);
        preparedStatement.setString(1, account.getEmail());
        preparedStatement.setString(2, dateFormat.format(startDate));
        preparedStatement.setString(3, hotel_name);
        preparedStatement.setInt(4, room_number);

        preparedStatement.executeUpdate();
    }

    /**
     * Return reserved rooms from database with the email.
     * Assumes first 2 column of query are dates, and formats them with newDateFormat.
     *
     * @param email
     * @param newDateFormat
     * @return
     * @see CustomTableModel
     */
    public static CustomTableModel getReservedRoomsAsTableModel(String email, DateFormat newDateFormat) {
        CustomTableModel tableModel = null;

        try (PreparedStatement preparedStatement = Connector.getInstance().prepareStatement(getReservedRoomsQuery)) {
            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();

            tableModel = TableUtility.buildTableModelWithFormattedDates(resultSet, newDateFormat);

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
