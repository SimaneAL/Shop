package sample;

import commandes.Commande;
import commandes.ModePaiement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import magasins.Magasin;
import personnes.Client;
import personnes.Employe;
import rayons.NintendoSwitch;
import rayons.PS5;
import rayons.Produit;
import rayons.Sweat;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

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


    @FXML
    private Label textInfoShop;

    private Magasin m;
    private Commande commande = null;

    Produit ps5, sweat, Switch;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("LEGOOOOO");
        m = new Magasin("Daphine Shop", "PLace du Marechal de Lattre de Tassigny, 75016 PARIS");
        //this.m.demarrerJournee();
        textInfo.setText("Bonjour ! Saisissez vos informations personnelles avant de \n commencer et appuyez sur le boutton 'Shop now' ");

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

        textInfo.setText("Hola ! " +labelPrenom.getText() +"\n Vous pouvez commencer votre \n shopping maintenant" +
                " dans l'onglet Shop, \n Votre caissier associe est : \n " +caissier.getPrenom()+", " +caissier.getNom().toUpperCase());


        //cast le double en string
        if (commande != null && caissier!= null ) {
            this.labelCaissier.setText(caissier.getPrenom() +", " +caissier.getNom().toUpperCase());
            this.labelPrixTital.setText(String.valueOf(commande.getPrixTotal()));
            this.labelNumCom.setText(String.valueOf(commande.getId()));
            this.labelDtaeCom.setText(commande.getDateCommande());
            this.labelModePai.setText(commande.getModePaiement().toString());
            this.labelMagasin.setText(this.m.getNom());
        }
