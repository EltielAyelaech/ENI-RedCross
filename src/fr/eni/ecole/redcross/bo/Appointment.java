package fr.eni.ecole.redcross.bo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import fr.eni.ecole.redcross.exception.ProgrammerException;
import fr.eni.ecole.redcross.exception.UserException;

public class Appointment {
    private TimeSlot timeSlot;
    private Patient patient;
    private LocalDate date;

    public Appointment(
        TimeSlot timeSlot,
        Patient patient,
        LocalDate date
    ) throws UserException, ProgrammerException {
        this.setTimeSlot(timeSlot);
        this.setPatient(patient);
        this.setDate(date);
    }

    @Override
    public String toString() {
        return String.format(
            "Appointment on %s %swith Dr. %s\nfor %s",
            this.date.format(DateTimeFormatter.ofPattern("LLLL d yyyy", new Locale("us"))),
            this.timeSlot,
            this.timeSlot.getDoctor().getLastName(),
            this.patient
        );
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) throws ProgrammerException {
        if (timeSlot == null) throw new ProgrammerException("time slot is mandatory");
        
        this.timeSlot = timeSlot;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) throws ProgrammerException {
        if (patient == null) throw new ProgrammerException("patient is mandatory");

        this.patient = patient;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) throws UserException {
        if (date.compareTo(LocalDate.now()) < 0) throw new UserException("Can't book an appointment in the past!");

        this.date = date;
    }
}
