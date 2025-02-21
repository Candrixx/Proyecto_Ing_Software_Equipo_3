import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.*;

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
        
        currentScreen.removeAll();

        NavBarUI navBarUI = new NavBarUI("Atras");
        currentScreen.add(navBarUI, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.DARK_GRAY);

        currentScreen.add(centerPanel, BorderLayout.CENTER);
        currentScreen.revalidate();
        currentScreen.repaint();

    }

    public static void main(String[] args) {
        EditUserUI editUserUI = new EditUserUI();
        editUserUI.setVisible(true);
    }
}
