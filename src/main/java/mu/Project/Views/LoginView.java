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
        setLocationRelativeTo(null);
        setSize(350,200);
        setResizable(false);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                sendSignalToController();
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }

    private void sendSignalToController() {
        ((LoginController) getController()).receiveSignalFromView();
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
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

    public void showNewAccountNotice() {
        JOptionPane.showMessageDialog(this,
                "No such account is registered with this email, new account created.",
                "New account notice",
                JOptionPane.PLAIN_MESSAGE
        );
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

    public void showWrongPasswordAlert() {
        JOptionPane.showMessageDialog(this,
                "Wrong password!",
                "Login failed",
                JOptionPane.WARNING_MESSAGE
        );
    }

    public void showEmptyPasswordAlert() {
        JOptionPane.showMessageDialog(this,
                "Please use a password.",
                "Empty password",
                JOptionPane.WARNING_MESSAGE
        );
    }

    public void showInvalidEmailAlert() {
        JOptionPane.showMessageDialog(this,
                "Please type an email adress.",
                "Invalid email format",
                JOptionPane.WARNING_MESSAGE
        );
    }
}
