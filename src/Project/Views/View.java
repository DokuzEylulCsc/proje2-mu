package Project.Views;

import Project.Controllers.Controller;

public abstract class View {
    Controller controller;

    public View() {}

    public View(Controller _controller) {
        controller = _controller;
    }

    private Controller getController() {
        return controller;
    }
}
