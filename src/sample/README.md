1. **JavaFX**
- Ouvrez le projet Shop via le bouton *"Open"*.
Vous devriez obtenir une interface comme celle-ci :
![image](https://user-images.githubusercontent.com/59501884/146651572-84644c87-1da6-41b7-b5e0-1d2183212b81.png)
- Rendez-vous dans File -> Project Structure, puis dans *Libraries*, et enfin, cliquez sur le **+**, puis sur *Java*.
<br>
![image](https://user-images.githubusercontent.com/59501884/146651607-f95481da-c24d-427e-b103-40bdeff1e44b.png)
![image](https://user-images.githubusercontent.com/59501884/146651656-e7dd917f-46ee-4440-a02e-7176481baae7.png)

- Sélectionnez le dossier "*lib*" de JavaFX sur votre disque.
![Capture d’écran 2021-12-18 à 19 17 38](https://user-images.githubusercontent.com/59501884/146651838-1b0f10b9-e340-44bc-a1c8-cf2d528e3fd0.jpg)
- Confirmez, cliquez sur "**Apply**", puis "**Ok**".
- Rendez-vous maintenant dans *Run* -> *Edit Configurations*
![image](https://user-images.githubusercontent.com/59501884/146651941-537aba78-c0f6-4ae7-9589-f112cbbc88f6.png)
- Cliquez sur *Modify Options* -> *Add VM Options*
![Image_18_12_2021_19_27_collée](https://user-images.githubusercontent.com/59501884/146652012-5379461f-fa04-4bda-ac8a-64aaf558ec63.png)
- Ajouter la ligne suivante :
 `--module-path "[chemin d’accès absolu au sous-dossier lib]" --add-modules=javafx.base,javafx.controls,javafx.graphics,javafx.media,javafx.fxml`
- Cliquez sur *Apply*, puis *Ok*.
- Dans l'arborescence du projet, ouvrez `Shop/src/sample/Main.java`.
![Image_18_12_2021_19_45_collée](https://user-images.githubusercontent.com/59501884/146652496-7f44beeb-0576-4cad-9e51-3c17986ea811.png)
- Cliquez sur un bouton Play pour lancer le projet
