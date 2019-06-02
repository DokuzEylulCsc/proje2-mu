package mu.Project.Controllers;

import mu.Project.Connector;
import mu.Project.Logger;
import mu.Project.Models.Account;
import mu.Project.Models.InvalidPasswordException;
import mu.Project.Models.NoSuchAccountException;
import mu.Project.Views.CustomerView;

import java.sql.SQLException;

public class CustomerController extends AccountController {

    public CustomerController(Account model, MainController parent) {
        setModel(model);
        setParent(parent);
        setFrame(new CustomerView(this));
        getFrame().setEmailFixedField(getModel().getEmail());
        getFrame().setNameField(getModel().getName());
        getFrame().setVisible(true);
    }

    public void windowClosing() {
        Logger.getInstance().addLog("Trying to close JDBC...");

        try {
            System.out.println(Connector.getInstance().getConnection().getAutoCommit());
            Connector.getInstance().getConnection().close();
            Logger.getInstance().addLog("Closed JDBC successfully.");
        } catch (SQLException e) {
            Logger.getInstance().addLog(e);
        }
    }

    public void updateNameButtonClicked() {
        String newName = getFrame().getNameField();

        try {
            getModel().setNewName(newName);
            getFrame().showNameUpdatedAlert();

        } catch (NoSuchAccountException e) {
            Logger.getInstance().addLog(e);
            getFrame().showInternalErrorWhileUpdatingAlert();
        }
    }

    public void updatePasswordButtonClicked() {
        try {
            getModel().setNewPassword(getFrame().getPasswordField());
            Logger.getInstance().addLog("Password changed: " + getModel().getEmail());
            getFrame().showPasswordUpdatedAlert();

        } catch (InvalidPasswordException e) {
            Logger.getInstance().addLog(e);
            getFrame().showInvalidPasswordAlert();

        } catch (NoSuchAccountException e) {
            Logger.getInstance().addLog(e);
            getFrame().showInternalErrorWhileUpdatingAlert();
        }

    }

    @Override CustomerView getFrame() {
        return (CustomerView) super.getFrame();
    }
}
