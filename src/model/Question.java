package model;

public class Question {
    //Attribute
    private int question_id;
    private String question_text;
    private boolean question_answer;
    private String question_complement;



    //Konstruktor
    public Question(int question_id, String question_text, boolean question_answer, String question_complement) {
        this.question_id = question_id;
        this.question_text = question_text;
        this.question_answer = question_answer;
        this.question_complement = question_complement;
    }

    //Getter/Setter
    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public String getQuestion_text() {
        return question_text;
    }

    public void setQuestion_text(String question_text) {
        this.question_text = question_text;
    }

    public boolean isQuestion_answer() {
        return question_answer;
    }

    public void setQuestion_answer(boolean question_answer) {
        this.question_answer = question_answer;
    }

    public String getQuestion_complement() {
        return question_complement;
    }

    public void setQuestion_complement(String question_complement) {
        this.question_complement = question_complement;
    }
}
