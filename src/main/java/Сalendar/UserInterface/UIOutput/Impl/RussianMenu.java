package Сalendar.UserInterface.UIOutput.Impl;

import Сalendar.Config.Exeptions.MyExeption;
import Сalendar.UserInterface.UIOutput.UIMenu;


public class RussianMenu implements UIMenu {
    @Override
    public void mainMenu() {
        System.out.println("    Гавное меню:\n" +
                "Пожалуйста выберите нужный вам пункт меню\n" +
                "1. Найти разницу между датами.\n" +
                "2. Вычитать из даты указаное время.\n" +
                "3. Отсортировать перечень дат.\n" +
                "4. Сменить формат представления дат.\n" +
                "5. Сменить язык.\n" +
                "0. Завершить программу.");
    }

    @Override
    public void choseFormatOfDate() {
        System.out.println("Выберети формат представления даты:\n" +
                "1. дд/мм/гг - 01/12/21\n" +
                "2. м/д/гггг - 3/4/2021\n" +
                "3. ммм-д-гг - Март-4-21\n" +
                "4. дд-ммм-гггг 00:00 - 09-Апрель-1789 00:00\n" +
                "0. Вернуться в главное меню\n");
    }

    @Override
    public void soutResalt(String str) {
        System.out.println("Результат :\n");
        System.out.println(str);
        System.out.println(str + "\n\n");
        System.out.println("Желаете подолжить:\n" +
                "1. Да(вернуться в главное меню)\n" +
                "0. Нет(Завершить программу)\n");
    }

    @Override
    public void operationComplete() {
        System.out.println(MyExeption.SUCCESS.getRussianMessage());
        System.out.println("Желаете подолжить:\n" +
                "1. Да(вернуться в главное меню)\n" +
                "0. Нет(Завершить программу)\n");
    }

    @Override
    public void exceptionSout(MyExeption exception) {
        System.out.println("ОШИБКА : " + exception.getRussianMessage());
        System.out.println("1. Вернуться в главное меню\n" +
                "0. Завершить программы\n");
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
