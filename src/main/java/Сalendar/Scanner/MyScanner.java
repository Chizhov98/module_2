package Сalendar.Scanner;

import Сalendar.Config.Languages;
import Сalendar.UserInterface.UINavigator.MenuNavigator;


import java.util.Scanner;

import static Сalendar.Config.Exeptions.MyExeption.ITEM_DOES_NOT_EXIST;

public class MyScanner {

    static private Scanner in = new Scanner(System.in);
    private static int intChose;

    public static Languages setLanguage() {
        intChose = in.nextInt();
        switch (intChose) {
            case 1:
                return Languages.RUSSIAN;
            case 2:
                return Languages.ENGLISH;
            case 0:
                System.exit(0);
            default:
                MenuNavigator.menu.exceptionSout(ITEM_DOES_NOT_EXIST);
                MenuNavigator.menu.choseLanguage();
                return setLanguage();
        }
    }

    public static int mainMenu() {
        return in.nextInt();
    }
}
