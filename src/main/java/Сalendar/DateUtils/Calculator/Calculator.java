package Сalendar.DateUtils.Calculator;

import Сalendar.DateUtils.Converter.FromString.ConverterDefaultUtils;
import Сalendar.UserInterface.UINavigator.MenuNavigator;

import java.util.Arrays;

public class Calculator {

    public long[] sorted(String[] date) {
        long[] dates = new long[date.length];
        for (int i = 0; i < dates.length; i++) {
            dates[i] = MenuNavigator.getConfig().getFormat().getPrivateDecoder().decoder(date[i]);
        }
        Arrays.sort(dates);
        return dates;
    }

    public int[] difference(int[] a, int[] b) {

        if (a[6] < b[6]) {
            int[] c = a;
            a = b;
            b = c;
        } else if (a[6] == b[6]) {
            int[] c = a;
            a = b;
            b = c;
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = a[i] - b[i];
        }
        return nonMinus(a);
    }

    private int[] nonMinus(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                switch (i) {
                    case 1:
                    case 2:
                        arr[i] += 60;
                        arr[i + 1]--;
                        break;
                    case 3:
                        arr[i] += 24;
                        arr[i + 1]--;
                        break;
                    case 4:
                        int[] tempArr = monthConverter(arr[5], arr[6]);
                        arr[i] += tempArr[0];
                        arr[i + 1] += tempArr[1];
                        break;
                    case 5:
                        arr[i] += 12;
                        arr[i + 1]--;
                        break;
                }
            }
        }

        return arr;
    }

    private int[] monthConverter(int months, int year) {
        int[] result = new int[2];
        switch (months) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                result[0] = 30;
                if (months == 12) result[1] = 11;
                else result[1] = -1;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                result[0] = 31;
                result[1] = -1;
                break;
            case 2:
                result[1] = -1;
                result[0] = year % 4 == 0 ? 29 : 28;
                break;
        }
        return result;
    }

    public long divTime(int[] a, int[] b) {
        a = difference(a, b);
        String[] results = new String[7];
        for (int i = 0; i < results.length; i++) {
            results[i] = String.valueOf(a[i]);
        }
        return ConverterDefaultUtils.toLong(results);
    }

    public long addTime(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            a[i] += b[i];
        }

        String[] results = new String[7];
        for (int i = 0; i < results.length; i++) {
            results[i] = String.valueOf(a[i]);
        }
        return ConverterDefaultUtils.toLong(results);
    }


}
