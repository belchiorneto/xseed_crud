package telaLogin;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Login {

	public List<ClienteModel> login(String login, String password) throws SQLException {
		LoginModel loginRetorno = DaoLogin.getInstancia().pesquisar(loginToMap(login, password));
		List<ClienteModel> listaRetorno = new ArrayList<ClienteModel>();
		if(loginRetorno != null) {
			listaRetorno = DaoClient.getInstancia().pesquisar();
		}
		
		return listaRetorno;
	}
	
	private Map<String, Object> loginToMap(String login, String password) {
		Map<String, Object> mapReturn = new HashMap<String, Object>();
		
		mapReturn.put("login", login);
		mapReturn.put("password", password);
		
		return mapReturn;
	}
}