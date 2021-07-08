package Сalendar.Config;


import lombok.Setter;
import Сalendar.UserInterface.UIOutput.UIMenu;


public class Config {
    @Setter
    private DateFormats format = DateFormats.DD_MM_YY;

    public static UIMenu setMenuLanguage(Languages languages) {
        return languages.getMenu();
    }



}
