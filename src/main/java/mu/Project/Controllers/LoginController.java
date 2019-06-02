package mu.Project.Controllers;

import mu.Project.Logger;
import mu.Project.Models.*;
import mu.Project.Views.LoginView;

import java.sql.SQLException;

public class LoginController extends ChildController {

    public LoginController(MainController parent) {
        setParent(parent);
        setModel(null);
        setFrame(new LoginView(this));
    }

    public void loginButtonClicked() {
        try {
            setModel(
                    new Account(
                            getFrame().getEmail(),
                            getFrame().getPassword()
                    )
            );
            getFrame().showLoginSuccessfulAlert();
            getFrame().close();

        } catch (InvalidEmailAddressException e) {
            Logger.getInstance().addLog(e);
            getFrame().showInvalidEmailAddressAlert();

        } catch (InvalidPasswordException e) {
            Logger.getInstance().addLog(e);
            getFrame().showInvalidPasswordAlert();

        } catch (NoSuchAccountException e) {
            // Account checks email and password formats first, then this exception is thrown.
            // Thus createAccount will not create an account with invalid fields.

            Logger.getInstance().addLog(e);
            Account.createAccount(getFrame().getEmail(), getFrame().getPassword());
            getFrame().showNewAccountNotice();
            loginButtonClicked();   // log in

        }  catch (WrongPasswordException e) {
            Logger.getInstance().addLog(e);
            getFrame().showWrongPasswordAlert();

        } catch (SQLException e) {
            Logger.getInstance().addLog(e);
        }
    }

    public void loginWindowClosed() {
        getParent().loginWindowClosed();
    }

    @Override LoginView getFrame() {
        return (LoginView) super.getFrame();
    }
}
