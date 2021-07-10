package Сalendar.Config.Enams;

import lombok.Getter;
import Сalendar.UserInterface.UIOutput.Impl.EnglishMenu;
import Сalendar.UserInterface.UIOutput.Impl.RussianMenu;
import Сalendar.UserInterface.UIOutput.UIMenu;
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
