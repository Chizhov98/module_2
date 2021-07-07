package Сalendar.UserInterface.Impl;

import Сalendar.Exeptions.MyExeption;
import Сalendar.UserInterface.UIMenu;

import java.sql.SQLOutput;

public class RussianMenu implements UIMenu {
    @Override
    public void mainMenu() {

    }

    @Override
    public void choseFormatOfData() {

    }

    @Override
    public void soutResalt(String str) {
        System.out.println("Результат");
        System.out.println(str);
    }

    @Override
    public void exceptionSout(MyExeption exception) {
        System.out.println("ERROR : " + exception.getEnglishMessage());
    }
}
