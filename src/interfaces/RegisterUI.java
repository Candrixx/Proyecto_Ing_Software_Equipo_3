import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

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
        labelsPanel.setBorder(BorderFactory.createEmptyBorder(30, 180, 0, 0));

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
        buttonContentCenterPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        JButton confirButton = new JButton("Confirmar");
        confirButton.setFont(new Font("Arial", Font.BOLD, 25));
        confirButton.setBackground(new Color(144, 238, 144));
        confirButton.setForeground(Color.white);
        confirButton.setPreferredSize(new Dimension(300, 50));
        buttonContentCenterPanel.add(confirButton);

        contentCenterPanel.add(buttonContentCenterPanel, BorderLayout.SOUTH);
        contentCenterPanel.add(labelsPanel, BorderLayout.CENTER);
        contentCenterPanel.add(titleContentCenterPanel, BorderLayout.NORTH);
        centerPanel.add(contentCenterPanel);
        currentScreen.add(centerPanel, BorderLayout.CENTER);

        confirButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                String userGmail = userGmailJLabel.getText(); 
                String userPassWord = userConfirPasswordJLabel.getText();
                String userId = userIdTextField.getText();
                
                //Usa las variables UserName y userPassword para mandarlo a la base de datose

            }


        });

        currentScreen.revalidate();
        currentScreen.repaint();
    }
    public static void main(String[] args) {
        RegisterUI registerUI = new RegisterUI();
        registerUI.setVisible(true);
    }
}
