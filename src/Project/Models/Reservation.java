package Project.Models;

import Project.NotImplementedException;

public class Reservation implements Model {
    private Integer dbid;
    private Integer dbroomid;
    private Integer dbaccountid;
    private String startdate;
    private String enddate;

    public void save() {
        throw new NotImplementedException();
    }

    public void delete() {
        throw new NotImplementedException();
    }
}
