package mu.Project.Views;

import mu.Project.Controllers.Controller;
import mu.Project.NotImplementedException;

public class AdminView extends View {

    public AdminView(Controller c) {
        super("Admin Dashboard", c);
    }

    public void close() {
        throw new NotImplementedException();
    }
}
