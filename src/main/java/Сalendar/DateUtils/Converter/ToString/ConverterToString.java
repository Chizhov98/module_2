package Сalendar.DateUtils.Converter.ToString;

public interface ConverterToString {

    String toStringFirstFormat(long num);

    String toStringSecondFormat(long num);

    String toStringThirdFormat(long num);

    String toStringForthFormat(long num);

    String getMonthName(int monthNum);

}
