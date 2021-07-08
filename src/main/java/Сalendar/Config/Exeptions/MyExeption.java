package Сalendar.Config.Exeptions;

import lombok.Getter;

@Getter
public enum MyExeption {
    SUCCESS(800,"Операция успешно выполенаб данные сохранены.\n","Operation completed successfully, data saved"),
    INCORRECT_INPUT_FORMAT(801, "Дата была введена в неверном формате.\n Попробуй еще.",
            "Input data has incorrect format.\n Try again."),
    ITEM_DOES_NOT_EXIST(802,"Функции с таким номером не соществует\nПопробуйте еще.",
            "The function whith chosen number not exist\nTry again.")
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
