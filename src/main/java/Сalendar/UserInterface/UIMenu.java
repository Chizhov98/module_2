package Сalendar.UserInterface;

import Сalendar.Exeptions.MyExeption;

public interface UIMenu {


    default public void choseLanguage() {
        System.out.println("Hello and welcome. Please chose one of languages and we will start. \n" +
                "Здраствуй и добро пожаловать. Пожалуйста, выбери язык и мы начнемю \n" +
                "1. Russian - Русский \n" +
                "2. English - Англиский \n");
    }

    public void mainMenu();

    public void choseFormatOfData();

    public void soutResalt(String str);

    public void exceptionSout(MyExeption exception);


}
