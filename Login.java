package percorsiTuristici;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {

	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Login (String username, String password){
		this.username=username;
		this.password=password;
	}
	
	public boolean getAmministratore() {
		String sql = "SELECT un, pw FROM persona WHERE un = '" + username + "' AND pw = '" + password 
				+"' AND stato = 's' AND ruolo = 'a'";

		MyConnection connessione = new MyConnection();
		ResultSet rs = connessione.getResult(sql);

		try {
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		connessione.closeConnection();
		return false;
	}
	
	public boolean getUtente() {
		String sql = "SELECT un, pw FROM persona WHERE un = '" + username + "' AND pw = '" + password 
				+"' AND stato = 's' AND ruolo = 'u'";

		MyConnection connessione = new MyConnection();
		ResultSet rs = connessione.getResult(sql);

		try {
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		connessione.closeConnection();
		return false;
	}
}