package mu.Project.Controllers;

import mu.Project.Models.Account;
import mu.Project.Models.Model;
import mu.Project.Views.AdminView;
import mu.Project.Views.View;

public class AdminController extends AccountController {
    public AdminController(Account model, ParentController parent) {
        super(model, parent);
        setView(new AdminView(this));
    }
}
