package Сalendar.Config;


import Сalendar.UserInterface.UIOutput.UIMenu;


public class Config {

    public static UIMenu setMenuLanguage(Languages languages) {
        return languages.getMenu();
    }
}
