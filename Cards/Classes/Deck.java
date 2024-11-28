package Cards.Classes;

import java.util.ArrayList;

import Cards.Classes.*;
import Cards.Enums.*;

public class Deck
{
    // ----- Deck -----
    private ArrayList<ArrayList<ArrayList<Card>>> deck;

    // ----------------------------------------------

    // C++ cards
    private ArrayList<ArrayList<Card>> cppDeck;
    // --- C++ number cards
    private ArrayList<NumberCard> cppNumberCards;
    // --- C++ power cards
    private ArrayList<PowerCard> cppPowerCards;

    // ----------------------------------------------

    // C# cards
    private ArrayList<ArrayList<Card>> csharpDeck;
    // --- C# number cards
    private ArrayList<NumberCard> csharpNumberCards;
    // --- C# power cards
    private ArrayList<PowerCard> csharpPowerCards;

    // ---------------------------------------------

    // Java cards
    private ArrayList<ArrayList<Card>> javaDeck;
    // --- Java number cards
    private ArrayList<NumberCard> javaNumberCards;
    // --- Java power cards
    private ArrayList<PowerCard> javaPowerCards;

    // ---------------------------------------------

    // Python cards
    private ArrayList<ArrayList<Card>> pythonDeck;
    // --- Python number cards
    private ArrayList<NumberCard> pythonNumberCards;
    // --- Python power cards
    private ArrayList<PowerCard> pythonPowerCards;
    
    // ---------------------------------------------


    public Deck()
    {
        initializeDeck();
    }

    private void initializeDeck()
    {
        // C++
        // --- C++ number cards
        for(int i = 0; i < 10; i++)
        {
            cppNumberCards.add(new NumberCard(ProgrammingLanguage.CPPLAN, "../Assets/cpp/numberCards/cpp_" + i + "_card.png", i));
        }
        // --- C++ power cards
        // - C++ base card
        cppPowerCards.add(new PowerCard(ProgrammingLanguage.CPPLAN, "../Assets/cpp/powerCards/cpp_base_card.png", PowerOptions.BASECARD));
        // - C++ take two card
        cppPowerCards.add(new PowerCard(ProgrammingLanguage.CPPLAN, "../Assets/cpp/powerCards/cpp_block_card.png", PowerOptions.TAKETWO));
        // - C++ block card
        cppPowerCards.add(new PowerCard(ProgrammingLanguage.CPPLAN, "../Assets/cpp/powerCards/cpp_taketwo_card.png", PowerOptions.BLOCK));

        // C#
        // --- C# number cards
        for(int i = 0; i < 10; i++)
        {
            csharpNumberCards.add(new NumberCard(ProgrammingLanguage.CSHARPLAN, "../Assets/csharp/numberCards/csharp_" + i + "_card.png", i));
        }
        // --- C# power cards
        // - C# base card
        csharpPowerCards.add(new PowerCard(ProgrammingLanguage.CSHARPLAN, "../Assets/csharp/powerCards/csharp_base_card.png", PowerOptions.BASECARD));
        // - C# take two card
        csharpPowerCards.add(new PowerCard(ProgrammingLanguage.CSHARPLAN, "../Assets/csharp/powerCards/csharp_block_card.png", PowerOptions.TAKETWO));
        // - C# block card
        csharpPowerCards.add(new PowerCard(ProgrammingLanguage.CSHARPLAN, "../Assets/csharp/powerCards/csharp_taketwo_card.png", PowerOptions.BLOCK));

        // Java
        // --- Java number cards
        for(int i = 0; i < 10; i++)
        {
            javaNumberCards.add(new NumberCard(ProgrammingLanguage.JAVALAN, "../Assets/java/numberCards/java_" + i + "_card.png", i));
        }
        // --- Java power cards
        // - Java base card
        javaPowerCards.add(new PowerCard(ProgrammingLanguage.JAVALAN, "../Assets/java/powerCards/java_base_card.png", PowerOptions.BASECARD));
        // - Java take two card
        javaPowerCards.add(new PowerCard(ProgrammingLanguage.JAVALAN, "../Assets/java/powerCards/java_block_card.png", PowerOptions.TAKETWO));
        // - Java block card
        javaPowerCards.add(new PowerCard(ProgrammingLanguage.JAVALAN, "../Assets/java/powerCards/java_taketwo_card.png", PowerOptions.BLOCK));

        // Python
        // --- Python number cards
        for(int i = 0; i < 10; i++)
        {
            pythonNumberCards.add(new NumberCard(ProgrammingLanguage.PYTHONLAN, "../Assets/python/numberCards/python_" + i + "_card.png", i));
        }
        // --- Python power cards
        // - Python base card
        pythonPowerCards.add(new PowerCard(ProgrammingLanguage.PYTHONLAN, "../Assets/python/powerCards/python_base_card.png", PowerOptions.BASECARD));
        // - Python take two card
        pythonPowerCards.add(new PowerCard(ProgrammingLanguage.PYTHONLAN, "../Assets/python/powerCards/python_block_card.png", PowerOptions.TAKETWO));
        // - C++ block card
        pythonPowerCards.add(new PowerCard(ProgrammingLanguage.PYTHONLAN, "../Assets/python/powerCards/python_taketwo_card.png", PowerOptions.BLOCK));

        // Deck
        deck.add(cppDeck);
        deck.add(csharpDeck);
        deck.add(javaDeck);
        deck.add(pythonDeck);
    }

    public ArrayList<ArrayList<ArrayList<Card>>> getDeck()
    {
        return deck;
    }
} 
