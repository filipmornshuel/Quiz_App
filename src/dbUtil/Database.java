package dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    //Static und final Attribute zum Verbinden der Datenbank
    public static final String DB_NAME = "quizApp.db";
    public static final String PATH = "C:\\Users\\filip\\OneDrive - Bildungszentrum Zürichsee\\Eigene_Projekte\\Java\\Quiz App 3\\";
    public static final String CONNECTION_STRING = "jdbc:sqlite:" + PATH + DB_NAME;

    private Connection connection =null;
    private Statement statement = null;

    public boolean open(){
        try{
            connection = DriverManager.getConnection(CONNECTION_STRING); //Verbindung aufbauen, Exception  möglich
            statement = connection.createStatement(); //Statement erstellen
            return true;
        }catch (SQLException e){
            System.out.println("Datei nicht gefunden");
            return false;

        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }
}
