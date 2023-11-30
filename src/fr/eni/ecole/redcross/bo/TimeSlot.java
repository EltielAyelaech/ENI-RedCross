package fr.eni.ecole.redcross.bo;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class TimeSlot {
    private LocalTime startTime;
    private int duration;
    private Doctor doctor;

    public TimeSlot(
        LocalTime startTime,
        int duration,
        Doctor doctor
    ) {
        this.startTime = startTime;
        this.duration = duration;
        this.doctor = doctor;

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

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    
}
