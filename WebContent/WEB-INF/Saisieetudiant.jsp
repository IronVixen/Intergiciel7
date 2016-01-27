<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Saisie Etudiant</title>
</head>
<body>


	<header>

	<div id="topBar">
		<div id="headerLinks"
			style="position: absolute; top: 0; right: 10px; float: right;">

			<%
				if (request.getAttribute("Utilisateur") == null) {
			%>
			<form method="get" action="/plateformeGroupe/Connexion">
				<input type="submit" value="Se Connecter">
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


	<% if( ( (String) request.getAttribute("Admin")).equals("Oui")){%>
	<li><form method="get" action="/plateformeGroupe/Projet">
			<input type="submit" value="Projet">
		</form></li>
	<br />

	<% } %> 
	
	<% if( ( (String) request.getAttribute("Admin")).equals("Oui")){%>
	<li><form method="get" action="/plateformeGroupe/SaisieEtudiant">
			<input type="submit" value="Saisie Etudiant">
		</form></li>
	<br />
	<% } %>


	<li><form method="get" action="/plateformeGroupe/Lister">
			<input type="submit" value="Lister">
		</form></li>
	<br />

	<% if( ( (String) request.getAttribute("Admin")).equals("Oui")){%>
	<li><form method="get" action="/plateformeGroupe/Newprojet">
			<input type="submit" value="Nouveau Projet">
		</form></li>
	<br />
	<% } %> 
	
	<% if( ( (String) request.getAttribute("Admin")).equals("Non")){%>
	<li><form method="get" action="/plateformeGroupe/Gestiongroupe">
			<input type="submit" value="Gestion Groupe">
		</form></li>
	<br />
	<% } %> 
	
	<li><form method="get" action="/plateformeGroupe/Demandes">
			<input type="submit" value="Demandes">
		</form></li>
	<br />
	
	</header>

<form action= "accueil" method="post">
Nom+Prenom+GTD</br>
<textarea rows="5" cols="50" name="letudiant"></textarea></br>
<input type="submit" value="OK">
<input type="hidden" name="op" value="se">
<p>
</br>${letudiantbis[0]}
</br>${letudiantbis[1]}
</br>${letudiantbis[2]}
</br>${paramletudiant}
</p>
</form>
</body>
</html>