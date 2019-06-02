package mu.Project.Views;

import mu.Project.Controllers.CustomerController;
import mu.Project.NotImplementedException;

import javax.swing.*;

public class CustomerView extends Frame {
    private JTabbedPane tabbedPane;
    private JPanel outerPanel;
    private JPanel accountTab;
    private JPanel reserveTab;
    private JPanel reservedTab;
    private JButton updatePasswordButton;
    private JTextField nameField;
    private JButton updateNameButton;
    private JLabel nameLabel;
    private JLabel emailLabel;
    private JPasswordField passwordField;
    private JLabel passwordLabel;
    private JPanel accountPanel;
    private JLabel emailFixedField;
    private JTable table1;

    public CustomerView(CustomerController controller) {
        super();
        setController(controller);
        setContentPane(outerPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        centerFrame();
        setVisible(true);
    }

    public void close() {
        throw new NotImplementedException();
    }
}
