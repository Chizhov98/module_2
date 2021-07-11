package Сalendar.Scanner;

import Сalendar.Config.Enams.DateFormats;
import Сalendar.Config.Enams.Languages;
import Сalendar.Config.Exeptions.MyExeption;
import Сalendar.DateUtils.Converter.ToString.ConverterUtils;
import Сalendar.UserInterface.UINavigator.MenuNavigator;

import java.util.Arrays;
import java.util.Scanner;

import static Сalendar.Config.Exeptions.MyExeption.ITEM_DOES_NOT_EXIST;

public class MyScanner {


    static private Scanner in = new Scanner(System.in);
    private static int chosenVariant;

    public long readData() {
        String scan = scannline();
        long result = MenuNavigator.getConfig().getFormat().getPrivateDecoder().decoder(scan);
        if (result <= 0) {
            MenuNavigator.menu.exceptionSout(MyExeption.INCORRECT_INPUT_FORMAT);
            if (continua()) MenuNavigator.mainMenu();
        }
        return result;
    }

    public int[] readDateToArray() {
        return ConverterUtils.longDecoder(readData());
    }

    public DateFormats setDateFormat() {
        switch (scannInt()) {
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
        switch (scannInt()) {
            case 1:
                return true;
            case 0:
                System.exit(0);
            default:
                MenuNavigator.menu.exceptionSout(ITEM_DOES_NOT_EXIST);
                return continua();
        }
    }

    public Languages setLanguage() {
        switch (scannInt()) {
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

    public String[] sortedMenu() {
        MenuNavigator.menu.sortFirstMenu();
        chosenVariant = scannInt();
        String[] scans = new String[chosenVariant];
        for (int i = 0; i < (scans.length); i++) {
            MenuNavigator.menu.sortSecondMenu(i + 1);
            scans[i] = scannline();
        }
        return scans;
    }

    public int scannInt()throws RuntimeException {
        try {
            String a = in.nextLine();
            return Integer.valueOf(a);

        }catch ( RuntimeException NumberFormatException){
            MenuNavigator.menu.exceptionSout(ITEM_DOES_NOT_EXIST);
            if(continua())MenuNavigator.mainMenu();
        }
        return -1;
    }

    public String scannline() {
        return in.nextLine();
    }

}
