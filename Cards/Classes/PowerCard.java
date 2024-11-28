package Cards.Classes;

import Cards.Enums.*;

public class PowerCard extends Card
{
    protected PowerOptions power;

    public PowerCard(ProgrammingLanguage language, String url, PowerOptions power)
    {
        this.language = language;
        this.imageAsset = url;
        this.power = power;
    }

    public PowerCard(String url, PowerOptions power)
    {
        this.imageAsset = url;
        this.power = power;
    }

    public PowerOptions getPower()
    {
        return power;
    }
}
