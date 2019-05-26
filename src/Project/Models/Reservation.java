package Project.Models;

import Project.NotImplementedException;

public class Reservation implements Model {
    private Integer dbId;
    private Integer dbroomId;
    private Integer dbaccountId;
    private String StartDate;
    private String EndDate;

    public void save() {
        throw new NotImplementedException();
    }

    public void delete() {
        throw new NotImplementedException();
    }
}
