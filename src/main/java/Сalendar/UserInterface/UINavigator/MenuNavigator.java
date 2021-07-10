package Сalendar.UserInterface.UINavigator;

import lombok.Getter;
import Сalendar.Config.Config;
import Сalendar.Config.Enams.Languages;
import Сalendar.DateUtils.Calculator.Calculator;
import Сalendar.DateUtils.Converter.FromString.ConverterDefaultUtils;
import Сalendar.DateUtils.Converter.ToString.ConverterToString;
import Сalendar.DateUtils.Converter.ToString.ConverterUtils;
import Сalendar.Scanner.MyScanner;
import Сalendar.UserInterface.UIOutput.UIMenu;

import java.util.Arrays;

import static Сalendar.Config.Exeptions.MyExeption.INCORRECT_INPUT_FORMAT;
import static Сalendar.Config.Exeptions.MyExeption.ITEM_DOES_NOT_EXIST;

public class MenuNavigator {
    @Getter
    private static final Config config = new Config();
    public static UIMenu menu = config.setMenuLanguage(Languages.RUSSIAN);
    public static ConverterToString converter = config.setCconverter(Languages.RUSSIAN);
    private static final MyScanner scanner = new MyScanner();
    private static Calculator calculator = new Calculator();

    private static void setLanguage() {
        menu.choseLanguage();
        Languages language = scanner.setLanguage();
        menu = config.setMenuLanguage(language);
        converter = config.setCconverter(language);
        menu.operationComplete();
        if (scanner.continua()) mainMenu();
    }

    private static void setFormatOfDate() {
        menu.choseFormatOfDate();
        config.setFormat(scanner.setDateFormat());
        menu.operationComplete();
        if (scanner.continua()) mainMenu();
    }

    private static void sortedMenu() {
        String[] scans = scanner.sortedMenu();
        long[] result = calculator.sorted(scans);
        for (int i = 0; i < scans.length; i++) {
            System.out.println((i+1)+")"+ ConverterUtils.resultToString(result[i]));
        }
    }

    private static void differenceMenu() {
        menu.differenceMenuFirst();
       int[] firstDate = scanner.readDateToArray();
        menu.differenceMenuSecond();
        int[] secondDate = scanner.readDateToArray();
        menu.toSoutForParts(calculator.difference(firstDate,secondDate));
        if (scanner.continua()) mainMenu();
    }

    private static void addTime() {
        menu.operation();
        int[] date = scanner.readDateToArray();
        menu.addTime();
        menu.soutResalt(ConverterUtils.resultToString(                ConverterDefaultUtils.allToAbsoluteSeconds(date)));
        menu.seconds();
        int[] time = new int[7];
        time[0] = 0;
        time[1] = scanner.scannInt();
        menu.minutes();
        time[2] = scanner.scannInt();
        menu.hours();
        time[3] = scanner.scannInt();
        menu.days();
        time[4] = scanner.scannInt();
        menu.month();
        time[5] = scanner.scannInt();
        menu.years();
        time[6] = scanner.scannInt();
        menu.soutResalt(ConverterUtils.resultToString
                (calculator.addTime(date, time)));
        if (scanner.continua()) mainMenu();
    }

    private static void divTime() {
        menu.operation();
        int[] date = scanner.readDateToArray();
        menu.divTime();
        menu.seconds();
        int[] time = new int[7];
        time[0] = 0;
        time[1] = scanner.scannInt();
        menu.minutes();
        time[2] = scanner.scannInt();
        menu.hours();
        time[3] = scanner.scannInt();
        menu.days();
        time[4] = scanner.scannInt();
        menu.month();
        time[5] = scanner.scannInt();
        menu.years();
        time[6] = scanner.scannInt();
        menu.soutResalt(ConverterUtils.resultToString
                (calculator.divTime(date, time)));
        if (scanner.continua()) mainMenu();
    }

    public static void mainMenu() {
        menu.mainMenu();
        switch (scanner.scannInt()) {
            case 1:
                differenceMenu();
                break;
            case 2:
                addTime();
                break;
            case 3:
                divTime();
                break;
            case 4:
                sortedMenu();
                break;
            case 5:
                setFormatOfDate();
                break;
            case 6:
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
