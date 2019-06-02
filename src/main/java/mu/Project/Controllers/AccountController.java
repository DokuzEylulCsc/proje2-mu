package mu.Project.Controllers;

import mu.Project.Models.Account;

abstract public class AccountController extends ChildController {

    @Override
    Account getModel() {
        return (Account) super.getModel();
    }
}
