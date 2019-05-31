package mu.Project.Controllers;

import mu.Project.Models.Account;
import mu.Project.Views.CustomerView;

public class CustomerController extends AccountController {
    public CustomerController(Account model, ParentController parent) {
        super(model, parent);

        setView(new CustomerView(this));
    }
}
