package mu.Project.Controllers;

import mu.Project.Models.Model;
import mu.Project.Views.View;

public class AdminController extends AccountController {
    public AdminController(View view, Model model) {
        this.view = view;
        this.model = model;
    }
}
