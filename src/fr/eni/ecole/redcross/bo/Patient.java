package fr.eni.ecole.redcross.bo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Patient extends Person {
    private char sex;
    private long socialSecurityNumber;
    private LocalDate birthDate;
    private String comments;

    public Patient(
        String lastName,
        String firstName,
        String phoneNumber,
        char sex,
        long socialSecurityNumber,
        LocalDate birthDate,
        String comments,
        Address address
    ) {
        super(
            lastName,
            firstName,
            phoneNumber,
            address
        );
        this.sex = sex;
        this.socialSecurityNumber = socialSecurityNumber;
        this.birthDate = birthDate;
        this.comments = comments;
    }

    @Override
    public String toString() {
        return String.format(
            "%s %s\nPhone number: %s\nSex: %s\nSocial security number: %d\nDate of birth: %s\nComments: %s\nAddress:\n%s",
            this.lastName.toUpperCase(),
            this.firstName,
            this.phoneNumber,
            this.sex == 'M' ? "Male" : "Female",
            this.socialSecurityNumber,
            this.birthDate.format(DateTimeFormatter.ofPattern("LLLL d yyyy", new Locale("us"))),
            this.comments != null ? this.comments : "[no comments]",
            this.address
        );
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public long getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(long socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
