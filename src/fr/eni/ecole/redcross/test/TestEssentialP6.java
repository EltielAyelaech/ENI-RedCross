package fr.eni.ecole.redcross.test;

import java.time.LocalDate;
import java.time.LocalTime;

import fr.eni.ecole.redcross.bo.Address;
import fr.eni.ecole.redcross.bo.TimeSlot;
import fr.eni.ecole.redcross.bo.Doctor;
import fr.eni.ecole.redcross.bo.SpecialistDoctor;
import fr.eni.ecole.redcross.bo.Patient;
import fr.eni.ecole.redcross.bo.Person;
import fr.eni.ecole.redcross.bo.Appointment;
import fr.eni.ecole.redcross.bo.Specialty;
import fr.eni.ecole.redcross.exception.ProgrammerException;
import fr.eni.ecole.redcross.exception.UserException;

public class TestEssentialP6 {

	public static void main(String[] args) throws ProgrammerException {
		Address sh= null, nio=null, lr=null;
		Appointment rdv= null;
		Person jean=null, adhemar=null;
		
		System.out.println("__________________________ Addresss ______________________________");
		//cas nominal
		try {
			sh = new Address("ZAC du Moulin Neuf", 2, "B", "rue Benjamin Franklin", 44800, "Saint Herblain");
			nio = new Address(19, null, "avenue Léo Lagrange", 79000, "Niort");
			lr = new Address(null, 18, "B", "rue des Fleurs", 17000, "La Rochelle");
		} catch (UserException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("__________________________ Patients ______________________________");
		//cas nominal
		try {
			jean = new Patient("Dupond", "Jean", "0753428619",'M', 1921121920201l, LocalDate.of(1992, 11, 21), null, nio);
			adhemar = new Patient("Pamamobe", "Adhémar", "0753428619", 'M', 1921121920201l, LocalDate.of(1992, 11, 21), null, lr);
		} catch (UserException | ProgrammerException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("__________________________ Médecins spécialistes ______________________________");
		//test medecin sans specialité
		System.out.println("===== spécialite obligatoire ===== ");
		Doctor edmond;
		try {
			edmond = new SpecialistDoctor("Bosapin", "Edmond", "0228031724", sh, null, 52);
			System.out.println(edmond);
		} catch (UserException | ProgrammerException e) {
			System.out.println(e.getMessage());
		}
		
		//cas nominal
		System.out.println("==== cas nominal ====");
		SpecialistDoctor celine=null;
		TimeSlot c2= null;
		try {
			celine = new SpecialistDoctor("OCENSEMAIME", "Céline", "0748159263", sh, Specialty.ORL, 52);
			System.out.println(celine);
			c2 = new TimeSlot(LocalTime.of(15, 20), 20, celine);
		} catch (UserException | ProgrammerException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("__________________________ rendez-vous __________________________");
		//cas nominal
		try {
			rdv = new Appointment(c2, (Patient)jean, LocalDate.now().plusMonths(3L));
			System.out.println(rdv.toString());
			SpecialistDoctor m = (SpecialistDoctor)c2.getDoctor();
			System.out.println("Specialité : "+m.getSpecialty());
		} catch (UserException | ProgrammerException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
