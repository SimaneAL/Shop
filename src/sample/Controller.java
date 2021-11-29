package sample;

import commandes.Commande;
import commandes.ModePaiement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import magasins.Magasin;
import personnes.Client;
import personnes.Employe;
import rayons.Produit;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Label labelCaissier;

    @FXML
    private Label labelDateNaiss;

    @FXML
    private TextField codePostal;

    @FXML
    private Label labelDtaeCom;

    @FXML
    private TextField nom;

    @FXML
    private Label labelPrenom;

    @FXML
    private Label labelCaissiers;

    @FXML
    private Label labelModePai;

    @FXML
    private Label labelNom;

    @FXML
    private Label textInfo;

    @FXML
    private Label labelCodePostal;

    @FXML
    private TextField adresse;

    @FXML
    private Label labelNumCom;

    @FXML
    private TextField dateNaiss;

    @FXML
    private TextField prenom;

    @FXML
    private Label labelAdresse;

    @FXML
    private Label labelPrixTital;

    @FXML
    private RadioButton paiementEspece;

    @FXML
    private RadioButton paiementCheque;

    @FXML
    private RadioButton paiementCB;

    private Magasin m = new Magasin("Daphine Shop", "PLace du Marechal de Lattre de Tassigny, 75016 PARIS");


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("LEGOOOOO");
        //this.m.demarrerJournee();
    }
    @FXML
    void shopNow(ActionEvent event) {

        if(nom.getText()!= null && prenom.getText() != null &&  adresse.getText()!= null && codePostal.getText() !=null && dateNaiss.getText()!= null ){
            labelNom.setText(nom.getText().toUpperCase());
            labelPrenom.setText(prenom.getText());
            labelAdresse.setText(adresse.getText());
            labelCodePostal.setText(codePostal.getText());
            labelDateNaiss.setText(dateNaiss.getText());
        }
        Client client = new Client(labelNom.getText(), labelPrenom.getText(), labelAdresse.getText(), labelDateNaiss.getText(), labelCodePostal.getText());
        textInfo.setText("Bonjour ! " +labelPrenom.getText() +"\n Vous pouvez commencer votre \n shopping maintenant" +
                " dans l'onglet Shop");
        Commande commande = null;
        Employe caissier = m.choixAleatoirCaissier();
        if(this.paiementCheque.isSelected()) {
            commande = new Commande(client, caissier, m, ModePaiement.cheque);//espece par defaut

        }
        if(this.paiementCB.isSelected()) {
             commande = new Commande(client, caissier, m, ModePaiement.CB);//espece par defaut

        }
        if(this.paiementEspece.isSelected()) {
             commande = new Commande(client, caissier, m, ModePaiement.espece);//espece par defaut

        }
        textInfo.setText("Votre caissier associe est : \n " +caissier.getPrenom()+", " +caissier.getNom().toUpperCase());


        //cast le double en string
        if (commande != null && caissier!= null ) {
            this.labelCaissier.setText(caissier.getPrenom() +", " +caissier.getNom().toUpperCase());
            this.labelPrixTital.setText(String.valueOf(commande.getPrixTotal()));
            this.labelNumCom.setText(String.valueOf(commande.getId()));
            this.labelDtaeCom.setText(commande.getDateCommande());
            this.labelModePai.setText(commande.getModePaiement().toString());
        }
//produits
        Produit p, p1, p2;
        p = new Produit("ps5", 20);
        p1 = new Produit("switch", 45);
        p2 = new Produit("livre", 3);

        m.ajouterprod(p);
        m.ajouterprod(p1);
        m.ajouterprod(p2);

    }

}
