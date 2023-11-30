package fr.eni.ecole.redcross.bo;

import java.util.Comparator;

import fr.eni.ecole.redcross.exception.ProgrammerException;
import fr.eni.ecole.redcross.exception.UserException;

public abstract class Person {
    protected String lastName;
    protected String firstName;
    protected String phoneNumber;
    protected Address address;

    public static Comparator<Person> comparatorFullnameAscending = new Comparator<Person>() {
        @Override
        public int compare(Person that, Person other) {
            String thatFullname = String.format(
                "%s %s",
                that.getLastName().toUpperCase(),
                that.getFirstName()
            );
            String otherFullname = String.format(
                "%s %s",
                other.getLastName().toUpperCase(),
                other.getFirstName()
            );

            return thatFullname.compareTo(otherFullname);
        }
    };

    public static Comparator<Person> comparatorFullnameDescending = comparatorFullnameAscending.reversed();

    protected Person(
        String lastName,
        String firstName,
        String phoneNumber,
        Address address
    ) throws UserException, ProgrammerException {
        this.setLastName(lastName);
        this.setFirstName(firstName);
        this.setPhoneNumber(phoneNumber);
        this.setAddress(address);
    }

    @Override
    public String toString() {
        return String.format(
            String.join("\n",
                "%s %s",
                "Phone number: %s",
                "Address:",
                "%s"
            ),
            this.lastName.toUpperCase(),
            this.firstName,
            this.phoneNumber,
            this.address
        );
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws UserException {
        if (
            lastName == null
            || lastName.equals("")
            || lastName.length() >= 100
        ) throw new UserException("the name is mandatory");

        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws UserException {
        if (
            firstName == null
            || firstName.equals("")
            || firstName.length() >= 100
        ) throw new UserException("the name is mandatory");

        this.firstName = firstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) throws UserException {
        if (phoneNumber != null && phoneNumber.length() != 10) throw new UserException("the phone number must be 10 digits long, if assigned");

        this.phoneNumber = phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) throws ProgrammerException {
        if (address == null) throw new ProgrammerException("the address is mandatory");

        this.address = address;
    }
}
