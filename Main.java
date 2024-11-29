import GUI.StartMenu.StartMenuFrame;
import Game.Classes.CreateDeck;

public class Main 
{
    static CreateDeck deck = new CreateDeck();
    public static void main(String[] args) 
    {
        StartMenuFrame menu = new StartMenuFrame();
        menu.setVisible(true);
    }    
}
