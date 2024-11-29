package Cards.Classes;

import Cards.Enums.*;

public abstract class Card
{
    protected ProgrammingLanguage language;
    protected String imageAsset;
    protected TypeOptions type;

    public ProgrammingLanguage getLanguage()
    {
        return language;
    }

    public String getAssetUrl()
    {
        return imageAsset;
    }

    public TypeOptions getType()
    {
        return type;
    }
}