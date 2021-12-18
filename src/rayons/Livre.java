package rayons;

public class Livre extends Produit {

    public Livre(String details) {
        super("livre", 35);
        super.setDetails(details);
    }
}
