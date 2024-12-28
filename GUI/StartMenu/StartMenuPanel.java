package GUI.StartMenu;

// Java awt
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.*;


public class StartMenuPanel extends JFrame
{
    // Declaramos la variable de nuestra pantalla
    private static Toolkit tool = Toolkit.getDefaultToolkit();
    private static Dimension screenSize = tool.getScreenSize();

    // Obtenemos las medidas de nuestra pantalla
    private int screenWidth = (int) screenSize.getWidth();
    private int screenHeight = (int) screenSize.getHeight();

    // Definimos el tamanio de los botones
    private int buttonWidth = (int) (screenWidth * 0.2082);
    private int buttonHeight = (int) (buttonWidth * (1.0/5.0));

    // Tamanio de los botones
    private int backButtonWidth = (int) (screenWidth * 0.09375);
    private int backButtonHeight = (int) (backButtonWidth * (7.0 / 9.0));

    // Arrays de botones
    private ArrayList<JLabel> buttonsList = new ArrayList<>();
    private ArrayList<ImageIcon> buttonsIconsList = new ArrayList<>();
    private ArrayList<ImageIcon> buttonsHoversList = new ArrayList<>();

    // Background
    private ImageIcon backgroundAsset;
    private JLabel background;

    // Credits
    private ImageIcon creditsButtonIcon;
    private ImageIcon creditsButtonHover;
    private JLabel creditsButton = new JLabel();

    // Instructions
    private ImageIcon instructionButtonIcon;
    private ImageIcon instructionButtonHover;
    private JLabel instructionButton = new JLabel();

    // Join party
    private ImageIcon joinPartyButtonIcon;
    private ImageIcon joinPartyButtonHover;
    private JLabel joinPartyButton = new JLabel();

    // Make party
    private ImageIcon makePartyButtonIcon;
    private ImageIcon makePartyButtonHover;
    private JLabel makePartyButton = new JLabel();

    // Exit
    private ImageIcon exitButtonIcon;
    private ImageIcon exitButtonHover;
    private JLabel exitButton = new JLabel();

    private ImageIcon createIcon(String url, int width, int height)
    {
        return new ImageIcon
        (
            new ImageIcon("./GUI/StartMenu/Assets/" + url)
            .getImage()
            .getScaledInstance(width, height, Image.SCALE_SMOOTH)
        ); 
    }

    private void createAssets()
    {
        try
        {
            // Credits
            creditsButtonIcon = createIcon("Buttons/Icons/credits_button_icon.png", buttonWidth, buttonHeight);
            creditsButtonHover = createIcon("Buttons/Hovers/credits_button_hover.png", buttonWidth, buttonHeight);
            buttonsIconsList.add(creditsButtonIcon);
            buttonsHoversList.add(creditsButtonHover);
            
            // Instruction
            instructionButtonIcon = createIcon("Buttons/Icons/instruction_button_icon.png", buttonWidth, buttonHeight);
            instructionButtonHover = createIcon("Buttons/Hovers/instruction_button_hover.png", buttonWidth, buttonHeight);
            buttonsIconsList.add(instructionButtonIcon);
            buttonsHoversList.add(instructionButtonHover);

            // Join party
            joinPartyButtonIcon = createIcon("Buttons/Icons/joinParty_button_icon.png", buttonWidth, buttonHeight);
            joinPartyButtonHover = createIcon("Buttons/Hovers/joinParty_button_hover.png", buttonWidth, buttonHeight);
            buttonsIconsList.add(joinPartyButtonIcon);
            buttonsHoversList.add(joinPartyButtonHover);

            // Make party
            makePartyButtonIcon = createIcon("Buttons/Icons/makeParty_button_icon.png", buttonWidth, buttonHeight);
            makePartyButtonHover = createIcon("Buttons/Hovers/makeParty_button_hover.png", buttonWidth, buttonHeight);
            buttonsIconsList.add(makePartyButtonIcon);
            buttonsHoversList.add(makePartyButtonHover);

            // Exit
            exitButtonIcon = createIcon("Buttons/Icons/exit_button_icon.png", backButtonWidth, backButtonHeight);
            exitButtonHover = createIcon("Buttons/Hovers/exit_button_hover.png", backButtonWidth, backButtonHeight);
            
            // Background
            backgroundAsset = createIcon("menu_background.png", screenWidth, screenHeight);
        }
        catch (Exception e)
        {
            System.out.println("Error loading image: " + e.getMessage());
        }
    }

