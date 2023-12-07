package fr.eni.ecole.redcross.bo;

import java.util.Arrays;

import fr.eni.ecole.redcross.exception.ProgrammerException;
import fr.eni.ecole.redcross.exception.UserException;

public abstract class Doctor extends Person {
    protected TimeSlot[] timeSlots;
    protected int rates = 25;
    protected Reimbursment reimbursment;

    protected Doctor(
        String lastName,
        String firstName,
        String phoneNumber,
        Address address,
        Reimbursment reimbursment
    ) throws UserException, ProgrammerException {
        super(
            lastName,
            firstName,
            phoneNumber,
            address
        );

        this.setReimbursment(reimbursment);
        this.setTimeSlots(new TimeSlot[15]);
    }

    public abstract void examine();
    public abstract void diagnose();
    public abstract void treat();
    public abstract void counsel();
    public abstract void orient();

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
        String timeSlotString = String.join(
            "\n",
            Arrays
                .stream(this.timeSlots)
                .filter(x -> x != null)
                .map(Object::toString)
                .toArray(String[]::new)
        );

        return String.format(
            String.join("\n",
                "%s",
                "Rates: %s€",
                "Time slots:",
                "%s",
                "%s"
            ),
            super.toString(),
            this.rates,
            timeSlotString.length() > 0 ? timeSlotString : "no time slots",
            this.reimbursment.getLabel()
        );
    }

    public void addTimeSlot(TimeSlot timeSlot) throws ProgrammerException {
        for (int i = 0; i < this.timeSlots.length; i++) {
            if (this.timeSlots[i] == null) {
                this.timeSlots[i] = timeSlot;
                return;
            }
        }
        throw new ProgrammerException("Overbooked!");
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

    public void setRates(int rates) throws UserException {
        this.rates = rates;
    }

    public Reimbursment getReimbursment() {
        return reimbursment;
    }

    public void setReimbursment(Reimbursment reimbursment) {
        this.reimbursment = reimbursment;
    }
    
}
