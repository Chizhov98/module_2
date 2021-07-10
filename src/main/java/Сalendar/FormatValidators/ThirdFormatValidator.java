package Сalendar.FormatValidators;

import Сalendar.Config.Enams.Months;

import java.util.Locale;

public class ThirdFormatValidator implements Validator {
    @Override
    public  boolean validator(String str) {
        String[] strArr = str.split("-");
        if (strArr.length != 3) return false;
        if (strArr[0] != null) {
            boolean monthIsGood = false;
            for (Months m : Months.values()) {
                if (m.getEnglishName().toLowerCase(Locale.ROOT).
                        equals(strArr[0].toLowerCase(Locale.ROOT))) monthIsGood = true;
                else if (m.getRussianName().toLowerCase(Locale.ROOT).
                        equals(strArr[0].toLowerCase(Locale.ROOT))) monthIsGood = true;
            }
            if (!monthIsGood) return false;
        }
        for (int i = 1; i < strArr.length; i++) {
            if (strArr[i] != null) {
                if (strArr[1].length() > 2) return false;
                if (strArr[i].matches("\\d+")) return false;
            }
        }
        return true;
    }
}
