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
		<title>Apagar Cliente</title>
	</head>
	<body>
		<div class="container">
			<h2 class="center">Exclusão de Clientes</h2>
			<div id="divForm">
				<h5 class="center">Cliente Excluído com Sucesso!</h5> <br />
				<input type="button" class="waves-effect waves-light btn blue" onclick="window.location='Lista.jsp';" value="Listar" />
				<input type="button" class="waves-effect waves-light btn orange" onclick="window.location='index.html';" value="Voltar" />
			</div>
		</div>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</body>
</html>