package Сalendar.UserInterface.UIOutput;

import Сalendar.Config.Exeptions.MyExeption;

public interface UIMenu {
    void differenceMenuFirst();

    void differenceMenuSecond();


    void sortFirstMenu();

    void sortSecondMenu(int i);

    void choseLanguage();

    void mainMenu();

    void choseFormatOfDate();

    void soutResalt(String str);

    void operationComplete();

    void exceptionSout(MyExeption exception);

    void addTime();

    void divTime();

    void hours();

    void minutes();

    void seconds();

    void days();

    void month();

    void years();

    void operation();

    void toSoutForParts(int[] time);
}
