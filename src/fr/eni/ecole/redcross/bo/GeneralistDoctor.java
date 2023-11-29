package fr.eni.ecole.redcross.bo;

public class GeneralistDoctor {
    private String lastName;
    private String firstName;
    private String phoneNumber;
    private Address address;
    private TimeSlot[] timeSlots;

    private static int rates = 25;

    public GeneralistDoctor(
        String lastName,
        String firstName,
        String phoneNumber,
        Address address
    ) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.timeSlots = new TimeSlot[15];
    }

    public void display() {
        System.out.printf(
            "%s %s\nPhone number: %s\nRates: %s€\n",
            this.lastName.toUpperCase(),
            this.firstName,
            this.phoneNumber,
            GeneralistDoctor.rates
        );
        System.out.println("Address:");
        this.address.display();
        System.out.println("Time slots:");
        for (TimeSlot timeSlot : this.timeSlots) {
            if (timeSlot != null) {
                timeSlot.display();
            }
        }
    }

    public void addTimeSlot(TimeSlot timeSlot) {
        for (int i = 0; i < this.timeSlots.length; i++) {
            if (this.timeSlots[i] == null) {
                this.timeSlots[i] = timeSlot;
                return;
            }
        }
        System.err.println("\033[31mOverbooked!\033[39m");
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
