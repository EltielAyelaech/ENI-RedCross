package fr.eni.ecole.redcross.test;

import java.time.LocalDate;

import fr.eni.ecole.redcross.bo.GeneralistDoctor;
import fr.eni.ecole.redcross.bo.Patient;
import fr.eni.ecole.redcross.ctrl.MyMethod;

public class TestClasses {
    public static void main(String[] args) {
        MyMethod ctrl = MyMethod.getMyMethod();
		System.out.println("___________________________ Test téléphone Patients ________________________");
		Patient mac = new Patient("Vambuce", "mac'douglas", "0123456789", 'F', 287060244010154l,
				LocalDate.of(1987, 6, 2), "Allergie aux arachides");
		//mettre la 1ere lettre de chaque mot du prénom en majuscule
		mac.setFirstName(ctrl.capitalize(mac.getFirstName(), "[-' ]"));
		//formattage numero de telephone
		mac.setPhoneNumber(ctrl.formatPhoneNumber(mac.getPhoneNumber()));
		mac.display();System.out.println();

		
		Patient ines = new Patient("Perret", "inès", "0698745123", 'F', 245021067034521l, LocalDate.of(1945, 2, 10),
				null);
		//mettre la 1ere lettre de chaque mot du prénom en majuscule
		ines.setFirstName(ctrl.capitalize(ines.getFirstName(), "[-' ]"));
		//formattage numero de telephone
		ines.setPhoneNumber(ctrl.formatPhoneNumber(ines.getPhoneNumber()));
		ines.display();System.out.println();

		
		Patient sidney = new Patient("Pamamobe", "sidney-scott", "0753428619", 'M', 192112192020142l,
				LocalDate.of(1992, 11, 21), null);
		//mettre la 1ere lettre de chaque mot du prénom en majuscule
		sidney.setFirstName(ctrl.capitalize(sidney.getFirstName(), "[-' ]"));
		//formattage numero de telephone
		sidney.setPhoneNumber(ctrl.formatPhoneNumber(sidney.getPhoneNumber()));
		sidney.display();System.out.println();

		
		Patient jessie = new Patient("Watson", "jessie james", "01254266788", 'M', 287060244010154l,
				LocalDate.of(1975, 8, 17), "Allergie au lactose");
		//mettre la 1ere lettre de chaque mot du prénom en majuscule
		jessie.setFirstName(ctrl.capitalize(jessie.getFirstName(), "[-' ]"));
		//formattage numero de telephone
		jessie.setPhoneNumber(ctrl.formatPhoneNumber(jessie.getPhoneNumber()));
		jessie.display();System.out.println();
		
		System.out.println("___________________________ Test téléphone Médecins ________________________");
		GeneralistDoctor melanie = new GeneralistDoctor("Malalaniche", "Mélanie", "0228031728");
		//mettre la 1ere lettre de chaque mot du prénom en majuscule
		melanie.setFirstName(ctrl.capitalize(melanie.getFirstName(), "[-' ]"));
		//formattage numero de telephone
		melanie.setPhoneNumber(ctrl.formatPhoneNumber(melanie.getPhoneNumber()));
		melanie.display();System.out.println();

		
		GeneralistDoctor edmond = new GeneralistDoctor("Bosapin", "Edmond", "217181920");
		//mettre la 1ere lettre de chaque mot du prénom en majuscule
		edmond.setFirstName(ctrl.capitalize(edmond.getFirstName(), "[-' ]"));
		//formattage numero de telephone
		edmond.setPhoneNumber(ctrl.formatPhoneNumber(edmond.getPhoneNumber()));
		edmond.display();System.out.println();

		
		GeneralistDoctor vikie = new GeneralistDoctor("Madge", "vickie", "OO04050607");
		//mettre la 1ere lettre de chaque mot du prénom en majuscule
		vikie.setFirstName(ctrl.capitalize(vikie.getFirstName(), "[-' ]"));
		//formattage numero de telephone
		vikie.setPhoneNumber(ctrl.formatPhoneNumber(vikie.getPhoneNumber()));
		vikie.display();
		
    }
}
