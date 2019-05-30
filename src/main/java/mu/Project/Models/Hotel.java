package Project.Models;

import Project.NotImplementedException;

public class Hotel implements Model {
    private Integer dbId;
    private String Name;
    private Integer Stars;

    public void save() {
        throw new NotImplementedException();
    }

    public void delete() {
        throw new NotImplementedException();
    }
}
