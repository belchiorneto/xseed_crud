package telaLogin;

import java.util.Map;
import java.sql.*;

public class DaoLogin {

	private static DaoLogin instancia;

	private DaoLogin() {
	}

	public static DaoLogin getInstancia() {
		if (instancia == null)
			instancia = new DaoLogin();
		return instancia;
	}
	
	private LoginModel connect(Map<String, Object> login) throws SQLException {
		ResultSet results = null;
		LoginModel loginRetorno = new LoginModel();
		Connection conn = null; 
		String sql = "select * from login "
					+ "where "
					+ "login = '" + login.get("login") + "'"
					+ " AND password = '" + login.get("password") + "'";
		try {
			// Step 1: "Load" the JDBC driver
			Class.forName("org.h2.Driver");

			conn = DriverManager.getConnection ("jdbc:h2:~/test", "sa","");
			//conn = DriverManager.getConnection ("jdbc:h2:tcp:192.168.0.170:8082/estagio5:test", "sa","");
			Statement st = conn.createStatement();
			results = st.executeQuery(sql);
			loginRetorno = resultSetToLogin(results);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			conn.close();
		}
		return loginRetorno;
	}

	public LoginModel pesquisar(Map<String, Object> cliente) throws SQLException {
		LoginModel loginRetorno =  connect(cliente);
		return loginRetorno;
	}
	
	private LoginModel resultSetToLogin(ResultSet results) throws SQLException{
		LoginModel login = new LoginModel();
		while(results.next()) {
			login.setLogin(results.getString("login"));
			login.setPassword(results.getString("password"));
		}
		
		return login;
	}

}
