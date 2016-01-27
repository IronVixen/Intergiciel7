<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Saisie Etudiant</title>
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



	<%if( (s==null)?false:s.equals("Oui") ){%>
	<li><form method="get" action="/plateformeGroupe/GestProjet">
			<input type="submit" value="Projet">
		</form></li>
	<br />

	<% } %> 
	
	<% 
	if( (s==null)?false:s.equals("Oui") ){%>
	<li><form method="get" action="/plateformeGroupe/SaisieEtudiant">
			<input type="submit" value="Saisie Etudiant">
		</form></li>
	<br />
	<% } %>


	<li><form method="get" action="/plateformeGroupe/Listeretu">
			<input type="submit" value="Lister Etudiant">
		</form></li>
	<br />

	<% 
	if( (s==null)?false:s.equals("Oui") ){%>
	<li><form method="get" action="/plateformeGroupe/Newprojet">
			<input type="submit" value="Nouveau Projet">
		</form></li>
	<br />
	<% } %> 
	
	<% s = ( (String) request.getAttribute("Admin"));
	if( (s==null)?false:s.equals("Non") ){%>
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

<% if( (s==null)?false:s.equals("Oui") ){%>
<form action= "accueil" method="post">
Nom+Prenom+GTD</br>
<textarea rows="5" cols="50" name="letudiant"></textarea></br>
<input type="submit" value="OK">
<input type="hidden" name="op" value="se">
<p>
</br>
<% } %> 

</form>
</body>
</html>