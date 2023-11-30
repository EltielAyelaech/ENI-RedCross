package fr.eni.ecole.redcross.test;

import java.time.LocalDate;
import java.time.LocalTime;

import fr.eni.ecole.redcross.bo.Address;
import fr.eni.ecole.redcross.bo.TimeSlot;
import fr.eni.ecole.redcross.bo.Doctor;
import fr.eni.ecole.redcross.bo.GeneralistDoctor;
import fr.eni.ecole.redcross.bo.SpecialistDoctor;
import fr.eni.ecole.redcross.bo.Patient;
import fr.eni.ecole.redcross.bo.Person;
import fr.eni.ecole.redcross.bo.Appointment;
import fr.eni.ecole.redcross.exception.ProgrammerException;
import fr.eni.ecole.redcross.exception.UserException;

public class TestExpectedP5 {

	public static void main(String[] args) {
		Address sh= null, nio=null, lr=null;
		Person jean=null, adhemar=null;
		TimeSlot c1=null;
		Appointment rdv= null;
		
		System.out.println("__________________________ Adresses ______________________________");
		//cas nominal
		try {
			sh = new Address("ZAC du Moulin Neuf", 2, "B", "rue Benjamin Franklin", 44800, "Saint Herblain");
			nio = new Address(19, null, "avenue Léo Lagrange", 79000, "Niort");
			lr = new Address(null, 18, "B", "rue des Fleurs", 17000, "La Rochelle");
		} catch (UserException | ProgrammerException e) {
			System.out.println(e.getMessage());
		}

		
		
		System.out.println("__________________________ Patients ______________________________");
		
		//test sexe : different de 'F' et 'M'
		try {
			jean = new Patient("Dupond", "Jean", "0753428619",'m', 1921121920201l, LocalDate.of(1992, 11, 21), null, nio);
			System.out.println(((Patient)jean).getSex());
		} catch (UserException | ProgrammerException e) {
			System.out.println(e.getMessage());
		}
		
		//test date de naissance : inferieur à date du jour
		try {
			jean = new Patient("Dupond", "Jean", "0753428619",'m', 1921121920201l, LocalDate.now().plusDays(10L), null, nio);
		} catch (UserException | ProgrammerException e) {
			System.out.println(e.getMessage());
		}
		
		//test date de naissance : superieur au 01/01/1900
		try {
			jean = new Patient("Dupond", "Jean", "0753428619",'m', 1921121920201l, LocalDate.of(1900, 1, 1).minusDays(10L), null, nio);
		} catch (UserException | ProgrammerException e) {
			System.out.println(e.getMessage());
		}

		//test patient sans adresse
		try {
			jean = new Patient("Dupond", "Jean", "0753428619",'m', 1921121920201l, LocalDate.of(1992, 11, 21), null, null);
		} catch (UserException | ProgrammerException e) {
			System.out.println(e.getMessage());
		}

		//cas nominal
		try {
			jean = new Patient("Dupond", "Jean", "0753428619",'M', 1921121920201l, LocalDate.of(1992, 11, 21), null, nio);
			adhemar = new Patient("Pamamobe", "Adhémar", "0753428619", 'M', 1921121920201l, LocalDate.of(1992, 11, 21), null, lr);
		} catch (UserException | ProgrammerException e) {
			System.out.println(e.getMessage());
		}

		
		
		System.out.println("__________________________ Médecins géneralistes ______________________________");
		Doctor melanie = null;
		//test Doctor sans adresse
		try {
			melanie = new GeneralistDoctor("Malalaniche", "Mélanie", "0228031728", null);
		} catch (UserException | ProgrammerException e) {
			System.out.println(e.getMessage());
		}

		//cas nominal
		try {
			melanie = new GeneralistDoctor("Malalaniche", "Mélanie", "0228031728", sh);
			c1 = new TimeSlot(LocalTime.of(9, 0), 15, melanie);
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
			new TimeSlot(LocalTime.of(16, 30), 30, null); //instance inexistante
			System.out.println(melanie.toString());
			
		} catch (UserException | ProgrammerException e) {
			System.out.println(e.getMessage());
		}
	
		try {
			new TimeSlot(LocalTime.of(16, 30), 30, melanie);
			new TimeSlot(LocalTime.of(17, 0), 30, melanie); // trop de TimeSlotx pour ce Doctor
		} catch (UserException | ProgrammerException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("__________________________ Rendez-Vous ___________________________");
		//date de rendez-vous antérieur à la date du jour
		try {
			rdv = new Appointment(c1, (Patient)adhemar, LocalDate.now().minusDays(10L));
			System.out.println(rdv.toString());
		} catch (UserException | ProgrammerException e) {
			System.out.println(e.getMessage());
		}
		
		//pas d'instance de TimeSlot
		try {
			rdv = new Appointment(null, (Patient)adhemar, LocalDate.now().minusDays(10L));
			System.out.println(rdv.toString());
		} catch (UserException | ProgrammerException e) {
			System.out.println(e.getMessage());
		}

		//pas d'instance de patient
		try {
			rdv = new Appointment(c1,  null, LocalDate.now().minusDays(10L));
			System.out.println(rdv.toString());
		} catch (UserException | ProgrammerException e) {
			System.out.println(e.getMessage());
		}


		System.out.println("__________________________ Médecins spécialistes ______________________________");
		//test Doctor sans adresse
		Doctor edmond;
		try {
			edmond = new SpecialistDoctor("Bosapin", "Edmond", "0228031724", null, "CARDIOLOGIE", 52);
			System.out.println(edmond);
		} catch (UserException | ProgrammerException e) {
			System.out.println(e.getMessage());
		}
		
		//cas nominal
		SpecialistDoctor celine=null;
		TimeSlot c2= null;
		try {
			celine = new SpecialistDoctor("OCENSEMAIME", "Céline", "0748159263", sh, "ORL", 52);
			new TimeSlot(LocalTime.of(10, 0), 20, celine);
			new TimeSlot(LocalTime.of(10, 20), 20, celine);
			new TimeSlot(LocalTime.of(10, 40), 20, celine);
			new TimeSlot(LocalTime.of(11, 0), 20, celine);
			new TimeSlot(LocalTime.of(11, 20), 20, celine);
			new TimeSlot(LocalTime.of(11, 40), 20, celine);
			new TimeSlot(LocalTime.of(14, 0), 20, celine);
			new TimeSlot(LocalTime.of(14, 20), 20, celine);
			new TimeSlot(LocalTime.of(14, 40), 20, celine);
			new TimeSlot(LocalTime.of(15, 0), 20, celine);
			c2 = new TimeSlot(LocalTime.of(15, 20), 20, celine);
			new TimeSlot(LocalTime.of(15, 40), 20, celine);
			new TimeSlot(LocalTime.of(16, 0), 20, celine);
			new TimeSlot(LocalTime.of(16, 20), 20, celine);
			new TimeSlot(LocalTime.of(16, 40), 20, null);//instance inexistante
		} catch (UserException | ProgrammerException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			new TimeSlot(LocalTime.of(16, 40), 20, celine);
			new TimeSlot(LocalTime.of(17, 0), 20, celine); // trop de TimeSlotx pour ce Doctor
		} catch (UserException | ProgrammerException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("__________________________ rendez-vous __________________________");
		//date de rendez-vous antérieur à la date du jour
		try {
			rdv = new Appointment(c2, (Patient)jean, LocalDate.now().minusDays(10L));
			System.out.println(rdv.toString());
		} catch (UserException | ProgrammerException e) {
			System.out.println(e.getMessage());
		}
		
		//pas d'instance de TimeSlot
		try {
			rdv = new Appointment(null, (Patient)jean, LocalDate.now().minusDays(10L));
			System.out.println(rdv.toString());
		} catch (UserException | ProgrammerException e) {
			System.out.println(e.getMessage());
		}

		//pas d'instance de patient
		try {
			rdv = new Appointment(c2,  null, LocalDate.now().minusDays(10L));
			System.out.println(rdv.toString());
		} catch (UserException | ProgrammerException e) {
			System.out.println(e.getMessage());
		}
	}
}