//produits
        ps5 = new PS5();
        sweat = new Sweat();
        Switch = new NintendoSwitch();

        m.ajouterprod(ps5, 10);
        m.ajouterprod(sweat, 5);
        m.ajouterprod(Switch, 1);

        this.textInfoShop.setText("Vous pouvez commencer par voir les\n" +
                                 " produits de notre magasin et pour plus \n" +
                                  " de details appuyez sur l'icone D pour \n" +
                                  "telecharger un fichier dans la racine \n" +
                                " du dossier Shop. \n" +
                                "Apres avoir lu la description de chaque \n" +
                                "article, vous pouvez desormais ajouter des \n" +
                                "articles dans votre panier ou supprimer \n" +
                                "quelques uns. \n");
        }

    @FXML
    void ajouterPS5(ActionEvent event) {
        this.labelnbrps5.setText(String.valueOf(Integer.parseInt(this.labelnbrps5.getText())+1));

        this.textInfoShop.setText("un produit ps5 a ete ajoute ! \n Si vous avez fini vos courses appuyez \n sur le boutton Shop now, \n et sinon continuez vos courses.");
    }

    @FXML
    void ajouterSweat(ActionEvent event) {
        this.labelnbrSWEAT.setText(String.valueOf(Integer.parseInt(this.labelnbrSWEAT.getText())+1));

        this.textInfoShop.setText("un produit sweat a ete ajoute !\n Si vous avez fini vos courses appuyez \nsur le boutton Shop now, \n et sinon continuez vos courses.");
    }

    @FXML
    void ajouterSwitch(ActionEvent event) {
        this.labelnbrSWITCH.setText(String.valueOf(Integer.parseInt(this.labelnbrSWITCH.getText())+1));

        this.textInfoShop.setText("un produit switch a ete ajoute ! \n Si vous avez fini vos courses appuyez \n sur le boutton Shop now, \n et sinon continuez vos courses.");
    }

    @FXML
    void ajouterJava(ActionEvent event) {
        this.labelnbrJAVA.setText(String.valueOf(Integer.parseInt(this.labelnbrJAVA.getText())+1));
        this.textInfoShop.setText("un produit livre Java a ete ajoute ! \n Si vous avez fini vos courses appuyez \n sur le boutton Shop now, \n et sinon continuez vos courses.");
    }

    @FXML
    void ajouterFX(ActionEvent event) {
        this.labelnbrFX.setText(String.valueOf(Integer.parseInt(this.labelnbrFX.getText())+1));
        this.textInfoShop.setText("un produit livre java FX a ete ajoute ! \n Si vous avez fini vos courses appuyez \n sur le boutton Shop now, \n et sinon continuez vos courses.");
    }

    @FXML
    void ajouterSQL(ActionEvent event) {
        this.labelnbrSQL.setText(String.valueOf(Integer.parseInt(this.labelnbrSQL.getText())+1));
        this.textInfoShop.setText("un produit livre SQL a ete ajoute ! \n Si vous avez fini vos courses appuyez \n sur le boutton Shop now, \n et sinon continuez vos courses.");
    }

    @FXML
    void ajouterGraphes(ActionEvent event) {
        this.labelnbrGRAPHE.setText(String.valueOf(Integer.parseInt(this.labelnbrGRAPHE.getText())+1));
        this.textInfoShop.setText("un produit livre graphe a ete ajoute ! \n Si vous avez fini vos courses appuyez \n sur le boutton Shop now, \n et sinon continuez vos courses.");
    }


    @FXML
    void suppPS5(ActionEvent event) {
        this.labelnbrps5.setText(String.valueOf(Integer.parseInt(this.labelnbrps5.getText())-1));
        this.textInfoShop.setText("un produit ps5 a ete supprime ! \n Si vous avez fini vos courses appuyez \n sur le boutton Shop now, \n et sinon continuez vos courses.");
    }



    @FXML
    void suppSweat(ActionEvent event) {
        this.labelnbrSWEAT.setText(String.valueOf(Integer.parseInt(this.labelnbrSWEAT.getText())-1));
        this.textInfoShop.setText("un produit sweat a ete supprime ! \n Si vous avez fini vos courses appuyez \n sur le boutton Shop now, \n et sinon continuez vos courses.");
    }


    @FXML
    void suppSwitch(ActionEvent event) {
        this.labelnbrSWITCH.setText(String.valueOf(Integer.parseInt(this.labelnbrSWITCH.getText())-1));
        this.textInfoShop.setText("un produit switch a ete supprime ! \n Si vous avez fini vos courses appuyez \n sur le boutton Shop now, \n et sinon continuez vos courses.");
    }

    @FXML
    void suppJava(ActionEvent event) {
        this.labelnbrJAVA.setText(String.valueOf(Integer.parseInt(this.labelnbrJAVA.getText())-1));
        this.textInfoShop.setText("un produit livre Java a ete supprime ! \n Si vous avez fini vos courses appuyez \n sur le boutton Shop now, \n et sinon continuez vos courses.");
    }


    @FXML
    void suppFX(ActionEvent event) {
        this.labelnbrFX.setText(String.valueOf(Integer.parseInt(this.labelnbrFX.getText())-1));
        this.textInfoShop.setText("un produit livre JavaFX a ete supprime ! \n Si vous avez fini vos courses appuyez \n sur le boutton Shop now, \n et sinon continuez vos courses.");
    }


    @FXML
    void suppSQL(ActionEvent event) {
        this.labelnbrSQL.setText(String.valueOf(Integer.parseInt(this.labelnbrSQL.getText())-1));
        this.textInfoShop.setText("un produit livre SQL a ete supprime ! \n Si vous avez fini vos courses appuyez \n sur le boutton Shop now, \n et sinon continuez vos courses.");
    }

    @FXML
    void suppGraphe(ActionEvent event) {
        this.labelnbrGRAPHE.setText(String.valueOf(Integer.parseInt(this.labelnbrGRAPHE.getText())-1));
        this.textInfoShop.setText("un produit livre Graphe a ete supprime ! \n Si vous avez fini vos courses appuyez \n sur le boutton Shop now, \n et sinon continuez vos courses.");
    }

