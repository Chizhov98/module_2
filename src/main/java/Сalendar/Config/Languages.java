package Сalendar.Config;

import lombok.Getter;
import Сalendar.UserInterface.Impl.EnglishMenu;
import Сalendar.UserInterface.Impl.RussianMenu;
import Сalendar.UserInterface.UIMenu;
@Getter
public enum Languages {
    RUSSIAN (new RussianMenu()),
    ENGLISH(new EnglishMenu())

    ;
    UIMenu menu;

    Languages(UIMenu menu) {
        this.menu = menu;
    }
}
