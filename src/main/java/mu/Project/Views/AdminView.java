package mu.Project.Views;

import mu.Project.Controllers.AdminController;

import javax.swing.*;

// TODO: Add GUI component bindings to controller
public class AdminView extends Frame {

    private JTabbedPane adminTabbedPane;
    private JPanel accountTab;
    private JPanel accountPanel;
    private JPanel summaryPane;
    private JFormattedTextField startDateField;
    private JFormattedTextField endDateField;
    private JPanel outerPanel;
    private JPanel summaryPanel;
    private JLabel startDateLabel;
    private JLabel endDateLabel;
    private JButton searchButton;
    private JLabel cityLabel;
    private JComboBox citiesComboBox;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton updatePasswordButton;
    private JLabel nameLabel;
    private JTextField nameField;
    private JButton updateNameButton;
    private JLabel emailLabel;
    private JLabel emailFixedField;
    private JButton logoutButton;
    private JSplitPane summarySplitPane;
    private JTable summaryTable;
    private JScrollPane summaryScrollPane;

    public AdminView(AdminController controller) {
        setController(controller);
        setContentPane(outerPanel);
        pack();
        centerFrame();

    }

    public void close() {
        getController().windowClosing();
        dispose();
    }

    @Override
    public AdminController getController() {
        return (AdminController) super.getController();
    }

    private void createUIComponents() {
        startDateField = new JDateField();
        endDateField = new JDateField();
    }
}
