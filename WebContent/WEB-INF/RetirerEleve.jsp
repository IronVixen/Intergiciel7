<%@page import="java.util.Collection"%>
<%@page import="entities.Projet"%>
<%@page import="entities.Etudiant;"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Retirer Eleve</title>
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
	<br />


	<%s = ( (String) session.getAttribute("Admin"));%>
	<%if( (s==null)?false:s.equals("Oui") ){%>
	<li><form method="get" action="/plateformeGroupe/GestProjet">
			<input type="submit" value="Projet">
		</form></li>
	<br />

	<% }  
	
	s = ( (String) session.getAttribute("Admin"));	
	if( (s==null)?false:s.equals("Oui") ){%>
	<li><form method="get" action="/plateformeGroupe/SaisieEtudiant">
			<input type="submit" value="Saisie Etudiant">
		</form></li>
	<br />
	<% } %>

	<%s = ( (String) session.getAttribute("Admin"));
	String lie = (String) session.getAttribute("Lie");
	if( (s==null)?false:s.equals("Non") && ((lie==null)?true:lie.equals("Non"))){%>
	<li><form method="get" action="/plateformeGroupe/LierCompte">
			<input type="submit" value="Lier le compte">
		</form></li>
	<br />
	<% } %> 

	<li><form method="get" action="/plateformeGroupe/Listeretu">
			<input type="submit" value="Lister Etudiant">
		</form></li>
	<br />
	
	<li><form method="get" action="/plateformeGroupe/Listergrp">
			<input type="submit" value="Lister Groupe">
		</form></li>
	<br />

	<% 
	if( !(s==null) ){%>
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
	
<%s = ( (String) session.getAttribute("Admin"));%>
<%if( (s==null)?false:s.equals("Oui") ){%>
	<form method="get" action="RetirerEleve">
		<%
	for (Projet p : (Collection<Projet>)  request.getAttribute("listproj")) {
	%>
	  <%= p.getNom()%>
	  <br/>
		
		<%
		for (Etudiant Etu : (Collection<Etudiant>)  p.getEtudiants()) {
		%>
		  <input type='radio' name='ide' value='<%= Etu.getId()%>'/><%= Etu.getNom()%> <%= Etu.getPrenom()%>
		  <br/>
		<% } %>
	<% } %>
	<input type="hidden" name="op" value="dissocier"/>
	<input type="submit" value="Retirer"/>
	</form>
<% } %>	

</body>
</html>