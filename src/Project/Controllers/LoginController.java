package Project.Controllers;

import Project.NotImplementedException;
import Project.Views.View;

public class LoginController extends Controller {

    public LoginController(View _view) {
        super(_view);
    }

    /**
     * If record doesn't exists, creates a new customer account.
     *
     * @param email String
     * @param password Password to hash
     * @returns Customer or Admin controller.
     */
    public Controller loginButtonClicked(String email, String password) {
        throw new NotImplementedException();

    }

    public void showInvalidPasswordAlert() {
        throw new NotImplementedException();
    }

}
