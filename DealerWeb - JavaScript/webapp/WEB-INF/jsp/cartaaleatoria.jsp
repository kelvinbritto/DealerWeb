<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Dealer WEB</title>
</head>
<body>

	<h1>Carta Aleatoria</h1>
	
	<h2>${cartaAleatoria}</h2>
	

	<table>

		<tr>
			<td>
				<form action="/baralho/cartaaleatoria">
					<input type="submit" value="Carta Aleatória" />
				</form>
			</td>

			<td>
				<form action="/baralho/reseta">
					<input type="submit" value="Resetar Baralho" />
				</form>
			</td>
		</tr>
	</table>

<h5>${quantidadeCartas}</h5>

</body>
</html>