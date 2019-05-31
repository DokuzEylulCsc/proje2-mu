package mu.Project.Controllers;

import mu.Project.Models.Account;
import mu.Project.Views.LoginView;

public class LoginController extends ChildController {

    public LoginController(ParentController parent) {
        setParent(parent);
        setModel(null);
        setView(new LoginView(this));
    }

    /**
     * If record doesn't exists, creates a new customer account.
     *
     * @param email String
     * @param password String
     */
    public void loginButtonClicked(String email, String password) {
        // check email address and password fields' validity
        if (!email.contains("@") || !(email.split("@").length > 1)) {
            getView().showInvalidEmailAddressAlert();
            return;
        } else if (password.isEmpty()) {
            getView().showEmptyPasswordAlert();
            return;
        }

        Account account = Account.getAccount(email);
        if (account == null) {
            setModel(new Account(email, password, null,0));
            getModel().save();
            getView().showNewAccountNotice();

        } else if (account.comparePassword(password)) {
            setModel(account);
            getView().showLoginSuccessfulAlert();

        } else {
            getView().showWrongPasswordAlert();
        }
    }

    /**
     * Receives signal from view when window is
     * manually closed or login successful.
     */
    public void receiveSignalFromView() {
        sendSignalToParent();
    }

    @Override LoginView getView() {
        return (LoginView) super.getView();
    }
}
