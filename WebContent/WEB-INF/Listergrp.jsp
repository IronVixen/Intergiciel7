<%@page import="java.util.Collection"%>
<%@page import="entities.Etudiant"%>
<%@page import="entities.Projet;"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="accueil.css" />
<title>Liste des Groupes</title>
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
	<li><form method="get" action="/plateformeGroupe/GestionGroupe">
			<input type="submit" value="Gestion des groupes">
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

	<% s = ( (String) session.getAttribute("Admin"));
	if( (s==null)?false:s.equals("Non") ){%>
	<li><form method="get" action="/plateformeGroupe/Newprojet">
			<input type="submit" value="Nouveau Projet">
		</form></li>
	<br />
	<% } %> 
	
	<% s = ( (String) session.getAttribute("Admin"));
	if( (s==null)?false:s.equals("Non") ){%>
	<li><form method="get" action="/plateformeGroupe/JoinProjet">
			<input type="submit" value="Rejoindre un groupe">
		</form></li>
	<br />
	<% } %> 
	
	</header>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


Liste des groupes :
<% 
for(Projet Proj : (Collection<Projet>)  request.getAttribute("listproj")) {
%>
<p>
	Nom du groupe : <%= Proj.getNom()%>
	<br>
	<% 
	for(Etudiant Etu : (Collection<Etudiant>)  Proj.getEtudiants()) {
	%>
			Nom : <%= Etu.getNom()%>
			<br>
			Prénom : <%=Etu.getPrenom()%>
			<br>
			Groupe de TD : <%=Etu.getGtd() %>
			<br>
			<br>
	<%
	}
	%>
</p>
<%
}
%>
</body>
</html>