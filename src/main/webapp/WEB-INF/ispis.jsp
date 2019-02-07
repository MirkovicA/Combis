<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Čitanje podataka iz CSV datoteke</title>
	<link href="css/reset.css" rel="stylesheet"/>
	<link href="css/style.css" rel="stylesheet"/>

</head>

<body>
	
	<header class="header">
		<h1>Podaci CSV</h1>
	</header>

	<main class="main">
		<table>
			<tr class="trHead">
				<td>Ime</td>
				<td>Prezime</td>
				<td>Poštanski broj</td>
				<td>Grad</td>
				<td>Telefon</td>
			</tr>

			<c:forEach items="${stockData}" var = "pbr">
				<c:if test="${pbr.postanskiBroj.length() > 5 || pbr.postanskiBroj.length() < 5}">
					<tr class="marked">
						<td class="tdBody"><c:out value="${pbr.ime}"></c:out></td>
						<td class="tdBody"><c:out value="${pbr.prezime}"></c:out></td>
						<td class="tdBody"><c:out value="${pbr.postanskiBroj}"></c:out></td>
						<td class="tdBody"><c:out value="${pbr.grad}"></c:out></td>
						<td class="tdBody"><c:out value="${pbr.telefon}"></c:out></td>
					</tr>
				</c:if>
				<c:if test="${pbr.postanskiBroj.length() == 5}">
					<tr class="trBodyCorrect">
						<td class="tdBody"><c:out value="${pbr.ime}"></c:out></td>
						<td class="tdBody"><c:out value="${pbr.prezime}"></c:out></td>
						<td class="tdBody"><c:out value="${pbr.postanskiBroj}"></c:out></td>
						<td class="tdBody"><c:out value="${pbr.grad}"></c:out></td>
						<td class="tdBody"><c:out value="${pbr.telefon}"></c:out></td>
					</tr>
				</c:if>
			</c:forEach>

	
		</table>

		<form class="form" action="/ButtonUpis" method="post">
			<button class="button" type="submit" name="ucitaj">Učitaj</button>
			<button class="button" type="submit" name="spremi">Spremi</button>
		</form>
	</main>
	
<footer class="footer">
		<p>Web aplikacija za natječaj</p>
	</footer>
</body>
</html>