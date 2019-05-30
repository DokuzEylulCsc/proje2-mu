package Project.Controllers;

import Project.Models.Model;
import Project.Views.View;

public class AdminController extends AccountController {
    public AdminController(View view, Model model) {
        this.view = view;
        this.model = model;
    }
}
