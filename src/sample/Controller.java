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


    @FXML
    private Label labelnbrSWITCH;

    @FXML
    private Label labelnbrFX;

    @FXML
    private Label labelnbrSWEAT;

    @FXML
    private Label labelnbrJAVA;

    @FXML
    private Label labelnbrSQL;

    @FXML
    private Label labelnbrGRAPHE;


    @FXML
    private Label labelnbrps5;

    @FXML
    private Label labelMagasin;


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

        m.ajouterprod(p, 10);
        m.ajouterprod(p1, 5);
        m.ajouterprod(p2, 1);

    }

    @FXML
    void ajouterPS5(ActionEvent event) {
        this.labelnbrps5.setText(String.valueOf(Integer.parseInt(this.labelnbrps5.getText())+1));
    }

    @FXML
    void ajouterSweat(ActionEvent event) {
        this.labelnbrSWEAT.setText(String.valueOf(Integer.parseInt(this.labelnbrSWEAT.getText())+1));
    }

    @FXML
    void ajouterSwitch(ActionEvent event) {
        this.labelnbrSWITCH.setText(String.valueOf(Integer.parseInt(this.labelnbrSWITCH.getText())+1));
    }

    @FXML
    void ajouterJava(ActionEvent event) {
        this.labelnbrJAVA.setText(String.valueOf(Integer.parseInt(this.labelnbrJAVA.getText())+1));
    }

    @FXML
    void ajouterFX(ActionEvent event) {
        this.labelnbrFX.setText(String.valueOf(Integer.parseInt(this.labelnbrFX.getText())+1));

    }

    @FXML
    void ajouterSQL(ActionEvent event) {
        this.labelnbrSQL.setText(String.valueOf(Integer.parseInt(this.labelnbrSQL.getText())+1));

    }

    @FXML
    void ajouterGraphes(ActionEvent event) {
        this.labelnbrGRAPHE.setText(String.valueOf(Integer.parseInt(this.labelnbrGRAPHE.getText())+1));
    }


    @FXML
    void suppPS5(ActionEvent event) {

    }



    @FXML
    void suppSweat(ActionEvent event) {

    }

    @FXML
    void passerCommande(ActionEvent event) {

    }
}
