package Project.Models;

import Project.NotImplementedException;

class Account implements Model {
    private Integer dbId;
    private String Email;
    private String PasswordHash;
    private String Name;
    private Integer Admin;


    public void save() {
        throw new NotImplementedException();
    }

    public void delete() {
        throw new NotImplementedException();
    }
}
