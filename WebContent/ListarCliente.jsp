<%@page import="java.util.ArrayList" %>
<%@page import="aula.entidade.Cliente" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css"> 
		<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
		<link rel="stylesheet" href="style.css"> 
		<title>Listar Cliente</title>
	</head>
	<body>
		<div class="container">
			<h2 class="center">Lista de Clientes</h2>
			<div id="divForm">
				<table class="striped">
					<thead>
						<tr>
							<th>CPF</th>
							<th>Nome</th>
							<th>E-mail</th>
							<th>Data de Nascimento</th>
							<th>Sexo</th>
							<th>Nome Social</th>
							<th>Apelido</th>
							<th>Telefone</th>
							<!-- <th><i>alterar</i></th>
							<th><i>excluir</i></th> -->
						</tr>
					</thead>
					<tbody>
						<%
							ArrayList<Cliente> lista = (ArrayList<Cliente>)request.getAttribute("clientes");
							
							if(lista.size() > 0){
								for(int i = 0; i < lista.size(); i++){
								int id = lista.get(i).getId();
								out.print("<tr>");
								out.print("<td>" + lista.get(i).getCpf() + "</td>");
								out.print("<td>" + lista.get(i).getNome() + "</td>");
								out.print("<td>" + lista.get(i).getEmail() + "</td>");
								out.print("<td>" + lista.get(i).getDataNascimento()+ "</td>");
								out.print("<td>" + lista.get(i).getSexo() + "</td>");
								out.print("<td>" + lista.get(i).getNomeSocial() + "</td>");
								out.print("<td>" + lista.get(i).getApelido() + "</td>");
								out.print("<td>" + lista.get(i).getTelefone() + "</td>");
								//out.print("<td><i class='small material-icons'>refresh</i></td>");
								//out.print("<td><i class='small material-icons'>remove_circle</i></td>");
								out.print("</tr>");
								}
							} else {
								out.print("<tr>");
								for(int i = 0; i < 8; i++){
									out.print("<td>-</td>");	
								}
								out.print("</tr>");
							}
						%>
					</tbody>
				</table>
				<input type="button" class="waves-effect waves-light btn orange" onclick="window.location='index.html';" value="Voltar" />
			</div>
		</div>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
	</body>
</html>