package mu.Project.Views;

import mu.Project.Controllers.Controller;

import javax.swing.*;

public abstract class View extends JFrame {
    private final Controller controller;

    public View(Controller controller) {
        this.controller = controller;
    }

    Controller getController() {
        return controller;
    }
}
