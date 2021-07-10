package Сalendar.Scanner;

import Сalendar.Config.Enams.DateFormats;
import Сalendar.Config.Enams.Languages;
import Сalendar.UserInterface.UINavigator.MenuNavigator;


import java.util.Scanner;

import static Сalendar.Config.Exeptions.MyExeption.ITEM_DOES_NOT_EXIST;

public class MyScanner {

    static private Scanner in = new Scanner(System.in);
    private static int intChose;
    private static String data;

    public static long readData() {
        data = in.nextLine();
        return 0;
    }

    public DateFormats setDateFormat() {
        switch (in.nextInt()) {
            case 1:
                return (DateFormats.DD_MM_YY);
            case 2:
                return (DateFormats.M_D_YYYY);
            case 3:
                return (DateFormats.MMM_D_YY);
            case 4:
                return (DateFormats.DD_MMM_YYYY_Hours_MINUTES);
            case 0:
                System.exit(0);
            default:
                return setDateFormat();
        }

    }

    public boolean continua() {

        intChose = in.nextInt();
        switch (intChose) {
            case 1:
                return true;
            case 0:
                System.exit(0);
            default:
                MenuNavigator.menu.exceptionSout(ITEM_DOES_NOT_EXIST);
                return continua();
        }
    }

        public Languages setLanguage () {
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

        public int mainMenu () {
            return in.nextInt();
        }
    }
