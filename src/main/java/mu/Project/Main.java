package mu.Project;

import mu.Project.Controllers.CustomerController;
import mu.Project.Controllers.MainController;
import mu.Project.Models.Account;
import mu.Project.Views.CustomerView;

public class Main {
    public static void main(String[] args) {


        Connector.getInstance().connect();  // initialize jdbc
        MainController mainController = new MainController();
        try {
            new CustomerView(new CustomerController(new Account("kestos@catmail.com", "password"), mainController));
        } catch (Exception e) {
            Logger.getInstance().addLog("CustomerView in Main not initialized.");
            e.printStackTrace();
        }
        // mainController.runApp();
    }
}
