package mu.Project.Views;

import mu.Project.Controllers.LoginController;

import javax.swing.*;
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
        setController(controller);
        setContentPane(outerPanel);
        pack();

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

    @Override public LoginController getController() {
        return (LoginController) super.controller;
    }
}
