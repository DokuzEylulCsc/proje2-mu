package mu.Project.Controllers;

import mu.Project.Models.Account;
import mu.Project.Views.LoginView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController extends ChildController implements ActionListener {

    public LoginController(MainController parent) {
        setParent(parent);
        setModel(null);
        setView(new LoginView(this));
    }

    public void actionPerformed(ActionEvent ae) {
        loginButtonClicked();
    }

    public void loginButtonClicked() {
        String password = getView().getPassword();
        String email = getView().getEmail();

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
            getView().showLoginSuccessfulAlert();
            getView().close();

        } else if (account.comparePassword(password)) {
            setModel(account);
            getView().showLoginSuccessfulAlert();
            getView().close();


        } else {
            getView().showWrongPasswordAlert();
        }
    }

    public void loginWindowClosed() {
        getParent().loginWindowClosed();
    }

    @Override LoginView getView() {
        return (LoginView) super.getView();
    }
}
