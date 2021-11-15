package commandes;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import magasins.Magasin;
import personnes.Client;
import personnes.Employe;
import rayons.Produit;

public class Commande {

	private int id;
	private static int incr=1;
	private Client client;
	private Employe employe;
	private Magasin magasin;
	private double prixTotal = 0.0;
	private Date date;
	private String dateCommande;
	private ModePaiement modePaiement;
	private Map<Produit, Integer> produits;
	
	
	
	public Commande(Client client, Employe employe, Magasin magasin, ModePaiement modePaiement) {
		this.id = incr;
		incr++;
		this.client = client;
		this.employe = employe;//
		this.magasin = magasin;
		this.dateCommande = this.date.toString();
		this.modePaiement = modePaiement;//CB, cheque, espece....
		this.produits = new HashMap<Produit, Integer>(); //cle => le produit
				//valeur => la quantite de ce produit dans le magasin
	}

	public Commande(Client client, Employe employe, Magasin magasin) {
		this.id = incr;
		incr++;
		this.client = client;
		this.employe = employe;//
		this.magasin = magasin;
		this.dateCommande = this.date.toString();
		this.produits = new HashMap<Produit, Integer>(); //cle => le produit
		//valeur => la quantite de ce produit dans le magasin
	}
	
//calculer prix total de la compmande courante
	public void calculerPrixTotal() {
		double prixT = 0;
		for (Map.Entry<Produit, Integer>  m : this.getProduits().entrySet()) { //parcourir tous les produits du magasin afin de calculer le prix (produit qt et prix unite)
	            prixT = prixT+  ((Produit) m.getKey()).getPrixUnite() *  (int) m.getValue() ; // somme (prixUnite * quantite) de tous les produits existants = prix total
	           //System.out.println((int) m.getValue());
	           //System.out.println("hum" +this.getPrixTotal() + (int) ((Produit) m.getKey()).getPrixUnite() * (int) m.getValue() );
		}
		this.setPrixTotal(prixT);//modifer l'attribur prixTotal de la classe commande
	}
	
//ajouter des produits + modification de prix total
	public void ajoutProduit(Produit p, int quantite) {

		if(quantite <= 0 ){//si la qtt choisie est négative on insere le mm prosuit or avec une qtt postive
			System.out.println("Impossible, car la quantite choisie est negative !");
			this.ajoutProduit(p, -quantite);//on prend l'opposé
		}
		else{//verif si le produit existe deja dans la liste des prosuits ou pas
			if(this.produits.containsKey(p)){//s il existe deja on augmente le stock
				for (Map.Entry<Produit, Integer> m : this.getProduits().entrySet()) {
					if(m.getKey().equals(p)){
						m.setValue(m.getValue()+quantite);
					}

				}
			}
			else{//sinon on l ajoute dans la liste
				this.produits.put(p, quantite);
			}
		}
		this.calculerPrixTotal(); //ajout d'un/des produit(s) change le prix total automatiquement
	}
	
//supp des unites de produits + modification de prix total
	public void suppProduit(Produit p, int quantite) {
		for (Map.Entry<Produit, Integer> m : this.getProduits().entrySet()) {
			if(m.getKey().equals(p)){
				if(quantite <= (int) m.getValue() ) {
					//System.out.println((int) m.getValue());
					m.setValue((int) m.getValue() - quantite);
				}
				else {
					System.out.println("Le nombre de produits choisi est negatif ou superieur au stock");
				}
			}
			
        }
		
		this.calculerPrixTotal();
	}

//supp des produits + modification de prix total
//cette méthode supprime totalement un produt choisi
	public void suppProduitTotalr(Produit p) {
		this.produits.remove(p);
		this.calculerPrixTotal();
	}
	
	public Map<Produit, Integer> getProduits() {
		return produits;
	}

	public void setProduits(Map<Produit, Integer> produits) {
		this.produits = produits;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public Magasin getMagasin() {
		return magasin;
	}

	public void setMagasin(Magasin magasin) {
		this.magasin = magasin;
	}

	public double getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(double prixTotal) {
		this.prixTotal = prixTotal;
	}

	public String getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(String dateCommande) {
		this.dateCommande = dateCommande;
	}

	public ModePaiement getModePaiement() {
		return modePaiement;
	}

	public void setModePaiement(ModePaiement modePaiement) {
		this.modePaiement = modePaiement;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "la Commande numero : " + id +"\n" + "Client : " + client +"\n" + "Employe : " + employe +"\n" + "Magasin : " + magasin
				+"\n" + "Le prixTotal est de " + prixTotal +"euros \n" + "La date de commande est le : " + dateCommande +"\n" + "Le mode de paiement : " + modePaiement
				+"\n" + "L'ensemble de produits de cette commandes est : " + produits + "]";
	}


	
	
}
