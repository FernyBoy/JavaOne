package Cards.Classes;

import Cards.Enums.*;

public class PowerCard extends Card
{
    protected PowerOptions power;

    public PowerCard(ProgrammingLanguage language, String url, TypeOptions type, PowerOptions power)
    {
        this.language = language;
        this.imageAsset = url;
        this.type = type;
        this.power = power;
    }

    public PowerCard(String url, TypeOptions type, PowerOptions power)
    {
        this.imageAsset = url;
        this.type = type;
        this.power = power;
    }

    public PowerOptions getPower()
    {
        return power;
    }
}
