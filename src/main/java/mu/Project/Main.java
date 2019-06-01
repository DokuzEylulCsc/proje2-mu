package mu.Project;

import mu.Project.Controllers.MainController;

public class Main {
    public static void main(String[] args) {
        MainController mainController = new MainController();
        Connector.getInstance().initialize();
        mainController.runApp();
        Logger.getInstance().writeToFile();
    }
}
