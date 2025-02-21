import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.*;

public class NavBarUI extends JPanel {
    
    public NavBarUI(){

        //------------------------NavBar configuration---------------------------------
        setBackground(Color.gray);
        setPreferredSize(new Dimension(100, 100));

        setLayout(new BorderLayout());
        
        Color backgroundColor = getBackground();

        //------------------------logo configuration---------------------------------
        JLabel labelLogo = new JLabel("Logo");
        labelLogo.setForeground(Color.white);

        JPanel logoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 40));
        logoPanel.setBackground(backgroundColor); 
        logoPanel.add(labelLogo);

        Font newStyle = new Font("Arial", Font.BOLD, 20);
        labelLogo.setFont(newStyle);

        add(logoPanel, BorderLayout.WEST);
        add(Box.createHorizontalGlue(), BorderLayout.CENTER);

        //------------------------User button configuration---------------------------------
        JButton userButton = new JButton("User");
        userButton.setPreferredSize(new Dimension(100, 40));

        JPanel userButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 30));
        userButtonPanel.setBackground(backgroundColor); 
        userButtonPanel.add(userButton);

        add(userButtonPanel, BorderLayout.EAST);

    }

    public NavBarUI(String nameButton){

        //------------------------NavBar configuration---------------------------------
        setBackground(Color.gray);
        setPreferredSize(new Dimension(100, 100));

        setLayout(new BorderLayout());
        
        Color backgroundColor = getBackground();

        //------------------------logo configuration---------------------------------
        JLabel labelLogo = new JLabel("Logo");
        labelLogo.setForeground(Color.white);

        JPanel logoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 40));
        logoPanel.setBackground(backgroundColor); 
        logoPanel.add(labelLogo);

        Font newStyle = new Font("Arial", Font.BOLD, 20);
        labelLogo.setFont(newStyle);

        add(logoPanel, BorderLayout.WEST);
        add(Box.createHorizontalGlue(), BorderLayout.CENTER);

        //------------------------User button configuration---------------------------------
        JButton userButton = new JButton(nameButton);
        userButton.setPreferredSize(new Dimension(100, 40));

        JPanel userButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 30));
        userButtonPanel.setBackground(backgroundColor); 
        userButtonPanel.add(userButton);

        add(userButtonPanel, BorderLayout.EAST);

    }

}
