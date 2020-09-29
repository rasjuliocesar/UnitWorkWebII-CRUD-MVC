<%@page import="aula.entidade.Cliente"%>
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
		<title>Alterar Cliente</title>
	</head>
	<body>
	<%
	Cliente consulta = (Cliente) request.getAttribute("consulta");
	%>
		<div class="container">
			<h2 class="center">Atualização de Clientes</h2>
			<div id="divForm">
			<form action="ClienteController" method="POST">
					<div class="input-field">
						<input type="hidden" name="id" value="<% out.print(consulta.getId()); %>"/>
					</div>
					<div class="input-field">
						<input type="text" id="cpf" name="cpf" value="<% out.print(consulta.getCpf()); %>" />
						<label for="cpf">CPF*:</label>
					</div>
					<div class="input-field">
						<input type="text" id="nome" name="nome" value="<% out.print(consulta.getNome()); %>" />
						<label for="nome">NOME*:</label>
					</div>
					<div class="input-field">
						<input type="email" id="email" name="email" value="<% out.print(consulta.getEmail()); %>" />
						<label for="email">E-MAIL*:</label>
					</div>
					<div class="input-field">
						<input type="date" id="date" name="dataNascimento" value="<% out.print(consulta.getDataNascimento()); %>" />
						<label for="date">Data de Nascimento*:</label>
					</div> 
					<div class="input-field">
						<input type="text" id="sexo" name="sexo" value="<% out.print(consulta.getSexo()); %>" />
						<label for="sexo">SEXO:</label>
					</div>
					<div class="input-field">
						<input type="text" id="social" name="social" value="<% out.print(consulta.getNomeSocial()); %>" />
						<label for="social">NOME SOCIAL:</label>
					</div>
					<div class="input-field">
						<input type="text" id="apelido" name="apelido" value="<% out.print(consulta.getApelido()); %>" />
						<label for="apelido">APELIDO:</label>
					</div>
					<div class="input-field">
					<input type="text" id="fone" name="telefone" value="<% out.print(consulta.getTelefone()); %>" />
					<label for="fone">TELEFONE:</label>
					</div> <br />
					<div class="center">
						<input type="hidden" name="action" value="atualizar"/>
						<button type="submit" class="waves-effect waves-light btn">Atualizar / Consultar</button>
						<input type="button" class="waves-effect waves-light btn orange" onclick="window.location='index.html';" value="Voltar" />
					</div>
				</form>
			</div>
		</div>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</body>
</html>