package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainBis extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view.fxml"));
        primaryStage.setTitle("Shop S5 ");
        primaryStage.setScene(new Scene(root, 900 , 700));
        primaryStage.show();
    }

//2 onglets :
// user :
    //acheter un/des produits + renseigner ses infos + consulter commandes + total

// admin : gerer les stock, crer des produits + gerer l'argent
    public static void main(String[] args) {
        launch(args);
    }
}
