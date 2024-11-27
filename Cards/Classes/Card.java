package Cards.Classes;

import Cards.Enums.ProgrammingLanguage;

public abstract class Card
{
    protected ProgrammingLanguage language;
    protected String imageAsset;

    public ProgrammingLanguage getLanguage()
    {
        return language;
    }

    public String getAssetUrl()
    {
        return imageAsset;
    }
}
