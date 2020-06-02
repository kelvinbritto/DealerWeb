<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Mesa - Dealer Web</title>
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
<body>
	<main>
		<h2 class="titulo">Web Dealer</h2>
		<h3 class="sub-titulo">Mesa</h3>
		<table class="tabela-resultado">
			<tr>
				<c:forEach items="${cartasComunitarias}" var="cards">

					<td class="carta-resultado">
						<p class="carta">${cards.nome}</p>
					</td>
				</c:forEach>
			</tr>

		</table>


		<form action="/mesa/flop" class="form2">
			<input type="submit" value="Flop" class="botao-flop" />
		</form>

		<form action="/mesa/turn" class="form2">
			<input type="submit" value="Turn" class="botao-turn"/>
		</form>

		<form action="/mesa/river" class="form2">
			<input type="submit" value="River" class="botao-river" />
		</form>

		<form action="/mesa/resultado" class="resultado">
			<input type="submit" value="Resultado" class="botao-resultado" />
		</form>

	</main>
</body>
</html>