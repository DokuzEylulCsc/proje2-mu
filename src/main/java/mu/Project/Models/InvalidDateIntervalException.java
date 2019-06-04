package mu.Project.Models;

import java.util.Date;

public class InvalidDateIntervalException extends Exception {
    public InvalidDateIntervalException(Date start, Date end) {
        super(start.toString() + " to " +end.toString());
    }

    public InvalidDateIntervalException(String start, String end) {
        super(start + " to " + end);
    }

}
