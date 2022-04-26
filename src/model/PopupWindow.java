package model;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.security.sasl.SaslClient;


public class PopupWindow {

    public static void display(String message){
        Stage stage = new Stage();
        stage.setTitle("Info! ");
        Label label =new Label(message);
        Button button = new Button("OK");
        button.setOnAction(new EventHandler<ActionEvent>() {
            //anonyme klasse
            @Override
            public void handle(ActionEvent event) {
                stage.close();
            }
        });

        VBox vBox = new VBox(10); //Abstand zwischen Label und Button gesetzt
        vBox.getChildren().addAll(label, button); //Beides gleichzeitig adden, aber Label zuerst...
        vBox.setAlignment(Pos.CENTER); //Zentrieren

        Scene scene = new Scene(vBox); //Die VBOX in Scene setzen
        stage.setScene(scene); //Szene gesetzt
        stage.show(); //Stage anzeigen...

    }

}
