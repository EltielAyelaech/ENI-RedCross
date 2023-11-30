package fr.eni.ecole.redcross.bo;

import java.util.Arrays;

public abstract class Doctor extends Person {
    protected TimeSlot[] timeSlots;
    protected int rates;

    protected Doctor(
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
        this.timeSlots = new TimeSlot[15];
        this.rates = 25;
    }

    public String toReducedString() {
        return String.format(
            String.join("\n",
                "%s",
                "Rates: %s€"
            ),
            super.toString(),
            this.rates
        );
    }

    @Override
    public String toString() {
        return String.format(
            String.join("\n",
                "%s",
                "Rates: %s€",
                "Time slots:",
                "%s"
            ),
            super.toString(),
            this.rates,
            String.join(
                "\n",
                Arrays
                    .stream(this.timeSlots)
                    .filter(x -> x != null)
                    .map(Object::toString)
                    .toArray(String[]::new)
            )
        );
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

    public TimeSlot[] getTimeSlots() {
        return timeSlots;
    }

    public void setTimeSlots(TimeSlot[] timeSlots) {
        this.timeSlots = timeSlots;
    }

    public int getRates() {
        return rates;
    }

    public void setRates(int rates) {
        this.rates = rates;
    }
    
}
