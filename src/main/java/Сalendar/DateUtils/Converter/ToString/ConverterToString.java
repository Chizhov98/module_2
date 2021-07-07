package Сalendar.DateUtils.Converter.ToString;

public interface ConverterToString {
    String toStringFirstFormat(long num);

    String toStringSecondFormat(long num);

    String toStringThirdFormat(long num);

    String toStringFifthFormat(long num);

    default int[] longDecoder(long num) {
        int[] date = new int[7];
        date[0] = (int) (num % 100);
        num /= 100;
        date[1] = (int) (num % 60);
        num /= 60;
        date[2] = (int) (num % 60);
        num /= 60;
        date[3] = (int) (num % 24);
        int[] temp = getMonth(num /= 24);
        date[4] = temp[2];
        date[5] = temp[1];
        date[6] = temp[0];
        return date;
    }

    default int[] getMonth(long days) {
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
