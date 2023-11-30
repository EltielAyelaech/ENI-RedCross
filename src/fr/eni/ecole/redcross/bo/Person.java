package fr.eni.ecole.redcross.bo;

import java.util.Comparator;

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
    ) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
        this.address = address;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
