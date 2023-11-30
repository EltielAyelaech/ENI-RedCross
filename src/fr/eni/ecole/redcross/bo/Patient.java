package fr.eni.ecole.redcross.bo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import fr.eni.ecole.redcross.exception.ProgrammerException;
import fr.eni.ecole.redcross.exception.UserException;

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
    ) throws UserException, ProgrammerException {
        super(
            lastName,
            firstName,
            phoneNumber,
            address
        );

        this.setSex(sex);
        this.setSocialSecurityNumber(socialSecurityNumber);
        this.setBirthDate(birthDate);
        this.setComments(comments);
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

    public void setSex(char sex) throws UserException {
        if (sex == 'f' || sex == 'm') sex = (char) (sex + 'A' - 'a');
        if (sex != 'F' && sex != 'M') throw new UserException("the sex bust be either 'F' or 'M'");

        this.sex = sex;
    }

    public long getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(long socialSecurityNumber) throws UserException {
        if (Long.toString(socialSecurityNumber).length() != 13) throw new UserException("the social security number must be 13 digits long");

        this.socialSecurityNumber = socialSecurityNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) throws UserException {
        if (birthDate == null) throw new UserException("the birth date is mandatory");
        if (birthDate.compareTo(LocalDate.now()) > 0) throw new UserException("the birth date can't be after today");
        if (birthDate.compareTo(LocalDate.of(1900, 1, 1)) < 0) throw new UserException("the birth date can't be before the 01/01/1900");

        this.birthDate = birthDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
