package fr.eni.ecole.redcross.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import fr.eni.ecole.redcross.bo.Address;
import fr.eni.ecole.redcross.bo.GeneralistDoctor;
import fr.eni.ecole.redcross.bo.SpecialistDoctor;
import fr.eni.ecole.redcross.bo.Person;

public class TestEssential {

	//instanciation des Addresss
	private static Address sh = new Address("ZAC du Moulin Neuf", 2, "B", "rue Benjamin Franklin", 44800, "Saint Herblain");
	
	//instanciation d'un Doctor generaliste
	private static Person melanie = new GeneralistDoctor("Malalaniche", "Mélanie", "02.28.03.17.28", sh);
	
	//instanciation des Doctors specialistes
	private static Person edmond = new SpecialistDoctor("Bosapin", "Edmond", "02.28.03.17.24", sh);
	private static Person benoit = new SpecialistDoctor("De Cajou", "Benoit", "02.28.03.17.23", sh);
	private static Person anne = new SpecialistDoctor("Aimone", "Anne", "02.28.03.17.26", sh);
	private static Person sylvan = new SpecialistDoctor("Tourne", "Sylvan", "02.28.03.17.21", sh);
	private static Person remy = new SpecialistDoctor("Sion", "Remy", "02.28.03.17.25", sh);

	
	public static void main(String[] args) {
		System.out.println("__________________________ Médecins géneralistes ______________________________");
		System.out.println(melanie);
		
		System.out.println("__________________________ Médecins spécialistes ______________________________");
		SpecialistDoctor edmondB = (SpecialistDoctor) edmond;
		edmondB.setSpecialty("CARDIOLOGIE");
		edmondB.setRates(52);
		System.out.println(edmondB);
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

		System.out.println("_________ trier la liste des Médecins spécialistes  ___________");
		List<SpecialistDoctor> liste = new ArrayList<SpecialistDoctor>();
		liste.add(edmondB);
		liste.add(benoitD);
		liste.add(anneA);
		liste.add(sylvanT);
		liste.add(remyS);
		
		System.out.println("======== affichage de la collection dans l'ordre d'insertion =======");
		for (SpecialistDoctor ms : liste) {
			System.out.print(liste.indexOf(ms)+" - "+ ms);
		}
		System.out.println();
		
		Collections.sort(liste);
		System.out.println("====== affichage de la collection triee dans l'ordre croissant des tarifs =====");
		for (SpecialistDoctor ms : liste) {
			System.out.print(liste.indexOf(ms)+" - "+ ms);
		}
		System.out.println();
		
		/* 
		 * Que faudrait-il rajouter afin de trier notre collection dans l'ordre decroissant des tarifs ?
		 */
		Collections.sort(liste, Comparator.reverseOrder());
		System.out.println("===== affichage de la collection triee dans l'ordre decroissant des tarifs =====");
		for (SpecialistDoctor ms : liste) {
			System.out.print(liste.indexOf(ms)+" - "+ ms);
		}
		System.out.println();

	}
}
