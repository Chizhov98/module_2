package Сalendar.FormatValidators;

public class SecondFormatValidator implements Validator {
    @Override
    public boolean validator(String str) {
        String[] strArr = str.split("/");
        if (strArr.length != 3) return false;
        for (int i = 0; i < 2; i++) {
            if (strArr[i] != null) {
                if (!strArr[i].matches("\\d+")) return false;
                if (strArr[i].length() > 2) return false;
            }
        }
        if (strArr[2] != null && !strArr[2].matches("\\d+")) return false;
        if (strArr[2] != null && strArr[2].length() != 4) return false;
        return true;
    }
}
