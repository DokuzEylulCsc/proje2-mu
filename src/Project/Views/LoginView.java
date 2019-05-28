package Project.Views;

import Project.Controllers.Controller;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class LoginView extends View implements ActionListener {
    JPanel panel;
    JLabel system_name;
    JLabel email_label;
    JLabel password_label;
    JLabel message;
    JTextField email_text;
    JPasswordField password_text;
    JButton submit;

    public void receiveUserInfo(String username, String password) {
        System.out.println(username + password);
    }

    private void initialize() {


        system_name = new JLabel();
        system_name.setText("EL TURISTIKO");
        //Email
        email_label = new JLabel();
        email_label.setText("Email : ");
        email_text = new JTextField();
        //password
        password_label = new JLabel();
        password_label.setText("Password : ");
        password_text = new JPasswordField();

        submit = new JButton("Submit");

        panel = new JPanel(new GridLayout(4,1,0,10));

        panel.add(system_name);
        panel.add(email_label);
        panel.add(email_text);
        panel.add(password_label);
        panel.add(password_text);
        panel.add(submit);
        message = new JLabel();
        panel.add(message, BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);
        add(system_name, BorderLayout.CENTER);
        add(panel, BorderLayout.CENTER);
        setTitle("PlezLogen");
        setSize(300,250);
        setVisible(true);
        submit.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        message.setText("Action Performed");
        String email = email_text.getText();
        char[] pass = password_text.getPassword();
        String password = new String(pass);
        receiveUserInfo(email, password);

    }

    public LoginView()
    {
        controller = null;
        initialize();

    }

    public LoginView(Controller _controller) {
        super(_controller);
        initialize();
    }
}
