package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class QuestionBank {

    //Fragen aus der Datenbank laden
    //Fragen Objekte erstellen
    //Fragen Objekte in eine Liste laden
    //Liste zurückgeben

    //Datenbankverbindung
    private ArrayList<Question> questionsList = new ArrayList<>();

    //Methode mit Parametern von Statement und categoryTable
    public void loadCategoryQuestions(Statement statement, String categoryTable){
        String QUERY_DATA_FROM_TABLE="SELECT * FROM "+categoryTable; //SQL Anfrage
        ResultSet resultSet = null; //Ergebnis gespeichert von Anfrage

        try{
           resultSet = statement.executeQuery(QUERY_DATA_FROM_TABLE); //In Resultset abspeichern von der Anfrage...

           //Tabelle wird Zeile für Zeile durchgelesen
           while (resultSet.next()){
               int question_id = resultSet.getInt(1); //Hier die Speicher der Attribute von der Tabelle in java Attribute
               String question_text = resultSet.getString(2); //Dasselbe, wichtig bei 0 anfangen und nicht 1!
               boolean question_answer;

               //Da in SQLite keine Bools möglich sind, hier mit if/else selbst geholfen und einfach abgefragt und in bool gespeichert
               if (resultSet.getInt(3) == 1){
                   question_answer = true;
               }else {
                   question_answer = false;
               }

               String question_complement = resultSet.getString(4);

               //das Question-Objekt erzeugt
               Question question = new Question(question_id, question_text, question_answer, question_complement);

               questionsList.add(question); //der Arraylist das oben erzeugte Objekt hinzugefügt...

           }


        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    //Getter/Setter der Arraylist
    public ArrayList<Question> getQuestionsList() {
        return questionsList;
    }

    public void setQuestionsList(ArrayList<Question> questionsList) {
        this.questionsList = questionsList;
    }
}
