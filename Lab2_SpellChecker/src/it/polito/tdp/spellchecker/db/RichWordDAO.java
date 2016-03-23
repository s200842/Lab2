package it.polito.tdp.spellchecker.db;

import java.sql.*;

public class RichWordDAO {
	
	public boolean cercaParola(String s){
		//Connessione al DB
		try {
			String jdbcURL = "jdbc:mysql://localhost/dizionario?user=root";
			Connection c = DriverManager.getConnection(jdbcURL);
			Statement st = c.createStatement();
			//Esecuzione Query
			String sql = "SELECT nome FROM parola WHERE nome='"+s+"';";
			ResultSet res = st.executeQuery(sql);
			//Importazione risultato
			if(res.next() == false){
				return false;
			}
			else if(s.equals(res.getString("nome"))){
				res.close();
				c.close();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
}
