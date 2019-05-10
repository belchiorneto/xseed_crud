package telaLogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoClient {
	private static DaoClient instancia;
	
	public DaoClient() {
	}
	
	public static DaoClient getInstancia() {
		if(instancia == null)
			instancia = new DaoClient();
		return instancia;
	}
	
	private List<ClienteModel> connect() throws SQLException {
		ResultSet results = null;
		List<ClienteModel> clienteRetorno = new ArrayList<ClienteModel>();
		Connection conn = null; 
		String sql = "select * from user ";
		try {
			// Step 1: "Load" the JDBC driver
			Class.forName("org.h2.Driver");

			conn = DriverManager.getConnection ("jdbc:h2:~/test", "admin","");
			//conn = DriverManager.getConnection ("jdbc:h2:tcp:192.168.0.170:8082/estagio5:test", "sa","");
			Statement st = conn.createStatement();
			results = st.executeQuery(sql);
			clienteRetorno = resultSetToCliente(results);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			conn.close();
		}
		return clienteRetorno;
	}
	
	public List<ClienteModel> pesquisar() throws SQLException {
		List<ClienteModel> listaRetorno = connect();
			
		return listaRetorno;
	}
	
	private List<ClienteModel> resultSetToCliente(ResultSet results) throws SQLException{
		List<ClienteModel> listaClientes = new ArrayList<ClienteModel>();
		while(results.next()) {
			ClienteModel cliente = new ClienteModel();
			cliente.setName(results.getString("name"));
			cliente.setAdress(results.getString("address"));
			cliente.setCredit(results.getShort("credit"));
			cliente.setExpiration(results.getDate("expiration"));
			
			listaClientes.add(cliente);
		}
		
		return listaClientes;
	}
}
