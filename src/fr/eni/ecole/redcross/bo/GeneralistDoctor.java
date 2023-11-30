package fr.eni.ecole.redcross.bo;

public class GeneralistDoctor extends Doctor {
    public GeneralistDoctor(
        String lastName,
        String firstName,
        String phoneNumber,
        Address address
    ) {
        super(
            lastName,
            firstName,
            phoneNumber,
            address
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
}
