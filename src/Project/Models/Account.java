package Project.Models;

import Project.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


class Account implements Model {
    private final Integer id;
    private String email;
    private String password_hash;
    private String name;
    private final Integer admin;

    private static String insertQuery = "INSERT INTO accounts (email, password_hash, name, admin)" +
            "VALUES (?, ?, ?, ?)";

    private static String updateQuery = "UPDATE accounts " +
            "SET email = ?, password_hash = ?,  name = ? " +
            "WHERE id = ? ";

    private static String deleteQuery = "DELETE FROM accounts " +
            "WHERE id = ?";

    /**
     * Boolean represented by 0 or 1.
     *
     * @param id Integer
     * @param email String
     * @param password_hash String
     * @param name String
     * @param admin Integer
     */
    private Account(Integer id, String email, String password_hash, String name, Integer admin) {
        this.id = id;
        this.email = email;
        this.password_hash = password_hash;
        this.name = name;
        this.admin = admin;
    }

    /**
     * Find account in table, if not exists create new.
     * Do not leave id attribute empty.
     *
     * @param email String
     * @param password_hash String
     * @param name String
     * @param admin Integer
     * @return Account
     */
    public static Account createAccount(String email, String password_hash, String name, Integer admin) {

        Account queryResult = getAccount(email);
        if (queryResult == null) {
            try (PreparedStatement pstmt = Connector.getInstance().getConnection().prepareStatement(insertQuery)) {
                pstmt.setString(1, email);
                pstmt.setString(2, password_hash);
                pstmt.setString(3, name);
                pstmt.setInt(4, admin);
                pstmt.execute();

                return getAccount(email);

            } catch (SQLException e) {
                Logger.getInstance().addLog(e);
            }
        }

        return queryResult;
    }

    /**
     * Find account in database by email and return it as Model object.
     *
     * @param email String
     * @return if exists Account else null
     * @see Account
     */
    public static Account getAccount(String email) {

        try (Statement stmt = Connector.getInstance().getConnection().createStatement()){
            String query = String.format("SELECT * FROM accounts WHERE email=%s", email);
            ResultSet rs = stmt.executeQuery(query);

            rs.last();
            if (rs.getRow() == 1) {
                return (
                        new Account(
                                rs.getInt("id"),
                                rs.getString("email"),
                                rs.getString("password_hash"),
                                rs.getString("name"),
                                rs.getInt("admin")
                        )
                );

            } else if (rs.getRow() != 0) {
                Logger.getInstance().addLog("Warning: Project.Models.Account.getAccount found more" +
                        " than 1 row with same email: " + email);
            }

        } catch (SQLException e) {
            Logger.getInstance().addLog(e);
        }

        return null;
    }

    /**
     * Return all records in accounts.
     */
    public static List<Account> queryAll() {

        List<Account> result = new ArrayList<>();
        try (Statement stmt = Connector.getInstance().getConnection().createStatement()){
            String query = "SELECT * FROM accounts";

            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                result.add(
                        new Account(
                                rs.getInt("id"),
                                rs.getString("email"),
                                rs.getString("password_hash"),
                                rs.getString("name"),
                                rs.getInt("admin")
                        )
                );
            }
        } catch (SQLException e) {
            Logger.getInstance().addLog(e);
        }

        return result;
    }

    /**
     * Update object in database.
     */
    public void save() {
        try (PreparedStatement pstmt = Connector.getInstance().getConnection().prepareStatement(updateQuery)){

            pstmt.setString(1, email);
            pstmt.setString(2, password_hash);
            pstmt.setString(3, name);
            pstmt.setInt(4, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            Logger.getInstance().addLog(e);
        }
    }

    /**
     * Delete object in database.
     */
    public void delete() {
        try (PreparedStatement pstmt = Connector.getInstance().getConnection().prepareStatement(deleteQuery)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            Logger.getInstance().addLog(e);
        }
    }

    public Boolean isAdmin() {
        return admin == 1;
    }

}
