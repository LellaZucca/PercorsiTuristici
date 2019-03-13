package percorsiTuristici;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Query {
	
	
public boolean confermaPercorso(int id_percorso){
		
		Integer id = id_percorso;
		String sql = "SELECT * FROM percorsi WHERE stato = 's' AND id_percorsi = " + id.toString();
		MyConnection Connessione = new MyConnection();
	    ResultSet rs =  Connessione.getResult(sql);	    
	    boolean se = false;
	     try
	    {
	    	while(rs.next())    		
	    		se = true;
	    			    }
	    catch (SQLException e)
	    { 
	    	e.printStackTrace();
	    }
	    Connessione.closeConnection();
	    return se;	
	    }

	public void eliminaPercorso(int id_percorso){
		
		
		try{
		
			String sql = "UPDATE percorsi SET stato='n' WHERE id_percorsi= ?" ;
			MyConnection Connessione = new MyConnection();
			Connessione.openConnection();
			PreparedStatement prep = Connessione.conn.prepareStatement(sql);
			prep.setInt(1, id_percorso);
			int esito = prep.executeUpdate();
			prep.close();
		}
		catch (SQLException e)
	    { 
	    	e.printStackTrace();
	    }
	}

public boolean confermaUtente(int id_utente){
		
	    Integer id = id_utente;
		String sql = "SELECT id_un FROM persona WHERE stato = 's' AND ruolo = 'u' AND id_un = "+ id.toString();
		MyConnection Connessione = new MyConnection();
	    ResultSet rs =  Connessione.getResult(sql);	    
	    
	     try
	    {
	    	if(rs.next())    		
	    		return true;
	    			    }
	    catch (SQLException e)
	    { 
	    	e.printStackTrace();
	    }
	    Connessione.closeConnection();
	    return false;	
	    }

	public void eliminaUtente(int id_un){
		
		
		try{
		
			String sql = "UPDATE persona SET stato='s' WHERE id_un= ?" ;
			MyConnection Connessione = new MyConnection();
			Connessione.openConnection();
			PreparedStatement prep = Connessione.conn.prepareStatement(sql);
			prep.setInt(1, id_un);
			int esito = prep.executeUpdate();
			prep.close();
		}
		catch (SQLException e)
	    { 
	    	e.printStackTrace();
	    }
	}

}
