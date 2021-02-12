<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Resultado - Dealer Web</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/reset.css'/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/style.css'/>" />
</head>

<body>
	<header>
		<div class="caixa">
			<img id="logo" class="logo" alt="cartas"
				src="<c:url value='/resources/imagens/logo1.png'/>">
		</div>
	</header>
	<main>

	<p>O </p>


		<h2 class="titulo">Web Dealer</h2>
		<table class="tabela-resultado">
			<tr>
				<c:forEach items="${cartasComunitarias}" var="cards">

					<td class="carta-resultado">
						<p class="carta">${cards.nome}</p>
					</td>
				</c:forEach>
			</tr>
		</table>

		<table class="tabelajogador">
			<c:forEach items="${players}" var="jogador">
				<tr class="jogador">
					<td style="display: block; text-transform: uppercase; font-size: 22px; padding: 11px 0px 0px ">${jogador.nome}</td>
					<td class="cardjogador">${jogador.carta1} </td>
					<td class="cardjogador">${jogador.carta2}</td>
					<td style="display: block; font-weight: bold; font-size: 25px;padding: 11px 0px 0px;
					color: orangered;">${jogador.resultado}</td>
				</tr>
			</c:forEach>
		</table>

		<form action="/mesa/resetajogo" class="novo-jogo-form">
			<input type="submit" value="Novo Jogo" class="novo-jogo" />
		</form>
	</main>

</body>
</html>