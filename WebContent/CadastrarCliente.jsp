<%@page import="aula.utilitarios.GerenciadorConexao"%>
<%@page import="aula.utilitarios.GerenciadorConexaoMySQL"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css"> 
		<link rel="stylesheet" href="style.css"> 
		<title>Cadastrar Cliente</title>
	</head>
	<body>
		<div class="container">
			<h2 class="center">Cadastro de Clientes</h2>
			<div id="divForm">
				<form action="ClienteController" method="POST">
					<div class="input-field">
						<input type="text" id="cpf" name="cpf" />
						<label for="cpf">CPF*:</label>
					</div>
					<div class="input-field">
						<input type="text" id="nome" name="nome"  />
						<label for="nome">NOME*:</label>
					</div>
					<div class="input-field">
						<input type="email" id="email" name="email"  />
						<label for="email">E-MAIL*:</label>
					</div>
					<div class="input-field">
						<input type="date" id="date" name="dataNascimento"  required="required" />
						<label for="date">Data de Nascimento*:</label>
					</div>  
					<div class="input-field">
						<input type="text" id="sexo" name="sexo" />
						<label for="sexo">SEXO:</label>
					</div>
					<div class="input-field">
						<input type="text" id="social" name="social" />
						<label for="social">NOME SOCIAL:</label>
					</div>
					<div class="input-field">
						<input type="text" id="apelido" name="apelido" />
						<label for="apelido">APELIDO:</label>
					</div>
					<div class="input-field">
					<input type="text" id="fone" name="telefone" />
					<label for="fone">TELEFONE:</label>
					</div> <br />
					<div class="center">
						<input type="hidden" name="action" value="salvar"/>
						<button type="submit" class="waves-effect waves-light btn">Enviar</button>
						<button type="reset" class="waves-effect waves-light btn red">Limpar</button>
						<input type="button" class="waves-effect waves-light btn orange" onclick="window.location='index.html';" value="Voltar" />
					</div>
				</form>
			</div>
		</div>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
	</body>
</html>