package Project.Controllers;

import Project.Views.View;

public abstract class Controller {
    final View view;

    public Controller(View _view) {
        view = _view;
    }

    private View getView() {
        return view;
    }
}
