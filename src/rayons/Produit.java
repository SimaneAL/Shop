package rayons;

public  class Produit {
	//abstract
	private int id;
	private static int incr=1;
	private String nom;
	private double prixUnite;
	private String details;
	public Produit(String nom, double prixUnite) {

		this.nom = nom;
		this.prixUnite = prixUnite;
		this.id = incr;
		incr++;
	}

	public String getNom() {
		return nom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrixUnite() {
		return prixUnite;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public void setPrixUnite(double prixUnite) {
		this.prixUnite = prixUnite;
	}

	@Override
	public String toString() {
		return nom +
				"\n	->PrixUnite : " + prixUnite +
				"\n	->Details : " + details;
	}

	@Override
	 public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produit other = (Produit) obj;
		if (id != other.id)
			return false;
		return true;
	}


}
