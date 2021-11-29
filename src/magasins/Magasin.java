package magasins;

import commandes.Commande;
import commandes.ModePaiement;
import personnes.Client;
import personnes.Employe;
import personnes.Personne;
import rayons.Produit;

import java.util.*;

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

	public void ajouterprod(Produit p){
		if(p!= null){
			this.produits.add(p);
		}
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
		for (Produit p : this.getProduits()) { //parcourir tous les produits du magasin afin de trouver le
			// produit choisi
			if(p.getId() == Integer.parseInt(id) || p.getNom().equals(id)){
				return p;
			}
		}
		return null;
	}

	public Employe choixAleatoirCaissier(){
		Random r = new Random();
		int choix = r.nextInt(3);

		if(choix == 0){
			return new Employe("AIT LAHCEN", "Simane", "adrr", "02/12/2001", "92600");
		}
		else if(choix==1){
			return new Employe("ETIENNE", "Loic", "trucc", "15/12/2001", "94130");
		}
		else{
			return new Employe("BOUR", "Maxime", "ad", "05//02/2001", "93600");
		}
	}

	//methode qui cree un client en fct des infos communiquees par le user
	public Client creationClient(){
		Scanner sc = new Scanner(System.in);
		//infos personnelles
		System.out.println("Quel est votre prenom ?");
		String prenom = sc.next();
		while(prenom == null){
			System.out.println("Erreu ! Quel est votre prenom ?");
			prenom = sc.next();
		}

		System.out.println("Quel est votre nom ?");
		String nom=sc.next();
		while(nom == null){
			System.out.println("Erreur ! Quel est votre nom ?");
			nom = sc.next();
		}

		System.out.println("Quelle est votre adresse ?");
		String adresse = sc.next();
		while(adresse == null){
			System.out.println("Erreur ! Quelle est votre adresse?");
			adresse = sc.next();
		}
		System.out.println("Quel est votre code postal ?");
		int code = 0;
		try {
			 code = sc.nextInt();
		}catch (InputMismatchException er){
			System.out.println("Erreur ! Quel est votre code postal ?");
			code = sc.nextInt();
		}

		System.out.println("Quelle est votre date de naissance?");
		String dateNaiss =sc.next();
		while(dateNaiss == null){
			System.out.println("Erreur ! Quelle est votre date de naissance?");
			dateNaiss = sc.next();
		}
		//if(prenom!=null && nom!=null && adresse!=null && code > 0){
		return new Client(nom.toUpperCase(), prenom, adresse, dateNaiss, dateNaiss);
	}

	public ModePaiement choixModePaiement(){

		System.out.println("Vous payez par quel mode de paiement ? \n 1 pour payer en CB \n 2 pour payer en cheque \n 3 pour payer en espece");
		Scanner sc = new Scanner(System.in);
		int choixUserInt= sc.nextInt();
		while(choixUserInt<1 || choixUserInt>3){
			System.out.println("erreur ! saissisez un mode de paiement,  \n 1 pour CB \n 2 pour cheque \n 3.  pour payer en espece\"");
			choixUserInt= sc.nextInt();
		}
		if(choixUserInt==1){
			return ModePaiement.CB;
		}
		if(choixUserInt==2){
			return ModePaiement.cheque;
		}
		if(choixUserInt==3){
			return ModePaiement.espece;
		}
		//cb par defaut
		return ModePaiement.CB;
	}


	public Produit acheter(){
		System.out.println("\n Vous voulez acheter quoi ? \n Le voila notre catalogue : \n"
				+this.produits +"Saisissez l'id ou le nom du produit");
		Scanner sc = new Scanner(System.in);
		String nomProduit = sc.next();

		return this.quelProduit(nomProduit);

	}




	public void demarrerJournee(){
		// deebut de la journee
		System.out.println("Bonjour! Bienvenue dans notre magasin \n Nos caissiers Simane, Loic, et Maxime vous aideront à faire vos course.");
		//choix aleatoire d un caissier
		Employe caissier;
		caissier = choixAleatoirCaissier();
		System.out.println("Votre caissier associe est : " +caissier.getPrenom()+", " +caissier.getNom().toUpperCase());
		//creation de client

		Scanner sc = new Scanner(System.in);
		Client client  = creationClient() ;
		Commande commande = new Commande(client, caissier, this, ModePaiement.espece);//espece par defaut

		//}





		Produit p, p1, p2;
		p = new Produit("ps5", 20);
		p1 = new Produit("switch", 45);
		p2 = new Produit("livre", 3);

		this.ajouterprod(p);
		this.ajouterprod(p1);
		this.ajouterprod(p2);


		System.out.println("1 : acheter un produit \n 2: supprimer une quantite d un produit " +
				"\n 3: supprimer totalement un produit \n 4: Afficher le prix total de votre commande et Exit");
		int choixUs = sc.nextInt();
		while(choixUs != 4){
			switch(choixUs){
				case 1 :
					//choix mode de paiement
					System.out.println("Bonjour! " +client.getPrenom() +", " +client.getNom() );
					commande.setModePaiement(this.choixModePaiement());


					System.out.println("\n Vous voulez acheter quoi ? \n Le voila notre catalogue : \n"
							+this.produits +"Saisissez l'id ou le nom du produit");
					String nomProduit = sc.next();
					//System.out.println("Vous en voulez combien ?");
					//int qtt = sc.nextInt();

					commande.ajoutProduit(this.acheter(), 1);
					break;
				case 2 :
					System.out.println("\n Vous voulez supprimer quoi ? \n La voila votre commande : \n"
							+commande +"Saisissez l'id ou le nom du produit");
					String nomPr = sc.next();
//					System.out.println("Vous voulez supprimer cmb?");
//					qtt = sc.nextInt();
					commande.suppProduit(this.quelProduit(nomPr),1 );
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
