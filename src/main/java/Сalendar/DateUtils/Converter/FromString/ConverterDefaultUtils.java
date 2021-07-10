package Сalendar.DateUtils.Converter.FromString;

public class ConverterDefaultUtils {
    private static int[] transformToIntArr(String[] dates) {
        int[] date = new int[dates.length];
        for (int i = 0; i < date.length; i++) {
            if (dates[i] != null) {
                date[i] = Integer.valueOf(dates[i]);
            } else
                date[i] = 0;
        }
        return validate(date);
    }

    private static int[] validate(int[] dates) {
        for (int elem : dates) {
            if (elem < 0) return new int[]{-1, -1, -1, -1, -1, -1, -1};
        }
        if ((dates[0] > 31) && (dates[1] == 1 || dates[1] == 3 || dates[1] == 5 || dates[1] == 7 || dates[1] == 8 || dates[1] == 10 || dates[1] == 12)
                || ((dates[0] > 30) && (dates[1] == 4 || dates[1] == 6 || dates[1] == 9 || dates[1] == 11))
                || (dates[0] > 28 && dates[1] == 2 && dates[3] % 4 != 0)
                || dates[0] > 29 && dates[1] == 2 && dates[3] % 4 == 0) return new int[]{-1, -1, -1, -1, -1, -1, -1};

        return dates;
    }


    private static int yearsToDays(int years) {
        return (years * 365) + (years / 4)+1;
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

    public static long allToAbsoluteSeconds(int[] date) {
        int days = date[4];
        days += yearsToDays(date[6]);
        days += monthsToDays(date[5], date[6] % 4 == 0);
        long result = (days * 86400000L);
        result += date[0] + (date[1] * 1000) + date[2] * 60000 + date[3] * 3600000;
        return result;
    }

    public static long toLong(String[] date) {
        long result = allToAbsoluteSeconds(
                transformToIntArr(
                        motNullDate(date)));
        return result;
    }

    private static String[] motNullDate(String[] date) {
        for (int i = 0; i < date.length; i++) {
            if (date[i] == null && i != 2) date[i] = "1";
        }
        if (date[2] == null) date[2] = "0";
        return date;
    }
}
