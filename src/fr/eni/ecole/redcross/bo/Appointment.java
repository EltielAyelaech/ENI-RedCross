package fr.eni.ecole.redcross.bo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Appointment {
    private TimeSlot timeSlot;
    private Patient patient;
    private LocalDate date;

    public Appointment(
        TimeSlot timeSlot,
        Patient patient,
        LocalDate date
    ) {
        this.timeSlot = timeSlot;
        this.patient = patient;
        this.date = date;
    }

    public void display() {
        System.out.printf("Appointment on %s ", this.date.format(DateTimeFormatter.ofPattern("LLLL d yyyy", new Locale("us"))));
        this.timeSlot.display();
        System.out.printf("with Dr. %s\nfor ", this.timeSlot.getDoctor().getLastName());
        this.patient.display();
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
