package fr.eni.ecole.redcross.bo;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import fr.eni.ecole.redcross.exception.ProgrammerException;
import fr.eni.ecole.redcross.exception.UserException;

public class TimeSlot {
    private LocalTime startTime;
    private int duration;
    private Doctor doctor;

    public TimeSlot(
        LocalTime startTime,
        int duration,
        Doctor doctor
    ) throws UserException, ProgrammerException {
        this.setStartTime(startTime);
        this.setDuration(duration);
        this.setDoctor(doctor);

        doctor.addTimeSlot(this);
    }

    @Override
    public String toString() {
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm", new Locale("us"));

        return String.format(
            "%s - %s (%d minutes)",
            this.startTime.format(timeFormat),
            this.startTime.plusMinutes(this.duration).format(timeFormat),
            this.duration
        );
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) throws ProgrammerException {
        if (doctor == null) throw new ProgrammerException("Doctor is mandatory");

        this.doctor = doctor;
    }

    
}
