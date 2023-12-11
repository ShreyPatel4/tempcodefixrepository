/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.csye6200;

/**
 *
 * @author Admin
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterface extends JFrame {
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JPanel mainPanel;
    private JLabel lblStatus;

    private UserService userService;

    public UserInterface() {
        userService = new UserService();
        setContentPane(mainPanel);
        setTitle("User Login");
        setSize(300, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performLogin();
            }
        });
    }

    private void performLogin() {
        String username = txtUsername.getText();
        String password = new String(txtPassword.getPassword());

        try {
            User user = userService.authenticateUser(username, password);
            lblStatus.setText("Login successful as " + user.getRole());
        } catch (AuthenticationException ex) {
            lblStatus.setText("Login failed: " + ex.getMessage());
            Logger.log("Authentication failed for user: " + username);
        } catch (Exception ex) {
            lblStatus.setText("An unexpected error occurred");
            Logger.log("Unexpected error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.setVisible(true);
    }
}


