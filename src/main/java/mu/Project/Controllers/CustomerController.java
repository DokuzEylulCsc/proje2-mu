package Project.Controllers;

import Project.Models.Model;
import Project.Views.View;

public class CustomerController extends AccountController {
    public CustomerController(View view, Model model) {
        this.view = view;
        this.model = model;
    }
}
