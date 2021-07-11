package Сalendar.Config.Enams;

import lombok.Getter;
import Сalendar.Config.Exeptions.MyExeption;
import Сalendar.DateUtils.Converter.FromString.Decoder;
import Сalendar.FormatValidators.*;
import Сalendar.FormatValidators.Validator;
import Сalendar.UserInterface.UINavigator.MenuNavigator;

import java.util.Arrays;
import java.util.Locale;

import static Сalendar.DateUtils.Converter.FromString.ConverterDefaultUtils.toLong;


public enum DateFormats {
    DD_MM_YY(1, decoder = str -> {
        str = str.trim();
        str += "/";
        Validator validator = new FirstFormatValidator();

        if (!validator.validator(str)) {
            MenuNavigator.menu.exceptionSout(MyExeption.INCORRECT_INPUT_FORMAT);
            if (MenuNavigator.getScanner().continua()) MenuNavigator.mainMenu();
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
        str = str.trim();
        str += "/";
        Validator validator = new SecondFormatValidator();

        if (!validator.validator(str)) {
            MenuNavigator.menu.exceptionSout(MyExeption.INCORRECT_INPUT_FORMAT);
            if (MenuNavigator.getScanner().continua()) MenuNavigator.mainMenu();
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
        str += "-";
        Validator validator = new ThirdFormatValidator();
        if (!validator.validator(str)) {
            MenuNavigator.menu.exceptionSout(MyExeption.INCORRECT_INPUT_FORMAT);
            if (MenuNavigator.getScanner().continua()) MenuNavigator.mainMenu();
        }
        String[] strArr = str.split("-");
        String[] dateArr = new String[3];
        dateArr[0] = strArr[1];
        if (!strArr[0].equals("")) {
            for (Months m : Months.values()) {
                if (m.getEnglishName().toLowerCase(Locale.ROOT).
                        equals(strArr[0].toLowerCase(Locale.ROOT))) dateArr[1] = String.valueOf(m.getNum());
                else if (m.getRussianName().toLowerCase(Locale.ROOT).
                        equals(strArr[0].toLowerCase(Locale.ROOT))) dateArr[1] = String.valueOf(m.getNum());
            }
        } else dateArr[1] = "1";
        dateArr[2] = strArr[2];

        String[] result = new String[7];
        for (int i = 0; i < 4; i++) {
            result[i] = "00";
        }
        result[4] = dateArr[0];
        result[5] = dateArr[1];
        result[6] = dateArr[2];

        for (int i=0; i<result.length;i++){
            if (result[i]==null)result[i]="";
        }
        return toLong(result);
    }),

    DD_MMM_YYYY_Hours_MINUTES(4, decoder = str -> {
        Validator validator = new FourthFormatValidator();
        str = str.trim();
        if (!validator.validator(str)) {
            MenuNavigator.menu.exceptionSout(MyExeption.INCORRECT_INPUT_FORMAT);
            if (MenuNavigator.getScanner().continua()) MenuNavigator.mainMenu();
        }

        String[] tempArr = str.split(" ");

        String[] strArr = tempArr[0].split("-");
        String[] dateArr = new String[3];
        dateArr[0] = strArr[0];
        if (!strArr[1].equals("")) {
            for (Months m : Months.values()) {
                if (m.getEnglishName().toLowerCase(Locale.ROOT).
                        equals(strArr[1].toLowerCase(Locale.ROOT))) dateArr[1] = String.valueOf(m.getNum());
                else if (m.getRussianName().toLowerCase(Locale.ROOT).
                        equals(strArr[1].toLowerCase(Locale.ROOT))) dateArr[1] = String.valueOf(m.getNum());
            }
        } else dateArr[1] = "1";
        dateArr[2] = strArr[2];

        String[] result = new String[7];
        result[4] = dateArr[0];
        result[5] = dateArr[1];
        result[6] = dateArr[2];

        if (tempArr.length > 1) {
            String[] time = tempArr[1].split(":");
            if (time.length <= 3)
                for (int i = 0; i < time.length; i++) {
                    result[2 - i] = time[i];
                }
        }
        for (int i=0; i<result.length;i++){
            if (result[i]==null)result[i]="";
        }
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
