package fr.eni.ecole.redcross.test;

import fr.eni.ecole.redcross.bo.GeneralistDoctor;

public class TestDoctor {
    public static void main(String[] args) {
        System.out.println("__________________________ Médecins ______________________________");
		GeneralistDoctor melanie = new GeneralistDoctor("Malalaniche", "Mélanie", "02.28.03.17.28");
		GeneralistDoctor edmond = new GeneralistDoctor("Bosapin", "Edmond", "+33 2 17 18 19 20");
		GeneralistDoctor djemila = new GeneralistDoctor("Table", "Djémila", "03-04-05-06-07");

		melanie.display();
		System.out.println("------------------------------------------------------------------");
		edmond.display();
		System.out.println("------------------------------------------------------------------");
		djemila.display();

		System.out.println("--------------- Changement du numéro de ce médecin ---------------");
		djemila.setPhoneNumber("07-06-05-04-03");
		System.out.printf("Nouveau numéro du Dr %s : %s%n", djemila.getLastName(), djemila.getPhoneNumber());
		
		System.out.println("-------------- Changement du prix de la consultation -------------");
		GeneralistDoctor.setRates(23);
		melanie.display();
		System.out.println("------------------------------------------------------------------");
		edmond.display();
		System.out.println("------------------------------------------------------------------");
		djemila.display();
    }
}
