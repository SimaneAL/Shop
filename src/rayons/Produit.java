package rayons;

public  class Produit {
	//abstract
	private int id;
	private static int incr=1;
	private String nom;
	private double prixUnite;
	
	public Produit(String nom, double prixUnite) {
		super();
		this.nom = nom;
		this.prixUnite = prixUnite;
		this.id = this.incr;
		this.incr++;
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

	public void setPrixUnite(double prixUnite) {
		this.prixUnite = prixUnite;
	}

	@Override
	public String toString() {
		return "Produit [id=" + id + ", nom=" + nom + ", prixUnite=" + prixUnite + "]";
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
//
//	@Override
//	public abstract String toString();
}
