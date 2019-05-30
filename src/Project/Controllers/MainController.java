package Project.Controllers;


// TODO: get Account from LoginController
// TODO: invoke Admin or Customer Controller with with Account object

import Project.Models.Account;

public class MainController extends ParentController {

    LoginController loginController;

    public void runApp() {
        loginController = new LoginController(this);
        // throw new NotImplementedException();
    }

    /**
     * Receive signal only from LoginController to build AccountControllers or quit.
     */
    public void receiveSignalFromChild() {
        if (loginController.getModel() != null) {
            System.out.println("Successful!" + loginController.getModel().toString());
        }
    }
}
