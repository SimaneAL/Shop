package commandes;

import contrat.CDD;
import contrat.CDI;
import contrat.Contrat;
import contrat.Stage;
import magasins.Magasin;
import org.junit.Test;
import org.testng.annotations.AfterTest;
import personnes.Client;
import personnes.Employe;
import rayons.PS5;
import rayons.Produit;
import rayons.NintendoSwitch;

import static org.junit.jupiter.api.Assertions.*;


class CommandeTest {
    private Client unClient = new Client("test","test","test","test","test");
    private Contrat cdd = new CDD();
    private Contrat stage = new Stage();
    private Contrat cdi = new CDI();
    private Employe unEmployee = new Employe(cdd, "test1","test2","test2","test2","test2");
    private Magasin unMagazine = new Magasin("leagasin","adragasin");
    private Produit ps5 = new PS5();
    private Produit uneSwitch = new NintendoSwitch();
    Commande uneCommand = new Commande(unClient,unEmployee,unMagazine,ModePaiement.CB);


    @org.junit.jupiter.api.Test
    void calculerPrixTotal() {
        Commande uneCommand = new Commande(unClient,unEmployee,unMagazine,ModePaiement.CB);
        uneCommand.ajoutProduit(ps5,2);
        assertEquals(910.90 , uneCommand.getPrixTotal());
    }

    @Test

        // Ajoute une certaine quantité à un produit ou bien ajoute un nouveau produit dans la commande
    public void ajoutProduitQuantity() {
        Commande uneCommand = new Commande(unClient,unEmployee,unMagazine,ModePaiement.CB);
        uneCommand.ajoutProduit(ps5,2);
        assertEquals(1 , uneCommand.getProduits().size());

    }

    @AfterTest
        // Supprime une quantité d'un produit, et le produit si sa quantité atteint 0
    void suppProduitQuantity() {
        Commande uneCommand = new Commande(unClient,unEmployee,unMagazine,ModePaiement.CB);
        uneCommand.ajoutProduit(ps5,2); // 910.90 value
        uneCommand.ajoutProduit(uneSwitch,2); // 678.0 value
        uneCommand.suppProduit(uneSwitch,1); // - 339 value => 910.90 + 678 - 339 = 1249.9
        assertEquals(2 , uneCommand.getProduits().size());
        assertEquals(1249.9,uneCommand.getPrixTotal());

    }

    @Test
        // Supprime une quantité d'un produit, et le produit si sa quantité atteint 0
    void suppProduit() {
        Commande uneCommand = new Commande(unClient,unEmployee,unMagazine,ModePaiement.CB);
        uneCommand.ajoutProduit(ps5,2); // 910.90 value
        uneCommand.ajoutProduit(uneSwitch,2); // 678.0 value
        uneCommand.suppProduit(uneSwitch,2); // - 339 value => 910.90 + 678 - 339 = 1249.9
        assertEquals(1 , uneCommand.getProduits().size());
        assertEquals(910.90,uneCommand.getPrixTotal());

    }

}