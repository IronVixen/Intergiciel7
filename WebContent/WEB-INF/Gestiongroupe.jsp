<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gestion des groupes</title>
</head>
	 <%String s = ( (String) session.getAttribute("Admin"));%>
<body>

	<header>

	<div id="topBar">
		<div id="headerLinks"
			style="position: absolute; top: 0; right: 10px; float: right;">

			<%if( (s==null)?true:s.equals("Deco") ){%>
			<form method="get" action="/plateformeGroupe/Connexion">
				<input type="submit" value="Se Connecter">
			</form>
			<form method="get" action="/plateformeGroupe/Inscription">
				<input type="submit" value="S'inscrire">
			</form>
			<%
				} else {
			%>
			<form method="get" action="/plateformeGroupe/Connexion">
				<input type="submit" value="Se deconnecter">
				<input type = "hidden" name="CheckDeco" value="deconnexion">
			</form>
			<%
				}
			%>

		</div>
	</div>

	<li><form method="get" action="/plateformeGroupe/Accueil">
			<input type="submit" value="Accueil">
		</form></li>
	<br />

	<li><form method="get" action="/plateformeGroupe/Listeretu">
			<input type="submit" value="Lister Etudiant">
		</form></li>
	<br />
	
	<li><form method="get" action="/plateformeGroupe/Demandes">
			<input type="submit" value="Demandes">
		</form></li>
	<br />
	
	</header>

<form action= "gestion" method="post">
	<input type="submit" name="op" value="Former Groupe"> 
	<input type="submit" name="op" value="Modifier Groupe"> 
	<input type="submit" name="op" value="Quitter Groupe"> 
</form>

</body>
</html>