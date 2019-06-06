package mu.Project;

import mu.Project.Controllers.MainController;

public class Main {

    public static void main(String[] args) {
        Connector.getInstance().connect();  // initialize jdbc
        MainController mainController = new MainController();
        mainController.runApp();
    }

}
