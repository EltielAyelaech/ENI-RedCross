package fr.eni.ecole.redcross.bo;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class TimeSlot {
    private LocalTime startTime;
    private int duration;
    private GeneralistDoctor doctor;

    public TimeSlot(
        LocalTime startTime,
        int duration,
        GeneralistDoctor doctor
    ) {
        this.startTime = startTime;
        this.duration = duration;
        this.doctor = doctor;

        doctor.addTimeSlot(this);
    }

    public void display() {
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm", new Locale("us"));

        System.out.printf(
            "%s - %s (%d minutes)\n",
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

    public GeneralistDoctor getDoctor() {
        return doctor;
    }

    public void setDoctor(GeneralistDoctor doctor) {
        this.doctor = doctor;
    }

    
}
