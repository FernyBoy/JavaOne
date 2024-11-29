package GUI.StartMenu;

// Java awt
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.*;


public class StartMenuFrame extends JFrame
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
    private ArrayList<JLabel> buttonsList = new ArrayList<>();
    private ArrayList<JLabel> buttonsHoverList = new ArrayList<>();

    // Background
    private ImageIcon backgroundAsset;
    private JLabel background;

    // Credits
    private ImageIcon creditsButtonAsset;
    private JLabel creditsButton;
    private ImageIcon creditsButtonHoverAsset;
    private JLabel creditsButtonHover;

    // Instructions
    private ImageIcon instructionButtonAsset;
    private JLabel instructionButton;
    private ImageIcon instructionButtonHoverAsset;
    private JLabel instructionButtonHover;

    // Join party
    private ImageIcon joinPartyButtonAsset;
    private JLabel joinPartyButton;
    private ImageIcon joinPartyButtonHoverAsset;
    private JLabel joinPartyButtonHover;

    // Make party
    private ImageIcon makePartyButtonAsset;
    private JLabel makePartyButton;
    private ImageIcon makePartyButtonHoverAsset;
    private JLabel makePartyButtonHover;

    // Exit
    private ImageIcon exitButtonAsset;
    private JLabel exitButton;
    private ImageIcon exitButtonHoverAsset;
    private JLabel exitButtonHover;

    private void createAssets()
    {
        try
        {
            // Background
            ImageIcon backgroundIcon = new ImageIcon("./GUI/StartMenu/Assets/menu_background.png");
            backgroundAsset = new ImageIcon(backgroundIcon.getImage().getScaledInstance(screenWidth, screenHeight, Image.SCALE_SMOOTH));

            // Make party
            ImageIcon makePartyIcon = new ImageIcon("./GUI/StartMenu/Assets/makeParty_button.png");
            makePartyButtonAsset = new ImageIcon(makePartyIcon.getImage().getScaledInstance(buttonWidth, buttonHeight, Image.SCALE_SMOOTH));
            ImageIcon makePartyHoverIcon = new ImageIcon("./GUI/StartMenu/Assets/makeParty_button_hover.png");
            makePartyButtonHoverAsset = new ImageIcon(makePartyHoverIcon.getImage().getScaledInstance(buttonWidth, buttonHeight, Image.SCALE_SMOOTH));

            // Join party
            ImageIcon joinPartyIcon = new ImageIcon("./GUI/StartMenu/Assets/joinParty_button.png");
            joinPartyButtonAsset = new ImageIcon(joinPartyIcon.getImage().getScaledInstance(buttonWidth, buttonHeight, Image.SCALE_SMOOTH));
            ImageIcon joinPartyHoverIcon = new ImageIcon("./GUI/StartMenu/Assets/joinParty_button_hover.png");
            joinPartyButtonHoverAsset = new ImageIcon(joinPartyHoverIcon.getImage().getScaledInstance(buttonWidth, buttonHeight, Image.SCALE_SMOOTH));

            // Instruction
            ImageIcon instructionIcon = new ImageIcon("./GUI/StartMenu/Assets/instruction_button.png");
            instructionButtonAsset = new ImageIcon(instructionIcon.getImage().getScaledInstance(buttonWidth, buttonHeight, Image.SCALE_SMOOTH));
            ImageIcon instructionHoverIcon = new ImageIcon("./GUI/StartMenu/Assets/instruction_button_hover.png");
            instructionButtonHoverAsset = new ImageIcon(instructionHoverIcon.getImage().getScaledInstance(buttonWidth, buttonHeight, Image.SCALE_SMOOTH));

            // Credits
            ImageIcon creditsIcon = new ImageIcon("./GUI/StartMenu/Assets/credits_button.png");
            creditsButtonAsset = new ImageIcon(creditsIcon.getImage().getScaledInstance(buttonWidth, buttonHeight, Image.SCALE_SMOOTH));
            ImageIcon creditsHoverIcon = new ImageIcon("./GUI/StartMenu/Assets/credits_button_hover.png");
            creditsButtonHoverAsset = new ImageIcon(creditsHoverIcon.getImage().getScaledInstance(buttonWidth, buttonHeight, Image.SCALE_SMOOTH));

            // Exit
            ImageIcon exitIcon = new ImageIcon("./GUI/StartMenu/Assets/exit_button.png");
            exitButtonAsset = new ImageIcon(exitIcon.getImage().getScaledInstance(backButtonWidth, backButtonHeight, Image.SCALE_SMOOTH));
            ImageIcon exitHoverIcon = new ImageIcon("./GUI/StartMenu/Assets/exit_button_hover.png");
            exitButtonHoverAsset = new ImageIcon(exitHoverIcon.getImage().getScaledInstance(backButtonWidth, backButtonHeight, Image.SCALE_SMOOTH));
        }
        catch (Exception e)
        {
            System.out.println("Error loading image: " + e.getMessage());
        }
    }

    private void createButtonsAndBackground()
    {
        // Exit
        exitButton = new JLabel(exitButtonAsset);
        exitButtonHover = new JLabel(exitButtonHoverAsset);
        
        // Credits
        creditsButton = new JLabel(creditsButtonAsset);
        buttonsList.add(creditsButton);
        creditsButtonHover = new JLabel(creditsButtonHoverAsset);
        buttonsHoverList.add(creditsButtonHover);
        
        // Instructions
        instructionButton = new JLabel(instructionButtonAsset);
        buttonsList.add(instructionButton);
        instructionButtonHover = new JLabel(instructionButtonHoverAsset);
        buttonsHoverList.add(instructionButtonHover);
        
        // Join party
        joinPartyButton = new JLabel(joinPartyButtonAsset);
        buttonsList.add(joinPartyButton);
        joinPartyButtonHover = new JLabel(joinPartyButtonHoverAsset);
        buttonsHoverList.add(joinPartyButtonHover);
        
        // Make party
        makePartyButton = new JLabel(makePartyButtonAsset);
        buttonsList.add(makePartyButton);
        makePartyButtonHover = new JLabel(makePartyButtonHoverAsset);
        buttonsHoverList.add(makePartyButtonHover);
        
        // Background
        background = new JLabel(backgroundAsset);
    }

    private void setButtonAndBackgroundPosition()
    {
        int middleScreen = (int) ((screenWidth - buttonWidth) / 2.0);
        int buttonYPostion = (int) (screenHeight - buttonHeight - (buttonHeight / 2.0));

        // Exit position
        exitButton.setBounds((int) (screenWidth - backButtonWidth), 0, backButtonWidth, backButtonHeight);
        exitButtonHover.setBounds((int) (screenWidth - backButtonWidth), 0, backButtonWidth, backButtonHeight);

        // Credits position
        creditsButton.setBounds(middleScreen, buttonYPostion, buttonWidth, buttonHeight);
        creditsButtonHover.setBounds(middleScreen, buttonYPostion, buttonWidth, buttonHeight);

        // Instructions position
        buttonYPostion -= (int) (buttonHeight + (buttonHeight / 2.0));
        instructionButton.setBounds(middleScreen, buttonYPostion, buttonWidth, buttonHeight);
        instructionButtonHover.setBounds(middleScreen, buttonYPostion, buttonWidth, buttonHeight);
        
        // Join party position
        buttonYPostion -= (int) (buttonHeight + (buttonHeight / 2.0));
        joinPartyButton.setBounds(middleScreen, buttonYPostion, buttonWidth, buttonHeight);
        joinPartyButtonHover.setBounds(middleScreen, buttonYPostion, buttonWidth, buttonHeight);

        // Make party position
        buttonYPostion -= (int) (buttonHeight + (buttonHeight / 2.0));
        makePartyButton.setBounds(middleScreen, buttonYPostion, buttonWidth, buttonHeight);
        makePartyButtonHover.setBounds(middleScreen, buttonYPostion, buttonWidth, buttonHeight);
        
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
        getContentPane().setComponentZOrder(hover, 0);
        repaint();
    }
    public void buttonHoverOff(JLabel button, JLabel hover)
    {
        remove(hover);
        add(button);
        getContentPane().setComponentZOrder(button, 0);
        repaint();
    }

    public StartMenuFrame()
    {
        // Ajustamos nuestro JFrame para pantalla completa
        // --- Esta funcion hace que no aparezca en un lugar aleatorio
        setLocationRelativeTo(null);
        // --- Quitamos el marco del JFrame
        setUndecorated(true);
        // --- Ajustamos el tamanio y posicion
        setBounds(0, 0, screenWidth, screenHeight);
        // --- Establecemos el cierre por defecto
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        createAssets();
        createButtonsAndBackground();
        setButtonAndBackgroundPosition();
        addListeners();
        addButtons();
    }

    public static void main(String[] args)
    {
        StartMenuFrame menu = new StartMenuFrame();
        menu.setVisible(true);
    }
}
