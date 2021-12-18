package contrat;

public class Stage implements Contrat {
	//un caissier gagne une pourcentage du prixTotale d une commande en fonction du type de son contrat

	private final int pourcentageGainsDeProductivite = 5;
	private String nom;

	public Stage() {
		this.nom ="Stage";
	}

	public int pourcentageGainsDeProductivite() {
		return pourcentageGainsDeProductivite;
	}

	@Override
	public String toString() {
		return "Stage : " +
				"\n pourcentage de gains  : " + pourcentageGainsDeProductivite +"\n";
	}
}