//    public String readBuffer(String fileName) {
//        BufferedReader in = null;
//        String line;
//        int i = 0;
//        StringBuilder msg = new StringBuilder();
//
//        try {
//            in = new BufferedReader(new FileReader(fileName));
//
//            //le buffer lit ligne par ligne
//            while ((line = in.readLine()) != null) {
//                line.replaceAll(" ", "");
//                msg.append(line);
//                i++;
//            }
//            in.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return msg.toString();
//    }

//    @FXML
//    void choseFile(ActionEvent event){
//        FileChooser file = new FileChooser();
//        file.setTitle("choisissez un fichier");
//        File f = file.showOpenDialog(null);
//        this.textInfoShop.setText("Super ! Vous avez choisi votre fichier");
//        String msg = readBuffer(f.getPath());
//
//    }

    @FXML
    void afficherDetailsPs5(ActionEvent event){
        File file = new File("src\\Details\\PS5_Details.txt");
        try {
            ecrireDansUnFichier(this.ps5, file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    void ecrireDansUnFichier(Produit p, File file) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(file.getName());

        if(writer.checkError()){
            throw new FileNotFoundException(file.getName());
        }
        else{
            writer.println(p.toString());
        }
        writer.close();
    }

    @FXML
    void passerCommande(ActionEvent event) throws InterruptedException {

        this.commande.ajoutProduit(ps5, Integer.parseInt(this.labelnbrps5.getText()));
        this.commande.ajoutProduit(sweat, Integer.parseInt(this.labelnbrSWEAT.getText()));
        this.commande.ajoutProduit(Switch, Integer.parseInt(this.labelnbrSWITCH.getText()));
        this.labelPrixTital.setText(String.valueOf(this.commande.getPrixTotal()));

        this.labelNumCom.setText(String.valueOf(this.commande.getId()));
        this.labelnbrGRAPHE.setText(String.valueOf(0));
        this.labelnbrSQL.setText(String.valueOf(0));
        this.labelnbrFX.setText(String.valueOf(0));
        this.labelnbrJAVA.setText(String.valueOf(0));
        this.labelnbrSWITCH.setText(String.valueOf(0));
        this.labelnbrSWEAT.setText(String.valueOf(0));
        this.labelnbrps5.setText(String.valueOf(0));
        //wait(100);
//        TimeUnit.MINUTES.sleep(1);
//        System.exit(0);

        //creation fichier ticket

        this.textInfoShop.setText("Super ! Merci pour votre commande " +this.labelPrenom.getText() +"\n" +
                "vous avez un total de \" + this.commande.getPrixTotal() +\" a payer . \n" +
                "Vous pouvez desormais telecharger \n votre ticket de" +
                "caisse en appuyant sur le boutton Ticket." +
                "\n Vous pouvez desormais fermer cette fenetyre ! \n A  bientot!");
    }

    @FXML
    void afficherDetailsSweat(ActionEvent event) {
        File file = new File("src\\Details\\Sweat_Details.txt");
        try {
            ecrireDansUnFichier(this.sweat, file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void afficherDetailsSwitch(ActionEvent event) {
        File file = new File("src\\Details\\Switch_Details.txt");
        try {
            ecrireDansUnFichier(this.Switch, file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    @FXML
    void afficherDetailsJava(ActionEvent event) {
        File file = new File("src\\Details\\JAVA_Details.txt");
        //TODO
    }


    @FXML
    void afficherDetailsFX(ActionEvent event) {
        //TODO
    }


    @FXML
    void afficherDetailsSQL(ActionEvent event) {
        //TODO
    }


    @FXML
    void afficherDetailsGraphes(ActionEvent event) {
        //TODO
    }

    @FXML
    void ticketDeCaisse(ActionEvent event) {
        String nom = "Ticket_" +this.labelPrenom.getText() +".txt";
        File file = new File("src\\Details\\nom");
        try {
            PrintWriter writer = new PrintWriter(file.getName());

            if(writer.checkError()){
                throw new FileNotFoundException(file.getName());
            }
            else{
                writer.println(this.commande.toString());
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
