package mu.Project.Views;

import mu.Project.Controllers.CustomerController;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class CustomerView extends Frame {
    private JTabbedPane tabbedPane;
    private JPanel outerPanel;
    private JPanel accountTab;
    private JPanel reserveTab;
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
    private JButton logoutButton;
    private JButton searchButton;
    private JPanel reservePanel;
    private JTable reservationTable;
    private JSpinner personCountSpinner;
    private JSpinner starCountSpinner;
    private JLabel cityLabel;
    private JLabel starCountLabel;
    private JComboBox citiesComboBox;
    private JButton reserveButton;
    private JPanel reservedTab;
    private JButton refreshReservedTableButton;
    private JButton cancelReservationButton;
    private JPanel reservedOptionButtonsPanel;
    private JTable reservedTable;
    public static final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public CustomerView(CustomerController controller) {
        setController(controller);
        setContentPane(outerPanel);
        pack();
        centerFrame();
        setMinimumSize(new Dimension(775, 420));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                close();
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                close();
            }
        });

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

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getController().searchButtonClicked();
            }
        });

        reserveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getController().reserveButtonClicked();
            }
        });

        cancelReservationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getController().cancelReservationButtonClicked();
            }
        });

        refreshReservedTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getController().refreshReservedTableButtonClicked();
            }
        });

        // make full screen when clicked to other tabs
        // which requires larger space
        tabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                CustomerView.super.makeFullScreen();
            }
        });
    }

    public void close() {
        getController().closeProgram();
        dispose();
    }

    public void showReservationSuccessfulAlert(String hotel_name, Integer room_number, String startDate, String endDate) {
        JOptionPane.showMessageDialog(this,
                String.format("Your reservation at %s has been processed.%n" +
                        "Room number %d starting from %s and ending at %s.",
                        hotel_name, room_number, startDate, endDate),
                "Reservation Successful",
                JOptionPane.PLAIN_MESSAGE
        );
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
                "Invalid date interval!" +
                        "Start date should be in future and end date shouldn't be less than or equal to start date.",
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

    public JSpinner getPersonCountSpinner() {
        return personCountSpinner;
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

    public JComboBox getCitiesComboBox() {
        return citiesComboBox;
    }

    public JSpinner getStarCountSpinner() {
        return starCountSpinner;
    }

    public JTable getReservationTable() {
        return reservationTable;
    }

    public JTable getReservedTable() {
        return reservedTable;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        startDateField = new JDateField();
        endDateField = new JDateField();
        budgetField = new JDecimalField();

        // maximum of 6 people
        SpinnerModel spinnerModel = new SpinnerNumberModel(1, 1, 6, 1);
        personCountSpinner = new JSpinner(spinnerModel);

        // maximum of 7 stars
        spinnerModel = new SpinnerNumberModel(0, 0, 7, 1);
        starCountSpinner = new JSpinner(spinnerModel);

    }
}
