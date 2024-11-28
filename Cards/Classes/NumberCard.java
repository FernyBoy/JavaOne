package Cards.Classes;

import Cards.Enums.ProgrammingLanguage;

public class NumberCard extends Card
{
    protected byte number;
    
    public NumberCard(ProgrammingLanguage language, String url, byte number)
    {
        this.language = language;
        this.imageAsset = url;
        this.number = number;
    }

    public byte getNumber()
    {
        return number;
    }
}
