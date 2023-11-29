package fr.eni.ecole.redcross.test;

import java.time.LocalTime;

import fr.eni.ecole.redcross.bo.Address;
import fr.eni.ecole.redcross.bo.TimeSlot;
import fr.eni.ecole.redcross.bo.GeneralistDoctor;

public class TestTimeSlot {
	public static void main(String[] args) {
		Address sh = new Address("ZAC du Moulin Neuf", 2, "B", "rue Benjamin Franklin", 44800,
				"Saint Herblain");
		GeneralistDoctor melanie = new GeneralistDoctor("Malalaniche", "Mélanie", "02.28.03.17.28", sh);
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
		System.out.println("__________________________ Créneaux ______________________________");
		c1.display();
		System.out.println("Médecin associé à ce créneau : Dr " + c1.getDoctor().getLastName());
		System.out.println("------------------------------------------------------------------");
		melanie.display();
	}
}
