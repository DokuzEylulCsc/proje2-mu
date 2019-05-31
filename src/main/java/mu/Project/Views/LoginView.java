package mu.Project.Views;

import mu.Project.Controllers.LoginController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LoginView extends View implements ActionListener {
    private JPanel panel1;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginOrRegisterButton;
    private JLabel emailLabel;
    private JLabel passwordLabel;

    public LoginView(LoginController controller) {
        super("Login", controller);
        setContentPane(panel1);
        pack();

        loginOrRegisterButton.addActionListener(this);
        setResizable(false);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Send signal to controller when window is closed
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                getDefaultCloseOperation();
                sendSignalToController();
            }
        });

        setVisible(true);
    }


    /**
     * Login successful or user manually closed application.
     */
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
                "No such account is registered with this email, new account created." +
                        "\nLogin successful!",
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

    public void showInvalidEmailAddressAlert() {
        JOptionPane.showMessageDialog(this,
                "Please type an email adress.",
                "Invalid email format",
                JOptionPane.WARNING_MESSAGE
        );
    }
}
