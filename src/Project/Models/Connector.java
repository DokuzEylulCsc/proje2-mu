package Project.Models;

import java.io.*;
import java.sql.*;


/**
 * Singleton class.
 */
public class Connector {
    private static final File   schemaSqlFile = new File("./scripts/schema.sql");
    private static final File   dbFile = new File("./Project.db");

    private static Connector    ourInstance = new Connector();
    private Connection          connection;

    private Connector() { connect(); }
    /**
     * Connect SQLite database at ./Project.db.
     * If not exists, create default schema.d
     */
    private void connect() {
        try {
            boolean dbDoesntExists = !dbFile.exists();
            setConnection(DriverManager.getConnection("jdbc:sqlite:" + dbFile.getAbsolutePath()));

            if (dbDoesntExists) {
                System.out.println("DB file doesn't exists. Creating new table with default schema.");
                executeFile(schemaSqlFile);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void executeFile(File sqlFile) {
        try {
            System.out.println("Executing statements in " + sqlFile.getName() + "...");
            BufferedReader reader = new BufferedReader(new FileReader(sqlFile));
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

    Connection getConnection() {
        return this.connection;
    }
}
