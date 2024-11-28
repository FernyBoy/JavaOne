package Cards.Classes;

import Cards.Enums.*;
import java.util.ArrayList;

public class Deck 
{
    private ArrayList<ArrayList<ArrayList<Card>>> deck;

    public Deck() 
    {
        initializeDeck();
    }

    private void initializeDeck() 
    {
        deck = new ArrayList<>(); 

        deck.add(createLanguageDeck(ProgrammingLanguage.CPPLAN, "cpp"));
        deck.add(createLanguageDeck(ProgrammingLanguage.CSHARPLAN, "csharp"));
        deck.add(createLanguageDeck(ProgrammingLanguage.JAVALAN, "java"));
        deck.add(createLanguageDeck(ProgrammingLanguage.PYTHONLAN, "python"));
    }

    private ArrayList<ArrayList<Card>> createLanguageDeck(ProgrammingLanguage language, String languageName) 
    {
        ArrayList<ArrayList<Card>> languageDeck = new ArrayList<>();

        // --- Number Cards
        ArrayList<Card> numberCards = new ArrayList<>();
        for (byte i = 0; i < 10; i++) 
        {
            numberCards.add(new NumberCard(language, "../Assets/" + languageName + "/numberCards/" + languageName + "_" + i + "_card.png", i));
        }

        // --- Power Cards
        ArrayList<Card> powerCards = new ArrayList<>();
        powerCards.add(new PowerCard(language, "../Assets/" + languageName + "/powerCards/" + languageName + "_base_card.png", PowerOptions.BASECARD));
        powerCards.add(new PowerCard(language, "../Assets/" + languageName + "/powerCards/" + languageName + "_block_card.png", PowerOptions.BLOCK));
        powerCards.add(new PowerCard(language, "../Assets/" + languageName + "/powerCards/" + languageName + "_taketwo_card.png", PowerOptions.TAKETWO));

        languageDeck.add(numberCards);
        languageDeck.add(powerCards);

        return languageDeck;
    }

    public ArrayList<ArrayList<ArrayList<Card>>> getDeck() 
    {
        return deck;
    }

    public void printDeck() 
    {
        for (byte i = 0; i < deck.size(); i++) 
        {
            ArrayList<ArrayList<Card>> currentLanguageDeck = deck.get(i);

            System.out.print("\n\n----- " + currentLanguageDeck.get(0).get(0).getLanguage() + " -----");
            System.out.println("\n--- Number Cards");
            ArrayList<Card> currentNumberCards = currentLanguageDeck.get(0);
            for (Card card : currentNumberCards) 
            {
                NumberCard numberCard = (NumberCard) card;

                System.out.println("Language: " + numberCard.getLanguage());
                System.out.println("Url: " + numberCard.getAssetUrl());
                System.out.println("Number: " + numberCard.getNumber());
            }

            System.out.println("\n--- Power Cards");
            ArrayList<Card> currentPowerCards = currentLanguageDeck.get(1);
            for (Card card : currentPowerCards) 
            {
                PowerCard powerCard = (PowerCard) card;

                System.out.println("Language: " + powerCard.getLanguage());
                System.out.println("Url: " + powerCard.getAssetUrl());
                System.out.println("Power: " + powerCard.getPower());
            }
        }
    }
}

