package Сalendar.DateUtils.Converter.ToString;

public class ConverterUtils {

    public static int[] longDecoder(long num) {
        int[] date = new int[7];
        date[0] = (int) (num % 1000);//ms
        num /= 1000;
        date[1] = (int) (num % 60);//s
        num /= 60;
        date[2] = (int) (num % 60);//min
        num /= 60;
        date[3] = (int) (num % 24)+1;//h
        int[] temp = getMonth(num /= 24);
        date[4] = temp[2];//d
        date[5] = temp[1];//mon
        date[6] = temp[0];//y
        return date;
    }

    private static int[] getMonth(long days) {
        boolean stop = false;
        int monthNum = 1;
        int yearCounter = 0;

        while (!stop) {
            if (monthNum == 1 || monthNum == 3 || monthNum == 5 || monthNum == 7 || monthNum == 8 || monthNum == 10 || monthNum == 12) {
                if (days - 31 >= 0) {
                    days -= 31;
                    if (monthNum == 12) {
                        monthNum = 1;
                        yearCounter++;
                    } else {
                        monthNum++;
                    }
                } else {
                    stop = true;
                }
            } else if (monthNum == 4 || monthNum == 6 || monthNum == 9 || monthNum == 11) {
                if (days - 30 >= 0) {
                    monthNum++;
                    days -= 30;
                } else {
                    stop = true;
                }
            } else if (monthNum == 2) {
                int isBissextileYear = yearCounter % 4 == 0 ? 29 : 28;
                if (days - isBissextileYear >= 0) {
                    monthNum++;
                    days -= isBissextileYear;
                } else {
                    stop = true;
                }
            }
        }
        return new int[]{yearCounter, monthNum, (int) days};
    }
}
