package Cards.Classes;

import Cards.Enums.*;

public class NumberCard extends Card
{
    protected byte number;
    
    public NumberCard(ProgrammingLanguage language, String url, TypeOptions type, byte number)
    {
        this.language = language;
        this.imageAsset = url;
        this.type = type;
        this.number = number;
    }

    public byte getNumber()
    {
        return number;
    }
}