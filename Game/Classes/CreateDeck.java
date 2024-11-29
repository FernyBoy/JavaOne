package Game.Classes;

import java.util.ArrayList;
import java.util.Collections;

import Cards.Classes.*;
import Cards.Enums.TypeOptions;

public class CreateDeck 
{
    private Deck deck = new Deck();
    private ArrayList<ArrayList<ArrayList<Card>>> cards = deck.getDeck();
    private ArrayList<Card> availableCards = new ArrayList<>();

    public CreateDeck()
    {
        for(ArrayList<ArrayList<Card>> language : cards)
        {
            availableCards.add(language.get(0).get(0));
    
            ArrayList<Card> numberCards = language.get(0);
            for(int i = 1; i < numberCards.size(); i++)
            {
                for(int j = 0; j < 2; j++)
                {
                    availableCards.add(numberCards.get(i));
                }
            }
    
            ArrayList<Card> powerCards = language.get(1);
            for(int i = 1; i < powerCards.size(); i++)
            {
                for(int j = 0; j < 3; j++)
                {
                    availableCards.add(powerCards.get(i));
                }
            }
        }
    }

    public void printDeck()
    {
        Collections.shuffle(availableCards);

        for(Card card : availableCards)
        {
            System.out.print("\n\nLanguage: " + card.getLanguage());
            System.out.print("\nAsset: " + card.getAssetUrl());
            System.out.print("\nType: " + card.getType());
            if(card.getType() == TypeOptions.NUMBER)
            {
                NumberCard nc = (NumberCard) card;
                System.out.println("\nNumber: " + nc.getNumber());
            }
            else if(card.getType() == TypeOptions.POWER)
            {
                PowerCard pc = (PowerCard) card;
                System.out.println("\nPower: " + pc.getPower());
            }

            System.out.println("-----------");
        }
    }
}
