package Сalendar.UserInterface.UIOutput.Impl;

import Сalendar.Config.Exeptions.MyExeption;
import Сalendar.UserInterface.UIOutput.UIMenu;

public class EnglishMenu implements UIMenu {
    @Override
    public void mainMenu() {
        System.out.println("                           Maine menu\n" +
                "Please select the menu item you need.\n" +
                "1. Find the difference between dates.\n" +
                "2. Subtract the specified time from the date.\n" +
                "3. Sort the list of dates.\n" +
                "4. Change date format.\n" +
                "5. Change language.\n" +
                "0. Exit program.");
    }

    @Override
    public void choseFormatOfDate() {
        System.out.println("Please chose format of data :\n" +
                "1. dd/mm/yy - 01/12/21\n" +
                "2. m/d/yyyy - 3/4/2021\n" +
                "3. mmm-d-yy - Март-4-21\n" +
                "4. dd-mmm-yyyy 00:00 - 09-Апрель-1789 00:00\n" +
                "0. Return to main menu");
    }

    @Override
    public void soutResalt(String str) {
        System.out.println("Результат :\n");
        System.out.println(str);
        System.out.println(str + "\n\n");
        System.out.println("Do you wont continue:\n" +
                "1. Yes(return to main menu)\n" +
                "0. No(Exit program)\n");
    }

    @Override
    public void operationComplete() {
        System.out.println(MyExeption.SUCCESS.getEnglishMessage());
        System.out.println("Do you wont continue:\n" +
                "1. Yes(return to main menu)\n" +
                "0. No(Exit program)\n");
    }

    @Override
    public void exceptionSout(MyExeption exception) {
        System.out.println("ERROR : " + exception.getEnglishMessage());
        System.out.println("1. Return to main menu\n" +
                "0. Exit program \n");
    }

    @Override
    public void choseLanguage() {
        System.out.println("Please chose one of languages \n" +
                "Пожалуйста, выбери язык\n" +
                "1. Russian - Русский \n" +
                "2. English - Англиский \n" +
                "0. Exit program - Завершить программу");
    }
}
