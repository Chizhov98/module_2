package Сalendar.DateUtils.Converter.ToString.toStringImpl;

import Сalendar.Config.Months;
import Сalendar.DateUtils.Converter.ToString.ConverterToString;
import Сalendar.DateUtils.Converter.ToString.ConverterUtils;

import java.time.Month;

public class RussianToString implements ConverterToString {
    private String dateResult;
    private int[] dateInArray;


    private void newInitialize(long num) {
        dateResult = "";
        dateInArray = ConverterUtils.longDecoder(num);
    }

    @Override
    public String toStringFirstFormat(long num) {
        newInitialize(num);
        for (int i = 4; i < dateInArray.length; i++) {
            if (dateInArray[i] >= 100) {
                dateResult += (dateInArray[i] % 100) + "/";
            } else if (dateInArray[i] >= 10) {
                dateResult += dateInArray[i] + "/";
            } else {
                dateResult += "0" + dateInArray[i] + "/";
            }
        }
        dateResult = dateResult.substring(0, dateResult.length() - 1);
        return dateResult;
    }

    @Override
    public String toStringSecondFormat(long num) {
        newInitialize(num);
        for (int i = 4; i < dateInArray.length; i++) {
            if (i == 6 && dateInArray[i] <= 1000) {
                if (dateInArray[i] <= 100) {
                    dateResult += "00" + dateInArray[i] + "/";
                } else {
                    dateResult += "0" + dateInArray[i] + "/";
                }
            }
            dateResult += dateInArray[i] + "/";
        }
        dateResult = dateResult.substring(0, dateResult.length() - 1);
        return dateResult;
    }

    @Override
    public String toStringThirdFormat(long num) {
        newInitialize(num);
        dateResult+=getMonthName(dateInArray[5]) + "-" + dateInArray[4] + "-";
        if (dateInArray[6] >= 100) {
            return dateResult += (dateInArray[6] % 100);
        }
        return dateResult += dateInArray[6];
    }

    @Override
    public String toStringFifthFormat(long num) {
        newInitialize(num);
        dateResult += getMonthName(dateInArray[5]) + "-" + dateInArray[4] + "-";
        if (dateInArray[6] <= 1000) {
            if (dateInArray[6] <= 100) {
                dateResult += "00" + dateInArray[6];
            } else {
                dateResult += "0" + dateInArray[6];
            }
        }


        return dateResult += "  " + getTime(new int[]{dateInArray[3], dateInArray[2]});


    }

    @Override
    public String getMonthName(int monthNum) {
        return Months.foundByNum(monthNum).getRussianName();
    }

    private String getTime(int[] arr) {
        String time = "";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 10) {
                time += "0" + arr[i] + ":";
            } else {
                time += arr[i] + ":";
            }
        }
        return time.substring(0, time.length() - 1);
    }

}
