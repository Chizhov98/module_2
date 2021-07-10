package Сalendar.Config;


import lombok.Setter;
import Сalendar.Config.Enams.DateFormats;
import Сalendar.Config.Enams.Languages;
import Сalendar.UserInterface.UIOutput.UIMenu;


public class Config {
    @Setter
    private DateFormats format = DateFormats.DD_MM_YY;

    public static UIMenu setMenuLanguage(Languages languages) {
        return languages.getMenu();
    }



}
