package Сalendar.Config;

import lombok.Getter;
import Сalendar.DateUtils.Converter.FromString.ConverterDefaultUtils;
import Сalendar.DateUtils.Converter.FromString.FromString;


public enum DateFormats {
    DD_MM_YY(decoder = str -> {
        long date = 0;
        str = str.trim();
        if (ConverterDefaultUtils.validator(8, str)) {
            int days = Integer.valueOf(str.substring(0, 2));
            int months = Integer.valueOf(str.substring(3, 2));
            int years = Integer.valueOf(str.substring(6, 2));
        }
        return 11;
    })/*,
    M_D_YYYY(),
    MMM_D_YY(),
    DD_MMM_YYYY_Hours_MINUTES()*/;
    private static FromString decoder;
    private FromString privateDecoder;
    private long date;

    DateFormats(FromString decoder) {
        privateDecoder = decoder;
    }

    public long getDate(String str){
        return privateDecoder.decoder(str);
    }



}