    private void setButtonsAndBackgroundIcons()
    {
        // Credits
        creditsButton.setIcon(creditsButtonIcon);
        
        // Instructions
        instructionButton.setIcon(instructionButtonIcon);
        
        // Join party
        joinPartyButton.setIcon(joinPartyButtonIcon);
        
        // Make party
        makePartyButton.setIcon(makePartyButtonIcon);

        // Exit
        exitButton.setIcon(exitButtonIcon);

        // Background
        background = new JLabel(backgroundAsset);
    }

    private void setButtonsAndBackgroundPosition()
    {
        int middleScreen = (int) ((screenWidth - buttonWidth) / 2.0);
        int buttonYPostion = (int) (screenHeight - buttonHeight - (buttonHeight / 2.0));

        // Credits position
        creditsButton.setBounds(middleScreen, buttonYPostion, buttonWidth, buttonHeight);
        buttonsList.add(creditsButton);

        // Instructions position
        buttonYPostion -= (int) (buttonHeight + (buttonHeight / 2.0));
        instructionButton.setBounds(middleScreen, buttonYPostion, buttonWidth, buttonHeight);
        buttonsList.add(instructionButton);
        
        // Join party position
        buttonYPostion -= (int) (buttonHeight + (buttonHeight / 2.0));
        joinPartyButton.setBounds(middleScreen, buttonYPostion, buttonWidth, buttonHeight);
        buttonsList.add(joinPartyButton);

        // Make party position
        buttonYPostion -= (int) (buttonHeight + (buttonHeight / 2.0));
        makePartyButton.setBounds(middleScreen, buttonYPostion, buttonWidth, buttonHeight);
        buttonsList.add(makePartyButton);
        
        // Exit position
        exitButton.setBounds((int) (screenWidth - backButtonWidth), 0, backButtonWidth, backButtonHeight);

    setLocationRelativeTo(null);
        // Background position
        background.setBounds(0, 0, screenWidth, screenHeight);
    }

    private void addListeners()
    {
        for(JLabel button : buttonsList)
        {
            button.addMouseListener(new java.awt.event.MouseAdapter() 
            {
                public void mouseEntered(java.awt.event.MouseEvent evt)
                {
                   buttonHoverOn(button, buttonsHoversList.get(buttonsList.indexOf(button)));
                }
                public void mouseExited(java.awt.event.MouseEvent evt)
                {
                   buttonHoverOff(button, buttonsIconsList.get(buttonsList.indexOf(button)));
                }
            });
        }

        exitButton.addMouseListener(new java.awt.event.MouseAdapter() 
        {            
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                closeGame();
            }
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
               buttonHoverOn(exitButton, exitButtonHover);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
               buttonHoverOff(exitButton, exitButtonIcon);
            }
        });
    }

    private void addButtons()
    {
        for(JLabel button : buttonsList)
        {
            this.add(button);
        }

        this.add(exitButton);

        this.add(background);
    }
        

    // Listeners
    public void closeGame()
    {
        System.exit(0);
    }

    private void buttonHoverOn(JLabel button, ImageIcon hover)
    {
        button.setIcon(hover);
        repaint();
    }

    private void buttonHoverOff(JLabel button, ImageIcon icon)
    {
        button.setIcon(icon);
        repaint();
    }

//    public void buttonHoverOn(JLabel button, JLabel hover)
//    {
//        remove(button);
//        add(hover);
//        setComponentZOrder(hover, 0);
//        repaint();
//    }
//    public void buttonHoverOff(JLabel button, JLabel hover)
//    {
//        remove(hover);
//        add(button);
//        setComponentZOrder(button, 0);
//        repaint();
//    }


    private StartMenuPanel()
    {
        // Ajustamos nuestro JFrame para pantalla completa
        // --- Ajustamos el tamanio y posicion
        // setBounds(0, 0, screenWidth, screenHeight);
        
        // Ajustamos nuestro JFrame para pantalla completa
        // --- Esta funcion hace que no aparezca en un lugar aleatorio
        this.setLocationRelativeTo(null);
        // --- Quitamos el marco del JFrame
        this.setUndecorated(true);
        // --- Ajustamos el tamanio y posicion
        this.setBounds(0, 0, screenWidth, screenHeight);
        // --- Establecemos el cierre por defecto
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        createAssets();
        setButtonsAndBackgroundIcons();
        setButtonsAndBackgroundPosition();
        addListeners();
        addButtons();

        this.setVisible(true);
    }

    public static void main(String[] args)
    {
        StartMenuPanel menu = new StartMenuPanel();
    }
}
