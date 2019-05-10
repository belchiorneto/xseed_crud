package controller;

import java.io.IOException;
import java.util.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import telaLogin.ClienteModel;
import telaLogin.DaoClient;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class ClientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DaoClient daoclient;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		daoclient = new DaoClient();
		String action = request.getParameter("action");
		List<ClienteModel> clientes = new ArrayList<ClienteModel>();
		RequestDispatcher view = request.getRequestDispatcher("/CRUD.jsp");
		
		switch (action) {
        case "listClient":
        	try {
        		clientes = daoclient.pesquisar();
    			request.setAttribute("clients", clientes);
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
            
            view.forward(request, response);
            break;
        case "deleteClient":
        	daoclient.deleteClient(request.getParameter("id"));
        	try {
        		clientes = daoclient.pesquisar();
    			request.setAttribute("clients", clientes);
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
            view.forward(request, response);
            break;
        case "updateClient":
        	
            break;
        }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("/CRUD.jsp");
		List<ClienteModel> clientes = new ArrayList<ClienteModel>();
		ClienteModel clientemodel = new ClienteModel();
		clientemodel.setName(request.getParameter("name"));
		clientemodel.setAdress(request.getParameter("adress"));
		clientemodel.setCredit(Integer.parseInt(request.getParameter("credit")));
		
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		//Date date = simpleDateFormat.parse(request.getParameter("expiration"));
		//clientemodel.setExpiration(date);
		daoclient.cadastra(clientemodel);
		try {
    		clientes = daoclient.pesquisar();
			request.setAttribute("clients", clientes);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        view.forward(request, response);
	}

}
