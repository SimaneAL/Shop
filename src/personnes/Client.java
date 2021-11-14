package personnes;

public class Client extends Personne {

	public Client(String nom, String prenom, String adresse, String dateNaissance, int codePostal) {
		super(nom, prenom, adresse, dateNaissance, codePostal);
		
	}

	@Override
	public String toString() {
		return "Client [Nom=" + super.getNom() + ", Prenom=" + super.getPrenom() + ", Adresse=" + getAdresse()
				+ ", DateNaissance=" + getDateNaissance() + ", CodePostal=" + getCodePostal()
				+ "]";
	}
	
	

	
	
}
