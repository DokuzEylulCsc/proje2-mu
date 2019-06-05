package mu.Project.Controllers;

import mu.Project.Models.Account;

public class AdminController extends AccountController {
    public AdminController(Account model, MainController parent) {
        setModel(model);
        setParent(parent);

    }

    public void windowClosing() {
        getParent().closeProgram();
    }
}
