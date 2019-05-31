package mu.Project.Models;

import mu.Project.Connector;
import mu.Project.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Account implements Model {
    private String email;
    private Integer password_hash;
    private String name;
    private final Integer admin;

    private static String insertQuery = "INSERT INTO accounts (email, password_hash, name, admin)" +
            "VALUES (?, ?, ?, ?)";

    private static String updateQuery = "UPDATE accounts " +
            "SET email = ?, password_hash = ?,  name = ? " +
            "WHERE email = ? ";

    private static String deleteQuery = "DELETE FROM accounts " +
            "WHERE email = ?";

    /**
     * Create Account object, do not save to database till save method is called.
     *
     * @param email String
     * @param password String
     * @param name String
     * @param admin Integer, 0 or 1
     * @throws if email already exists in database
     */
    public Account(String email, String password, String name, Integer admin) {

        if (admin != 0 && admin != 1) {
            throw new UnsupportedOperationException("Admin can be only 0 or 1!");
        }

        this.email = email;
        this.password_hash = hashPassword(password);
        this.name = name;
        this.admin = admin;
    }

    /**
     * Initialize with password_hash from database.
     *
     * @param email String
     * @param password_hash Integer
     * @param name String
     * @param admin Integer, 0 or 1
     */
    private Account(String email, Integer password_hash, String name, Integer admin) {

        if (admin != 0 && admin != 1) {
            throw new UnsupportedOperationException("Admin can be only 0 or 1!");
        }

        this.email = email;
        this.password_hash = password_hash;
        this.name = name;
        this.admin = admin;
    }

    /**
     * Create an Account object from database by email.
     *
     * @param email String
     */
    public Account(String email) {

        Account thisAccount = getAccount(email);
        if (thisAccount == null) {
            throw new UnsupportedOperationException("No account exists with email:" + email + " in database!");
        }

        this.email = thisAccount.getEmail();
        this.name = thisAccount.getName();
        this.password_hash = thisAccount.getPassword_hash();
        this.admin = (thisAccount.isAdmin()) ? 1 : 0;

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
            String query = String.format("SELECT * FROM accounts WHERE email='%s'", email);
            ResultSet rs = stmt.executeQuery(query);
            rs.next();

            if (rs.isClosed()) {
                // ResultSet is empty.
                return null;
            }

            Account result = new Account(
                    rs.getString("email"),
                    rs.getInt("password_hash"),
                    rs.getString("name"),
                    rs.getInt("admin")
            );
            rs.close();
            return result;

        } catch (SQLException e) {
            Logger.getInstance().addLog(e);
            return null;
        }

    }

    /**
     * Find account in table, if not exists create new.
     *
     * @param email String
     * @param password_hash Integer
     * @param name String
     * @param admin Integer
     * @return Account
     */
    private static void createAccount(String email, Integer password_hash, String name, Integer admin) {

        try (PreparedStatement pstmt = Connector.getInstance().getConnection().prepareStatement(insertQuery)) {
            pstmt.setString(1, email);
            pstmt.setInt(2, password_hash);
            pstmt.setString(3, (name != null) ? name : "None");
            pstmt.setInt(4, admin);
            pstmt.execute();

        } catch (SQLException e) {
            Logger.getInstance().addLog(e);
        }
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
                                rs.getString("email"),
                                rs.getInt("password_hash"),
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
     * Update/create an object in database.
     */
    public void save() {

        if (getAccount(getEmail()) == null) {
            createAccount(getEmail(), getPassword_hash(), getName(), (isAdmin() ? 1 : 0));
        } else {
            try (PreparedStatement pstmt = Connector.getInstance().getConnection().prepareStatement(updateQuery)) {
                pstmt.setString(1, getEmail());
                pstmt.setInt(2, getPassword_hash());
                pstmt.setString(3, getName());
                pstmt.setString(4, getEmail());
                pstmt.executeUpdate();

            } catch (SQLException e) {
                Logger.getInstance().addLog(e);
            }
        }
    }

    /**
     * Delete object in database.
     */
    public void delete() {
        try (PreparedStatement pstmt = Connector.getInstance().getConnection().prepareStatement(deleteQuery)) {
            pstmt.setString(1, getEmail());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            Logger.getInstance().addLog(e);
        }
    }

    public Boolean isAdmin() {
        return admin == 1;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    private static Integer hashPassword(String password) {
        return password.hashCode();
    }

    public Integer getPassword_hash() {
        return password_hash;
    }

    public Boolean comparePassword(String password) {
        return getPassword_hash().equals(hashPassword(password));
    }

    @Override
    public String toString() {
        return String.format("name: %s\nemail: %s\nadmin: %d", email, name, admin);
    }
}
