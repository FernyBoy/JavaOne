// Java awt
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.*;


public class TableFrame extends JFrame
{
    // Declaramos la variable de nuestra pantalla
    private static Toolkit tool = Toolkit.getDefaultToolkit();
    private static Dimension screenSize = tool.getScreenSize();

    // Establecemos nuestras medidas
    private int screenWidth = (int) screenSize.getWidth();
    private int screenHeight = (int) screenSize.getHeight();
    
    // Declaro las nuevas dimensiones
    int cardsWidth = (int)(screenWidth * 0.075); // Relacion de las cartas respecto al tamanio de pantalla
    int cardsHeight = (int) (cardsWidth * (181.0/125.0)); // Relacion de aspecto de las cartas: 181/125 

    int availableCardsWidth = (int)(screenWidth * 0.10);
    int availableCardsHeight = (int) (availableCardsWidth * (181.0/125.0));

    int playedCardsWidth = (int)(screenWidth * 0.12);
    int playedCardsHeight = (int) (playedCardsWidth * (181.0/125.0));


    private ImageIcon tableAsset;
    private ImageIcon availableCardsAsset;
    private ImageIcon playedCardsAsset;
    private ArrayList<ImageIcon> player1CardsAssets = new ArrayList<>(); 
    private ArrayList<ImageIcon> player2CardsAssets = new ArrayList<>();
    private ArrayList<JLabel> player1Cards = new ArrayList<>();
    private ArrayList<JLabel> player2Cards = new ArrayList<>();

    private JLabel table;
    private JLabel availableCards;
    private JLabel playedCards;

    private void createAssets()
    {
        // Se importan las cartas y el tablero, las redimensionamos y las volvemos a convertir en un icono\
        try
        {
            ImageIcon tableIcon = new ImageIcon("./Assets/table_background.png");
            tableAsset = new ImageIcon(tableIcon.getImage().getScaledInstance(screenWidth, screenHeight, Image.SCALE_SMOOTH));

            ImageIcon availableCardsIcon = new ImageIcon("../../Cards/Assets/back_view_card.png");
            availableCardsAsset = new ImageIcon(availableCardsIcon.getImage().getScaledInstance(availableCardsWidth, availableCardsHeight, Image.SCALE_SMOOTH));

            ImageIcon playedCardsIcon = new ImageIcon("../../Cards/Assets/java/powerCards/java_base_card.png");
            playedCardsAsset = new ImageIcon(playedCardsIcon.getImage().getScaledInstance(playedCardsWidth, playedCardsHeight, Image.SCALE_SMOOTH));
        }
        catch (Exception e)
        {
            System.out.println("Error loading image: " + e.getMessage());
        }

        // --- Player 1 Cards
        for(int i = 0; i < 10; i++)
        {
            try
            {
                ImageIcon player1NumberCardsIcon = new ImageIcon("../../Cards/Assets/cpp/numberCards/cpp_" + i + "_card.png");
                player1CardsAssets.add(new ImageIcon(player1NumberCardsIcon.getImage().getScaledInstance(cardsWidth, cardsHeight, Image.SCALE_SMOOTH)));
            }
            catch (Exception e)
            {
                System.out.println("Error loading image: " + e.getMessage());
            }
        }

        try
        {
            ImageIcon player1BlockCardIcon = new ImageIcon("../../Cards/Assets/cpp/powerCards/cpp_block_card.png");
            player1CardsAssets.add(new ImageIcon(player1BlockCardIcon.getImage().getScaledInstance(cardsWidth, cardsHeight, Image.SCALE_SMOOTH)));

            ImageIcon player1TaketwoCardIcon = new ImageIcon("../../Cards/Assets/cpp/powerCards/cpp_taketwo_card.png");
            player1CardsAssets.add(new ImageIcon(player1TaketwoCardIcon.getImage().getScaledInstance(cardsWidth, cardsHeight, Image.SCALE_SMOOTH)));
        }
        catch(Exception e)
        {
            System.out.println("Error loading image: " + e.getMessage());
        }

        // --- Player 2 Cards
        for(int i = 0; i < 12; i++)
        {
                ImageIcon player2CardsIcon = new ImageIcon("../../Cards/Assets/back_view_card.png");
                player2CardsAssets.add(new ImageIcon(player2CardsIcon.getImage().getScaledInstance(cardsWidth, cardsHeight, Image.SCALE_SMOOTH)));
        }
    }

