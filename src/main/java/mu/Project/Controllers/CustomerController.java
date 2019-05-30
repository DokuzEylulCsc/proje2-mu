package mu.Project.Controllers;

import mu.Project.Models.Account;
import mu.Project.Models.Model;
import mu.Project.Views.CustomerView;
import mu.Project.Views.View;

public class CustomerController extends AccountController {
    public CustomerController(Account model, ParentController parent) {
        super(model, parent);
        setView(new CustomerView(this));
    }
}
