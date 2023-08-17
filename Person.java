import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/**
 * Тип данных "Человек"
 */
public class Person {
    /** Фамилия */
    private String surname;
    /** Имя */
    private String name;
    /** Отчество */
    private String fathername;
    /** Дата рождения */
    private Date dateOfBirth;
    /** Номер телефона */
    private long phoneNumber;
    /** Пол - символ латиницей f или m */
    private char gender;

    /**
     * Конструктор класса:
     * создает пустой тип данных "Человек"
     */
    public Person() {
        this.surname = null;
        this.name = null;
        this.fathername = null;
        this.dateOfBirth = null;
        this.phoneNumber = 0;
        this.gender = 0;
    }

    /**
     * Конструктор класса:
     * @param surname Фамилия
     * @param name Имя
     * @param fathername Отчество
     * @param dateOfBirth Дата рождения
     * @param phoneNumber Номер телефона
     * @param gender пол
     */
    public Person(String surname, String name, String fathername, Date dateOfBirth,
                  int phoneNumber, char gender) {
        this.surname = surname;
        this.name = name;
        this.fathername = fathername;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    /**
     * Метод записи Человека в файл
     * Файл будет создан по фамилии человека
     * Однофамильцы будут записаны в один файл
     */
    public void addPersonInFile(){
        try (FileWriter writer = new FileWriter(new File(this.getSurname() + ".txt"), true)){
            writer.write(this.toString());
        } catch (IOException e) {
            throw new RuntimeException("Файла для записи не существует");
        }
    }

    @Override
    public String toString() {
        return String.format("<%s><%s><%s><%td.%tm.%tY><%d><%c>", surname, name, fathername, dateOfBirth,
                dateOfBirth, dateOfBirth, phoneNumber, gender);
    }
}
