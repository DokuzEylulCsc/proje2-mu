package mu.Project.Views;

import mu.Project.Controllers.CustomerController;
import mu.Project.NotImplementedException;

import javax.swing.*;

public class CustomerView extends Frame {
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JPanel Account;
    private JPanel Reservation;

    public CustomerView(CustomerController controller) {
        super();
        setController(controller);
        setContentPane(panel1);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        centerFrame();
        setVisible(true);
    }

    public void close() {
        throw new NotImplementedException();
    }
}
