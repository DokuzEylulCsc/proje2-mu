package mu.Project;

import java.io.*;
import java.sql.*;


/**
 * Singleton class.
 */
public class Connector {
    private final static File       dbFile = new File("./Project.db");
    private final static Connector  ourInstance = new Connector();
    private Connection              connection;

    private Connector() { }

    /**
     * Connect SQLite database at ./Project.db.
     * If not exists, create default schema.
     */
    void connect() {
        try {
            boolean dbDoesntExists = !dbFile.exists();
            setConnection(DriverManager.getConnection("jdbc:sqlite:" + dbFile.getAbsolutePath()));

            if (dbDoesntExists) {
                Logger.getInstance().addLog("DB file doesn't exists. Creating new database with default schema " +
                        "and dataset.");

                executeResource(getClass().getResourceAsStream("/schema.sql"));
                executeResource(getClass().getResourceAsStream("/prototype.sql"));
            }

            Logger.getInstance().addLog("Connected to database!");
        } catch (SQLException e) {
            Logger.getInstance().addLog(e);
        }
    }

    /**
     * Set closeOnCompletion and return a PreparedStatement.
     *
     * @param SQL String
     * @return Empty statement, set to close on completion
     * @see PreparedStatement
     * @throws SQLException if connection isn't set
     */
    public PreparedStatement prepareStatement(String SQL) throws SQLException {
        PreparedStatement preparedStatement = getInstance().getConnection().prepareStatement(SQL);
        preparedStatement.closeOnCompletion();
        return preparedStatement;
    }

    public void executeResource(InputStream stream) {
        assert stream != null;

        Logger.getInstance().addLog("Starting execution of sql script...");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
            Statement statement;

            StringBuilder strStatement = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();

                // don't include comments
                if (line.isEmpty() || line.charAt(0) == '-') continue;
                // add line breaks as space character
                strStatement.append(line);
                strStatement.append(" ");

                if (line.endsWith(";")) {
                    Logger.getInstance().addLog(strStatement.toString());

                    statement = connection.createStatement();
                    statement.executeUpdate(strStatement.toString());
                    strStatement = new StringBuilder();
                }
            }

        } catch (IOException | SQLException e) {
            Logger.getInstance().addLog(e);
        } finally {
            Logger.getInstance().addLog("Execution finished!");
        }
    }

    public static Connector getInstance() {
        return ourInstance;
    }

    private void setConnection(Connection c) {
        this.connection = c;
    }

    public Connection getConnection() {
        return this.connection;
    }
}
