package menu;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import model.PopupWindow;

import java.io.IOException;

public class ControllerMenu {
//In der menu.fxml-Datei zusammenverbunden!!!


    @FXML
    void startButton_Clicked(ActionEvent event) {
        System.out.println("Start");
        //Startbutton menu2.fxml Datei verbinden

        Button button = (Button)event.getSource(); //Quelle herausfinden; Ursprungsort
        Stage primaryStage = (Stage) button.getScene().getWindow(); //Hauptfenster, mit dem Button die Szene bekommen, die SZene weiss in welcher Hauptfesnter es ist
        primaryStage.close(); //Hauptfenster schliessen
        try {
            goToCategoryOverview();
        } catch (IOException e) {
            //Fehler bearbeiten... für Endnutzer
            PopupWindow.display("Datei nicht gefunden \n Programm bitte neustarten!");
            e.printStackTrace();

        }
    }
    @FXML
    void scoreButton_Clicked(ActionEvent event) {
        System.out.println("Score");
    }
    @FXML
    void quitButton_Clicked(ActionEvent event) {
        System.out.println("Quit");
        Platform.exit();
    }

    private void goToCategoryOverview() throws IOException {
        Stage stage2 = new Stage(); //Stage erstellen
        FXMLLoader fxmlLoader = new FXMLLoader(); //Loader für die fxml datei

        //Aufpassen mit dem Pfad...
        Pane root = (Pane) fxmlLoader.load(getClass().getResource("/menu2/menu2.fxml").openStream()); //Exception möglichh, hierbei jetzt das menu2.fxml file hinzugefügt

        Scene scene2 = new Scene(root); //Root übergeben

        stage2.setScene(scene2); //Stage2 scene2 hinzufügen
        stage2.setTitle("Kategorie Auswahll"); //Titel
        stage2.setResizable(false);
        stage2.show();//anzeigen der Fenster



    }




}
