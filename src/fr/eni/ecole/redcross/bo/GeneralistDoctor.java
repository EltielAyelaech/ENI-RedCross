package fr.eni.ecole.redcross.bo;

public class GeneralistDoctor {
    private String lastName;
    private String firstName;
    private String phoneNumber;

    private static int rates = 25;

    public GeneralistDoctor(
        String lastName,
        String firstName,
        String phoneNumber
    ) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
    }

    public void display() {
        System.out.printf(
            "%s %s\nPhone number: %s\nRates: %s€\n",
            this.lastName.toUpperCase(),
            this.firstName,
            this.phoneNumber,
            GeneralistDoctor.rates
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

    public static int getRates() {
        return rates;
    }

    public static void setRates(int rates) {
        GeneralistDoctor.rates = rates;
    }
}
