import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.Scanner;

/**
 * Класс для проверки корректности введенных данных пользователем
 */
public class EnterNewUser {
    /**
     * Подготовленные данные введенные пользователем для проверки соответствия
     */
    private String[] userDetailsForParsing;

    /**
     * Инициируем количество данных, которые должны быть введены пользователем
     */
    public EnterNewUser() {
        this.userDetailsForParsing = new String[6];
    }

    /**
     * Метод
     * Введите данные пользователя
     * @return подготовленные данные пользователя для дальнейшего форматирования
     */
    public String[] enterUserInfo(){
        System.out.println("Введите свои данные: ФИО, дата рождения, номер телефона, пол (f или m); в следующем формате:\n" +
                "Фамилия Имя Отчество dd.mm.yyyy 79261234589 m");
        Scanner scanner = new Scanner(System.in);
        String newUserDetails = scanner.nextLine();
        try {
            this.userDetailsForParsing = newUserDetails.split(" ");
        } catch (RuntimeException e){
            throw new ExceptionsUserCreate("Проверьте количество и формат ввода данных, наличие пробелов обязательно!");
        }
        return userDetailsForParsing;
    }

    /**
     * Метод проверки соответствия введенных пользователем данных
     * @param userDetailsForParsing Подготовленные данные введенные пользователем для проверки соответствия
     * @return корректно заполненный тип данных "Человек"
     */
    public static Person verifyUserInfo(String[] userDetailsForParsing){
        Person person = new Person();
        try {
            person.setSurname(userDetailsForParsing[0]);
            person.setName(userDetailsForParsing[1]);
            person.setFathername(userDetailsForParsing[2]);
        } catch (RuntimeException e0){
            throw new ExceptionsUserCreate("Неверный формат ФИО");
        }
        try {
            DateFormat dateOfBirth = new SimpleDateFormat("dd.MM.yyyy");
            Formatter f = new Formatter();
            Date date = dateOfBirth.parse(userDetailsForParsing[3]);
            person.setDateOfBirth(date);
        } catch (ParseException e1){
            throw new ExceptionsUserCreate("Неверный формат даты рождения");
        }
        try {
            long phoneNumber = Long.parseLong(userDetailsForParsing[4]);
            person.setPhoneNumber(phoneNumber);
        } catch (NumberFormatException e2){
            throw new ExceptionsUserCreate("Неверный формат номера телефона");
        }
        try {
            if (userDetailsForParsing[5].length() == 1) {
                if (userDetailsForParsing[5].equalsIgnoreCase("f")
                        || userDetailsForParsing[5].equalsIgnoreCase("m")) {
                    person.setGender(userDetailsForParsing[5].charAt(0));
                }
            }
        } catch (RuntimeException e3){
            throw new ExceptionsUserCreate("пол может быть обозначен только одним символом латиницы f или m");
        }
        return person;
    }

}
