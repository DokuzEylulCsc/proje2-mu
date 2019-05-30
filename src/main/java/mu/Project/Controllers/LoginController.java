package Project.Controllers;

import Project.Models.Account;
import Project.Models.Model;
import Project.NotImplementedException;
import Project.Views.LoginView;
import Project.Views.View;

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
        Account account = Account.getAccount(email);

        // TODO: CREATE ACCOUNT IF NOT EXISTS AND UPDATE DATABASE SCHEMA ACCORDINGLY (I.E DEFAULT VALUES)
        if (account == null) {
            getView().showNoSuchAccountAlert();
        } else if (account.comparePasswordHash(getPasswordHash(password))) {
            setModel(account);
            getView().showLoginSuccessfulAlert();
            sendSignalToParent();
        } else {
            getView().showInvalidPasswordAlert();
        }

        // temporary
        System.out.println(email + password + getPasswordHash(password).toString());
    }

    private Integer getPasswordHash(String password) {
        return password.hashCode();
    }

    @Override LoginView getView() {
        return (LoginView) super.getView();
    }
}
