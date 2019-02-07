<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Čitanje podataka iz CSV datoteke</title>
	<link href="css/reset.css" rel="stylesheet"/>
	<link href="css/style.css" rel="stylesheet"/>
</head>
<body>
<div class="wrapper">

	<header class="header">
		<h1>Podaci CSV</h1>
	</header>

	<main class="main">
		<table>
			<tr class="trHead">
				<td class="tdHead">Ime</td>
				<td class="tdHead">Prezime</td>
				<td class="tdHead">Poštanski broj</td>
				<td class="tdHead">Grad</td>
				<td class="tdHead">Telefon</td>
			</tr>
	
	
		</table>

		<form class="form" action="/Button" method="post">
			<button class="button" type="submit" name="ucitaj">Učitaj</button>
			<button class="button" type="submit" name="spremi">Spremi</button>
		</form>
		<div class="error">
		<p>${poruka}</p>
		</div>
	</main>
	
	<footer class="footer">
		<p>Web aplikacija za natječaj</p>
	</footer>
	</div>
</body>
</html>