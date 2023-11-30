package fr.eni.ecole.redcross.bo;

import fr.eni.ecole.redcross.exception.ProgrammerException;
import fr.eni.ecole.redcross.exception.UserException;

public class SpecialistDoctor extends Doctor implements Comparable<SpecialistDoctor> {
    private String specialty;

    public SpecialistDoctor(
        String lastName,
        String firstName,
        String phoneNumber,
        Address address,
        String specialty,
        int rates
    ) throws UserException, ProgrammerException {
        super(
            lastName,
            firstName,
            phoneNumber,
            address
        );

        this.setSpecialty(specialty);
        this.setRates(rates);
    }

    public SpecialistDoctor(
        String lastName,
        String firstName,
        String phoneNumber,
        Address address
    ) throws UserException, ProgrammerException {
        super(
            lastName,
            firstName,
            phoneNumber,
            address
        );
    }

    @Override
    public void examine() {
        System.out.println("The doctor proceeds with routine exams on the patients (wsh je suis pas medecin je connais pas ces termes)");        
    }

    @Override
    public void diagnose() {
        System.out.println("The doctor evaluates the patient's health in order to discover eventual problems");
    }

    @Override
    public void treat() {
        System.out.println("The doctor dispenses a medical treatment.");
    }

    @Override
    public void counsel() {
        System.out.println("The doctor gives appropriate counselling on healthy habits (diet, hygiene...)");
    }

    @Override
    public void orient() {
        System.out.println("The doctor redirects to a specialist when necessary");
    }

    @Override
    public String toReducedString() {
        return String.format(
            String.join("\n",
                "%s",
                "Specialty: %s",
                "Rates: %s€"
            ),
            super.toString(),
            this.specialty,
            this.rates
        );
    }

    @Override
    public String toString() {
        return String.format(
            String.join("\n",
                "%s",
                "Specialty: %s"
            ),
            super.toString(),
            this.specialty
        );
    }

    @Override
    public int compareTo(SpecialistDoctor other) {
        return this.rates - other.getRates();
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) throws UserException {
        if (specialty == null || specialty.equals("")) throw new UserException("the specialty is mandatory");

        this.specialty = specialty;
    }

    public void setRates(int rates) throws UserException {
        if (rates <= 25) throw new UserException("the rates must be above 25€");

        super.setRates(rates);
    }
}
