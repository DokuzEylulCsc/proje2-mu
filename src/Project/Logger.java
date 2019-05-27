package Project;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;

// TODO: Add writeToFile
public class Logger {
    private static Logger ourInstance = new Logger();
    private static final DateFormat ISO8601 = new SimpleDateFormat("yyyy-mm-dd hh:mm");
    private LinkedHashMap<Date, Object> Logs;

    private Logger() {
        setLogs(new LinkedHashMap<>());
    }

    public void addLog(String log) { addLogObject(log); }

    public void addLog(Exception log) { addLogObject(log); }

    /**
     * @param log instance of String or Exception
     */
    private void addLogObject(Object log) {
        assert log instanceof Exception || log instanceof String;

        Date now = new Date();
        System.out.println("Log > " + logToString(now, log));
        getLogs().put(now, log);
    }

    /**
     * Helper method to convert a log to String.
     */
    private String logToString(Date key, Object val) {
        if (val instanceof String) {
            return String.format("%s: %s", getISO8601().format(key), val);

        } else if (val instanceof Exception) {
            Exception e = (Exception) val;
            return String.format("%s: %s\n%s",
                    getISO8601().format(key), e.getMessage(), e.getStackTrace());
        } else {
            Logger.getInstance().addLog(new TypeException("Invalid type at Logger.logToString!"));
            return null;
        }
    }

    public static Logger getInstance() { return ourInstance; }

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
