package Project.Views;

import Project.Controllers.Controller;

import javax.swing.*;

public abstract class View extends JFrame {
    Controller controller;

    public View() {}

    public View(Controller _controller) {
        controller = _controller;
    }

    private Controller getController() {
        return controller;
    }
}
