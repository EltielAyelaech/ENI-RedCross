package fr.eni.ecole.redcross.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.eni.ecole.redcross.bo.Address;
import fr.eni.ecole.redcross.bo.Doctor;
import fr.eni.ecole.redcross.bo.GeneralistDoctor;
import fr.eni.ecole.redcross.bo.SpecialistDoctor;
import fr.eni.ecole.redcross.bo.Patient;
import fr.eni.ecole.redcross.bo.Person;

public class TestAdvanced {

	//instanciation des Addresss
	private static Address sh = new Address("ZAC du Moulin Neuf", 2, "B", "rue Benjamin Franklin", 44800, "Saint Herblain");
	private static Address nantes = new Address(null, 20, null, "rue de la Paix", 44000, "Nantes");
	private static Address brest = new Address(null, 22, null, "rue de la Mer", 29000, "Brest");
	private static Address nio = new Address(19, null, "avenue Léo Lagrange", 79000, "Niort");
	private static Address lr = new Address(null, 18, "B", "rue des Fleurs", 17000, "La Rochelle");
	//private static Address p = new Address(null, 1, null, "rue des Fraises", 75000, "Paris");
	
	//instanciation d'un Doctor generaliste
	private static Doctor melanie = new GeneralistDoctor("Malalaniche", "Mélanie", "02.28.03.17.28", sh);
	
	//instanciation des Doctors specialistes
	private static Doctor edmond = new SpecialistDoctor("Bosapin", "Edmond", "02.28.03.17.24", sh, "CARDIOLOGIE", 52);
	private static Doctor benoit = new SpecialistDoctor("De Cajou", "Benoit", "02.28.03.17.23", sh, "ANGIOLOGIE", 57);
	private static Doctor anne = new SpecialistDoctor("Aimone", "Anne", "02.28.03.17.26", sh, "STOMATOLOGIE", 55);
	private static Doctor sylvan = new SpecialistDoctor("Tourne", "Sylvan", "02.28.03.17.21", sh, "PEDIATRIE", 52);
	private static Doctor remy = new SpecialistDoctor("Sion", "Remy", "02.28.03.17.25", sh, "GYNECOLOGIE OBSTETRIQUE", 55);

	//instanciation des patients
	private static Person jean = new Patient("Dupond", "Jean", "0753428619",'M', 192112192020142l,
			LocalDate.of(1992, 11, 21), null, nio);
	private static Person paul = new Patient("Dupond", "Paul", "0753428619", 'M', 192112192020142l,
			LocalDate.of(1992, 11, 21), null, nantes);
	private static Person franck = new Patient("Duboulon", "Franck", "0753428619", 'M', 192112192020142l,
			LocalDate.of(1992, 11, 21), null, brest);
	private static Person adhemar = new Patient("Pamamobe", "Adhémar", "0753428619", 'M', 192112192020142l,
			LocalDate.of(1992, 11, 21), null, lr);

	
	public static void main(String[] args) {
		System.out.println("__________________________ Médecins géneralistes ______________________________");
		System.out.println(melanie);
		System.out.println("========= test comportements =======");
		melanie.examine();
		melanie.diagnose();
		melanie.orient();
		
		System.out.println("__________________________ Médecins spécialistes ______________________________");
		SpecialistDoctor edmondB = (SpecialistDoctor) edmond;
		edmondB.setSpecialty("CARDIOLOGIE");
		edmondB.setRates(52);
		System.out.println(edmondB);
		System.out.println("========= test comportements =======");
		edmond.examine();
		edmond.diagnose();
		edmond.orient();
		SpecialistDoctor benoitD = (SpecialistDoctor) benoit;
		benoitD.setSpecialty("ANGIOLOGIE");
		benoitD.setRates(57);
		System.out.println(benoitD);
		SpecialistDoctor anneA = (SpecialistDoctor) anne;
		anneA.setSpecialty("STOMATOLOGIE");
		anneA.setRates(55);
		System.out.println(anneA);
		SpecialistDoctor sylvanT = (SpecialistDoctor) sylvan;
		sylvanT.setSpecialty("PEDIATRIE");
		sylvanT.setRates(52);
		System.out.println(sylvanT);
		SpecialistDoctor remyS = (SpecialistDoctor) remy;
		remyS.setSpecialty("GYNECOLOGIE OBSTETRIQU");
		remyS.setRates(55);
		System.out.println(remyS);

		System.out.println("___ liste des Médecins spécialistes ____");
		List<SpecialistDoctor> liste = new ArrayList<SpecialistDoctor>();
		liste.add(edmondB);
		liste.add(benoitD);
		liste.add(anneA);
		liste.add(sylvanT);
		liste.add(remyS);
		
		System.out.println("====== affichage de la collection dans l'ordre d'insertion =====");
		for (SpecialistDoctor ms : liste) {
			System.out.print(liste.indexOf(ms)+" - "+ ms);
		}
		System.out.println();
		
		Collections.sort(liste, Person.comparatorFullnameAscending);
		System.out.println("====== affichage de la collection triee dans l'ordre croissant sur le nom et prenom =====");
		for (SpecialistDoctor ms : liste) {
			System.out.print(liste.indexOf(ms)+" - "+ ms);
		}
		System.out.println();
		
		Collections.sort(liste, Person.comparatorFullnameDescending);
		System.out.println("===== affichage de la collection triee dans l'ordre decroissant sur le nom et prenom =====");
		for (SpecialistDoctor ms : liste) {
			System.out.print(liste.indexOf(ms)+" - "+ ms);
		}
		System.out.println();


		System.out.println("__________________________ Patients ______________________________");
		List<Patient> patients = new ArrayList<Patient>();
		patients.add((Patient) adhemar);
		patients.add((Patient) paul);
		patients.add((Patient) jean);
		patients.add((Patient) franck);
		
		System.out.println("====== affichage de la collection dans l'ordre d'insertion =====");
		for (Patient p : patients) {
			System.out.print(patients.indexOf(p)+" - "+ p);
		}
		System.out.println();
		
		Collections.sort(patients, Person.comparatorFullnameAscending);
		System.out.println("====== affichage de la collection triee dans l'ordre croissant sur le nom et prenom =====");
		for (Patient p : patients) {
			System.out.print(patients.indexOf(p)+" - "+ p);
		}
		System.out.println();
		
		Collections.sort(patients, Person.comparatorFullnameDescending);
		System.out.println("===== affichage de la collection triee dans l'ordre decroissant sur le nom et prenom =====");
		for (Patient p : patients) {
			System.out.print(patients.indexOf(p)+" - "+ p);
		}
		System.out.println();
		
	}
}
