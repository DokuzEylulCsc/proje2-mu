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
        createUIComponents();
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
        outerPanel = new JPanel();
        outerPanel.setLayout(new BorderLayout(0, 0));
        outerPanel.setMinimumSize(new Dimension(750, 400));
        outerPanel.setPreferredSize(new Dimension(750, 400));
        adminTabbedPane = new JTabbedPane();
        outerPanel.add(adminTabbedPane, BorderLayout.CENTER);
        accountTab = new JPanel();
        accountTab.setLayout(new GridBagLayout());
        adminTabbedPane.addTab("Account", accountTab);
        accountPanel = new JPanel();
        accountPanel.setLayout(new GridBagLayout());
        accountPanel.setPreferredSize(new Dimension(300, 150));
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        accountTab.add(accountPanel, gbc);
        passwordLabel = new JLabel();
        passwordLabel.setText("Password: ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0.05;
        gbc.anchor = GridBagConstraints.EAST;
        accountPanel.add(passwordLabel, gbc);
        updatePasswordButton = new JButton();
        updatePasswordButton.setText("Update");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.weightx = 0.05;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        accountPanel.add(updatePasswordButton, gbc);
        nameLabel = new JLabel();
        nameLabel.setText("Name: ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.05;
        gbc.anchor = GridBagConstraints.EAST;
        accountPanel.add(nameLabel, gbc);
        nameField = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        accountPanel.add(nameField, gbc);
        updateNameButton = new JButton();
        updateNameButton.setText("Update");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.weightx = 0.05;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        accountPanel.add(updateNameButton, gbc);
        passwordField = new JPasswordField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 0.9;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        accountPanel.add(passwordField, gbc);
        emailLabel = new JLabel();
        emailLabel.setText("Email: ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.05;
        gbc.anchor = GridBagConstraints.EAST;
        accountPanel.add(emailLabel, gbc);
        emailFixedField = new JLabel();
        emailFixedField.setText("None");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.9;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        accountPanel.add(emailFixedField, gbc);
        logoutButton = new JButton();
        logoutButton.setText("Logout");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        accountPanel.add(logoutButton, gbc);
        summaryPane = new JPanel();
        summaryPane.setLayout(new BorderLayout(0, 0));
        adminTabbedPane.addTab("Summary", summaryPane);
        summarySplitPane = new JSplitPane();
        summaryPane.add(summarySplitPane, BorderLayout.CENTER);
        summaryPanel = new JPanel();
        summaryPanel.setLayout(new GridBagLayout());
        summarySplitPane.setLeftComponent(summaryPanel);
        startDateLabel = new JLabel();
        startDateLabel.setText("Start Date: ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        summaryPanel.add(startDateLabel, gbc);
        endDateLabel = new JLabel();
        endDateLabel.setText("End Date: ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        summaryPanel.add(endDateLabel, gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        summaryPanel.add(startDateField, gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        summaryPanel.add(endDateField, gbc);
        searchButton = new JButton();
        searchButton.setText("Search");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        summaryPanel.add(searchButton, gbc);
        cityLabel = new JLabel();
        cityLabel.setText("City: ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        summaryPanel.add(cityLabel, gbc);
        citiesComboBox = new JComboBox();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        summaryPanel.add(citiesComboBox, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        summaryPanel.add(spacer1, gbc);
        cancelReservationButton = new JButton();
        cancelReservationButton.setText("Cancel Reservation");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        summaryPanel.add(cancelReservationButton, gbc);
        summaryScrollPane = new JScrollPane();
        summarySplitPane.setRightComponent(summaryScrollPane);
        summaryTable = new JTable();
        summaryScrollPane.setViewportView(summaryTable);
    }

}
