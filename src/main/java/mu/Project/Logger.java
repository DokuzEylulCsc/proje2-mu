package mu.Project;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;

public class Logger {

    public final static String  defaultFileName = "Project.log";
    private final static Logger instance = new Logger();
    private final static DateFormat ISO8601 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private LinkedHashMap<Date, Object> Logs;

    private Logger() {
        setLogs(new LinkedHashMap<>());
    }

    public void addLog(String log) { addLogObject(log); }

    public void addLog(Exception log) {
        addLogObject(log);
        log.printStackTrace();
    }

    /**
     * @param log instance of String or Exception
     */
    private void addLogObject(Object log) {
        assert log instanceof Exception || log instanceof String;

        Date now = new Date();
        getLogs().put(now, log);

        // Echo to console
        System.out.println("Log > " + logToString(now, log));
    }

    /**
     * Helper method to convert a log to String.
     */
    private String logToString(Date key, Object val) {
        if (val instanceof String) {
            return String.format("%s > %s", getISO8601().format(key), val);

        } else if (val instanceof Exception) {
            Exception e = (Exception) val;

            // get stackTrace as String
            StringWriter stackTrace = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stackTrace);
            ((Exception) val).printStackTrace(printWriter);

            return String.format(
                    "%s > %s",
                    getISO8601().format(key),
                    stackTrace.toString()
            );

        } else {
            Logger.getInstance().addLog(new TypeException("Invalid type at Logger.logToString!"));
            return null;
        }
    }

    /**
     * Write log file to ./defaultFileName using writeToFile(File obj).
     */
    public void writeToFile() {
        writeToFile(new File(defaultFileName));
    }

    /**
     * Write logs to specified file using logToString.
     *
     * @param file File object
     */
    public void writeToFile(File file) {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
            for (Date key : getLogs().keySet()) {
                bufferedWriter.write(String.format("%s%n", logToString(key, getLogs().get(key))));
            }
        } catch (IOException e) {
            Logger.getInstance().addLog(e);
        }
    }

    public static Logger getInstance() { return instance; }

    public DateFormat getISO8601() {
        return ISO8601;
    }

    private LinkedHashMap<Date, Object> getLogs() {
        return Logs;
    }

    private void setLogs(LinkedHashMap<Date, Object> logs) {
        Logs = logs;
    }

}
