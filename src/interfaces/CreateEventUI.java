import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CreateEventUI extends JFrame{

    private JPanel currentScreen;
    
    public CreateEventUI(){

        currentScreen = new JPanel();
        currentScreen.setLayout(new BorderLayout());

        showScreenCreateEvent();
        add(currentScreen);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

    }

    private void showScreenCreateEvent(){
        Font newStyle = new Font("Arial", Font.BOLD, 25);
        Color colorLightGray = new Color(156,156,156);
        Color colorDarkGray = new Color(75,73,71);

        currentScreen.removeAll();

        // ------------------------NavBar panel------------------------
        NavBarUI navBarUI = new NavBarUI();
        currentScreen.add(navBarUI, BorderLayout.NORTH);

        // ------------------------Center panel------------------------
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(colorLightGray);
        centerPanel.setBorder(BorderFactory.createEmptyBorder(60, 60, 60, 60));
        centerPanel.setLayout(new BorderLayout());
        
        JPanel centerContentPanel = new JPanel();
        centerContentPanel.setBackground(colorDarkGray);
        centerContentPanel.setLayout(new BorderLayout());

        //---centerContentTitlePanel---
        JPanel centerContentTitlePanel = new JPanel();
        centerContentTitlePanel.setBackground(colorDarkGray);
        centerContentTitlePanel.setPreferredSize(new Dimension(100,80));
        centerContentTitlePanel.setBorder(BorderFactory.createEmptyBorder(0, 60, 0, 0));
        centerContentTitlePanel.setLayout(new BorderLayout());

        JLabel titleCenterContentPanel = new JLabel("Crear evento");
        titleCenterContentPanel.setFont(newStyle);
        titleCenterContentPanel.setForeground(Color.WHITE);
        centerContentTitlePanel.add(titleCenterContentPanel,BorderLayout.WEST);

        //---centerContentButtonPanel---

        JPanel centerContentButtonPanel = new JPanel();
        centerContentButtonPanel.setBackground(colorDarkGray);
        centerContentButtonPanel.setPreferredSize(new Dimension(100,80));
        centerContentButtonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        centerContentButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton buttonConfirm = new JButton("Confirmar");
        buttonConfirm.setFont(new Font("Arial", Font.BOLD, 25));
        buttonConfirm.setBackground(new Color(144, 238, 144));
        buttonConfirm.setForeground(Color.white);
        buttonConfirm.setPreferredSize(new Dimension(300, 50));
        centerContentButtonPanel.add(buttonConfirm);

        //---centerContentInputPanel---

        JPanel centerContentInputPanel = new JPanel();
        centerContentInputPanel.setBackground(colorDarkGray);
        centerContentInputPanel.setPreferredSize(new Dimension(700,80));
        centerContentInputPanel.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 0));
        centerContentInputPanel.setLayout(new BoxLayout(centerContentInputPanel, BoxLayout.Y_AXIS));

        JLabel dateOfEventLabel = new JLabel("Fecha del evento y hora:");
        dateOfEventLabel.setForeground(Color.white);
        dateOfEventLabel.setFont(newStyle);
        dateOfEventLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        centerContentInputPanel.add(dateOfEventLabel);

        JTextField dateOfEventInput = new JTextField();
        dateOfEventInput.setPreferredSize(new Dimension(200, 40));
        dateOfEventInput.setMaximumSize(new Dimension(200, 40));
        dateOfEventInput.setAlignmentX(Component.LEFT_ALIGNMENT);
        centerContentInputPanel.add(dateOfEventInput);

        centerContentInputPanel.add(Box.createRigidArea(new Dimension(0, 50)));

        JLabel locationOfEventLabel = new JLabel("Ubicacion:");
        locationOfEventLabel.setForeground(Color.white);
        locationOfEventLabel.setFont(newStyle);
        locationOfEventLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        centerContentInputPanel.add(locationOfEventLabel);

        JTextField locationOfEventInput = new JTextField();
        locationOfEventInput.setPreferredSize(new Dimension(200, 40));
        locationOfEventInput.setMaximumSize(new Dimension(200, 40));
        locationOfEventInput.setAlignmentX(Component.LEFT_ALIGNMENT);
        centerContentInputPanel.add(locationOfEventInput);

        centerContentInputPanel.add(Box.createRigidArea(new Dimension(0, 50)));

        JLabel timeOfEventLabel = new JLabel("Titulo:");
        timeOfEventLabel.setForeground(Color.white);
        timeOfEventLabel.setFont(newStyle);
        timeOfEventLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        centerContentInputPanel.add(timeOfEventLabel);

        JTextField timeOfEventInput = new JTextField();
        timeOfEventInput.setPreferredSize(new Dimension(200, 40));
        timeOfEventInput.setMaximumSize(new Dimension(200, 40));
        timeOfEventInput.setAlignmentX(Component.LEFT_ALIGNMENT);
        centerContentInputPanel.add(timeOfEventInput);

        centerContentInputPanel.add(Box.createRigidArea(new Dimension(0, 50)));

        JLabel descriptionOfEventLabel = new JLabel("Descripcion:");
        descriptionOfEventLabel.setForeground(Color.white);
        descriptionOfEventLabel.setFont(newStyle);
        descriptionOfEventLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        centerContentInputPanel.add(descriptionOfEventLabel);

        JTextField descriptionOfEventInput = new JTextField();
        descriptionOfEventInput.setPreferredSize(new Dimension(200, 40));
        descriptionOfEventInput.setMaximumSize(new Dimension(200, 40));
        descriptionOfEventInput.setAlignmentX(Component.LEFT_ALIGNMENT);
        centerContentInputPanel.add(descriptionOfEventInput);

        //---centerContentLoadImage---

        JPanel centerContentLoadImage = new JPanel();
        centerContentLoadImage.setBackground(colorDarkGray);
        centerContentLoadImage.setPreferredSize(new Dimension(700,80));
        centerContentLoadImage.setLayout(new FlowLayout(FlowLayout.CENTER));

        /*
         * En esta parte es donde hay que colocar lo de subir imagenes
         * En este apartado para que se vea en el Jpanel es con centerContentLoadImage.add(Cosa nueva)
         */

        centerContentPanel.add(centerContentLoadImage, BorderLayout.EAST);
        centerContentPanel.add(centerContentInputPanel, BorderLayout.WEST);
        centerContentPanel.add(centerContentButtonPanel, BorderLayout.SOUTH);
        centerContentPanel.add(centerContentTitlePanel, BorderLayout.NORTH);
        centerPanel.add(centerContentPanel, BorderLayout.CENTER);
        currentScreen.add(centerPanel, BorderLayout.CENTER);

        buttonConfirm.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String fechaEvento = dateOfEventInput.getText();
                String ubicacionEvento = locationOfEventInput.getText();
                String tituloEvento = timeOfEventInput.getText();
                String descripcionEvento = descriptionOfEventInput.getText();

            
                System.out.println("Fecha del evento: " + fechaEvento);
                System.out.println("Ubicación del evento: " + ubicacionEvento);
                System.out.println("Título del evento: " + tituloEvento);
                System.out.println("Descripción del evento: " + descripcionEvento);
            }


        });
    
        centerContentButtonPanel.add(buttonConfirm);

        // ------------------------Refrest panel------------------------

        currentScreen.revalidate();
        currentScreen.repaint();
    }

    public static void main(String[] args) {
        CreateEventUI createEventUI = new CreateEventUI();
        createEventUI.setVisible(true);
    }
}
