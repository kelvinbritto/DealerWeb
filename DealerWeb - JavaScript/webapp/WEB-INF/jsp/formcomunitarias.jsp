<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Escolha Suas Cartas - Dealer Web</title>
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
		<h1 class="title">Seleciona Comunitárias</h1>
		<form method="POST" action="/mesa/gravarcomunitarias">
			<p>Primeira Carta:</p>
			<select name="carta1" class="input-comunitaria">
				<option value="null">Primeira Carta</option>
				<c:forEach items="${cartasBaralho}" var="carta">
					<option value="${carta.id}">${carta.nome}</option>
				</c:forEach>
			</select>

			<p>Segunda Carta:</p>
			<select name="carta2" class="input-comunitaria">
				<option value="null">Segunda Carta</option>
				<c:forEach items="${cartasBaralho}" var="carta">
					<option value="${carta.id}">${carta.nome}</option>
				</c:forEach>
			</select>

			<p>Terceira Carta:</p>
			<select name="carta3" class="input-comunitaria">
				<option value="null">Terceira Carta</option>
				<c:forEach items="${cartasBaralho}" var="carta">
					<option value="${carta.id}">${carta.nome}</option>
				</c:forEach>
			</select>

			<p>Quarta Carta:</p>
			<select name="carta4" class="input-comunitaria">
				<option value="null">Quarta Carta</option>
				<c:forEach items="${cartasBaralho}" var="carta">
					<option value="${carta.id}">${carta.nome}</option>
				</c:forEach>
			</select>

			<p>Quinta Carta:</p>
			<select name="carta5" class="input-comunitaria">
				<option value="null">Quinta Carta</option>
				<c:forEach items="${cartasBaralho}" var="carta">
					<option value="${carta.id}">${carta.nome}</option>
				</c:forEach>
			</select> <input type="submit" value="Pronto!" class="enviar" />
		</form>
	</main>
</body>
</html>