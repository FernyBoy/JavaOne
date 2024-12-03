import javax.swing.JFrame;

import java.awt.Toolkit;
import java.awt.Dimension;

import GUI.StartMenu.StartMenuPanel;
import Game.Classes.CreateDeck;

public class Main 
{
    static Toolkit tool = Toolkit.getDefaultToolkit();
    static Dimension screen = tool.getScreenSize();
    static int screenWidth = (int) screen.getWidth();
    static int screenHeight = (int) screen.getHeight();

    static CreateDeck deck = new CreateDeck();
    public static void main(String[] args) 
    {
        JFrame start = new JFrame();
        
        StartMenuPanel menu = new StartMenuPanel();
        start.add(menu);

        // Ajustamos nuestro JFrame para pantalla completa
        // --- Esta funcion hace que no aparezca en un lugar aleatorio
        start.setLocationRelativeTo(null);
        // --- Quitamos el marco del JFrame
        start.setUndecorated(true);
        // --- Ajustamos el tamanio y posicion
        start.setBounds(0, 0, screenWidth, screenHeight);
        // --- Establecemos el cierre por defecto
        start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        start.setLayout(null);
        start.setVisible(true);
    }    
}
