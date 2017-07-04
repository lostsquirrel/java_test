package demo.java.v8.lambda.use.caze;

import java.time.LocalDate;

public class Person {

    public String getEmailAddress() {
        return emailAddress;
    }

    public enum Sex {
        MALE, FEMALE
    }

    private String name;
    private LocalDate birthday;
    private Sex gender;
    private String emailAddress;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getAge() {
        return birthday == null ? -1 : LocalDate.now().getYear() - birthday.getYear();
    }

    public void printPerson() {
        System.out.println(String.format("name:{}, age:{}, gender:{}", name, getAge(), gender));
    }

    public Sex getGender() {
        return gender;
    }
}
