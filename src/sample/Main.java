package sample;

import magasins.Magasin;


public class Main {

	public static void main(String[] args) {
//
//		Client c1 = new Client("AIT LAHCEN", "Simane", "adrr", "02/12/2001", 92600);
//		Client c2 = new Client("BOUR", "Maxime", "ad", "05//02/2001", 93600);
//		Employe e = new Employe("ETIENNE", "Loic", "trucc", "15/12/2001", 94130);
//		Magasin m = new Magasin("Micromania", "3 rue");
//
//		Commande c = new Commande(c1, e, m,  ModePaiement.CB);
//		Produit p, p1, p2;
//		p = new Produit("ps5", 20);
//		p1 = new Produit("switch", 45);
//		p2 = new Produit("livre", 3);
//
//		//ajout
//		c.ajoutProduit(p, 1);
//		c.ajoutProduit(p1, 7);
//		c.ajoutProduit(p2, 5);
//
//		System.out.println(c.toString());
//		//c.calculerPrixTotal();
//		c.suppProduit(p2, 3);
//		System.out.println("vous avez supprime 3 livres !");
//		System.out.println("***************************************************************************");
//		System.out.println(c.toString());
//		c.suppProduitTotalr(p2);//supprime totalement tout le stock du prosuit p2
//		c.ajoutProduit(p, 1);//augmente le stock
//		System.out.println("***************************************************************************");
//		System.out.println(c.toString());
//
//
//


		//decommentez la ligne 48 pour lancer


		Magasin m1 = new Magasin("Micromania", "3 rue");

		m1.demarrerJournee();


	}

}