package personnes;

public class Personne {
	private String nom, prenom, adresse, dateNaissance;
	private String codePostal;
	
	
	public Personne(String nom, String prenom, String adresse, String dateNaissance, String codePostal) {
		try{
			this.nom = nom;
			this.prenom = prenom;
			this.adresse = adresse;
			this.dateNaissance = dateNaissance;
			this.codePostal = codePostal;

		} catch (Exception ignored){

		}
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getDateNaissance() {
		return dateNaissance;
	}


	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}


	public String getCodePostal() {
		return codePostal;
	}


	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}


	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", dateNaissance="
				+ dateNaissance + ", codePostal=" + codePostal + "]";
	}
	
	
}
