package fr.eni.quelmedecin.test;

import java.time.LocalDate;
import java.time.LocalTime;

import fr.eni.quelmedecin.bo.Adresse;
import fr.eni.quelmedecin.bo.Creneau;
import fr.eni.quelmedecin.bo.Medecin;
import fr.eni.quelmedecin.bo.MedecinGeneraliste;
import fr.eni.quelmedecin.bo.MedecinSpecialiste;
import fr.eni.quelmedecin.bo.Patient;
import fr.eni.quelmedecin.bo.Payer;
import fr.eni.quelmedecin.bo.Personne;
import fr.eni.quelmedecin.bo.Remboursement;
import fr.eni.quelmedecin.bo.RendezVous;
import fr.eni.quelmedecin.bo.Specialite;
import fr.eni.quelmedecin.exception.ProgrammeurException;
import fr.eni.quelmedecin.exception.UtilisateurException;

public class TestAvancé {

	public static void main(String[] args) {
		Adresse sh= null, nio=null, lr=null;
		Personne jean=null, adhemar=null;
		Creneau c1=null;
		RendezVous rdv= null;
		
		System.out.println("__________________________ Adresses ______________________________");
		//cas nominal
		try {
			sh = new Adresse("ZAC du Moulin Neuf", 2, "B", "rue Benjamin Franklin", 44800, "Saint Herblain");
			nio = new Adresse(19, null, "avenue Léo Lagrange", 79000, "Niort");
			lr = new Adresse(null, 18, "B", "rue des Fleurs", 17000, "La Rochelle");
		} catch (UtilisateurException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("__________________________ Patients ______________________________");
		//cas nominal
		try {
			jean = new Patient("Dupond", "Jean", "0753428619",'M', 1921121920201l, LocalDate.of(1992, 11, 21), null, nio);
			adhemar = new Patient("Pamamobe", "Adhémar", "0753428619", 'M', 1921121920201l, LocalDate.of(1992, 11, 21), null, lr);
		} catch (UtilisateurException | ProgrammeurException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("__________________________ Médecins géneralistes ______________________________");
		Medecin melanie = null;
		//cas nominal
		try {
			melanie = new MedecinGeneraliste("Malalaniche", "Mélanie", "0228031728", sh, Remboursement.TFCM1);
			c1 = new Creneau(LocalTime.of(9, 0), 15, melanie);
			System.out.println(melanie.toString());
			
		} catch (UtilisateurException | ProgrammeurException e) {
			System.out.println(e.getMessage());
		}
	
		System.out.println("__________________________ Rendez-Vous ___________________________");
		//cas nominal
		try {
			rdv = new RendezVous(c1, (Patient)adhemar, LocalDate.now().plusDays(10L));
			System.out.println(rdv.toString());
			if (c1.getMedecin() instanceof MedecinGeneraliste) {
				MedecinGeneraliste m = (MedecinGeneraliste)c1.getMedecin();
				Payer p = new Payer() {
				};
				p.resteACharge(m);
			}
		} catch (UtilisateurException | ProgrammeurException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("__________________________ Médecins spécialistes ______________________________");
		//test medecin sans specialité
		System.out.println("===== spécialite obligatoire ===== ");
		Medecin edmond;
		try {
			edmond = new MedecinSpecialiste("Bosapin", "Edmond", "0228031724", sh, null, 52, Remboursement.TVCM1);
			System.out.println(edmond);
		} catch (UtilisateurException | ProgrammeurException e) {
			System.out.println(e.getMessage());
		}
		
		//cas nominal
		System.out.println("==== cas nominal ====");
		MedecinSpecialiste celine=null;
		Creneau c2= null, c3=null;
		try {
			celine = new MedecinSpecialiste("OCENSEMAIME", "Céline", "0748159263", sh, Specialite.CARDIO, 52, Remboursement.TVCM2);
			System.out.println(celine);
			c2 = new Creneau(LocalTime.of(15, 20), 20, celine);

			edmond = new MedecinSpecialiste("Bosapin", "Edmond", "0228031724", sh, Specialite.OPHTALMO, 45, Remboursement.NCM2);
			System.out.println(edmond);
			c3=new Creneau(LocalTime.of(11, 0), 20, edmond);

		} catch (UtilisateurException | ProgrammeurException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("__________________________ rendez-vous __________________________");
		//cas nominal
		try {
			rdv = new RendezVous(c2, (Patient)jean, LocalDate.now().plusMonths(3L));
			System.out.println(rdv.toString());
			if (c2.getMedecin() instanceof MedecinSpecialiste) {
				MedecinSpecialiste m = (MedecinSpecialiste)c2.getMedecin();
				System.out.println("Specialité : "+m.getSpecialite().getLibelle()+" - "+m.getSpecialite().getSituationGeo());
				Payer p = new Payer() {
				};
				p.resteACharge(m);
			}
			System.out.println("************************************************************");
			rdv = new RendezVous(c3, (Patient)adhemar, LocalDate.now().plusMonths(3L));
			System.out.println(rdv.toString());
			if (c2.getMedecin() instanceof MedecinSpecialiste) {
				MedecinSpecialiste m = (MedecinSpecialiste)c3.getMedecin();
				System.out.println("Specialité : "+m.getSpecialite().getLibelle()+" - "+m.getSpecialite().getSituationGeo());
				Payer p = new Payer() {
				};
				p.resteACharge(m);
			}
			
} catch (UtilisateurException | ProgrammeurException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
