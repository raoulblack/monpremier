package fr.vidal.dbmobile.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnexionUtils {
	 private String DBPath = "";
	    private Connection connection = null;
	    private Statement statement = null;
	 
	    public ConnexionUtils(String dBPath) {
	        DBPath = dBPath;
	    }
	 
	    public void connect() {
	        try {
	            Class.forName("org.sqlite.JDBC");
	            connection = DriverManager.getConnection("jdbc:sqlite:" + DBPath);
	            statement = connection.createStatement();
	            System.out.println("Connexion a " + DBPath + " avec succ�s");
	        } catch (ClassNotFoundException notFoundException) {
	            notFoundException.printStackTrace();
	            System.out.println("Erreur de connecxion");
	        } catch (SQLException sqlException) {
	            sqlException.printStackTrace();
	            System.out.println("Erreur de connecxion test");
	        }
	    }
	 
	    public ResultSet query(String requet) {
	        ResultSet resultat = null;
	        try {
	            resultat = statement.executeQuery(requet);
	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println("Erreur dans la requet : " + requet);
	        }
	        return resultat;
	  
	    }
	    
	    
	    
	    public void close() {
	        try {
	            connection.close();
	            statement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
}
