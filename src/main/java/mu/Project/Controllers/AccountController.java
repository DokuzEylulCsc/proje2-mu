package mu.Project.Controllers;

import mu.Project.Models.Account;

public abstract class AccountController extends ChildController {
    public AccountController(Account model, ParentController parent) {
        setParent(parent);
        setModel(model);
    }
}
