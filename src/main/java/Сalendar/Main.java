package Сalendar;

import Сalendar.Config.Config;
import Сalendar.Config.Languages;
import Сalendar.UserInterface.UIMenu;


public class Main {
    private static Config config = new Config();
    private static UIMenu menu = config.setMenuLanguage(Languages.RUSSIAN);


    public static void main(String[] args) {
        menu.choseLanguage();

    }
}
