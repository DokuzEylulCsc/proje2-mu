package Project.Views;

import Project.Controllers.Controller;

public abstract class View {
    final Controller controller;

    public View(Controller _controller) {
        controller = _controller;
    }

    private Controller getController() {
        return controller;
    }
}
