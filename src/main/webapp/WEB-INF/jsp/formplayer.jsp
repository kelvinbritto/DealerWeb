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
		<h2 class="titulo">Selecione Suas Cartas</h2>
		<h3 style="color: white;">${operacao}</h3>
		<form method="POST" action="/mesa/grava">
			<table>
				<tr>
					<td>
						<div>
							<label>Seu Nome</label> <input type="text" name="nome"
								class="input-nome" required="required" />
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<p>Primeira Carta:</p> <select name="carta1" class="input-padrao">
							<option value="null">Sua Primeira Carta</option>
							<c:forEach items="${cartasBaralho}" var="carta">
								<option value="${carta.id}">${carta.nome}</option>
							</c:forEach>
					</select>
					</td>
				</tr>
				<tr>
					<td>
						<p>Segunda Carta:</p> <select name="carta2" class="input-padrao">
							<option value="null">Sua Segunda Carta</option>
							<c:forEach items="${cartasBaralho}" var="carta">
								<option value="${carta.id}">${carta.nome}</option>
							</c:forEach>
					</select>
					</td>

				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Pronto!"
						class="enviar" /></td>
				</tr>
			</table>
		</form>
		<div class="jogador-tabela">
			<table>
				<thead>
					<tr>
						<th style="padding: 6px 0;">Jogadores</th>
					</tr>
				</thead>

				<c:forEach items="${jogadores}" var="player">
					<tr>
						<td style="text-transform: uppercase; padding: 3px 0;">${player.nome}</td>
					</tr>
				</c:forEach>
			</table>
		</div>

		<form action="/mesa/">
			<input type="submit" value="Começar o Jogo Automatico" class="enviar" />
		</form>

		<form action="/mesa/formcomunitarias">
			<input type="submit" value="Selecionar Comunitarias" class="enviar" />
		</form>

	</main>
</body>
</html>