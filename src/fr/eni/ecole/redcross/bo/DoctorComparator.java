package fr.eni.ecole.redcross.bo;

import java.util.Comparator;

public class DoctorComparator implements Comparator<SpecialistDoctor> {
    @Override
    public int compare(SpecialistDoctor doctor, SpecialistDoctor other) {
        return doctor.getSpecialty().compareTo(other.getSpecialty());
    }
}
