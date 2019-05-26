package Project.Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Singleton class.
 */
public class Connector {
    private static Connector    ourInstance = new Connector();
    private Connection          connection = null;

    private Connector() {
        connect();
    }

    /**
     * Connect SQLite database at ./Project.db.
     * If not exists, create default schema.
     *
     * TODO: Create default schema from scripts/schema.sql
     */
    private void connect() {
        try {
            setConnection(DriverManager.getConnection("jdbc:sqlite:Project.db"));
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static Connector getInstance() {
        return ourInstance;
    }

    private void setConnection(Connection c) {
        this.connection = c;
    }

    private Connection getConnection() {
        return this.connection;
    }
}
