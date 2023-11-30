package fr.eni.ecole.redcross.test;

import java.time.LocalDate;
import java.time.LocalTime;

import fr.eni.ecole.redcross.bo.Address;
import fr.eni.ecole.redcross.bo.TimeSlot;
import fr.eni.ecole.redcross.bo.GeneralistDoctor;
import fr.eni.ecole.redcross.bo.SpecialistDoctor;
import fr.eni.ecole.redcross.bo.Patient;
import fr.eni.ecole.redcross.bo.Appointment;

public class TestSpecialty {

	private static Address sh = new Address("ZAC du Moulin Neuf", 2, "B", "rue Benjamin Franklin", 44800,
			"Saint Herblain");
	private static GeneralistDoctor melanie = new GeneralistDoctor("Malalaniche", "Mélanie", "02.28.03.17.28", sh);
	private static SpecialistDoctor celine = new SpecialistDoctor("OCENSEMAIME", "Céline", "0748159263", sh, "CARDILOGIE", 52);

	private static Address nio = new Address(19, null, "avenue Léo Lagrange", 79000, "Niort");
	private static Patient adhemar = new Patient("Pamamobe", "Adhémar", "0753428619", 'M', 192112192020142l,
			LocalDate.of(1992, 11, 21), null, nio);

	public static void main(String[] args) {
		
		System.out.println("__________________________ Médecins généralistes ______________________________");
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
		melanie.display();

		System.out.println("__________________________ Médecins spécialistes __________________________");
		new TimeSlot(LocalTime.of(14, 0), 20, celine);
		new TimeSlot(LocalTime.of(14, 20), 20, celine);
		new TimeSlot(LocalTime.of(14, 40), 20, celine);
		new TimeSlot(LocalTime.of(15, 0), 20, celine);
		TimeSlot c2 = new TimeSlot(LocalTime.of(15, 20), 20, celine);
		new TimeSlot(LocalTime.of(15, 40), 20, celine);
		new TimeSlot(LocalTime.of(16, 0), 20, celine);
		new TimeSlot(LocalTime.of(16, 20), 20, celine);
		new TimeSlot(LocalTime.of(16, 40), 20, celine);
		new TimeSlot(LocalTime.of(17, 0), 20, celine);
		celine.display();
		
		
		System.out.println("__________________________ Rendez-Vous avec médecin generaliste ___________________________");
		Appointment rdvGen = new Appointment(c1, adhemar, LocalDate.of(2023, 4, 10));
		rdvGen.display();
		System.out.println("__________________________ Rendez-Vous avec médecin spécialiste ___________________________");
		Appointment rdvSpe = new Appointment(c2, adhemar, LocalDate.of(2023, 6, 17));
		rdvSpe.display();
	}
}
