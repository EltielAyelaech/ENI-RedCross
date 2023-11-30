package fr.eni.ecole.redcross.bo;

public abstract class Person {
    protected String lastName;
    protected String firstName;
    protected String phoneNumber;
    protected Address address;

    public static comparatorFullnameAscending = Comparator

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
