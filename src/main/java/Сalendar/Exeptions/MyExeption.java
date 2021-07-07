package Сalendar.Exeptions;

import lombok.Getter;

@Getter
public enum MyExeption {
    INCORRECT_INPUT_FORMAT(801, "Дата была введена в неверном формате", "Input data has incorrect format")
    ;

    MyExeption(int id, String russianMessage, String englishMessage) {
        this.id = id;
        this.russianMessage = russianMessage;
        this.englishMessage = englishMessage;
    }

    int id;
    String russianMessage;
    String englishMessage;
}
