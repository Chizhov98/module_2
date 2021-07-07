package Сalendar.UserInterface.UINavigator;

import Сalendar.Config.Config;
import Сalendar.Config.Languages;
import Сalendar.Scanner.MyScanner;
import Сalendar.UserInterface.UIOutput.UIMenu;

import static Сalendar.Config.Exeptions.MyExeption.ITEM_DOES_NOT_EXIST;

public class MenuNavigator {

    private static Config config = new Config();
    public static UIMenu menu = config.setMenuLanguage(Languages.RUSSIAN);

    private static void setLanguage( ){
        menu.choseLanguage();
        menu = config.setMenuLanguage(MyScanner.setLanguage());
    }

    public static void mainMenu(){
        menu.mainMenu();
        switch (MyScanner.mainMenu()){
            case 1:

                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                setLanguage();
                break;
            case 0:
                System.exit(0);
                break;
            default:
                MenuNavigator.menu.exceptionSout(ITEM_DOES_NOT_EXIST);
                mainMenu();
        }
    }






}
