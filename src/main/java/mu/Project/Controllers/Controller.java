package mu.Project.Controllers;

import mu.Project.Views.Frame;
import mu.Project.Models.Model;


public abstract class Controller {
    Frame frame;
    Model model;

    Frame getFrame() {
        return frame;
    }

    void setFrame(Frame frame) {
        this.frame = frame;
    }

    Model getModel() {
        return model;
    }

    void setModel(Model model) {
        this.model = model;
    }
}
