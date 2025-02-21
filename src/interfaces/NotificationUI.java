import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.*;

public class NotificationUI extends JFrame {

    private JPanel currentScreen;

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBackground(new Color(34, 113, 179));
        button.setForeground(Color.white);
        button.setPreferredSize(new Dimension(300, 50));
        return button;
    }

    public NotificationUI() {
        currentScreen = new JPanel();
        currentScreen.setLayout(new BorderLayout());

        showScreenNotification();
        add(currentScreen);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private void showScreenNotification() {

        currentScreen.removeAll();

        // ------------------------NavBar panel------------------------
        NavBarUI navBarUI = new NavBarUI();
        currentScreen.add(navBarUI, BorderLayout.NORTH);

        // ------------------------Center panel------------------------
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(new Color(156,156,156));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(60, 60, 60, 60));
        centerPanel.setLayout(new BorderLayout());

        //---centerContentPanel---
        JPanel centerContentPanel = new JPanel();
        centerContentPanel.setBackground(Color.white);
        centerContentPanel.setLayout(new BorderLayout());

        /*
         * 
         * Aqui va el codigo del tablon de anuncios
         * Se puede crear una funcion aparte
         * En este apartado para que se vea en el Jpanel es con centerContentPanel.add(Cosa nueva)
         * 
         */

        centerPanel.add(centerContentPanel, BorderLayout.CENTER);
        currentScreen.add(centerPanel, BorderLayout.CENTER);

        // ------------------------Right panel------------------------
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(new Color(156,156,156));
        rightPanel.setPreferredSize(new Dimension(350, 100));
        rightPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        JButton publishButton = createButton("publicar investigacion");
        rightPanel.add(Box.createVerticalStrut(200));
        rightPanel.add(publishButton);

        JButton createEventButton = createButton("Crear Evento");
        rightPanel.add(createEventButton);

        currentScreen.add(rightPanel, BorderLayout.EAST);

        // ------------------------Refrest the new panel------------------------
        currentScreen.revalidate();
        currentScreen.repaint();
    }

    public static void main(String[] args) {
        NotificationUI notificationUI = new NotificationUI();
        notificationUI.setVisible(true);
    }
}