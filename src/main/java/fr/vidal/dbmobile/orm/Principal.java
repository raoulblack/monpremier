package fr.vidal.dbmobile.orm;



import java.sql.ResultSet;
import java.sql.SQLException;

import fr.vidal.dbmobile.utils.ConnexionUtils;

public class Principal {

	public static void main(String[] args) {
		ConnexionUtils cnx = new ConnexionUtils("C:/Users/raoul/vidalmono.db");
	    cnx.connect();
	    ResultSet resultSet = cnx.query("SELECT count(*) FROM DOCUMENT");
        try {
            if (resultSet.next()) {
                System.out.println("nombre de données dans la base "+ resultSet.getInt(1) );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        cnx.close();
	}

}
