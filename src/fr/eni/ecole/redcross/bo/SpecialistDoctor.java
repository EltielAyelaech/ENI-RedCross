package fr.eni.ecole.redcross.bo;

public class SpecialistDoctor extends Doctor {
    private String specialty;

    public SpecialistDoctor(
        String lastName,
        String firstName,
        String phoneNumber,
        Address address,
        String specialty,
        int rates
    ) {
        super(
            lastName,
            firstName,
            phoneNumber,
            address
        );
        this.specialty = specialty;
        this.rates = rates;
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

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
    
}
