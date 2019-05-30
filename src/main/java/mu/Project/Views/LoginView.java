package mu.Project.Views;

import mu.Project.Controllers.LoginController;
import mu.Project.NotImplementedException;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class LoginView extends View implements ActionListener {
    private static JPanel outerPanel = new JPanel(new BorderLayout(10,10));
    private static JPanel inputPanel = new JPanel(new GridLayout(2,2,10,10));
    private static JLabel systemNameLabel = new JLabel("Reservation System");
    private static JLabel emailFieldLabel = new JLabel("Email: ");
    private static JTextField emailField = new JTextField();
    private static JButton loginButton = new JButton("Login or Register!");
    private static JLabel passwordFieldLabel = new JLabel("Password: ");
    private static JPasswordField passwordField = new JPasswordField();

    public LoginView(LoginController controller) {
        super(controller);
        initialize();
    }

    private void initialize() {

        inputPanel.add(emailFieldLabel);
        inputPanel.add(emailField);
        inputPanel.add(passwordFieldLabel);
        inputPanel.add(passwordField);
        //inputPanel.setBackground(Color.RED);

        outerPanel.add(systemNameLabel, BorderLayout.NORTH);
        outerPanel.add(inputPanel, BorderLayout.CENTER);
        outerPanel.add(loginButton, BorderLayout.SOUTH);
        //outerPanel.setBackground(Color.BLUE);

        add(outerPanel, BorderLayout.CENTER);
        loginButton.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(300,200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String email = emailField.getText();
        char[] pass = passwordField.getPassword();
        String password = new String(pass);

        ((LoginController) getController()).loginButtonClicked(email, password);
    }

    public void showLoginSuccessfulAlert() {
        JOptionPane.showMessageDialog(this,
                "Login successful!",
                "Success",
                JOptionPane.PLAIN_MESSAGE
        );

    }

    public void showNoSuchAccountAlert() {
        JOptionPane.showMessageDialog(this,
                "No such account is registered with this email, new account created",
                "New account notice",
                JOptionPane.PLAIN_MESSAGE
        );

    }

    public void showInvalidPasswordAlert() {
        JOptionPane.showMessageDialog(this,
                "Invalid password!",
                "Failed",
                JOptionPane.WARNING_MESSAGE
        );
    }
}
