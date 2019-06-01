package mu.Project.Controllers;

import mu.Project.Logger;
import mu.Project.Models.Account;

public class MainController extends Controller {

    LoginController loginController;
    AccountController accountController;

    public void runApp() {
        setLoginController(new LoginController(this));
    }

    /**
     * Receive signal only from LoginController to build AccountControllers or quit.
     */
    public void loginWindowClosed() {
        if (getLoginController().getModel() != null) {
            setModel(getLoginController().getModel());
            System.out.println("Login successful!\n" + getModel());

            if (getModel().isAdmin()) {
                setAccountController(new AdminController(getModel(), this));
            } else {
                setAccountController(new CustomerController(getModel(), this));
            }
        } else {
            // Quit
            Logger.getInstance().writeToFile();
        }
    }

    @Override Account getModel() {
        return (Account) super.getModel();
    }
    private LoginController getLoginController() {
        return loginController;
    }

    private void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }

    private AccountController getAccountController() {
        return accountController;
    }

    private void setAccountController(AccountController accountController) {
        this.accountController = accountController;
    }
}
