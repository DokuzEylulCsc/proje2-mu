package mu.Project.Controllers;

import mu.Project.Views.View;
import mu.Project.Models.Model;


public abstract class Controller {
    View view;
    Model model;

    View getView() {
        return view;
    }

    void setView(View view) {
        this.view = view;
    }


    Model getModel() {
        return model;
    }

    void setModel(Model model) {
        this.model = model;
    }
}
