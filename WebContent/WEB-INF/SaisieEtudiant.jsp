<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Saisie Etudiant</title>
<link type="text/css" rel="stylesheet" href="accueil.css" />
</head>

<body>

	<header>

	<div id="topBar">
		<div id="headerLinks"
			style="position: absolute; top: 0; right: 10px; float: right;">
			<%String s = ( (String) session.getAttribute("Admin"));%>
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
			<form method="get" action="/plateformeGroupe/Deconnexion">
				<input type="submit" value="Se deconnecter"/>
			</form>
			<%
				}
			%>

		</div>
	</div>



	<li><form method="get" action="/plateformeGroupe/Accueil">
			<input type="submit" value="Accueil">
		</form></li>
	


	<%s = ( (String) session.getAttribute("Admin"));%>
	<%if( (s==null)?false:s.equals("Oui") ){%>
	<li><form method="get" action="/plateformeGroupe/GestionGroupe">
			<input type="submit" value="Gestion des groupes">
		</form></li>
	

	<% }  
	
	s = ( (String) session.getAttribute("Admin"));	
	if( (s==null)?false:s.equals("Oui") ){%>
	<li><form method="get" action="/plateformeGroupe/SaisieEtudiant">
			<input type="submit" value="Saisie Etudiant">
		</form></li>
	
	<% } %>

	<%s = ( (String) session.getAttribute("Admin"));
	String lie = (String) session.getAttribute("Lie");
	if( (s==null)?false:s.equals("Non") && ((lie==null)?true:lie.equals("Non"))){%>
	<li><form method="get" action="/plateformeGroupe/LierCompte">
			<input type="submit" value="Lier le compte">
		</form></li>
	
	<% } %> 

	<li><form method="get" action="/plateformeGroupe/Listeretu">
			<input type="submit" value="Lister Etudiant">
		</form></li>
	
	
	<li><form method="get" action="/plateformeGroupe/Listergrp">
			<input type="submit" value="Lister Groupe">
		</form></li>
	

	<% s = ( (String) session.getAttribute("Admin"));
	if( (s==null)?false:s.equals("Non") ){%>
	<li><form method="get" action="/plateformeGroupe/Newprojet">
			<input type="submit" value="Nouveau Projet">
		</form></li>
	
	<% } %> 
	
	<% s = ( (String) session.getAttribute("Admin"));
	if( (s==null)?false:s.equals("Non") ){%>
	<li><form method="get" action="/plateformeGroupe/JoinProjet">
			<input type="submit" value="Rejoindre un groupe">
		</form></li>
	
	<% } %> 
	
	</header>
<%s = ( (String) session.getAttribute("Admin"));%>
<% if( (s==null)?false:s.equals("Oui") ){%>
<form action= "SaisieEtudiant" method="post">
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