    private void createCardsAndTable()
    {
        table = new JLabel(tableAsset);
        availableCards = new JLabel(availableCardsAsset);
        playedCards = new JLabel(playedCardsAsset);

        for(ImageIcon icon : player1CardsAssets)
        {
            player1Cards.add(new JLabel(icon));
        }

        for(ImageIcon icon : player2CardsAssets)
        {
            player2Cards.add(new JLabel(icon));
        }
    }

    private void setCardsAndTablePosition()
    {
        int cardsTotalWidth = (int) (cardsWidth + cardsWidth * (player1Cards.size() - 1) * (2.0 / 3.0));

        // --- Player 1 Cards
        int player1CardsPosition = (int)((screenWidth - cardsTotalWidth) / 2.0);
        player1Cards.get(0).setBounds(player1CardsPosition, screenHeight - cardsHeight, cardsWidth, cardsHeight);
        for(int i = 1; i < player1Cards.size(); i++)
        {
            player1Cards.get(i).setBounds(
                player1Cards.get(i - 1).getX() + (int)(cardsWidth * (2.0 / 3.0)), 
                screenHeight - cardsHeight, 
                cardsWidth, 
                cardsHeight
            );
        }

        // --- Player 2 Cards
        int player2CardsPosition = screenWidth - (int)((screenWidth - cardsTotalWidth) / 2.0) - cardsWidth;
        player2Cards.get(0).setBounds(player2CardsPosition, 0, cardsWidth, cardsHeight);
        for(int i = 1; i < player2Cards.size(); i++)
        {
            player2Cards.get(i).setBounds(
                player2Cards.get(i - 1).getX() - (int)(cardsWidth * (2.0 / 3.0)), 
                0, 
                cardsWidth, 
                cardsHeight
            );
        }

        availableCards.setBounds((int)(playedCardsWidth * (2.0 / 3.0)), (int)((screenHeight - availableCardsHeight) / 2.0), availableCardsWidth, availableCardsHeight);
        playedCards.setBounds((int)((screenWidth - playedCardsWidth) / 2.0), (int)((screenHeight - playedCardsHeight) / 2.0), playedCardsWidth, playedCardsHeight);
        table.setBounds(0, 0, screenWidth, screenHeight);
    }

    private void addListeners()
    {
        for(JLabel card : player1Cards)
        {
            card.addMouseListener(new java.awt.event.MouseAdapter() 
            {
                public void mouseEntered(java.awt.event.MouseEvent evt)
                {
                    cardUp(card);
                }
                public void mouseExited(java.awt.event.MouseEvent evt)
                {
                    cardDown(card);
                }
            });
        }
    }

    private void addAssets()
    {
        // --- Player 1 cards
        for(JLabel card : player1Cards)
        {
            add(card);
        }

        // --- Player 2 cards
        for(JLabel card : player2Cards)
        {
            add(card);
        }

        add(availableCards);
        add(playedCards);
        add(table);
    }


    public TableFrame()
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
        createCardsAndTable();
        addListeners();
        setCardsAndTablePosition();
        addAssets();
    }

    // ----- Listeners -----
    private void cardUp(JLabel card)
    {
        card.setBounds(card.getX(), (card.getY() - (int)(cardsWidth / 2.0)), cardsWidth, (cardsHeight + (int)(cardsWidth / 2.0)));
    }
    private void cardDown(JLabel card)
    {
        card.setBounds(card.getX(), (card.getY() + (int)(cardsWidth / 2.0)), cardsWidth, cardsHeight);
    }

    public static void main(String[] args)
    {
        TableFrame canvas = new TableFrame();
        canvas.setVisible(true);
    }
}
