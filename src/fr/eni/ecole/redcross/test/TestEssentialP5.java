package fr.eni.ecole.redcross.test;

import java.time.LocalDate;

import fr.eni.ecole.redcross.bo.Address;
import fr.eni.ecole.redcross.bo.Doctor;
import fr.eni.ecole.redcross.bo.GeneralistDoctor;
import fr.eni.ecole.redcross.bo.SpecialistDoctor;
import fr.eni.ecole.redcross.bo.Patient;
import fr.eni.ecole.redcross.bo.Person;
import fr.eni.ecole.redcross.exception.ProgrammerException;
import fr.eni.ecole.redcross.exception.UserException;

public class TestEssentialP5 {

	public static void main(String[] args) throws ProgrammerException {
		
		System.out.println("__________________________ Adresses ______________________________");
		//test numero de voie : negatif
		Address sh= null;
		try {
			sh = new Address("ZAC du Moulin Neuf", -10, "B", "rue Benjamin Franklin", 44800, "Saint Herblain");
		} catch (UserException e) {
			System.out.println(e.getMessage());
		}
		
		//test nom de la rue : null
		Address nantes= null;
		try {
			nantes = new Address(null, 20, null, null, 44000, "Nantes");
		} catch (UserException e) {
			System.out.println(e.getMessage());
		}
		
		//test nom de la rue : non renseigné
		try {
			nantes = new Address(null, 20, null, "", 44000, "Nantes");
		} catch (UserException e) {
			System.out.println(e.getMessage());
		}
		
		//test nom de la ville : null
		Address brest= null;
		try {
			brest = new Address(null, 22, null, "rue de la Mer", 29000, null);
		} catch (UserException e) {
			System.out.println(e.getMessage());
		}

		//test nom de la ville : non renseigné
		try {
			brest = new Address(null, 22, null, "rue de la Mer", 29000, "");
		} catch (UserException e) {
			System.out.println(e.getMessage());
		}

		//test code postal : inférieur à 1000
		Address nio= null;
		try {
			nio = new Address(19, null, "avenue Léo Lagrange", 999, "Niort");
		} catch (UserException e) {
			System.out.println(e.getMessage());
		}
		
		//test code postal : supérieur à 99999
		Address lr= null;
		try {
			lr = new Address(null, 18, "B", "rue des Fleurs", 100000, "La Rochelle");
		} catch (UserException e) {
			System.out.println(e.getMessage());
		}
		

		//cas nominal
		try {
			sh = new Address("ZAC du Moulin Neuf", -10, "B", "rue Benjamin Franklin", 44800, "Saint Herblain");
			nantes = new Address(null, 20, null, "rue de la Paix", 44000, "Nantes");
			brest = new Address(null, 22, null, "rue de la Mer", 29000, "Brest");
			nio = new Address(19, null, "avenue Léo Lagrange", 79000, "Niort");
			lr = new Address(null, 18, "B", "rue des Fleurs", 17000, "La Rochelle");
		} catch (UserException e) {
			System.out.println(e.getMessage());
		}

		
		
		System.out.println("__________________________ Patients ______________________________");
		
		//test sexe : different de 'F' et 'M'
		try {
			Person jean = new Patient("Dupond", "Jean", "0753428619",'G', 1921121920201l, LocalDate.of(1992, 11, 21), null, nio);
		} catch (UserException e) {
			System.out.println(e.getMessage());
		}
		
		//test numsecu : different de 13 caractères
		try {
			Person paul = new Patient("Dupond", "Paul", "0753428619", 'M', 19211219202014l, LocalDate.of(1992, 11, 21), null, nantes);
		} catch (UserException e) {
			System.out.println(e.getMessage());
		}
		
		//test sexe : date de naissance non renseignée
		try {
			Person franck = new Patient("Duboulon", "Franck", "0753428619", 'M', 1921121920201l, null, null, brest);
		} catch (UserException e) {
			System.out.println(e.getMessage());
		}
		
		//cas nominal
		try {
			Person jean = new Patient("Dupond", "Jean", "0753428619",'M', 1921121920201l, LocalDate.of(1992, 11, 21), null, nio);
			Person paul = new Patient("Dupond", "Paul", "0753428619", 'M', 1921121920201l, LocalDate.of(1992, 11, 21), null, nantes);
			Person franck = new Patient("Duboulon", "Franck", "0753428619", 'M', 1921121920201l, LocalDate.of(1992, 11, 21), null, brest);
			Person adhemar = new Patient("Pamamobe", "Adhémar", "0753428619", 'M', 1921121920201l, LocalDate.of(1992, 11, 21), null, lr);
		} catch (UserException e) {
			System.out.println(e.getMessage());
		}

		
		
		System.out.println("__________________________ Médecins géneralistes ______________________________");
		//instanciation d'un Doctor generaliste avec erreur
		Doctor melanie= null;
		try {
			melanie = new GeneralistDoctor("", "Mélanie", "0228031728", sh);
		} catch (UserException e) {
			System.out.println(e.getMessage());
		}
		
		//cas nominal
		try {
			melanie = new GeneralistDoctor("Malalaniche", "Mélanie", "0228031728", sh);
		} catch (UserException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("__________________________ Médecins spécialistes ______________________________");
		//instanciation des Doctors specialistes avec erreur
		Doctor edmond;
		try {
			edmond = new SpecialistDoctor("", "Edmond", "0228031724", sh, "CARDIOLOGIE", 52);
		} catch (UserException e) {
			System.out.println(e.getMessage());
		}
		
		//test spécialité : null
		Doctor benoit;
		try {
			benoit = new SpecialistDoctor("De Cajou", "Benoit", "0228031723", sh, null, 57);
		} catch (UserException e) {
			System.out.println(e.getMessage());
		}

		//test spécialité : non renseignée
		try {
			benoit = new SpecialistDoctor("De Cajou", "Benoit", "0228031723", sh, "", 57);
		} catch (UserException e) {
			System.out.println(e.getMessage());
		}

		//test tarif superieur au tarif du Doctor generaliste
		Doctor anne;
		try {
			anne = new SpecialistDoctor("Aimone", "Anne", "0228031726", sh, "STOMATOLOGIE", 20);
		} catch (UserException e) {
			System.out.println(e.getMessage());
		}
		
		//cas nominal
		try {
			edmond = new SpecialistDoctor("Bosapin", "Edmond", "0228031724", sh, "CARDIOLOGIE", 52);
			benoit = new SpecialistDoctor("De Cajou", "Benoit", "0228031723", sh, "ANGIOLOGIE", 57);
			anne = new SpecialistDoctor("Aimone", "Anne", "0228031726", sh, "STOMATOLOGIE", 55);
			Doctor sylvan = new SpecialistDoctor("Tourne", "Sylvan", "0228031721", sh, "PEDIATRIE", 52);
			Doctor remy = new SpecialistDoctor("Sion", "Remy", "0228031725", sh, "GYNECOLOGIE OBSTETRIQUE", 55);
		} catch (UserException e) {
			System.out.println(e.getMessage());
		}
		

	}
}
