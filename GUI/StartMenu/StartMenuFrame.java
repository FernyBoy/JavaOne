// Java awt
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.*;


public class StartMenuFrame extends JFrame
{
    // Declaramos la variable de nuestra pantall
    private static Toolkit tool = Toolkit.getDefaultToolkit();
    private static Dimension screenSize = tool.getScreenSize();

    // Obtenemos las medidas de nuestra pantalla
    private int screenWidth = (int) screenSize.getWidth();
    private int screenHeight = (int) screenSize.getHeight();

    // Background
    private ImageIcon backgroundAsset;
    private JLabel background;

    // Make party
    private ImageIcon makePartyButtonAsset;
    private JLabel makePartyButton;
    private ImageIcon makePartyButtonHoverAsset;
    private JLabel makePartyButtonHover;

    // Join party
    private ImageIcon joinPartyButtonAsset;
    private JLabel joinPartyButton;
    private ImageIcon joinPartyButtonHoverAsset;
    private JLabel joinPartyButtonHover;

    // Instructions
    private ImageIcon instructionButtonAsset;
    private JLabel instructionButton;
    private ImageIcon instructionButtonHoverAsset;
    private JLabel instructionButtonHover;

    // Credits
    private ImageIcon creditsButtonAsset;
    private JLabel creditsButton;
    private ImageIcon creditsButtonHoverAsset;
    private JLabel creditsButtonHover;

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
            ImageIcon backgroundIcon = new ImageIcon("./Assets/menu_background.png");
            backgroundAsset = new ImageIcon(backgroundIcon.getImage().getScaledInstance(screenWidth, screenHeight, Image.SCALE_SMOOTH));

            // Make party
            ImageIcon makePartyIcon = new ImageIcon("./Assets/makeParty_button.png");
            makePartyButtonAsset = new ImageIcon(makePartyIcon.getImage().getScaledInstance(screenWidth, screenHeight, Image.SCALE_SMOOTH));
            ImageIcon makePartyHoverIcon = new ImageIcon("./Assets/makeParty_button_hover.png");
            makePartyButtonHoverAsset = new ImageIcon(makePartyHoverIcon.getImage().getScaledInstance(screenWidth, screenHeight, Image.SCALE_SMOOTH));

            // Join party
            ImageIcon joinPartyIcon = new ImageIcon("./Assets/joinParty_button.png");
            joinPartyButtonAsset = new ImageIcon(joinPartyIcon.getImage().getScaledInstance(screenWidth, screenHeight, Image.SCALE_SMOOTH));
            ImageIcon joinPartyHoverIcon = new ImageIcon("./Assets/joinParty_button_hover.png");
            joinPartyButtonHoverAsset = new ImageIcon(joinPartyHoverIcon.getImage().getScaledInstance(screenWidth, screenHeight, Image.SCALE_SMOOTH));

            // Instruction
            ImageIcon instructionIcon = new ImageIcon("./Assets/instruction_button.png");
            instructionButtonAsset = new ImageIcon(instructionIcon.getImage().getScaledInstance(screenWidth, screenHeight, Image.SCALE_SMOOTH));
            ImageIcon instructionHoverIcon = new ImageIcon("./Assets/instruction_button_hover.png");
            instructionButtonHoverAsset = new ImageIcon(instructionHoverIcon.getImage().getScaledInstance(screenWidth, screenHeight, Image.SCALE_SMOOTH));

            // Credits
            ImageIcon creditsIcon = new ImageIcon("./Assets/credits_button.png");
            creditsButtonAsset = new ImageIcon(creditsIcon.getImage().getScaledInstance(screenWidth, screenHeight, Image.SCALE_SMOOTH));
            ImageIcon creditsHoverIcon = new ImageIcon("./Assets/credits_button_hover.png");
            creditsButtonHoverAsset = new ImageIcon(creditsHoverIcon.getImage().getScaledInstance(screenWidth, screenHeight, Image.SCALE_SMOOTH));

            // Exit
            ImageIcon exitIcon = new ImageIcon("./Assets/exit_button.png");
            exitButtonAsset = new ImageIcon(exitIcon.getImage().getScaledInstance(screenWidth, screenHeight, Image.SCALE_SMOOTH));
            ImageIcon exitHoverIcon = new ImageIcon("./Assets/exit_button_hover.png");
            exitButtonHoverAsset = new ImageIcon(exitHoverIcon.getImage().getScaledInstance(screenWidth, screenHeight, Image.SCALE_SMOOTH));
        }
        catch (Exception e)
        {
            System.out.println("Error loading image: " + e.getMessage());
        }
    }

    private void createButtonsAndBackground()
    {
        // Background
        background = new JLabel(backgroundAsset);

        // Make party
        makePartyButton = new JLabel(makePartyButtonAsset);
        makePartyButtonHover = new JLabel(makePartyButtonHoverAsset);

        // Join party
        joinPartyButton = new JLabel(joinPartyButtonAsset);
        joinPartyButtonHover = new JLabel(joinPartyButtonHoverAsset);

        // Instructions
        instructionButton = new JLabel(instructionButtonAsset);
        instructionButtonHover = new JLabel(instructionButtonHoverAsset);

        // Credits
        creditsButton = new JLabel(creditsButtonAsset);
        creditsButtonHover = new JLabel(creditsButtonHoverAsset);

        // Exit
        exitButton = new JLabel(exitButtonAsset);
        exitButtonHover = new JLabel(exitButtonHoverAsset);
    }

    private void setButtonAndBackgroundPosition()
    {
        // Background position
        background.setBounds(0, 0, screenWidth, screenHeight);

        // Make party position
        makePartyButton.setBounds(0, 0, screenWidth, screenHeight);

        // Join party position
        joinPartyButton.setBounds(0, 0, screenWidth, screenHeight);

        // Instructions position
        instructionButton.setBounds(0, 0, screenWidth, screenHeight);

        // Credits position
        creditsButton.setBounds(0, 0, screenWidth, screenHeight);

        // Exit position
        exitButton.setBounds(0, 0, screenWidth, screenHeight);
    }

    private void addButtons()
    {
        add(exitButton);

        add(creditsButton);

        add(instructionButton);

        add(joinPartyButton);

        add(makePartyButton);

        add(background);
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
        addButtons();
    }

    public static void main(String[] args)
    {
        StartMenuFrame menu = new StartMenuFrame();
        menu.setVisible(true);
    }
}
