package src.vistas;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import src.vistas.LoginUI;

import javax.swing.*;

import src.controllers.UserControl;

public class RegisterUI extends JFrame {
    
    private JPanel currentScreen;

    public RegisterUI() {

        currentScreen = new JPanel();
        currentScreen.setLayout(new BorderLayout());

        showRegisterUI();
        add(currentScreen);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

    }

    private void showRegisterUI() {
        Font currentStyle = new Font("Arial", Font.BOLD, 25);
        Font inputStyle = new Font("Arial", Font.BOLD, 16);
        int spaceBetweenBoxes = 30;

        currentScreen.removeAll();

        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.BLUE);
        centerPanel.setLayout(new GridBagLayout());

        JPanel contentCenterPanel = new JPanel();
        contentCenterPanel.setBackground(Color.DARK_GRAY);
        contentCenterPanel.setPreferredSize(new Dimension(650, 500));
        contentCenterPanel.setLayout(new BorderLayout());

        //title

        JPanel titleContentCenterPanel = new JPanel();
        titleContentCenterPanel.setBackground(Color.DARK_GRAY);
        titleContentCenterPanel.setPreferredSize(new Dimension(600, 50)); 
        titleContentCenterPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel titleLabel = new JLabel("Registro");
        titleLabel.setFont(currentStyle);
        titleLabel.setForeground(Color.WHITE);
        titleContentCenterPanel.add(titleLabel);

        //labels

        JPanel labelsPanel = new JPanel();
        labelsPanel.setBackground(Color.DARK_GRAY); // Fondo del panel
        labelsPanel.setLayout(new BoxLayout(labelsPanel, BoxLayout.Y_AXIS));
        labelsPanel.setBorder(BorderFactory.createEmptyBorder(30, 228, 0, 0));

        JLabel userGmailJLabel = new JLabel("Correo electronico:");
        userGmailJLabel.setFont(inputStyle);
        userGmailJLabel.setForeground(Color.WHITE); // Color del texto
        userGmailJLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT); // Alinear a la izquierda
        labelsPanel.add(userGmailJLabel);

        JTextField userGmailTextField = new JTextField();
        userGmailTextField.setMaximumSize(new Dimension(200, 30)); // Tamaño máximo del JTextField
        userGmailTextField.setAlignmentX(JTextField.LEFT_ALIGNMENT); // Alinear a la izquierda
        labelsPanel.add(userGmailTextField);
        
        labelsPanel.add(Box.createVerticalStrut(spaceBetweenBoxes));
        
        JLabel userPasswordJLabel = new JLabel("Contraseña:");
        userPasswordJLabel.setFont(inputStyle);
        userPasswordJLabel.setForeground(Color.WHITE); // Color del texto
        userPasswordJLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT); // Alinear a la izquierda
        labelsPanel.add(userPasswordJLabel);

        JTextField userPasswordTextField = new JTextField();
        userPasswordTextField.setMaximumSize(new Dimension(200, 30)); // Tamaño máximo del JTextField
        userPasswordTextField.setAlignmentX(JTextField.LEFT_ALIGNMENT); // Alinear a la izquierda
        labelsPanel.add(userPasswordTextField);

        labelsPanel.add(Box.createVerticalStrut(spaceBetweenBoxes));

        JLabel userConfirPasswordJLabel = new JLabel("Confirmar contraseña:");
        userConfirPasswordJLabel.setFont(inputStyle);
        userConfirPasswordJLabel.setForeground(Color.WHITE); // Color del texto
        userConfirPasswordJLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT); // Alinear a la izquierda
        labelsPanel.add(userConfirPasswordJLabel);

        JTextField userConfirPasswordTextField = new JTextField();
        userConfirPasswordTextField.setMaximumSize(new Dimension(200, 30)); // Tamaño máximo del JTextField
        userConfirPasswordTextField.setAlignmentX(JTextField.LEFT_ALIGNMENT); // Alinear a la izquierda
        labelsPanel.add(userConfirPasswordTextField);

        labelsPanel.add(Box.createVerticalStrut(spaceBetweenBoxes));

        JLabel userIdJLabel = new JLabel("Cedula:");
        userIdJLabel.setFont(inputStyle);
        userIdJLabel.setForeground(Color.WHITE); // Color del texto
        userIdJLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT); // Alinear a la izquierda
        labelsPanel.add(userIdJLabel);

        JTextField userIdTextField = new JTextField();
        userIdTextField.setMaximumSize(new Dimension(200, 30)); // Tamaño máximo del JTextField
        userIdTextField.setAlignmentX(JTextField.LEFT_ALIGNMENT); // Alinear a la izquierda
        labelsPanel.add(userIdTextField);

        //button

        JPanel buttonContentCenterPanel = new JPanel();
        buttonContentCenterPanel.setBackground(Color.DARK_GRAY);
        buttonContentCenterPanel.setPreferredSize(new Dimension(100, 100));
        buttonContentCenterPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        buttonContentCenterPanel.setLayout(new BoxLayout(buttonContentCenterPanel, BoxLayout.Y_AXIS));

        JButton confirButton = new JButton("Confirmar");
        confirButton.setFont(new Font("Arial", Font.BOLD, 30));
        confirButton.setBackground(new Color(144, 238, 144));
        confirButton.setForeground(Color.white);
        confirButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        buttonContentCenterPanel.add(confirButton);

        JButton loginButton = new JButton("¿Ya tienes cuenta? Inicia sesión");
        loginButton.setFont(new Font("Arial", Font.PLAIN, 14));
        loginButton.setBackground(Color.DARK_GRAY);
        loginButton.setForeground(Color.LIGHT_GRAY);
        loginButton.setBorderPainted(false);
        loginButton.setContentAreaFilled(false);
        loginButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        buttonContentCenterPanel.add(loginButton);

        contentCenterPanel.add(buttonContentCenterPanel, BorderLayout.SOUTH);
        contentCenterPanel.add(labelsPanel, BorderLayout.CENTER);
        contentCenterPanel.add(titleContentCenterPanel, BorderLayout.NORTH);
        centerPanel.add(contentCenterPanel);
        currentScreen.add(centerPanel, BorderLayout.CENTER);

        confirButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                UserControl userControl = new UserControl();
                String userGmail = userGmailTextField.getText(); 
                String userPassWord =userPasswordTextField.getText();
                String userConfirPassword = userConfirPasswordTextField.getText();

                if (userGmail.trim().isEmpty() || userPassWord.trim().isEmpty() || userConfirPassword.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(!userPassWord.equals(userConfirPassword)){
                    JOptionPane.showMessageDialog(null, "Contraseñas no son iguales", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(userControl.isUser(userGmail, userConfirPassword)){
                    JOptionPane.showMessageDialog(null, "Usuario Existente", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String userId = userIdTextField.getText();
                Integer userIdInteger = Integer.parseInt(userId);
                
                
                //Usa las variables UserName y userPassword para mandarlo a la base de datose
                
                userControl.addNewUser(userIdInteger, userGmail, userPassWord);
                new LoginUI();
                dispose();
            }

        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginUI();
                dispose();
            }
        });

        currentScreen.revalidate();
        currentScreen.repaint();
    }
}
