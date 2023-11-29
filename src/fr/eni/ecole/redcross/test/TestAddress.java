package fr.eni.ecole.redcross.test;

import fr.eni.ecole.redcross.bo.Address;

public class TestAddress {
    public static void main(String[] args) {
        System.out.println("__________________________ Addresss ______________________________");
		Address sh = new Address("ZAC du Moulin Neuf", 2, "B", "rue Benjamin Franklin", 44800, "Saint Herblain");
		Address nio = new Address(19, null, "avenue Léo Lagrange", 79000, "Niort");
		Address comp = new Address(4, null, "Rue des Glatiniers", 2100, "Saint-Quentin");

		sh.display();
		System.out.println("------------------------------------------------------------------");
		nio.display();
		System.out.println("------------------------------------------------------------------");
		comp.display();
    }
}
