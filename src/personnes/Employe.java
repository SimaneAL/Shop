package personnes;

import contrat.Contrat;

public class Employe extends Personne{
	private Contrat contrat;
	private double gains = 0.0;

	public Employe( Contrat contrat, String nom, String prenom, String adresse, String dateNaissance, String codePostal) {
		super(nom, prenom, adresse, dateNaissance, codePostal);
		this.contrat = contrat;
	}

	public void setGains(double gains) {
		this.gains = gains;
	}

	public Contrat getContrat() {
		return contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat=contrat;
	}

	public double getGains() {
		return this.gains;
	}

	@Override
	public String toString() {
		return "	->Nom : " + this.getNom() + "\n	->Prenom : " + this.getPrenom() + "\n	->Adresse : " + getAdresse()
				+ "\n	->Contrat : " + getContrat() + "\n	->Ses gains : " + this.getGains();
	}
}
