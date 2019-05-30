package mu.Project.Controllers;

import mu.Project.Models.Model;
import mu.Project.Views.View;

public class CustomerController extends AccountController {
    public CustomerController(View view, Model model) {
        this.view = view;
        this.model = model;
    }
}
