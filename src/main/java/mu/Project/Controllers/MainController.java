package mu.Project.Controllers;

import mu.Project.Connector;
import mu.Project.Logger;
import mu.Project.Models.Account;

import java.sql.SQLException;

public class MainController extends Controller {

    LoginController loginController;
    AccountController accountController;

    public void runApp() {
        setLoginController(new LoginController(this));
    }

    public void closeProgram() {
        Logger.getInstance().addLog("Trying to close JDBC...");

        try {
            Connector.getInstance().getConnection().close();
            Logger.getInstance().addLog("Closed JDBC successfully.");
        } catch (SQLException e) {
            Logger.getInstance().addLog(e);
        }
    }

    public void loginWindowClosed() {
        setModel(getLoginController().getModel());

        if (getModel() != null) {
            Logger.getInstance().addLog("Login successful: " + getModel().getEmail());

            if (getModel().isAdmin()) {
                setAccountController(new AdminController(getModel(), this));
            } else {
                setAccountController(new CustomerController(getModel(), this));
            }
        } else {
            // Quit application
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
