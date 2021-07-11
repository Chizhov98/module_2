package Сalendar.UserInterface.UIOutput.Impl;

import Сalendar.Config.Exeptions.MyExeption;
import Сalendar.UserInterface.UIOutput.UIMenu;


public class RussianMenu implements UIMenu {


    @Override
    public void differenceMenuFirst() {
        System.out.println("Введите первую дату");
    }

    @Override
    public void differenceMenuSecond() {
        System.out.println("Введите вторую дату");
    }

    @Override
    public void sortFirstMenu() {
        System.out.println("Сколько дат вы хотите отсортировать?");
    }

    @Override
    public void sortSecondMenu(int i) {
        System.out.println("Введите дату №" + i);
    }

    @Override
    public void mainMenu() {
        System.out.println("    Гавное меню:\n" +
                "Пожалуйста выберите нужный вам пункт меню\n" +
                "1. Найти разницу между датами.\n" +
                "2. Дабавить к дате время\n" +
                "3. Вычесть из даты время\n" +
                "4. Отсортировать перечень дат.\n" +
                "5. Сменить формат представления дат.\n" +
                "6. Сменить язык.\n" +
                "0. Завершить программу.");
    }

    @Override
    public void choseFormatOfDate() {
        System.out.println("Выберети формат представления даты:\n" +
                "1. дд/мм/гг - 01/12/21\n" +
                "2. м/д/гггг - 3/4/2021\n" +
                "3. ммм-д-гг - Март-4-21\n" +
                "4. дд-ммм-гггг 00:00 - 09-Апрель-1789 00:00\n" +
                "0. Выйти из программы\n");
    }

    @Override
    public void soutResalt(String str) {
        System.out.println("Результат :\n");
        System.out.println(str + "\n");
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
    public void addTime() {
        System.out.println("Какое время нужно добавить к датe");
    }

    @Override
    public void divTime() {
        System.out.println("Какое время нужно вычесть из даты");
    }

    @Override
    public void hours() {
        System.out.print("Часов:");
    }

    @Override
    public void minutes() {
        System.out.print("Минут:");
    }

    @Override
    public void seconds() {
        System.out.print("Секунд:");
    }

    @Override
    public void days() {
        System.out.print("Дней:");
    }

    @Override
    public void month() {
        System.out.print("Месяцев:");
    }

    @Override
    public void years() {
        System.out.print("Лет:");
    }

    @Override
    public void operation() {
        System.out.println("Над какой датой будет проведена операция?");
    }

    @Override
    public void toSoutForParts(int[] time) {
        System.out.println("Разница между датами :\n" +
                time[6] + "лет " + time[5] + "месяцев " + time[4] + "дней " + time[3] + " часов " + time[2] + "минут " + time[1] + "секунд  ");

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
