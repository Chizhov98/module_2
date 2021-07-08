package Сalendar.UserInterface.UINavigator;

import Сalendar.Config.Config;
import Сalendar.Config.Exeptions.MyExeption;
import Сalendar.Config.Languages;
import Сalendar.Scanner.MyScanner;
import Сalendar.UserInterface.UIOutput.UIMenu;

import static Сalendar.Config.Exeptions.MyExeption.ITEM_DOES_NOT_EXIST;

public class MenuNavigator {

    private static Config config = new Config();
    public static UIMenu menu = config.setMenuLanguage(Languages.RUSSIAN);
    private static MyScanner scaner = new MyScanner();

    private static void setLanguage() {
        menu.choseLanguage();
        menu = config.setMenuLanguage(scaner.setLanguage());
        menu.operationComplete();
        if (scaner.continua()) mainMenu();
    }

    private static void setFormatOfDate() {
        menu.choseFormatOfDate();
        config.setFormat(scaner.setDateFormat());
        menu.operationComplete();
        if (scaner.continua()) mainMenu();
    }


    public static void mainMenu() {
        menu.mainMenu();
        switch (scaner.mainMenu()) {
            case 1:

                break;
            case 2:

                break;
            case 3:
                break;
            case 4:
                setFormatOfDate();
                break;
            case 5:
                setLanguage();
                break;
            case 0:
                System.exit(0);
                break;
            default:
                menu.exceptionSout(ITEM_DOES_NOT_EXIST);
                mainMenu();
        }
    }


}
