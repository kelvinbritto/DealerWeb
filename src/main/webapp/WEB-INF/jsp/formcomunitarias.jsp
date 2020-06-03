<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Escolha Suas Cartas - Dealer Web</title>
</head>
<body>

	<form method="POST" action="/mesa/gravarcomunitarias">
		<p>Primeira Carta:</p>
		<select name="carta1" class="input-padrao">
			<option value="null">Primeira Carta</option>
			<c:forEach items="${cartasBaralho}" var="carta">
				<option value="${carta.id}">${carta.nome}</option>
			</c:forEach>
		</select>

		<p>Segunda Carta:</p>
		<select name="carta2" class="input-padrao">
			<option value="null">Segunda Carta</option>
			<c:forEach items="${cartasBaralho}" var="carta">
				<option value="${carta.id}">${carta.nome}</option>
			</c:forEach>
		</select>

		<p>Terceira Carta:</p>
		<select name="carta3" class="input-padrao">
			<option value="null">Terceira Carta</option>
			<c:forEach items="${cartasBaralho}" var="carta">
				<option value="${carta.id}">${carta.nome}</option>
			</c:forEach>
		</select>

		<p>Quarta Carta:</p>
		<select name="carta4" class="input-padrao">
			<option value="null">Quarta Carta</option>
			<c:forEach items="${cartasBaralho}" var="carta">
				<option value="${carta.id}">${carta.nome}</option>
			</c:forEach>
		</select>

		<p>Quinta Carta:</p>
		<select name="carta5" class="input-padrao">
			<option value="null">Quinta Carta</option>
			<c:forEach items="${cartasBaralho}" var="carta">
				<option value="${carta.id}">${carta.nome}</option>
			</c:forEach>
		</select> 
		<input type="submit" value="Pronto!" class="enviar" />
	</form>

</body>
</html>