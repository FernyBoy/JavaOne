package GUI.StartMenu;

// Java awt
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.*;


public class StartMenuPanel extends JPanel
{
    // Declaramos la variable de nuestra pantall
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
    private ArrayList<JButton> buttonsList = new ArrayList<>();
    private ArrayList<ImageIcon> buttonsIconsList = new ArrayList<>();
    private ArrayList<ImageIcon> buttonsHoverList = new ArrayList<>();

    // Background
    private ImageIcon backgroundAsset;
    private JLabel background;

    // Credits
    private ImageIcon creditsButtonIcon;
    private ImageIcon creditsButtonHover;
    private JButton creditsButton;

    // Instructions
    private ImageIcon instructionButtonIcon;
    private ImageIcon instructionButtonHover;
    private JButton instructionButton;

    // Join party
    private ImageIcon joinPartyButtonIcon;
    private ImageIcon joinPartyButtonHover;
    private JButton joinPartyButton;

    // Make party
    private ImageIcon makePartyButtonIcon;
    private ImageIcon makePartyButtonHover;
    private JButton makePartyButton;

    // Exit
    private ImageIcon exitButtonIcon;
    private ImageIcon exitButtonHover;
    private JButton exitButton;

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
            
            // Instruction
            instructionButtonIcon = createIcon("Buttons/Icons/instruction_button_icon.png", buttonWidth, buttonHeight);
            instructionButtonHover = createIcon("Buttons/Hovers/instruction_button_hover.png", buttonWidth, buttonHeight);

            // Join party
            joinPartyButtonIcon = createIcon("Buttons/Icons/joinParty_button_icon.png", buttonWidth, buttonHeight);
            joinPartyButtonHover = createIcon("Buttons/Hovers/joinParty_button_hover.png", buttonWidth, buttonHeight);

            // Make party
            makePartyButtonIcon = createIcon("Buttons/Icons/makeParty_button_icon.png", buttonWidth, buttonHeight);
            makePartyButtonHover = createIcon("Buttons/Hovers/makeParty_button_hover.png", buttonWidth, buttonHeight);
            
            // Exit
            exitButtonIcon = createIcon("Buttons/Icons/exit_button_icon.png", buttonWidth, buttonHeight);
            exitButtonHover = createIcon("Buttons/Hovers/exit_button_hover.png", buttonWidth, buttonHeight);
            
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

    private void setButtonAndBackgroundPosition()
    {
        int middleScreen = (int) ((screenWidth - buttonWidth) / 2.0);
        int buttonYPostion = (int) (screenHeight - buttonHeight - (buttonHeight / 2.0));

        // Credits position
        creditsButton.setBounds(middleScreen, buttonYPostion, buttonWidth, buttonHeight);

        // Instructions position
        buttonYPostion -= (int) (buttonHeight + (buttonHeight / 2.0));
        instructionButton.setBounds(middleScreen, buttonYPostion, buttonWidth, buttonHeight);
        
        // Join party position
        buttonYPostion -= (int) (buttonHeight + (buttonHeight / 2.0));
        joinPartyButton.setBounds(middleScreen, buttonYPostion, buttonWidth, buttonHeight);

        // Make party position
        buttonYPostion -= (int) (buttonHeight + (buttonHeight / 2.0));
        makePartyButton.setBounds(middleScreen, buttonYPostion, buttonWidth, buttonHeight);
        
        // Exit position
        exitButton.setBounds((int) (screenWidth - backButtonWidth), 0, backButtonWidth, backButtonHeight);
        exitButtonHover.setBounds((int) (screenWidth - backButtonWidth), 0, backButtonWidth, backButtonHeight);

        // Background position
        background.setBounds(0, 0, screenWidth, screenHeight);
    }

    private void addListeners()
    {
        exitButton.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
               buttonHoverOn(exitButton, exitButtonHover);
            }
        });
        
        exitButtonHover.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                closeGame();
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
               buttonHoverOff(exitButton, exitButtonHover);
            }
        });

        for(JLabel button : buttonsList)
        {
            button.addMouseListener(new java.awt.event.MouseAdapter() 
            {
                public void mouseEntered(java.awt.event.MouseEvent evt)
                {
                   buttonHoverOn(button, buttonsHoverList.get(buttonsList.indexOf(button)));
                }
            });
        }

        for(JLabel hover : buttonsHoverList)
        {
            hover.addMouseListener(new java.awt.event.MouseAdapter() 
            {
                public void mouseExited(java.awt.event.MouseEvent evt)
                {
                   buttonHoverOff(buttonsList.get(buttonsHoverList.indexOf(hover)), hover);
                }
            });
        }
    }

    private void addButtons()
    {
        // add(exitButtonHover);

        add(exitButton);

        for(JLabel button : buttonsList)
        {
            add(button);
        }

        add(background);
    }

    // Listeners
    public void closeGame()
    {
        System.exit(0);
    }

    public void buttonHoverOn(JLabel button, JLabel hover)
    {
        remove(button);
        add(hover);
        setComponentZOrder(hover, 0);
        repaint();
    }
    public void buttonHoverOff(JLabel button, JLabel hover)
    {
        remove(hover);
        add(button);
        setComponentZOrder(button, 0);
        repaint();
    }

    public StartMenuPanel()
    {
        // Ajustamos nuestro JFrame para pantalla completa
        // --- Ajustamos el tamanio y posicion
        setBounds(0, 0, screenWidth, screenHeight);

        createAssets();
        createButtonsAndBackground();
        setButtonAndBackgroundPosition();
        addListeners();
        addButtons();
    }
}
