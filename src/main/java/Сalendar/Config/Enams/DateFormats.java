package Сalendar.Config.Enams;

import Сalendar.DateUtils.Converter.FromString.Decoder;
import Сalendar.DateUtils.Converter.FromString.FormatValidators.*;
import Сalendar.DateUtils.Converter.FromString.Validator;

import java.util.Locale;

import static Сalendar.DateUtils.Converter.FromString.ConverterDefaultUtils.toLong;


public enum DateFormats {
    DD_MM_YY(decoder = str -> {
        str = str.trim();
        Validator validator = new FirstFormatValidator();

        if (!validator.validator(str)) {
            return -1;
        }
        String[] dateArr = str.split("/");
        return toLong(dateArr);
    }),

    M_D_YYYY(decoder = str -> {
        Validator validator = new SecondFormatValidator();
        str = str.trim();

        if (validator.validator(str)) {
            return -1;
        }
        String[] dateArr = str.split("/");

        String temp = dateArr[0];
        dateArr[0] = dateArr[1];
        dateArr[1] = temp;

        return toLong(dateArr);
    }),

    MMM_D_YY(decoder = str -> {
        str = str.trim();
        Validator validator = new ThirdFormatValidator();
        if (validator.validator(str)) return -1;
        String[] strArr = str.split("-");
        String dateArr[] = new String[3];
        dateArr[0] = strArr[1];
        if (strArr[0] != null) {
            for (Months m : Months.values()) {
                if (m.getEnglishName().toLowerCase(Locale.ROOT).
                        equals(strArr[0].toLowerCase(Locale.ROOT))) dateArr[1] = String.valueOf(m.getNum());
                else if (m.getRussianName().toLowerCase(Locale.ROOT).
                        equals(strArr[0].toLowerCase(Locale.ROOT))) dateArr[1] = String.valueOf(m.getNum());
            }
        } else dateArr[1] = "1";
        dateArr[2] = strArr[2];
        return toLong(dateArr);
    }),

    DD_MMM_YYYY_Hours_MINUTES(decoder = str -> {
        Validator validator = new FourthFormatValidator();
        str.trim();
        if (!validator.validator(str)) {
            return -1;
        }
        String[] date = new String[6];
        String[] sArr = str.split("-");
        date[0] = sArr[0];

        if (sArr[2] != null) {
            String[] strArr = sArr[2].trim().split(" ");
            date[3] = sArr[0];
            if (strArr.length == 2) {
                if (strArr[1] != null) {
                    if (strArr[1].length() == 5 || strArr[1].length() == 7) {
                        String[] time = strArr[1].split(":");
                        if (time.length != 7) date[5] = "00";
                        int j = 4;
                        for (String elem : time) {
                            if (elem != null) {
                                date[j] = elem;
                            } else date[j] = "00";
                        }
                    } else for (int i = 4; i < date.length; i++) {
                        date[i] = "00";
                    }
                }
            }
        }
        if (sArr[1] != null) {
            for (Months m : Months.values()) {
                if (m.getEnglishName().toLowerCase(Locale.ROOT).
                        equals(sArr[1].toLowerCase(Locale.ROOT))) date[1] = String.valueOf(m.getNum());
                else if (m.getRussianName().toLowerCase(Locale.ROOT).
                        equals(sArr[1].toLowerCase(Locale.ROOT))) date[1] = String.valueOf(m.getNum());
            }
        } else date[1] = "1";

        return toLong(date);
    });
    private static Decoder decoder;
    private Decoder privateDecoder;
    private long date;

    DateFormats(Decoder decoder) {
        privateDecoder = decoder;
    }

    public long getDate(String str) {
        return privateDecoder.decoder(str);
    }

}
