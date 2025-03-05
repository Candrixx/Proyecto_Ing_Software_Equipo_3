package  src.vistas;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

import javax.swing.*;

import src.controllers.UserControl;

public class EditUserUI extends JFrame {

    private JPanel currentScreen;
    
    public EditUserUI(){

        currentScreen = new JPanel();
        currentScreen.setLayout(new BorderLayout());

        showScreenEditUserUI();
        add(currentScreen);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

    }

    private void showScreenEditUserUI() {
        Font inputStyle = new Font("Arial", Font.BOLD, 20);
        int spaceBetweenBoxes = 80;
        
        currentScreen.removeAll();

        NavBarUI navBarUI = new NavBarUI("Atras");
        currentScreen.add(navBarUI, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.lightGray);
        centerPanel.setBorder(BorderFactory.createEmptyBorder(60, 60, 60, 60));
        centerPanel.setLayout(new BorderLayout());

        JPanel centerContentPanel = new JPanel();
        centerContentPanel.setBackground(Color.darkGray);
        centerContentPanel.setLayout(new BorderLayout());

        JPanel picturContentPanel = new JPanel();
        picturContentPanel.setBackground(Color.darkGray);
        picturContentPanel.setPreferredSize(new Dimension(720,0));

        JLabel temporalLabel = new JLabel("Picture");
        temporalLabel.setForeground(Color.white);
        temporalLabel.setFont(new Font("Arial", Font.BOLD, 50));
        picturContentPanel.add(temporalLabel);

        JPanel labelcontentJPanel = new JPanel();
        labelcontentJPanel.setBackground(Color.darkGray);
        labelcontentJPanel.setPreferredSize(new Dimension(700,0));
        labelcontentJPanel.setLayout(new BoxLayout(labelcontentJPanel, BoxLayout.Y_AXIS));
        labelcontentJPanel.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));

        JLabel userNameJLabel = new JLabel("Nombre usuario:");
        userNameJLabel.setFont(inputStyle);
        userNameJLabel.setForeground(Color.WHITE); // Color del texto
        userNameJLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT); // Alinear a la izquierda
        labelcontentJPanel.add(userNameJLabel);

        JTextField userNameTextField = new JTextField();
        userNameTextField.setMaximumSize(new Dimension(300, 30)); // Tamaño máximo del JTextField
        userNameTextField.setAlignmentX(JTextField.LEFT_ALIGNMENT); // Alinear a la izquierda
        labelcontentJPanel.add(userNameTextField);

        labelcontentJPanel.add(Box.createVerticalStrut(spaceBetweenBoxes));

        JLabel userIdJLabel = new JLabel("Cedula:");
        userIdJLabel.setFont(inputStyle);
        userIdJLabel.setForeground(Color.WHITE); // Color del texto
        userIdJLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT); // Alinear a la izquierda
        labelcontentJPanel.add(userIdJLabel);

        JTextField userIdTextField = new JTextField();
        userIdTextField.setMaximumSize(new Dimension(300, 30)); // Tamaño máximo del JTextField
        userIdTextField.setAlignmentX(JTextField.LEFT_ALIGNMENT); // Alinear a la izquierda
        labelcontentJPanel.add(userIdTextField);

        labelcontentJPanel.add(Box.createVerticalStrut(spaceBetweenBoxes));

        JLabel userPasswordJLabel = new JLabel("Contraseña:");
        userPasswordJLabel.setFont(inputStyle);
        userPasswordJLabel.setForeground(Color.WHITE); // Color del texto
        userPasswordJLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT); // Alinear a la izquierda
        labelcontentJPanel.add(userPasswordJLabel);

        JTextField userPasswordTextField = new JTextField();
        userPasswordTextField.setMaximumSize(new Dimension(300, 30)); // Tamaño máximo del JTextField
        userPasswordTextField.setAlignmentX(JTextField.LEFT_ALIGNMENT); // Alinear a la izquierda
        labelcontentJPanel.add(userPasswordTextField);


        //button

        JPanel buttonContentPanel = new JPanel();
        buttonContentPanel.setBackground(Color.darkGray);
        buttonContentPanel.setPreferredSize(new Dimension(100,80));
        buttonContentPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        JButton confirButton = new JButton("Confirmar");
        confirButton.setFont(new Font("Arial", Font.BOLD, 25));
        confirButton.setBackground(new Color(144, 238, 144));
        confirButton.setForeground(Color.white);
        confirButton.setPreferredSize(new Dimension(300, 50));
        buttonContentPanel.add(confirButton);

        confirButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                String userName = userNameTextField.getText(); 
                String userPassWord = userPasswordTextField.getText();
                String userId = userIdTextField.getText();
                Integer userIdInteger = Integer.parseInt(userId);

                UserControl userControl = new UserControl();
                userControl.setUserData(userIdInteger, userName, userPassWord);
                
                //Usa las variables UserName y userPassword para mandarlo a la base de datose

            }


        });

        centerContentPanel.add(labelcontentJPanel, BorderLayout.EAST);
        centerContentPanel.add(picturContentPanel, BorderLayout.WEST);
        centerContentPanel.add(buttonContentPanel, BorderLayout.SOUTH);
        centerPanel.add(centerContentPanel);
        currentScreen.add(centerPanel, BorderLayout.CENTER);
        currentScreen.revalidate();
        currentScreen.repaint();

    }

    public static void main(String[] args) {
        EditUserUI editUserUI = new EditUserUI();
        editUserUI.setVisible(true);
    }
}
