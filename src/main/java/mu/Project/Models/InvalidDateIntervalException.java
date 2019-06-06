package mu.Project.Models;

import java.util.Date;

public class InvalidDateIntervalException extends Exception {
    public InvalidDateIntervalException(Date start, Date end) {
        super(TableUtility.dateFormat.format(start) + " to " + TableUtility.dateFormat.format(end));
    }

}
