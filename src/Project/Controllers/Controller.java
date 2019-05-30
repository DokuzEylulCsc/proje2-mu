package Project.Controllers;

import Project.Views.View;
import Project.Models.Model;


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
