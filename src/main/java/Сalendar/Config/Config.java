package Сalendar.Config;


import lombok.Getter;
import lombok.Setter;
import Сalendar.Config.Enams.DateFormats;
import Сalendar.Config.Enams.Languages;
import Сalendar.DateUtils.Converter.ToString.ConverterToString;
import Сalendar.UserInterface.UIOutput.UIMenu;


public class Config {
    @Setter
    @Getter
    private DateFormats format = DateFormats.DD_MM_YY;


    public UIMenu setMenuLanguage(Languages languages) {
        return languages.getMenu();
    }

    public ConverterToString setCconverter( Languages languages){
        return languages.getConverter();
    }



}
