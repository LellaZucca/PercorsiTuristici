package percorsiTuristici;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginAmministratore {

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

	public LoginAmministratore (String username, String password){
		this.username=username;
		this.password=password;
	}
	
	public boolean getUname() {
		String sql = "SELECT un, pw FROM persona WHERE un = '" + username + "' AND pw = '" + password +"'";

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