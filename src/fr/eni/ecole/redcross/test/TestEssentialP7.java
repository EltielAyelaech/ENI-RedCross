package fr.eni.ecole.redcross.test;

import java.time.LocalDate;

import fr.eni.ecole.redcross.bo.Address;
import fr.eni.ecole.redcross.bo.MedicalFile;
import fr.eni.ecole.redcross.bo.MedicalFileHandler;
import fr.eni.ecole.redcross.bo.Doctor;
import fr.eni.ecole.redcross.bo.GeneralistDoctor;
import fr.eni.ecole.redcross.bo.SpecialistDoctor;
import fr.eni.ecole.redcross.bo.Patient;
import fr.eni.ecole.redcross.bo.Person;
import fr.eni.ecole.redcross.bo.Reimbursment;
import fr.eni.ecole.redcross.bo.Specialty;
import fr.eni.ecole.redcross.exception.ProgrammerException;
import fr.eni.ecole.redcross.exception.UserException;

public class TestEssentialP7 {

	public static void main(String[] args) {
		Person sophie= null, jean=null, adhemar=null;
		Doctor melanie= null, edmond=null, celine=null;
		
		try {
			System.out.println("__________________________ Patients ______________________________");
			jean = new Patient("Dupond", "Jean", "0753428619",'M', 1921121920201l, LocalDate.of(1992, 11, 21), null, new Address(19, null, "avenue Léo Lagrange", 79000, "Niort"));
			adhemar = new Patient("Pamamobe", "Adhémar", "0753428619", 'M', 1950661517002l, LocalDate.of(1995, 06, 10), null, new Address(null, 18, "B", "rue des Fleurs", 17000, "La Rochelle"));
			sophie = new Patient("Durant", "Sophie", "0751322412", 'F', 1041078217038l, LocalDate.of(2004, 10, 21), null, new Address(215, null, "avenue de Paris", 79000, "Niort"));

			System.out.println("__________________________ Médecins géneralistes ______________________________");
			melanie = new GeneralistDoctor("Malalaniche", "Mélanie", "0228031728", new Address("ZAC du Moulin Neuf", 2, "B", "rue Benjamin Franklin", 44800, "Saint Herblain"));
			melanie.setReimbursment(Reimbursment.TFCM1);
		
			System.out.println("__________________________ Médecins spécialistes ______________________________");
			edmond = new SpecialistDoctor("Bosapin", "Edmond", "0228031724", new Address("ZAC du Moulin Neuf", 2, "B", "rue Benjamin Franklin", 44800, "Saint Herblain"), Specialty.ANGIO, 90);
			edmond.setReimbursment(Reimbursment.TVCM2);
			celine = new SpecialistDoctor("OCENSEMAIME", "Céline", "0228031721", new Address("ZAC du Moulin Neuf", 2, "B", "rue Benjamin Franklin", 44800, "Saint Herblain"), Specialty.CARDIO, 85);
			celine.setReimbursment(Reimbursment.TVCM2);
			
		
			System.out.println("__________________________ Collection de type ArrayList des données de type MedicalFile ______________________________");
			MedicalFileHandler.add(new MedicalFile(78, 178, "10/7", 95, 135, "probleme d'arythmie cardiaque", "Xarelto 20 mg (le soir au diner) - Bisoprolol 2.5mg (le matin au déjeuner)", LocalDate.of(2023, 3, 5), (Patient)jean, celine));
			MedicalFileHandler.add(new MedicalFile(54, 172, "14/7", 94, 65, "probleme d'hypertension", "Perindropil 2mg (le matin au petit déjeuner) - Pantoprazole 20mg (le soir pendant le repas)", LocalDate.of(2023, 2, 17), (Patient)sophie, melanie));
			MedicalFileHandler.add(new MedicalFile(77, 170, "15/7", 94, 70, "probleme d'hypertension", "Perindropil 2mg (le matin au petit déjeuner)", LocalDate.of(2023, 2, 25), (Patient)adhemar, edmond));

			//edition du fichier
			MedicalFileHandler.displayList();
			
		} catch (UserException | ProgrammerException e) {
			System.out.println(e.getMessage());
		}
	}
}
