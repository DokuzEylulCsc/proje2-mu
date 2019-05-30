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
        if (!email.contains("@") || email.length() < 3) {
            getView().showInvalidEmailAlert();
            return;
        } else if (password.isEmpty()) {
            getView().showEmptyPasswordAlert();
            return;
        }

        Account account = Account.getAccount(email);
        if (account == null) {
            setModel(new Account(email, password, null,0));
            getView().showNewAccountNotice();
            getModel().save();

        } else if (account.comparePassword(password)) {
            setModel(account);
            getView().showLoginSuccessfulAlert();
            sendSignalToParent();

        } else {
            getView().showWrongPasswordAlert();
        }

        // temporary
        System.out.println(email + password + getPasswordHash(password).toString());
    }

    public void receiveSignalFromView() {
        if (getModel() == null) sendSignalToParent();
    }

    private Integer getPasswordHash(String password) {
        return password.hashCode();
    }

    @Override LoginView getView() {
        return (LoginView) super.getView();
    }
}
