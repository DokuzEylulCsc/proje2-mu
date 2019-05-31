package mu.Project;

import java.io.*;
import java.sql.*;


/**
 * Singleton class.
 */
public class Connector {
    private static final File   dbFile = new File("./Project.db");

    private static Connector    ourInstance = new Connector();
    private Connection          connection;

    private Connector() { connect(); }

    /**
     * Initialize singleton.
     */
    public void initialize() {
        System.out.println("Database connector initialized.");
    }

    /**
     * Connect SQLite database at ./Project.db.
     * If not exists, create default schema.
     */
    private void connect() {
        try {
            boolean dbDoesntExists = !dbFile.exists();
            setConnection(DriverManager.getConnection("jdbc:sqlite:" + dbFile.getAbsolutePath()));

            if (dbDoesntExists) {
                System.out.println("DB file doesn't exists. Creating new table with default schema.");
                executeResource(getClass().getResourceAsStream("/schema.sql"));
                executeResource(getClass().getResourceAsStream("/prototype.sql"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void executeResource(InputStream stream) {
        assert stream != null;

        System.out.println("Starting execution of sql script...");
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
                    System.out.println(strStatement.toString());

                    statement = connection.createStatement();
                    statement.executeUpdate(strStatement.toString());
                    strStatement = new StringBuilder();
                }
            }

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Execution finished!");
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
