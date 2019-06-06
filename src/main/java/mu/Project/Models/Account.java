package mu.Project.Models;

import mu.Project.Connector;
import mu.Project.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


public class Account implements Model {
    private static String RFC5322 = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
    private static Pattern emailPattern = Pattern.compile(RFC5322);
    private final String email;
    private Integer password_hash;
    private String name;
    private final Integer admin;

    private static String insertStatement = "INSERT INTO accounts (email, password_hash, name, admin) " +
            "VALUES (?, ?, ?, ?)";

    private static String updateStatement = "UPDATE accounts " +
            "SET password_hash = ?,  name = ? " +
            "WHERE email = ? ";

    private static String deleteStatement = "DELETE FROM accounts " +
            "WHERE email = ?";

    private static String emailQuery = "SELECT email, password_hash, name, admin FROM accounts " +
            "WHERE email = ?";

    /**
     * Successful initialization of Account from public means login successful.
     *
     * @param email String
     * @param password String
     * @throws InvalidEmailAddressException Not an email
     * @throws NoSuchAccountException No account exists with the email in database
     * @throws WrongPasswordException Hash doesn't match to password's in database
     */
    public Account(String email, String password) throws InvalidEmailAddressException, NoSuchAccountException,
            WrongPasswordException, InvalidPasswordException, SQLException {

        if (! emailPattern.matcher(email).matches()) {
            throw new InvalidEmailAddressException(email);
        } else if (password.length() < 8) {
            throw new InvalidPasswordException();
        }

        PreparedStatement preparedStatement = Connector.getInstance().prepareStatement(emailQuery);
        preparedStatement.setString(1, email);
        ResultSet rs = preparedStatement.executeQuery();
        rs.next();

        if (rs.isClosed()) {
            throw new NoSuchAccountException(email);
        } else if (rs.getInt(2) != hashPassword(password)) {
            throw new WrongPasswordException();
        }

        // initialize
        this.email = rs.getString(1);
        this.password_hash = rs.getInt(2);
        this.name = rs.getString(3);
        this.admin = rs.getInt(4);
    }

    /**
     * Create Account object, do not save to database till save method is called.
     *
     * @param email String
     * @param password_hash Integer
     * @param name String
     * @param admin Integer, 0 or 1
     */
    private Account(String email, Integer password_hash, String name, Integer admin) {
        assert admin == 0 || admin == 1;

        this.email = email;
        this.password_hash = password_hash;
        this.name = name;
        this.admin = admin;
    }

    /**
     * Create a customer account with no name.
     *
     * @param email String
     * @param password String
     */
    public static void createAccount(String email, String password) {
        createAccount(email, hashPassword(password), null, 0);
    }

    /**
     * Create new account.
     *
     * @param email String
     * @param password_hash Integer
     * @param name String
     * @param admin Integer equals 0 or 1
     */
    private static void createAccount(String email, Integer password_hash, String name, Integer admin) {

        try (PreparedStatement preparedStatement = Connector.getInstance().prepareStatement(insertStatement)) {
            preparedStatement.setString(1, email);
            preparedStatement.setInt(2, password_hash);
            preparedStatement.setString(3, name);
            preparedStatement.setInt(4, admin);
            preparedStatement.execute();

            Logger.getInstance().addLog(String.format("New account created: %s", email));
        } catch (SQLException e) {
            Logger.getInstance().addLog(e);
        }
    }

    /**
     * Check if an Account exists by the email.
     *
     * @param email String
     * @see Boolean
     */
    public static Boolean isExists(String email) {

        try (PreparedStatement preparedStatement = Connector.getInstance().prepareStatement(emailQuery)){
            preparedStatement.setString(1, email);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();

            // if ResultSet is closed, query is empty
            Boolean result = !rs.isClosed();
            if (result) rs.close();
            return result;

        } catch (SQLException e) {
            Logger.getInstance().addLog(e);
            return false;
        }
    }

    /**
     * For AdminController.
     *
     * Return all records in accounts.
     */
    public static List<Account> queryAll() {

        List<Account> result = new ArrayList<>();
        try (Statement statement = Connector.getInstance().getConnection().createStatement()){
            String query = "SELECT email, password_hash, name, admin FROM accounts";

            ResultSet rs = statement.executeQuery(query);
            statement.close();

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
            rs.close();

        } catch (SQLException e) {
            Logger.getInstance().addLog(e);
        }

        return result;
    }

    /**
     * Update/create an object in database.
     */
    public void save() {

        if (isExists(getEmail())) try {
            update();
        } catch (NoSuchAccountException e) {
            Logger.getInstance().addLog(e);
        } else {
            // low level account creation
            createAccount(getEmail(), getPassword_hash(), getName(), (isAdmin() ? 1 : 0));
        }
    }

    public void update() throws NoSuchAccountException {
        if (!isExists(getEmail())) {
            throw new NoSuchAccountException(getEmail());
        }

        try (PreparedStatement preparedStatement = Connector.getInstance().prepareStatement(updateStatement)) {
            preparedStatement.setInt(1, getPassword_hash());
            preparedStatement.setString(2, getName());
            preparedStatement.setString(3, getEmail());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            Logger.getInstance().addLog(e);
        }
    }

    /**
     * Delete object in database.
     */
    public void delete() {
        try (PreparedStatement preparedStatement = Connector.getInstance().prepareStatement(deleteStatement)) {
            preparedStatement.setString(1, getEmail());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            Logger.getInstance().addLog(e);
        }
    }

    /**
     * Try to update name, both in object and database.
     *
     * @param newName String
     * @throws NoSuchAccountException if database update failed
     */
    public void setNewName(String newName) throws NoSuchAccountException {
        if (getName() == null || !getName().equals(newName)) {
            String oldName = getName();
            this.name = newName;

            update();
            Logger.getInstance().addLog(
                    String.format("Name changed %s to %s: %s", oldName, newName, getEmail())
            );
        }
    }

    /**
     * Try to update password, both in object and database.
     *
     * @param password String, length >= 8
     * @throws InvalidPasswordException if password length less than 8
     * @throws NoSuchAccountException if database update failed
     */
    public void setNewPassword(String password) throws InvalidPasswordException, NoSuchAccountException {
        if (password.length() < 8) {
            throw new InvalidPasswordException();
        } else {
            this.password_hash = hashPassword(password);
            update();
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
        return String.format("Name: %s | Email: %s | Admin: %s", name, email, (admin == 1) ? "yes" : "no");
    }
}
