package Project.Views;

import Project.Controllers.Controller;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class LoginView extends View {
    LFrame frame;

    class LFrame extends JFrame implements ActionListener
    {
        JPanel panel;

        JLabel email_label;
        JLabel password_label;
        JLabel message;

        JTextField email_text;
        JPasswordField password_text;

        JButton submit;

        LFrame()
        {
            //Email
            email_label = new JLabel();
            email_label.setText("Email : ");
            email_text = new JTextField();
            //password
            password_label = new JLabel();
            password_label.setText("Password : ");
            password_text = new JPasswordField();

            submit = new JButton("Submit");

            panel = new JPanel(new GridLayout(3,1,0,10));

            panel.add(email_label);
            panel.add(email_text);
            panel.add(password_label);
            panel.add(password_text);
            message = new JLabel();
            panel.add(message);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            add(panel,BorderLayout.CENTER);
            setTitle("PlezLogen");
            setSize(300,150);
            setVisible(true);
            add(submit,BorderLayout.SOUTH);
            submit.addActionListener(this);
        }
        public void actionPerformed(ActionEvent ae) {
            message.setText("Action Performed");
            String email = email_text.getText();
            char[] pass = password_text.getPassword();
            String password = new String(pass);

            //System.out.println(email +"  "+ password);
        }
    }

    public LoginView()
    {
        controller = null;
        this.frame = new LFrame();

    }

    public LoginView(Controller _controller) {
        super(_controller);
        this.frame = new LFrame();
    }
}
