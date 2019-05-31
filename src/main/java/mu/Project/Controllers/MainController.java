package mu.Project.Controllers;

import mu.Project.Logger;
import mu.Project.Models.Account;

public class MainController extends ParentController {

    LoginController loginController;
    Account account;
    AccountController accountController;

    public void runApp() {
        setLoginController(new LoginController(this));
    }

    /**
     * Receive signal only from LoginController to build AccountControllers or quit.
     */
    public void receiveSignalFromChild() {
        if (getLoginController().getModel() != null) {
            setAccount((Account) getLoginController().getModel());
            System.out.println("Login successful!%n" + getAccount());

            if (getAccount().isAdmin()) {
                setAccountController(new AdminController(getAccount(), this));
            } else {
                setAccountController(new CustomerController(getAccount(), this));
            }
        } else {
            // Quit
            Logger.getInstance().writeToFile();
        }
    }

    private LoginController getLoginController() {
        return loginController;
    }

    private void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }

    private Account getAccount() {
        return account;
    }

    private void setAccount(Account account) {
        this.account = account;
    }

    private AccountController getAccountController() {
        return accountController;
    }

    private void setAccountController(AccountController accountController) {
        this.accountController = accountController;
    }
}
