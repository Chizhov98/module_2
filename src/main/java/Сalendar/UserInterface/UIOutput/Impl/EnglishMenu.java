package Сalendar.UserInterface.UIOutput.Impl;

import Сalendar.Config.Exeptions.MyExeption;
import Сalendar.UserInterface.UIOutput.UIMenu;

public class EnglishMenu implements UIMenu {
    @Override
    public void mainMenu() {
        System.out.println("    Maine menu\n" +
                "Please select the menu item you need.\n" +
                "1. Find the difference between dates.\n" +
                "2. Add time to date\n" +
                "3. Div time from date\n" +
                "4. Sort the list of dates.\n" +
                "5. Change date format.\n" +
                "6. Change language.\n" +
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
    public void addTime() {
        System.out.println("What time do you want add to date");

    }

    @Override
    public void divTime() {
        System.out.println("What time do you want to div from date");
    }

    @Override
    public void hours() {
        System.out.print("Hours");
    }

    @Override
    public void minutes() {
        System.out.print("Minutes");
    }

    @Override
    public void seconds() {
        System.out.print("Seconds");
    }

    @Override
    public void days() {
        System.out.print("Days");
    }

    @Override
    public void month() {
        System.out.print("Months");
    }

    @Override
    public void years() {
        System.out.print("Years");
    }

    @Override
    public void operation() {
        System.out.println("What is the date did you want to work with ");
    }

    @Override
    public void toSoutForParts(int[] time) {
        System.out.println("Difference by two dates is :\n"
                + time[6] + " years" + time[5] + "months" + time[4] + "days" + time[3] + "hours" + time[2] + "minutes" + time[1] + "seconds");
    }

    @Override
    public void differenceMenuFirst() {
        System.out.println("Enter first date");
    }

    @Override
    public void differenceMenuSecond() {
        System.out.println("Enter second date");
    }

    @Override
    public void sortFirstMenu() {
        System.out.println("How much date do you want sorted?");
    }

    @Override
    public void sortSecondMenu(int i) {
        System.out.println("Enter date №" + i);
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
