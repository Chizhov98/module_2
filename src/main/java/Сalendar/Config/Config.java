package Сalendar.Config;


import Сalendar.UserInterface.UIOutput.UIMenu;


public class Config {
    public static DateFormats format = DateFormats.DD_MM_YY;

    public static UIMenu setMenuLanguage(Languages languages) {
        return languages.getMenu();
    }
}
