package mu.Project.Views;

import mu.Project.Controllers.CustomerController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
    private JCheckBox seaViewCheckBox;
    private JCheckBox safeCheckBox;
    private JFormattedTextField startDateField;
    private JFormattedTextField endDateField;
    private JLabel startDateLabel;
    private JLabel endDateLabel;
    private JFormattedTextField budgetField;
    private JLabel personCountLabel;
    private JLabel budgetLabel;
    private JFormattedTextField personCountField;
    private JButton logoutButton;
    private JButton searchButton;
    private JPanel reservePanel;
    private JTable reservationTable;
    public static final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public CustomerView(CustomerController controller) {
        setController(controller);
        setContentPane(outerPanel);
        pack();
        centerFrame();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        updateNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getController().updateNameButtonClicked();
            }
        });

        updatePasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getController().updatePasswordButtonClicked();
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                getController().windowClosing();
            }

        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getController().searchButtonClicked();
            }
        });
    }

    public void showInvalidDateAlert() {
        JOptionPane.showMessageDialog(this,
                "Invalid date format!",
                "Failed",
                JOptionPane.WARNING_MESSAGE
        );
    }

    public void showInvalidPasswordAlert() {
        JOptionPane.showMessageDialog(this,
                "Invalid password format! Password's length must be a minimum of 8.",
                "Failed",
                JOptionPane.WARNING_MESSAGE
        );
    }

    public void showPasswordUpdatedAlert() {
        JOptionPane.showMessageDialog(this,
                "Password updated!",
                "Success",
                JOptionPane.PLAIN_MESSAGE
        );
    }

    public void showNameUpdatedAlert() {
        JOptionPane.showMessageDialog(this,
                "Name updated!",
                "Success",
                JOptionPane.PLAIN_MESSAGE
        );
    }

    public void showInternalErrorWhileUpdatingAlert() {
        JOptionPane.showMessageDialog(this,
                "An exception occurred while trying to update. Contact to support.",
                "Failed",
                JOptionPane.WARNING_MESSAGE
        );
    }

    public void close() {
        getDefaultCloseOperation();
    }

    @Override
    public CustomerController getController() {
        return (CustomerController) super.getController();
    }

    public String getNameField() {
        return nameField.getText();
    }

    public void setNameField(String name) {
        this.nameField.setText(name);
    }

    public String getPasswordField() {
        return new String(passwordField.getPassword());
    }

    public void setEmailFixedField(String email) {
        this.emailFixedField.setText(email);
    }

    public JCheckBox getSafeCheckBox() {
        return safeCheckBox;
    }

    public JCheckBox getSeaViewCheckBox() {
        return seaViewCheckBox;
    }

    public JFormattedTextField getPersonCountField() {
        return personCountField;
    }

    public JFormattedTextField getEndDateField() {
        return endDateField;
    }

    public JFormattedTextField getStartDateField() {
        return startDateField;
    }

    public JFormattedTextField getBudgetField() {
        return budgetField;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

        startDateField = new JDateField();
        endDateField = new JDateField();
        budgetField = new JDecimalField();
        personCountField = new JDecimalField();

    }

}
