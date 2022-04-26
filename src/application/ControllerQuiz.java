package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.Question;

import java.util.ArrayList;

public class ControllerQuiz {

    @FXML
    private Label questionLabel;

    @FXML
    private Button trueButton;

    @FXML
    private Button falseButton;

    @FXML
    private Label questionCountLabel;

    @FXML
    private Label scoreLabel;

    @FXML
    private Label bestScoreLabel;

    @FXML
    private Label answerStatusLabel;

    @FXML
    private HBox progressHboxbar;

    private ArrayList<Question> questionArrayList;


    //Attribute zu den Fragen
    private boolean pickedAnswer = false;
    private int currentQuestionNumber = 0; //Welche FRage man sich gerade befindet
    private int score= 0; //Die erreichte Punktzahl
    private int questionCount= 0; //Anzahl der Gesamtfragen

    @FXML
    void answerButton_Clicked(ActionEvent event) {
        Button tappedBUtton = (Button) event.getSource(); //Quelle, wer hat gedrückt.

        //Unterscheidung, ob der Stimmt oder Stimm nicht Button gedrückt wurde, mittels IDs...
        if (tappedBUtton.getId().equals("trueButton")){ //Die ID hatte ich im SCENEBuilder gegeben, siehe Quiz.fxml Datei
            pickedAnswer  =true;
        }else if(tappedBUtton.getId().equals("falseButton")){
            pickedAnswer = false;
        }

        //Antwort überprüfen
        checkAnswer();
        //Eine Frage weiterspringen
        currentQuestionNumber += 1;

        //3. Nächste Fragen anzeigen
        nextQuestion(); //Methodenaufruf von unten
    }

    private void checkAnswer(){
        Question question = questionArrayList.get(currentQuestionNumber);
        boolean answer = question.isQuestion_answer();
        String complement = question.getQuestion_complement();

        if (answer == pickedAnswer){
            if (complement != null){
                answerStatusLabel.setText("Richtig " + complement);
            }else {
                answerStatusLabel.setText("Richtig");
            }
        }else {
            if (complement != null){
                answerStatusLabel.setText("Falsch " + complement);
            }else {
                answerStatusLabel.setText("Falsch");
            }
        }
    }

    private void nextQuestion(){
        if (currentQuestionNumber <= questionCount -1){ //Vergleich mit der Anzahl der Fragen
            questionLabel.setText(questionArrayList.get(currentQuestionNumber).getQuestion_text());
            updateUI();
        }else {
            restart();
        }
    }

    private void updateUI(){
        scoreLabel.setText("Score: " + score);
        questionCountLabel.setText("" + (currentQuestionNumber + 1) + "/" + questionCount); //Aktuelle Frage / Gesamtanzahl -->

        double progressHBoxBarWidth = (progressHboxbar.getWidth() /  questionCount);
        progressHboxbar.getChildren().add(new Rectangle(progressHBoxBarWidth, 20, Color.BLACK));
    }

    private void restart(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Glückwunsch");
        alert.setHeaderText("Glückwunsch zum Beenden des Quizes");
        alert.setContentText("Neustart?");
        alert.showAndWait(); //Anzeigen des Alerts

        //Alle Attribute "leeren"
        currentQuestionNumber = 0;
        score=0;
        nextQuestion();
        progressHboxbar.getChildren().clear();
        answerStatusLabel.setText("");
    }

    //Methoden
    public void setQuestions(ArrayList<Question> qList){
        questionArrayList = new ArrayList<>();
        this.questionArrayList = qList;
        questionCount = questionArrayList.size(); //wie viele Fragen in der Liste gerade sind, wird oben gebraucht
        //Test:
        System.out.println("Anzahl der Fragen: " + questionCount);

        /*
        //Test-foreach SChleife...
        for (Question question: questionArrayList) {
            System.out.println("ID " + question.getQuestion_id());
            System.out.println("Frage " + question.getQuestion_text());
            System.out.println("Ergänzung " + question.getQuestion_complement());
        }

         */

        //Erste Frage anzeigen
        if (questionArrayList != null) {
            String firstQuestion = questionArrayList.get(0).getQuestion_text();
            questionLabel.setText(firstQuestion);
        }
        updateUI(); //Aufruf der Methode von oben
    }

}
