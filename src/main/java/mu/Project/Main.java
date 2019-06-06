package mu.Project;

import mu.Project.Controllers.AdminController;
import mu.Project.Controllers.MainController;
import mu.Project.Models.Account;

public class Main {
    public static void main(String[] args) {
        Connector.getInstance().connect();  // initialize jdbc
        MainController mainController = new MainController();
        mainController.runApp();


        try {
            new AdminController(new Account("admin@tester.com", "password"), mainController);
        } catch (Exception e) {
            Logger.getInstance().addLog("AdminView not initialized in Main.");
            e.printStackTrace();
        }
    }
}
