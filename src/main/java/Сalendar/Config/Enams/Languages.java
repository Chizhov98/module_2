package Сalendar.Config.Enams;

import lombok.Getter;
import Сalendar.DateUtils.Converter.ToString.ConverterToString;
import Сalendar.DateUtils.Converter.ToString.toStringImpl.EnglishToString;
import Сalendar.DateUtils.Converter.ToString.toStringImpl.RussianToString;
import Сalendar.UserInterface.UIOutput.Impl.EnglishMenu;
import Сalendar.UserInterface.UIOutput.Impl.RussianMenu;
import Сalendar.UserInterface.UIOutput.UIMenu;
@Getter
public enum Languages {
    RUSSIAN (new RussianMenu(), new RussianToString()),
    ENGLISH(new EnglishMenu(), new EnglishToString())

    ;
    UIMenu menu;
    ConverterToString converter;

    Languages(UIMenu menu, ConverterToString converter) {
        this.menu = menu;
        this.converter = converter;
    }
}
