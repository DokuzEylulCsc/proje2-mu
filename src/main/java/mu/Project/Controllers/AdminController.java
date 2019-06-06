package mu.Project.Controllers;

import mu.Project.Models.Account;
import mu.Project.Views.AdminView;

public class AdminController extends AccountController {
    public AdminController(Account model, MainController parent) {
        setModel(model);
        setParent(parent);
        initializeFrame();
    }

    private void initializeFrame() {
        setFrame(new AdminView(this));

        getFrame().makeFullScreen();
        getFrame().setVisible(true);

    }
    public void windowClosing() {
        getParent().closeProgram();
    }
}
