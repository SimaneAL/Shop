package magasins;

import commandes.Commande;
import commandes.ModePaiement;
import contrat.CDD;
import contrat.CDI;
import contrat.Contrat;
import contrat.Stage;
import personnes.Client;
import personnes.Employe;
import personnes.Personne;
import rayons.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Magasin {
	private String nom, adresse;
	private ArrayList<Personne> personnes;
	private Map<Produit, Integer> produits;
	private int id;
	private static int incr;

	//les 3 types de contrat de ce magasin
	private static Contrat cdd;
	private static Contrat stage ;
	private static Contrat cdi ;

	//les principaux produits de notre magasin
	private Produit ps5, sweat, nintendoSwitch, livreJAVA, livreFX, livreSQL, livreGRAPHES;

	//construteur
	public Magasin(String nom, String adresse) {
		this.id = incr;
		incr++;
		this.nom = nom;
		this.adresse = adresse;
		this.personnes = new ArrayList<Personne>();
		this.produits = new HashMap<Produit, Integer>();
		cdd = new CDD();
		stage = new Stage();
		cdi = new CDI();
		this.ps5 = new PS5();
		this.sweat = new Sweat();
		this.nintendoSwitch = new NintendoSwitch();
		this.livreJAVA = new Livre("Idéal pour commencer avec Java comme premier langage !\n" +
				"\n" +
				"Grâce à ce livre, vous allez rapidement écrire rapidement vos premières \n" +
				" applets Java, sans pour autant devenir un gourou de la programmation objet. \n" +
				"Rassurez-vous, on ne vous assommera pas avec toutes les subtilités du langage Java, \n" +
				"mais vous posséderez rapidement les bases nécessaires pour utiliser la panoplie d'outils\n" +
				" du parfait programmeur Java.\n" +
				"Cette nouvelle édition a été entirement mise à jour avec les spécifications de la \n" +
				" dernière version du SDK Java. Intègre les nouveautés apportées par Java 8.");
		this.livreFX = new Livre("JavaFX est une plate-forme logicielle permettant de \n" +
				"créer et de fournir des applications de bureau,\n" +
				"ainsi que des applications Internet riches (RIA) pouvant fonctionner sur une grande variété de\n" +
				"périphériques. JavaFX est destiné à remplacer Swing en tant que bibliothèque graphique standard\n" +
				"pour Java SE.");
		this.livreSQL = new Livre("Ce nouveau livre de la collection  » Pour les Nuls pros » va vous donner \n" +
				" en quelque 400 pages toutes les connaissances qui vous permettront de maîtriser SQL et de construire \n" +
				"des requêtes fiables et puissantes.\n" +
				"SQL (Structured Query Language) est un langage qui permet de construire de puissantes bases de \n" +
				"données relationnelles. Vous apprendrez toutes les techniques pour concevoir et administrer une \n" +
				" base de données, et même à créer des bases de données Internet.");
		this.livreGRAPHES = new Livre("Les modèles et les algorithmes de graphes se sont imposés aujourd'hui \n" +
				"dans de nombreuses disciplines, aussi bien dans les sciences de base (physique, chimie, biologie, \n" +
				"ciences humaines, informatique théorique et algorithmique) que dans les sciences de l'ingénieur \n" +
				"(automatique, optimisation de systèmes, économie et recherche opérationnelle, analyse de données, \n" +
				"ingénierie des grands réseaux de communication de type internet, etc). Cette nouvelle édition est la \n" +
				"seule à offrir un panorama aussi complet de ces outils et de leurs plus récents développements.");
		this.ajouterDesEmployes();
		this.ajouterArticles();

	}

	//methode qui ajoute les employes dans la liste des personnes
	public void ajouterDesEmployes(){ //les membres de ce groupe de projet
		this.personnes.add(new Employe(cdd, "AIT LAHCEN", "Simane", "adrr", "02/12/2001", "92600"));
		this.personnes.add(new Employe(stage, "ETIENNE", "Loic", "trucc", "15/12/2001", "94130"));
		this.personnes.add(new Employe(cdi, "BOUR", "Maxime", "ad", "05//02/2001", "93600"));


	}

	//methode qui ectit toutes les infos d'un produit dans un fichier passe en param
	void ecrireDansUnFichier(Produit p, File file) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(file.getName());

		if(writer.checkError()){
			throw new FileNotFoundException(file.getName());
		}
		else{
			writer.println(p.toString());
		}
		writer.close();
	}

	//methode qui cree le fichier dans lequel on retrouve les details d un produit
	public void afficherDetailsProduit(Produit p) {
		String nom = p.getNom() +"_Details.txt";
		File file = new File("src//Details//" +nom);
		try {
			ecrireDansUnFichier(p, file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	//idem pour les details d une commande passee en param
	public void ticketDeCaisse(Commande commande, Client client) {

		File file = new File("src/Details/Ticket_de_Caisse.txt" );
		try {
			PrintWriter writer = new PrintWriter(file.getName());

			if(writer.checkError()){
				throw new FileNotFoundException(file.getName());
			}
			else{
				writer.println(commande.toString());
			}
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	//methode qui ajoute une quantite d un produit passe en param
	public void ajouterprod(Produit p, int quantite){
		if(p!= null){
			if(!this.produits.containsKey(p)){
				this.produits.put(p, quantite);
			}
			else {
				for (Map.Entry<Produit, Integer>  m : this.getProduits().entrySet()) {
					if(m.getKey().equals(p)){
						m.setValue(m.getValue() + quantite);
					}
				}
			}

		}
	}

	//methose qui ajoute tous les articles cres pour magasin dans la liste des produits
	public void ajouterArticles(){
		this.ajouterprod(ps5, 200);
		this.ajouterprod(sweat, 69);
		this.ajouterprod(nintendoSwitch, 100);
		this.ajouterprod(livreJAVA, 5);
	}

	//methode qui renvoie un produit en fonction de son id
	public Produit quelProduit(String id){
		for (Map.Entry<Produit, Integer> p : this.getProduits().entrySet()) { //parcourir tous les produits du magasin afin de trouver le
			// produit choisi
			if(p.getKey().getId() == Integer.parseInt(id) || p.getKey().getNom().equals(id)){
				return p.getKey();
			}
		}
		return null;
	}

	//methode qui choisi aleatoirement un caissier parmis les employes de ce magasin
	public Employe choixAleatoirCaissier(){
		Random r = new Random();
		int choix = r.nextInt(3);

		if(choix == 0){
			Employe simane = (Employe) this.getPersonnes().get(0);
			return simane;
		}
		else if(choix==1){
			Employe loic = (Employe) this.getPersonnes().get(1);
			return loic;//loic
		}
		else{
			Employe max = (Employe) this.getPersonnes().get(2);
			return max; //maxime
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
		Client client = new Client(nom.toUpperCase(), prenom, adresse, dateNaiss, dateNaiss);
		this.getPersonnes().add(client);


		return client;
	}


//Getters et les setters + toString()

	public Produit getPs5() {
		return ps5;
	}

	public Produit getSweat() {
		return sweat;
	}

	public Produit getNintendoSwitch() {
		return nintendoSwitch;
	}

	public Produit getLivreJAVA() {
		return livreJAVA;
	}

	public Produit getLivreFX() {
		return livreFX;
	}

	public Produit getLivreSQL() {
		return livreSQL;
	}

	public Produit getLivreGRAPHES() {
		return livreGRAPHES;
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

	public ArrayList<Personne> getPersonnes() {
		return personnes;
	}

	public void setPersonnes(ArrayList<Personne> personnes) {
		this.personnes = personnes;
	}

	public Map<Produit, Integer> getProduits() {
		return produits;
	}

	public void setProduits(Map<Produit, Integer> produits) {
		this.produits = produits;
	}

	@Override
	public String toString() {
		return  nom + "\n" +
				"-Adresse : " + adresse + "\n" ;
	}
}
