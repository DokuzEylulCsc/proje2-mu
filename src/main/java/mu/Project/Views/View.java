package mu.Project.Views;

import mu.Project.Controllers.Controller;

import javax.swing.*;

public abstract class View extends JFrame {
    private final Controller controller;

    public View(String title, Controller controller) {
        super(title);
        this.controller = controller;
    }

    Controller getController() {
        return controller;
    }
}
