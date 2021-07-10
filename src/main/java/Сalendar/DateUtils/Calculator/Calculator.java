package Сalendar.DateUtils.Calculator;

import Сalendar.DateUtils.Converter.FromString.ConverterDefaultUtils;
import Сalendar.DateUtils.Converter.ToString.ConverterUtils;
import Сalendar.UserInterface.UINavigator.MenuNavigator;

import java.util.Arrays;

public class Calculator {

    public long[] sorted(String[] date) {
        long[] dates = new long[date.length];
        for (int i = 0; i <dates.length ; i++) {
            dates[i] = MenuNavigator.getConfig().getFormat().getPrivateDecoder().decoder(date[i]);;
        }
        return Arrays.stream(dates).sorted().toArray();
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
        for(int i=0;i<a.length;i++){
            a[i]= Math.abs(a[i]-b[i]);

        }
        return a;
    }

    public  long divTime(int[] a, int[] b) {
        a=difference(a,b);
        String[] results = new String[7];
        for (int i = 0; i < results.length; i++) {
            results[i] = String.valueOf(a[i]);
        }
        return ConverterDefaultUtils.toLong(results);
    }

    public  long addTime(int[] a, int[] b) {
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
