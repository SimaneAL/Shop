package contrat;

public class CDD implements Contrat  {
	//un caissier gagne une pourcentage du prixTotale d une commande en fonction du type de son contrat

	private final int pourcentageGainsDeProductivite = 20;
	private String nom;

	public CDD() {
		this.nom = "CDD";
	}

	public int pourcentageGainsDeProductivite() {
		return pourcentageGainsDeProductivite;
	}

	@Override
	public String toString() {
		return "CDD{" +
				"\n pourcentage de gains  : " + pourcentageGainsDeProductivite +"\n";
	}
}
