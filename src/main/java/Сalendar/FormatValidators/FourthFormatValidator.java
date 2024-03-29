package Сalendar.FormatValidators;

import Сalendar.Config.Enams.Months;


import java.util.Locale;

public class FourthFormatValidator implements Validator {
    @Override
    public boolean validator(String str) {

        String[] sArr = str.split("-");
        if (sArr.length != 3) return false;
        if (!sArr[2].equals("")) {
            String[] strArr = sArr[2].trim().split(" ");
            if (strArr.length > 2) return false;
            if (!strArr[0].matches("\\d+") ||
                    strArr[0].length() != 4) return false;
            if (strArr.length == 2) {
                if (!strArr[1].equals("")) {
                    if (strArr[1].length() == 5 || strArr[1].length() == 7) {
                        String[] time = strArr[1].split(":");
                        for (String elem : time) {
                            if (!elem.matches("\\d+")) return false;
                            if (elem.length() != 2) return false;
                        }
                    } else return false;
                }

            }

        }
        if (!sArr[0].equals("")) {
            if (!sArr[0].matches("\\d+")) return false;
            if (sArr[0].length() != 2) return false;
        }


        if (!sArr[1].equals("")) {

            boolean monthIsGood = false;
            for (Months m : Months.values()) {
                if (m.getEnglishName().toLowerCase(Locale.ROOT).
                        equals(sArr[1].toLowerCase(Locale.ROOT))) monthIsGood = true;
                else if (m.getRussianName().toLowerCase(Locale.ROOT).
                        equals(sArr[1].toLowerCase(Locale.ROOT))) monthIsGood = true;
            }
            if (!monthIsGood) return false;
        }


        return true;
    }
}
