package magasins;

import java.util.ArrayList;
import java.util.List;
import personnes.Personne;
import rayons.Produit;

public class Magasin {
	private String nom, adresse;
	private List<Personne> personnes;
	private List<Produit> produits;
	
	
	public Magasin(String nom, String adresse) {
		super();
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
	
	
	
}
