package Сalendar.UserInterface.UIOutput;

import Сalendar.Config.Exeptions.MyExeption;

public interface UIMenu {


    void choseLanguage();

    void mainMenu();

    void choseFormatOfDate();

    void soutResalt(String str);

    void operationComplete();

    void exceptionSout(MyExeption exception);


}
