package fr.eni.ecole.redcross.test;

import java.time.LocalDate;
import java.time.LocalTime;

import fr.eni.ecole.redcross.bo.Address;
import fr.eni.ecole.redcross.bo.TimeSlot;
import fr.eni.ecole.redcross.bo.GeneralistDoctor;
import fr.eni.ecole.redcross.bo.Patient;
import fr.eni.ecole.redcross.bo.Person;
import fr.eni.ecole.redcross.bo.Appointment;

public class TestPerson {

	private static Address sh = new Address("ZAC du Moulin Neuf", 2, "B", "rue Benjamin Franklin", 44800,
			"Saint Herblain");
	// transtypage ascendant
	private static Person malalaniche = new GeneralistDoctor("Malalaniche", "Mélanie", "02.28.03.17.28", sh);

	private static Address nio = new Address(19, null, "avenue Léo Lagrange", 79000, "Niort");
	private static Patient adhemar = new Patient("Pamamobe", "Adhémar", "0753428619", 'M', 192112192020142l,
			LocalDate.of(1992, 11, 21), null, nio);

	public static void main(String[] args) {
		System.out.println("__________________________ Affichage d'un médecin ______________________________");
		malalaniche.display();
		//transtypage descendant
		GeneralistDoctor melanie =(GeneralistDoctor) malalaniche;
		melanie.displayAddressAndTimeSlots();

		System.out.println("__________________________ Affectation des TimeSlotx au médecin ______________________________");
		TimeSlot c1 = new TimeSlot(LocalTime.of(9, 0), 15, melanie);
		new TimeSlot(LocalTime.of(9, 15), 15, melanie);
		new TimeSlot(LocalTime.of(9, 30), 15, melanie);
		new TimeSlot(LocalTime.of(9, 45), 15, melanie);
		new TimeSlot(LocalTime.of(10, 30), 15, melanie);
		new TimeSlot(LocalTime.of(10, 45), 15, melanie);
		new TimeSlot(LocalTime.of(11, 15), 15, melanie);
		new TimeSlot(LocalTime.of(11, 30), 15, melanie);
		new TimeSlot(LocalTime.of(11, 45), 15, melanie);
		new TimeSlot(LocalTime.of(14, 0), 30, melanie);
		new TimeSlot(LocalTime.of(14, 30), 30, melanie);
		new TimeSlot(LocalTime.of(15, 0), 30, melanie);
		new TimeSlot(LocalTime.of(15, 30), 30, melanie);
		new TimeSlot(LocalTime.of(16, 0), 30, melanie);
		new TimeSlot(LocalTime.of(16, 30), 30, melanie);
		//polymorphisme
		melanie.display();
		melanie.displayAddressAndTimeSlots();
		
		System.out.println("__________________________ Affichage d'un Patient ______________________________");
		adhemar.display();

		System.out.println("__________________________ display le rendez-Vous du Patient ___________________________");
		Appointment rdv = new Appointment(c1, adhemar, LocalDate.of(2020, 5, 23));
		rdv.display();

	}
}
