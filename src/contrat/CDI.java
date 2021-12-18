package contrat;

public class CDI implements Contrat {
	private final int pourcentageGainsDeProductivite = 15;
	private String nom;

	public CDI() {
		this.nom = "CDI";
	}

	public int pourcentageGainsDeProductivite() {
		return pourcentageGainsDeProductivite;
	}

	@Override
	public String toString() {
		return "CDI{" +
				"\n pourcentage de gains  : " + pourcentageGainsDeProductivite +"\n";

	}
}
