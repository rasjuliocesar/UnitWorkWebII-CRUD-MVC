package aula.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aula.entidade.Cliente;
import aula.model.ClienteAlterar;
import aula.model.ClienteApagar;
import aula.model.ClienteConsultar;
import aula.model.ClienteListar;
import aula.model.ClienteSalvar;

@WebServlet("/ClienteController")
public class ClienteController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at GET: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("action").equals("salvar")) {
			Cliente cliente = new Cliente();
			
			cliente.setCpf(request.getParameter("cpf"));
			cliente.setNome(request.getParameter("nome"));
			cliente.setEmail(request.getParameter("email"));
			
			try {
				cliente.setDataNascimento(sdf.parse(request.getParameter("dataNascimento")));
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			
			cliente.setSexo(request.getParameter("sexo"));
			cliente.setNomeSocial(request.getParameter("social"));
			cliente.setApelido(request.getParameter("apelido"));
			cliente.setTelefone(request.getParameter("telefone"));
			
			try {
				
				ClienteSalvar salva = new ClienteSalvar();
				salva.salvar(cliente);
				
				ClienteListar lista = new ClienteListar();
				ArrayList<Cliente> nLista = (ArrayList) lista.listar();
				request.setAttribute("clientes", nLista);
				
				RequestDispatcher view = request.getRequestDispatcher("ListarCliente.jsp");
				view.forward(request, response);
			} catch (Exception e) {
				response.getWriter().append("Erro: ClienteController salvar " + e.getMessage());
			}
		}
		
		if(request.getParameter("action").equals("listar")) {
			try {
				ClienteListar lista = new ClienteListar();
				ArrayList<Cliente> nLista = (ArrayList) lista.listar();
				request.setAttribute("clientes", nLista);
				
				RequestDispatcher view = request.getRequestDispatcher("ListarCliente.jsp");
				view.forward(request, response);
			} catch (Exception e) {
				response.getWriter().append("Erro: ClienteController listar " + e.getMessage());
			}
		}
		
		if(request.getParameter("action").equals("consultar")) {
			Cliente  cliente = new Cliente();
			
			cliente.setCpf(request.getParameter("cpf"));

			try {
				Cliente consulta = new ClienteConsultar().consultar(cliente);

				request.setAttribute("consulta", consulta);
				
				RequestDispatcher view = request.getRequestDispatcher("ConsultarCliente.jsp");
				view.forward(request, response);
			} catch (Exception e) {
				response.getWriter().append("Erro: ClienteController consultar " + e.getMessage());
			}
		}
		
		if(request.getParameter("action").equals("apagar")){
			Cliente cliente = new Cliente();
			
			cliente.setCpf(request.getParameter("cpf"));
			cliente.setEmail(request.getParameter("email"));
			
			try {
				ClienteApagar apaga = new ClienteApagar();
				apaga.apagar(cliente);
				
				request.setAttribute("exclusao", cliente);
				
				RequestDispatcher view = request.getRequestDispatcher("ApagarCliente.jsp");
				view.forward(request, response);
			} catch (Exception e) {
				response.getWriter().append("Erro: ClienteController apagar " + e.getMessage());
			}
		}
		
		if(request.getParameter("action").equals("alterar")) {
			Cliente  cliente = new Cliente();
			
			cliente.setCpf(request.getParameter("cpf"));
			
			try {
				Cliente consulta = new ClienteConsultar().consultar(cliente);

				request.setAttribute("consulta", consulta);
				
				RequestDispatcher view = request.getRequestDispatcher("AlterarCliente.jsp");
				view.forward(request, response);
			} catch (Exception e) {
				response.getWriter().append("Erro: ClienteController alterar " + e.getMessage());
			}
		}
		
		if(request.getParameter("action").equals("atualizar")) {
			Cliente cliente = new Cliente();
			
			cliente.setId(Integer.parseInt(request.getParameter("id")));
			cliente.setCpf(request.getParameter("cpf"));
			cliente.setNome(request.getParameter("nome"));
			cliente.setEmail(request.getParameter("email"));
			
			try {
				cliente.setDataNascimento(sdf.parse(request.getParameter("dataNascimento")));
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			cliente.setSexo(request.getParameter("sexo"));
			cliente.setNomeSocial(request.getParameter("social"));
			cliente.setApelido(request.getParameter("apelido"));
			cliente.setTelefone(request.getParameter("telefone"));
			
			try {
				Cliente atualiza = new ClienteAlterar().atualizar(cliente);
				
				request.setAttribute("consulta", atualiza);
				
				RequestDispatcher view = request.getRequestDispatcher("ConsultarCliente.jsp");
				view.forward(request, response);
			} catch (Exception e) {
				response.getWriter().append("Erro: ClienteController atualizar " + e.getMessage());
			}
		}
		
	}
}
