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
			<h2 class="center">Lista de Clientes</h2>
			<div id="divForm">
				<form action="ClienteController" method="POST">
					<input type="hidden" name="action" value="listar"/>
					<button type="submit" class="waves-effect waves-light btn">Listar</button>
					<input type="button" class="waves-effect waves-light btn orange" onclick="window.location='index.html';" value="Voltar" />
				</form>
			</div>
		</div>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</body>
</html>