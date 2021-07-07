package Сalendar.UserInterface.Impl;

import Сalendar.Exeptions.MyExeption;
import Сalendar.UserInterface.UIMenu;

public class EnglishMenu implements UIMenu {
    @Override
    public void mainMenu() {

    }

    @Override
    public void choseFormatOfData() {

    }

    @Override
    public void soutResalt(String str) {

    }

    @Override
    public void exceptionSout(MyExeption exception) {
        System.out.println("ОШИБКА : " + exception.getRussianMessage());
    }
}
