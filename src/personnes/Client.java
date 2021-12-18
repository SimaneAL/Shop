package personnes;

public class Client extends Personne {

	public Client(String nom, String prenom, String adresse, String dateNaissance, String codePostal) {
		super(nom, prenom, adresse, dateNaissance, codePostal);

	}
	@Override
	public String toString() {
			return "	->Nom : " + this.getNom().toUpperCase() + "\n	->Prenom : " + this.getPrenom() + "\n	->Adresse : " + getAdresse()
				+ "\n	->DateNaissance : " + getDateNaissance() + "\n	->CodePostal : " + getCodePostal();
	}





}
