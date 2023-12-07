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

public class TestAdvancedP7 {

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
			MedicalFileHandler.add(new MedicalFile(54, 172, "15/7", 94, 95, "probleme d'hypertension", "Ramipril 20mg (le matin au petit déjeuner)", LocalDate.of(2023, 1, 21), (Patient)sophie, melanie));
			MedicalFileHandler.add(new MedicalFile(54, 172, "15/7", 94, 95, "probleme d'hypertension", "Ramipril 20mg (le matin au petit déjeuner)", LocalDate.of(2023, 2, 11), (Patient)sophie, melanie));
			MedicalFileHandler.add(new MedicalFile(54, 172, "15/7", 95, 135, "probleme d'arythmie cardiaque", "Xarelto 20 mg (le soir au diner) - Bisoprolol 2.5mg (le matin au déjeuner)", LocalDate.of(2023, 3, 5), (Patient)sophie, celine));
			MedicalFileHandler.add(new MedicalFile(77, 170, "15/7", 94, 70, "probleme d'hypertension", "Perindropil 2mg (le matin au petit déjeuner)", LocalDate.of(2023, 3, 15), (Patient)sophie, edmond));

			MedicalFileHandler.add(new MedicalFile(54, 172, "15/7", 95, 135, "probleme d'arythmie cardiaque", "Xarelto 20 mg (le soir au diner) - Bisoprolol 2.5mg (le matin au déjeuner)", LocalDate.of(2023, 2, 12), (Patient)jean, celine));
			MedicalFileHandler.add(new MedicalFile(77, 170, "15/7", 94, 70, "probleme d'hypertension", "Perindropil 2mg (le matin au petit déjeuner)", LocalDate.of(2023, 2, 15), (Patient)adhemar, edmond));

			System.out.println("==============================================");
			System.out.println("=                  1ere PARTIE               =");
			System.out.println("==============================================");
			MedicalFileHandler.updateRates();
			MedicalFileHandler.displayList();


			System.out.println("==============================================");
			System.out.println("=                  2eme PARTIE               =");
			System.out.println("==============================================");
			MedicalFileHandler.addMap();
			MedicalFileHandler.displayMap();
			
		} catch (UserException | ProgrammerException e) {
			System.out.println(e.getMessage());
		}
	}
}
