package commandes;

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
	private String dateCommande;
	private ModePaiement modePaiement;
	private Map<Produit, Integer> produits;
	
	
	
	public Commande(Client client, Employe employe, Magasin magasin, String dateCommande, ModePaiement modePaiement) {
		super();
		this.client = client;
		this.employe = employe;
		this.magasin = magasin;
		this.dateCommande = dateCommande;
		this.modePaiement = modePaiement;
		this.produits = new HashMap<Produit, Integer>();
	}

	
//calculer prix total
	public void calculerPrixTotal() {
		double prixT = 0;
		for (Map.Entry<Produit, Integer>  m : this.getProduits().entrySet()) {
			
	            prixT = prixT+  ((Produit) m.getKey()).getPrixUnite() *  (int) m.getValue() ;
	           //System.out.println((int) m.getValue());
	           //System.out.println("hum" +this.getPrixTotal() + (int) ((Produit) m.getKey()).getPrixUnite() * (int) m.getValue() );
		}
		this.setPrixTotal(prixT);
	}
	
//ajouter des produits + modification de prix total
	public void ajoutProduit(Produit p, int quantite) {
		this.produits.put(p, quantite);
		this.calculerPrixTotal();
	}
	
//supp des produits + modification de prix total	
	public void suppProduit(Produit p, int quantite) {
		for (Map.Entry<Produit, Integer> m : this.getProduits().entrySet()) {
			if(m.getKey().equals(p)){
				if(quantite <= (int) m.getValue() ) {
					//System.out.println((int) m.getValue());
					m.setValue((int) m.getValue() - quantite);
				}
				else {
					System.out.println("Le nombre de produits choisi est n�gatif ou sup�rieur au stock");
				}
			}
			
        }
		
		this.calculerPrixTotal();
	}

//supp des produits + modification de prix total	
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
		return "Commande [id=" + id + ", client=" + client + ", employe=" + employe + ", magasin=" + magasin
				+ ", prixTotal=" + prixTotal + ", dateCommande=" + dateCommande + ", modePaiement=" + modePaiement
				+ ", produits=" + produits + "]";
	}

//	@Override
//	public String toString() {
//		return "Commande [id=" + id + ", client=" + client + ", employe=" + employe + ", magasin=" + magasin
//				+ ", prixTotal=" + prixTotal + ", dateCommande=" + dateCommande + ", modePaiement=" + modePaiement
//				+ "]";
//	}
	
	
}
