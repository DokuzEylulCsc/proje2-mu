package mu.Project.Controllers;

import mu.Project.Models.Account;
import mu.Project.Views.LoginView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController extends ChildController implements ActionListener {

    public LoginController(MainController parent) {
        setParent(parent);
        setModel(null);
        setFrame(new LoginView(this));
    }

    public void actionPerformed(ActionEvent ae) {
        loginButtonClicked();
    }

    public void loginButtonClicked() {
        String password = getFrame().getPassword();
        String email = getFrame().getEmail();

        // check email address and password fields' validity
        if (!email.contains("@") || !(email.split("@").length > 1)) {
            getFrame().showInvalidEmailAddressAlert();
            return;
        } else if (password.isEmpty()) {
            getFrame().showEmptyPasswordAlert();
            return;
        }

        Account account = Account.getAccount(email);
        if (account == null) {
            setModel(new Account(email, password, null,0));
            getModel().save();
            getFrame().showNewAccountNotice();
            getFrame().showLoginSuccessfulAlert();
            getFrame().close();

        } else if (account.comparePassword(password)) {
            setModel(account);
            getFrame().showLoginSuccessfulAlert();
            getFrame().close();


        } else {
            getFrame().showWrongPasswordAlert();
        }
    }

    public void loginWindowClosed() {
        getParent().loginWindowClosed();
    }

    @Override LoginView getFrame() {
        return (LoginView) super.getFrame();
    }
}
