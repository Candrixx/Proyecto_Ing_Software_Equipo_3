import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginUI extends JFrame {

    private JPanel currentScreen;

    public LoginUI() {
        currentScreen = new JPanel();
        currentScreen.setLayout(new BorderLayout());

        showLoginUI();
        add(currentScreen);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private void showLoginUI() {
        Font currentStyle = new Font("Arial", Font.BOLD, 25);
        Font inputStyle = new Font("Arial", Font.BOLD, 16);
        currentScreen.removeAll();

        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.BLUE);
        centerPanel.setLayout(new GridBagLayout());

        JPanel contentCenterPanel = new JPanel();
        contentCenterPanel.setBackground(Color.DARK_GRAY);
        contentCenterPanel.setPreferredSize(new Dimension(600, 400));
        contentCenterPanel.setLayout(new BorderLayout());

        //labels

        // Panel para agrupar los JLabel y JTextField
        JPanel labelsPanel = new JPanel();
        labelsPanel.setBackground(Color.DARK_GRAY); // Fondo del panel
        labelsPanel.setLayout(new BoxLayout(labelsPanel, BoxLayout.Y_AXIS));
        labelsPanel.setBorder(BorderFactory.createEmptyBorder(50, 150, 0, 0)); // Organizar los componentes verticalmente

        JLabel userNameJLabel = new JLabel("Nombre usuario:");
        userNameJLabel.setFont(inputStyle);
        userNameJLabel.setForeground(Color.WHITE); // Color del texto
        userNameJLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT); // Alinear a la izquierda
        labelsPanel.add(userNameJLabel);

        // JTextField para el nombre de usuario
        JTextField userNameTextField = new JTextField();
        userNameTextField.setMaximumSize(new Dimension(200, 30)); // Tamaño máximo del JTextField
        userNameTextField.setAlignmentX(JTextField.LEFT_ALIGNMENT); // Alinear a la izquierda
        labelsPanel.add(userNameTextField);

        // Espacio personalizado entre el JTextField y el siguiente JLabel
        labelsPanel.add(Box.createVerticalStrut(40)); // Ajusta el valor para cambiar el espacio entre label y text

        JLabel userPassWordJLabel = new JLabel("Contraseña");
        userPassWordJLabel.setFont(inputStyle);
        userPassWordJLabel.setForeground(Color.WHITE); // Color del texto
        userPassWordJLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT); // Alinear a la izquierda
        labelsPanel.add(userPassWordJLabel);

        // JPasswordField para la contraseña
        JPasswordField userPasswordField = new JPasswordField();
        userPasswordField.setMaximumSize(new Dimension(200, 30)); // Tamaño máximo del JPasswordField
        userPasswordField.setAlignmentX(JPasswordField.LEFT_ALIGNMENT); // Alinear a la izquierda
        labelsPanel.add(userPasswordField);

        //title

        JPanel titleContentCenterPanel = new JPanel();
        titleContentCenterPanel.setBackground(Color.DARK_GRAY);
        titleContentCenterPanel.setPreferredSize(new Dimension(600, 50)); 
        titleContentCenterPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel titleLabel = new JLabel("Iniciar sesion");
        titleLabel.setFont(currentStyle);
        titleLabel.setForeground(Color.WHITE);
        titleContentCenterPanel.add(titleLabel);

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
                
                String userName = userNameTextField.getText(); 
                String userPassWord = userPassWordJLabel.getText();
                
                //Usa las variables UserName y userPassword para mandarlo a la base de datose

            }


        });

        currentScreen.revalidate();
        currentScreen.repaint();
    }

    public static void main(String[] args) {
        LoginUI loginUI = new LoginUI();
        loginUI.setVisible(true);
    }
}