package fr.eni.ecole.redcross.bo;

public class GeneralistDoctor extends Doctor {
    public GeneralistDoctor(
        String lastName,
        String firstName,
        String phoneNumber,
        Address address
    ) {
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
