package mu.Project.Views;

import mu.Project.Controllers.CustomerController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
    private JComboBox<String> citiesComboBox;
    private JButton reserveButton;
    private JPanel reservedTab;
    private JButton refreshReservedTableButton;
    private JButton cancelReservationButton;
    private JPanel reservedOptionButtonsPanel;
    private JTable reservedTable;
    private JSplitPane reserveSplitPane;
    private JScrollPane reservationScrollPane;
    private JSplitPane reservedSplitPane;
    private JScrollPane reservedScrollPane;

    public CustomerView(CustomerController controller) {
        createUIComponents();
        setController(controller);
        setContentPane(outerPanel);
        setMinimumSize(new Dimension(775, 420));
        pack();
        centerFrame();

        setTitle("Dashboard");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getReservedTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        getReservationTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

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
    }

    public void showNoRoomSelectedAlert() {
        JOptionPane.showMessageDialog(this,
                "Please select a room in the table by clicking on it to reserve a room.",
                "Failed",
                JOptionPane.WARNING_MESSAGE
        );
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

    public void showReservationSuccessfulAlert(String hotel_name, Integer room_number, String startDate, String endDate) {
        JOptionPane.showMessageDialog(this,
                String.format("Your reservation at %s has been processed.%n" +
                                "Room number %d starting from %s and ending at %s.",
                        hotel_name, room_number, startDate, endDate),
                "Reservation Successful",
                JOptionPane.PLAIN_MESSAGE
        );
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

    public JComboBox<String> getCitiesComboBox() {
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

    @Override
    public CustomerController getController() {
        return (CustomerController) super.getController();
    }

    private void createUIComponents() {
        startDateField = new JDateField();
        endDateField = new JDateField();
        budgetField = new JDecimalField();

        // maximum of 6 people
        SpinnerModel spinnerModel = new SpinnerNumberModel(1, 1, 6, 1);
        personCountSpinner = new JSpinner(spinnerModel);

        // maximum of 7 stars
        spinnerModel = new SpinnerNumberModel(0, 0, 7, 1);
        starCountSpinner = new JSpinner(spinnerModel);

        outerPanel = new JPanel();
        outerPanel.setLayout(new BorderLayout(0, 0));
        outerPanel.setPreferredSize(new Dimension(750, 400));
        tabbedPane = new JTabbedPane();
        outerPanel.add(tabbedPane, BorderLayout.CENTER);
        accountTab = new JPanel();
        accountTab.setLayout(new GridBagLayout());
        tabbedPane.addTab("Account", accountTab);
        accountPanel = new JPanel();
        accountPanel.setLayout(new GridBagLayout());
        accountPanel.setPreferredSize(new Dimension(300, 150));
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
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
        reserveTab = new JPanel();
        reserveTab.setLayout(new BorderLayout(0, 0));
        tabbedPane.addTab("Reservation", reserveTab);
        reserveSplitPane = new JSplitPane();
        reserveTab.add(reserveSplitPane, BorderLayout.CENTER);
        reservePanel = new JPanel();
        reservePanel.setLayout(new GridBagLayout());
        reserveSplitPane.setLeftComponent(reservePanel);
        startDateLabel = new JLabel();
        startDateLabel.setText("Start Date: ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        reservePanel.add(startDateLabel, gbc);
        endDateLabel = new JLabel();
        endDateLabel.setText("End Date: ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        reservePanel.add(endDateLabel, gbc);
        seaViewCheckBox = new JCheckBox();
        seaViewCheckBox.setHideActionText(false);
        seaViewCheckBox.setText("Sea View");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        reservePanel.add(seaViewCheckBox, gbc);
        safeCheckBox = new JCheckBox();
        safeCheckBox.setHideActionText(false);
        safeCheckBox.setText("Safe");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        reservePanel.add(safeCheckBox, gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        reservePanel.add(startDateField, gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        reservePanel.add(endDateField, gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        reservePanel.add(budgetField, gbc);
        budgetLabel = new JLabel();
        budgetLabel.setText("Budget: ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.EAST;
        reservePanel.add(budgetLabel, gbc);
        personCountLabel = new JLabel();
        personCountLabel.setText("Person Count: ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.EAST;
        reservePanel.add(personCountLabel, gbc);
        searchButton = new JButton();
        searchButton.setText("Search");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        reservePanel.add(searchButton, gbc);
        personCountSpinner.setName("Person Count");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        reservePanel.add(personCountSpinner, gbc);
        starCountLabel = new JLabel();
        starCountLabel.setText("Star Count: ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.EAST;
        reservePanel.add(starCountLabel, gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        reservePanel.add(starCountSpinner, gbc);
        cityLabel = new JLabel();
        cityLabel.setText("City: ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        reservePanel.add(cityLabel, gbc);
        citiesComboBox = new JComboBox();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        reservePanel.add(citiesComboBox, gbc);
        reserveButton = new JButton();
        reserveButton.setText("Attemp to Reserve");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        reservePanel.add(reserveButton, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        reservePanel.add(spacer1, gbc);
        reservationScrollPane = new JScrollPane();
        reserveSplitPane.setRightComponent(reservationScrollPane);
        reservationTable = new JTable();
        reservationScrollPane.setViewportView(reservationTable);
        reservedTab = new JPanel();
        reservedTab.setLayout(new BorderLayout(0, 0));
        reservedTab.setName("Reserved");
        tabbedPane.addTab("Reserved", reservedTab);
        reservedSplitPane = new JSplitPane();
        reservedTab.add(reservedSplitPane, BorderLayout.CENTER);
        reservedOptionButtonsPanel = new JPanel();
        reservedOptionButtonsPanel.setLayout(new GridBagLayout());
        reservedSplitPane.setLeftComponent(reservedOptionButtonsPanel);
        refreshReservedTableButton = new JButton();
        refreshReservedTableButton.setText("Refresh");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        reservedOptionButtonsPanel.add(refreshReservedTableButton, gbc);
        cancelReservationButton = new JButton();
        cancelReservationButton.setText("Cancel Reservation");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        reservedOptionButtonsPanel.add(cancelReservationButton, gbc);
        reservedScrollPane = new JScrollPane();
        reservedSplitPane.setRightComponent(reservedScrollPane);
        reservedTable = new JTable();
        reservedScrollPane.setViewportView(reservedTable);
    }
}
