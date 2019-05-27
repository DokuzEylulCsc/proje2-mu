package Project.Models;

import Project.NotImplementedException;

public class Room implements  Model{
    private Integer dbid;
    private Integer dbhotelid;
    private Integer roomnumber;
    private Integer dbroomtypeid;

    public void save() {
        throw new NotImplementedException();
    }

    public void delete() {
        throw new NotImplementedException();
    }


}
