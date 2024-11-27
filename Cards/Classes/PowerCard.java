package Cards.Classes;

import Cards.Classes.Card;
import Cards.Enums.*;

public class PowerCard extends Card
{
    protected String power;

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

    public String getPower()
    {
        return power;
    }
}
