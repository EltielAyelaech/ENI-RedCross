package fr.eni.ecole.redcross.bo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import fr.eni.ecole.redcross.exception.ProgrammerException;
import fr.eni.ecole.redcross.exception.UserException;

public class MedicalFile {
    private int weight;
    private int size;
    private String tension;  // "^\d+/\d+$"
    private int oxygenation;
    private int pulse;
    private String problem;
    private String prescription;
    private LocalDate treatmentDate;
    private Patient patient;
    private Doctor doctor;

    public MedicalFile(
        int weight,
        int size,
        String tension,
        int oxygenation,
        int pulse,
        String problem,
        String prescription,
        LocalDate treatmentDate,
        Patient patient,
        Doctor doctor
    ) throws UserException, ProgrammerException {
        this.setWeight(weight);
        this.setSize(size);
        this.setTension(tension);
        this.setOxygenation(oxygenation);
        this.setPulse(pulse);
        this.setProblem(problem);
        this.setPrescription(prescription);
        this.setTreatmentDate(treatmentDate);
        this.setPatient(patient);
        this.setDoctor(doctor);
    }

    @Override
    public String toString() {
        return String.format(
            String.join("\n",
                "Medical file owner:",
                "%s",
                "Weight: %dkg, size: %dcm",
                "Tension: %scmHg, saturation: %d%%, pulse: %d",
                "Problem: %s",
                "Prescription: %s",
                "Treatment date: %s",
                "Assigned generalist doctor: %s",
                "%s"
            ),
            this.patient,
            this.weight,
            this.size,
            this.tension,
            this.oxygenation,
            this.pulse,
            this.problem,
            this.prescription,
            this.treatmentDate.format(DateTimeFormatter.ofPattern("LLLL d yyyy")),
            this.doctor.toReducedString(),
            Payment.reminderToBePaidToString(this.doctor)
        );
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getTension() {
        return tension;
    }

    public void setTension(String tension) {
        this.tension = tension;
    }

    public int getOxygenation() {
        return oxygenation;
    }

    public void setOxygenation(int oxygenation) {
        this.oxygenation = oxygenation;
    }

    public int getPulse() {
        return pulse;
    }

    public void setPulse(int pulse) {
        this.pulse = pulse;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public LocalDate getTreatmentDate() {
        return treatmentDate;
    }

    public void setTreatmentDate(LocalDate treatmentDate) {
        this.treatmentDate = treatmentDate;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    
}
