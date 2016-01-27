<%@page import="java.util.Collection"%>
<%@page import="entities.Etudiant;"%>
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

<%s = ( (String) session.getAttribute("Admin"));%>
	<%if( (s==null)?false:s.equals("Oui") ){%>
	<li><form method="get" action="/plateformeGroupe/Projet">
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
<%s = ( (String) session.getAttribute("Admin"));%>
<%if( (s==null)?false:s.equals("Non") ){%>
	<form method="get" action="Controller">
	<%
	for (Etudiant Etu : (Collection<Etudiant>)  request.getAttribute("listetu")) {
	%>
	  <input type='radio' name='idp' value='<%= Etu.getId()%>'/><%= Etu.getNom()%> <%= Etu.getPrenom()%>
	  <br/>
	<% } %>
	
	<input type="hidden" name="op" value="associer"/>
	<input type="submit" value="OK"/>
	</form>
<% } %>	

</body>
</html>