package Сalendar.DateUtils.Converter.FromString;

public class ConverterDefaultUtils {
    private static int yearsToDays(int years) {
        return (years * 365) + (years / 4) ;
    }

    private static int monthsToDays(int months, boolean isLeapYear) {
        int days = 0;
        switch (months) {
            case 12:
                days += 30;
            case 11:
                days += 31;
            case 10:
                days += 30;
            case 9:
                days += 31;
            case 8:
                days += 31;
            case 7:
                days += 30;
            case 6:
                days += 31;
            case 5:
                days += 30;
            case 4:
                days += 31;
            case 3:
                days = isLeapYear ? days + 29 : days + 28;
            case 2:
                days += 31;
        }
        return days;
    }

    private static int allToDays(int[] date) {
        int days = date[0];
        days += yearsToDays(date[2]);
        days += monthsToDays(date[1], date[2] % 4 == 0);

        return days;
    }

    public static long toLong(int[] date) {
        int days = allToDays(date);

        return days*86400000;
    }

    public static boolean validator(int length, String str) {
        if (str.length() != length) return false;
        return true;
    }
}
