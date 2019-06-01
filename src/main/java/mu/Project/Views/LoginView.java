package mu.Project.Views;

import mu.Project.Controllers.LoginController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class LoginView extends Frame {
    private JPanel outerPanel;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginOrRegisterButton;
    private JLabel emailLabel;
    private JLabel passwordLabel;
    private JPanel innerPanel;

    public LoginView(LoginController controller) {
        setupProperties();
        setContentPane(outerPanel);
        setController(controller);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Send signal to controller when window is closed
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                getDefaultCloseOperation();
                getController().loginWindowClosed();
            }
        });

        loginOrRegisterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getController().loginButtonClicked();
            }
        });

        setTitle("Login");
        setResizable(false);
        pack();
        centerFrame();
        setVisible(true);
    }

    public void close() {
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

    public void showLoginSuccessfulAlert() {
        JOptionPane.showMessageDialog(this,
                "Login successful!",
                "Success",
                JOptionPane.PLAIN_MESSAGE
        );
    }

    public void showNewAccountNotice() {
        JOptionPane.showMessageDialog(this,
                "No such account is registered with this email, new account created.",
                "New account notice",
                JOptionPane.PLAIN_MESSAGE
        );
    }

    public void showWrongPasswordAlert() {
        JOptionPane.showMessageDialog(this,
                "Wrong password!",
                "Login failed",
                JOptionPane.WARNING_MESSAGE
        );
    }

    public void showInvalidPasswordAlert() {
        JOptionPane.showMessageDialog(this,
                "Please use a valid password. Password's length must be minimum of 8.",
                "Invalid password",
                JOptionPane.WARNING_MESSAGE
        );
    }

    public void showInvalidEmailAddressAlert() {
        JOptionPane.showMessageDialog(this,
                "Please type an email address.",
                "Invalid email format",
                JOptionPane.WARNING_MESSAGE
        );
    }

    public String getEmail() {
        return emailField.getText();
    }

    public String getPassword() {
        char[] password = passwordField.getPassword();
        return new String(password);
    }

    @Override
    public LoginController getController() {
        return (LoginController) super.controller;
    }

    private void setupProperties() {
        outerPanel = new JPanel();
        outerPanel.setLayout(new GridBagLayout());
        outerPanel.setPreferredSize(new Dimension(350, 200));
        innerPanel = new JPanel();
        innerPanel.setLayout(new GridBagLayout());
        innerPanel.setPreferredSize(new Dimension(250, 150));
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        outerPanel.add(innerPanel, gbc);
        emailLabel = new JLabel();
        emailLabel.setText("Email:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        innerPanel.add(emailLabel, gbc);
        emailField = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        innerPanel.add(emailField, gbc);
        passwordLabel = new JLabel();
        passwordLabel.setText("Password:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        innerPanel.add(passwordLabel, gbc);
        passwordField = new JPasswordField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        innerPanel.add(passwordField, gbc);
        loginOrRegisterButton = new JButton();
        loginOrRegisterButton.setText("Login or Register");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        innerPanel.add(loginOrRegisterButton, gbc);
    }
}
