package menu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/menu/menu.fxml")); //Verzeichnis zum menu.fxml Datei
        //auch mit Main.class.getResource möglich...
            Scene scene = new Scene(root); //Szene erstellen
            //Szene präsenteieren
            primaryStage.setScene(scene);
            primaryStage.setResizable(false); //Nicht anpassbar das Fenster
            primaryStage.show(); //Die Szene zeigen
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
