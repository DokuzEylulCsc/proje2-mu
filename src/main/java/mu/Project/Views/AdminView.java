package mu.Project.Views;

import mu.Project.Controllers.AdminController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
    private JComboBox<String> citiesComboBox;
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
    private JButton cancelReservationButton;

    public AdminView(AdminController controller) {
        setController(controller);
        setContentPane(outerPanel);
        setMinimumSize(new Dimension(775, 420));
        pack();
        centerFrame();

        setTitle("Admin Dashboard");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getSummaryTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                getController().close();
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getController().close();
            }
        });

        updatePasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getController().updatePasswordButtonClicked();
            }
        });

        updateNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getController().updateNameButtonClicked();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getController().searchButtonClicked();
            }
        });

        cancelReservationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getController().cancelReservationButtonClicked();
            }
        });
    }

    public void showNoReservationSelectedAlert() {
        JOptionPane.showMessageDialog(this,
                "Please select reservation in the table by clicking on it to cancel a reservation.",
                "Failed",
                JOptionPane.WARNING_MESSAGE
        );
    }

    public int showYesNoOptionPane(String questionMessage) {
        return JOptionPane.showConfirmDialog(this, questionMessage, "Confirm",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    }

    public void showPastReservationCancelRequestAlert() {
        JOptionPane.showMessageDialog(this,
                "We can't cancel a past reservation!",
                "Failed",
                JOptionPane.WARNING_MESSAGE
        );
    }

    public void showReservationCancellationSuccessfulAlert(String hotel_name, Integer room_number, String startDate) {
        JOptionPane.showMessageDialog(this,
                String.format("Your reservation at %s for room number %d at %s successfully cancelled.",
                        startDate, room_number, hotel_name),
                "Reservation Cancelled",
                JOptionPane.PLAIN_MESSAGE);
    }

    public void showEmptyRequiredFieldAlert() {
        JOptionPane.showMessageDialog(this,
                "Please fill in all required fields to search!",
                "Empty field",
                JOptionPane.WARNING_MESSAGE
        );
    }

    public void showInvalidDateFormatAlert() {
        JOptionPane.showMessageDialog(this,
                "Invalid date format!",
                "Failed",
                JOptionPane.WARNING_MESSAGE
        );
    }

    public void showInvalidDateIntervalAlert() {
        JOptionPane.showMessageDialog(this,
                String.format("Invalid date interval!%n" +
                        "Start date should be in future and before end date."),
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

    public void showGeneralInternalErrorAlert() {
        JOptionPane.showMessageDialog(this,
                "An exception occurred. Contact to support.",
                "Failed",
                JOptionPane.WARNING_MESSAGE
        );
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

    public JFormattedTextField getEndDateField() {
        return endDateField;
    }

    public JFormattedTextField getStartDateField() {
        return startDateField;
    }

    public JComboBox<String> getCitiesComboBox() {
        return citiesComboBox;
    }

    public JTable getSummaryTable() {
        return summaryTable;
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
