package percorsiTuristici;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Query {
	
	
public boolean confermaPercorso(int id_percorso){
		
		String sql = "SELECT id_percorso FROM percorsi WHERE stato = 's' AND id_percorso =" + id_percorso;
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

	public void eliminaPercorso(int id_percorso){
		
		
		try{
		
			String sql = "UPDATE percorsi SET stato='n' WHERE id_percorso= ?" ;
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
		
		String sql = "SELECT id_un FROM persona WHERE stato != 0 AND ruolo = 'u' AND id_un ="+ id_utente;
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
	
public void ModificaUtente(int id_un, String nuovonome_inserito){
		
		
		try{
		
			String sql = "UPDATE persona SET un=? WHERE id_un= ?" ;
			MyConnection Connessione = new MyConnection();
			Connessione.openConnection();
			PreparedStatement prep = Connessione.conn.prepareStatement(sql);
			prep.setString(1, nuovonome_inserito);
			prep.setInt(2, id_un);
			int esito = prep.executeUpdate();
			prep.close();
		}
		catch (SQLException e)
	    { 
	    	e.printStackTrace();
	    }
	}


public boolean ModificaPercorso(String id_pe_inserito, String nuovonomepercorso_inserito){
	
	Integer id_pe = Integer.parseInt(id_pe_inserito);
	try{
	
		String sql = "UPDATE NOME_PERCORSI SET NOME_PERCORSO=? WHERE ID_PERCORSI= ?" ;
		MyConnection Connessione = new MyConnection();
		Connessione.openConnection();
		PreparedStatement prep = Connessione.conn.prepareStatement(sql);
		prep.setString(1, nuovonomepercorso_inserito);
		prep.setInt(2, id_pe);
		int esito = prep.executeUpdate();
		prep.close();
		if (esito == 1) return true;
	}
	catch (SQLException e)
    { 
    	e.printStackTrace();
    }
	return false;
}
////////////////////////// CONTROLLO POI/////////////////////////////////////////////////////////////
public boolean Control(int idpoi, int idpercorso){
	String sql= "SELECT ID_PERCORSI, ID_POI FROM PERCORSI";

	MyConnection Connessione = new MyConnection();
	
	ResultSet rs= Connessione.getResult(sql);
	
	System.out.println("VERIFIED POI FROM PERCORSI:");
	
	try 
	{
		 while (rs.next())
		 { 
			
			 Integer ID_PERCORSI=Integer.parseInt(rs.getString("ID_PERCORSI"));
			 Integer ID_POI=Integer.parseInt(rs.getString("ID_POI"));
			 System.out.println("ID_PERCORSI-->" +ID_PERCORSI+ " ID_POI--> " +ID_POI);
			 if (ID_POI.equals(idpoi) && ID_PERCORSI.equals(idpercorso)){
				return true;
				
				 
			 }
		 }
	}
	catch (SQLException e)
	{ 
		e.printStackTrace();
	}
	Connessione.closeConnection();
	return false;
}
/////////////////////////////////AGGIUNGI POI //////////////////////////////////////////////////////////

	public int getAddPoi(int idpoi, int idpercorso){
		int esito=-1;
		
		try{
		
			String sql = "INSERT INTO PERCORSI(id_percorsi, id_poi, stato) Values (?,?,'s')";
			MyConnection Connessione = new MyConnection();
			Connessione.openConnection();
			PreparedStatement prep = Connessione.conn.prepareStatement(sql);
			prep.setInt(1, idpoi);
			prep.setInt(2, idpercorso);
			esito = prep.executeUpdate();
			prep.close();
		}
		catch (SQLException e)
	    { 
	    	e.printStackTrace();
	    }
		return esito;
	}
/////////////////////////////////////RIMUOVI POI //////////////////////////////////////////////////////
	
	//DELETE FROM nome_tabella[ WHERE predicato ]
	
	
	public int getRemovePoi(int idpoi, int idpercorso){
		int esito=-1;
		
		try{
		
			String sql = "DELETE FROM PERCORSI WHERE id_poi=? AND id_percorsi=?" ;
			MyConnection Connessione = new MyConnection();
			Connessione.openConnection();
			PreparedStatement prep = Connessione.conn.prepareStatement(sql);
			prep.setInt(1, idpoi);
			prep.setInt(2, idpercorso);
			esito = prep.executeUpdate();
			prep.close();
			
		}
		catch (SQLException e)
	    { 
	    	e.printStackTrace();
	    }
		return esito;
	}
	
/////////////////////////////////////////////////////////////////////////////////////////	
	
	
	
	
	
	
	

}
