package magasins;

import java.util.*;

import commandes.Commande;
import commandes.ModePaiement;
import personnes.Client;
import personnes.Employe;
import personnes.Personne;
import rayons.Produit;

public class Magasin {
	private String nom, adresse;
	private List<Personne> personnes;
	private List<Produit> produits;
	private int id;
	private static int incr;
	
	
	public Magasin(String nom, String adresse) {
		this.id = incr;
		incr++;
		this.nom = nom;
		this.adresse = adresse;
		this.personnes = new ArrayList<Personne>();
		this.produits = new ArrayList<Produit>();
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public List<Personne> getPersonnes() {
		return personnes;
	}


	public void setPersonnes(List<Personne> personnes) {
		this.personnes = personnes;
	}


	public List<Produit> getProduits() {
		return produits;
	}


	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	@Override
	public String toString() {
		return "Le magasin : " + nom + '\'' +
				", adresse='" + adresse + '\'' +
				", personnes=" + personnes +
				", produits=" + produits +
				'}';
	}


	public Produit quelProduit(String id){
		for (Produit  p : this.getProduits()) { //parcourir tous les produits du magasin afin de trouver le
			// produit choisi
			if(p.getId() == Integer.parseInt(id) || p.getNom().equals(id)){
				return p;
			}
		}
		return null;
	}

	
	

	public void demarrerJournee(){
		// deebut de la journee
		System.out.println("Bonjour! Bienvenue dans notre magasin \n Nos caissiers Simane, Loic, et Maxime vous aideront à faire vos course.");
		//choix aleatoire d un caissier
		Employe caissier;
		Random r = new Random();
		int choix = r.nextInt(3);

		if(choix == 0){
			caissier = new Employe("AIT LAHCEN", "Simane", "adrr", "02/12/2001", 92600);
		}
		else if(choix==1){
			caissier = new Employe("ETIENNE", "Loic", "trucc", "15/12/2001", 94130);
		}
		else{
			caissier = new Employe("BOUR", "Maxime", "ad", "05//02/2001", 93600);
		}
		System.out.println("Votre caissier associe est : " +caissier.getPrenom()+", " +caissier.getNom().toUpperCase());
		//creation de client
		
		Scanner sc = new Scanner(System.in);

		//infos personnelles
		System.out.println("Quel est votre prenom ?");
		String prenom = sc.next();

		
	

		String nom;
		System.out.println("Quel est votre nom ?");
		nom = sc.next();

		System.out.println("Quelle est votre adresse ?");
		String adresse = sc.next();

		System.out.println("Quel est votre code postal ?");
		int code = sc.nextInt();

		System.out.println("Quelle est votre adresse mail?");
		String dateNaiss =sc.next();

		//if(prenom!=null && nom!=null && adresse!=null && code > 0){
			Client client = new Client(nom, prenom, adresse, dateNaiss, code);
			client.setNom(nom.toUpperCase());
			Commande commande = new Commande(client, caissier, this, ModePaiement.espece);//espece par defaut

		//}

		
		

		
		

		
		System.out.println("1 : acheter un produit \n 2: supprimer une quantite d un produit " +
				"\n 3: supprimer totalement un produit \n 4: Afficher le prix total de votre commande et Exit");
		int choixUs = sc.nextInt();
		while(choixUs != 4){
			switch(choixUs){
				case 1 :
					System.out.println("Bonjour! " +client.getPrenom() +", " +client.getNom() + "Vous payez par quel mode de paiement ? \n 1.CB" +
							"2.cheque \n 3.espece");
					int choixUserInt= sc.nextInt();

					while(choixUserInt<1 || choixUserInt>3){
						System.out.println("erreur ! saissisez un mode de paiement,  \\n 1.CB\" +\n" +
								"\t\t\"2.cheque \\n 3.espece\"");
						choixUserInt= sc.nextInt();
					}
					if(choixUserInt==1){
						commande.setModePaiement(ModePaiement.CB);
					}
					if(choixUserInt==2){
						commande.setModePaiement(ModePaiement.cheque);
					}
					if(choixUserInt==3){
						commande.setModePaiement(ModePaiement.espece);
					}
					System.out.println("\n Vous voulez acheter quoi ? \n Le voila notre catalogue : \n"
							+this.produits +"Saisissez l'id ou le nom du produit");
					String nomProduit = sc.next();
					System.out.println("Vous en voulez combien ?");
					int qtt = sc.nextInt();

					commande.ajoutProduit(this.quelProduit(nomProduit), qtt);
					break;
				case 2 :
					System.out.println("\n Vous voulez supprimer quoi ? \n La voila votre commande : \n"
							+commande +"Saisissez l'id ou le nom du produit");
					String nomPr = sc.next();
					System.out.println("Vous voulez supprimer cmb?");
					qtt = sc.nextInt();
					commande.suppProduit(this.quelProduit(nomPr), qtt);
					break;

				case 3 :
					System.out.println("\n Vous voulez supprimer quoi ? \n La voila votre commande : \n"
							+commande +"Saisissez l'id ou le nom du produit");
					nomPr = sc.next();

					commande.suppProduitTotalr(this.quelProduit(nomPr));
					break;

				default :
					break;

			}
		}
		System.out.println("Votre prix total est : " +commande.getPrixTotal()+ "\n Au revoir! ");

	}

}
