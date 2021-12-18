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
import personnes.Personne;

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
    private Label textInfoTicket;

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

    @FXML
    private Label salaireSimane;

    @FXML
    private Label salaireLoic;

    @FXML
    private Label salaireMaxime;


    private Magasin m;
    private Commande commande = null;
    private Personne caissier, client;


    @Override
    public void initialize(URL location, ResourceBundle resources) { //initialiser le programme
        System.out.println("LEZGOOO");
        m = new Magasin("Daphine Shop", "PLace du Marechal de Lattre de Tassigny, 75016 PARIS");
        textInfo.setText("Bonjour ! Saisissez vos informations personnelles avant de \n commencer et appuyez sur le boutton 'Shop now' ");
    }

    //le boutton shopNow permet de commencer le shopping
    @FXML
    void shopNow(ActionEvent event) {
        //verifie si les infos sont remplies
         if(nom.getText()!= null && prenom.getText() != null &&  adresse.getText()!= null && codePostal.getText() !=null && dateNaiss.getText()!= null ){
            labelNom.setText(nom.getText().toUpperCase());
            labelPrenom.setText(prenom.getText());
            labelAdresse.setText(adresse.getText());
            labelCodePostal.setText(codePostal.getText());
            labelDateNaiss.setText(dateNaiss.getText());
        }
         //creation du client
        Client client = new Client(labelNom.getText(), labelPrenom.getText(), labelAdresse.getText(), labelDateNaiss.getText(), labelCodePostal.getText());

         //associer un caissier au client
        this.caissier = m.choixAleatoirCaissier();

        //choix du mode de paiement en fonction de ce que l user chosi
        //si i ne choisi rien le mode espece est pa defaut
        //en choisisssant le mode la commande est cree le user peut donc commencer son shopping
        if(this.paiementCheque.isSelected()) {
            commande = new Commande(client, (Employe) this.caissier, m, ModePaiement.cheque);//espece par defaut
        }
        if(this.paiementCB.isSelected()) {
             commande = new Commande(client, (Employe) this.caissier, m, ModePaiement.CB);//espece par defaut
        }
        if(this.paiementEspece.isSelected()) {
             commande = new Commande(client, (Employe) this.caissier, m, ModePaiement.espece);//espece par defaut
        }

        //dans le cas ou le user ne renseigne aucune infos
        //on remplie tout par des "NON RENSEIGNE"
        if(commande == null ){
            commande = new Commande(client, (Employe) this.caissier, m, ModePaiement.espece);//espece par defaut
            labelNom.setText("NON RENSEIGNE");
            labelPrenom.setText("NON RENSEIGNE");
            labelAdresse.setText("NON RENSEIGNE");
            labelCodePostal.setText("NON RENSEIGNE");
            labelDateNaiss.setText("NON RENSEIGNE");
        }

        //le shopping commence
        textInfo.setText("Hola ! " +labelPrenom.getText() +"\n Vous pouvez commencer votre \n shopping maintenant" +
                " dans l'onglet Shop, \n Votre caissier associe est : \n " +this.caissier.getPrenom()+", " +this.caissier.getNom().toUpperCase());


        //remplir les labels (infos) de la commande dans notre interface
        // cast le double en string
        if (commande != null && caissier!= null ) {
            this.labelCaissier.setText(caissier.getPrenom() +", " +caissier.getNom().toUpperCase());
            this.labelPrixTital.setText(String.valueOf(commande.getPrixTotal()));
            this.labelNumCom.setText(String.valueOf(commande.getId()));
            this.labelModePai.setText(commande.getModePaiement().toString());
            this.labelMagasin.setText(this.m.getNom());
        }

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

//bouttons d'ajout des produits affiches dans notre magasin
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

//bouttons de suppression des produits affiches dans notre magasin
    @FXML
    void suppPS5(ActionEvent event) {
        if(this.labelnbrps5.getText().equals("0")){//ne pas pouvoir supprimer si y a 0 article
            this.textInfoShop.setText("Vous ne pouvez pas \n supprimer cet article \n vous avez 0 de base ! ");
        }else{
            this.labelnbrps5.setText(String.valueOf(Integer.parseInt(this.labelnbrps5.getText())-1));
            this.textInfoShop.setText("un produit ps5 a ete supprime ! \n Si vous avez fini vos courses appuyez \n sur le boutton Shop now, \n et sinon continuez vos courses.");

        }

    }

    @FXML
    void suppSweat(ActionEvent event) {
        if(this.labelnbrSWEAT.getText().equals("0")){//ne pas pouvoir supprimer si y a 0 article
            this.textInfoShop.setText("Vous ne pouvez pas \n supprimer cet article \n vous avez 0 de base ! ");
        }else{
            this.labelnbrSWEAT.setText(String.valueOf(Integer.parseInt(this.labelnbrSWEAT.getText()) - 1));
            this.textInfoShop.setText("un produit sweat a ete supprime ! \n Si vous avez fini vos courses appuyez \n sur le boutton Shop now, \n et sinon continuez vos courses.");
        }
    }

    @FXML
    void suppSwitch(ActionEvent event) {
        if(this.labelnbrSWITCH.getText().equals("0")){//ne pas pouvoir supprimer si y a 0 article
            this.textInfoShop.setText("Vous ne pouvez pas \n supprimer cet article \n vous avez 0 de base ! ");
        }else {


            this.labelnbrSWITCH.setText(String.valueOf(Integer.parseInt(this.labelnbrSWITCH.getText()) - 1));
            this.textInfoShop.setText("un produit switch a ete supprime ! \n Si vous avez fini vos courses appuyez \n sur le boutton Shop now, \n et sinon continuez vos courses.");

        }
    }

    @FXML
    void suppJava(ActionEvent event) {
        if (this.labelnbrJAVA.getText().equals("0")) {//ne pas pouvoir supprimer si y a 0 article
            this.textInfoShop.setText("Vous ne pouvez pas \n supprimer cet article \n vous avez 0 de base ! ");
        } else {
            this.labelnbrJAVA.setText(String.valueOf(Integer.parseInt(this.labelnbrJAVA.getText()) - 1));
            this.textInfoShop.setText("un produit livre Java a ete supprime ! \n Si vous avez fini vos courses appuyez \n sur le boutton Shop now, \n et sinon continuez vos courses.");
        }
    }

    @FXML
    void suppFX(ActionEvent event) {
        if(this.labelnbrFX.getText().equals("0")){//ne pas pouvoir supprimer si y a 0 article
            this.textInfoShop.setText("Vous ne pouvez pas \n supprimer cet article \n vous avez 0 de base ! ");
        }else{
            this.labelnbrFX.setText(String.valueOf(Integer.parseInt(this.labelnbrFX.getText())-1));
            this.textInfoShop.setText("un produit livre JavaFX a ete supprime ! \n Si vous avez fini vos courses appuyez \n sur le boutton Shop now, \n et sinon continuez vos courses.");
        }
    }

    @FXML
    void suppSQL(ActionEvent event) {
        if(this.labelnbrSQL.getText().equals("0")){//ne pas pouvoir supprimer si y a 0 article
            this.textInfoShop.setText("Vous ne pouvez pas \n supprimer cet article \n vous avez 0 de base ! ");
        }else {
            this.labelnbrSQL.setText(String.valueOf(Integer.parseInt(this.labelnbrSQL.getText()) - 1));
            this.textInfoShop.setText("un produit livre SQL a ete supprime ! \n Si vous avez fini vos courses appuyez \n sur le boutton Shop now, \n et sinon continuez vos courses.");
        }
        }

    @FXML
    void suppGraphe(ActionEvent event) {
        if(this.labelnbrGRAPHE.getText().equals("0")){//ne pas pouvoir supprimer si y a 0 article
            this.textInfoShop.setText("Vous ne pouvez pas \n supprimer cet article \n vous avez 0 de base ! ");
        }else {
            this.labelnbrGRAPHE.setText(String.valueOf(Integer.parseInt(this.labelnbrGRAPHE.getText()) - 1));
            this.textInfoShop.setText("un produit livre Graphe a ete supprime ! \n Si vous avez fini vos courses appuyez \n sur le boutton Shop now, \n et sinon continuez vos courses.");
        }
    }

//boutton Shop now qui fait passer la commande et calcule le prix total de la commande
    @FXML
    void passerCommande(ActionEvent event) {
        //un try catch car le user peut appuyer sur le boutton sans renseigner les infos et donc
        //aucune commande ne sera cree, JAVA aura donc un pointeur nul
        try {
            //ajout de tous les produits choisis par le user
            this.commande.ajoutProduit(this.m.getPs5(), Integer.parseInt(this.labelnbrps5.getText()));
            this.commande.ajoutProduit(this.m.getSweat(), Integer.parseInt(this.labelnbrSWEAT.getText()));
            this.commande.ajoutProduit(this.m.getNintendoSwitch(), Integer.parseInt(this.labelnbrSWITCH.getText()));
            this.commande.ajoutProduit(this.m.getLivreJAVA(), Integer.parseInt(this.labelnbrJAVA.getText()));
            this.commande.ajoutProduit(this.m.getLivreSQL(), Integer.parseInt(this.labelnbrSQL.getText()));
            this.commande.ajoutProduit(this.m.getLivreFX(), Integer.parseInt(this.labelnbrFX.getText()));
            this.commande.ajoutProduit(this.m.getLivreGRAPHES(), Integer.parseInt(this.labelnbrGRAPHE.getText()));
            this.labelPrixTital.setText(String.valueOf(this.commande.getPrixTotal()));

            //si le user n'a rien choisi mais qu il a appuye sur le boutton shop now
            if(this.commande.getPrixTotal() == 0.0){
                this.textInfoShop.setText("Vous n'avez rien achete :(");
            }else{

             //calcule du prixTotal et remettre les compteurs a zero
                this.labelDtaeCom.setText(commande.getDateCommande());
                this.labelNumCom.setText(String.valueOf(this.commande.getId()));
                this.labelnbrGRAPHE.setText(String.valueOf(0));
                this.labelnbrSQL.setText(String.valueOf(0));
                this.labelnbrFX.setText(String.valueOf(0));
                this.labelnbrJAVA.setText(String.valueOf(0));
                this.labelnbrSWITCH.setText(String.valueOf(0));
                this.labelnbrSWEAT.setText(String.valueOf(0));
                this.labelnbrps5.setText(String.valueOf(0));

             //calculer les gains du caissier associe
                Employe caissier =(Employe) this.caissier;
                double prixTotal = this.commande.getPrixTotal();
                caissier.setGains((prixTotal*caissier.getContrat().pourcentageGainsDeProductivite())/100);
                if(caissier.getPrenom().equals("Simane")){
                    this.salaireSimane.setText(String.valueOf(caissier.getGains()));
                }
                if(caissier.getPrenom().equals("Maxime")){
                    this.salaireMaxime.setText(String.valueOf(caissier.getGains()));
                }
                if(caissier.getPrenom().equals("Loic")){
                    this.salaireLoic.setText(String.valueOf(caissier.getGains()));
                }

              //commande passee
             //creation fichier ticket
                this.textInfoShop.setText("Super ! Merci pour votre commande\n " +this.labelPrenom.getText() +"\n" +
                        "vous avez un total de \n" + this.commande.getPrixTotal() +" a payer . \n" +
                        "Vous pouvez desormais telecharger \n votre ticket de" +
                        "caisse en appuyant sur le \n boutton Ticket." +
                        "Grace a vous votre caissier " +this.caissier.getPrenom()
                        +"\n a pu gagner un gains de \n"+
                        ((Employe) this.caissier).getGains()+
                        "\n Vous pouvez desormais fermer cette fenetre ! \n A  bientot!");
            }
        }catch(NullPointerException er){
            this.textInfoShop.setText("Vous n'avez pas renseigne \n vos infos personnelles! \n Ou vous n'avez pas appuyez sur \n le boutton " +
                    "\n Shop Now ! \n Retourner dans l'onglet Acceuil \n et faites le .");
        }
    }

//les bouttons "D" pour telecharger le fichier dans lequel le user trouvera tous les details d un produit
    @FXML
    void afficherDetailsPs5(ActionEvent event){
        this.m.afficherDetailsProduit(this.m.getPs5());
        this.textInfoTicket.setText("Votre fichier texte est dans \n le dossier Shop");
    }

    @FXML
    void afficherDetailsSweat(ActionEvent event) {
       this.m.afficherDetailsProduit(this.m.getSweat());
       this.textInfoTicket.setText("Votre fichier texte est dans \n le dossier Shop");
    }

    @FXML
    void afficherDetailsSwitch(ActionEvent event) {
        this.m.afficherDetailsProduit(this.m.getNintendoSwitch());
        this.textInfoTicket.setText("Votre fichier texte est dans \n le dossier Shop");
    }

    @FXML
    void afficherDetailsJava(ActionEvent event) {
        this.m.afficherDetailsProduit(this.m.getLivreJAVA());
        this.textInfoTicket.setText("Votre fichier texte est dans \n le dossier Shop");
    }

    @FXML
    void afficherDetailsFX(ActionEvent event) {
        this.m.afficherDetailsProduit(this.m.getLivreFX());
        this.textInfoTicket.setText("Votre fichier texte est dans \n le dossier Shop");
    }

    @FXML
    void afficherDetailsSQL(ActionEvent event) {
        this.m.afficherDetailsProduit(this.m.getLivreSQL());
        this.textInfoTicket.setText("Votre fichier texte est dans \n le dossier Shop");
    }

    @FXML
    void afficherDetailsGraphes(ActionEvent event) {
        this.m.afficherDetailsProduit(this.m.getLivreGRAPHES());
        this.textInfoTicket.setText("Votre fichier texte est dans \n le dossier Shop");
    }

//boutton pour telecharger le ticket de caisse
    @FXML
    void ticketDeCaisse(ActionEvent event) {
        //un try catch car le user peut appuyer sur le boutton "ticket" sans renseigner les infos et donc
        //aucune commande ne sera cree, JAVA aura donc un pointeur nul
        try {
            if(this.commande.getPrixTotal() == 0.0){//s il n a rien achete
                this.textInfoShop.setText("Vous n'avez rien achete :(");
            }else{
                this.m.ticketDeCaisse(this.commande, (Client) this.client);
                this.textInfoTicket.setText("Votre ticket de caisse est dans \n le dossier Shop");
            }
        }catch(NullPointerException erreur){
            this.textInfoShop.setText("Vous n'avez pas renseigne \n vos infos personnelles! \n Ou vous n'avez pas appuyez sur \n le boutton " +
                    "\n Shop Now ! \n Retourner dans l'onglet Acceuil \n et faites le .");
        }
    }
}
