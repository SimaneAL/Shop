# MagasinJavaS5
 Un projet de java réalisé par Simane AIT LAHCEN, Maxime BOURDON
 et Loïc Etienne. Des étudiants de Paris Dauphine PSL
## Shop DAUPHINE : Programme en Java et interface en JavaFX  🌎 
[![forthebadge](https://forthebadge.com/images/badges/built-with-love.svg)](https://forthebadge.com) [![forthebadge](https://forthebadge.com/images/badges/made-with-java.svg)](https://forthebadge.com)
> Il s'agit d'un magasin vendant des produits en rapport avec l'informatique dans lequel le client pourra interagir avec une interface graphique faite en JavaFX 

### Repo gitHub :
https://github.com/SimaneAL/Shop

## Installation 

1. **Installation de IntelliJ**

À cause du système de dépendances lui étant propre, l'utilisation de IntelliJ est nécessaire pour utiliser cette application.
- Télécharger IntelliJ à ce lien : https://www.jetbrains.com/fr-fr/idea/download/
    - La version gratuite de IntelliJ, dite "Community", devrait suffire pour lancer le projet.
    - Il est possible d'obtenir une license gratuite (via un compte JetBrains) de IntelliJ Ultimate, pour les enseignants : https://www.jetbrains.com/shop/eform/students

- Télécharger la dernière version du SDK de JavaFX (version **x64**) :
    - *[Pour Windows](https://download2.gluonhq.com/openjfx/17.0.1/openjfx-17.0.1_windows-x64_bin-sdk.zip)*
    - *[Pour MacOS](https://download2.gluonhq.com/openjfx/17.0.1/openjfx-17.0.1_osx-x64_bin-sdk.zip)*
    - *[Pour Linux](https://download2.gluonhq.com/openjfx/17.0.1/openjfx-17.0.1_linux-x64_bin-sdk.zip)*

- Installez IntelliJ, créez un compte JetBrains si besoin. Une fois l'installation terminée, vous devriez obtenir une interface similaire à celle-ci :
![image](https://user-images.githubusercontent.com/59501884/146651506-3289552b-c047-4d6a-b615-b7613837b45f.png)
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



### Setup

Important ! 
> Si vous n'avez jamais utilisé Junit sur Intellij vous devez suivre les étapes suivantes :
>
![Capture3](src/pics/junit.PNG)
>Ensuite vous cliquez sur le boutton FIX en dessous de JUnit5
>
![Capture3](src/pics/ju.PNG)

Voilà, il n'y a plus qu'une seule chose à faire, cliquer sur le boutton OK, et Sdémarrer le programme en exécutant la classe Main


### 1. Java 

#### 1.1. Les Classes Métier : classes principales !
https://github.com/SimaneAL/Shop/tree/Simane_dev/src

#### 1.3. JavaFX !
https://github.com/SimaneAL/Shop/tree/Simane_dev/src/sample


### 1. Diagramme de classe :
![Capture](src/pics/Produit.png)
