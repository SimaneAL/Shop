package contrat;

public class Alternance implements Contrat {
	//un caissier gagne une pourcentage du prixTotale d une commande en fonction du type de son contrat
	private final int pourcentageGainsDeProductivite = 10;
	private String nom;

	public Alternance(String nom) {
		this.nom = nom;
	}

	public int pourcentageGainsDeProductivite() {
		return pourcentageGainsDeProductivite;
	}

	@Override
	public String toString() {
		return "Alternance{" +
				"\n pourcentage de gains  : " + pourcentageGainsDeProductivite +"\n";
	}
}

