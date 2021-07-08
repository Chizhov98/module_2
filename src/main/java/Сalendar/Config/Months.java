package Сalendar.Config;

import lombok.Getter;
import org.jetbrains.annotations.Nullable;


@Getter
public enum Months {
    JANUARY(1, "January", "Январь"),
    FEBRUARY(2, "February", "Февраль"),
    MARCH(3, "March", "Март"),
    APRIL(4, "April", "Апрель"),
    MAY(5, "May", "Май"),
    JUNE(6, "June", "Июнь"),
    JULY(7, "July", "Июль"),
    AUGUST(8, "August", "Август"),
    SEPTEMBER(9, "September", "Сентябрь"),
    OCTOBER(10, "October", "Октябрь"),
    NOVEMBER(11, "November", "Ноябрь"),
    DECEMBER(12, "December", "Декабрь");

    private int num;
    private String englishName;
    private String russianName;

    Months(int num, String englishName, String russianName) {
        this.num = num;
        this.englishName = englishName;
        this.russianName = russianName;
    }


    public static Months foundByNum(int num) {
        Months[] months = Months.values();
        for (Months elem : months) {
            if (elem.getNum() == num)
                return elem;
        }
        return JANUARY;
    }
}
