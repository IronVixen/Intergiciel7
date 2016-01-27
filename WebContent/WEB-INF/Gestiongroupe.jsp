<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gestion des groupes</title>
</head>
<body>

<div id="topBar">
	<div id="headerLinks" style="position: absolute; top: 0; right: 10px; float: right;" >
		
			<% if(request.getAttribute("Utilisateur")==null){%>
			<form method="get" action = "/plateforme_groupe/Connexion">
				<input type = "submit" value="Se Connecter">
			</form>
			<% } else { %>
			<form method="get" action = "/plateforme_groupe/Connexion">
				<input type = "submit" value="Se deconnecter">
			</form>
			<% } %>
			
	</div>
</div>

<form action= "gestion" method="post">
	<input type="submit" name="op" value="Former Groupe"> 
	<input type="submit" name="op" value="Modifier Groupe"> 
	<input type="submit" name="op" value="Annuler Groupe"> 
</form>

</body>
</html>