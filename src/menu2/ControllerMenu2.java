package menu2;

import application.ControllerQuiz;
import dbUtil.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import model.PopupWindow;
import model.Question;
import model.QuestionBank;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllerMenu2 implements Initializable {
    @FXML
    private Button categoryComputer;

    @FXML
    private Button categoryProLan;

    @FXML
    private Button categoryJava;

    @FXML
    private Button categorySwiss;

    @FXML
    private Button categoryAnimals;

    @FXML
    private Label categoryLabel;

    @FXML
    private HBox statusHBox;

    @FXML
    private Circle dbStatusLight;

    //Liste mit FRagen
    ArrayList<Question> quizQuestionList = new ArrayList<>();

    //Liste, welche Kategorie soll im Quiz erscheinen
    ArrayList<String>  categoryList = new ArrayList<>(); //Auswahl in dieser Liste speichern

    //Datenbankobjekt
    Database database;

    //QuestionBank
    QuestionBank questionBank;

    //Category
    @FXML
    void categoryComputerButton_Clicked(ActionEvent event) {
        Button button = (Button) event.getSource(); //Quelle vom Button bekommen
        getCategory(button.getText(), button); //Aufruf der Methode von unten


    }

    @FXML
    void categoryProLan_Clicked(ActionEvent event) {
        Button button = (Button) event.getSource(); //Quelle vom Button bekommen
        getCategory(button.getText(), button); //Aufruf der Methode von unten
    }

    @FXML
    void categoryJavaButton_Clicked(ActionEvent event) {
        Button button = (Button) event.getSource(); //Quelle vom Button bekommen
        getCategory(button.getText(), button); //Aufruf der Methode von unten
    }

    @FXML
    void categorySwissButton_Clicked(ActionEvent event) {
        Button button = (Button) event.getSource(); //Quelle vom Button bekommen
        getCategory(button.getText(), button); //Aufruf der Methode von unten
    }

    @FXML
    void categoryAnimalsButton_Clicked(ActionEvent event) {
        Button button = (Button) event.getSource(); //Quelle vom Button bekommen
        getCategory(button.getText(), button); //Aufruf der Methode von unten
    }

    //HBOX Status
    @FXML
    void cancelButton_Clicked(ActionEvent event) {
        //Alle Buttons wieder aktiveren
        categoryComputer.setDisable(false);
        categoryAnimals.setDisable(false);
        categoryJava.setDisable(false);
        categoryProLan.setDisable(false);
        categorySwiss.setDisable(false);
        statusHBox.setDisable(true); //Hbox nicht klickbar machen
        categoryLabel.setText(""); //Leeren Text wieder setzen...
    }


    @FXML
    void okButton_Clicked(ActionEvent event) {
        questionBank = new QuestionBank(); //Initialisierung

        //Foreach durch categorylist
        for (String category: categoryList) {
            questionBank.loadCategoryQuestions(database.getStatement(), category);//Questionbank
        }
        quizQuestionList = questionBank.getQuestionsList(); //Die Fragen von der questionBank in der List abgespeichert...

        /*
        //Testdurchlauf, ob alles richtig ausgegeben wird...
        for (Question question: quizQuestionList) {
            System.out.println("ID " +question.getQuestion_id());
            System.out.println("Frage " +question.getQuestion_text());
            System.out.println("Antwort " +question.isQuestion_answer()); //isquestion, wegen Bool!
            System.out.println("Ergänzung " +question.getQuestion_complement());

        }

         */

        //Das Kategorie Fenster schliessen
        Button okButton = (Button) event.getSource();
        Stage stage  = (Stage) okButton.getScene().getWindow(); //Hauptfenster herausfinden...
        stage.close(); //Hauptfenster schliessen

        //Try-Catch, da Exception möglich ist, weil Methode sie wirft
        try {
            startQuiz();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //Initialize Methode von Implementierung
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Methode wird aufgerufen bevor fxml fenster aufgebaut wird
        statusHBox.setDisable(true); //OK und Cancel Button nicht klickbar gemacht
        //Databank-Verbindung
        database = new Database();
        boolean dbConnection = database.open();
        if (dbConnection){
            dbStatusLight.setFill(Color.GREEN);
        }else {
            dbStatusLight.setFill(Color.RED);
            PopupWindow.display("Keine Verbindung zur Datenbank möglich \n Programm bitte neustarten");

        }


    }

    //Methoden
    private void getCategory(String category, Button button){

        //Ausgewählte Kategorie in arraylist speichern
        categoryList.add(category);

        //Unten im Label ausgewählten Namen anzeigen
        categoryLabel.setText(categoryLabel.getText() + " " + category); //

        //Kategorie-Button Ausblenden
        button.setDisable(true);


        //Statusbox einsschalten
        statusHBox.setDisable(false); //Statusbox wieder aktiveren, also ok und cancel button
    }

    private void startQuiz() throws IOException {
        Stage stage3 = new Stage(); //Neue Stage erstellen, neues Fenster erstellen
        stage3.setTitle("Quiz App");
        FXMLLoader fxmlLoader = new FXMLLoader(); //Loader für quiz.fxml

        Pane root = (Pane) fxmlLoader.load(getClass().getResource("/application/quiz.fxml").openStream());

        //Die ArrayList mit den Fragen muss zum ControllerQuiz, mit getController() erhält man die Controller Klasse aus der fxml datei
        ControllerQuiz controllerQuiz = fxmlLoader.getController(); //Controllerquiz-Datei die FXMLDatei bekommen
        controllerQuiz.setQuestions(quizQuestionList); //Übergabe der Liste dem Controller

        Scene scene3 = new Scene(root); //Rootübergabe an Scene

        stage3.setScene(scene3); //Scene3 dem stage3 übergeben
        stage3.setResizable(false);
        stage3.show(); //anzeigen der Stage3!!!


    }
}
