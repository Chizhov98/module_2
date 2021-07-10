package Сalendar.Config.Enams;

import lombok.Getter;
import Сalendar.DateUtils.Converter.FromString.Decoder;
import Сalendar.FormatValidators.*;
import Сalendar.FormatValidators.Validator;

import java.util.Locale;

import static Сalendar.DateUtils.Converter.FromString.ConverterDefaultUtils.toLong;


public enum DateFormats {
    DD_MM_YY(1, decoder = str -> {
        str = str.trim();
        Validator validator = new FirstFormatValidator();

        if (!validator.validator(str)) {
            return -1;
        }
        String[] dateArr = str.split("/");
        String[] result = new String[7];
        for (int i = 0; i < 4; i++) {
            result[i] = "00";
        }
        result[4] = dateArr[0];
        result[5] = dateArr[1];
        result[6] = dateArr[2];
        return toLong(result);
    }),

    M_D_YYYY(2, decoder = str -> {
        Validator validator = new SecondFormatValidator();
        str = str.trim();

        if (validator.validator(str)) {
            return -1;
        }
        String[] dateArr = str.split("/");

        String[] result = new String[7];
        for (int i = 0; i < 4; i++) {
            result[i] = "00";
        }
        result[4] = dateArr[1];
        result[5] = dateArr[0];
        result[6] = dateArr[2];
        return toLong(result);
    }),

    MMM_D_YY(3, decoder = str -> {
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
        }else dateArr[1] = "1";
        dateArr[2] = strArr[2];

        String[] result = new String[7];
        for (int i = 0; i < 4; i++) {
            result[i] = "00";
        }
        result[4] = dateArr[1];
        result[5] = dateArr[0];
        result[6] = dateArr[2];
        return toLong(result);
    }),

    DD_MMM_YYYY_Hours_MINUTES(4, decoder = str -> {
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
            date[2] = sArr[0];
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
                else date[1] = "1";
            }
        } else date[1] = "1";


        String[] result = new String[7];
        for (int i = 0; i < 4; i++) {
            result[i] = date[date.length-i];
        }
        result[4] = date[0];
        result[5] = date[1];
        result[6] = date[2];
        return toLong(result);
    });

    private static Decoder decoder;
    @Getter
    private Decoder privateDecoder;
    @Getter
    private int id;

    DateFormats(int id, Decoder decoder) {
        this.id = id;
        privateDecoder = decoder;
    }

    public long getDate(String str) {
        return privateDecoder.decoder(str);
    }
}
